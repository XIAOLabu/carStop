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
<title>收费规则查看</title>
<link rel="stylesheet" href="<%=basePath%>css/admin.css">
<link rel="stylesheet" href="<%=basePath%>css/pintuer.css">
<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>js/pintuer.js"></script>

</head>
<body>
	<div class="panel admin-panel">
		<h3 style="font-size: 20px">为贯彻落实政府改革精神，切实减轻人民负担。</h3>
		<h4>实行政府定价的区内停车场，小区物业处决定，自2020年3月1日起，下调条码服务费标准如下：</h4>
		<div>
			<h3 align="center" style="color: blue">停车时长收费标准</h3>
			<table class="table table-hover text-center panel admin-panel">
				<tr>
					<th>车辆停车收费</th>
					<th>收费标准(单位：元/小时)</th>
				</tr>
				<tr>
					<td>小区用户</td>
					<c:forEach items="${request.MrateList}" var="cr">
						<td style="text-align: left;">${cr.r_scu}</td>
					</c:forEach>
				</tr>
				<tr>
					<td>非小区用户</td>
					<c:forEach items="${request.MrateList}" var="cr">
						<td style="text-align: left;">${cr.r_scutmp}</td>
						<!-- 	<tr>
					
					<td style="text-align: left;">5</td>
				</tr>
				<tr>
					
					<td style="text-align: left;">8</td>
				</tr> -->

					</c:forEach>
			</table>
		</div>

		<div>
			<div class="panel admin-panel">
				<h3 align="center" style="color: blue">物业服务项目清单</h3>
				<table class="table table-hover text-center panel admin-panel">
					<tr>
						<th width="5%" style="text-align: center;">序号</th>
						<th width="12.5%" style="text-align: center;">服务项目</th>
						<th width="30%" style="text-align: left;">服务内容</th>
					</tr>
					<tr>
						<td>1</td>
						<td width="12.5%" style="text-align: center;">公共事务</td>
						<td width="12.5%" style="text-align: left;">出入管理、传达文书、公共安全检修监督</td>
					</tr>
					<tr>
						<td>2</td>
						<td width="12.5%" style="text-align: center;">保全警戒</td>
						<td width="12.5%" style="text-align: left;">岗哨警戒、巡逻警戒、机动警戒、集中监控</td>
					</tr>
					<tr>
						<td>3</td>
						<td width="12.5%" style="text-align: center;">服务职能</td>
						<td width="12.5%" style="text-align: left;">便利行政人员和管理人员管理停车设施</td>
					</tr>
				</table>
			</div>
			<h3>执收单位:</h3>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;小区物业处
		</div>
	</div>
</body>
</html>