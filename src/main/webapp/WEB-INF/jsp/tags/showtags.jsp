<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<!DOCTYPE html>

<html lang="zh-CN">
<script
	src="chrome-extension://eojeoeddgeaeahpmfabdfpfialkoplcb/_locales/en/Kernel.js?0.5383648139636812"></script>
<head>
<jsp:include page="../common/resource.jsp"></jsp:include>
<title>标签云  -- iLvc | Lvc唯爱</title>

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
	
					<div class="cover tag-cover">
					    <h3 class="tag-name">
					        标签
					    </h3>
					    <div class="post-count">
					       共 ${allTags.size()}个标签
				    	</div>
				    </div>
					
					<article class="post page">
			 			<header class="post-head">
					        <h1 class="post-title"></h1>		         
					    </header>		  
					    <section class="post-content widget">
					    	<div class="tag-cloud">
					          <c:forEach items="${allTags}" var="tag">
					          		<a href="${pageContext.request.contextPath}/tags/${tag.tagName }">${tag.tagName }</a>			
					          </c:forEach>
					            
					        </div>
					    </section>					
					</article>
															
				</main>

				<aside class="col-md-4 sidebar">
					<!-- start widget -->
					<!-- end widget -->

					<!-- start tag cloud widget -->
					<jsp:include page="../common/aside.jsp"></jsp:include>
					<!-- end tag cloud widget -->


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