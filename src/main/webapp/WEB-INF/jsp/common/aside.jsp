<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  


	<!-- start tag cloud widget -->
					<div class="widget">
						<h4 class="title">交流</h4>
						<div class="content community">
							
								<p>
								<a href="https://github.com/ilvc" title="GitHub"
									target="_blank">
									<i class="fa fa-comments"></i> GitHub </a>
							</p>
							<p>
								<a href="http://weibo.com/2883343161/profile?rightmod=1&wvr=6&mod=personinfo&is_all=1" title="ilvc官方微博"
									target="_blank">
									<i class="fa fa-weibo"></i> 新浪微博</a>
							</p>
							<p>
								<a href="http://music.163.com/#/user/home?id=113643683" title="ilvc官方微博"
									target="_blank">
									<i class="fa fa-music"></i> 网 易 云</a>
							</p>
							<p>
								<a href="http://chunchuji.ilvc.me" target="_blank" title="如春之生息，雏之无畏，是为春雏。">诗集-《春雏集》</a>
							</p>
							<p>
								<a target="_blank" href="//shang.qq.com/wpa/qunwpa?idkey=2d90a4111fab133ddb17eeb482d243ec9ccb83d98f3e43063d2fad1f20e87a6e"><img border="0" src="//pub.idqqimg.com/wpa/images/group.png" alt="小伙伴们技术学习交流" title="小伙伴们技术学习交流"></a>
							</p>
							<!-- <p>
							<a href="https://jq.qq.com/?_wv=1027&k=47a5ekC" title="小伙伴们的技术学习交流群" >交流QQ群：632944013 </a>
							</p> -->
							<!-- <p>
							<a href="http://wpa.qq.com/msgrd?v=1&uin=328097822&site=houdao.com&menu=yes" target="_blank" title="点击即可与我交流" >点击即可与我交流 </a>
							</p> -->
						</div>
					</div>
					<!-- end tag cloud widget -->

					<!-- start tag cloud widget -->
					<div class="widget">
						<h4 class="title">最受欢迎的</h4>
						<div class="content tag-cloud">
						<c:forEach var="post" items="${post2rate}" end="12">
								<a href="${pageContext.request.contextPath}/blog/post/${post.id}">${post.title})</a>
							</c:forEach>
							 
						</div>
					</div>
					<!-- end tag cloud widget -->
					
					<!-- start tag cloud widget -->
					<div class="widget">
						<h4 class="title">分类</h4>
						<div class="content tag-cloud">
						<c:forEach var="categories" items="${categoriess}">
								<a href="${pageContext.request.contextPath}/categories/${categories.typeName}">${categories.typeName}</a>
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