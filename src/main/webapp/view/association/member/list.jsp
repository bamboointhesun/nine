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
<title>成员列表展示</title>
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
				<li class="nav-item btn btn-info disabled">成员列表展示</li>
			</ul>
		</div>
		</nav>
		<table class="table table-bordered text-center bg-light text-dark">
			<tr>
				<td class="text-left" colspan="5"><a
					href="<%=basePath%>member/addUI.do?" class="btn btn-primary btn-sm">添加</a></td>
			</tr>
			<tr>
				<td>职务</td>
				<td>姓名</td>
				<td>电话</td>
				<td>性别</td>
				<td>生日</td>
				<td colspan="2">操作</td>
			</tr>
			<c:forEach items="${members }" var="member">
				<tr>
					<td>${member.jobTitle }</td>
					<td>${member.memberName }</td>
					<td>${member.memberPhone }</td>
					<td>${member.memberGender }</td>
					<td><fmt:formatDate value="${member.memberBirthday }"
							pattern="yyyy-MM-dd" /></td>
					<td><a
						href="<%=basePath%>member/delete.do?memberId=${member.memberId }"
						class="btn btn-primary btn-sm alert alert-danger" id="del">删除</a>
						<a
						href="<%=basePath%>member/updateUI.do?memberId=${member.memberId }"
						class="btn btn-primary btn-sm">修改</a>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>