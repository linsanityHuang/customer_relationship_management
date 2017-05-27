<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑用户信息</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/role_save.action?currentPage=1" method="post">
	<a>关于</a>
	<a>返回</a>
	<input type="submit" value="保存">
	<input type="hidden" name="role_id" value="${role.role_id }">
	<table>
		<tr>
			<td>编号</td>
			<td>${role.role_id }</td>
			<td>角色名</td>
			<td><input type="text" name="role_name" value="${role.role_name }"></td>
			
		</tr>
		<tr>
			<td>现任角色</td>
			<td>${user.sysRole.role_name}</td>
			<td>角色</td>
			<!-- 需要从数据库中取出 -->
			<td>
				<select name="sysRole.role_id">
					<option>---请选择---</option>
					<c:forEach items="${mapRole}" var="role">
						<option value="${role.key }">${role.value}</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>密码</td>
			<td><input type="text" name="user_password" value="${user.user_password}"></td>
			<td>确认密码</td>
			<td><input type="text" name="confirm_password" value="${user.user_password}"></td>
		</tr>
	</table>
</form>
</body>
</html>