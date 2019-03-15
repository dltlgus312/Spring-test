<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c"	 	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" 	uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" 		uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" 	uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>
	
</head>

<body>
	
	<div>
		<label><input type="checkbox" name="group" value="" />전체</label>
		<label><input type="checkbox" name="group" value="" />야구</label>
		<label><input type="checkbox" name="group" value="" />축구</label>
		<label><input type="checkbox" name="group" value="" />농구</label>
		<label><input type="checkbox" name="group" value="" />배구</label>
		<label><input type="checkbox" name="group" value="" />발레</label> 
		<label><input type="checkbox" name="group" value="" />쇼트트랙</label>  
		<label><input type="checkbox" name="group" value="" />골프</label>      
	</div>
	
	<div id="onMouse" style="width:100px;height:100px;display:none;background-color:gray;color:white">
		   
	</div> 
	<script type="text/javascript">
		$("label:first > input:checkbox").change(function (){
			$("label:gt(0) > input").prop("checked", false);   
		}) 
 
		$("label:gt(0) > input:checkbox").change(function (){
			var check = 0;
			$("label:gt(0) > input:checkbox").each(function(index, elements){
				if(!$(this).is(":checked")){
					check = check + 1;
				}
			})
			if(check == 0){ 
				$("label:first > input").prop("checked", true);
				$("label:gt(0) > input").prop("checked", false); 
			}else {					
				$("label:first > input").prop("checked", false); 
			} 
		})
		
		$("label:gt(0)").each(function(index, elements){
			$(this).hover(function(){
				$("#onMouse").slideDown(50)
				$("#onMouse").html($(this).text())
				$("#onMouse").css("fontSize","20px")
			}, function(){
				$("#onMouse").slideUp(50)
				$("#onMouse").text("")
				$("#onMouse").css("")
			})
		})
	</script>
</body>
</html>