<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>车位增加失败页面</title>
</head>
<body>
	<s:if test="message!=null">
		<div id="messageBox" style="color: red; font-weight: bold"
			class="alert ${empty message ? 'hide' : ' '}">${message}</div>
	</s:if>
	<a href="cwlist.jsp">返回车位信息列表</a>
</body>
</html>