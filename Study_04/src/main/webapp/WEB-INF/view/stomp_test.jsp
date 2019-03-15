<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<Script src="http://code.jquery.com/jquery-3.2.1.min.js"></Script>
<Script src="https://cdn.jsdelivr.net/sockjs/1/sockjs.min.js"></Script>
<Script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.js"></Script>

<title>제목</title>
	
<script type="text/javascript">

	function connect(){
		var socket = new SockJS("/StompMessageTester"); 
		stompClient = Stomp.over(socket);
		stompClient.connect({}, function(frame) {
			var sub = $("#subdomain").val();
			stompClient.subscribe("/tester/"+sub, function(greeting) { 
				$("#chating").append(JSON.parse(greeting.body).msg+"<br/>");
			});
		});
	}
	
	function sendMessage(){
		var msg = $("#chat").val();
		var sub = $("#subdomain").val();
		stompClient.send("/chating/" + sub, {}, JSON.stringify({
			msg : msg
		}));
	}
</script>
	
</head>

<body>
	<div>
		<input type="text" value="" id="subdomain">
		<input onclick="connect()" type="button" value="연결a"> 
	</div>
	<div>
		<input type="text" id="chat">
		<input onclick="sendMessage()" type="button" value="전송">
	</div>
	
	<div id="chating"></div>
</body>
</html>