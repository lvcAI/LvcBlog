<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<!DOCTYPE html>

<html lang="zh-CN">
<script
	src="chrome-extension://eojeoeddgeaeahpmfabdfpfialkoplcb/_locales/en/Kernel.js?0.5383648139636812"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>iLvc | Lvc唯爱</title>
<meta name="description" content="LvcBlog">
<meta name="keywords" content="LvcBlog blog ilvc lvc">

<meta name="HandheldFriendly" content="True">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/img/favicon.ico">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/font-awesome.min.css">
<link rel="stylesheet" href="resources/css/monokai_sublime.min.css">
<link href="resources/css/magnific-popup.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="resources/css/screen.css">
<script type="text/javascript" src="resources/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
<!-- <script type="text/javascript" src="resources/js/loading.js"></script> -->
<style type="text/css">
.search{
	position: absolute;
    top: 15px;
    margin-left: 50px;
}
/*页面自动生成了 一些，<code></code>  */
code {
     padding: 0 0; 
   /*  font-size: 90%;
    color: #c7254e;
    background-color: #f9f2f4;
    border-radius: 4px; */
    
}
</style>
<script type="text/javascript">

function search(){
	if($("#q").val()!=null&&$("#q").val().trim()!=""){
		window.location.href="${pageContext.request.contextPath}/blog/post/q?q="+$("#q").val().trim();
	}else{
		alert("请输入关键字，后在搜索！");
	}
}
document.onkeydown=function(event){   
    var e = event || window.event || arguments.callee.caller.arguments[0];   
    if (e.keyCode == 13 && e.ctrlKey) {    
        alert("你按下了ctrl+Enter");    
    }  
 };    
	
	$(document).ready(function(){
		$('.asearch').hover(function(){
			$('.search').show();
		});
		 $('#q').blur(function(){
			 if($("#q").val()!=null&&$("#q").val().trim()!=""){
					//alert("可以收索了");
				}else{
					$('.search').hide();
				}
			
		}); 
		
		$('.asearch').click(function(){
			if($("#q").val()!=null&&$("#q").val().trim()!=""){
				window.location.href="${pageContext.request.contextPath}/blog/post/q?q="+$("#q").val().trim();
			}else{
				alert("请输入关键字，后在搜索！");
			}
		});
	});
