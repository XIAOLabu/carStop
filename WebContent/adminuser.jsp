<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>后台管理中心</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body style="background-color: #f2f9fd;">
	<div class="leftnav">
		<!-- <div class="leftnav-title">
			<strong><span class="icon-list"></span>菜单列表</strong>
		</div> -->
		<h2>
			<span class="icon-user"></span>基本设置
		</h2>
		<ul style="display: block">
			<li><a href="info.html" target="right"><span
					class="icon-caret-right"></span>网站设置</a></li>
			<li><a href="pass.html" target="right"><span
					class="icon-caret-right"></span>修改密码</a></li>
			<li><a href="page.html" target="right"><span
					class="icon-caret-right"></span>单页管理</a></li>
			<li><a href="adv.html" target="right"><span
					class="icon-caret-right"></span>首页轮播</a></li>
			<li><a href="book.html" target="right"><span
					class="icon-caret-right"></span>留言管理</a></li>
			<li><a href="column.html" target="right"><span
					class="icon-caret-right"></span>栏目管理</a></li>
		</ul>
	</div>
	<!-- 	<script type="text/javascript">
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
	</script> -->
	<div class="admin">
		<iframe scrolling="auto" rameborder="0" src="info.jsp" name="right"
			width="100%" height="100%"></iframe>
	</div>
</body>
</html>