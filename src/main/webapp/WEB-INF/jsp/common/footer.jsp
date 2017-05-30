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
							<a href="http://pjc.party" title="彭佳成的博客" target="_blank">彭佳成的博客</a> 
							
							<hr>
							<a href="http://bootcss.com/" title="Bootstrap中文网" target="_blank">Bootstrap中文网</a> 
							<a href="http://www.runoob.com/" title="菜鸟教程" target="_blank">菜鸟教程</a>
							<a href="http://www.csdn.net/" title="CSDN" target="_blank">CSDN</a>
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