<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新建销售机会</title>
	<!-- 
		点击“新建”按钮，进入新建销售机会页面，注明红色“ *”的为必填项，如果未
		填写，给出提示信息。其中客户等级、地区、指派给用下拉列表显示，数据来源于数
		据库，指派时间为当前系统时间。当信息填写完整后，点击“保存”按钮提交数据到
		数据库，成功后返回销售机会列表页面并更新。
	 -->
</head>
<body>
<% 
	String datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()); //获取系统时间 
	request.setAttribute("currentTime",datetime);
%>
	<form action="${pageContext.request.contextPath }/saleChance_add.action" method="post">
		<button>关于</button>
		<a href="${pageContext.request.contextPath }/saleChance_listpage.action?currentPage=${currentPage}">返回</a>
		<input type="submit" value="保存">
		
		<!-- 该隐藏项是为了将记录的主键值通过模型驱动的方式传递给action中的方法 -->
		<input type="hidden" name="chan_no" value="${saleChance.chan_no}">
		
		<table border="1px" cellpadding="10" cellspacing="1">
			<tr>
				<td style="color:black; background-color:blue; ">
					客户名称
				</td>
				<td>
					<input type="text" name="chan_cust_name">
				</td>
				<td style="color: red;">
					*必填项
				</td>
				<td style="color:black; background-color:blue; ">
					负责人
				</td>
				<td>
					<input type="text" name="chan_linkman">
				</td>
				<td style="color: red;">
					*必填项
				</td>
			</tr>
			<tr>
				<td style="color:black; background-color:blue; ">
					机会来源
				</td>
				<td>
					<input type="text" name="chan_source">
				</td>
				<td style="color:black; background-color:blue; ">
					成功几率
				</td>
				<td>
					<input type="text" name="chan_rate">
				</td>
				<td style="color: red;">*必填项</td>
			</tr>
			<tr>
				<td style="color:black; background-color:blue; ">
				公司电话
				</td>
				<td>
				<input type="text" name="chan_telephone">
				</td>
				<td style="color: red;">*必填项</td>
				<td style="color:black; background-color:blue; ">
				客户等级
				</td>
				<!-- 需要从数据库中获取 -->
				<td>
					<select name="customer.cust_level">
						<option value="">---请选择---</option>
						<c:forEach items="${mapLevel}" var="map">
							<option value="${map.key }">${map.value}</option>
						</c:forEach>
					</select>
				</td>
				<td style="color: red;">*</td>
			</tr>
			<tr>
				<td style="color:black; background-color:blue; ">
					概要
				</td>
				<td>
					<input type="text" width="" height="" name="chan_title">
				</td>
				<td style="color: red;">*必填项</td>
				<td style="color:black; background-color:blue; ">
					地区
				</td>
				<!-- 需要从数据库中获取 -->
				<td>
					<select name="customer.cust_region">
						<option value="">---请选择---</option>
						<c:forEach items="${mapRegion}" var="map">
							<option value="${map.key}">${map.value}</option>
						</c:forEach>
					</select>
				</td>
				<td style="color: red;">*</td>
			</tr>
			
			<tr>
				<td style="color:black; background-color:blue; ">机会描述</td>
				<td><input type="text" width="" height="" name="chan_description"></td>
				<td style="color: red;">*必填项</td>
			</tr>
			
			<tr>
				<td style="color:black; background-color:blue; ">指派给</td><!-- 所有的客户经理 -->
				<!-- 需要从数据库中获取 -->
				<td>
					<select name="chan_due_to">
						<option>---请选择---</option>
						<c:forEach items="${listManager }" var="manager">
							<option value="${manager}">${manager}</option>
						</c:forEach>
					</select>
				</td>
				<td style="color: red;">*</td>
				<td style="color:black; background-color:blue; ">指派时间</td>
				<td>
					<input type="text" name="chan_due_date" value="${currentTime }">
				</td>
				<td style="color: red;">*</td>
			</tr>
		</table>
	</form>
</body>
</html>