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
<title>${pageTitle}</title>
</head>
<body class="home-template">

	<!-- start header -->
	<jsp:include page="../common/head.jsp"></jsp:include>
	<!-- end navigation -->


	<!-- start site's main content area -->
	<section class="content-wrap">
		<div class="container">
			<div class="row">

				<main class="col-md-8 main-content">

				<article class="post page">
					<header class="post-head">
						<h1 class="post-title">SEARCH</h1>
						  搜索 <span style="color:red;"><b>${q} </b></span>  共 ${resultTotal} 个结果
					</header>
				</article>

				<!-- start  search result -->
					
				<c:choose>
					<c:when test="${blogList.size()==0 }">
						
						<article class="post page">
				 			<header class="post-head">
						        <h1 class="post-title"></h1>
						    </header>			
						    <section class="post-content widget">
						    	<div class="tag-cloud">
									<div align="center" style="padding-top: 20px">未查询到结果，请换个关键字试试看！</div>
						        </div>
						    </section>					
						</article>
					</c:when>
					<c:otherwise>
						<c:forEach var="blog" items="${blogList }">
						  <article class="post page">
				 			<header class="post-head">
						        <h1 class="post-title">${blog.title }</h1>
						    </header>			
						    <section class="post-content widget">
						    	<div class="tag-cloud">
<%-- 								<span class="title"><a href="${pageContext.request.contextPath}/blog/post/${blog.id}" target="_blank">${blog.title }</a></span>
 --%>						  		<span class="summary">摘要: ${blog.content }...</span>
						  		<span class="link"><a href="${pageContext.request.contextPath}/blog/post/${blog.id}">http://ilvc.me/blog/post/${blog.id}</a>&nbsp;&nbsp;&nbsp;&nbsp;发布日期:${blog.releaseDate }</span>
						        </div>
						    </section>					
						</article>
						  
						</c:forEach>
					</c:otherwise>
				</c:choose>
				<!-- end  search result -->
				<!-- start   page  nav -->
					${navPage}							
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

	<!-- start footer and copyright -->
	<jsp:include page="../common/footer.jsp"></jsp:include>

</body>
</html>