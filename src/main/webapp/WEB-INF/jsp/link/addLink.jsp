<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  

	<ul class="breadcrumb">
		<li>
			文章 Post
		</li>				
		<li class="active">
			添加文章
		</li>
	</ul>

	<!-- start site's main content area -->
	<section class="content-wrap" >
		<div class="container-fluid">
			<div class="row">

				<main class="col-md-12 main-content">	
					<form role="form" action="${pageContext.request.contextPath}/admin/links/save" method="post">
					<input type="hidden" class="form-control" name="updateId"  value="${update_link }"/>
					<div class="form-group">
						 <label for="exampleInputEmail1">Link Name</label><input type="text" class="form-control" id="" name="urlname" placeholder="Link Name" required="required"/>
					</div>
					<div class="form-group">
						 <label for="exampleInputPassword1">link URL</label><input type="url" class="form-control" name="url" placeholder="链接地址，必须包含  http://" required="required"/>
					</div>
					<div class="form-group">
						 <label for="exampleInputPassword1">权重</label><input type="text" class="form-control" placeholder="0-100之间选择输入" name="ordernum" required="required"/>
					</div>
					<div >
					<label>链接类型：</label>
						 <label><input type="radio" value="0" name="state" /> 友情链接 </label>
						 <label><input type="radio" value="1" name="state" /> FAQ链接 </label>
						 <label><input type="radio" value="2" name="state" /> 回 收 站 </label>
						 <label><input type="radio" value="3" name="state" /> 我的链接 </label>
					</div> 
					<button type="submit" class="btn btn-default">Submit</button>
					&nbsp;
					<br/>
					&nbsp;
				</form>					
				</main>		
				

			</div>
		</div>
	</section>


