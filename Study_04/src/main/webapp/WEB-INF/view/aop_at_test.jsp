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
	<%= session.getAttribute("id") %> <br/>
	<%= session.getId() %> <br/>
	<%= session.getMaxInactiveInterval() %> <br/>
	<%= session.getCreationTime() %> <br/>
	<%= session.getLastAccessedTime() %> <br/>
</body>
</html>