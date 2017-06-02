<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>销售机会管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script src="../script/common.js"></script>
</head>
<body>

<div class="page_title">销售机会管理</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<!-- add.html -->
	<input type="hidden" id="add" value="${pageContext.request.contextPath}/saleChance_toAddPage.action">
	<button class="common_button" onclick="to(document.getElementById('add').value)">新建</button>  
	
	<!-- reload(); -->
	<button class="common_button" onclick="document.query_form.submit()">查询</button> 
</div>
<form name="query_form" action="${pageContext.request.contextPath}/saleChance_multiQuery.action" method="post">
	<table class="query_form_table">
		<tr>
			<th>客户名称</th>
			<td><input type="text" name="chan_cust_name"></td>
			<th>概要</th>
			<td><input type="text" name="chan_title"></td>
		</tr>
	</table>
</form>
<br />
<table class="data_list_table">
	<tr>
		<th>编号</th>
		<th>客户名称</th>
		<th>负责人</th>
		<th>公司电话</th>
		<th>概要</th>
		<th>操作</th>
	</tr>
		<!-- 在销售机会管理的列表页面列出所有状态为“未分配”的销售机会记录 -->
	<c:forEach items="${pageBean.list}" var="saleChance">
		<tr>
			<td class="list_data_number">${saleChance.chan_no }</td>
			<td class="list_data_text">${saleChance.chan_cust_name}</td>
			<td class="list_data_ltext">${saleChance.chan_linkman}</td>
			<td class="list_data_text">${saleChance.chan_telephone }</td>
			<td class="list_data_text">${saleChance.chan_description }</td>
			<td class="list_data_op">
				<!-- dispatch.html -->
				<img onclick="to('${pageContext.request.contextPath }/saleChance_due_to_manager.action?chan_no=${saleChance.chan_no}');" title="指派" src="../images/bt_linkman.gif" class="op_button" />
				<!-- edit.html -->
				<img onclick="to('${pageContext.request.contextPath }/saleChance_showSaleChance.action?chan_no=${saleChance.chan_no}');" title="编辑" src="../images/bt_edit.gif" class="op_button" />
				<!-- “销售机会：采购笔记本电脑意向” -->
				<img onclick="del('销售机会' ,'${pageContext.request.contextPath }/saleChance_delete.action?chan_no=${saleChance.chan_no}');" title="删除" src="../images/bt_del.gif" class="op_button" />
			</td>
		</tr>
	</c:forEach>
	<tr>
		<th colspan="7" class="pager">
<div class="pager">
	共${pageBean.totalCount}条记录 每页<input value="${pageBean.pageSize}" size="2" />条
	第<input value="${pageBean.currentPage}" size="2"/>页/共${pageBean.totalPage}页
	<a href="#">第一页</a>
	<a href="${pageContext.request.contextPath }/saleChance_listpage?currentPage=${pageBean.currentPage-1 }">上一页</a>
	<a href="${pageContext.request.contextPath }/saleChance_listpage?currentPage=${pageBean.currentPage+1 }">下一页</a>
	<a href="#">最后一页</a>
	转到<input value="1" size="2" />页
	<button width="20" onclick="reload();">GO</button>
</div>
		</th>
	</tr>
</table>
</body>
</html>