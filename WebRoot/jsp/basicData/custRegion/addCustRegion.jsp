<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新建客户地区</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/dictionary_addCustRegion2db.action" method="post">
	<input type="submit" value="保存">
	<input type="hidden" name="basi_type" value="地区">
	<!-- 1表示可编辑，0表示不可编辑 -->
	<input type="hidden" name="basi_editable" value="1">
	<input type="hidden" name="basi_flag" value="1">
	<input type="hidden" name="basi_value" value="${max_basi_valueOfCustRegion+1}">
	<table>
		<tr>
			<td>值</td>
			<td>
				<input type="text" name="basi_item">
			</td>
		</tr>
	</table>
</form>
</body>
</html>