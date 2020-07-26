<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath()%>/css/css.css" rel="stylesheet">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		$.post("findCategoryAll",function(date){
			for ( var i in date) {
				$("#cid").append("<option value='"+date[i].cid+"'>"+date[i].cname+"</option>");
			}
			$("#cid").val("${blog.cid}");
		})
	})
</script>
<script type="text/javascript">
	function saveOrUpdate(){
		$("#cid").attr("disabled",false);
		$.post("saveOrUpdate",$("form").serialize(),function(date){
			if (date) {
				alert("保存成功");
				location.href="http://localhost:8080/queryCategory";
			} else {
				alert("保存失败");
			}
		})
	}
</script>
</head>
<body>
	<form action="#">
		<input type="hidden" name="bid" value="${blog.bid }">
		标题:<input type="text" name="title" value="${blog.title }"><br>
		博文分类:<select id="cid" name="cid" disabled="disabled">
			   		<option value="">请选择</option>
			   </select><br>
		文章内容:<input type="text" name="content" value="${blog.content }"><br>
		标签:<input type="text" name="label" value="${blog.label }"><br>
		<input type="button" value="保存" onclick="saveOrUpdate()">
		<input type="button" value="取消">
	</form>
</body>
</html>