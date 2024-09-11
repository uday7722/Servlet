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

@WebServlet("/DeleteBike")
public class DeleteBikes extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int bikeId=Integer.parseInt(req.getParameter("bikeId"));

		String query1="Delete from bike where bikeId=?";

		String url="jdbc:mysql://localhost:3306/servlet_bikedb?user=root&password=root";

		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url);

			PreparedStatement stmt=con.prepareStatement(query1);
			stmt.setInt(1, bikeId);
			stmt.executeUpdate();

			String query2="Select * from bike";

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
