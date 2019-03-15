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

	$(document).ready(function(){
		$("#select").change(function (){
			selectEvent($(this).val())
		})
		
		$(".paging > a").click(function(){
			pagingEvent($(this).text())
		})
	})
		

	function moveTo(obj) {
		if (obj >= 0) {
			var url;
			url = "/Study_02/user/board/boardContents.do?number=" + obj;
			location.href = url;
		} else {
			location.href = "/Study_02/user/board/boardContentsModify.do";
		}
	}
	
	function searchEvent(){
		location.href = "/Study_02/user/board/userBoardList.do?" + 
		"bundle=" + ${bundle } + 
		"&page=" + 1 +
		"&search=" + $('#search').val();
	}
	
	function selectEvent(value) {
		location.href = "/Study_02/user/board/userBoardList.do?" + 
				"bundle=" + value + 
				"&page=" + ${page };
	}
	
	function pagingEvent(value){
		var url = "/Study_02/user/board/userBoardList.do?" + 
					"bundle=" + ${bundle } +  
					"&page=" + value
			
		var len = "${search.length()}";
			
		if( len > 0 ){
			url += "&search=" + '${search }';
		}
					
		location.href = url;
	}
	
	
	
	function b1(){
		$("table > tbody > tr").each(function (index){
			$(this).find("> td:eq(1) > a").css("color","red");
			$(this).find("> td:eq(1) > a").css("fontSize","20px");
		});
	}
	
	function b2(){
// 		$("#select").val(20);

		$("#select > option[value=20]").prop("selected",true);

	}
	 
	function b3(){
		$("th#num").html("번호");
	}
	
	function b4(){
		var str = "";  
		
		$("input:checkbox[name='chk']:checked").each(function (idx) {
			str += $(this).val() + ",";
		});  

		$('#checkList').html(str);
	} 
	

</script>


</head>
<body>

	<div class="wrap">
		<div class="mg_b20">
			<input type="text" id="search" name="" value="${search }" />
			<button onclick="searchEvent()">검색</button>
		</div>

		<table>
			<colgroup> 
				<col width="10px">
				<col width="*">
				<col width="120px">
				<col width="10%">
			</colgroup>
			<thead>
				<tr>
					<th id="num">NO</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일시</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="list" items="${boardList }">
					<tr>
						<td><a>${list.NOTICE_SN }</a></td>
						<td><a href="javascript:void(0);" onclick="moveTo('${list.NOTICE_SN }')">${list.NOTICE_TITLE }</a></td>
						<td>관리자</td>
						<td>${list.REG_DATETIME }</td>
					</tr>
				</c:forEach>
			</tbody>

		</table>


		<!-- 모아보기 -->
		<div class="txt_right mg_t10">
			<select id="select" name="select">
				<option value="10" ${empty bundle || bundle eq '10' ? 'selected' : '' }>10개씩보기</option>
				<option value="20" ${bundle eq '20' ? 'selected' : '' }>20개씩보기</option>
				<option value="30" ${bundle eq '30' ? 'selected' : '' }>30개씩보기</option>
				<option value="50" ${bundle eq '50' ? 'selected' : '' }>50개씩보기</option>
			</select>
		</div>

		<!-- 등록 -->
		<div class="txt_right mg_t10">
			<button onclick="moveTo()">등록</button>
		</div>

		<!-- class="active" -->
		<!-- 페이지 -->
		<div class="txt_center mg_t30">
			<div class="paging">
				<a href="javascript:void(0);">&lt;&lt;</a> 
				<a href="javascript:void(0);">&lt;</a> 
				
				<c:forEach var="i" begin="1" end="${ cnt / bundle + 1}">
					<a href="javascript:void(0);" ${page eq i ? 'class=active' : ''}>${i}</a>
				</c:forEach>
			
				<a href="javascript:void(0);">&gt;</a> 
				<a href="javascript:void(0);">&gt;&gt;</a>
			</div>
		</div>
		
		
		
		
		<div>
			<button onclick="b1()">변경1</button>
			<button onclick="b2()">변경2</button>
			<button onclick="b3()">변경3</button>
		</div>

		<div>
			<label><input type="checkbox" id="check_1" name="chk" value="1" /> 1</label>
			<label><input type="checkbox" id="check_2" name="chk" value="2" /> 2</label>
			<label><input type="checkbox" id="check_3" name="chk" value="3" /> 3</label>
			<label><input type="checkbox" id="check_4" name="chk" value="4" /> 4</label>
			<label><input type="checkbox" id="check_5" name="chk" value="5" /> 5</label>
			<label><input type="checkbox" id="check_6" name="chk" value="6" /> 6</label>
			<button onclick="b4()">선택완료</button>
		</div>
				
		<div id="checkList"></div>
		
		

	</div>
</body>
</html>