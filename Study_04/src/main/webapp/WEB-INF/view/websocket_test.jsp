<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<Script src="http://code.jquery.com/jquery-3.2.1.min.js"></Script>
<Script src="https://cdn.jsdelivr.net/sockjs/1/sockjs.min.js"></Script>
	<script type="text/javascript">
		var sock = null;	
		$(document).ready(function(){
			sock = new SockJS("/websocket_test");
			sock.onopen = function(){ sock.send("안녕하세요"); }
			sock.onmessage = function(msg){ $("#container").append(msg.data + "<br/>") }
			sock.onclose = function(){ sock.send("종료"); }
			$("#send").click(function(){ sock.send($("#message").val()); })
		})
	</script>
<title>제목</title>
</head>
<body>
	<input type="text" id="message" />	
	<input type="button" id="send" />
	<div id="container"></div>
</body>
</html>