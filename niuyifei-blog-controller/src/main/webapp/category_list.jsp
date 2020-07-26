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
</head>
<body>
	<table>
		<tr>
			<th>序号</th>
			<th>名称</th>
			<th>文章数量</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${category }" var="c">
			<tr>
				<td>${c.cid }</td>
				<td>${c.cname }</td>
				<td>${c.bcount }</td>
				<td>
					<a href="queryBlog?cid=${c.cid }">				
						<input type="button" value="文章序列">
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>