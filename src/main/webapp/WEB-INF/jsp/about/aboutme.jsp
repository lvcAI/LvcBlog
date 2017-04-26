<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  

<!DOCTYPE html>

<html lang="zh-CN">
<script
	src="chrome-extension://eojeoeddgeaeahpmfabdfpfialkoplcb/_locales/en/Kernel.js?0.5383648139636812"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge">


<jsp:include page="../common/resource.jsp"></jsp:include>
<title>关于我 | iLvc | Lvc唯爱</title>

</head>
<body class="home-template">

<!-- start header -->
	<jsp:include page="../common/head.jsp"></jsp:include>
	<!-- end navigation -->


	<!-- start site's main content area -->
	<section class="content-wrap">
		<div class="container">
			<div class="row">

			<aside class="col-md-2 sidebar">
					&nbsp;&nbsp;&nbsp;&nbsp;
					<p>&nbsp;</p>
					
					</aside>
					

				<main class="col-md-8 main-content">

					
					<div class="cover author-cover">
					    <div class="avatar-wrap">
					           <img src="${pageContext.request.contextPath}/resources/img/logoko.png" width="10%" height="10%" alt="iLvc 开源博客平台" alt="彭佳成" class="avatar" />
					    </div>
					    <h3 class="author-name">
					        作者：彭佳成 
					    </h3>
					    <div class="meta-info">
					        <span class="post-count"><i class="fa fa-pencil-square-o"></i>99+ 篇文章</span>
					        <span class="loaction"><i class="fa fa-map-marker"></i>南昌</span>
					        <span class="website"><i class="fa fa-globe"></i><a href="http://pjc.party" targer="_BLANK">个人网站 | 博客</a></span>
					    </div>
					    <div class="bio"></div>
					</div>
					


				</main>

				<aside class="col-md-2 sidebar">
					<!-- start widget -->
					<!-- end widget -->

					<!-- start tag cloud widget -->
					
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