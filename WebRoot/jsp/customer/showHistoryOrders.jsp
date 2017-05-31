<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>历史订单</title>
<script type="text/javascript">
	function addCommunicateRecord() {
		var url = document.getElementById("add").value;
		window.location.href = url;
	}
</script>
</head>
<body>
<input type="button" value="关于">
<input type="button" value="新建" onclick="addCommunicateRecord()">
<input type="hidden" id="add" value="${pageContext.request.contextPath}/customer_addOrder.action?cust_no=${customer.cust_no}">
<input type="button" value="返回">
<table border="1px" cellpadding="10" cellspacing="1">
	<tr>
		<td>客户名称</td>
		<td>${customer.cust_name}</td>
		<td>客户编号</td>
		<td>${customer.cust_no}</td>
	</tr>
</table>
<table border="1px" cellpadding="10" cellspacing="1">
	<thead>
		<tr>
			<td>订单编号</td>
			<td>日期</td>
			<td>送货地址</td>
			<td>状态</td>
			<td>操作</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${orders}" var="order">
			<c:if test="${order.orde_flag == 1}">
				<tr>
					<td>${order.orde_no }</td>
					<td>${order.orde_date }</td>
					<td>${order.orde_address }</td>
					<td>
						<c:if test="${order.orde_status == 1}">已回款</c:if>
						<c:if test="${order.orde_status == 0}">未回款</c:if>
					
					</td>
					<td>
						<a href="${pageContext.request.contextPath}/customer_showOrderDetail.action?cust_no=${customer.cust_no}&&orde_no=${order.orde_no}">查看详情</a>
					</td>
				</tr>
			</c:if>
		</c:forEach>
	</tbody>
</table>
</body>
</html>