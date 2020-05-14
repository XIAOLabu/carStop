<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>

	<div class="panel admin-panel">
		<div class="panel-head">
			<strong> 用户管理</strong>
			<s:if test="message!=null">
				<div id="messageBox" style="color: red; font-weight: bold"
					class="alert ${empty message ? '' : ''}">${message}</div>
			</s:if>
		</div>
		<div class="padding border-bottom">
			<ul class="search" style="padding-left: 10px;">
				<li><a href="myUser" class="button border-main icon-exchange">
						刷新用户</a></li>
				<li>
					<form action="toQueryUser.action" method="post">
						<input class="input" placeholder="输入查询用户关键字" name="u_user"
							style="width: 250px; line-height: 17px; display: inline-block"
							id="" type="text"> <input type="submit" value="查询"
							class="button border-main icon-search">
					</form>
				</li>
			</ul>
		</div>
		<table class="table table-hover text-center">
			<tr>
				<th width="100" style="text-align: left; padding-left: 20px;">ID</th>
				<th width="10%">用户名</th>
				<th>用户密码</th>
				<th>用户性别</th>
				<th>用户手机号</th>
				<th>用户类型</th>
				<th width="310">操作</th>
			</tr>
			<!-- <volist name="list" id="vo"> -->
			<tr>
				<c:forEach items="${request.userList}" var="key" begin="0" end="4">
					<td style="text-align: left; padding-left: 20px;"><input
						type="checkbox" name="id[]" value="" />&nbsp;&nbsp;${key.u_id}</td>
					<td style="width: 50px; text-align: center; padding: 7px 0;">${key.u_user}</td>
					<td>${key.u_pwd }</td>
					<td>${key.u_sex }</td>
					<td>${key.u_phone }</td>
					<td>${key.u_del}</td>
					<td><div class="button-group">
							<a class="button border-main"
								href="up1User.action?u_id=${key.u_id}"><span
								class="icon-edit"></span> 更新</a> <a class="button border-red"
								href="delUser.action?u_id=${key.u_id}"
								onclick="return del(1,1,1)"><span class="icon-trash-o"></span>
								删除</a>
						</div></td>
				</c:forEach>
			</tr>
		</table>
	</div>

	<script type="text/javascript">
		//搜索
		function changesearch() {

		}

		//单个删除
		function del(id, mid, iscid) {
			if (confirm("您确定要删除吗?")) {

			}
		}
	</script>
</body>

</html>