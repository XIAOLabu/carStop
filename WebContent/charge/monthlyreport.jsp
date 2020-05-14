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
<title>收费月报表</title>
</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head">
			<div class="panel-head" id="add" align="center">
				<strong><span class="icon-pencil-square-o"></span>查询近三个月其中某个月的收费记录</strong>
			</div>
			<a class="button border-main" href="monthly.action?mi=-2"><span
				class="icon-edit"></span> 上上个月</a> <a class="button border-main"
				href="monthly.action?mi=-1"><span class="icon-edit"></span> 上个月</a>
			<a class="button border-main" href="monthly.action?mi=0"><span
				class="icon-edit"></span> 本月</a>
		</div>
		<div class="panel-head" align="right">
			<s:if test="message!=null">
				<div id="messageBox"
					style="color: red; font-weight: bold; text-align: right;"
					class="alert ${empty message ? 'hide' : ' '}">
					<button type="button" onclick="tableToExcel('item','${message}')">导出并打印</button>
				</div>
			</s:if>
		</div>
		<table class="table table-hover text-center" id="item">
			<s:if test="message!=null">

				<tr style="height: 24px">
					<h2 align="center">
						<strong>${message}</strong>
					</h2>
				</tr>

			</s:if>
			<tr>
				<th style="text-align: center;">序号</th>
				<th style="text-align: center;">日期</th>
				<th style="text-align: center;">星期</th>
				<th style="text-align: center;">小区用户</th>
				<th style="text-align: center;">非小区用户</th>
				<th style="text-align: center;">本日收费合计</th>
			</tr>
			<c:set var="Sum" value="0.00"></c:set>
			<c:forEach items="${request.momcostList}" var="mc" varStatus="status">
				<c:set var="Sum" value="${Sum + mc.mc_sumcost}" />
				<tr>
					<td>${status.index+1}</td>
					<td>${mc.mc_time }</td>
					<td>${mc.mc_week }</td>
					<td>${mc.mc_icost }</td>
					<td>${mc.mc_zcost }</td>
					<td>${mc.mc_sumcost }</td>
				</tr>
			</c:forEach>
			<tr>
				<th style="text-align: center;"></th>
				<th style="text-align: center;"></th>
				<th style="text-align: center;"></th>
				<th style="text-align: center;"></th>
				<th style="text-align: right;"></th>
				<th style="text-align: right;">该月总收费为：${Sum } 元</th>
			</tr>
		</table>
	</div>
</body>
<script type="text/javascript">
	/*
	 * 导出Excel的方法 
	 */
	function base64(content) {
		return window.btoa(unescape(encodeURIComponent(content)));
	}
	function tableToExcel(tableID, fileName) {
		var table = document.getElementById(tableID);
		var excelContent = table.innerHTML;
		var excelFile = "<html xmlns:o='urn:schemas-microsoft-com:office:office' xmlns:x='urn:schemas-microsoft-com:office:excel' xmlns='http://www.w3.org/TR/REC-html40'>";
		excelFile += "<head><meta charset='UTF-8'><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head>";
		excelFile += "<body><table>";
		excelFile += excelContent;
		excelFile += "</table></body>";
		excelFile += "</html>";
		var link = "data:application/vnd.ms-excel;base64," + base64(excelFile);
		var a = document.createElement("a");
		a.download = fileName + ".xls";
		a.href = link;
		a.click();
	}
</script>

</html>