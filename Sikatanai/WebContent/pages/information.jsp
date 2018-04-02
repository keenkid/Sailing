<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.utils.DbHelper,java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Information</title>
		<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
		<script type="text/javascript" src="js/query.js"></script>
		<link rel="stylesheet" type="text/css" href="css/basic.css"/>
	</head>
	<body>
		<input type="button" id="btnQuery" value="Query" onclick="doQuery()" />
		<p/>
		<table>
			<thead>
				<tr>
					<th>Employee ID</th>
					<th>National ID Number</th>
					<th>Salutation</th>
					<th>Title</th>
					<th>Birthday</th>
				</tr>
			</thead>
			<tbody id="contentBody">
			</tbody>
			<tfoot>
				<tr>
					<td class="tdfooter"><a>&lt;&lt; previous</a></td>
					<td colspan="3" class="tdfooter">
					Page Size  <input type="text" id="txtPageSize" value="10" />
					Page Index  <label id="lblPageIndex">1</label>
					Total Pages <label id="lblTotalPages">1</label>
					</td>
					<td class="tdfooter"><a>next &gt;&gt;</a></td>
				</tr>
			</tfoot>
		</table>
	</body>
</html>