<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询库存</title>
</head>
<body>
<h1>查询库存</h1>
<form action="${pageContext.request.contextPath }/storage_multiQuery.action" method="post">
	<a href="#">关于</a>
	<input type="submit" value="查询">
	<table>
		<tr>
			<td>产品</td>
			<!-- 如何根据产品名称查询出向关联的库存信息 -->
			<!-- 当输入的是产品名称的时候报异常 -->
			<!-- 如果要在前端输入产品姓名实现查询功能，就需要在后台进行二次查询 -->
			<td><input type="text" name="product.prod_no"></td>
			<td>仓库</td>
			<td><input type="text" name="stor_storehouse"></td>
		</tr>
	</table>
</form>

<table>
	<thead>
		<tr>
			<td>序号</td>
			<td>产品</td>
			<td>仓库</td>
			<td>货位</td>
			<td>件数</td>
			<td>备注</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${pageBean.list}" var="storage">
			<tr>
				<td>${storage.stor_no}</td>
				<td>${storage.product.prod_name}</td>
				<td>${storage.stor_storehouse}</td>
				<td>${storage.stor_location}</td>
				<td>${storage.stor_count}</td>
				<td>${storage.stor_remark}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<div>
	共【<b>${pageBean.totalCount }</b>】条记录，共【<b>${pageBean.totalPage}</b>】页
	，当前第【<b>${pageBean.currentPage}</b>】
	<c:if test="${pageBean.currentPage != 1}">
		【<a href="${pageContext.request.contextPath }/storage_showStorage?currentPage=${pageBean.currentPage-1 }">前一页</a>】
	</c:if>
	
	<c:if test="${pageBean.currentPage != pageBean.totalPage}">
		【<a href="${pageContext.request.contextPath }/storage_showStorage?currentPage=${pageBean.currentPage+1 }">后一页</a>】
	</c:if>
</div>
</body>
</html>