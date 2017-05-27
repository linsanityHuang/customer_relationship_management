<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>组合查询</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/customer_moreCondition.action" method="post">
		<table>
			<tr>
				<td>客户姓名</td>
				<td colspan="3">
					<input type="text" name="cust_name">
				</td>
			</tr>
			<tr>
				<td>客户地址</td>
				<td><input type="text" name="cust_address"></td>
			</tr>
			<tr>
				<td>客户经理姓名</td>
				<td><input type="text" name="cust_manager_name"></td>
			</tr>
			<tr>
				<td rowspan="2">
					<input type="submit" value="查询">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>