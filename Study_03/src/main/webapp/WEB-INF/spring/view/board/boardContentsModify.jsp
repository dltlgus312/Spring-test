<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
// 			url : "/user/board/modify.do",
// 			processData: false,  // Important! 데이터형식으로 만들지 않아야한다.
// 		    contentType: false,	 // 기본이 application/x-www-form-urlencoded; charset=UTF-8 인데 "multipart/form-data" 로 전송이 되게 false 로 넣어준다.


			var frm = $("form")[0]
			var multipartFile = new FormData(frm);
			
			/* 수정 */
			$.ajax({
				type : "POST",
				url : "/user/board/modify.do",
				data : multipartFile,
		        cache: false,
				processData: false,
				contentType: false,
				success : function (data) {
					location.href = "/user/board/boardContents.do?number=" + number;
				},
				error : function (data) {
					alert("error");
					location.href = "/user/board/userBoardList.do";
				}
			});

		} else {
			
			var frm = $("form")[0]
			var multipartFile = new FormData(frm);
			
			/* 등록 */
			$.ajax({
				type : "POST",
				url : "/user/board/generator.do",
				data : multipartFile,
		        cache: false,
				processData: false,
				contentType: false,
				success : function (data) {
					if(data.sn == 0){
						location.href = "/user/board/userBoardList.do";
					}else {
						location.href = "/user/board/boardContents.do?number=" + data.sn; 
					}
				},
				error : function(data){
					alert("error : " + data.sn);
					location.href = "/user/board/userBoardList.do";
				}
			});
		}
	}
	

	
</script>

</head>

<body>

	<form id="formData" action="/user/board/modify.do" enctype="multipart/form-data" method="post">
		<input type="hidden" name="NOTICE_SN" value="${boardContents.NOTICE_SN}">
		<table>
			<colgroup>
				<col width="10px">
				<col width="100%">
			</colgroup>
	
			<thead>
				<tr>
					<th>제목</th>
					<td><input type="text" id="title" name="NOTICE_TITLE" value="${boardContents.NOTICE_TITLE }"></td>
				</tr>
			</thead>
		</table>
		<div style="margin: 30px;">
			<textarea rows="30%" cols="150%" name="NOTICE_CONTENTS" id="contents">${boardContents.NOTICE_CONTENTS }</textarea>
		</div>
		<div>
			<input type="file" name="file" />
			<c:forEach var="list" items="${file}">
				<img alt="" src="${pageContext.request.contextPath}${list.streCours}/${list.streFileNm}.${list.fileExtsn}" id="img">
				${list.orginlFileNm}.${list.fileExtsn}
			</c:forEach>
		</div>
	</form>
	
	<div class="txt_right mg_t10">
		<button id="ch" onclick="goBack('${boardContents.NOTICE_SN}')">확인</button>
	</div>
</body>
</html>