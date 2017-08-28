<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<!DOCTYPE html>

<html lang="zh-CN">

<head>
<title>首页 - iLvc | Lvc唯爱</title>
<jsp:include page="../common/resource.jsp"></jsp:include>
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
</head>
<body class="home-template">

	<!-- start header -->
	
	<jsp:include page="../common/head.jsp"></jsp:include>

	<!-- end header -->


	


	<!-- start site's main content area -->
	<section class="content-wrap">
		<div class="container">
			<div class="row">

				<main class="col-md-8 main-content">

			<c:forEach items="${postList}" var="post">
			
				<article  class="post">

					
						<div class="post-head">
							<h1 class="post-title">
								<a href="${pageContext.request.contextPath}/blog/post/${post.id}">${post.title}</a>
							</h1>
							<div class="post-meta">
								<span class="author"><a
									href="${pageContext.request.contextPath}/about"><i class="fa fa-user-md"></i>  ${post.user.userName}</a></span> • 
								<time class="post-date" 
									title="${post.createDate}"> <i class="fa fa-calendar"></i> ${fn:substring(post.createDate,0,10)}</time>
									<span class="author"><i class="fa fa-tags"></i> <a href="${pageContext.request.contextPath}/categories/${post.categories.categoriesName}">${post.categories.categoriesName}</a></span>
									<%-- <span><i class="fa fa-star" style="color: "></i> ${post.rate}</span> --%>
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
						
						<div class="pull-right share">
							<!-- JiaThis Button BEGIN -->
								<div class="jiathis_style">
									<span class="jiathis_txt">分享到：</span>
									<a class="jiathis_button_icons_1"></a>
									<a class="jiathis_button_icons_2"></a>
									<a class="jiathis_button_icons_3"></a>
									<a class="jiathis_button_icons_4"></a>
									<a href="http://www.jiathis.com/share" class="jiathis jiathis_txt jtico jtico_jiathis" target="_blank"></a>
									<a class="jiathis_counter_style"></a>
								</div>
								<script type="text/javascript" src="http://v3.jiathis.com/code/jia.js" charset="utf-8"></script>
								<!-- JiaThis Button END -->
						</div>
					</footer>
					
				</article>
			
			</c:forEach>

				
				


				<%-- <nav class="pagination" role="navigation">
					<span class="page-number">第 ${page.page } 页 ⁄ ${totalPage} 共 页</span> <a
						class="older-posts" href="blog/post/page/2"><i
						class="fa fa-angle-right"></i></a>
				</nav>
			 --%>
			<!-- 首页的 分页栏 -->
				${navPage}

				</main>

				<aside class="col-md-4 sidebar">
					<!-- start tag cloud widget -->
					<jsp:include page="../common/aside.jsp"></jsp:include>
					<!-- end tag cloud widget -->

				</aside>

			</div>
		</div>
	</section>

	<!--start footer copyright  -->
	<jsp:include page="../common/footer.jsp"/>

</body>
</html>