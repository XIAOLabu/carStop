<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>增加用户</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
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
</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head" id="add" align="center">
			<strong><span class="icon-pencil-square-o"></span>增加用户</strong>
			<s:if test="message!=null">
				<div id="messageBox" style="color: red; font-weight: bold"
					class="alert ${empty message ? 'hide' : ' '}">${message}</div>
			</s:if>
		</div>
		<div class="body-content"
			style="display: flex; justify-content: center; align-items: center;">

			<form method="post" action="addUser.action">
				<div class="form-group">
					<div class="label">
						<strong>用户名称</strong>
					</div>
					<div class="field">
						<input type="text" class="input" id="username" name="u_user"
							size="50" placeholder="输入用户名" />
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<strong>用户密码</strong>
					</div>
					<div class="field">
						<div class="input-group">
							<input class="input" type="password" id="password" name="u_pwd"
								size="50" placeholder="填写密码" />
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<strong>用户联系方式</strong>
					</div>
					<div class="field">
						<input type="text" class="input" id="u_phone" name="u_phone"
							size="50" placeholder="手机号\电话" />
					</div>
				</div>
				<!-- <div class="form-group">
					<div class="label">
						<label for="face"> 头像</label>
					</div>
					<div class="field">
						<a class="button input-file" href="javascript:void(0);">+ 浏览文件<input
							size="100" type="file" /></a>
					</div>
				</div> -->
				<div class="form-group">
					<div class="label">
						<strong>用户性别</strong>
					</div>
					<div class="field">
						<div class="button-group radio">
							<label class="button active"> <input name="u_sex"
								value="先生" checked="checked" type="radio"><span
								class="icon icon-male"></span> 先生
							</label> <label class="button"> <input name="u_sex" value="女士"
								type="radio"><span class="icon icon-female"></span> 女士
							</label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<strong>用户类型</strong>
					</div>
					<div class="field">
						<div class="button-group radio">
							<label class="button active"> <input name="u_del"
								value="0" checked="checked" type="radio"><span
								class="icon icon-cog text-green"></span> 管理员
							</label> <label class="button"> <input name="u_del" value="1"
								type="radio"><span class="icon icon-user"></span> 普通用户
							</label>
						</div>
					</div>
				</div>

				<div class="form-button">
					<button class="button button-block border-main size-big"
						type="submit">用户注册</button>
					<button class="button button-block border-main size-big"
						type="submit" formaction="myUser.action">取消注册</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>