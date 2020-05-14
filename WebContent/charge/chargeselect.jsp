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
<link rel="stylesheet" href="<%=basePath%>css/admin.css">
<link rel="stylesheet" href="<%=basePath%>css/pintuer.css">
<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>js/pintuer.js"></script>
<title>收费数据查询</title>
</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head" id="add" align="center">
			<strong><span class="icon-pencil-square-o"></span>按条件查询车辆</strong>
			<s:if test="message!=null">
				<div id="messageBox" style="color: red; font-weight: bold"
					class="alert ${empty message ? 'hide' : ' '}">${message}</div>
			</s:if>
		</div>
		<div class="button-group">
			<form action="queryChargeAll.action">
				<label>根据车牌号查询</label> <input type="text" name="s_tcn" value="">
				<label>根据车主名字查询</label><input type="text" name="c_user" value="">
				<input type="submit" value="提交">
				<!-- <a class="button border-main"
				href="queryChargeAll.action?s_tcn=s_tcn&c_user=c_user}"><span
				class="icon-external-link"></span>查询</a> -->
			</form>
		</div>

		<table class="table table-hover text-center">
			<tr>
				<th style="text-align: center;">序号</th>
				<th style="text-align: center;">车主</th>
				<th style="text-align: center;">车牌号</th>
				<th style="text-align: center;">入场时间</th>
				<th style="text-align: center;">出场时间</th>
				<th style="text-align: center;">停放时长</th>
				<th style="text-align: center;">该次费用(元)</th>
			</tr>
			<c:set var="Sum" value="0.00"></c:set>
			<c:forEach items="${request.stopList}" var="st" varStatus="status">
				<c:set var="Sum" value="${Sum + st.s_cost }" />
				<tr>
					<td>${status.index+1}</td>
					<td>${st.s_user}</td>
					<td>${st.s_tcn}</td>
					<td>${st.s_cit}</td>
					<td>${st.s_cot}</td>
					<td>${st.s_time}</td>
					<td>${st.s_cost}</td>
				</tr>
			</c:forEach>
			<tr style="align-content: center;">
				<th style="text-align: center;"></th>
				<th style="text-align: center;"></th>
				<th style="text-align: center;"></th>
				<th style="text-align: center;"></th>
				<th style="text-align: center;"></th>
				<th style="text-align: center;"></th>
				<th style="text-align: center;">费用总计为：${Sum } 元</th>
			</tr>
		</table>
	</div>
</body>
</html>