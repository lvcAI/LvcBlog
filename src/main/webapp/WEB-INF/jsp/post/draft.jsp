<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  

<!DOCTYPE html>
<html lang="zh-CN">

<head>
	<jsp:include page="../common/resource.jsp"></jsp:include>
	<title>草稿纸  -- iLvc | Lvc唯爱</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/editormd/css/editormd.min.css">
	<script src="${pageContext.request.contextPath}/resources/editormd/lib/marked.min.js"></script>	
	<script src="${pageContext.request.contextPath}/resources/editormd/lib/prettify.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/editormd/editormd.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/editormd/plugins/image-dialog-qiniu/image-dialog-qiniu.js"></script>
    

<script type="text/javascript">

var editormdElement;
$(function() {
	editormdElement = editormd("id_editormd", {
		width : "100%",
		height : 540,
		syncScrolling : "single",
		path : "${pageContext.request.contextPath}/resources/editormd/lib/",
		imageUpload : false,
		imageFormats : [ "jpg", "jpeg", "gif", "png", "bmp", "webp" ],
		imageUploadURL : "${pageContext.request.contextPath}/uploadfile",
		saveHTMLToTextarea : true,
		toolbarIcons : function() {
       		return  ["bold", "del", "italic", "hr", "table", "datetime", "|", "preview", "watch", "|", "fullscreen"];
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
        htmlDecode	  : "true",						//是否开启html解析，默认不开启				
	});
});


</script>

</head>
<body >
	<nav class="main-navigation" style="    margin-bottom: 5px;">
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<div class="navbar-header">
						<span class="nav-toggle-button collapsed" data-toggle="collapse"
							data-target="#main-menu"> <span class="sr-only">Toggle
								navigation</span> <i class="fa fa-bars"></i>
						</span>
					</div>
					<div class="collapse navbar-collapse" id="main-menu">
						<ul class="menu">
							<li role="presentation"><a
								href="${pageContext.request.contextPath}/">首页</a></li>
							<%-- <li role="presentation"><a href="${pageContext.request.contextPath}/archive">归档</a></li> --%>
							<li role="presentation"><a
								href="${pageContext.request.contextPath}/categories/categories-cloud">分类</a></li>
							<li role="presentation"><a
								href="${pageContext.request.contextPath}/tags/tag-cloud">标签</a></li>
							<li role="presentation"><a
								href="${pageContext.request.contextPath}/guestBook">留言本</a></li>
							<li role="presentation"><a
								href="${pageContext.request.contextPath}/FAQ/links-could" title="问题与解决方案">收藏夹</a></li>
							<li role="presentation"><a
								href="${pageContext.request.contextPath}/about">关于</a></li>
							<li role="presentation"><a
								href="javascript:void(0);" class="asearch" title="点击即可搜索"><i class="fa fa-search"></i></a>
								<div class="search" style="display: none;float: left;">
									<form action="${pageContext.request.contextPath}/blog/post/q" method="get" onsubmit="javascript:search();return false;">
										<input type="search" name="q" id="q" placeholder="回车搜索...." style="height: 25px; border-radius: 20px 20px 20px 20px;padding: 5px;padding-left: 10px;"/>
									</form>
								</div>
							</li>	
						</ul>
					</div>
				</div>
			</div>
		</div>
	</nav>

	<!-- end navigation -->
	<!-- start site's main content area -->
	<section class="content-wrap" >
		<div class="container-fluid">
			<div class="row">

				<main class="col-md-12 main-content">	
					<form class="am-form" id="add-article-form" action="#" method="post" onsubmit="javascript:alert('您好，在草稿纸下，是不能被保存的');return false;">
				
						 <input type="text" class="form-control" id="title" placeholder="请输入文章标题，不要超过30个字符" name="title" value="${update_post.title}"  required="required"/>	
						<input type="hidden" id="updateId"  name="updateId" value="${update_post.id}"/>
					<div class="editormd" id="id_editormd">
					  <textarea class="editormd-markdown-textarea" id="markdown" name="markdown" onfocus="javascript:toggle('none')" required="required" >${update_post.markdown }</textarea>
  					  <textarea class="editormd-html-textarea" name="html" id="html">${update_post.markdown }</textarea>
					  <!-- 第二个隐藏文本域，用来构造生成的HTML代码，方便表单POST提交，这里的name可以任意取，后台接受时以这个name键为准 -->
					</div>	
					
			
					 <br/>
					<div align="center">
						<input type="submit" class="btn btn-primary"  value="提交"/>
						&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="reset" class="btn btn-warning"  onclick="javascript:clearTags()" value="重置"/>
					</div>
					 <br/>
					</form>								
				</main>		
				

			</div>
		</div>
	</section>
 <!-- 定时 缓存 操作 -->
  <!--
 <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.powertimer.js" ></script>
 <script>
        $(function() {
        	
          $('body').powerTimer({
             interval: 1000*60,
             func: function() {
            	 var title =$("#title").val();
             	
             	var markdown =$("#markdown").val();
             	var html =$("#html").val();
             	var tags =$("#tags").val();
             	var categories1 =$("#categories1").val();
             	var updateId=$("#updateId").val();
             	var post={updateId:updateId,title:title,markdown:markdown,html:html,tags:tags,categories1:categories1};
              $.ajax({
              	type:"post",
              	url:"${pageContext.request.contextPath}/admin/post/presave",
              	async:true,
              	data:post,
              	success:function(result){
              		$("#updateId").val(result);
              		alert("文章 以保存");
              	}
              	
              });
             }
          });
        });
     </script> -->
</body>
</html>
	