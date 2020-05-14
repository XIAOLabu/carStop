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
<title>车位信息管理页面</title>

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
		<div class="panel-head">
			<strong> 车位信息管理页面</strong>
			<s:if test="message!=null">
				<div id="messageBox" style="color: red; font-weight: bold"
					class="alert ${empty message ? 'hide' : ' '}">${message}</div>
			</s:if>
		</div>
		<div class="padding border-bottom">
			<ul class="search" style="padding-left: 10px;">
				<li><a href="showPosi.action"
					class="button border-main icon-exchange"> 刷新车位列表</a></li>
			</ul>
			<table>
				<tr>
					<th>
						<form action="toQueryPosi.action" method="post">
							<input class="input" placeholder="输入车位用户" name="cw_user"
								style="width: 160px; line-height: 17px; display: inline-block"
								id="" type="text"> <input type="submit" value="查询"
								class="button border-main icon-search">
						</form>
					</th>
					<th>
						<form action="toQueryPosi.action" method="post">
							<select class="input" name="cw_state"
								style="width: 160px; line-height: 17px; display: inline-block">
								<option>闲置</option>
								<option>占用</option>
							</select> <input type="submit" value="车位状态查找"
								class="button border-main icon-search">

						</form>
					</th>
					<th>
						<form action="toQueryPosi.action" method="post">
							<select class="input" name="cw_wz"
								style="width: 160px; line-height: 17px; display: inline-block">
								<option>A区</option>
								<option>B区</option>
								<option>C区</option>
								<option>D区</option>
								<option>E区</option>
							</select> <input type="submit" value="车位区域查找"
								class="button border-main icon-search">
						</form>
					</th>
				</tr>
			</table>
		</div>

		<table class="table table-hover text-center">
			<tr>
				<th width="100" style="text-align: center; padding-left: 20px;">车位ID</th>
				<th width="14.2%" style="text-align: center;">车位号</th>
				<th width="14.2%" style="text-align: center;">车位用户</th>
				<th width="14.2%" style="text-align: center;">车位位置</th>
				<th width="14.2%" style="text-align: center;">车位状态</th>
				<th width="14.2%" style="text-align: center;">车位类型</th>
				<th width="310" style="text-align: center;">操作</th>
			</tr>
			<c:forEach items="${request.posiList}" var="cw">
				<tr>
					<td style="text-align: left; padding-left: 20px;"><input
						type="checkbox" name="id[]" value="" />&nbsp;&nbsp;${cw.cw_id}</td>
					<td style="width: 50px; text-align: center; padding: 7px 0;">${cw.cw_no}</td>
					<td>${cw.cw_user }</td>
					<td>${cw.cw_wz}</td>
					<td>${cw.cw_state }</td>
					<td>${cw.cw_type}</td>
					<td><div class="button-group">
							<a class="button border-main"
								href="up1Posi.action?cw_id=${cw.cw_id}"><span
								class="icon-edit"></span> 更新</a> <a class="button border-red"
								href="delPosi.action?cw_id=${cw.cw_id}"
								onclick="return del(1,1,1)"><span class="icon-trash-o"></span>
								删除</a>
						</div></td>
				</tr>
			</c:forEach>
			<tr>
				<td style="text-align: left; padding: 19px 0; padding-left: 20px;"><input
					type="checkbox" id="checkall" /> 全选/反选</td>
				<td colspan="7" style="text-align: left; padding-left: 20px;"><a
					href="toQueryUser.action" class="button border-red icon-trash-o"
					style="padding: 5px 15px;" onclick="DelSelect()"> 删除</a></td>
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
				return true;
			} else {
				return false;
			}
		}

		//全选
		$("#checkall").click(function() {
			$("input[name='id[]']").each(function() {
				if (this.checked) {
					this.checked = false;
				} else {
					this.checked = true;
				}
			});
		})

		//批量删除
		function DelSelect() {
			var Checkbox = false;
			$("input[name='id[]']").each(function() {
				if (this.checked == true) {
					Checkbox = true;
				}
			});
			if (Checkbox) {
				var t = confirm("您确认要删除选中的内容吗？");
				if (t == false)
					return false;
				$("#listform").submit();
			} else {
				alert("请选择您要删除的内容!");
				return false;
			}
		}
	</script>
</body>

</html>