<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page language="java" import="cn.gx.czz.model.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户收费</title>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<link rel="stylesheet" href="<%=basePath%>css/admin.css">
<link rel="stylesheet" href="<%=basePath%>css/pintuer.css">
<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>js/pintuer.js"></script>
</head>
<body>
	<!-- 获取session中的用户对象 -->
	<%
		User user = (User) session.getAttribute("user");
	%>
	<div>
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong> 用户名为: &nbsp;&nbsp;<%=user.getU_user()%>&nbsp;&nbsp;的收费信息
				</strong>
				<s:if test="message!=null">
					<div id="messageBox" style="color: red; font-weight: bold"
						class="alert ${empty message ? 'hide' : ' '}">${message}</div>
				</s:if>
			</div>
		</div>
		<table class="table table-hover text-center">
			<tr>
				<th style="text-align: center;">车牌号</th>
				<th style="text-align: center;">总收费</th>
				<th width="310" style="text-align: center;">操作</th>
			</tr>
			<tr>
				<td style="text-align: center;">桂A00018</td>
				<td style="text-align: center;">998.00</td>
				<td width="310" style="text-align: center;">点击查看明细</td>
			</tr>
		</table>
	</div>
</body>
</html>