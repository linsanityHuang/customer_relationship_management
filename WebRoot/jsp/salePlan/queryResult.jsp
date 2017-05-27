<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>开发计划查询页面</title>
</head>
<body>
<h1>查询结果</h1>
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
		<c:forEach items="${list}" var="salePlan">
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
						<a href="${pageContext.request.contextPath}/salePlan_showDetails.action?plan_no=${salePlan.plan_no}">查看</a>
					</c:if>
					<c:if test="${salePlan.saleChance.chan_status == 1}">
						<a href="${pageContext.request.contextPath}/salePlan_showDetails.action?plan_no=${salePlan.plan_no}">制定计划</a>
						<a href="${pageContext.request.contextPath}/salePlan_showDetails.action?plan_no=${salePlan.plan_no}">执行计划</a>
						<a href="${pageContext.request.contextPath}/salePlan_showDetails.action?plan_no=${salePlan.plan_no}">开发成功</a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>