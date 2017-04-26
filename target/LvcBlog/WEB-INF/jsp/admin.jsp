<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/img/favicon.ico">

	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/monokai_sublime.min.css">
	<link href="${pageContext.request.contextPath}/resources/css/magnific-popup.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/editormd/css/editormd.min.css">
	<!-- resources/editormd/css/editormd.css -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/screen.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/admin.css">
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/editormd/lib/marked.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/editormd/lib/prettify.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/editormd/editormd.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/editormd/plugins/image-dialog-qiniu/image-dialog-qiniu.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery.pin.js"></script>
    <title>iLvcBlog管理系统</title>
    

<script type="text/javascript">

var editormdElement;
$(function() {
	editormdElement = editormd("id_editormd", {
		width : "100%",
		height : 540,
		syncScrolling : "single",
		path : "${pageContext.request.contextPath}/resources/editormd/lib/",
		imageUpload : true,
		imageFormats : [ "jpg", "jpeg", "gif", "png", "bmp", "webp" ],
		imageUploadURL : "${pageContext.request.contextPath}/uploadfile",
		saveHTMLToTextarea : true,
		toolbarIcons : function() {
       		return  ["bold", "del", "italic", "hr", "image", "qiniu", "table", "datetime", "|", "preview", "watch", "|", "fullscreen"];
       	},
       	//配置七牛上传插件
       	toolbarIconsClass : {
            qiniu : "fa-cloud-upload"
        },
        toolbarHandlers : {
            qiniu : function(cm, icon, cursor, selection) {
            	this.imageDialogQiniu();
            }
        },
        qiniuTokenUrl : "${pageContext.request.contextPath}/getQiniuToken",	
        qiniuPublishUrl :"http://ooprvk5m6.bkt.clouddn.com",
        htmlDecode	  : "false",						//是否开启html解析，默认不开启				
	});
});

$("#panel-1").pin()
</script>

</head>

<body style="background-color:#f7f7f7;">
	<div class="container-fuild">
		<div class="row clearfix">
				<nav class="navbar navbar-default  " role="navigation">
					<a class="navbar-brand" href="#" style="padding-left: 50px;"><img src="${pageContext.request.contextPath}/resources/img/ilogoko.png"  width="20px" height="20px" style="display: inline-block;" >  iLvc | 博客 </a>
					<p class="nav navbar-nav navbar-right" style="padding-right:60px;" ><a href="${pageContext.request.contextPath}/admin/logout"><i class="fa fa-sign-out fa-2x" style="padding-top: 10px;" ></i></a></p>
				</nav>
			</div>
	</div>
		
	<div class="container-fuild  ">
		<div class="row clearfix contained">
			<div class="col-md-2 column " >
				<div class="panel-group pinned" id="panel-1"  >
					<div class="panel panel-default">
						<div class="panel-heading">
							 <i class="fa fa-navicon "></i>&nbsp;&nbsp;<a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-1" href="#panel-element-1">文章 Post</a>
						</div>
						<div id="panel-element-1" class="panel-collapse collapse">
							<div class="panel-body">
								<i class="fa fa-navicon "></i>&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/admin/post/add">添加文章</a>
								
							</div>
							<div class="panel-body">
							
								<i class="fa fa-tag "></i>&nbsp;&nbsp; <a href="${pageContext.request.contextPath}/admin/post/list">文章列表</a>
								
							</div>
							<div class="panel-body">
							
							
								<i class="fa fa-tag "></i>&nbsp;&nbsp; <a href="${pageContext.request.contextPath}/admin/post/trash">垃圾箱</a>
							</div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							 <i class="fa fa-tag "></i>&nbsp;&nbsp;  <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-1" href="#panel-element-2"> 标签 Tags</a>
						</div>
						<div id="panel-element-2" class="panel-collapse collapse">
							<div class="panel-body">
								<i class="fa fa-navicon "></i>&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/admin/post/add">添加标签</a>							
							</div>
							<div class="panel-body">							
								<i class="fa fa-tag "></i>&nbsp;&nbsp; <a href="${pageContext.request.contextPath}/admin/post/list">标签列表</a>							
							</div>
							
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<i class="fa fa-file  "></i>&nbsp;&nbsp;  <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-1" href="#panel-element-3">分类 CateGories</a>
						</div>
						<div id="panel-element-3" class="panel-collapse collapse">
							<div class="panel-body">
								<i class="fa fa-navicon "></i>&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/admin/post/add">添加分类</a>							
							</div>
							<div class="panel-body">							
								<i class="fa fa-tag "></i>&nbsp;&nbsp; <a href="${pageContext.request.contextPath}/admin/post/list">分类列表</a>							
							</div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							 <i class="fa fa-cog "></i>&nbsp;&nbsp;<a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-1" href="#panel-element-4">系统设置</a>
						</div>
						<div id="panel-element-4" class="panel-collapse collapse">
							<div class="panel-body">
							
								<i class="fa fa-tag "></i>&nbsp;&nbsp; <a href="#">系统常量</a>
								
							</div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<i class="fa fa-sign-out "></i>&nbsp;&nbsp;  <a class="panel-title" href="${pageContext.request.contextPath}/admin/logout">退出</a>
						</div>
						
					</div>
				</div>
			</div>
			<div class="col-md-10 column">
				<!-- <ul class="breadcrumb">
					<li>
						 <a href="#">Home</a>
					</li>
					<li>
						 <a href="#">Library</a>
					</li>
					<li class="active">
						Data
					</li>
				</ul> -->
				<c:if test="${mainPage!=null }">
				<jsp:include page="${mainPage}"></jsp:include>
				</c:if>
				<c:if test="${mainPage==null }">
					<div style="position: absolute;left: 350px;height: 600px;">
						<img src="${pageContext.request.contextPath}/resources/img/ilogoko.png" />
					</div>
				</c:if>
			</div>
		</div>
	</div>
	<a href="#" id="back-to-top" style="display: block;"><i class="fa fa-angle-up"></i></a>
	<script type="text/javascript">
	  //防止页面后退
    history.pushState(null, null, document.URL);
    window.addEventListener('popstate', function () {
        history.pushState(null, null, document.URL);});
　　</script>

<script>
      $(".pinned").pin({containerSelector: ".contained"});
    </script>
</body>

</html>
