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
<title>车辆入场管理</title>
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
<script>
	function showCustomer(str) {
		var xmlhttp;

		if (str == "") {
			document.getElementById("se").innerHTML = "";
			return;
		}
		if (window.XMLHttpRequest) {
			// IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
			xmlhttp = new XMLHttpRequest();
		} else {
			// IE6, IE5 浏览器执行代码
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {

				document.getElementById("se").innerHTML = xmlhttp.responseText;
			}
		}
		xmlhttp.open("POST", "/catstop/wherePosiNo.action?i=" + str, true);
		xmlhttp.send();
	}
</script>
</head>
<body>
	<div id="se">
		<select onchange="showCustomer(this.value)" id="txtHint"
			style="font-family: Verdana, Arial, Helvetica, sans-serif;">
			<option value="">选择车位区域</option>
			<option value="1">A区</option>
			<option value="2">B区</option>
			<option value="3">C区</option>
			<option value="4">D区</option>
			<option value="5">E区</option>
		</select>
		<div align="left">
			<div class="form-group">
				<div class="label">
					<label>新增停车车辆</label>
					<s:if test="message!=null">
						<div id="messageBox" style="color: red; font-weight: bold"
							class="alert ${empty message ? 'hide' : ' '}">${message}</div>
					</s:if>
				</div>
				<form action="addCarInto.action" method="post">
					<select name="s_tcw">
						<c:forEach items="${request.posinoList}" var="posi">
							<c:choose>
								<c:when test="${posi.cw_state =='占用'}">
									<!-- <option style="display: none">选择车位号</option> -->
								</c:when>
								<c:otherwise>
									<option><c:out value="${posi.cw_wz}-${posi.cw_no}" /></option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select> <input type="text" name="s_tcn" placeholder="输入车牌号">
					<button type="submit">增加入场车辆</button>
				</form>
			</div>

		</div>
		<form action="delAllCarInto.action" method="post" id="form1">
			<table class="table table-hover text-center">
				<tr>
					<th width="10%" style="text-align: center; padding-left: 20px;"
						id="firstCb">车辆ID</th>
					<th width="12.5%" style="text-align: center;">车牌号码</th>
					<th width="12.5%" style="text-align: center;">车辆用户类型</th>
					<th width="12.5%" style="text-align: center;">停车位置</th>
					<th width="12.5%" style="text-align: center;">入场时间</th>
					<!-- 				<th width="12.5%" style="text-align: center;">出场时间</th>
				<th width="12.5%" style="text-align: center;">停车总时长</th> -->
					<th width="12.5%" style="text-align: center;">是否出场</th>
					<th width="12.5%" style="text-align: center;">操作</th>
				</tr>
				<c:forEach items="${stopList.pageRow}" var="cs" varStatus="st">
					<tr>
						<td style="text-align: left; padding-left: 20px;"><input
							type="checkbox" name="id[]" value="${cs.s_id}" />&nbsp;&nbsp;${cs.s_id}</td>
						<td style="width: 50px; text-align: center; padding: 7px 0;">${cs.s_tcn}</td>
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
						<td><div class="button-group">
								<a class="button border-main"
									href="up1Stop.action?s_id=${cs.s_id}"><span
									class="icon-edit"></span> 更新</a> <a class="button border-red"
									href="delStop.action?s_id=${cs.s_id}"
									onclick="return del(1,1,1)"><span class="icon-trash-o"></span>
									删除</a>
							</div></td>
					</tr>
				</c:forEach>
				<tr>
					<td style="text-align: left; padding: 19px 0; padding-left: 20px;"><input
						type="checkbox" id="checkall" value="全选/反选" />全选/反选</td>
					<td colspan="7" style="text-align: left; padding-left: 20px;"><a
						class="button border-red icon-trash-o" href="javascript:void(0);"
						id="delSelected">删除选中</a></td>
				</tr>
				<tr>
					<td colspan="8"><div class="pagelist">
							<c:if test="${stopList.pageNow >1 }">
								<a href="showStop.action?pageNow=${1}">首页</a>
								<a
									href="<c:url value="showStop.action?method=stopList&pageNow=${stopList.pageNow-1}" />">上一页</a>
							</c:if>
							<c:choose>
								<c:when test="${stopList.pageCount < stopList.pageSize }">
									<c:set var="begin" value="1" />
									<c:set var="end" value="${stopList.pageCount}" />
								</c:when>
								<c:otherwise>
									<c:set var="begin" value="${stopList.pageNow - 2 }" />
									<c:set var="end" value="${stopList.pageNow + 2 }" />
									<c:if test="${begin < 1 }">
										<c:set var="begin" value="${1}" />
										<c:set var="end" value="${5}" />
									</c:if>
									<c:if test="${end > stopList.pageCount }">
										<c:set var="begin" value="${stopList.pageCount-4}" />
										<c:set var="end" value="${stopList.pageCount}" />
									</c:if>
								</c:otherwise>
							</c:choose>
							<%-- 循环打印页码（i），如果${i eq userList.pageNow }则取消超链接 --%>
							<c:forEach var="i" begin="${begin }" end="${end }">
								<c:choose>
									<c:when test="${i eq stopList.pageNow }">
									${i}
								</c:when>
									<c:otherwise>
										<a
											href="<c:url value="showStop.action?method=stopList&pageNow=${i}" />">${i}</a>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<c:if test="${stopList.pageNow < stopList.pageCount}">
								<a
									href="<c:url value="showStop.action?method=stopList&pageNow=${stopList.pageNow+1}" />">下一页</a>
								<a
									href="<c:url value="showStop.action?method=stopList&pageNow=${stopList.pageCount}" />">尾页</a>
							</c:if>
							<c:out value="第${stopList.pageNow}页/共${stopList.pageCount}页 " />
						</div></td>
				</tr>
			</table>
		</form>
	</div>
</body>
<script type="text/javascript">
	//单个删除
	function del(id, mid, iscid) {
		if (confirm("您确定要删除吗?")) {
			return true;
		} else {
			return
						false;
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
		window.onload = function() {
			document.getElementById("delSelected").onclick = function() {
				if (confirm("您确定要删除选中信息吗？")) {
					var flag = false;
					//判断是否有选中条目
					var cbs = document.getElementsByName("id[]");
					for (var i = 0; i < cbs.length; i++) {
						if (cbs[i].checked) {
							flag = true;
							break;
						}
					}
					if (flag) {
						document.getElementById("form1").submit();
					}
				}
			}
			//获取第一个checkbox
			document.getElementById("firstCb").onclick = function() {
				//获取下摆你列表中所有cd
				var cbs = document.getElementsByName("id[]");
				//遍历
				for (var i = 0; i < cbs.length; i++) {
					//设置cbs[]的check状态 = firstCb.checked
					cbs[i].checked = this.checked;
				}
			}
		}
</script>
</html>