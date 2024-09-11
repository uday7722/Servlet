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

@WebServlet("/displayBikes")
public class DisplayBikes extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		String query="Select * from bike";
		String url="jdbc:mysql://localhost:3306/servlet_bikedb?user=root&password=root";

		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con=DriverManager.getConnection(url);
			PreparedStatement stmt=con.prepareStatement(query);
			ResultSet rs=stmt.executeQuery();

			req.setAttribute("display", rs);

			RequestDispatcher requestDispatcher=req.getRequestDispatcher("displaybikes.jsp");
			requestDispatcher.forward(req, resp);


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
