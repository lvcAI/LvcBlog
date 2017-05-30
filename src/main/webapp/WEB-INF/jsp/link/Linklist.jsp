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
								<c:forEach items="${link_list }" var="link" varStatus="count" >
									<tr>
									  <td >${count.count}</td>
									  <td ><a href="${link.url}">${link.urlname}</a></td>
									  <td ><a href="javascript:void(0);">${link.state}</a></td>
									  <td >   <a href="#"><i class="fa fa-share-alt"></i></a></td>
									  <td > <a href="${pageContext.request.contextPath}/admin/links/update/${link.id}">修改</a></td>
									  <td ><a href="${pageContext.request.contextPath}/admin/links/delete/${link.id}">删除</a></td>
									</tr>
								
								</c:forEach>								
							</tbody>		
						 </table>
						<p style="font-size: 10px;">注:0 : 友情链接；1：问题与解决. 2 : 回收 不显示在前台和后台;3:我的链接</p>
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

	
