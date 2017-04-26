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

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/monokai_sublime.min.css">
<link href="${pageContext.request.contextPath}/resources/css/magnific-popup.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/screen.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/screen.css">

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

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

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/img/css/share_style0_24.css">
</head>
<body class="home-template">
	<!-- start headr and navcation  -->
	<jsp:include page="../common/head.jsp"></jsp:include>
	
	<!-- start site's main content area -->
	<section class="content-wrap">
		<div class="container">
			<div class="row">

				<main class="col-md-8 main-content">
	
				
					<div class="cover tag-cover">
					    <h3 class="tag-name">
					        归档
					    </h3>
					    <div class="post-count">
					        共 99+ 篇文章
				    	</div>
				    </div>
		<c:forEach items="${tagByPost.posts}" var="post" >
			
			</c:forEach> 
				
				</main>

				<aside class="col-md-4 sidebar">
					<!-- start widget -->
					<!-- end widget -->

					<jsp:include page="../common/aside.jsp"></jsp:include>

					<!-- start widget -->
					<!-- end widget -->

					<!-- start widget -->
					<!-- end widget -->
				</aside>

			</div>
		</div>
	</section>

	<jsp:include page="../common/footer.jsp"></jsp:include>

</body>
</html>