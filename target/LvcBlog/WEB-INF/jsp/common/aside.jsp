<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  


	<!-- start tag cloud widget -->
					<div class="widget">
						<h4 class="title">交流</h4>
						<div class="content community">
							
							<p>
								<a href="#" title="ilvc GitHub"
									target="_blank">
									<i class="fa fa-comments"></i> GitHub </a>
							</p>
							<p>
								<a href="#" title="ilvc官方微博"
									target="_blank">
									<i class="fa fa-weibo"></i> 新浪微博</a>
							</p>
							<p>
								<a href="#" title="ilvc官方微博"
									target="_blank">
									<i class="fa fa-music"></i> 网 易 云</a>
							</p>
							<p>
							<a href="https://jq.qq.com/?_wv=1027&k=47a5ekC">交流QQ群：632944013 </a>
							</p>
						</div>
					</div>
					<!-- end tag cloud widget -->

					<!-- start tag cloud widget -->
					<div class="widget">
						<h4 class="title">分类</h4>
						<div class="content tag-cloud">
						<c:forEach var="categories" items="${categoriess}">
								<a href="${pageContext.request.contextPath}/categories/${categories.categoriesName}">${categories.categoriesName}</a>
							</c:forEach>
							 <a
								href="${pageContext.request.contextPath}/categories/categories-cloud/">...</a>
						</div>
					</div>
					<!-- end tag cloud widget -->

					<!-- start tag cloud widget -->
					<div class="widget">
						<h4 class="title">标签云</h4>
						<div class="content tag-cloud">
							<c:forEach var="tag" items="${tagss}">
								<a href="${pageContext.request.contextPath}/tags/${tag.tagName}">${tag.tagName}</a>
							</c:forEach>
							 <a href="${pageContext.request.contextPath}/tags/tag-cloud">...</a>
						</div>
					</div>
					<!-- end tag cloud widget -->