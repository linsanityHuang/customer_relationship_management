<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑客户信息</title>
<script type="text/javascript">
	function update() {
		var url = document.getElementById("update");
		window.location.href = url;
	}
	
	function isUpdateSuccsee() {
		
	}
</script>
</head>
<body>
<h1>客户信息</h1>
<input type="button" value="关于" onclick="">
<input type="button" value="联系人" onclick="">
<input type="button" value="交往记录" onclick="">
<input type="button" value="历史订单" onclick="">
<input type="button" value="返回" onclick="">
<input type="button" value="保存" onclick="update()">

	<!-- form表单可以不用 -->
	<form action="${pageContext.request.contextPath }/customer_update.action" method="post">
	<input type="hidden" id="update" value="${pageContext.request.contextPath }/customer_update.action">
	
	<!-- 获取更新结果 -->
	<input type="hidden" id="flag" value="${flag}">
	<!-- 设置其他信息 -->
	<input type="hidden" name="cust_flag" value="1">
		<table border="1px" cellpadding="10" cellspacing="1">
			<tr>
				<td>客户姓名</td>
				<td><input type="text" name="cust_name" value="${customer.cust_name }"></td>
				<td>客户编号</td>
				<td><input type="text" name="cust_no" value="${customer.cust_no }"></td>
			</tr>
			<tr>
				<td>地区</td>
				<td>
					<select name="cust_region">
						<c:forEach items="${mapRegion}" var="map">
							<option value="${map.key}" <c:if test="${map.key eq customer.cust_region}">selected="selected"</c:if>>
								${map.value}
							</option>
						</c:forEach>
					</select>
				</td>
				<td>负责人</td>
				<td><input type="text" name="cust_manager_name" value="${customer.cust_manager_name }"></td>
			</tr>
			<tr>
				<td>客户等级</td>
				<td>
					<select name="cust_level">
						<c:forEach items="${mapLevel}" var="map">
							<option value="${map.key}" <c:if test="${map.key eq customer.cust_level}">selected="selected"</c:if>>
								${map.value}
							</option>
						</c:forEach>
					</select>
				</td>
				<td>客户信誉度</td>
				<td>
					<select name="cust_credit">
						<c:forEach items="${mapCredit}" var="map">
							<option value="${map.key}" <c:if test="${map.key eq customer.cust_credit}">selected="selected"</c:if>>
								${map.value}
							</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>客户满意度</td>
				<td>
					<select name="cust_satisfy">
						<c:forEach items="${mapSatisfy}" var="map">
							<option value="${map.key}" <c:if test="${map.key eq customer.cust_satisfy}">selected="selected"</c:if>>
								${map.value}
							</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>地址</td>
				<td><input type="text" name="cust_address" value="${customer.cust_address }"></td>
				<td>邮政编码</td>
				<td><input type="text" name="cust_zip" value="${customer.cust_zip }"></td>
			</tr>
			<tr>
				<td>电话</td>
				<td><input type="text" name="cust_telephone" value="${customer.cust_telephone }"></td>
				<td>传真</td>
				<td><input type="text" name="cust_fax" value="${customer.cust_fax }"></td>
			</tr>
			<tr>
				<td>网址</td>
				<td><input type="text" name="cust_website" value="${customer.cust_website }"></td>
			</tr>
			
			<tr>
				<td>营业执照注册号</td>
				<td><input type="text" name="cust_licenc_no" value="${customer.cust_licenc_no }"></td>
				<td>法人</td>
				<td><input type="text" name="cust_corporation" value="${customer.cust_corporation }"></td>
			</tr>
			<tr>
				<td>注册资金（万元）</td>
				<td><input type="text" name="cust_registered_capital" value="${customer.cust_registered_capital }"></td>
				<td>年营业额</td>
				<td><input type="text" name="cust_turnover" value="${customer.cust_turnover }"></td>
			</tr>
			<tr>
				<td>开户银行</td>
				<td><input type="text" name="cust_bank" value="${customer.cust_bank }"></td>
				<td>银行账号</td>
				<td><input type="text" name="cust_bank_account" value="${customer.cust_bank_account }"></td>
			</tr>
			<tr>
				<td>地税登记号</td>
				<td><input type="text" name="cust_local_tax_no" value="${customer.cust_local_tax_no }"></td>
				<td>国税登记号</td>
				<td><input type="text" name="cust_national_tax_no" value="${customer.cust_national_tax_no }"></td>
			</tr>
		</table>
	</form>
</body>
</html>