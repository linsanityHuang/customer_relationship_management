<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户流失管理</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/custLost_multiQuery.action" method="post">
<input type="button" value="关于">
<input type="submit" value="查询">
	<table border="1px" cellpadding="10" cellspacing="1">
		<tr>
			<td>客户名称</td>
			<td><input type="text" name="lost_cust_no.cust_name"></td>
			<td>客户经理</td>
			<td><input type="text" name="lost_manager_name"></td>
			<td>状态</td>
			<td>
				<select name="lost_status">
					<option value="0">全部</option>
					<c:forEach  items="${mapLostStatus}" var="map">
						<option value="${map.key}">${map.value}</option>
					</c:forEach>
				</select>
			</td>
		</tr>
	</table>
</form>
<table border="1px" cellpadding="10" cellspacing="1">
	<thead>
		<tr>
			<td>编号</td>
			<td>客户名称</td>
			<td>客户经理</td>
			<td>上次下单时间</td>
			<td>确认流失时间</td>
			<td>状态</td>
			<td>操作</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${pageBean.list}" var="custLost">
			<tr>
				<td>${custLost.lost_no}</td>
				<td>${custLost.lost_cust_no.cust_name}</td>
				<td>${custLost.lost_manager_name}</td>
				<td>${custLost.lost_last_order_date}</td>
				<td>${custLost.lost_last_date}</td>
				<td>
					<c:forEach items="${mapLostStatus}" var="map">
						<c:if test="${map.key == custLost.lost_status}">
							${map.value}
						</c:if>
					</c:forEach>
				</td>
				<td>
					<a href="${pageContext.request.contextPath}/custLost_pauseLost.action?lost_no=${custLost.lost_no}">暂缓流失</a>
					<a href="${pageContext.request.contextPath}/custLost_confirmLost.action?lost_no=${custLost.lost_no}">确认流失</a>
				</td>
			</tr>
		</c:forEach>
	
	</tbody>
</table>
<div>
	共【<b>${pageBean.totalCount }</b>】条记录，共【<b>${pageBean.totalPage}</b>】页，当前第【<b>${pageBean.currentPage}</b>】
	<c:if test="${pageBean.currentPage != 1}">
		【<a href="${pageContext.request.contextPath }/custLost_listpage?currentPage=${pageBean.currentPage-1 }">前一页</a>】
	</c:if>
	
	<c:if test="${pageBean.currentPage != pageBean.totalPage}">
		【<a href="${pageContext.request.contextPath }/custLost_listpage?currentPage=${pageBean.currentPage+1 }">后一页</a>】
	</c:if>
</div>
</body>
</html>