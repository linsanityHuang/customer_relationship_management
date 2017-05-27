<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户关系管理系统</title>
</head>
<body>
<table>
	<tr>
		<td>当前用户：</td>
		<td>${user.user_name}(${user.sysRole.role_name})</td>
		<td><a href="${pageContext.request.contextPath}/user_loginOut.action">退出系统</a></td>
	</tr>
</table>

<div>
	<h3>营销管理</h3>
	<ul>
		<li>
			<a href="${pageContext.request.contextPath }/saleChance_listpage.action?currentPage=1">销售机会管理</a>
		</li>
		<li>
			<a href="${pageContext.request.contextPath }/salePlan_showSalePlan.action?currentPage=1">客户开发计划</a>
		</li>
	</ul>
	
	<h3>客户管理</h3>
	<ul>
		<li>
			<a href="${pageContext.request.contextPath }/customer_listpage.action?currentPage=1">客户信息管理</a>
		</li>
		<li>
			<a href="">客户流失管理</a>
		</li>
	</ul>
	
	<h3>服务管理</h3>
	<ul>
		<li>
			<a href="${pageContext.request.contextPath }/saleChance_listpage.action?currentPage=1">服务创建</a>
		</li>
		<li>
			<a href="${pageContext.request.contextPath }/salePlan_showSalePlan.action?currentPage=1">服务分配</a>
		</li>
		<li>
			<a href="${pageContext.request.contextPath }/salePlan_showSalePlan.action?currentPage=1">服务处理</a>
		</li>
		<li>
			<a href="${pageContext.request.contextPath }/salePlan_showSalePlan.action?currentPage=1">服务反馈</a>
		</li>
		<li>
			<a href="${pageContext.request.contextPath }/salePlan_showSalePlan.action?currentPage=1">服务归档</a>
		</li>
	</ul>
	
	<h3>统计报表</h3>
	<ul>
		<li>
			<a href="${pageContext.request.contextPath }/saleChance_listpage.action?currentPage=1">客户贡献分析</a>
		</li>
		<li>
			<a href="${pageContext.request.contextPath }/salePlan_showSalePlan.action?currentPage=1">客户构成分析</a>
		</li>
		<li>
			<a href="${pageContext.request.contextPath }/salePlan_showSalePlan.action?currentPage=1">客户服务分析</a>
		</li>
		<li>
			<a href="${pageContext.request.contextPath }/salePlan_showSalePlan.action?currentPage=1">客户流失分析</a>
		</li>
	</ul>
	
	<h3>基础数据</h3>
	<ul>
		<li>
			<a href="${pageContext.request.contextPath}/dictionary_showCustLevel.action?currentPage=1">客户等级管理</a>
		</li>
		<li>
			<a href="${pageContext.request.contextPath}/dictionary_showServiceType.action?currentPage=1">服务类型管理</a>
		</li>
		<li>
			<a href="${pageContext.request.contextPath}/dictionary_showCustRegion.action?currentPage=1">客户地区管理</a>
		</li>
		<li>
			<a href="${pageContext.request.contextPath}/product_showProduct.action?currentPage=1">查询产品信息</a>
		</li>
		<li>
			<a href="${pageContext.request.contextPath}/storage_showStorage.action?currentPage=1">查询库存</a>
		</li>
	</ul>
	
	<h3>权限管理</h3>
	<ul>
		<li>
			<a href="${pageContext.request.contextPath}/user_listpage.action?currentPage=1">用户管理</a>
		</li>
		<li>
			<a href="${pageContext.request.contextPath}/role_listpage.action?currentPage=1">角色管理</a>
		</li>
	</ul>
</div>


<%-- <a href="${pageContext.request.contextPath }/customer_toAddPage.action">新增客户</a>
<a href="${pageContext.request.contextPath }/customer_list.action">客户列表</a>
<a href="${pageContext.request.contextPath }/customer_listpage.action?currentPage=1">分页客户列表</a><br>
<a href="${pageContext.request.contextPath }/linkMan_toAddPage.action">新增联系人</a>
<a href="${pageContext.request.contextPath }/linkMan_list.action">联系人列表</a><br>
<a href="${pageContext.request.contextPath }/visit_toAddPage.action">新增客户拜访</a>
<a href="${pageContext.request.contextPath }/visit_list.action">客户拜访列表</a><br>

<a href="${pageContext.request.contextPath }/customer_toSelectCustomerPage.action">客户信息查询</a>
<a href="${pageContext.request.contextPath }/linkMan_toSelectPage.action">联系人信息查询</a><br>

<a href="${pageContext.request.contextPath }/customer_countManager.action">客户经理统计</a>
<a href="${pageContext.request.contextPath }/customer_countLevel.action">客户级别统计</a> --%>
</body>
</html>