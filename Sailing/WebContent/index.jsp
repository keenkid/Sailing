<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="utils.DbHelper,java.sql.*;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sailing Your Dream</title>
<script type="text/javascript" src="basic.js"></script>
<link rel="stylesheet" type="text/css" href="basic.css" />
</head>
<body>
<form action="/EmployeeServlet" method="post">
	<input type="submit" id="btnNormal" value="Click"/>
	<p></p>
	<table>
		<tr>
			<th>Employee ID</th>
			<th>National ID Number</th>
			<th>Title</th>
			<th>Birthday</th>
		</tr>
		<%
			int i = 0;
			while(i < 10){
		%>
		<tr>
			<td><%=i+1 %></td>
			<td><%=i+2 %></td>
			<td><%=i+3 %></td>
			<td><%=i+4 %></td>
		</tr>
		<%
				i++;
			}
		%>
	</table>
</form>
</body>
</html>