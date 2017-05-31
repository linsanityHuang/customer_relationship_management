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
<form action="" method="post">
	<input type="button" value="关于">
	<input type="submit" value="查询">
</form>

<table cellspacing="1" cellpadding="10" border="1px">
	<thead>
		<tr>
			<td>编号</td>
			<td>客户</td>
			<td>服务类型</td>
			<td>创建人</td>
			<td>创建日期</td>
			<td>概要</td>
			<td>操作</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${pageBean.list}" var="service">
			<tr>
				<td>${service.serv_no}</td>
				<td>${service.serv_cust_no.cust_name}</td>
				<td>
					<c:forEach items="${serviceTypeMap}" var="map">
						<c:if test="${service.serv_type == map.key}">
							${map.value}
						</c:if>
					</c:forEach>
				</td>
				<td>${service.serv_create_by}</td>
				<td>${service.serv_create_date}</td>
				<td>${service.serv_title}</td>
				<td>
					<a href="${pageContext.request.contextPath}/serviceManager_handlingService.action?serv_no=${service.serv_no}">处理</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<div>
	共【<b>${pageBean.totalCount }</b>】条记录，共【<b>${pageBean.totalPage}</b>】页
	，当前第【<b>${pageBean.currentPage}</b>】
	<c:if test="${pageBean.currentPage != 1}">
		【<a href="${pageContext.request.contextPath }/serviceManager_handleService?currentPage=${pageBean.currentPage-1 }">前一页</a>】
	</c:if>
	
	<c:if test="${pageBean.currentPage != pageBean.totalPage}">
		【<a href="${pageContext.request.contextPath }/serviceManager_handleService?currentPage=${pageBean.currentPage+1 }">后一页</a>】
	</c:if>
</div>
</body>
</html>