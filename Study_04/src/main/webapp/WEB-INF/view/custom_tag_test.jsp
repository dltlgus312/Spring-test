<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<Script src="http://code.jquery.com/jquery-3.2.1.min.js"></Script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://com.perform/mytags" prefix="fmt"%>

<title>제목</title>
</head>
<body>
	HELLOW WORLD
	
	<fmt:formatNumber number="10000000.5555" format="#,###.00"/>
	
</body>
</html>