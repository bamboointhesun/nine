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
<title>修改成员信息</title>
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
				<li class="nav-item btn btn-info disabled">开始修改成员信息</li>
			</ul>
		</div>
		</nav>
		<form action="<%=basePath%>member/update.do" method="post">
			<input type="hidden" name="memberId" value="${member.memberId }">
			<table class="table table-bordered text-center bg-light text-dark">
				<tr>
					<td>职务</td>
					<td><select class="form-control" name="jobTitle">
							<c:forEach items="${jobs}" var="job">
								<option>${job.jobTitle}</option>
							</c:forEach>
								<option disabled selected hidden>重新选一个部门吧</option>
					</select></td>
				</tr>
				<tr>
					<td>姓名</td>
					<td><input type="text" value="${member.memberName}"
						name="memberName" class="form-control"></td>
				</tr>
				<tr>
					<td>电话</td>
					<td><input type="text" maxlength="11"
						value="${member.memberPhone}" name="memberPhone" class="form-control" id="phone"></td>
				</tr>
				<tr>
					<td>性别</td>
					<td>男：<input type="radio" name="memberGender" value="男"/> &nbsp;&nbsp;&nbsp;&nbsp;
						女：<input type="radio" name="memberGender" value="女" /> &nbsp;&nbsp;&nbsp;&nbsp;
						其它：<input type="radio" name="memberGender" checked="checked" value="其它" /></td>
				</tr>
				<tr>
					<td>生日</td>
					<td>
					<fmt:formatDate value="${member.memberBirthday}" pattern="yyyy-MM-dd"/>
					<input type="date" name="memberBirthday" class="form-control">
					</td>
				</tr>
				<tr>
					<td>添加时间</td>
					<td><fmt:formatDate value="${member.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				</tr>
				<tr>
					<td>上次修改时间</td>
					<td><fmt:formatDate value="${member.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				</tr>
				<tr>
					<td>想好了</td>
					<td><input type="submit" value="确定" id="ok" class="form-control"></td>
				</tr>
				<tr>
					<td>先不慌</td>
					<td><input type="reset" value="重置" class="form-control"></td>
				</tr>

			</table>
		</form>
	</div>
</body>
<script type="text/javascript">
$(function() {
	var reg = /^1\d{10}$/;
	$("#ok").click(function() {
		if (!reg.test($("#phone").val())){
			alert("电话不正确");
			return false;
		}
	})
	
})
</script>
</html>