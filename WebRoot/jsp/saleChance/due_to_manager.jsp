<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>指派销售机会</title>
</head>
<body>
<% 
	String datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()); //获取系统时间 
	request.setAttribute("currentTime",datetime);
%>
	<form action="${pageContext.request.contextPath }/saleChance_due_to_manager_update.action" method="post">
	<a href="${pageContext.request.contextPath }/saleChance_listpage.action?currentPage=${currentPage}">返回</a>
	<input type="submit" value="保存">
		<!-- 该隐藏项是为了将记录的主键值通过模型驱动的方式传递给action中的方法 -->
		<input type="hidden" name="chan_no" value="${saleChance.chan_no}">
		<table border="1px" cellpadding="10" cellspacing="1">
			<tr>
				<td>编号</td>
				<td>${saleChance.chan_no }</td>
				<td>机会来源</td>
				<td>${saleChance.chan_source }"</td>
			</tr>
			
			<tr>
				<td>客户名称</td>
				<td>${saleChance.chan_cust_name }</td>
				<td>成功几率</td>
				<td>${saleChance.chan_rate }</td>
			</tr>
			
			<tr>
				<td>概要</td>
				<td>${saleChance.chan_title }</td>
			</tr>
			
			<tr>
				<td>负责人</td>
				<td>${saleChance.chan_linkman }</td>
				<td>公司电话</td>
				<td>${saleChance.chan_telephone }</td>
			</tr>
			
			<tr>
				<td>机会描述</td>
				<td>${saleChance.chan_description }</td>
			</tr>
			<tr>
				<td>指派给</td><!-- 所有的客户经理 -->
				<!-- 需要从数据库中获取 -->
				<td>
					<select name="chan_due_to">
						<option>---请选择---</option>
						<c:forEach items="${listManager}" var="manager">
							<option value="${manager}">${manager}</option>
						</c:forEach>
					</select>
				</td>
				<td>指派时间</td>
				<td><input type="text" name="chan_due_date" value="${currentTime }"></td>
			</tr>
		</table>
	</form>
</body>
</html>