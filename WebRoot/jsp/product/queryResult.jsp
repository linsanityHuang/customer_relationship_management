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
			<td>名称</td>
			<td>型号</td>
			<td>等级/批次</td>
			<td>单位</td>
			<td>单价（元）</td>
			<td>备注</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="product">
			<tr>
				<td>${product.prod_no}</td>
				<td>
					<c:if test="${keyWords[0] != null}">
						<font color="red">
					</c:if>
						${product.prod_name}
					</font>
				
				</td>
				<td>
					<c:if test="${keyWords[1] != null}">
						<font color="red">
					</c:if>
						${product.prod_type}
					</font>
				</td>
				<td>
					<c:if test="${keyWords[2] != null}">
						<font color="red">
					</c:if>
						${product.prod_garde_batch}
					</font>
					
				</td>
				<td>${product.prod_unit}</td>
				<td>${product.prod_price}</td>
				<td>${product.prod_remark}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>