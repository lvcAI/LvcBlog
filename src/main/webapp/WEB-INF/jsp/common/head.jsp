<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  

<script>

	function search(){
		if($("#q").val()!=null&&$("#q").val().trim()!=""){
			window.location.href="${pageContext.request.contextPath}/blog/post/q?q="+$("#q").val().trim();
		}else{
			alert("请输入关键字，后在搜索！");
		}
	}
	
$(document).ready(function(){
	$('.asearch').hover(function(){
		$('.search').show();
	});
	 $('#q').blur(function(){
		 if($("#q").val()!=null&&$("#q").val().trim()!=""){
				//alert("可以收索了");
			}else{
				$('.search').hide();
			}
		
	}); 
	$('.asearch').click(function(){
		if($("#q").val()!=null&&$("#q").val().trim()!=""){
			window.location.href="${pageContext.request.contextPath}/blog/post/q?q="+$("#q").val().trim();
		}else{
			alert("请输入关键字，后在搜索！");
		}
	});
});
</script>
<style type="text/css">
.search{
	position: absolute;
    top: 15px;
    margin-left: 50px;
}
/*页面自动生成了 一些，<code></code>  */
code {
     padding: 0 0; 
   /*  font-size: 90%;
    color: #c7254e;
    background-color: #f9f2f4;
    border-radius: 4px; */
    
}
</style>
	<!-- start header -->
	<header class="main-header"
		style="background-image: url(${pageContext.request.contextPath}/resources/img/xk.jpg);">
		<div class="container">
			<div class="row">
				<div class="col-sm-12">

					<!-- start logo -->
				<a class="branding" href="#" title="iLvc 开源博客平台">
				<img src="${pageContext.request.contextPath}/resources/img/ilogoko.png" width="10%" height="10%" alt="iLvc 开源博客平台"></a>
				<!-- end logo -->
				<h2 class="text-hide">Ghost
						lvcBlog</h2>

					<img src="${pageContext.request.contextPath}/resources/img/fcb3879e14429d75833a461572e64.jpg"
						alt="ilvc 博客系统" class="hide">
				</div>
			</div>
		</div>
	</header>
	<!-- end header -->

	<!-- start navigation -->
	<nav class="main-navigation">
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<div class="navbar-header">
						<span class="nav-toggle-button collapsed" data-toggle="collapse"
							data-target="#main-menu"> <span class="sr-only">Toggle
								navigation</span> <i class="fa fa-bars"></i>
						</span>
					</div>
					<div class="collapse navbar-collapse" id="main-menu">
						<ul class="menu">
							<li  <c:if test="${pageType==null }"> class="nav-current" </c:if> role="presentation"><a
								href="${pageContext.request.contextPath}/">首页</a></li>
							<li role="presentation" <c:if test="${pageType=='archive'}"> class="nav-current" </c:if>><a
								href="${pageContext.request.contextPath}/archive">归档</a></li> 
							<li role="presentation" <c:if test="${pageType=='categories'}"> class="nav-current" </c:if> ><a
								href="${pageContext.request.contextPath}/categories/categories-cloud">分类</a></li>
							<li role="presentation" <c:if test="${pageType=='tags'}"> class="nav-current" </c:if>> <a
								href="${pageContext.request.contextPath}/tags/tag-cloud" <c:if test="${pageType=='tags'}"> class="nav-current" </c:if> >标签</a></li>
							<li role="presentation"><a
								href="http://chunchuji.ilvc.me" target="_blank">诗集</a></li>
							<li role="presentation" <c:if test="${pageType=='guestBook'}"> class="nav-current" </c:if>><a
								href="${pageContext.request.contextPath}/guestBook" <c:if test="${pageType=='guestBook'}"> class="nav-current" </c:if> >留言本</a></li>
							<li role="presentation" <c:if test="${pageType=='link'}"> class="nav-current" </c:if>><a
								href="${pageContext.request.contextPath}/FAQ/links-could" title="问题与解决方案"  >收藏夹</a></li>
							<li role="presentation" <c:if test="${pageType=='about'}"> class="nav-current" </c:if>><a
								href="${pageContext.request.contextPath}/about" >关于</a></li>
							<li role="presentation"><a
								href="javascript:void(0);" class="asearch" title="点击即可搜索"><i class="fa fa-search"></i></a>
								<div class="search" style="display: none;float: left;">
									<form action="${pageContext.request.contextPath}/blog/post/q" method="get" onsubmit="javascript:search();return false;">
										<input type="search" name="q" id="q" placeholder="回车搜索...." style="height: 25px; border-radius: 20px 20px 20px 20px;padding: 5px;padding-left: 10px;"/>
									</form>
								</div>
							</li>	
						</ul>
					</div>
				</div>
			</div>
		</div>
	</nav>
	<!-- end navigation -->
	<!--  start notice -->
	<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<div class="huadong">
							<div class="notice_active">
								<c:if test="${app_notices!=null}">	<i id="volume" class="fa fa-volume-off" style="color:#e67e22; float: left; margin-top: 8px;width: 5px;" ></i></c:if>
								<ul style="margin-top: 0.3rem;">
									<c:forEach items="${app_notices}" var="notice"  >
										<li class="notice_active_ch">
											<span title="《${notice.bookname }》：${notice.title}"><c:if test="${notice.type==1}">【公告】&nbsp;&nbsp;</c:if><c:if test="${notice.type==0}">【开卷有益】&nbsp;&nbsp;</c:if>${notice.title}</span>
										</li>
									</c:forEach>
								</ul>
							</div>
						</div>
				</div>
			</div>
	</div>
	<!-- end notice  -->