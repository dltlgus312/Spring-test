<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c"	 	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" 	uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" 		uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" 	uri="http://www.springframework.org/tags" %>

<html>
<body>

<c:forEach var="list" items="${noticeList }">
	<div>
		${list.NOTICE_TITLE }
		${list.NOTICE_CONTENTS }
		${list.REG_DATETIME }
	</div>
</c:forEach>

</body>
</html>
