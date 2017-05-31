<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询结果页面</title>
</head>
<body>
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
		<c:forEach items="${list}" var="custLost">
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
				<td>操作</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>