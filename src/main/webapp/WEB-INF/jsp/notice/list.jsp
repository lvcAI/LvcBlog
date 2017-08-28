<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  


	<ul class="breadcrumb">
		<li>
			<a href="${pageContext.request.contextPath}/admin/admin">首页</a>
		</li>
		<li>
			链接 Link
		</li>
					
		<li class="active">
			链接列表
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
								  <th >类别</th>
								  <th >分享</th>
								  <th >修改</th>
								  <th >删除</th>
								 
								</tr>
							</thead>
							<!-- On cells (`td` or `th`) -->
							<tbody>
								<c:forEach items="${list_notice }" var="notice" varStatus="count" >
									<tr>
									  <td >${count.count}</td>
									  <td >${notice.title}</td>
									  <td ><c:if test="${notice.type==1}">公告</c:if><c:if test="${notice.type==0}">开卷有益</c:if></td>
									  <td >   <a href="#"><i class="fa fa-share-alt"></i></a></td>
									  <td > <a href="${pageContext.request.contextPath}/admin/notice/update/${notice.id}">修改</a></td>
									  <td ><a href="javascript:deletePost(${post.id},'${pageContext.request.contextPath}/admin/notice/delete/');">删除</a></td>
									</tr>
								
								</c:forEach>								
							</tbody>		
						 </table>
						<p style="font-size: 10px;">注:0 : 开卷有益；1：公告；2 : 回收 不显示在前台和后台;</p>
						 <nav style="margin-bottom:30px;padding-bottom: 20px; ">
						  <ul class="pagination">
						    ${navPage}
						  </ul>
						</nav>
						
					</div>	
				</main>		
				

			</div>
		</div>
	</section>

	
