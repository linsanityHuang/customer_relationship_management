<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色管理</title>
<script language="javascript">
    function delcfm() {
        if (!confirm("确认要删除？")) {
            window.event.returnValue = false;
        }
    }
</script>
<!-- 
	代码说明：单击删除的超链接后将执行delcfm()函数，
	在对话框中，如果点击“确定”，函数将返回true值，就将页面转到<a>标签中的链接页面执行删除的页面；
	如果点击“取消”，函数将返回false值，<a>标签将不转到执行删除的页面。
-->
</head>
<body>
<h1>角色管理</h1>

<!-- 该form表单主要实现查询功能 -->
<form action="${pageContext.request.contextPath}/role_multiQuery.action" method="post">
	<a></a>
	<a href="${pageContext.request.contextPath}/role_add.action">新建</a>
	<input type="submit" value="查询">
	<table>
		<tr>
			<td>编号</td>
			<td><input type="text" name="role_id"></td>
			<td>角色名</td>
			<td><input type="text" name="role_name"></td>
		</tr>
	</table>
</form>
	<!-- 该表格主要用来显示用户信息 -->
	<table>
		<thead>
			<tr>
				<td>编号</td>
				<td>角色名</td>
				<td>操作</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pageBean.list}" var="role">
				<tr>
					<td>${role.role_id }</td>
					<td>${role.role_name }</td>
					<td>
						<a href="${pageContext.request.contextPath}/role_edit.action?role_id=${role.role_id}">编辑</a>
						<a href="${pageContext.request.contextPath}/role_delete.action?role_id=${role.role_id}" onclick="delcfm()">删除</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
		共【<b>${pageBean.totalCount }</b>】条记录，共【<b>${pageBean.totalPage}</b>】页
		，当前第【<b>${pageBean.currentPage}</b>】
		<c:if test="${pageBean.currentPage != 1}">
			【<a href="${pageContext.request.contextPath }/role_listpage?currentPage=${pageBean.currentPage-1 }">前一页</a>】
		</c:if>
		
		<c:if test="${pageBean.currentPage != pageBean.totalPage}">
			【<a href="${pageContext.request.contextPath }/role_listpage?currentPage=${pageBean.currentPage+1 }">后一页</a>】
		</c:if>
	</div>
</body>
</html>