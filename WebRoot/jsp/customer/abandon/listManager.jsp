<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>根据客户经理统计分析</title>
</head>
<body>
	
	<!-- 使用EL表达式获取域对象中的数据 -->
	<table>
		<tr>
			<td>客户经理姓名</td>
			<td>数量</td>
			
		</tr>
		<c:forEach items="${list}" var="map">
			<tr>
				<td>${map.cust_manager_name }</td>
				<td>${map.num }</td>
			</tr>
		</c:forEach>
	</table>
	
	<!-- 使用struts2标签库+ognl表达式获取值栈中的数据 -->
	<%-- <table>
		<s:iterator value="list" var="cus">
			<tr>
				<td>
					<s:property value="#cus.cust_name"/>
				</td>
				<td>
					<s:property value="#cus.cust_region"/>
				</td>
				<td>
					<s:property value="#cus.cust_manager_name"/>
				</td>
				<td>
					<s:property value="#cus.cust_address"/>
				</td>
				<td>
					<s:property value="#cus.cust_website"/>
				</td>
				<td>
					<a href="${pageContext.request.contextPath }/customer_delete.action?cust_no=<s:property value="#cus.cust_no"/>">删除</a>
				</td>
			</tr>
		</s:iterator>
	</table> --%>
</body>
</html>