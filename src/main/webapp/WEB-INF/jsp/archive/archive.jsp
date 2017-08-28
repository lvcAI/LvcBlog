<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<!DOCTYPE html>

<html lang="zh-CN">
<head>


<jsp:include page="../common/resource.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/timeline.css" />

<title>归档  -- iLvc | Lvc唯爱</title>

<style type="text/css">
	
		.archive {
			list-style:none;  
			font-size: 16px;
			margin: 5px;
		}
		.archive li span{
			padding-right: 20px;
		}
	
</style>

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
					        共 ${postcount} 篇文章
				    	</div>
				    </div>
					<article  class="post">
						<%-- <ul class="archive">
							 
							<c:forEach var="post" items="${post_list}">
									<li><span>${fn:substring(post.createDate,5,10)}</span><a href="${pageContext.request.contextPath}/blog/post/${post.id}">${post.title}</a></li>
							</c:forEach>
						</ul> --%>
						    <div class="timeline timeline-both">
						    	<div class="timeline-header">2017</div>
						    	<c:forEach items="${post_list}" var="post" varStatus="count" >
						    	
							        <dl>
							            <dt>
							            	<img src="${pageContext.request.contextPath}/resources/img/face/${count.count}.gif" />
							                <p>${fn:substring(post.createDate,0,10)}</p>
							                <b><a href="${pageContext.request.contextPath}/blog/post/${post.id}">${post.title}</a></b>
							            </dt>
							            <dd><a href="${pageContext.request.contextPath}/blog/post/${post.id}">${fn:substring(post.content,0,50)}</a></dd>
							        </dl>
						    	</c:forEach>
						      
						    </div>
					</article>
				
				<!-- 首页的 分页栏 -->
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

	<jsp:include page="../common/footer.jsp"></jsp:include>

</body>
</html>