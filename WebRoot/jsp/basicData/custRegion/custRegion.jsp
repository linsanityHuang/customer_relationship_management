<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户地区管理</title>
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
<h1>客户地区管理</h1>

<!-- 该form表单主要实现查询功能 -->
<form action="${pageContext.request.contextPath}/dictionary_multiQuery.action" method="post">
	<a></a>
	<a href="${pageContext.request.contextPath}/dictionary_addCustRegion.action">新建</a>
	<input type="submit" value="查询">
	<table>
		<tr>
			<td>编号</td>
			<td><input type="text" name="basi_value"></td>
			<td>值</td>
			<td><input type="text" name="basi_item"></td>
		</tr>
	</table>
</form>
	<!-- 该表格主要用来显示用户信息 -->
	<table>
		<thead>
			<tr>
				<td>编号</td>
				<td>值</td>
				<td>操作</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pageBean.list}" var="dictionary">
				<tr>
					<td>${dictionary.basi_value }</td>
					<td>${dictionary.basi_item }</td>
					<td>
						<a href="${pageContext.request.contextPath}/dictionary_editCustRegion.action?basi_no=${dictionary.basi_no}">编辑</a>
						<a href="${pageContext.request.contextPath}/dictionary_deleteCustRegion.action?basi_no=${dictionary.basi_no}" onclick="delcfm()">删除</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
		共【<b>${pageBean.totalCount }</b>】条记录，共【<b>${pageBean.totalPage}</b>】页
		，当前第【<b>${pageBean.currentPage}</b>】页
		<c:if test="${pageBean.currentPage != 1}">
			【<a href="${pageContext.request.contextPath }/dictionary_showCustRegion?currentPage=${pageBean.currentPage-1 }">前一页</a>】
		</c:if>
		
		<c:if test="${pageBean.currentPage != pageBean.totalPage}">
			【<a href="${pageContext.request.contextPath }/dictionary_showCustRegion?currentPage=${pageBean.currentPage+1 }">后一页</a>】
		</c:if>
	</div>
</body>
</html>