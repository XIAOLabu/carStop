<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>异常页面</title>
</head>
<body>
	<div class="container">
		<div class="panel margin-big-top">
			<div class="text-center">
				<br>
				<h2 class="padding-top">操作错误！抱歉您要找的页面已被外星人劫持</h2>
				<img src="<%=basePath%>images/wxr-1.jpg" width=500 height=500 />
				<div class="padding-big">
					<a href="info.jsp" class="button bg-yellow" target="right"
						class="icon-home">返回首页</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>