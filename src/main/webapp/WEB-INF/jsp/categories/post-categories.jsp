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
<title>${cateByPost.categoriesName} -- iLvc | Lvc唯爱</title>
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
					       分类：${cateByPost.categoriesName}
					    </h3>
					    <div class="post-count">
					        共 ${cateByPost.posts.size()} 篇文章
				    	</div>
				    </div>
		<c:forEach items="${cateByPost.posts}" var="post"  begin="${pageBean.start }" end="${pageBean.start+pageBean.pageSize-1}">
			
				<article  class="post">

					<div class="post-head">
						<h1 class="post-title">
							<a href="${pageContext.request.contextPath}/blog/post/${post.id}">${post.title}</a>
						</h1>
						<div class="post-meta">
							<span class="author">作者：<a
								href="${pageContext.request.contextPath}/about">彭佳成</a></span> 
							<time class="post-date" > <i class="fa fa-calendar"></i> ${fn:substring(post.createDate,0,10)}</time>
								<span class="author">分类：<a href="${pageContext.request.contextPath}/categories/${post.categories.categoriesName}">${post.categories.categoriesName}</a></span>
						</div>
					</div>
					<div class="post-content">
						${fn:substring(post.html,0,500)}
					</div>
					<div class="post-permalink">
						<a href="${pageContext.request.contextPath}/blog/post/${post.id}"
							class="btn btn-default">阅读全文</a>
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
			
			</c:forEach> 
				
				<!-- start nav -->
					${navPage}
				
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
	<!--start footer copyright  -->
	<jsp:include page="../common/footer.jsp"></jsp:include>

	

</body>
</html>