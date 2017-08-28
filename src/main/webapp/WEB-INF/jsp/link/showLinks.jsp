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
<title>收藏夹 -- iLvc | Lvc唯爱</title>
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
	
					<div class="cover tag-cover">
					    <h3 class="tag-name">
					        收藏夹
					    </h3>
					    <div class="post-count">
					      共 ${totalLink} 个收藏
				    	</div>
				    </div>
	
					<article class="post page">
			 			<header class="post-head">
					        <h1 class="post-title"></h1>
					    </header>			
					    <section class="post-content widget">
					    	<div class="tag-cloud">
					          <c:forEach items="${allLinks}" var="link">
					          		<a href="${link.url}" target="_blank">${link.urlname}</a>	<br>
					          				
					          </c:forEach>
					            
					        </div>
					    </section>					
					</article>
					<!-- start nav -->
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
					
					<div class="widget">
						<h4 class="title">快速添加</h4>
						<div class="content tag-cloud">
							<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo">快速添加收藏</button>
						</div>
						<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
						  <div class="modal-dialog" role="document">
						    <div class="modal-content">
						      <div class="modal-header">
						        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						        <h4 class="modal-title" id="exampleModalLabel">快速添加 FAQ</h4>
						      </div>
						      <div class="modal-body">
						        <form id="add">
						          <div class="form-group">
						            <label for="urlName" class="control-label">URL Name:</label>
						            <input type="text"  class="form-control" id="urlname" >
						          </div>
						          <div class="form-group">
						            <label for="url" class="control-label">URL Address </label>
						           	 <input type="url" name="url"  class="form-control" id="url"  style="background-color: #fff;">
						          </div>
						        </form>
						      </div>
						      <div class="modal-footer">
						        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						        <button type="button" class="btn btn-primary" id="addLink" >添加</button>
						      </div>
						    </div>
						  </div>
						</div>
					</div>
				</aside>

			</div>
		</div>
	</section>

	<!-- start footer and copyright -->
	<jsp:include page="../common/footer.jsp"></jsp:include>

</body>
</html>