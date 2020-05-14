<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!DOCTYPE html>
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="renderer" content="webkit">
<title>登录页面</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>

</head>
<body>
	<s:div class="bg">
		<s:if test="message!=null">
			<div id="messageBox" style="color: red; font-weight: bold"
				class="alert ${empty message ? 'hide' : ' '}">${message}</div>
		</s:if>
	</s:div>
	<s:div class="container">
		<s:div class="line bouncein">
			<s:div class="xs6 xm4 xs3-move xm4-move">
				<s:div style="height: 150px;"></s:div>
				<s:div class="media media-y margin-big-bottom"></s:div>
				<!-- 表单开头。。。。。。。。。。。。。 -->
				<s:form method="post" action="login.action">
					<s:div class="panel loginbox">
						<s:div class="text-center margin-big padding-big-top">
							<h1>后台管理中心</h1>
						</s:div>
						<s:div class="panel-body"
							style="padding: 30px; padding-bottom: 10px; padding-top: 10px;">
							<s:div class="form-group">
								<s:div class="field field-icon-right">
									<!-- 获取用户名 -->
									<%
										//设置u_user默认值为""，避免在页面显示为null
																		String u_user = "";
																		if (request.getAttribute("u_user") != null) {
																			u_user = (String) request.getAttribute("u_user");
																		}
									%>
									<input type="text" class="input input-big" name="u_user"
										value="<%=u_user%>" placeholder="登录账号"
										data-validate="required:请填写账号" />
									<span class="icon icon-user margin-small"></span>
								</s:div>
							</s:div>
							<s:div class="form-group">
								<s:div class="field field-icon-right">
									<input type="password" class="input input-big" name="u_pwd"
										placeholder="登录密码" data-validate="required:请填写密码" />
									<span class="icon icon-key margin-small"></span>
								</s:div>
							</s:div>
						</s:div>
						<s:div style="padding: 30px;">
							<input type="submit"
								class="button button-block bg-main text-big input-big"
								value="登录">
						</s:div>
					</s:div>
				</s:form>
			</s:div>
		</s:div>
	</s:div>

</body>
</html>