<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新建联系人</title>
</head>
<body>
<%
	String datetime=new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime()); //获取系统时间 
	String link_no = "LK" + datetime;
	request.setAttribute("link_no",link_no);
%>
<form action="${pageContext.request.contextPath}/linkMan_addLinkMan2db.action" method="post">
	<input type="button" value="关于">
	<input type="button" value="返回">
	<input type="submit" value="保存">
	
	<input type="hidden" name="link_cust_no.cust_no" value="${customer.cust_no}">
	<input type="hidden" name="link_flag" value="1">
	<input type="hidden" name="link_no" value="${link_no}">
	<table border="1px" cellpadding="10" cellspacing="1">
		<tr>
			<td>姓名</td>
			<td><input type="text" name="link_name"></td>
			<td>*</td>
			<td>性别</td>
			<td>
				<input type="radio" name="link_sex" value="0">男
				<input type="radio" name="link_sex" value="1">女
			</td>
			<td></td>
		</tr>
		<tr>
			<td>职位</td>
			<td><input type="text" name="link_position" ></td>
			<td>*</td>
			<td>办公电话</td>
			<td><input type="text" name="link_telephone" ></td>
			<td>*</td>
		</tr>
		<tr>
			<td>手机</td>
			<td><input type="text" name="link_mobile" ></td>
			<td></td>
			<td>备注</td>
			<td><input type="text" name="link_remark" ></td>
			<td></td>
		</tr>
	</table>
</form>
</body>
</html>