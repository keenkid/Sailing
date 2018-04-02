$(document).ready(
	function(){
		$("#txtUserName").focus();
		$("#btnQuery").click(function(){ checkQuery() })
	}
)

function constructData(){
	var username = $("#txtUserName").val();
	var password = $("#txtPassword").val();
	var json = {"username":username,"password":password};
	return json;
}

function checkQuery(){
	var sendData = constructData();

	$.ajax({
		async : false,
		url : "QueryServlet",
		data : sendData,
		dataType : "text",
		success : function(result){
			parseResult(result);
		}
	});
	//window.location.href="pages/information.jsp";
}

function parseResult(result){
	if("1" == result){
		$("#contentSpan").css("color","green");
		//$("#contentSpan").html("query success");
		window.location.href="pages/information.jsp";
	} else if("0" == result){
		$("#contentSpan").css("color","red");
		$("#contentSpan").html("query failure");
	}
}