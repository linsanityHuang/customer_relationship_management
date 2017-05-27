<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>客户关系管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>
<h1>欢迎您：${sessionScope.user.user_name}</h1>
</body>
</html>

