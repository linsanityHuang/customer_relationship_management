<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>联系人信息查询</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/linkMan_moreCondition.action" method="post">
		<table>
			<tr>
				<td>联系人姓名</td>
				<td colspan="3">
					<input type="text" name="link_name">
				</td>
			</tr>
			<tr>
			
				<td>所属客户</td>
				<td>
					<select name="customer.cust_no">
						<option value="0">---请选择---</option>
						<c:forEach items="${list }" var="cus">
							<option value="${cus.cust_no }">${cus.cust_name}</option>
						</c:forEach>
					</select>
				</td>
				
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