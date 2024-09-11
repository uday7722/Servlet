<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div style="width: 300px; margin:0 auto; background-color: black; padding: 20px; text-align: center">
<!--style="width: 300px; margin: 0 auto; background-color: #f0f0f0; padding: 20px;  -->

<form action="addBikes" method="post">
<input type="number" placeholder="Enter bike Id" name="bikeId"><br>
<input type="text" placeholder="Enter bike Company" name="bikeCompany"><br>
<input type="text" placeholder="Enter bike Model" name="bikeModel"><br>
<input type="number" placeholder="Enter bike Price" name="bikePrice"><br>
<input type="submit" value="Add">
</form>
</div>

</body>
</html>