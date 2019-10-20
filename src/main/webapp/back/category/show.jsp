<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<html>
<head>
<link rel="stylesheet" href="${path }/back/css/btn.css" />
</head>
<body style="background-color: #f0f9fd;text-align: center;">

	<div style="font-size:25px">类别管理</div>
	<hr />
	<div style="margin-bottom: 10px;">
		<div class="button btn-p" onclick="location.href='${path }/back/category/add-first.jsp'">添加一级类别&raquo;</div>
		<div class="button btn-p" onclick="location.href='${path }/category/showOneCategory'">添加二级类别&raquo;</div>
	</div>
	<table bordercolor='#898E90' align='center' border='3px'
		cellpadding='10px' cellspacing="0px">
		<tr bgcolor='lightblue'>
			<td>Id</td>
			<td>类别名</td>
			<td>所属类别</td>
			<td>级别</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${categorys }" var="f">
			<tr>
				<td>${f.id }</td>
				<td>${f.cate_name }</td>
				<td></td>
				<td>1</td>
				<td><c:if test="${f.categorys.size()==0 }">
						<div class="button" onclick="location.href='' ">删除 &raquo;</div>
					</c:if></td>
			</tr>
			<c:forEach items="${f.categorys }" var="c">
				<tr>
					<td>${c.id }</td>
					<td>${c.cate_name }</td>
					<td>${f.cate_name }</td>
					<td>2</td>
					<td>
						<div class="button" onclick="location.href='' ">删除 &raquo;</div>
					</td>
				</tr>
			</c:forEach>
		</c:forEach>



	</table>
	<br />

</body>
</html>



