package com.servlet.bikeproject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.Driver;

@WebServlet("/SaveUpdatedBikes")
public class SaveUpdatedBikes  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int bikeId=Integer.parseInt(req.getParameter("bikeId"));
		String bikeCompany=req.getParameter("bikeCompany");
		String bikeModel=req.getParameter("bikeModel");
		int bikePrice=Integer.parseInt(req.getParameter("bikePrice"));
		
		String query1="Update bike set bikeCompany=?,bikeModel=?,bikePrice=? where bikeId=?";
		String url="jdbc:mysql://localhost:3306/servlet_bikedb?user=root&password=root";
		String query2="Select * from bike";
		
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(url);
			PreparedStatement stmt1=con.prepareStatement(query1);
			stmt1.setString(1, bikeCompany);
			stmt1.setString(2, bikeModel);
			stmt1.setInt(3, bikePrice);
			stmt1.setInt(4, bikeId);
			
			stmt1.executeUpdate();
			
			PreparedStatement stmt2=con.prepareStatement(query2);
			ResultSet rs=stmt2.executeQuery();
			
			req.setAttribute("display", rs);
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("displaybikes.jsp");
			requestDispatcher.forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
