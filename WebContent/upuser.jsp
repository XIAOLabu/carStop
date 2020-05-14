<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.errorMessage {
	font-size: 1.5em;
	color: red;
	text-align: right;
}

.label {
	font-size: 1.3em;
	text-align: center;
}

.footer {
	position: fixed;
	bottom: 0;
}

body {
	margin: 0 auto;
	text-align: center;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>信息更新</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head" id="add" align="center">
			<strong><span class="icon-pencil-square-o"></span>用户信息更新</strong>
			<s:if test="message!=null">
				<div id="messageBox" style="color: red; font-weight: bold"
					class="alert ${empty message ? 'hide' : ' '}">${message}</div>
			</s:if>
		</div>

		<div class="body-content"
			style="display: flex; justify-content: center; align-items: center;">

			<form method="post" action="up2User.action">
				<c:forEach items="${request.userid}" var="key">
					<div class="form-group" style="display: none">
						<div class="label" style="display: none">
							<span class="float-right">注:该选项不可改动</span> <label for="username">用户ID:${key.u_id}</label>
						</div>
						<div class="field" style="display: none">
							<input class="input" type="text" readonly="readonly" name="u_id"
								size="50" value="${key.u_id}">
						</div>
					</div>

					<div class="form-group">
						<div class="label">
							<label for="username">更新用户名</label>
						</div>
						<div class="field">
							<input type="text" class="input" name="u_user" size="50"
								value="${key.u_user}" />
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label for="username">更新用户手机号</label>
						</div>
						<div class="field">
							<input type="text" class="input" name="u_phone" size="50"
								value="${key.u_phone }" />
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label for="username"> 更新用户密码</label>
						</div>
						<div class="field">
							<div class="input-group">
								<input class="input" type="text" name="u_pwd" size="50"
									value="${key.u_pwd }" />
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>更新用户性别，原${key.u_sex }</label>
						</div>
						<select class="input" name="u_sex">
							<option>女士</option>
							<option>男士</option>
						</select>
					</div>
					<div class="form-group">
						<div class="label">
							<span class="float-right">0管理员\1普通用户 注:该选项不可改动</span> <label
								for="username"> 用户类型</label>
						</div>
						<div class="field">
							<div class="input-group">
								<input class="input" type="text" readonly="readonly"
									name="u_del" size="50" value="${key.u_del}">
							</div>
						</div>
					</div>
				</c:forEach>
				<div class="form-button" align="center">
					<button class="button button-block border-main size-big"
						type="submit">确认更新</button>
					<button class="button button-block border-main size-big"
						type="submit" formaction="myUser.action">取消更新</button>
				</div>
			</form>
		</div>

	</div>
</body>
</html>


<%-- <form action="up2User.action" method="post">
				<table class="table table-hover text-center">
					<tr>
						<th width="100" style="text-align: left; padding-left: 20px;">ID</th>
						<th width="10%">用户名</th>
						<th>用户密码</th>
						<th>用户性别</th>
						<th>用户手机号</th>
						<th>用户类型</th>
					</tr>
					<tr>
						<c:forEach items="${request.userid}" var="key">
							<tr>
								<td><input type="text" value="${key.u_id}" name="u_id" /></td>
								<td><input type="text" value="${key.u_del}" name="u_del" /></td>
								<td><input type="text" value="${key.u_user}" name="u_user" /></td>
								<td><input type="text" value="${key.u_pwd}" name="u_pwd" /></td>
								<td><input type="text" value="${key.u_phone}"
									name="u_phone" /></td>
							<tr>
						</c:forEach>

						<form> --%>







