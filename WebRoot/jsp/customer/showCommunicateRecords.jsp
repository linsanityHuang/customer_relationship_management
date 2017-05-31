<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>交往记录</title>
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
<input type="hidden" id="add" value="${pageContext.request.contextPath}/customer_addCommunicateRecord.action?cust_no=${customer.cust_no}">
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
			<td>时间</td>
			<td>地点</td>
			<td>概要</td>
			<td>详细信息</td>
			<td>备注</td>
			<td>操作</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${communicateRecords}" var="communicateRecord">
			<c:if test="${communicateRecord.comm_flag == 1}">
				<tr>
					<td>${communicateRecord.comm_date }</td>
					<td>${communicateRecord.comm_address }</td>
					<td>${communicateRecord.comm_title }</td>
					<td>${communicateRecord.comm_detail }</td>
					<td>${communicateRecord.comm_remark }</td>
					<td>
						<a href="${pageContext.request.contextPath}/customer_editCommunicateRecord.action?cust_no=${customer.cust_no}&&comm_no=${communicateRecord.comm_no}">编辑</a>
						<a href="${pageContext.request.contextPath}/customer_deleteCommunicateRecord.action?cust_no=${customer.cust_no}&&comm_no=${communicateRecord.comm_no}" onclick="confirm('确实要删除此联系人吗？')">删除</a>
					</td>
				</tr>
			</c:if>
		</c:forEach>
	</tbody>
</table>
</body>
</html>