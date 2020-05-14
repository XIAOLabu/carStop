<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更改收费标准</title>

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
	<div class="panel admin-panel">
		<div class="panel-head" align="center">
			<strong><span class="icon-pencil-square-o"></span>更改收费标准</strong>
			<s:if test="message!=null">
				<div id="messageBox" style="color: red; font-weight: bold"
					class="alert ${empty message ? 'hide' : ' '}">${message}</div>
			</s:if>
		</div>
		<div class="body-content"
			style="display: flex; justify-content: center; align-items: center;">
			<form method="post" action="upCharge.action">
				<c:forEach items="${request.showmrate}" var="cr">
					<div class="form-group">
						<div class="label">
							<label>小区用户固定停车收费</label>
						</div>
						<div class="field">
							<input type="text" class="input" name="r_scu" size="50"
								value="${cr.r_scu }" />
						</div>
					</div>
				</c:forEach>
				<c:forEach items="${request.showmrate}" var="cr">
					<div class="form-group">
						<div class="label">
							<label>非小区用户停车收费</label>
						</div>
						<div class="field">
							<input type="text" class="input" name="r_scutmp" size="50"
								value="${cr.r_scutmp }" />
						</div>
					</div>
				</c:forEach>
				<div class="form-button" align="center">
					<button class="button button-block border-main size-big"
						type="submit">确认修改</button>
					<button class="button button-block border-main size-big"
						type="submit" formaction="">取消修改</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>