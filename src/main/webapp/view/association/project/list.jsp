<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.4.1/dist/jquery.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
<title>活动列表展示</title>
</head>
<body>
	<div class="container-fluid">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item btn btn-info disabled">活动列表展示</li>
			</ul>
		</div>
		</nav>
		<table class="table table-bordered text-center bg-light text-dark">
			<tr>
				<td class="text-left" colspan="8"><a
					href="<%=basePath%>project/addUI.do?"
					class="btn btn-primary btn-sm">添加</a></td>
			</tr>
			<tr>
				<td>活动名称</td>
				<td>活动主题</td>
				<td>活动地点</td>
				<td>活动负责人</td>
				<td>活动赞助商</td>
				<td>活动开始时间</td>
				<td>活动结束时间</td>
				<td colspan="2">操作</td>
			</tr>
			<c:forEach items="${projects }" var="project">
				<tr>
					<td>${project.projectTitle }</td>
					<td>${project.projectTopic }</td>
					<td>${project.projectPlace }</td>
					<td>${project.projectWheel }</td>
					<td>${project.sponsorTitle }</td>
					<td><fmt:formatDate value="${project.startTime }"
							pattern="yyyy-MM-dd" /></td>
					<td><fmt:formatDate value="${project.endTime }"
							pattern="yyyy-MM-dd" /></td>
					<td><a
						href="<%=basePath%>project/delete.do?projectId=${project.projectId }"
						class="btn btn-primary btn-sm alert alert-danger">删除</a> <a
						href="<%=basePath%>project/updateUI.do?projectId=${project.projectId }"
						class="btn btn-primary btn-sm">修改</a>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>