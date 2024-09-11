package com.servlet.bikeproject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addBikes")
public class AddBikes extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int bikeId=Integer.parseInt(req.getParameter("bikeId"));
		String bikeCompany=req.getParameter("bikeCompany");
		String bikeModel=req.getParameter("bikeModel");
		int bikePrice=Integer.parseInt(req.getParameter("bikePrice"));
		
		String query="Insert into bike values(?,?,?,?)";
		String url="jdbc:mysql://localhost:3306/servlet_bikedb?user=root&password=root";
		
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url);
			PreparedStatement stmt=con.prepareStatement(query);
			stmt.setInt(1, bikeId);
			stmt.setString(2, bikeCompany);
			stmt.setString(3, bikeModel);
			stmt.setInt(4, bikePrice);
			
			stmt.executeUpdate();
			
			resp.sendRedirect("index.jsp");
						
		} catch (Exception e) {
			e.printStackTrace();
		}	
		finally {
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
