<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  


<footer class="main-footer">
		<div class="container">
			<div class="row">
				<div class="col-sm-4">
					<div class="widget">
						<h4 class="title">最新文章</h4>
						<div class="content recent-post">
							<c:forEach var="post" items="${posts}" end="3">
							
								<div class="recent-single-post">
								<a href="${pageContext.request.contextPath}/blog/post/${post.id}"
									class="post-title">${post.title}</a>
								<div class="date">${fn:substring(post.createDate,0,10)}</div>
							</div>
							</c:forEach>
							
						</div>
					</div>
				</div>

				<div class="col-sm-4">
					<div class="widget">
						<h4 class="title">标签云</h4>
						<div class="content tag-cloud">
							<c:forEach var="tag" items="${tagss}">
								<a href="${pageContext.request.contextPath}/tags/${tag.tagName}">${tag.tagName}</a>
							</c:forEach>
							 <a href="${pageContext.request.contextPath}/tag-cloud">...</a>
						</div>
					</div>
				</div>

				<div class="col-sm-4">
					<div class="widget">
						<h4 class="title">友情链接</h4>
						<div class="content tag-cloud friend-links">
							<a href="http://pjc.party" title="彭佳成的博客" target="_blank">彭佳成的博客</a> 
							
							<hr>
							<a href="http://bootcss.com/" title="Bootstrap中文网" target="_blank">Bootstrap中文网</a> 
							<a href="http://www.runoob.com/" title="菜鸟教程" target="_blank">菜鸟教程</a>
							<a href="http://www.csdn.net/" title="CSDN" target="_blank">CSDN</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
	
	<div class="copyright">
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<span>Copyright © <a href="http://pjc.party" target="_blank">iLvc</a></span>
					| <span><a href="#"
						target="_blank">测试版@iLvc 0.1.0</a></span> | <span></span>
				</div>
			</div>
		</div>
	</div>

	<a href="#" id="back-to-top" style="display: block;"><i class="fa fa-angle-up"></i></a>