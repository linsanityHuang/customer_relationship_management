<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>制定开发计划</title>
</head>
<body>
<% 
    String datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()); //获取系统时间 
    request.setAttribute("currentTime",datetime);
%>
<h1>制定开发计划</h1>
<table border="1px" cellspacing="1" cellpadding="10">
	<tr>
		<td>编号</td>
		<td>${saleChance.chan_no}</td>
		<td>机会来源</td>
		<td>${saleChance.chan_source }</td>
	</tr>
	<tr>
		<td>客户名称</td>
		<td>${saleChance.chan_cust_name }</td>
		<td>成功几率(%)</td>
		<td>${saleChance.chan_rate }</td>
	</tr>
	<tr>
		<td>负责人</td>
		<td>${saleChance.chan_linkman }</td>
		<td>公司电话</td>
		<td>${saleChance.chan_telephone }</td>
	</tr>
	<tr>
		<td>概要</td>
		<td colspan="3">${saleChance.chan_title }</td>
	</tr>
	<tr>
		<td>机会描述</td>
		<td colspan="3">${saleChance.chan_description }</td>
	</tr>
</table>

<table border="1px" cellspacing="1" cellpadding="10">
	<thead style="background-color: blue; color: white;font-weight: bolder;">
		<tr>
			<td>日期</td>
			<td colspan="3">计划项</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${saleChance.salePlans}" var="salePlan">
			<c:if test="${salePlan.plan_flag == 1}">
				<form action="${pageContext.request.contextPath}/salePlan_deletePlan_Item.action?plan_no=${salePlan.plan_no}" method="post">
					<tr>
						<td>${salePlan.plan_date }</td>
						<td>
							<input type="text" value="${salePlan.plan_item }">
						</td>
						<td colspan="2"><input type="submit" value="删除"></td>
					</tr>
				</form>
			
			</c:if>
		</c:forEach>
	</tbody>
	<tfoot>
		<form action="${pageContext.request.contextPath}/salePlan_addPlan_Item.action" method="post">
			<tr>
				<td colspan="4">
					<input type="submit" value="添加">
				</td>
			</tr>
			<!-- 这些隐藏域提供添加一项开发计划所需的其它默认信息 -->
			<input type="hidden" name="saleChance.chan_no" value="${saleChance.chan_no}">
			<input type="hidden" name="plan_result" value="">
			<input type="hidden" name="plan_flag" value="1">
			<tr>
				<td>日期</td>
				<td><input type="text" name="plan_date" value="${currentTime}" readonly="readonly"></td>
				<td>计划项</td>
				<td>
					<input type="text" name="plan_item">
				</td>
			</tr>
		</form>
	</tfoot>
</table>
</body>
</html>