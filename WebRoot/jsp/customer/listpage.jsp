<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户信息管理</title>
<%-- <script type="text/javascript">
	window.onload = function () {
		var flag = document.getElementById("flag").value;
		if(flag == true) {
			alert("保存成功！");
		} else if (flag == false) {
			alert("保存失败！");
		}
	};
</script> --%>
</head>
<body>
	<form action="${pageContext.request.contextPath}/customer_multiQuery.action" method="post">
		<input type="button" value="关于">
		<input type="submit" value="查询">
		<table border="1px" cellpadding="10" cellspacing="1">
			<tr>
				<td>客户名称</td>
				<td>
					<input type="text" name="cust_name">
				</td>
				<td>客户编号</td>
				<td>
					<input type="text" name="cust_no">
				</td>
				<td>地区</td>
				<td>
					<select name="cust_region">
						<option value="0">---请选择---</option>
						<c:forEach items="${mapRegion}" var="map">
							<option value="${map.key}">${map.value}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>客户经理/负责人</td>
				<td>
					<input type="text" name="cust_manager_name">
				</td>
				<td>客户等级</td>
				<td>
					<select name="cust_level">
						<option value="">---请选择---</option>
						<c:forEach items="${mapLevel}" var="map">
							<option value="${map.key }">${map.value}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
		</table>
	</form>
	<table border="1px" cellpadding="10" cellspacing="1">
		<thead>
			<tr>
				<td>序号</td>
				<td>客户名称</td>
				<td>客户编号</td>
				<td>地区</td>
				<td>客户经理/负责人</td>
				<td>客户等级</td>
				<td>操作</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pageBean.list}" var="customer">
				<tr>
					<td>序号</td>
					<td>${customer.cust_name }</td>
					<td>${customer.cust_no}</td>
					<td>
						<c:forEach items="${mapRegion}" var="map">
							<c:if test="${map.key eq customer.cust_region}">
								${map.value}
							</c:if>
						</c:forEach>
					</td>
					<td>${customer.cust_manager_name }</td>
					<td>
						<c:forEach items="${mapLevel}" var="map">
							<c:if test="${map.key eq customer.cust_level}">
								${map.value}
							</c:if>
						</c:forEach>
					</td>
					<td>
						<a href="${pageContext.request.contextPath }/customer_showCustomer.action?cust_no=${customer.cust_no}">编辑</a>
						<a href="${pageContext.request.contextPath }/customer_showCustLinkMan.action?cust_no=${customer.cust_no}">联系人</a>
						<a href="${pageContext.request.contextPath }/customer_showCommunicateRecords.action?cust_no=${customer.cust_no}">交往记录</a>
						<a href="${pageContext.request.contextPath }/customer_showHistoryOrders.action?cust_no=${customer.cust_no}">历史订单</a>
						<a href="${pageContext.request.contextPath }/customer_deleteCustomer.action?cust_no=${customer.cust_no}" onclick="confirm('是否确定删除此客户？')">删除</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
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