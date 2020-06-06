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
<title>活动详情</title>
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
				<li class="nav-item btn btn-info disabled">${pro.proTitle }</li>
				&nbsp;
				<li class="nav-item"><a class="btn btn-info"
					href="<%=basePath%>web/loginUI.do">去登录</a></li> &nbsp;
				<li class="nav-item"><a class="btn btn-info"
					href="<%=basePath%>web/registerUI.do">去注册</a></li>
			</ul>
		</div>
		</nav>
		<div class="text-center">${pro.proContent}</div>

		<form action="<%=basePath%>visitor/comment.do?proId=${pro.proId}"
			method="post">
			<input type="hidden" name="proNo" value="${pro.proId }"> <input
				type="hidden" name="commentAuthor" value="${name}"> <label
				for="comment" class="btn btn-info disabled">评论:</label>
			<textarea class="form-control" placeholder="请文明发言" rows="5"
				id="comment" name="commentContent"></textarea>
			<input type="button" id="ok" value="发布">
		</form>
		<button id="check" class=" btn btn-lg btn-outline-success">去报名参加该活动</button>
		<table class="table table-bordered text-center bg-light text-dark">
			<c:forEach items="${comments}" var="comment">
				<tr>
					<td>${comment.commentContent}</td>
					<td>${comment.commentAuthor}</td>
				</tr>
			</c:forEach>
			<tr>
			<td colspan="2">我也是有底线的</td>
			</tr>
		</table>
	</div>
</body>
<script type="text/javascript">
	$(function($) {
		$("#check").click(function() {
			alert("需要登录才能报名。");
		});
		$("#ok").click(function() {
			alert("需要登录才能评论。");

		})

	})
</script>
</html>