<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>临时车位信息添加</title>
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

body {
	margin: 0 auto;
	text-align: center;
}
</style>
</head>
<body>

	<div class="panel admin-panel">
		<div class="panel-head" id="add" align="center">
			<strong><span class="icon-pencil-square-o"></span>增加临时车车位</strong>
			<s:if test="message!=null">
				<div id="messageBox" style="color: red; font-weight: bold"
					class="alert ${empty message ? 'hide' : ' '}">${message}</div>
			</s:if>
		</div>

		<div class="body-content"
			style="display: flex; justify-content: center; align-items: center;">

			<form method="post" action="addPosi.action">
				<div class="form-group">
					<div class="label">
						<span class="float-right">注:临时车车位</span> <label for="cw_type">车位所属类型</label>
					</div>
					<div class="field">
						<input class="input" type="text" readonly="readonly"
							name="cw_type" size="50" value="1">
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>车位号</label>
					</div>
					<div class="field">
						<input type="text" class="input" name="cw_no" size="50"
							placeholder="车位号" />
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>车位区域</label>
					</div>
					<select class="input" name="cw_wz">
						<option>A区</option>
						<option selected="selected">B区</option>
						<option>C区</option>
						<option>D区</option>
						<option>E区</option>
					</select>
				</div>
				<div class="form-group">
					<div class="label">
						<label>车位状态</label>
					</div>
					<select class="input" name="cw_state">
						<option>闲置</option>
						<option>占用</option>
					</select>
				</div>
				<div class="form-button">
					<button class="button button-block border-main size-big"
						type="submit">确认增加</button>
					<button class="button button-block border-main size-big"
						type="submit" formaction="addallcw.jsp">取消增加</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>