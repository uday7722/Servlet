<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div
		style="width: 700px; margin: 1 auto; background-color: black; padding: 20px; text-align: center">
		<!--  style="width: 300px; margin:0 auto; background-color: black; padding: 20px"-->

		<table style="border-collapse: collapse; width: 60%;" border="1"
			align="center">

			<%
			ResultSet rs = (ResultSet) request.getAttribute("display");
			%>

			<tr style="background-color: yellow;">
				<th>BikeId</th>
				<th>Bike Company</th>
				<th>Bike Model</th>
				<th>BikePrice</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>

			<%
			while (rs.next()) {
			%>

			<tr style="background-color: beige;">
				<td><%=rs.getInt(1)%></td>
				<td><%=rs.getString(2)%></td>
				<td><%=rs.getString(3)%></td>
				<td><%=rs.getInt(4)%></td>
				<td><a href="UpdateBike?bikeId=<%=rs.getInt(1)%>"
					style="color: green;">Update</a></td>
				<td><a href="DeleteBike?bikeId=<%=rs.getInt(1)%>"
					style="color: red">Delete</a></td>
			</tr>
			<%
			}
			%>
		</table>
		<h2 align="center">
			<a href="index.jsp" style="color: beige;">Go Back to Dashboard!!</a>
		</h2>

	</div>

</body>
</html>