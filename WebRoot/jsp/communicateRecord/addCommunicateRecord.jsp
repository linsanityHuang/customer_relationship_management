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
<title>新建交往记录</title>
</head>
<body>
<%
	String datetime=new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime()); //获取系统时间 
	String comm_no = "RE" + datetime;
	request.setAttribute("comm_no",comm_no);
	
	String comm_date = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒").format(Calendar.getInstance().getTime());
	request.setAttribute("comm_date", comm_date);
%>
<form action="${pageContext.request.contextPath}/communicateRecord_addCommunicateRecord2db.action" method="post">
	<input type="button" value="关于">
	<input type="button" value="返回">
	<input type="submit" value="保存">
	
	<input type="hidden" name="comm_cust_no.cust_no" value="${customer.cust_no}">
	<input type="hidden" name="comm_flag" value="1">
	<input type="hidden" name="comm_no" value="${comm_no}">
	<table border="1px" cellpadding="10" cellspacing="1">
		<tr>
			<td>时间</td>
			<td><input maxlength="200" type="text" name="comm_date" value="${comm_date}"></td>
			<td></td>
			<td>地点</td>
			<td>
				<input type="text" name="comm_address">
			</td>
			<td></td>
		</tr>
		<tr>
			<td>概要</td>
			<td><input type="text" name="comm_title" ></td>
			<td>*</td>
			<td>备注</td>
			<td><input type="text" name="comm_remark" ></td>
			<td></td>
		</tr>
		<tr>
			<td>详细信息</td>
			<td><input type="text" name="comm_detail" ></td>
			<td></td>
		</tr>
	</table>
</form>
</body>
</html>