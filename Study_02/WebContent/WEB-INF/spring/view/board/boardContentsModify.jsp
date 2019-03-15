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

<Script src="http://code.jquery.com/jquery-3.2.1.min.js"></Script>

<script type="text/javascript">
	function goBack(number) {
		
		if($('#title').val() == "NULL" || $('#contents').val() == ""){
			alert("제목과 내용은 필수 항목입니다."); 
			return;
		}
		
		if (number > 0) {
			/* 수정 */
			$.ajax({
				type : "POST",
				url : "/Study_02/user/board/modify.do",
				data : {
					NOTICE_SN : number,
					NOTICE_TITLE : $('#title').val(),
					NOTICE_CONTENTS : $('#contents').val()
				}
			});
			location.href = "/Study_02/user/board/boardContents.do?number=" + number;

		} else {
			/* 등록 */
			$.ajax({
				type : "POST",
				url : "/Study_02/user/board/generator.do",
				data : {
					NOTICE_TITLE : $('#title').val(),
					NOTICE_CONTENTS : $('#contents').val()
				}
			});
			location.href = "/Study_02/user/board/userBoardList.do";
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
				<td><input type="text" id="title" value="${boardContents.NOTICE_TITLE }"></td>
			</tr>
		</thead>
	</table>


	<div style="margin: 30px;">
		<textarea rows="30%" cols="150%" id="contents">${boardContents.NOTICE_CONTENTS }</textarea>
	</div>
	

	<div class="txt_right mg_t10">
		<button id="ch" onclick="goBack('${boardContents.NOTICE_SN}')">확인</button>
	</div>
</body>
</html>