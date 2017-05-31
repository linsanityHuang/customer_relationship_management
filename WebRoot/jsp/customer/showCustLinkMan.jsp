<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>联系人</title>
<script type="text/javascript">
	function addCustLinkMan() {
		var url = document.getElementById("add").value;
		window.location.href = url;
	}
</script>
</head>
<body>
<input type="button" value="关于">
<input type="button" value="新建" onclick="addCustLinkMan()">
<input type="hidden" id="add" value="${pageContext.request.contextPath}/customer_addLinkMan.action?cust_no=${customer.cust_no}">
<input type="button" value="返回">
<table border="1px" cellpadding="10" cellspacing="1">
	<tr>
		<td>客户名称</td>
		<td>${customer.cust_name}</td>
		<td>客户编号</td>
		<td>${customer.cust_no}</td>
	</tr>
</table>
<table border="1px" cellpadding="10" cellspacing="1">
	<thead>
		<tr>
			<td>姓名</td>
			<td>性别</td>
			<td>职位</td>
			<td>办公电话</td>
			<td>手机</td>
			<td>备注</td>
			<td>操作</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${linkMans}" var="linkMan">
			<c:if test="${linkMan.link_flag == 1}">
				<tr>
					<td>${linkMan.link_name }</td>
					<td>
						<c:if test="${linkMan.link_sex == 0 }">男</c:if>
						<c:if test="${linkMan.link_sex == 1 }">女</c:if>
					</td>
					<td>${linkMan.link_position }</td>
					<td>${linkMan.link_telephone }</td>
					<td>${linkMan.link_mobile }</td>
					<td>${linkMan.link_remark }</td>
					<td>
						<a href="${pageContext.request.contextPath}/customer_editLinkMan.action?cust_no=${customer.cust_no}&&link_no=${linkMan.link_no}">编辑</a>
						<a href="${pageContext.request.contextPath}/customer_deleteLinkMan.action?cust_no=${customer.cust_no}&&link_no=${linkMan.link_no}" onclick="confirm('确实要删除此联系人吗？')">删除</a>
					</td>
				</tr>
			</c:if>
		</c:forEach>
	</tbody>
</table>
</body>
</html>