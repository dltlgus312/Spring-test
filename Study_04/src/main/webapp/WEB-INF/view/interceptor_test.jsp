<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<Script src="http://code.jquery.com/jquery-3.2.1.min.js"></Script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>제목</title>
</head>
<body>
	id : <%= session.getAttribute("id") %> <br/>
	pw : <%= session.getAttribute("pw") %> <br/>
	age : <%= session.getAttribute("age") %> <br/><br/><br/>
	
	session id : <%= session.getId() %> <br/>
	session max Interval : <%= session.getMaxInactiveInterval() %> <br/>
	session create Time : <%= session.getCreationTime() %> <br/>
	session last Access Time  : <%= session.getLastAccessedTime() %> <br/>
</body>
</html>