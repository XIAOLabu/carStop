<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!DOCTYPE html>
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
					class="alert ${empty message ? 'hide' : ' '}">${message}</div>
			</s:if>
		</div>
		<div class="padding border-bottom">
			<ul class="search" style="padding-left: 10px;">
				<li><a class="button border-main icon-plus-square-o"
					href="toAddUser"> 添加用户</a></li>
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
		<form id="form1" action="delAllUser.action" method="post">
			<table class="table table-hover text-center">
				<tr>
					<th width="12%" style="text-align: left; padding-left: 20px;"
						id="firstCb">ID</th>
					<th width="10%">用户名</th>
					<th>用户密码</th>
					<th>用户性别</th>
					<th>用户手机号</th>
					<th title="0为管理员;1为普通用户">用户类型</th>
					<th width="310">操作</th>
				</tr>
				<c:forEach items="${userList.pageRow}" var="user">
					<tr>
						<!-- 加入判断 当用户ID为999时，不显示在页面中 -->
						<c:choose>
							<c:when
								test="${user.u_id==999||user.u_id==1036||user.u_id==1037}">
								<%-- <!-- 设置该行数据不显示 -->
								<tr style="display: none">
									<td style="text-align: left; padding-left: 20px;"><input
										type="checkbox" name="id[]" value="" />${user.u_id}</td>
									<td style="width: 50px; text-align: center; padding: 7px 0;">${user.u_user}</td>
									<td>${user.u_pwd }</td>
									<td>${user.u_sex }</td>
									<td>${user.u_phone }</td>
									<td>${user.u_del}</td>
									<td><div class="button-group">
											<a class="button border-main"
												href="up2User.action?u_id=${user.u_id}"><span
												class="icon-edit"></span> 更新</a> <a class="button border-red"
												href="delUser.action?u_id=${user.u_id}"
												onclick="return del(1,1,1)"><span class="icon-trash-o"></span>
												删除</a>
										</div></td>
								</tr> --%>
							</c:when>
							<c:otherwise>
								<tr>
									<td style="text-align: left; padding-left: 20px;"><input
										type="checkbox" name="id[]" value="${user.u_id}"
										id="${user.u_id}" />&nbsp;&nbsp;${user.u_id}</td>
									<td style="width: 50px; text-align: center; padding: 7px 0;">${user.u_user}</td>
									<td>${user.u_pwd }</td>
									<td>${user.u_sex }</td>
									<td>${user.u_phone }</td>
									<td>${user.u_del}</td>
									<td><div class="button-group">
											<a class="button border-main"
												href="up1User.action?u_id=${user.u_id}"><span
												class="icon-edit"></span> 更新</a> <a class="button border-red"
												href="delUser.action?u_id=${user.u_id}"
												onclick="return del(1,1,1)"><span class="icon-trash-o"></span>
												删除</a>
										</div></td>
								</tr>
							</c:otherwise>
						</c:choose>
				</c:forEach>
				<tr>
					<td style="text-align: left; padding: 19px 0; padding-left: 20px;"><input
						type="checkbox" id="checkall" name="checkall" /> 全选/反选</td>
					<td colspan="7" style="text-align: left; padding-left: 20px;">
						<a class="button border-red icon-trash-o"
						href="javascript:void(0);" id="delSelected">删除选中</a> <!-- <a
					href="delAllUser.action" class="button border-red icon-trash-o"
					style="padding: 5px 15px;" id="delSelected" onclick="DelSelect()">
						删除</a> -->
					</td>
				</tr>
				<tr>
					<td colspan="8"><div class="pagelist">
							<%-- <c:out value="第${userList.pageNow}页/共${userList.pageCount}页 " /> --%>
							<c:if test="${userList.pageNow >1 }">
								<a href="myUser.action?pageNow=${1}">首页</a>
								<a
									href="<c:url value="myUser.action?method=userList&pageNow=${userList.pageNow-1}" />">上一页</a>
							</c:if>
							<c:choose>
								<c:when test="${userList.pageCount < userList.pageSize }">
									<c:set var="begin" value="1" />
									<c:set var="end" value="${userList.pageCount}" />
								</c:when>
								<c:otherwise>
									<c:set var="begin" value="${userList.pageNow - 2 }" />
									<c:set var="end" value="${userList.pageNow + 2 }" />
									<c:if test="${begin < 1 }">
										<c:set var="begin" value="${1}" />
										<c:set var="end" value="${5}" />
									</c:if>
									<c:if test="${end > userList.pageCount }">
										<c:set var="begin" value="${userList.pageCount-4}" />
										<c:set var="end" value="${userList.pageCount}" />
									</c:if>
								</c:otherwise>
							</c:choose>
							<%-- 循环打印页码（i），如果${i eq userList.pageNow }则取消超链接 --%>
							<c:forEach var="i" begin="${begin }" end="${end }">
								<c:choose>
									<c:when test="${i eq userList.pageNow }">
									${i}
								</c:when>
									<c:otherwise>
										<a
											href="<c:url value="myUser.action?method=userList&pageNow=${i}" />">${i}</a>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<c:if test="${userList.pageNow < userList.pageCount}">
								<a
									href="<c:url value="myUser.action?method=userList&pageNow=${userList.pageNow+1}" />">下一页</a>
								<a
									href="<c:url value="myUser.action?method=userList&pageNow=${userList.pageCount}" />">尾页</a>
							</c:if>
							<c:out value="第${userList.pageNow}页/共${userList.pageCount}页 " />
						</div></td>
				</tr>
			</table>
		</form>
	</div>

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
</body>

</html>