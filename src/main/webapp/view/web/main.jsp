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
<title>主页</title>
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
				<li class="nav-item btn btn-info disabled">欢迎${webLoginame}</li>
			</ul>
			&nbsp; <a
				href="<%=basePath%>web/myInformationUI.do?webLoginame=${webLoginame}"
				class="btn btn-primary btn-sm">我的</a>

		</div>
		</nav>
		<table class="table table-bordered text-center bg-light text-dark">
			<th colspan="3">九宫格事务管理</th>
			<tr>
				<td><a href="<%=basePath%>/member/list.do"
					class="btn btn-lg btn-outline-success">成员信息</a></td>
				<td><a href="<%=basePath%>/job/list.do"
					class="btn btn-lg btn-outline-success">职务信息</a></td>
				<td><a href="<%=basePath%>/external/list.do"
					class="btn btn-lg btn-outline-success">赞助信息</a></td>
			</tr>
			<tr>
				<td><a href="<%=basePath%>/project/list.do"
					class="btn btn-lg btn-outline-success">活动信息</a></td>
				<td><a
					href="<%=basePath%>/interact/readnews.do?name=${webLoginame}"
					class="btn btn-lg btn-outline-success">看新闻</a></td>
				<td><a href="<%=basePath%>/social/list.do"
					class="btn btn-lg btn-outline-success">社交平台信息</a></td>
			</tr>
			<tr>
				<td><a href="<%=basePath%>/resource/list.do"
					class="btn btn-lg btn-outline-success">资源信息</a></td>
				<td><a href="<%=basePath%>/news/list.do"
					class="btn btn-lg btn-outline-success">活动预告信息</a></td>
				<td><a href="<%=basePath%>/applyList/list.do"
					class="btn btn-lg btn-outline-success">报名信息</a></td>
			</tr>
		</table>
	</div>
</body>
</html>