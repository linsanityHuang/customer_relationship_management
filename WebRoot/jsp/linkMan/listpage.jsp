<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分页显示客户列表</title>
</head>
<body>
	<table border="1px" cellpadding="10" cellspacing="1">
		<tr>
			<td>客户姓名</td>
			<td>客户所在地区</td>
			<td>客户经理姓名</td>
			<td>客户地址</td>
			<td>客户网址</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${pageBean.list }" var="customer">
			
				<tr>
					<td>${customer.cust_name }</td>
					<td>${customer.cust_region }</td>
					<td>${customer.cust_manager_name }</td>
					<td>${customer.cust_address }</td>
					<td>${customer.cust_website }</td>
					<td><a href="${pageContext.request.contextPath }/customer_delete.action?cust_no=${customer.cust_no}">删除</a></td>
					<td><a href="${pageContext.request.contextPath }/customer_showCustomer.action?cust_no=${customer.cust_no}">修改</a></td>
				</tr>
				
		</c:forEach>
	</table>
	<div>
		共【<b>${pageBean.totalCount }</b>】条记录，共【<b>${pageBean.totalPage}</b>】页
		，当前第【<b>${pageBean.currentPage}</b>】
		<c:if test="${pageBean.currentPage != 1}">
			【<a href="${pageContext.request.contextPath }/customer_listpage?currentPage=${pageBean.currentPage-1 }">前一页</a>】
		</c:if>
		
		<c:if test="${pageBean.currentPage != pageBean.totalPage}">
			【<a href="${pageContext.request.contextPath }/customer_listpage?currentPage=${pageBean.currentPage+1 }">后一页</a>】
		</c:if>
		</div>
</body>
</html>