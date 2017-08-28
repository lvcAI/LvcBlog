<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<!DOCTYPE html>

<html lang="zh-CN">
<head>
<jsp:include page="../common/resource.jsp"></jsp:include>
<title>${post.title} -- iLvc | Lvc唯爱</title>

<script type="text/javascript">

function send2(){
	
	var reg = /^\s*$/g;
	if(reg.test($('#userName').val()))
	{
		//alert("\u8bf7\u586b\u5199\u60a8\u7684\u59d3\u540d");
		$('#userName').focus()
		return false;
	}
	else if(!/^[u4e00-\u9fa5\w]{2,8}$/g.test($('#userName').val()))
	{
		//alert("\u59d3\u540d\u75312-8\u4f4d\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u3001\u6c49\u5b57\u7ec4\u6210\uff01");
		$('#userName').focus()
		return false;
	}
	
	var commnet={
			name:$('#userName').val(),
			email:$('#email').val(),
			context:$('#conBox').val(),
			state:1};
	//alert("请填写完整！");
	
		if($('#userName').val()!=null && $('#userName').val()!=""){
			//alert(commnet);
		$.post("<%= request.getContextPath()%>/comments/save",commnet,function(result,state){
			//alert(result+state);
		});			
		}else{
			//alert("请填写完整！");
			return false;
		}
}


</script>

</head>
<body class="home-template">

	<!-- start header -->
	<!-- start headr and navcation  -->
			<jsp:include page="../common/head.jsp"></jsp:include>
	<!-- end navigation -->


	<!-- start site's main content area -->
	<section class="content-wrap">
		<div class="container">
			<div class="row">

				<main class="col-md-8 main-content">
					<article  class="post">
	
						<div class="post-head">
							<h1 class="post-title">
								<a href="#">${post.title}</a>
							</h1>
							<div class="post-meta">
								<span class="author"><a href="${pageContext.request.contextPath}/about"><i class="fa fa-user-md"></i>  ${post.user.userName}</a></span> • 
								<time class="post-date" > <i class="fa fa-calendar"></i> ${fn:substring(post.createDate,0,10)}</time>
									<span class="author"><i class="fa fa-tags"></i> <a href="${pageContext.request.contextPath}/categories/${post.categories.categoriesName}">${post.categories.categoriesName}</a></span>
									<span><i class="fa fa-star" style="color: "></i> ${post.rate}</span>
							</div>
						</div>
						<div class="post-content">
							<blockquote  style="background: #ebebeb;font-size: 14px;">
   								 <span>本文永久链接地址：<i  style="color: #e67e22; font-weight: bold;">http://ilvc.me/blog/post/${post.id}</i></span><br/>
   								 <span>转载请注明出处：<i  style="color: #e67e22; font-weight: bold;">iLvc 开源 博客系统  ---- ${post.title}</i> </span>
  								
 							 </blockquote>
							 ${post.html}
							<blockquote  style="background: #ebebeb;font-size: 14px;">
   								 <span>本文永久链接地址：<i  style="color: #e67e22; font-weight: bold;">http://ilvc.me/blog/post/${post.id}</i></span><br/>
   								 <span>转载请注明出处：<i  style="color: #e67e22; font-weight: bold;">iLvc 开源 博客系统  ---- ${post.title}</i> </span>
  								
 							 </blockquote>
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
					
					<article  class="post">
					<!-- 系统自带 评论  -->
					<!-- 
						<header class="post-head">
					        <h4 id="writeGuest" align="left" >Write something....? <i class="fa fa-hand-right"></i><span style="color: #ea4c4c;" >click here </span></h4>
					    </header>			
					    	<div id="toggleGuest" style="display:none;">
					    		<form>
								    <div style="padding: 10px;">
								        Name: <input id="userName"  placeholder="u name "/>
								          &nbsp; &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp; 
								         Email: <input id="email" type="text"   placeholder="我将通过此邮箱联系您"/>
								         
								    </div>
								    <div><textarea id="conBox" class="f-text"></textarea></div>
								    <div class="tr">
								        <p>
								            <span class="countTxt">还能输入</span><strong class="maxNum">140</strong><span>个字</span>
								 
								            <input id="sendBtn" type="button" class=" btn btn-success" onclick="javascript:send2();" value="留言" title="快捷键 Ctrl+Enter" />
								        </p>
								    </div>
								</form>
					    	</div>	 -->
							<!-- 畅言 PC和WAP自适应版-->
							<div id="SOHUCS" sid="${pageContext.request.contextPath}/blog/post/${post.id}" ></div> 
							<script type="text/javascript"> 
							(function(){ 
							var appid = 'cyt0uaFJg'; 
							var conf = 'prod_fc3456eb4d080c94e74d99316162e290'; 
							var width = window.innerWidth || document.documentElement.clientWidth; 
							if (width < 960) { 
							window.document.write('<script id="changyan_mobile_js" charset="utf-8" type="text/javascript" src="http://changyan.sohu.com/upload/mobile/wap-js/changyan_mobile.js?client_id=' + appid + '&conf=' + conf + '"><\/script>'); } else { var loadJs=function(d,a){var c=document.getElementsByTagName("head")[0]||document.head||document.documentElement;var b=document.createElement("script");b.setAttribute("type","text/javascript");b.setAttribute("charset","UTF-8");b.setAttribute("src",d);if(typeof a==="function"){if(window.attachEvent){b.onreadystatechange=function(){var e=b.readyState;if(e==="loaded"||e==="complete"){b.onreadystatechange=null;a()}}}else{b.onload=a}}c.appendChild(b)};loadJs("http://changyan.sohu.com/upload/changyan.js",function(){window.changyan.api.config({appid:appid,conf:conf})}); } })(); </script>
						  <%--  <div class="list" >
						          <ul id="ulid" style="list-style: none;padding: 0;">
						          	<li id="liId"></li>
						          	<c:forEach items="${guestList}" var="comment" varStatus="count">
						           	<li style="margin: 5px 0;" >
						           		<div class="media">
											 <div class="media-left media-middle">
											      <img class="media-object img-circle" alt="64x64"  src="${pageContext.request.contextPath}/resources/img/face/face${count.count}.gif"  style="width: 64px; height: 64px;">
											  </div>
											  <div class="media-body">
											   	 <h4 class="media-heading">@ ${comment.name } <span style="font-size:10px;margin-left:20px;">${comment.createdate}</span></h4>
											   	 <p>${comment.context}</p>
											   </div>
											</div> 
						           		</li >
						           		</c:forEach>
						          </ul>
					          </div>     	 --%>
					</article>

				<!-- nav start  -->
				 ${navPage}
			
				</main>

				<aside class="col-md-4 sidebar">
					<!-- start tag cloud widget -->
					<jsp:include page="../common/aside.jsp"></jsp:include>
					<!-- end tag cloud widget -->

				</aside>
			</div>
		</div>
	</section>

	<!--start footer copyright  -->
	<jsp:include page="../common/footer.jsp"/>
<script type="text/javascript">
	$("#writeGuest").click(function(){
		//  $("#toggleGuest").toggle();
		  $("#toggleGuest").fadeToggle("slow");
		});
</script>
</body>
</html>