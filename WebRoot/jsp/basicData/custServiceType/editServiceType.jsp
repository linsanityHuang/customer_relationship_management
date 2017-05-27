<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑服务类型</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/dictionary_saveServiceType.action" method="post">
	<input type="submit" value="保存">
	<input type="hidden" name="basi_no" value="${dictionary.basi_no }">
	<table>
		<tr>
			<td>值</td>
			<td>
				<input type="text" name="basi_item" value="${dictionary.basi_item}">
			</td>
		</tr>
	</table>
</form>
</body>
</html>