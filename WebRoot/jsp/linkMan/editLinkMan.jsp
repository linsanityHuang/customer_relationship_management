<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑交往记录</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/linkMan_updateLinkMan.action" method="post">
		<input type="button" value="关于">
		<input type="button" value="返回">
		<input type="submit" value="保存">
		<!-- 该隐藏项是为了将记录的主键值通过模型驱动的方式传递给action中的方法 -->
		<input type="hidden" name="link_no" value="${linkMan.link_no}">
		<input type="hidden" name="link_cust_no.cust_no" value="${linkMan.link_cust_no.cust_no}">
		<input type="hidden" name="link_flag" value="1">
		<table border="1px" cellpadding="10" cellspacing="1">
			<tr>
				<td>姓名</td>
				<td><input type="text" name="link_name" value="${linkMan.link_name }"></td>
				<td style="color: red">*</td>
				<td>性别</td>
				<td>
					<input type="radio" value="0" name="link_sex" 
						<c:if test="${linkMan.link_sex == 0 }">checked="checked"</c:if>
					>男
					<input type="radio" value="1" name="link_sex" <c:if test="${linkMan.link_sex == '1' }">checked="checked"</c:if>>女
				</td>
				<td></td>
			</tr>
			<tr>
				<td>职位</td>
				<td><input type="text" name="link_position" value="${linkMan.link_position }"></td>
				<td style="color: red">*</td>
				<td>办公电话</td>
				<td><input type="text" name="link_telephone" value="${linkMan.link_telephone }"></td>
				<td style="color: red">*</td>
			</tr>
			<tr>
				<td>手机</td>
				<td><input type="text" name="link_mobile" value="${linkMan.link_mobile }"></td>
				<td></td>
				<td>备注</td>
				<td><input type="text" name="link_remark" value="${linkMan.link_remark }"></td>
				<td></td>
			</tr>
		</table>
	</form>
<%-- <table>
	<tr>
		<td>所属客户：<input type="text" name="" value="${custLinkMan.link_cust_no.cust_name }">
			<select name="customer.cust_no">
				<c:forEach items="${listCustomers}" var="customer">
					<!-- 判断当前联系人所属客户id和所有客户id比较，如果相同则为选中状态（即设置默认选项） -->
				
					<option value="${customer.cust_no }" <c:if test="${customer.cust_no == custLinkMan.link_cust_no.cust_no}">selected</c:if>>${customer.cust_name }</option>
				</c:forEach>
			</select>
		</td>
		<td>联系人名称：<input type="text" name="link_name" value="${custLinkMan.link_name }"></td>
		<td>联系人性别：
			<input type="radio" value="0" name="link_sex" <c:if test="${custLinkMan.link_sex == '0' }">checked</c:if>>男
			<input type="radio" value="1" name="link_sex" <c:if test="${custLinkMan.link_sex == '1' }">checked</c:if>>女
		</td>
		<td>联系人职位：<input type="text" name="link_position" value="${custLinkMan.link_position }"></td>
		<td>联系人办公电话：<input type="text" name="link_telephone" value="${custLinkMan.link_telephone }"></td>
		<td>联系人手机号码：<input type="text" name="link_mobile" value="${custLinkMan.link_mobile }"></td>
		<td>联系人备注：<input type="text" name="link_remark" value="${custLinkMan.link_remark }"></td>
	</tr>
</table> --%>
</body>
</html>