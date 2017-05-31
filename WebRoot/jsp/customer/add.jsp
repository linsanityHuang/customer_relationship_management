<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加客户信息</title>
</head>
<body>

<form action="${pageContext.request.contextPath }/customer_add.action" method="post">
	<table border="1px" cellpadding="10" cellspacing="1">
		<thead></thead>
		<tbody>
			<tr>
				<td>客户名称</td>
				<td><input type="text" name="cust_name"></td>
				<td>客户区域</td>
				<td><input type="text" name="cust_region"></td>
				<td>客户经理姓名</td>
				<td><input type="text" name="cust_manager_name"></td>
			</tr>
			<tr>
				<td>客户等级</td>
				<td><input type="text" name="cust_level"></td>
				<td>客户满意度</td>
				<td><input type="text" name="cust_satisfy"></td>
				<td>客户信用等级</td>
				<td><input type="text" name="cust_credit"></td>
			</tr>
			<tr>
				<td>客户地址</td>
				<td><input type="text" name="cust_address"></td>
				<td>邮政编码</td>
				<td><input type="text" name="cust_zip"></td>
				<td>传真</td>
				<td><input type="text" name="cust_fax"></td>
			</tr>
			<tr>
				<td>客户办公电话</td>
				<td><input type="text" name="cust_telephone"></td>
				<td>客户网址</td>
				<td><input type="text" name="cust_website"></td>
				<td>客户营业执照编号</td>
				<td><input type="text" name="cust_licenc_no"></td>
			</tr>
			<tr>
				<td>客户法人</td>
				<td><input type="text" name="cust_corporation"></td>
				<td>客户注册资金(万元)</td>
				<td><input type="text" name="cust_registered_capital"></td>
				<td>客户年营业额(万元)</td>
				<td><input type="text" name="cust_turnover"></td>
			</tr>
			<tr>
				<td>客户开户银行</td>
				<td><input type="text" name="cust_bank"></td>
				<td>客户银行账号</td>
				<td><input type="text" name="cust_bank_account"></td>
				<td>客户地税登记号</td>
				<td><input type="text" name="cust_local_tax_no"></td>
			</tr>
			<tr>
				<td>客户国税登记号</td>
				<td><input type="text" name="cust_national_tax_no"></td>
				<td>客户标识</td>
				<td colspan="1"><input type="text" name="cust_flag"></td>
			</tr>
		</tbody>
	</table>
	<table>
		<tr>
			<td><input type="submit" value="添加用户"></td>
			<td><input type="reset" value="重置信息"></td>
		</tr>
	</table>
</form>
</body>
</html>