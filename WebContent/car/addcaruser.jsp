<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>私家车信息添加</title>
<link rel="stylesheet" href="<%=basePath%>css/admin.css">
<link rel="stylesheet" href="<%=basePath%>css/pintuer.css">
<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>js/pintuer.js"></script>
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
</style>
</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head" id="add" align="center">
			<strong><span class="icon-pencil-square-o"></span>私家车信息添加</strong>
			<s:if test="message!=null">
				<div id="messageBox" style="color: red; font-weight: bold"
					class="alert ${empty message ? 'hide' : ' '}">${message}</div>
			</s:if>
		</div>

		<div class="body-content"
			style="display: flex; justify-content: center; align-items: center;">

			<form method="post" action="addCar.action">

				<div class="form-group">
					<div class="label">
						<label>车辆号码</label>
					</div>
					<div class="field">
						<input type="text" class="input" name="c_cno" size="50"
							placeholder="车辆号码" />
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label>车辆品牌</label>
					</div>
					<div class="field">
						<input type="text" class="input" name="c_csd" size="50"
							placeholder="车辆品牌" />
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label>车辆颜色</label>
					</div>
					<div class="field">
						<input type="text" class="input" name="c_ccr" size="50"
							placeholder="车辆颜色" />
					</div>
				</div>

				<div class="form-button">
					<button class="button button-block border-main size-big"
						type="submit">确认增加</button>
					<button class="button button-block border-main size-big"
						type="submit" formaction="showCar.action">取消增加</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>




