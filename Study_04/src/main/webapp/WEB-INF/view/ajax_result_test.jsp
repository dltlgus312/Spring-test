<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<Script src="http://code.jquery.com/jquery-3.2.1.min.js"></Script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>제목</title>

<script type="text/javascript">
	
function test(){
	
	var name = "이시현";
	var age = "27";
	var phone = "01023814118";
	
	$.ajax({
		type : "POST",
		url : "${pageContext.request.contextPath}/ajax_request.do",
		data : {
			name : name,
			age : age,
			phone : phone
		},
		success : function( data ){ 
			alert("성공입니다. >> " + data.result);
		},
		error : function( data ){
			alert("실패입니다.");
		},
	});
}
</script>
		
		
</head>
<body>
	<button onclick="test()"> ajax result 테스트 </button>
</body>
</html>