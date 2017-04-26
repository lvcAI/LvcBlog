<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<!DOCTYPE html>

<html lang="zh-CN">
<script
	src="chrome-extension://eojeoeddgeaeahpmfabdfpfialkoplcb/_locales/en/Kernel.js?0.5383648139636812"></script>
<head>
<jsp:include page="../common/resource.jsp"></jsp:include>
<title>${post.title} | iLvc | Lvc唯爱</title>

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
								<span class="author">作者：${post.user.userName}<a
									href="${pageContext.request.contextPath}/about"></a></span> • 
								<time class="post-date" 
									title="${post.createDate}">${fn:substring(post.createDate,0,10)}</time>
									<span class="author">分类：<a href="${pageContext.request.contextPath}/categories/${post.categories.categoriesName}">${post.categories.categoriesName}</a></span>
							</div>
						</div>
						<div class="post-content">
							 ${post.html}
						</div>
						
	
						<footer class="post-footer clearfix">
							<div class="pull-left tag-list">
								<i class="fa fa-folder-open-o"></i>
								<c:forEach items="${post.tags }" var="tag">
									<a href="${pageContext.request.contextPath}/tags/${tag.tagName}">${tag.tagName}</a>
								</c:forEach>
								
							</div>
							<div class="pull-right share"></div>
							
						</footer>
						
					</article>
					
					<article  class="post">
							<h4>write something in there ...</h4>
							<div>
					    		<form>
								    <div style="padding: 10px;">
								        Name: <input id="userName"  placeholder="u name "/>
								          &nbsp; &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp; 
								         Email: <input id="email" type="text"   placeholder="u email"/>
								         
								    </div>
								    <div><textarea id="conBox" class="f-text"></textarea></div>
								    <div class="tr">
								        <p>
								            <span class="countTxt">还能输入</span><strong class="maxNum">140</strong><span>个字</span>
								 
								            <input id="sendBtn" type="button" class=" btn btn-success" onclick="javascript:send2();" value="留言" title="快捷键 Ctrl+Enter" />
								        </p>
								    </div>
								</form>
					    	</div>	
							
						   <div class="list" >
						          <ul id="ulid" style="list-style: none;padding: 0;">
						          	<li id="liId"></li>
						          	<%-- <c:forEach items="${guestList}" var="comment" varStatus="count">
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
						           		</c:forEach> --%>
						          </ul>
					          </div>     	
					</article>

			<!-- nav start  -->
			 ${navPage}
			<%-- 	<nav class="pagination" role="navigation">
					<a class="older-posts" href="${pageContext.request.contextPath}/blog/post/2" style="text-decoration: none;  padding-right: 18px;">
						<i	class="fa fa-angle-left"></i>上一篇
					</a>
					<a class="older-posts" href="${pageContext.request.contextPath}/blog/post/2" style="text-decoration: none;  padding-right: 18px;">
						<i	class="fa fa-angle-right"></i>下一篇
					</a>
				</nav>
 --%>

				</main>

				<aside class="col-md-4 sidebar">
					<!-- start widget -->
					<!-- end widget -->

					<!-- start tag cloud widget -->
					<jsp:include page="../common/aside.jsp"></jsp:include>
					<!-- end tag cloud widget -->

					<!-- start widget -->
					<!-- end widget -->

					<!-- start widget -->
					<!-- end widget -->
				</aside>

			</div>
		</div>
	</section>

	<!--start footer copyright  -->
	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>