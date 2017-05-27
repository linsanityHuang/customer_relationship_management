<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
<TITLE>登录页面</TITLE>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8">

</HEAD>
<body>
<table>
	<tr>
	    <td>
		    <form action="${pageContext.request.contextPath}/user_login.action" method="post">
		    	<table>
			        <tr> 
			          <th>用户名</th>
			          <td><input type="text" name="user_name"/></td>
			        </tr>
			        <tr> 
			          <th>密码</th>
			          <td><input type="password" name="user_password"/></td>
			        </tr>
			        <tr> 
			          <td>&nbsp;</td>
			          <td><input type="submit" value="登录"></td>
			        </tr>
	        	</table>
		    </form>
	    </td>
    	<td>${info}</td>
	</tr>
</table>
</body>
</html>