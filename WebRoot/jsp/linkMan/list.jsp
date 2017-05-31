<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户列表</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/customer_listcondition.action" method="post">
		<table border="1px" cellpadding="10" cellspacing="1">
			<tr>
				<td>客户姓名：<input type="text" name="cust_name"></td>
				<td><input type="submit" name="filter" value="筛选"></td>
			</tr>
		</table>
	</form>
	<!-- 使用EL表达式获取域对象中的数据 -->
	<table border="1px" cellpadding="10" cellspacing="1">
		<tr>
			<td>所属客户</td>
			<td>联系人名称</td>
			<td>联系人性别</td>
			<td>联系人职位</td>
			<td>联系人办公电话</td>
			<td>联系人手机号码</td>
			<td>联系人备注</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${list}" var="linkMan">
			<c:if test="${linkMan.link_flag == 1}">
				<tr>
					<td>${linkMan.link_cust_no.cust_name }</td>
					
					<td>${linkMan.link_name }</td>
					<td>${linkMan.link_sex }</td>
					<td>${linkMan.link_position }</td>
					<td>${linkMan.link_telephone }</td>
					<td>${linkMan.link_mobile }</td>
					<td>${linkMan.link_remark }</td>
					<td><a href="${pageContext.request.contextPath }/customer_delete.action?cust_no=${customer.cust_no}">删除</a></td>
					<td><a href="${pageContext.request.contextPath }/linkMan_showLinkMan.action?link_no=${linkMan.link_no}">修改</a></td>
				</tr>
			</c:if>
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