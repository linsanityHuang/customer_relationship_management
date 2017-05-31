<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产品查询</title>
</head>
<body>
<h1>产品查询</h1>
<form action="${pageContext.request.contextPath }/product_multiQuery.action" method="post">
	<a href="#">关于</a>
	<input type="submit" value="查询">
	<table border="1px" cellpadding="10" cellspacing="1">
		<tr>
			<td>名称</td>
			<td><input type="text" name="prod_name"></td>
			<td>型号</td>
			<td><input type="text" name="prod_type"></td>
			<td>等级/批次</td>
			<td><input type="text" name="prod_garde_batch"></td>
		</tr>
	</table>
</form>

<table border="1px" cellpadding="10" cellspacing="1">
	<thead>
		<tr>
			<td>编号</td>
			<td>名称</td>
			<td>型号</td>
			<td>等级/批次</td>
			<td>单位</td>
			<td>单价（元）</td>
			<td>备注</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${pageBean.list}" var="product">
			<tr>
				<td>${product.prod_no}</td>
				<td>${product.prod_name}</td>
				<td>${product.prod_type}</td>
				<td>${product.prod_garde_batch}</td>
				<td>${product.prod_unit}</td>
				<td>${product.prod_price}</td>
				<td>${product.prod_remark}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<div>
	共【<b>${pageBean.totalCount }</b>】条记录，共【<b>${pageBean.totalPage}</b>】页
	，当前第【<b>${pageBean.currentPage}</b>】
	<c:if test="${pageBean.currentPage != 1}">
		【<a href="${pageContext.request.contextPath }/product_showProduct?currentPage=${pageBean.currentPage-1 }">前一页</a>】
	</c:if>
	
	<c:if test="${pageBean.currentPage != pageBean.totalPage}">
		【<a href="${pageContext.request.contextPath }/product_showProduct?currentPage=${pageBean.currentPage+1 }">后一页</a>】
	</c:if>
</div>
</body>
</html>