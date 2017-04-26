<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  

	<ul class="breadcrumb">
		<li>
			文章 Post
		</li>				
		<li class="active">
			垃圾箱
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
								<tr>
								  <td >1</td>
								  
								  <td ><a href="#">HelloWorld</a></td>
								  <td ><a href="#">分享</a></td>
								  <td ><a href="#">修改</a></td>
								  <td ><a href="#">删除</a></td>
								</tr>
								<tr>
								  <td >1</td>
								  <td>阿里云服务器连接以及centos 搭建 web java环境（linux java部署 tomcat部署）</td>
								  <td >分享</td>
								  <td >修改</td>
								  <td >删除</td>
								</tr>
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

	
