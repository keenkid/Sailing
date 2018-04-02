$(document).ready(
	function(){
		//$("#btnQuery").click(doQuery());
		//$("#nextLink").click(doQuery());
	}
)

function doQuery(sender){
	if(!doCheck(sender.id)){
		return false;
	}	
	
	var sendData = constructData(sender.id);
	
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

function doCheck(senderID){
	var pageIndex = parseInt($("#lblPageIndex").html());
	var totalPage = parseInt($("#lblTotalPages").html());
	
	if(pageIndex == totalPage && (pageIndex == 1 || pageIndex == 0)){
		if(senderID == "preLink" || senderID == "nextLink"){
			showHint("There is no data.");
			return false;
		}
	}
	
	if(pageIndex == 1 && senderID == "preLink"){
		showHint("It's already the first page.");
		return false;
	}
	
	if(pageIndex == totalPage && pageIndex != 0 && senderID == "nextLink"){
		showHint("It's already the last page.");
		return false;
	}
	
	return true;
}

function showHint(message){
	$("#msgParam").css("display","block");
	$("#msgParam").html(message);
	setTimeout(function(){$("#msgParam").css("display","none")},3000);
}

function constructData(senderID){
	var pageSize = $("#txtPageSize").val();
	var pageIndex = parseInt($("#lblPageIndex").html());
	
	if(senderID == "btnQuery"){
		pageIndex = 1;
	}
	if(senderID == "nextLink"){
		pageIndex += 1;
	}
	if(senderID == "preLink"){
		pageIndex -= 1;
	}
	$("#lblPageIndex").html(pageIndex);
	var json = {"pageSize":pageSize,"pageIndex":pageIndex};
	
	return json;
}

function parseResult(result){
	var content = "";
	for(var i = 0; i < result.employee.length; i++){
		var emp = result.employee[i];
		content += "<tr><td>"+ emp.EmployeeID +"</td><td>"+ emp.NationalID +"</td><td>"+ emp.Salutation +"</td><td>"+ emp.Title +"</td><td>"+ emp.BirthDate +"</td></tr>";
	}
	$("#contentBody").html(content);
	$("#lblTotalPages").html(result.pages);	
}