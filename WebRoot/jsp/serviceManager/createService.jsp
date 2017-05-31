<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>服务创建</title>
<script type="text/javascript">
	var serv_cust_no = document.getElementById("serv_cust_no").value;
	var temp = document.getElementById("temp").value;
	temp = serv_cust_no;
</script>
</head>
<body>
<h1>服务创建</h1>
<% 
    String datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()); //获取系统时间 
    request.setAttribute("currentTime",datetime);
    
    String serv_no = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());  //获取服务编号
    serv_no = "SE" + serv_no;
%>
<form action="${pageContext.request.contextPath}/serviceManager_createService2db.action">
	<input type="button" value="关于">
	<input type="submit" value="保存">
	<input type="hidden" name="serv_no" value="${serv_no}">
	<c:forEach items="${customerMap}" var="map">
		<option value="${map.key}">${map.value}</option>
	</c:forEach>
	<c:if test=""></c:if>
	<input type="hidden" name="serv_cust_name">
	<input type="hidden" id="temp">
	
	<input type="hidden" name="serv_flag" value="1">
	<table cellspacing="1" cellpadding="10" border="1px">
		<tr>
			<td>客户</td>
			<td>
				<select id="serv_cust_no" name="serv_cust_no">
					<c:forEach items="${customerMap}" var="map">
						<option value="${map.key}"></option>
					</c:forEach>
				</select>*
			</td>
			<td>服务类型</td>
			<td>
				<select name="serv_type">
					<c:forEach items="${serviceTypeMap}" var="map">
						<option value="${map.key}">${map.value}</option>
					</c:forEach>
				</select>*
			</td>
		</tr>
		<tr>
			<td>创建人</td>
			<td>
				<input type="text" name="serv_create_by" value="${user.user_name}">*
			</td>
			<td>状态</td>
			<td>
				<input type="hidden" name="serv_status" value="1">新创建
			</td>
		</tr>
		<tr>
			<td>概要</td>
			<td>
				<input type="text" name="serv_title">*
			</td>
			<td>创建时间</td>
			<td>
				<input type="hidden" name="serv_create_date" value="${currentTime}">*
			</td>
		</tr>
		<tr>
			<td>服务请求</td>
			<td>
				<textarea rows="5" cols="25" name="serv_request"></textarea>*
			</td>
		</tr>
	</table>
</form>
</body>
</html>