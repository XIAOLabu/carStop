<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>停车信息更新</title>
<link rel="stylesheet" href="<%=basePath%>css/admin.css">
<link rel="stylesheet" href="<%=basePath%>css/pintuer.css">
<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>js/pintuer.js"></script>
<script type="text/javascript"
	src="<%=basePath%>My97DatePicker/WdatePicker.js"></script>

</head>


<body>
	<div class="panel admin-panel">
		<div class="panel-head" id="add" align="center">
			<strong><span class="icon-pencil-square-o"></span>停车信息更新</strong>
			<s:if test="message!=null">
				<div id="messageBox" style="color: red; font-weight: bold"
					class="alert ${empty message ? 'hide' : ' '}">${message}</div>
			</s:if>
		</div>

		<div class="body-content"
			style="display: flex; justify-content: center; align-items: center;">

			<form method="post" action="up2Stop.action">
				<c:forEach items="${request.stopUpList}" var="stop">

					<div class="form-group" style="display: none">
						<div class="label">
							<span class="float-right">注:该选项不可改动</span> <label for="username">停车ID:${stop.s_id}</label>
						</div>
						<div class="field">
							<input class="input" type="text" readonly="readonly" name="s_id"
								size="50" value="${stop.s_id}">
						</div>
					</div>

					<div class="form-group" style="display: none">
						<div class="label">
							<span class="float-right">注:该选项不可改动</span> <label for="username">车辆类型</label>
						</div>
						<div class="field">
							<input class="input" type="text" readonly="readonly" name="s_tcu"
								size="50" value="${stop.s_tcu}">
						</div>
					</div>


					<div class="form-group">
						<div class="label">
							<span class="float-right">注:该选项不可改动</span> <label for="username">车牌号</label>
						</div>
						<div class="field">
							<input class="input" type="text" readonly="readonly" name="s_tcn"
								size="50" value="${stop.s_tcn}">
						</div>
					</div>

					<div class="form-group">
						<div class="label">
							<span class="float-right">注:该选项不可改动</span> <label for="username">停车位置</label>
						</div>
						<div class="field">
							<input class="input" type="text" readonly="readonly" name="s_tcw"
								size="50" value="${stop.s_tcw}">
						</div>
					</div>


					<div class="form-group">
						<div class="label">
							<label for="username">更新车辆入场时间</label>
						</div>
						<div class="field">
							<input class="input" type="text" name="s_cit"
								value="${stop.s_cit}"
								onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'})">
						</div>
						<%-- <div class="field">
							<input type="text" class="input" name="s_cit" size="50"
								value="${stop.s_cit}" />
						</div> --%>
					</div>


					<div class="form-group">
						<div class="label">
							<label>更新车辆停放总时长</label>
						</div>
						<div class="field">
							<input type="text" class="input" name="s_time" size="50"
								value="${stop.s_time}" />
						</div>
					</div>


				</c:forEach>


				<div class="form-button" align="center">
					<button class="button button-block border-main size-big"
						type="submit">确认更新</button>
					<button class="button button-block border-main size-big"
						type="submit" formaction="showStop.action">取消更新</button>
				</div>

			</form>
		</div>
	</div>
</body>
</html>
