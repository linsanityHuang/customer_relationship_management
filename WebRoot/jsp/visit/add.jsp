<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加客户拜访</title>
</head>
<body>

<form action="${pageContext.request.contextPath }/visit_addVisit.action" method="post">
	<table>
		<thead>添加拜访记录</thead>
		<tbody>
		
			<tr>
				<td>客户：</td>
				<td colspan="3">
					<!-- 可以借助此处select标签的name属性的值，将相应数据封装到Visit模型中，是为模型驱动 -->
					<select name="customer.cust_no">
						<c:forEach items="${listCustomer }" var="customer">
							<option value="${customer.cust_no }">${customer.cust_name}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			
			<tr>
				<td>用户：</td>
				<td colspan="3">
					<select name="user.user_id">
						<c:forEach items="${listUser }" var="user">
							<option value="${user.user_id }">${user.user_name}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			
			
			<tr>
				<td>拜访地址：</td>
				<td><input type="text" name="vaddress"></td>
				<td>拜访内容：</td>
				<td><input type="text" name="vcontent"></td>
			</tr>
			
		</tbody>
	</table>
	<table>
		<tr>
			<td><input type="submit" value="添加拜访"></td>
			<td><input type="reset" value="重置信息"></td>
		</tr>
	</table>
</form>
</body>
</html>