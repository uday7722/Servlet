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
<%
ResultSet rs=(ResultSet) request.getAttribute("update");
rs.next();
%>

<div style="width: 300px; margin:0 auto; background-color: black; padding: 20px; text-align: center">

<form action="SaveUpdatedBikes" method="get">

<input type="number" value="<%=rs.getInt(1)%>" name="bikeId" readonly="bikeId" style="text-align: center;"><br>
<input type="text" value="<%=rs.getString(2)%>" name="bikeCompany" style="text-align: center;"><br>
<input type="text" value="<%=rs.getString(3)%>" name="bikeModel" style="text-align: center;"><br>
<input type="number" value="<%=rs.getInt(4)%>" name="bikePrice" style="text-align: center;"><br>
<input type="submit" value="Update" >
</form>

</div>

</body>
</html>