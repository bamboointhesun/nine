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
<title>我的</title>
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
				<li class="nav-item btn btn-info disabled">我的信息</li>
			</ul>
		</div>
		</nav>
		<form action="<%=basePath%>web/doMyInformation.do?webLoginame=${myInformation.userLoginame }" method="post">
			<input type="hidden" name="userId" value="${myInformation.userId }">
			<table class="table table-bordered text-center bg-light text-dark">

				<tr>
					<td>昵称</td>
					<td><input type="text" name="userNickname"
						value="${myInformation.userNickname }" class="form-control"></td>
				</tr>
				<tr>
					<td>登录名</td>
					<td><input type="text" value="${myInformation.userLoginame }" 
						readonly="readonly" class="form-control">
					</td>
				</tr>
				<tr>
					<td>密码</td>
					<td><input type="text" name="userPassword" value="${myInformation.userPassword }"
						readonly="readonly" class="form-control"></td>
				</tr>
				<tr>
					<td>生日</td>
					<td>
						<fmt:formatDate value="${myInformation.userBirthday }" pattern="yyyy-MM-dd"/>
						<input id="birthday" type="date" name="userBirthday"
						value="${myInformation.userBirthday }" class="form-control">
						</td>
				</tr>
				<tr>
					<td>性别</td>
					<td>男：<input type="radio" checked="checked" name="userGender" value="男"/> &nbsp;&nbsp;&nbsp;&nbsp;
						女：<input type="radio" name="userGender" value="女" /> &nbsp;&nbsp;&nbsp;&nbsp;
						其它：<input type="radio" name="userGender" value="其它" /></td>
				</tr>
				<tr>
					<td>个性签名</td>
					<td><input type="text" name="userSignature"
						value="${myInformation.userSignature}" class="form-control"></td>
				</tr>
				<tr>
					<td>注册时间</td>
					<td><fmt:formatDate value="${myInformation.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				</tr>
				<tr>
					<td>想好了</td>
					<td><input type="submit" value="确认" class="form-control"></td>
				</tr>
				<tr>
					<td>先不改</td>
					<td><input type="reset" value="还原" class="form-control"></td>
				</tr>

			</table>
		</form>
	</div>
</body>
</html>