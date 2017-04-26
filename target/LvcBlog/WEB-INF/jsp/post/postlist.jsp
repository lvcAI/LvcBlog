<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  


	<ul class="breadcrumb">
		<li>
			文章 Post
		</li>
					
		<li class="active">
			文章列表
		</li>
	</ul>
	<!-- start site's main content area -->
	<section class="content-wrap">
		<div class="container-fluid">
			<div class="row">

				<main class="col-md-12 main-content">	
					<div>
						<table class="table">
							<thead>
								<tr>
								  <th >#</th>
								  <th width="75%">标题</th>
								  <th >分享</th>
								  <th >修改</th>
								  <th >删除</th>
								 
								</tr>
							</thead>
							<!-- On cells (`td` or `th`) -->
							<tbody>
								<c:forEach items="${pos_list }" var="post" varStatus="count" >
									<tr>
									  <td >${count.count}</td>
									  <td ><a href="${pageContext.request.contextPath}/blog/post/${post.id}">${post.title}</a></td>
									  <td ><a href="#">分享</a></td>
									  <td ><a href="${pageContext.request.contextPath}/admin/post/update/${post.id}">修改</a></td>
									  <td ><a href="${pageContext.request.contextPath}/admin/post/delete/${post.id}">删除</a></td>
									</tr>
								
								</c:forEach>								
							</tbody>		
						 </table>
					
						 <nav>
						  <ul class="pagination">
						    <li>
						      <a href="#" aria-label="Previous">
						        <span aria-hidden="true">&laquo;</span>
						      </a>
						    </li>
						    <li><a href="#">1</a></li>
						    <li><a href="#">2</a></li>
						    <li><a href="#">3</a></li>
						    <li><a href="#">4</a></li>
						    <li><a href="#">5</a></li>
						    <li>
						      <a href="#" aria-label="Next">
						        <span aria-hidden="true">&raquo;</span>
						      </a>
						    </li>
						  </ul>
						</nav>
						
					</div>	
				</main>		
				

			</div>
		</div>
	</section>

	
