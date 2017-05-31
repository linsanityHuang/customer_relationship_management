<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>服务处理</title>
</head>
<body>
<% 
    String datetime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()); //获取系统时间 
    request.setAttribute("currentTime",datetime);
%>
<form action="${pageContext.request.contextPath}/serviceManager_handleService2db.action?serv_no=${serviceManager.serv_no}" method="post">
	<input type="button" value="关于">
	<input type="button" value="返回">
	<input type="submit" value="保存">
	<table cellspacing="1" cellpadding="10" border="1px">
		<tr>
			<td>编号</td>
			<td>${serviceManager.serv_no}</td>
			<td>服务类型</td>
			<td>
				<c:forEach items="${serviceTypeMap}" var="map">
					<c:if test="${service.serv_type == map.key}">
						${map.value}
					</c:if>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<td>概要</td>
			<td>${serviceManager.serv_title}</td>
		</tr>
		<tr>
			<td>客户</td>
			<td>${serviceManager.serv_cust_name}</td>
			<td>状态</td>
			<td>
				<c:if test="${serviceManager.serv_status == 2}">
					已分配
				</c:if>
			</td>
		</tr>
		<tr>
			<td>服务请求</td>
			<td>${serviceManager.serv_request}</td>
		</tr>
		<tr>
			<td>创建人</td>
			<td>${serviceManager.serv_create_by}</td>
			<td>创建时间</td>
			<td>${serviceManager.serv_create_date}</td>
		</tr>
		<tr>
			<td>分配给</td>
			<td>${serviceManager.serv_due_to}</td>
			<td>分配时间</td>
			<td>${serviceManager.serv_due_date}</td>
		</tr>
		<tr>
			<td>服务处理</td>
			<td><textarea rows="5" cols="25" name="serv_deal"></textarea>*</td>
		</tr>
		<tr>
			<td>处理人</td>
			<td><input type="text" name="serv_deal_name" value="${user.user_name}">*</td>
			<td>处理时间</td>
			<td><input type="text" name="serv_deal_date" value="${currentTime}">*</td>
		</tr>
	</table>
</form>
</body>
</html>