<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  


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
							 <a href="${pageContext.request.contextPath}/tags/tag-cloud">...</a>
						</div>
					</div>
				</div>

				<div class="col-sm-4">
					<div class="widget">
						<h4 class="title">友情链接</h4>
						<div class="content tag-cloud friend-links">
								<c:forEach items="${app_friendlink}" var="link">
								<a href="${link.url}" title="${link.urlname}" target="_blank">${link.urlname}</a> 
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<div class="widget" style="    margin-bottom: 0px; ">
											
						<div class="content tag-cloud ">
							<span style="font-size:  1.5em;font-weight: 400; color: #ffffff; border-bottom: 1px solid #303030; margin-right: 10px;">快速工具</span>
							<a href="${pageContext.request.contextPath}/blog/post/draft" title="草&nbsp;&nbsp;稿&nbsp;&nbsp;纸" class="btn " >草&nbsp;&nbsp;稿&nbsp;&nbsp;纸</a> 
							<a href="#" title="添加收藏" class="btn " data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo">添加收藏</a>
							<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
						  <div class="modal-dialog" role="document">
						    <div class="modal-content">
						      <div class="modal-header">
						        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						        <h4 class="modal-title" id="exampleModalLabel">快速添加 FAQ</h4>
						      </div>
						      <div class="modal-body">
						        <form id="add">
						          <div class="form-group">
						            <label for="urlName" class="control-label">URL Name:</label>
						            <input type="text"  class="form-control" id="urlname" >
						          </div>
						          <div class="form-group">
						            <label for="url" class="control-label">URL Address </label>
						           	 <input type="url" name="url"  class="form-control" id="url"  style="background-color: #fff;">
						          </div>
						        </form>
						      </div>
						      <div class="modal-footer">
						        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						        <button type="button" class="btn btn-primary" id="addLink" >添加</button>
						      </div>
						    </div>
						  </div>
						</div>
							 
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
					 <br/> 
					 <span>
						<a href="http://www.miibeian.gov.cn/"
						target="_blank">备案号：赣ICP备17005492号</a></span> 
					 <span></span>
				</div>
			</div>
		</div>
	</div>
	<!-- <a href="javascript:void(0);" id="meun-to-top" style="display: block;z-index:9999;"><i class="fa fa-angle-up"></i></a> -->
	<a href="#" id="back-to-top" style="display: block;z-index:9999;"><i class="fa fa-angle-up"></i></a>
	
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
    <!-- 百度链接自动推送 -->
    <script>
(function(){
    var bp = document.createElement('script');
    var curProtocol = window.location.protocol.split(':')[0];
    if (curProtocol === 'https') {
        bp.src = 'https://zz.bdstatic.com/linksubmit/push.js';        
    }
    else {
        bp.src = 'http://push.zhanzhang.baidu.com/push.js';
    }
    var s = document.getElementsByTagName("script")[0];
    s.parentNode.insertBefore(bp, s);
})();
</script>
<!-- 快速添加 FAQ -->
<script type="text/javascript">

	$("#addLink").click(function(){	
		var urlname =$("#urlname").val();
		var url = document.getElementById("url").value;
		//alert(urlname+"；"+url);
		if(urlname==null && urlname==""){
			alert("URL Name 不能为空！");
		}else if(url==null && url==""){
			alert("URL 不能为空！");
		}else{
			var reg=/(http|ftp|https):\/\/[\w\-_]+(\.[\w\-_]+)+([\w\-\.,@?^=%&:/~\+#]*[\w\-\@?^=%&/~\+#])?/;
			if(!reg.test(url)){
				 alert("这网址不是以http://https://开头，或者不是网址！");
			}else{
				var link ={"urlname":urlname,
						"url":url};
				$.post("${pageContext.request.contextPath}/FAQ/links/fastsave",link,function(result){
					if(result==1){
						alert("快速添加FAQ成功");
						$('#exampleModal').modal('hide');
						var urlname =$("#urlname").val('');
						var url = $("#url").val('');
					}else{
						alert("添加失败！");
					}
				});
				}
			}
		});


</script>
<script type="text/javascript">
	function timer(opj){
		$(opj).find('ul').animate({
			marginTop : "-2.5rem"  
			},500,function(){  
			$(this).css({marginTop : "0.3rem"}).find("li:first").appendTo(this);  
		})  
	}
	var i=0;
	function volume(){
		if(i==2){
			$("#volume").removeClass("fa-volume-up");
			$("#volume").addClass("fa-volume-off");
			i=0;
		}
		if(i==1){
			$("#volume").removeClass("fa-volume-down");
			$("#volume").addClass("fa-volume-up");
			i=2;
		}
		if(i==0){
			$("#volume").removeClass("fa-volume-off");
			$("#volume").addClass("fa-volume-down");
			i=1;
		}
	}
	
	$(function(){ 
		setInterval('volume()',1000);
		var num = $('.notice_active').find('li').length;
		if(num > 1){
		   var time=setInterval('timer(".notice_active")',5000);
			$('.notice_active ul li').mousemove(function(){
				clearInterval(time);
			}).mouseout(function(){
				time = setInterval('timer(".notice_active")',5000);
			}); 
		}
	});
</script>