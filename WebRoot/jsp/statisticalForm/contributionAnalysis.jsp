<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户贡献分析</title>
</head>
<body>
<form action="" method="post">
	
</form>
<table border="1px" cellpadding="10" cellspacing="1">
	<thead>
		<tr>
			<td>编号</td>
			<td>客户名称</td>
			<td>订单金额（元）</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${pageBean.list}" var="customer">
			<tr>
				<td>${customer.cust_no}</td>
				<td>${customer.cust_name}</td>
				<td>
					<c:forEach items="${custTotalMoney}" var="map">
						<c:if test="${map.key == customer.cust_no}">
							${map.value}
						</c:if>
					</c:forEach>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<div>
	共【<b>${pageBean.totalCount }</b>】条记录，共【<b>${pageBean.totalPage}</b>】页，当前第【<b>${pageBean.currentPage}</b>】
	<c:if test="${pageBean.currentPage != 1}">
		【<a href="${pageContext.request.contextPath }/statisticalForm_contributionAnalysis?currentPage=${pageBean.currentPage-1 }">前一页</a>】
	</c:if>
	
	<c:if test="${pageBean.currentPage != pageBean.totalPage}">
		【<a href="${pageContext.request.contextPath }/statisticalForm_contributionAnalysis?currentPage=${pageBean.currentPage+1 }">后一页</a>】
	</c:if>
</div>

<h1>客户关系统计图</h1>
<br><br>
<center>
 <img alt="jfreechart" src="statisticalForm_serviceAnalysis" style="display: none;"><img alt="加载中..." title="图片加载中..." src="http://statics.2cto.com/images/s_nopic.gif">
</center>
</body>
</html>