<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<base href="<%=basePath%>">
<link rel="stylesheet" href="<%=basePath%>css/admin.css">
<link rel="stylesheet" href="<%=basePath%>css/pintuer.css">
<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>js/pintuer.js"></script>
<title>个人信息表</title>
</head>
<body>
	<div>
		<div class="panel-head" id="add" align="center">
			<strong><span class="icon-pencil-square-o"></span>用户信息查看</strong>
		</div>
		<div class="body-content"
			style="display: flex; justify-content: center; align-items: center;">
			<ul class="list-group list-striped">
				<c:forEach items="${request.personalList}" var="u">
					<li>
						<div class="form-group" style="display: none">
							<div class="label" style="display: none">
								<span class="float-right">注:该选项不可改动</span> <label for="username">用户ID:${key.u_id}</label>
							</div>
							<div class="field" style="display: none">
								<input class="input" type="text" readonly="readonly" name="u_id"
									size="50" placeholder="${u.u_id}">
							</div>
						</div>

						<div class="form-group">
							<div class="label">
								<label for="username">用户名</label>
							</div>
							<div class="field">
								<input type="text" class="input" name="u_user" size="50"
									readonly="readonly" placeholder="${u.u_user}" />
							</div>
						</div>
						<div class="form-group">
							<div class="label">
								<label for="username">用户手机号</label>
							</div>
							<div class="field">
								<input type="text" class="input" name="u_phone" size="50"
									readonly="readonly" placeholder="${u.u_phone }" />
							</div>
						</div>
						<div class="form-group">
							<div class="label">
								<label for="username">用户密码</label>
							</div>
							<div class="field">
								<div class="input-group">
									<input class="input" type="text" name="u_pwd" size="50"
										readonly="readonly" placeholder="${u.u_pwd }" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="label">
								<label>用户性别</label>
							</div>
							<div class="field">
								<input type="text" class="input" name="u_phone" size="50"
									readonly="readonly" placeholder="${u.u_sex }" />
							</div>
						</div>
						<div class="form-group">
							<div class="label">
								<span class="float-right">0管理员\1普通用户 注:该选项不可改动</span> <label
									for="username"> 用户类型</label>
							</div>
							<div class="field">
								<div class="input-group">
									<input class="input" type="text" readonly="readonly"
										name="u_del" size="50" placeholder="${u.u_del}">
								</div>
							</div>
						</div>
						<div class="form-button" align="center">
							<a class="button button-block border-main size-big"
								href="up1User.action?u_id=${user.u_id}"><span
								class="icon-edit"></span> 点击更新用户信息</a> <a
								class="button button-block border-main size-big" href="info.jsp"><span
								class="icon-edit"></span> 返回首页</a>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
</body>
</html>