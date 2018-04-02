//$(document).ready(
//	function(){
//		$("#btnQuery").click(doQuery());
//	}
//)

function constructData(){
	var pageSize = $("#txtPageSize").val();
	var pageIndex = $("#lblPageIndex").html();
	var totalPages = $("#lblTotalPages").html();
	var json = {"pageSize":pageSize,"pageIndex":pageIndex,"totalPages":totalPages};
	
	return json;
}

function doQuery(){
	var sendData = constructData();
	
	$.ajax({
		async : true,
		url : "../InformationServlet",
		data : sendData,
		dataType : "json",
		success : function(result){
			parseResult(result);
		},
		error : function(result,status,msg){
			alert(msg);
		}
	})
}

function parseResult(result){
	var content = "";
	for(var i = 0; i < result.employee.length; i++){
		var emp = result.employee[i];
		content += "<tr><td>"+ emp.EmployeeID +"</td><td>"+ emp.NationalID +"</td><td>"+ emp.Salutation +"</td><td>"+ emp.Title +"</td><td>"+ emp.BirthDate +"</td></tr>";
	}
	$("#contentBody").html(content);
}