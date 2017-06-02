<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>客户关系管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>

<body style="border-bottom:solid 1px #666;">

<TABLE style="width:100%;">
<TR >
	<td ><img src="images/logo.gif"></td>
	<td style="font-family:黑体;font-size:33px;font-weight:bold;"> 客户关系管理系统</td>	
	<td width="25%" align="right" style="font-size:12px;" valign="bottom">当前用户：${user.user_name}(${user.sysRole.role_name})&nbsp;&nbsp; <a href="${pageContext.request.contextPath}/user_loginOut.action" style="text-decoration: underline;"><b>退出系统</b></a> </td>
</tr>
</table>
</body>
</html>