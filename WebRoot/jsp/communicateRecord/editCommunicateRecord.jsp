<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑交往记录</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/communicateRecord_updateCommunicateRecord.action" method="post">
		<input type="button" value="关于">
		<input type="button" value="返回">
		<input type="submit" value="保存">
		<!-- 该隐藏项是为了将记录的主键值通过模型驱动的方式传递给action中的方法 -->
		<input type="hidden" name="comm_no" value="${communicateRecord.comm_no}">
		<input type="hidden" name="comm_cust_no.cust_no" value="${communicateRecord.comm_cust_no.cust_no}">
		<input type="hidden" name="comm_flag" value="1">
		<table border="1px" cellpadding="10" cellspacing="1">
			<tr>
				<td>时间</td>
				<td><input type="text" name="comm_date" value="${communicateRecord.comm_date }"></td>
				<td style="color: red">*</td>
				<td>地点</td>
				<td><input type="text" name="comm_address" value="${communicateRecord.comm_address }"></td>
				<td style="color: red">*</td>
			</tr>
			<tr>
				<td>概要</td>
				<td><input type="text" name="comm_title" value="${communicateRecord.comm_title }"></td>
				<td style="color: red">*</td>
				<td>备注</td>
				<td><input type="text" name="comm_remark" value="${communicateRecord.comm_remark }"></td>
				<td></td>
			</tr>
			<tr>
				<td>详细信息</td>
				<td><input type="text" name="comm_detail" value="${communicateRecord.comm_detail }"></td>
				<td></td>
			</tr>
		</table>
	</form>
</body>
</html>