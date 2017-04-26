<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<!DOCTYPE html>

<html lang="zh-CN">
<script
	src="chrome-extension://eojeoeddgeaeahpmfabdfpfialkoplcb/_locales/en/Kernel.js?0.5383648139636812"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>LvcBlog</title>
<meta name="description" content="LvcBlog">
<meta name="keywords" content="LvcBlog blog ilvc lvc">

<meta name="HandheldFriendly" content="True">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/img/favicon.ico">

<link rel="stylesheet" href="../../resources/css/bootstrap.min.css">
<link rel="stylesheet" href="../../resources/css/font-awesome.min.css">
<link rel="stylesheet" href="../../resources/css/monokai_sublime.min.css">
<link href="../../resources/css/magnific-popup.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="../../resources/css/screen.css">
<script type="text/javascript" src="../../resources/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="../../resources/js/bootstrap.min.js"></script>

<style id="fit-vids-style">
.fluid-width-video-wrapper {
	width: 100%;
	position: relative;
	padding: 0;
}

.fluid-width-video-wrapper iframe, .fluid-width-video-wrapper object,
	.fluid-width-video-wrapper embed {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
}
</style>

<link rel="stylesheet" href="../../resources/img/css/share_style0_24.css">
</head>
<body class="home-template">

	<!-- start header -->
	<!-- start headr and navcation  -->
			<jsp:include page="../common/head.jsp"></jsp:include>
	<!-- end navigation -->


	<!-- start site's main content area -->
	<section class="content-wrap">
		<div class="container">
			<div class="row">

				<main class="col-md-8 main-content">

			
			
				<article id="98" class="post">

					<div class="post-head">
						<h1 class="post-title">
							<a href="#">${post.title}</a>
						</h1>
						<div class="post-meta">
							<span class="author">作者：${post.user.userName}<a
								href="${pageContext.request.contextPath}/about"></a></span> • 
							<time class="post-date" 
								title="${post.createDate}">${fn:substring(post.createDate,0,10)}</time>
								<span class="author">分类：<a href="${pageContext.request.contextPath}/categories/${post.categories.categoriesName}">${post.categories.categoriesName}</a></span>
						</div>
					</div>
					<div class="post-content">
						 ${post.html}
					</div>
					

					<footer class="post-footer clearfix">
						<div class="pull-left tag-list">
							<i class="fa fa-folder-open-o"></i>
							<c:forEach items="${post.tags }" var="tag">
								<a href="${pageContext.request.contextPath}/tags/${tag.tagName}">${tag.tagName}</a>
							</c:forEach>
							
						</div>
						<div class="pull-right share"></div>
					</footer>
					
				</article>
			
		

				
				

			<!-- nav start  -->
			 ${navPage}
			<%-- 	<nav class="pagination" role="navigation">
					<a class="older-posts" href="${pageContext.request.contextPath}/blog/post/2" style="text-decoration: none;  padding-right: 18px;">
						<i	class="fa fa-angle-left"></i>上一篇
					</a>
					<a class="older-posts" href="${pageContext.request.contextPath}/blog/post/2" style="text-decoration: none;  padding-right: 18px;">
						<i	class="fa fa-angle-right"></i>下一篇
					</a>
				</nav>
 --%>

				</main>

				<aside class="col-md-4 sidebar">
					<!-- start widget -->
					<!-- end widget -->

					<!-- start tag cloud widget -->
					<jsp:include page="../common/aside.jsp"></jsp:include>
					<!-- end tag cloud widget -->

					<!-- start widget -->
					<!-- end widget -->

					<!-- start widget -->
					<!-- end widget -->
				</aside>

			</div>
		</div>
	</section>

	<!--start footer copyright  -->
	<jsp:include page="../common/footer.jsp"></jsp:include>

</body>
</html>