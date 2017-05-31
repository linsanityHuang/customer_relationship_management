<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户开发计划</title>
<style type="text/css">
	
</style>
</head>
<body>
<h1>客户开发计划</h1>
<form action="${pageContext.request.contextPath}/salePlan_multiQuery.action">
	<input type="button" value="关于">
	<!-- 点击“查询”按钮，可以根据客户名称、负责人、概要进行筛选查询。 -->
	<input type="submit" value="查询">
	<table border="1px" cellpadding="10" cellspacing="1">
		<tr>
			<td>客户名称</td>
			<td>
				<input type="text" name="saleChance.chan_cust_name">
			</td>
			<td>负责人</td>
			<td>
				<input type="text" name="saleChance.chan_linkman">
			</td>
			<td>概要</td>
			<td>
				<input type="text" name="saleChance.chan_title">
			</td>
		</tr>
	</table>
</form>

<table border="1px" cellspacing="2" cellpadding="10">
	<thead style="background: blue;">
		<tr style="font-weight: bolder;">
			<td>编号</td>
			<td>客户名称</td>
			<td>负责人</td>
			<td>公司电话</td>
			<td>状态</td>
			<td>概要</td>
			<td>操作</td>
		</tr>
	</thead>
	<!--
		状态为“已归档”的显示“查看”的操作图片链接，
		状态为“开发中”的依次显示“制定计划”、“执行计划”、“开发成功”的操作图片链接.
		销售机会指派状态（0：未指派/1：已指派开发中/2：已归档开发失败/3：已归档开发成功）
	-->
	<tbody>
		<c:forEach items="${pageBean.list}" var="salePlan">
			<tr>
				<td>${salePlan.plan_no }</td>
				<td>${salePlan.saleChance.chan_cust_name }</td>
				<td>${salePlan.saleChance.chan_linkman }</td>
				<td>${salePlan.saleChance.chan_telephone }</td>
				<td>
					<c:if test="${salePlan.saleChance.chan_status == 2 || salePlan.saleChance.chan_status == 3}">
						已归档
					</c:if>
					<c:if test="${salePlan.saleChance.chan_status == 1}">
						开发中
					</c:if>
				</td>
				<td>${salePlan.saleChance.chan_title }</td>
				<td>
					<c:if test="${salePlan.saleChance.chan_status == 2 || salePlan.saleChance.chan_status == 3}">
						<a href="${pageContext.request.contextPath}/salePlan_showSaleChanceDetails.action?plan_no=${salePlan.plan_no}">查看</a>
					</c:if>
					<c:if test="${salePlan.saleChance.chan_status == 1}">
						<!-- 
							客户经理对分配给自己的销售机会制定开发计划。
							点选“制定计划”后，显示销售机会的详细信息。
						-->
						<a href="${pageContext.request.contextPath}/salePlan_makePlan.action?plan_no=${salePlan.plan_no}">制定计划</a>
						<!-- 点选“执行开发计划”后，显示销售机会的详细信息以及制定的开发计划项列表 -->
						<a href="${pageContext.request.contextPath}/salePlan_executePlan.action?plan_no=${salePlan.plan_no}">执行计划</a>
						<!-- 
							客户经理从列表中选择一个状态为“已指派”的销售机会，点选“开发成功”操
							作，或者在执行计划页面点击“开发成功”按钮，修改销售机会的状态为“开发成功”，
							并提示信息“开发成功，已归档”，返回客户开发计划列表并更新。
						-->
						<a href="${pageContext.request.contextPath}/salePlan_developSuccess.action?plan_no=${salePlan.plan_no}" onclick="alert('开发成功，已归档。')">开发成功</a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<div>
	共【<b>${pageBean.totalCount }</b>】条记录，共【<b>${pageBean.totalPage}</b>】页
	，当前第【<b>${pageBean.currentPage}</b>】页
	<c:if test="${pageBean.currentPage != 1}">
		【<a href="${pageContext.request.contextPath }/salePlan_showSalePlan?currentPage=${pageBean.currentPage-1 }">前一页</a>】
	</c:if>
	
	<c:if test="${pageBean.currentPage != pageBean.totalPage}">
		【<a href="${pageContext.request.contextPath }/salePlan_showSalePlan?currentPage=${pageBean.currentPage+1 }">后一页</a>】
	</c:if>
</div>
</body>
</html>