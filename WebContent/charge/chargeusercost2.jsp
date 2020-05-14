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
<title>用户收费统计二</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<link rel="stylesheet" href="<%=basePath%>css/admin.css">
<link rel="stylesheet" href="<%=basePath%>css/pintuer.css">
<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>js/pintuer.js"></script>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<div class="panel-head" align="center">
			<strong>车牌号 :${message}<br />的车辆收费信息列表
			</strong>
		</div>
		<div class="panel-head">
			<button class="button win-back icon-arrow-left">返回上个页面</button>
			<button class="button win-refresh icon-refresh">刷新</button>
		</div>
		<table class="table table-hover text-center">
			<tr>
				<th style="text-align: center;">序号</th>
				<th style="text-align: center;">停车位置</th>
				<th style="text-align: center;">车辆入场时间</th>
				<th style="text-align: center;">车辆出场时间</th>
				<th style="text-align: center;">车辆单次停放时长(小时)</th>
				<th style="text-align: center;">车辆单次收费(元)</th>
			</tr>
			<c:forEach items="${request.stopList}" var="st" varStatus="status">
				<tr>
					<td>${status.index+1}</td>
					<td>${st.s_tcw}</td>
					<td>${st.s_cit}</td>
					<td>${st.s_cot}</td>
					<td>${st.s_time}</td>
					<td>${st.s_cost}</td>
					<%-- <td><div class="button-group">
							<a class="button border-main"
								href="showUserCost2.action?c_tcn=${ucl.s_tcn}"><span
								class="icon-edit"></span>查询该车牌车辆的具体出入信息</a>
						</div></td> --%>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>