<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>确认流失</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/custLost_updateConfirmLost.action?lost_no=${custLost.lost_no}" method="post">
	<input type="button" value="关于">
	<input type="button" value="返回">
	<input type="button" value="确认流失">
	<input type="submit" value="保存">
	<table border="1px" cellpadding="10" cellspacing="1">
		<tr>
			<td>编号</td>
			<td>${custLost.lost_no}</td>
			<td>客户名称</td>
			<td>${custLost.lost_cust_no.cust_name}</td>
		</tr>
		<tr>
			<td>客户经理</td>
			<td>${custLost.lost_manager_name}</td>
			<td>上次下单时间</td>
			<td>${custLost.lost_last_order_date}</td>
		</tr>
		<tr>
			<td>暂缓措施</td>
			<td>${custLost.lost_delay}</td>
		</tr>
		<tr>
			<td>流失原因</td>
			<td>
				<textarea rows="5" cols="25" name="lost_reson"></textarea>
			</td>
		</tr>
	</table>
</form>
</body>
</html>