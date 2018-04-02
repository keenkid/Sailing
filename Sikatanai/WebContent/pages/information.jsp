<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.utils.DbHelper,java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Information</title>
		<script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
		<script type="text/javascript" src="../js/query.js"></script>
		<link rel="stylesheet" type="text/css" href="../css/basic.css"/>
	</head>
	<body>
		<div id="divContent">
			<input type="button" id="btnQuery" value="Query" onclick="doQuery(this)" />
			<p/>
			<p id="msgParam" style="color:red;font-weight:bold;"/>
			<table id="contentTable">
				<thead>
					<tr>
						<th>Employee ID</th>
						<th class="widetd" style="width:200px">National ID Number</th>
						<th class="widetd" style="width:200px">Salutation</th>
						<th class="widetd" style="width:360px">Title</th>
						<th>Birthday</th>
					</tr>
				</thead>
				<tbody id="contentBody">
				</tbody>
				<tfoot>
					<tr>
						<td class="tdfooter"><a id="preLink" onclick="doQuery(this)">&lt;&lt; Previous</a></td>
						<td colspan="3" class="tdfooter">
						Page Size  <input type="text" style="width:40px; text-align:center" id="txtPageSize" value="10" />&nbsp;&nbsp;&nbsp;&nbsp;
						Page Index:  <label id="lblPageIndex">0</label>&nbsp;&nbsp;&nbsp;&nbsp;
						Total Pages: <label id="lblTotalPages">0</label>
						</td>
						<td class="tdfooter"><a id="nextLink" onclick="doQuery(this)">Next &gt;&gt;</a></td>
					</tr>
				</tfoot>
			</table>
		</div>
	</body>
</html>