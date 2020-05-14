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
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>车辆出场管理</title>
<link rel="stylesheet" href="<%=basePath%>css/admin.css">
<link rel="stylesheet" href="<%=basePath%>css/pintuer.css">
<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>js/pintuer.js"></script>
<script type="text/javascript"
	src="<%=basePath%>My97DatePicker/WdatePicker.js"></script>
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
	<div>
		<div align="left">
			<div class="form-group">
				<div class="label">
					<label>停车车辆出场管理</label>
					<s:if test="message!=null">
						<div id="messageBox" style="color: red; font-weight: bold"
							class="alert ${empty message ? 'hide' : ' '}">${message}</div>
					</s:if>
				</div>
				<form action="queryStop.action" method="post">
					<input class="input" placeholder="输入查询的车牌号码" name="s_tcn"
						style="width: 160px; line-height: 17px; display: inline-block"
						type="text"> <input class="input"
						style="width: 200px; line-height: 17px; display: inline-block"
						type="text" name="s_cit" placeholder="输入查询停车入场时间A"
						onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'})">
					<input class="input"
						style="width: 200px; line-height: 17px; display: inline-block"
						type="text" name="s_citt" placeholder="输入查询停车入场时间B"
						onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'})">

					<input type="submit" value="查询"
						class="button border-main icon-search">
				</form>
			</div>
			<table class="table table-hover text-center">
				<tr>
					<!-- <th width="12.5%" style="text-align: center; padding-left: 20px;">车位ID</th> -->
					<th width="12.5%" style="text-align: center;">车牌号码</th>
					<th width="12.5%" style="text-align: center;">车辆用户类型</th>
					<th width="12.5%" style="text-align: center;">停车位置</th>
					<th width="12.5%" style="text-align: center;">入场时间</th>
					<th width="12.5%" style="text-align: center;">出场时间</th>
					<th width="12.5%" style="text-align: center;">停车总时长</th>
					<th width="12.5%" style="text-align: center;">停车费用/出场操作</th>
				</tr>
				<c:forEach items="${request.stopList}" var="cs">
					<tr>
						<td style="text-align: left; padding-left: 20px;"><input
							type="checkbox" name="id[]" value="" />&nbsp;&nbsp;${cs.s_tcn}</td>
						<%-- <td style="width: 50px; text-align: center; padding: 7px 0;">${cs.s_id}</td> --%>
						<c:choose>
							<c:when test="${cs.s_tcu == 0}">
								<td>小区用户</td>
							</c:when>
							<c:otherwise>
								<td>非小区用户</td>
							</c:otherwise>
						</c:choose>
						<%-- <td>${cs.s_tcu}</td> --%>
						<td>${cs.s_tcw}</td>
						<td>${cs.s_cit }</td>
						<%-- 	<td>${cs.s_cot}</td>
					<td>${cs.s_time}</td> --%>
						<c:choose>
							<c:when test="${cs.s_time == 0}">
								<td>未出场</td>
							</c:when>
							<c:otherwise>
								<td>${cs.s_cot}</td>
							</c:otherwise>
						</c:choose>
						<td>${cs.s_time}</td>
						<c:choose>
							<c:when test="${cs.s_time >0}">
								<td><div class="button-group">
										<label class="button border-main"><span
											class="icon-cny (alias)"></span>${cs.s_cost}</label>
									</div></td>
							</c:when>
							<c:otherwise>
								<td><div class="button-group">
										<a class="button border-main"
											href="stopOut.action?s_id=${cs.s_id}&s_cit=${cs.s_cit}&s_tcw=${cs.s_tcw}"><span
											class="icon-external-link"></span> 设置出场</a>
									</div></td>
							</c:otherwise>
						</c:choose>

						<%-- <a class="button border-red"
									href="delStop.action?s_id=${cs.s_id}"
									onclick="return del(1,1,1)"><span class="icon-trash-o"></span>
									删除</a> --%>
					</tr>
				</c:forEach>
				<tr>
					<td style="text-align: left; padding: 19px 0; padding-left: 20px;"><input
						type="checkbox" id="checkall" value="全选/反选" />全选/反选</td>
					<td colspan="7" style="text-align: left; padding-left: 20px;"><a
						href="#.action" class="button border-red icon-trash-o"
						style="padding: 5px 15px;" onclick="DelSelect()"> 删除</a></td>
				</tr>
			</table>
		</div>
	</div>
</body>
<script type="text/javascript">
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


</html>