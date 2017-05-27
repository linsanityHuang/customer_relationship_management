<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>执行开发计划</title>
<script type="text/javascript">
	function developSuccess(){
		var url = document.getElementById("developSuccess").value;
		window.location.href = url;
		alert("开发成功，已归档。");
	}
	
	function developFailed(){
		var url = document.getElementById("developFailed").value;
		window.location.href = url;
		alert("开发失败，已归档。");
	}
	
	function makePlan(){
		var url = document.getElementById("makePlan").value;
		if(confirm("制定计划？")) {
			window.location.href = url;
		}
	}
	
</script>
</head>
<body>
<input type="hidden" id="developSuccess" value="${pageContext.request.contextPath}/salePlan_developSuccess.action?plan_no=${salePlan.plan_no}">
<input type="hidden" id="developFailed" value="${pageContext.request.contextPath}/salePlan_developFailed.action?plan_no=${salePlan.plan_no}">
<input type="hidden" id="makePlan" value="${pageContext.request.contextPath}/salePlan_makePlan.action?plan_no=${salePlan.plan_no}">

<h1>执行开发计划</h1>
<!-- 某个客户开发计划执行过程中或执行结束后如果客户同意购买公司产品，已经下
订单或者签订销售合同，则标志客户开发成功。 -->
<input type="button" value="关于" onclick="">
<input type="button" value="终止开发" onclick="developFailed()">
<input type="button" value="返回" onclick="">
<input type="button" value="制定计划" onclick="makePlan()">
<input type="button" value="开发成功" onclick="developSuccess()">

<table border="1px" cellspacing="1" cellpadding="10">
	<tr>
		<td>编号</td>
		<td>${salePlan.saleChance.chan_no }</td>
		<td>机会来源</td>
		<td>${salePlan.saleChance.chan_source }</td>
	</tr>
	<tr>
		<td>客户名称</td>
		<td>${salePlan.saleChance.chan_cust_name }</td>
		<td>成功几率(%)</td>
		<td>${salePlan.saleChance.chan_rate }</td>
	</tr>
	<tr>
		<td>负责人</td>
		<td>${salePlan.saleChance.chan_linkman }</td>
		<td>公司电话</td>
		<td>${salePlan.saleChance.chan_telephone }</td>
	</tr>
	<tr>
		<td>概要</td>
		<td colspan="3">${salePlan.saleChance.chan_title }</td>
	</tr>
	<tr>
		<td>机会描述</td>
		<td colspan="3">${salePlan.saleChance.chan_description }</td>
	</tr>
</table>

<table border="1px" cellpadding="10" cellspacing="1">
	<thead>
		<tr>
			<td>日期</td>
			<td>计划</td>
			<td>执行效果</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${salePlan.saleChance.salePlans }" var="salePlan_">
			<!-- 开发计划标识(0:已删除/1:未删除)只显示标识为1的数据 -->
			<c:if test="${salePlan_.plan_flag == 1}"> 
				<form action="${pageContext.request.contextPath}/salePlan_writePlanResult.action" method="post">
					<input type="hidden" name="plan_no" value="${salePlan_.plan_no}">
					<tr>
						<td>${salePlan_.plan_date }</td>
						<td>${salePlan_.plan_item }</td>
						<td>
							<c:if test="${salePlan_.plan_result != null}">
								${salePlan_.plan_result}
							</c:if>
							
							<c:if test="${salePlan_.plan_result == null}">
								<input type="text" name="plan_result">
								<input type="submit" value="保存">
							</c:if>
						</td>
					</tr>
				</form>
			</c:if>
		</c:forEach>
	</tbody>
</table>
</body>
</html>