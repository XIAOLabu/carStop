<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>车位分类增加</title>
<base href="<%=basePath%>">
<link rel="stylesheet" href="<%=basePath%>css/admin.css">
<link rel="stylesheet" href="<%=basePath%>css/pintuer.css">
<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>js/pintuer.js"></script>

</head>
<body>
	<!-- 	<button class="button icon-navicon margin-small-bottom"
		data-target="#nav-bg4"></button> -->
	<s:if test="message!=null">
		<div id="messageBox" style="color: red; font-weight: bold"
			class="alert ${empty message ? 'hide' : ' '}">${message}</div>
	</s:if>
	<div class="bg-green bg-inverse radius nav-navicon" id="nav-bg4">
		<ul class="nav nav-inline nav-menu nav-split nav-big nav-justified">
			<li><a href="<%=basePath%>parkinglot/addcwuser.jsp">私家车车位增加</a></li>
			<li><a href="<%=basePath%>parkinglot/addcwtemp.jsp">临时车位增加</a></li>
			<li><a href="<%=basePath%>parkinglot/addcwpb.jsp">公共车位增加</a></li>
		</ul>
	</div>

</body>
</html>