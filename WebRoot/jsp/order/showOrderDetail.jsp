<%@page import="cn.crm.entity.OrdersLine"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单明细</title>
</head>
<body>
	<input type="button" value="关于">
	<input type="button" value="返回">
	<table border="1px" cellpadding="10" cellspacing="1">
		<tr>
			<td>订单编号</td>
			<td>${order.orde_no}</td>
			<td>日期</td>
			<td>${order.orde_date}</td>
		</tr>
		<tr>
			<td>送货地址</td>
			<td>${order.orde_address }</td>
			<td>总金额（元）</td>
			<td>${totalMoney}</td>
		</tr>
		<tr>
			<td>状态</td>
			<td>
				<c:if test="${order.orde_status == 1}">已回款</c:if>
				<c:if test="${order.orde_status == 0}">未回款</c:if>
			</td>
			<td></td>
			<td></td>
		</tr>
	</table>
	
	<table border="1px" cellpadding="10" cellspacing="1">
		<thead>
			<tr>
				<td>商品</td>
				<td>数量</td>
				<td>单位</td>
				<td>单价（元）</td>
				<td>金额</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ordersLines}" var="line">
				<c:if test="${line.line_flag == 1}">
					<tr>
						<td>${line.product.prod_name }</td>
						<td>${line.line_count }</td>
						<td>${line.line_unit }</td>
						<td>${line.product.prod_price }</td>
						<td>
							<%-- <%
								OrdersLine line = request.getAttribute("line");
								String prod_price = line.getProduct().getProd_price();
								String line_unit = line.getLine_count()
								line.product.prod_price * line.line_unit
							%> --%>
						${line.product.prod_price * line.line_count}
						</td>
					</tr>
				</c:if>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>