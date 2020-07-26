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
	function del(bid){
		$.post("deleteBlogByid",{"bid":bid},function(date){
			if (date) {
				alert("删除成功");
				location.href="http://localhost:8080/queryCategory";
			} else {
				alert("删除失败");
			}
		})
	}
</script>
</head>
<body>
	<form action="queryBlog?cid=${cid }" method="post">
		关键字:<input type="text" name="likeName">
		<input type="submit" value="搜索"><br>
	</form>
	<a href="toadd?cid=${cid }">
		<input type="button" value="添加文章">
	</a>
	<table>
		<tr>
			<th>分类</th>
			<th>标题</th>
			<th>标签</th>
			<th>
				发布时间
					<a href="http://localhost:8080/queryBlog?cid=${cid }&orders=created asc">
						<input type="button" value="升序" onclick="orders('created asc')">
					</a>
					<a href="http://localhost:8080/queryBlog?cid=${cid }&orders=created desc">
						<input type="button" value="降序" onclick="orders('created desc')"> 
					</a>
			</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${page.list }" var="b">
			<tr>
				<td>${b.cname }</td>
				<td>${b.title }</td>
				<td>${b.label }</td>
				<td>${b.created }</td>
				<td>
					<a href="queryBlogById?bid=${b.bid }">
						<input type="button" value="编辑">
					</a>
					<input type="button" value="删除" onclick="del('${b.bid}')">
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="10">
				<a href="?cid=${cid }&pageNum=1">首页</a>
				<a href="?cid=${cid }&pageNum=${page.pageNum-1 <1 ?page.pageNum:page.pageNum-1}">上一页</a>
				<a href="?cid=${cid }&pageNum=${page.pageNum+1 >page.pages? page.pageNum :page.pageNum+1}">下一页</a>
				<a href="?cid=${cid }&pageNum=${page.pages}">尾页</a>
			</td>
		</tr>
	</table>
</body>
</html>