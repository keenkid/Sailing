<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Start</title>
	<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
	<script type="text/javascript" src="js/basic.js"></script>
	<link rel="stylesheet" type="text/css" href="css/basic.css"/>
</head>
<body>
	<div>
		<div>
			<table>
				<tr>
					<td>User Name:</td>
					<td><input type="text" id="txtUserName"/></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" id="txtPassword"/></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:right;padding-right:18px"><input type="button" id="btnQuery" value="Query" /></td>
				</tr>
			</table>
		</div>
		<span id="contentSpan" style="width:200px"></span>
	</div>
</body>
</html>