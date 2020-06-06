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
<title>修改活动信息</title>
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
				<li class="nav-item btn btn-info disabled">开始修改活动信息</li>
			</ul>
		</div>
		</nav>
		<form action="<%=basePath%>project/update.do" method="post">
			<input type="hidden" name="projectId" value="${project.projectId }">
			<table class="table table-bordered text-center bg-light text-dark">
				<tr>
					<td>活动名称</td>
					<td><input type="text" name="projectTitle" value="${project.projectTitle }" class="form-control"></td>
				</tr>
				<tr>
					<td>活动主题</td>
					<td><input type="text" name="projectTopic" value="${project.projectTopic }" class="form-control"></td>
				</tr>
				<tr>
					<td>活动地点</td>
					<td><input type="text" name="projectPlace" value="${project.projectPlace }" class="form-control"></td>
				</tr>
				<tr>
					<td>活动负责人</td>
					<td><input type="text" name="projectWheel" value="${project.projectWheel }" class="form-control"></td>
				</tr>
				<tr>
					<td>活动赞助商</td>
					<td><select name="sponsorTitle" class="form-control">
					<c:forEach items="${sponsors}" var="sponsor">
							<option>${sponsor.sponsorName}</option>
					</c:forEach>
							<option disabled selected hidden>从下面选一个赞助商吧</option>
					</select></td>
				</tr>
				<tr>
					<td>开始时间</td>
					<td><fmt:formatDate value="${project.startTime}" pattern="yyyy-MM-dd"/>
					<input type="date" name="startTime" value="${project.startTime }" class="form-control"></td>
				</tr>
				<tr>
					<td>结束时间</td>
					<td><fmt:formatDate value="${project.endTime}" pattern="yyyy-MM-dd"/>
					<input type="date" name="endTime" value="${project.endTime }" class="form-control"></td>
				</tr>
				<tr>
				<td>创建时间</td>
				<td><fmt:formatDate value="${project.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				</tr>
				<tr>
				<td>上次修改时间</td>
				<td><fmt:formatDate value="${project.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				</tr>
				<tr>
					<td>想好了</td>
					<td><input type="submit" value="确定" class="form-control"></td>
				</tr>
				<tr>
					<td>先不慌</td>
					<td><input type="reset" value="还原" class="form-control"></td>
				</tr>

			</table>
		</form>
	</div>
</body>
</html>