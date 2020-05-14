<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@page language="java" import="cn.gx.czz.model.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<link rel="stylesheet" href="<%=basePath%>css/admin.css">
<link rel="stylesheet" href="<%=basePath%>css/pintuer.css">
<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>js/pintuer.js"></script>
</head>
<title>管理页面</title>

</head>


<body style="background-color: #f2f9fd;">

	<!-- 获取session中的用户对象 -->
	<%
		User user = (User) session.getAttribute("user");
	%>
	<div class="header bg-main">
		<div class="logo margin-big-left fadein-top">
			<h1>
				<img src="images/y.jpg" class="radius-circle rotate-hover"
					height="50" alt="" />XX小区停车位收费系统
			</h1>
		</div>
		<div class="head-l">
			<%
				if (user != null) {
			%>
			<a class="button button-little bg-green" href="toHostIndex.action"
				target="_blank"> <span class="icon-user"></span>
				${del}:&nbsp;&nbsp;<%=user.getU_user()%></a> &nbsp;&nbsp;
			<%
				} else {
			%>
			<a class="button button-little bg-green" href="toLogin.action"
				target="_blank"><span class="icon-github-alt "></span> 用户登录 </a>
			&nbsp;&nbsp;
			<%
				}
			%><a class="button button-little bg-red" href="logout.action"><span
				class="icon-power-off"></span> 退出登录</a>
		</div>
	</div>
	<c:choose>
		<c:when test="${u_del !=0}">
			<div class="leftnav">
				<h2>
					<strong><span class="icon-user"></span>用户功能菜单列表</strong>
				</h2>
				<ul>
				</ul>
				<h2>
					<span class="icon-pencil-square-o"></span>用户管理
				</h2>
				<ul style="display: block">

					<li><a href="myUser.action" target="right"><span
							class="icon-caret-right"></span>用户信息</a></li>
				</ul>
				<h2>
					<span class="icon-pencil-square-o"></span>车位信息管理
				</h2>
				<ul>
					<li><a href="showPosi.action" target="right"><span
							class="icon-caret-right"></span>车位列表查询</a></li>
					<li><a href="toAddPosi" target="right"><span
							class="icon-caret-right"></span>车位添加</a></li>
					<!-- 			<li><a href="cate.html" target="right"><span
					class="icon-caret-right"></span>车位使用信息查询</a></li> -->
				</ul>
				<h2>
					<span class="icon-pencil-square-o"></span>车辆信息管理
				</h2>
				<ul>
					<li><a href="car/addcaruser.jsp" target="right"><span
							class="icon-caret-right"></span>个人车辆新增</a></li>
					<li><a href="showCar.action" target="right"><span
							class="icon-caret-right"></span>个人车辆信息查询</a></li>
					<li><a href="showStop.action" target="right"><span
							class="icon-caret-right"></span>车辆驶入登记</a></li>
					<li><a href="showCostStopOut.action" target="right"><span
							class="icon-caret-right"></span>车辆驶出登记</a></li>
					<li><a href="showStopout.action" target="right"><span
							class="icon-caret-right"></span>以出场车辆查询</a></li>

				</ul>
				<h2>
					<span class="icon-pencil-square-o"></span>收费信息管理
				</h2>
				<ul>
					<li><a href="toShowCharge.action" target="right"><span
							class="icon-caret-right"></span>收费规则查看</a></li>
					<li><a href="upCharge.action" target="right"><span
							class="icon-caret-right"></span>收费规则修改</a></li>
					<li><a href="charge/chargeselect.jsp" target="right"><span
							class="icon-caret-right"></span>收费数据查询</a></li>
					<li><a href="tatiCharge.action" target="right"><span
							class="icon-caret-right"></span>收费数据统计</a></li>
					<li><a href="charge/monthlyreport.jsp" target="right"><span
							class="icon-caret-right"></span>收费月报表</a></li>
					<li><a href="showUserCost1.action" target="right"><span
							class="icon-caret-right"></span>用户收费</a></li>
				</ul>
			</div>
		</c:when>
		<c:otherwise>
			<div class="leftnav">
				<h2>
					<strong><span class="icon-user"></span>用户功能菜单列表</strong>
				</h2>
				<ul>
				</ul>
				<h2>
					<span class="icon-pencil-square-o"></span>用户管理
				</h2>
				<ul style="display: block">

					<li><a href="myUser.action" target="right"><span
							class="icon-caret-right"></span>个人信息更新</a></li>
				</ul>
				<h2>
					<span class="icon-pencil-square-o"></span>车辆信息管理
				</h2>
				<ul>
					<li><a href="car/addcaruser.jsp" target="right"><span
							class="icon-caret-right"></span>个人车辆新增</a></li>
					<li><a href="showCar.action" target="right"><span
							class="icon-caret-right"></span>个人车辆信息查询</a></li>
				</ul>
				<h2>
					<span class="icon-pencil-square-o"></span>收费信息管理
				</h2>
				<ul>
					<li><a href="toShowCharge.action" target="right"><span
							class="icon-caret-right"></span>收费规则查看</a></li>
					<li><a href="showUserCost1.action" target="right"><span
							class="icon-caret-right"></span>用户收费</a></li>
				</ul>
			</div>
		</c:otherwise>
	</c:choose>
	<script type="text/javascript">
		$(function() {
			$(".leftnav h2").click(function() {
				$(this).next().slideToggle(200);
				$(this).toggleClass("on");
			})
			$(".leftnav ul li a").click(function() {
				$("#a_leader_txt").text($(this).text());
				$(".leftnav ul li a").removeClass("on");
				$(this).addClass("on");
			})
		});
	</script>
	<ul class="bread">
		<li><a href="info.jsp" target="right" class="icon-home"> 首页</a></li>
		<li><a href="##" id="a_leader_txt">网站信息</a></li>
		<li><b>当前时间：</b><span style="color: red;"> <label
				id="time"> <script>
					document.getElementById('time').innerHTML = new Date()
							.toLocaleString()
							+ ' 星期' + '日一二三四五六'.charAt(new Date().getDay());
					setInterval(
							"document.getElementById('time').innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",
							1000);
				</script>
			</label>
		</span></li>
	</ul>
	<div class="admin">
		<!-- 中心页面展示的网页 info.jsp -->
		<iframe scrolling="auto" rameborder="0" src="info.jsp" name="right"
			width="100%" height="100%"></iframe>
	</div>
</body>
</html>