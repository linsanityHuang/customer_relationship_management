<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>服务归档</title>
</head>
<body>
<form action="#" method="post">
	<input type="button" value="关于">
	<input type="button" value="返回">
	<table cellspacing="1" cellpadding="10" border="1px">
		<tr>
			<td>编号</td>
			<td>${serviceManager.serv_no}</td>
			<td>服务类型</td>
			<td>
				<c:forEach items="${serviceTypeMap}" var="map">
					<c:if test="${map.key == serviceManager.serv_type}">
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
				<c:if test="${serviceManager.serv_status == 4}">
					已反馈
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
			<td>处理人</td>
			<td>${serviceManager.serv_deal_name}</td>
			<td>处理时间</td>
			<td>${serviceManager.serv_deal_date}</td>
		</tr>
		<tr>
			<td>处理结果</td>
			<td>${serviceManager.serv_result}</td>
			<td>满意度</td>
			<td>
				<c:forEach items="${satisfyMap}" var="map">
					<c:if test="${map.key == serviceManager.serv_satisfy}">
						${map.value}
					</c:if>
				</c:forEach>
			</td>
		</tr>
	</table>
</form>
</body>
</html>