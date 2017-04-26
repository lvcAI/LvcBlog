<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  


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
							<li class="nav-current" role="presentation"><a
								href="${pageContext.request.contextPath}/">首页</a></li>
							<%-- <li role="presentation"><a
								href="${pageContext.request.contextPath}/archive">归档</a></li> --%>
							<li role="presentation"><a
								href="${pageContext.request.contextPath}/categories/categories-cloud">分类</a></li>
							<li role="presentation"><a
								href="${pageContext.request.contextPath}/tags/tag-cloud">标签</a></li>
							<li role="presentation"><a
								href="${pageContext.request.contextPath}/guestBook">留言本</a></li>
							<li role="presentation"><a
								href="${pageContext.request.contextPath}/FAQ/links-could" title="问题与解决方案">收藏夹</a></li>
							<li role="presentation"><a
								href="${pageContext.request.contextPath}/about">关于</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</nav>
	<!-- end navigation -->