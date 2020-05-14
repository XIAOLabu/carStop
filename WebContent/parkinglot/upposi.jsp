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
<title>车位信息更新</title>
<link rel="stylesheet" href="<%=basePath%>css/admin.css">
<link rel="stylesheet" href="<%=basePath%>css/pintuer.css">
<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>js/pintuer.js"></script>
</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head" id="add" align="center">
			<strong><span class="icon-pencil-square-o"></span>车位信息更新</strong>
			<s:if test="message!=null">
				<div id="messageBox" style="color: red; font-weight: bold"
					class="alert ${empty message ? 'hide' : ' '}">${message}</div>
			</s:if>
		</div>

		<div class="body-content"
			style="display: flex; justify-content: center; align-items: center;">

			<form method="post" action="up2Posi.action">
				<c:forEach items="${request.positionid}" var="posi">
					<div class="form-group" style="display: none">
						<div class="label" style="display: none">
							<span class="float-right">注:该选项不可改动</span> <label for="username">车位ID:${posi.cw_id}</label>
						</div>
						<div class="field" style="display: none">
							<input class="input" type="text" readonly="readonly" name="cw_id"
								size="50" value="${posi.cw_id}">
						</div>
					</div>

					<div class="form-group">
						<div class="label">
							<label for="username">更新车位号</label>
						</div>
						<div class="field">
							<input type="text" class="input" name="cw_no" size="50"
								value="${posi.cw_no}" />
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>车位区域. 原${posi.cw_wz}</label>
						</div>
						<select class="input" name="cw_wz">
							<option>A区</option>
							<option>B区</option>
							<option>C区</option>
							<option>D区</option>
							<option>E区</option>
						</select>
					</div>
					<div class="form-group">
						<div class="label">
							<label>更新车位状态，原${posi.cw_state}</label>
						</div>
						<select class="input" name="cw_state">
							<option>闲置</option>
							<option>占用</option>
						</select>
					</div>
					<c:choose>
						<c:when test="${posi.cw_type==1||posi.cw_type==2}">
							<!-- 设置该行数据不显示 -->
							<div class="form-group" style="display: none">
								<div class="label" style="display: none">
									<label for="username">更新车位用户</label>
								</div>
								<div class="field">
									<!-- 遍历用户名 -->
									<select class="input" name="cw_user">
										<c:forEach var="i" items="${u_s }">
											<option><c:out value="${i.u_user}" /></option>
										</c:forEach>
									</select>
								</div>
							</div>
						</c:when>
						<c:otherwise>
							<div class="form-group">
								<div class="label">
									<label for="username">更新车位用户,原用户为：${posi.cw_user }</label>
								</div>

								<div class="field">
									<!-- 遍历用户名 -->
									<select class="input" name="cw_user">
										<c:forEach var="i" items="${u_s }">
											<c:choose>
												<c:when test="${posi.cw_user == i.u_user }">
													<option class="input" selected="selected">
														<c:out value="${i.u_user}" /></option>
												</c:when>
												<c:otherwise>
													<option class="input">
														<c:out value="${i.u_user}" /></option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</select>
								</div>
							</div>
						</c:otherwise>
					</c:choose>
					<div class="form-group">
						<div class="label">
							<label for="username"> 车位类型</label>
						</div>
						<div class="field">
							<div class="input-group">
								<input class="input" type="text" readonly="readonly"
									name="cw_type" size="50" value="${posi.cw_type}">
							</div>
						</div>
					</div>
				</c:forEach>
				<div class="form-button" align="center">
					<button class="button button-block border-main size-big"
						type="submit">确认更新</button>
					<button class="button button-block border-main size-big"
						type="submit" formaction="showPosi.action">取消更新</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
