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
<h1>多重查询结果</h1>
<table border="1px">
	<thead>
		<tr>
			<td>编号</td>
			<td>客户名称</td>
			<td>负责人</td>
			<td>公司电话</td>
			<td>概要</td>
			<td>操作</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${pageBean.list}" var="saleChance">
			<tr>
				<td>${saleChance.chan_no }</td>
				<td>${saleChance.chan_cust_name}</td>
				<td>${saleChance.chan_linkman}</td>
				<td>${saleChance.chan_telephone }</td>
				<td>${saleChance.chan_description }</td>
				<td>
					<a href="${pageContext.request.contextPath }/saleChance_due_to_manager.action?chan_no=${saleChance.chan_no}">指派</a>
					<!-- 必须控制，只有当销售机会的状态为未指派的时候才可以编辑 -->
					<a href="${pageContext.request.contextPath }/saleChance_showSaleChance.action?chan_no=${saleChance.chan_no}">编辑</a>
					<a href="${pageContext.request.contextPath }/saleChance_delete.action?chan_no=${saleChance.chan_no}">删除</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<div>
	共【<b>${pageBean.totalCount }</b>】条记录，共【<b>${pageBean.totalPage}</b>】页，当前第【<b>${pageBean.currentPage}</b>】
	
	<c:if test="${pageBean.currentPage != 1}">
		【<a href="${pageContext.request.contextPath }/saleChance_multiQuery?currentPage=${pageBean.currentPage-1 }">前一页</a>】
	</c:if>

	<c:if test="${pageBean.currentPage != pageBean.totalPage}">
		【<a href="${pageContext.request.contextPath }/saleChance_multiQuery?currentPage=${pageBean.currentPage+1 }">后一页</a>】
	</c:if>
</div>
</body>
</html>