<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 查询之后显示的用户信息 -->
	<table border="1px" cellpadding="10" cellspacing="1">
		<thead>
			<tr>
				<td>编号</td>
				<td>用户名</td>
				<td>操作</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${multiQueryList}" var="queryUser">
				<tr>
					<td>${queryUser.user_id }</td>
					<td>${queryUser.user_name }</td>
					<td>
						<a href="${pageContext.request.contextPath}/user_edit.action?user_id=${queryUser.user_id}">编辑</a>
						<a href="${pageContext.request.contextPath}/user_delete.action?user_id=${queryUser.user_id}" onclick="delcfm()">删除</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>