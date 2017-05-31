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
			<td>序号</td>
			<td>产品</td>
			<td>仓库</td>
			<td>货位</td>
			<td>件数</td>
			<td>备注</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="storage">
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
</body>
</html>