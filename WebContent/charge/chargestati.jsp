<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>收费数据统计</title>
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
	<div>
		<div class="panel-head" align="center">
			<strong>已注册用户车辆收费信息列表 </strong>
		</div>
		<table class="table table-hover text-center">
			<tr>
				<th style="text-align: center;">编号</th>
				<th style="text-align: center;">用户名</th>
				<th style="text-align: center;">收费金额(元)</th>
				<th style="text-align: center;">操作</th>
			</tr>
			<c:forEach items="${request.allUserCost}" var="all"
				varStatus="status">
				<c:choose>
					<c:when test="${all.cu_user==null}">
					</c:when>
					<c:otherwise>
						<tr>
							<td>${status.index+1}</td>
							<td>${all.cu_user}</td>
							<td>${all.cu_sum}</td>
							<td><div class="button-group">
									<a class="button border-main"
										href="showUserCost1.action?c_user=${all.cu_user}"><span
										class="icon-edit"></span>显示该用户名下车辆具体信息</a>
								</div></td>
						</tr>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</table>
	</div>
</body>
</html>