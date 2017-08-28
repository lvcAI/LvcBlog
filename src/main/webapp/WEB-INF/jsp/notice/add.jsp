<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  

	<ul class="breadcrumb">
		<li>
			通知 Notice
		</li>				
		<li class="active">
			添加通知
		</li>
	</ul>

	<!-- start site's main content area -->
	<section class="content-wrap" >
		<div class="container-fluid">
			<div class="row">

				<main class="col-md-12 main-content">	
					<form role="form" action="${pageContext.request.contextPath}/admin/notice/save" method="post">
					<input type="hidden" class="form-control" name="updateId"  value="${update_notice.id }"/>
					<div class="form-group">
						 <label for="exampleInputEmail1">Notice Title</label><input type="text" class="form-control"  value="${update_notice.title }" name="title" placeholder="通知内容" required="required"/>
					</div>
					<div class="form-group">
						 <label for="exampleInputPassword1">Notice Source</label><input type="text" class="form-control" value="${update_notice.bookname }" name="bookname" placeholder=" 通知来源 ，小于50个字" required="required"/>
					</div>
					<div class="form-group">
						 <label for="exampleInputPassword1">Notie Type</label><input type="text" class="form-control" value="${update_notice.type }" placeholder="请输入下面弄连接类型" name="type" required="required"/>
					</div>
					<div >
					<label>通知类型：</label>
						 <label>0: 小提示 </label>
						 <label>1: 公告 </label>
						 <label>2: 回 收 站 </label>
						
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


