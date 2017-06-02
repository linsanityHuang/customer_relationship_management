<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户关系管理系统</title>
<style type="text/css"> 
	a {text-decoration:none;} 
	a,a:visited {color:#000;background:inherit;} 
	body {margin:0;padding:20px;font:12px tahoma,宋体,sans-serif;} 
	dt {font-size:22px;font-weight:bold;margin:0 0 0 15px;} 
	dd {margin:0 0 0 15px;} 
	h4 {margin:0;padding:0;font-size:18px;text-align:center;} 
	p {margin:0;padding:0 0 0 18px;} 
	p a,p a:visited {color:#00f;background:inherit;}
	
	/*CNLTreeMenu Start*/ 
	.CNLTreeMenu img.s {cursor:pointer;vertical-align:middle;} 
	.CNLTreeMenu ul {padding:0;} 
	.CNLTreeMenu li {list-style:none;padding:0; font-size: 20px} 
	.Closed ul {display:none;} 
	.Child img.s {background:none;cursor:default;} 
	#CNLTreeMenu1 ul {margin:0 0 0 17px;} 
	#CNLTreeMenu1 img.s {width:20px;height:15px;} 
	#CNLTreeMenu1 .Opened img.s {background:url(http://www.zzsky.cn/effect/images/treemenu/opened1.gif) no-repeat 0 0;} 
	#CNLTreeMenu1 .Closed img.s {background:url(http://www.zzsky.cn/effect/images/treemenu/closed1.gif) no-repeat 0 0;} 
	#CNLTreeMenu1 .Child img.s {background:url(http://www.zzsky.cn/effect/images/treemenu/child1.gif) no-repeat 3px 5px;} 

/*CNLTreeMenu End*/

/*Temp CSS for View Demo*/ 
#CNLTreeMenu1,#CNLTreeMenu2,#CNLTreeMenu3 {float:left;width:249px;border:1px solid #99BEEF;background:#D2E4FC;color:inherit;margin:3px;padding:3px;} 
#CNLTreeMenu1,#CNLTreeMenu2 {padding-bottom:15px;} 
.ViewCode {clear:both;border:1px solid #FFB900;background:#FFFFCC;color:inherit;margin:3px;padding:3px;} 
.ViewCode h6 {color:#00f;} 
</style>

</head>
<body>
<table style="float: right">
	<tr>
		<td><b>当前用户：</b></td>
		<td><b>${user.user_name}(${user.sysRole.role_name})</b></td>
		<td><a href="${pageContext.request.contextPath}/user_loginOut.action" style="text-decoration: underline;"><b>退出系统</b></a></td>
	</tr>
</table>

<div class="CNLTreeMenu" id="CNLTreeMenu1">
<p><a id="AllOpen_1" href="#" onClick="MyCNLTreeMenu1.SetNodes(0);Hd(this);Sw('AllClose_1');">全部展开</a><a id="AllClose_1" href="#" onClick="MyCNLTreeMenu1.SetNodes(1);Hd(this);Sw('AllOpen_1');" style="display:none;">全部折叠</a></p> 
<ul> 
	<li class="Opened"><a href="#">客户关系管理系统</a> 
<ul>
<li><a href="#1">营销管理</a> 
	<ul> 
		<li>
			<a href="${pageContext.request.contextPath }/saleChance_listpage.action?currentPage=1">销售机会管理</a> 
		</li> 
	<!--Sub Node 3--> 
		<li>
			<a href="${pageContext.request.contextPath }/salePlan_showSalePlan.action?currentPage=1">客户开发计划</a>  
		</li> 
	</ul> 
</li> 
<!--Sub Node 2--> 
<li><a href="#1">客户管理</a> 
	<ul> 
		<li>
			<a href="${pageContext.request.contextPath }/customer_listpage.action?currentPage=1">客户信息管理</a>
		</li>
		<li>
			<a href="${pageContext.request.contextPath }/custLost_listpage.action?currentPage=1">客户流失管理</a>
		</li>
		<!--Sub Node 3--> 
	</ul> 
</li>
<li><a href="#1">服务管理</a> 
	<ul>
		<li>
			<a href="${pageContext.request.contextPath }/serviceManager_createService.action">服务创建</a>
		</li>
		<li>
			<a href="${pageContext.request.contextPath }/serviceManager_due_to_service.action?currentPage=1">服务分配</a>
		</li>
		<li>
			<a href="${pageContext.request.contextPath }/serviceManager_handleService.action?currentPage=1">服务处理</a>
		</li>
		<li>
			<a href="${pageContext.request.contextPath }/serviceManager_feedBackService.action?currentPage=1">服务反馈</a>
		</li>
		<li>
			<a href="${pageContext.request.contextPath }/serviceManager_fileService.action?currentPage=1">服务归档</a>
		</li>
		<!--Sub Node 3--> 
	</ul> 
</li> 
<li><a href="#1">统计报表</a> 
	<ul> 
		<li>
			<a href="${pageContext.request.contextPath }/statisticalForm_contributionAnalysis.action?currentPage=1">客户贡献分析</a>
		</li>
		<li>
			<a href="${pageContext.request.contextPath }/salePlan_showSalePlan.action?currentPage=1">客户构成分析</a>
		</li>
		<li>
			<a href="${pageContext.request.contextPath }/statisticalForm_serviceAnalysis.action?currentPage=1">客户服务分析</a>
		</li>
		<li>
			<a href="${pageContext.request.contextPath }/salePlan_showSalePlan.action?currentPage=1">客户流失分析</a>
		</li>
		<!--Sub Node 3--> 
	</ul> 
</li> 
<li><a href="#1">基础数据</a> 
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
		<!--Sub Node 3--> 
	</ul> 
</li>
<li><a href="#1">权限管理</a> 
	<ul> 
		<li>
			<a href="${pageContext.request.contextPath}/user_listpage.action?currentPage=1" target=iframe>用户管理</a>
		</li>
		<li>
			<a href="${pageContext.request.contextPath}/role_listpage.action?currentPage=1" target=iframe>角色管理</a>
		</li>
		<!--Sub Node 3--> 
	</ul> 
</li>
<!--Sub Node 2--> 
</ul> 
</li> 
<!--Sub Node 1 --> 
</ul> 
</div> 
<!-- CNLTreeMenu --> 
<!--CNLTreeMenu1 End!-->
<div>
	<iframe name=iframe width=800 height=500 frameborder=0 scrolling=auto></iframe>
</div>

<script type="text/javascript">
<!-- 
	function Ob(o){
		var o=document.getElementById(o)?document.getElementById(o):o; 
		return o; 
	}
	
	function Hd(o) {
		Ob(o).style.display="none"; 
	}
	
	function Sw(o) {
		Ob(o).style.display=""; 
	}
	
	function ExCls(o,a,b,n){ 
		var o=Ob(o); 
		for(i=0;i<n;i++) {o=o.parentNode;} 
		o.className=o.className==a?b:a; 
	} 
	
	function CNLTreeMenu(id,TagName0) { 
		this.id=id; 
		this.TagName0=TagName0==""?"li":TagName0; 
		this.AllNodes = Ob(this.id).getElementsByTagName(TagName0); 
		
		this.InitCss = function (ClassName0,ClassName1,ClassName2,ImgUrl) { 
			this.ClassName0=ClassName0; 
			this.ClassName1=ClassName1; 
			this.ClassName2=ClassName2; 
			this.ImgUrl=ImgUrl || "http://www.zzsky.cn/effect/images/treemenu/s.gif"; 
			this.ImgBlankA ="<img src=\""+this.ImgUrl+"\" class=\"s\" onclick=\"ExCls(this,'"+ClassName0+"','"+ClassName1+"',1);\" alt=\"展开/折叠\" />"; 
			this.ImgBlankB ="<img src=\""+this.ImgUrl+"\" class=\"s\" />"; 
			
			for (i=0;i<this.AllNodes.length;i++ ) {
				this.AllNodes[i].className==""?this.AllNodes[i].className=ClassName1:""; 
				this.AllNodes[i].innerHTML=(this.AllNodes[i].className==ClassName2?this.ImgBlankB:this.ImgBlankA)+this.AllNodes[i].innerHTML; 
			} 
		};
		
		this.SetNodes = function (n) {
			var sClsName=n==0?this.ClassName0:this.ClassName1; 
			for (i=0;i<this.AllNodes.length;i++ ) {
				this.AllNodes[i].className==this.ClassName2?"":this.AllNodes[i].className=sClsName; 
			} 
		};
	} 
	var MyCNLTreeMenu1=new CNLTreeMenu("CNLTreeMenu1","li");
	MyCNLTreeMenu1.InitCss("Opened","Closed","Child","http://www.zzsky.cn/effect/images/treemenu/s.gif");
--> 
</script>
</body>
</html>