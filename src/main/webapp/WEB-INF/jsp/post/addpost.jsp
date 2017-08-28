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
					<form class="am-form" id="add-article-form" action="${pageContext.request.contextPath}/admin/post/save" method="post">
				
						 <input type="text" class="form-control" id="title" placeholder="请输入文章标题，不要超过30个字符" name="title" value="${update_post.title}" onfocus="javascript:toggle('none')" required="required"/>	
						<input type="hidden" id="updateId"  name="updateId" value="${update_post.id}"/>
					<div class="editormd" id="id_editormd">
					  <textarea class="editormd-markdown-textarea" id="markdown" name="markdown" onfocus="javascript:toggle('none')" required="required" >${update_post.markdown }</textarea>
  					  <textarea class="editormd-html-textarea" name="html" >${update_post.markdown }</textarea>
					  <!-- 第二个隐藏文本域，用来构造生成的HTML代码，方便表单POST提交，这里的name可以任意取，后台接受时以这个name键为准 -->
					</div>	
					<div class="tags">
						 <input type="text" name="tags1" class="form-control" id="tags" placeholder="多个 Tag 请用 ','分隔开来" 
						 onfocus="javascript:toggle('tags')" required="required"  />
						<div id="tag2box1" class="tag2box" style="display:none ;">
							<table>
								<tbody>
									<c:if test="${not empty edit_post_tags}">
										<tr>
										<th  style="padding-right: 10px;">常用标签</th>
											<td id="td_tag21" >
											<c:forEach items="${edit_post_tags }" var="tag">
												<a onclick="javascript:setTag2('${tag.tagName}');return false;" class="${tag.tagName}" target="_blank">${tag.tagName}</a>
											</c:forEach>
											</td>
										</tr>
										<tr>
											<th  style="padding-right: 10px;">推荐标签</th>
											<td id="td_tag22"  >
													<c:forEach items="${update_post.tags}" var="tag">
												<a onclick="javascript:setTag2(this);return false;" class="" target="_blank">${tag.tagName}</a>
											</c:forEach>
											</td>
										</tr>
									</c:if>
									<c:if test="${not empty update_post}">
										<tr>
										<th style="padding-right: 10px;">常用标签</th>
											<td id="td_tag21" class="tracking-ad" data-mod="popu_133">
											<c:forEach items="${tagss }" var="tag">
												<a onclick="javascript:setTag2('${tag.tagName}');return false;" class="${tag.tagName}" target="_blank">${tag.tagName}</a>
											</c:forEach>
											</td>
										</tr>
										<tr>
											<th  style="padding-right: 10px;">已有标签</th>
											<td id="td_tag22" class="tracking-ad" data-mod="popu_73" >
													<c:forEach items="${update_post.tags }" var="tag">
												<a onclick="javascript:return false;" class="${tag.tagName}" target="_blank">${tag.tagName}</a>
											</c:forEach>
											</td>
										</tr>
									</c:if>
								</tbody>
							</table>
						</div>
						 
						 <input type="text" name="categories1" class="form-control" id="categories1" placeholder="分类只能有一个，请尽量简洁。如有多过个，默认为第一个..." 
						  onfocus="javascript:toggle('categories')"  required="required" />
					<div id="tag2box2" class="tag2box" style="display: none;">
						<table id="tagtb" cellspacing="0">
							<tbody>

										<tr>
										<th  style="padding-right: 10px;">常用分类</th>
											<td id="td_tag21" >
											<c:forEach items="${categoriess }" var="cate">
												<a onclick="javascript:setCate2('${cate.typeName}');return false;"  target="_blank">${cate.typeName}</a>
											</c:forEach>
											</td>
										</tr>
										<tr>
											<th  style="padding-right: 10px;">已有标签</th>
											<td id="td_tag22" class="tracking-ad" data-mod="popu_73" >
													
												<a href="javascript:return false;" target="_blank">${update_post.categories.categoriesName==null?"无":update_post.categories.categoriesName}</a>
											
											</td>
										</tr>

							</tbody>
						</table>
					</div>
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
<!-- 自动保存草稿  -->
 <%-- <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.powertimer.js" ></script>
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
     </script>
 --%>
