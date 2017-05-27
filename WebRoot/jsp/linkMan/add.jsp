<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 使用struts2的fileupload组件实现文件上传 -->
<form action="${pageContext.request.contextPath }/linkMan_addLinkMan.action"
method="post" enctype="multipart/form-data">
	<table>
		<thead>添加联系人信息</thead>
		<tbody>
			<tr>
				<!-- 把域对象中所有客户的list显示到下拉列表中 -->
				<td>所属客户：</td>
				<td>
					<!-- 表示的是将该处的数据放入到CustLinkMan中Customer类型的属性中 -->
					<select name="link_cust_no.cust_no">
						<c:forEach var="customer" items="${listcusCustomer }">
							<!-- 提交的时候传递的是value中的数据 -->
							<option value="${customer.cust_no}">${customer.cust_name}</option>
						</c:forEach>
					</select>
				</td>
				
				
				<td>联系人名称：<input type="text" name="link_name"></td>
				<td>联系人性别：<input type="radio" name="link_sex" value="0">男<input type="radio" name="link_sex" value="1">女</td>
			</tr>
			<tr>
				<td>联系人职位：<input type="text" name="link_position"></td>
				<td>联系人办公电话：<input type="text" name="link_telephone"></td>
				<td>联系人手机号码：<input type="text" name="link_mobile"></td>
			</tr>
			<tr>
				<td>联系人备注：<input type="text" name="link_remark"></td>
				<td>联系人标识（0:已删除/1:未删除）, 非空：<input type="text" name="link_flag"></td>
			
			</tr>
			<tr>
				<td>选择文件<input type="file" name="upload"></td>
			</tr>
		</tbody>
	</table>
	<table>
		<tr>
			<td><input type="submit" value="添加联系人"></td>
			<td><input type="reset" value="重置信息"></td>
		</tr>
	</table>
</form>
</body>
</html>