<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link type="text/css" rel="stylesheet" href="/css/cmmn/normalize.css" />
<link type="text/css" rel="stylesheet" href="/css/cmmn/common.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<Script src="http://code.jquery.com/jquery-3.2.1.min.js">
	
</Script>

<script type="text/javascript">
	function moveTo(number) {
		location.href = "/user/board/boardContentsModify.do?number="+number;
	}
	
	function deleteBoard(number){
		var yes = confirm("삭제하시겠습니까?");
		if(yes){
			$.ajax({
				type : "POST",
				url : "/user/board/delete.do",
				data : {
					number : number
				}
			});
			location.href = "/user/board/userBoardList.do";
		}else {
			
		}
	}

</script>
</head>
<body>
	<table>
		<colgroup>
			<col width="10px">
			<col width="100%">
		</colgroup>

		<thead>
			<tr>
				<th>제목</th>
				<td>
<%-- 					<c:out value="${boardContents.NOTICE_TITLE }" /> --%>
					<input type="text" id="test" value="<c:out value="${boardContents.NOTICE_TITLE }" />" />
				</td>
			</tr>
		</thead>
	</table>


	<div id="contents" style="margin: 30px;">
		<c:out value="${boardContents.NOTICE_CONTENTS }" />
	</div>



	<table>
		<tr>
			<td>글번호</td>
			<td>생성날짜</td>
			<td>생성한곳</td>
			<td>수정날짜</td>
			<td>수정한곳</td>
		</tr>
		<tr>
			<td>${boardContents.NOTICE_SN }</td>
			<td>${boardContents.REG_DATETIME }</td>
			<td>${boardContents.REG_IP }</td>
			<td>${boardContents.MOD_DATETIME }</td>
			<td>${boardContents.MOD_IP }</td>
		</tr>
	</table>

	<div class="txt_right mg_t10">
		<button onclick="moveTo(${boardContents.NOTICE_SN})">수정</button>
		<button onclick="deleteBoard(${boardContents.NOTICE_SN})">삭제</button> 
	</div>

</body>
</html>