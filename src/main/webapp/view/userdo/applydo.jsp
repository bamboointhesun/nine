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
<title>填写申请</title>
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
				<li class="nav-item btn btn-info disabled">填写申请</li>
			</ul>
		</div>
		</nav>
		<form action="<%=basePath%>apply/apply.do" method="post">
			<table class="table table-bordered text-center bg-light text-dark">
				<tr>
					<td>意愿活动</td>
					<td><input type="text" readonly="readonly" name="appActivity" value="${proTitle}" class="form-control"></td>
				</tr>
				<tr>
					<td>姓名</td>
					<td><input type="text" name="appName" placeholder="信息请务必真实喔亲" class="form-control"></td>
				</tr>
				<tr>
					<td>性别</td>
					<td>男：<input type="radio" name="appGender" value="男"/> &nbsp;&nbsp;
						女：<input type="radio" name="appGender" value="女" /> &nbsp;&nbsp;
						其它：<input type="radio" name="appGender" checked="checked" value="其它" /></td>
				</tr>
				<tr>
					<td>专业</td>
					<td><input type="text" name="appMajor" placeholder="信息请务必真实喔亲" class="form-control"></td>
				</tr>
				<tr>
					<td>年级</td>
					<td><input type="text" name="appGrade" placeholder="信息请务必真实喔亲" class="form-control" id="grade"></td>
				</tr>
				<tr>
					<td>电话</td>
					<td><input type="text" name="appPhone" placeholder="以1开头的11位手机号码"
						maxlength="11" class="form-control" id="phone"></td>
				</tr>
				<tr>
					<td>qq</td>
					<td><input type="text" name="appQq" placeholder="默认6-12位才是正确的qq" class="form-control" id="qq"></td>
				</tr>
				<tr>
					<td>初衷</td>
					<td><textarea  placeholder="信息请务必真实喔亲"
							rows="5" id="comment" name="appTar" class="form-control"></textarea></td>
				</tr>
				<tr>
					<td>想好了</td>
					<td><input type="submit" value="确定"  id="ok" class="form-control"></td>
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
	var reg1 = /^1\d{10}$/;
	var reg2 = /^\d{6,12}$/;
	var reg3 = /^[0-9]*$/;
	$("#ok").click(function() {
		if (!reg1.test($("#phone").val())){
			alert("电话起码以1开头，11位吧");
			return false;
		}
		if (!reg2.test($("#qq").val())){
			alert("qq起码是6-12位");
			return false;
		}
		if (!reg3.test($("#grade").val())){
			alert("年级是数字");
			return false;
		}
		alert("报名成功");
	})
	
})
</script>
</html>