</script>
</head>
<body class="home-template">
	<!-- <div class="loading" id="loading">
   		<div class="progress" id="progress">0%</div>
   </div> -->
	<!-- start header -->
	<header class="main-header"
		style="background-image: url(${pageContext.request.contextPath}/resources/img/xk.jpg);">
		<div class="container">
			<div class="row">
				<div class="col-sm-12">

					<!-- start logo -->
					<a class="branding" href="#"
						title="iLvc 开源博客平台"><img
						src="${pageContext.request.contextPath}/resources/img/ilogoko.png" width="10%" height="10%"
						alt="iLvc 开源博客平台" title="iLvc | Lvc唯爱"></a>
					<!-- end logo -->
				</div>
			</div>
		</div>
	</header>
	<!-- end header -->

	<!-- start navigation -->
	<nav class="main-navigation">
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
							<li class="nav-current" role="presentation"><a
								href="${pageContext.request.contextPath}/">首页</a></li>
							<!-- 
							<%-- <li role="presentation"><a
								href="${pageContext.request.contextPath}/archive">归档</a></li> --%>
							 -->
							<li role="presentation"><a
								href="${pageContext.request.contextPath}/categories/categories-cloud">分类</a></li>
							<li role="presentation"><a
								href="${pageContext.request.contextPath}/tags/tag-cloud">标签</a></li>
							<li role="presentation"><a
								href="http://pjc.party/categories/Poem/">诗集</a></li>
							<li role="presentation"><a
								href="${pageContext.request.contextPath}/guestBook">留言本</a></li>
							<li role="presentation"><a
								href="${pageContext.request.contextPath}/FAQ/links-could" title="问题与解决方案">收藏夹</a></li>
							<li role="presentation"><a
								href="${pageContext.request.contextPath}/about">关于</a></li>
							<li role="presentation"><a
								href="javascript:void(0);" class="asearch"><i class="fa fa-search"></i></a>
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
	<section class="content-wrap">
		<div class="container">
			<div class="row">

			<main class="col-md-8 main-content">

			<c:forEach items="${applicationScope.posts}" var="post">
				
				<article id="98" class="post">
					
						<div class="post-head">
							<h1 class="post-title">
								<a href="${pageContext.request.contextPath}/blog/post/${post.id}">${post.title}</a>
							</h1>
							<div class="post-meta">
								<span class="author"><a
									href="${pageContext.request.contextPath}/about"><i class="fa fa-user-md"></i>  ${post.user.userName}</a></span> •&nbsp;  
								<time class="post-date" 
									title="${post.createDate}"> <i class="fa fa-calendar"></i> ${fn:substring(post.createDate,0,10)}</time>
									<span class="author"><i class="fa fa-tags"></i> <a href="${pageContext.request.contextPath}/categories/${post.categories.categoriesName}">${post.categories.categoriesName}</a></span>
									<%-- <span><i class="fa fa-star" style="color: "></i> ${post.rate}</span> --%>
							</div>
						</div>
					<div class="post-content">
						${fn:substring(post.html,0,500)}
					</div>
					<div class="post-permalink">
						<a href="${pageContext.request.contextPath}/blog/post/${post.id}"
							class="btn btn-default">阅读全文</a>
					</div>

					<footer class="post-footer clearfix">
						<div class="pull-left tag-list">
							<i class="fa fa-folder-open-o"></i>
							<c:forEach items="${post.tags }" var="tag">
								<a href="${pageContext.request.contextPath}/tags/${tag.tagName}">${tag.tagName}</a>
							</c:forEach>
						</div>
						
						<div class="pull-right share">
							<!-- JiaThis Button BEGIN -->
								<div class="jiathis_style">
									<span class="jiathis_txt">分享到：</span>
									<a class="jiathis_button_icons_1"></a>
									<a class="jiathis_button_icons_2"></a>
									<a class="jiathis_button_icons_3"></a>
									<a class="jiathis_button_icons_4"></a>
									<a href="http://www.jiathis.com/share" class="jiathis jiathis_txt jtico jtico_jiathis" target="_blank"></a>
									<a class="jiathis_counter_style"></a>
								</div>
								<script type="text/javascript" src="http://v3.jiathis.com/code/jia.js" charset="utf-8"></script>
								<!-- JiaThis Button END -->
						</div>
					</footer>
					
				</article>
			
			</c:forEach>

				

			<!-- 首页的 分页栏 -->
				${indexPage}

				</main>

				<aside class="col-md-4 sidebar">
					<!-- start widget -->
					<!-- end widget -->

					<!-- start tag cloud widget -->
					<div class="widget">
						<h4 class="title">交流</h4>
						<div class="content community">
							
							<p>
								<a href="https://github.com/lvcAI" title="lvcAI-GitHub"
									target="_blank">
									<i class="fa fa-comments"></i> GitHub </a>
							</p>
							<p>
								<a href="http://weibo.com/2883343161/profile?rightmod=1&wvr=6&mod=personinfo&is_all=1" title="ilvc官方微博"
									target="_blank">
									<i class="fa fa-weibo"></i> 新浪微博</a>
							</p>
							<p>
								<a href="http://music.163.com/#/user/home?id=113643683" title="网 易 云"
									target="_blank">
									<i class="fa fa-music"></i> 网 易 云</a>
							</p>
							<p>
							<a href="https://jq.qq.com/?_wv=1027&k=47a5ekC" title="小伙伴们的技术学习交流群" >交流QQ群：632944013 </a>
							</p>
							
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
				</aside>

			</div>
		</div>
	</section>

	<footer class="main-footer">
		<div class="container">
			<div class="row">
				<div class="col-sm-4">
					<div class="widget">
						<h4 class="title">最新文章</h4>
						<div class="content recent-post">
							<c:forEach var="post" items="${posts}" end="2">
							
								<div class="recent-single-post">
								<a href="${pageContext.request.contextPath}/blog/post/${post.id}"
									class="post-title">${post.title}</a>
								<div class="date">${fn:substring(post.createDate,0,10)}</div>
							</div>
							</c:forEach>
							
						</div>
					</div>
				</div>

				<div class="col-sm-4">
					<div class="widget">
						<h4 class="title">标签云</h4>
						<div class="content tag-cloud">
							<c:forEach var="tag" items="${tagss}">
								<a href="${pageContext.request.contextPath}/tags/${tag.tagName}">${tag.tagName}</a>
							</c:forEach>
							 <a href="${pageContext.request.contextPath}/tags/tag-cloud/" >...</a>
						</div>
					</div>
				</div>

				<div class="col-sm-4">
					<div class="widget">
						<h4 class="title">友情链接</h4>
						<div class="content tag-cloud friend-links">
							<a href="http://pjc.party" title="彭佳成的博客" target="_blank">彭佳成的博客</a> 
							<hr/>
							<a href="http://bootcss.com/" title="Bootstrap中文网" target="_blank">Bootstrap中文网</a> 
							<a href="http://www.runoob.com/" title="菜鸟教程" target="_blank">菜鸟教程</a>
							<a href="http://www.csdn.net/" title="CSDN" target="_blank">CSDN</a>
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>

	<div class="copyright">
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<span>Copyright 2015-2017 © <a href="http://ilvc.me">iLvc | Lvc唯爱 </a></span>
					|  <span><a href="http://www.miibeian.gov.cn/"
						target="_blank">赣ICP备17005492号</a></span> | <span></span>
				</div>
			</div>
		</div>
	</div>

	<a href="#" id="back-to-top" style="display: block;"><i class="fa fa-angle-up"></i></a>
	
<script type="text/javascript">
	  //防止页面后退
    history.pushState(null, null, document.URL);
    window.addEventListener('popstate', function () {
        history.pushState(null, null, document.URL);});
    
    $('#back-to-top').click(function(){$('html,body').animate({scrollTop: '0px'}, 800);return false;});
    window.onscroll = function () {
        if (document.documentElement.scrollTop + document.body.scrollTop > 100) {
            document.getElementById("back-to-top").style.display = "block";
        }
        else {
            document.getElementById("back-to-top").style.display = "none";
        }
    };
</script> 
</body>
</html>