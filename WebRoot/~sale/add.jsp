<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script src="../script/common.js"></script>
</head>
<body>
<% 
	String datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()); //获取系统时间 
	request.setAttribute("currentTime",datetime);
%>
<div class="page_title">销售机会管理&nbsp; &gt; 新建销售机会</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();">返回</button>
	<button class="common_button" onclick="add('list.html');">保存</button>  
</div>
<form action="${pageContext.request.contextPath }/saleChance_add.action" method="get">
	<table class="query_form_table">
		<tr>
			<th>客户名称</th>
			<td><input type="text" name="chan_cust_name"><span class="red_star">*</span></td>
			<th>联系人</th>
			<td><input type="text" name="chan_linkman" size="20" /><span class="red_star">*</span></td>
		</tr>
		<tr>
			<th>机会来源</th>
			<td>
				<input type="text" name="chan_source" size="20" />
			</td>
			<th>成功机率</th>
			<td><input type="text" name="chan_rate"><span class="red_star">*</span></td>
		</tr>	
		<tr>
			<th>联系人电话</th>
			<td><input type="text" name="chan_telephone" size="20" /><span class="red_star">*</span></td>
			<th>客户等级</th>
			<td>
				<select name="customer.cust_level">
					<option value="">---请选择---</option>
					<c:forEach items="${mapLevel}" var="map">
						<option value="${map.key }">${map.value}</option>
					</c:forEach>
				</select><span class="red_star">*</span>
			</td>
		</tr>
		<tr>
			<th>概要</th>
			<td><input name="T0" size="20" /><span class="red_star">*</span></td>
			<th>地区</th>
			<td>
				<select name="customer.cust_region">
					<option value="">---请选择---</option>
					<c:forEach items="${mapRegion}" var="map">
						<option value="${map.key}">${map.value}</option>
					</c:forEach>
				</select>
				<span class="red_star">*</span>
			</td>
		</tr>
		<tr>
			<th>机会描述</th>
			<td colspan="3"><textarea name="chan_description" rows="6" cols="50" name="S1"></textarea><span class="red_star">*</span></td>
		</tr>
	</table>
	<br />
	<table class="query_form_table" id="table1">
		<tr>
			<th>指派给</th>
			<td>
				<select name="chan_due_to">
					<option>---请选择---</option>
						<c:forEach items="${listManager }" var="manager">
							<option value="${manager}">${manager}</option>
						</c:forEach>
				</select> <span class="red_star">*</span></td>
			<th>指派时间</th>
			<td>
				<input id="t2" type="text" value="${currentTime }" name="chan_due_date" readonly size="20" /><span class="red_star">*</span></td>
		</tr>
	</table>
</form>
<script>
	setCurTime('t1');
	setCurTime('t2');
</script>
</body>
</html>