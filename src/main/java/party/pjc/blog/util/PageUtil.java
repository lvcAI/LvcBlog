package party.pjc.blog.util;

import java.util.List;

import party.pjc.blog.model.Post;



public class PageUtil {
	/**
	 * 
	 * @param totalNum
	 * @param currentPage
	 * @param pageSize
	 * @param typeId
	 * @return
	 */
	/**
	 * 
	 * <nav class="pagination" role="navigation">
			<span class="page-number">第 ${page.page } 页 ⁄ ${totalPage} 共 页</span>
		 	<a class="older-posts" href="blog/post/page/2"> <i class="fa fa-angle-right"></i></a>
		</nav>
	 * 
	 */
	public static String getIndexPage(int totalNum,int currentPage ,int pageSize ,String basePath){
		//获取总页数  一个计算总页数的常用算法
		int totalPage=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
		System.out.println("总页数:"+totalPage);
		StringBuffer pageCode = new StringBuffer();
		pageCode.append("<nav class='pagination' role='navigation'>");
		if(currentPage==1){
			//	
			
		}else{
			pageCode.append(" <a class='older-posts' style='margin:10px 10px;' href='"+basePath+(currentPage-1)+"'> <i class='fa fa-angle-left'></i></a>");
		}
		pageCode.append(" <span class='page-number' style='margin:10px 0px;'>第 "+currentPage+" 页 ⁄ "+totalPage+" 共 页</span>");
		if(totalPage==currentPage){
			//pageCode.append(" <li class='disabled'><a href='#'>下一页</a></li>");
		}else{			
			pageCode.append(" <a class='older-posts' style='margin:10px 10px;'  href='"+basePath+(currentPage+1)+"'> <i class='fa fa-angle-right'></i></a>");
		}
		pageCode.append("</nav>");
		return pageCode.toString();
	}
	public static String getIndexPage2(int totalNum,int currentPage ,int pageSize ,String basePath){
		//获取总页数  一个计算总页数的常用算法
		int totalPage=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
		System.out.println("总页数:"+totalPage);
		StringBuffer pageCode = new StringBuffer();
		pageCode.append("<nav class='pagination' role='navigation'>");
		if(currentPage==1){
			//	
			
		}else{
			pageCode.append(" <a class='older-posts' style='margin:10px 10px;'  href='"+basePath+(currentPage-1)+"'> <i class='fa fa-angle-left'></i></a>");
		}
		pageCode.append(" <span class='page-number'>第 "+currentPage+" 页 ⁄ "+totalPage+" 共 页</span>");
		if(totalPage==currentPage){
			//pageCode.append(" <li class='disabled'><a href='#'>下一页</a></li>");
		}else{			
			pageCode.append(" <a class='older-posts' style='margin:10px 10px;'  href='"+basePath+(currentPage+1)+"'> <i class='fa fa-angle-right'></i></a>");
		}
		pageCode.append("</nav>");
		return pageCode.toString();
	}
	public static String getUpAndDwonPageCode(int totalNum,int currentPage ,int pageSize ,String typeId){
		//获取总页数  一个计算总页数的常用算法
		int totalPage=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
		System.out.println("总页数:"+totalPage);
		StringBuffer pageCode = new StringBuffer();
		pageCode.append("<ul class='pager'>");
		if(currentPage==1){
			pageCode.append(" <li class='disabled'><a href='#'>上一页</a></li>");
		}else{
			pageCode.append(" <li><a href='news?action=list&typeId="+typeId+"&page="+(currentPage-1)+"'>上一页</a></li>");
		}
		pageCode.append("&nbsp;&nbsp;");
		if(totalPage==currentPage){
			pageCode.append(" <li class='disabled'><a href='#'>下一页</a></li>");
		}else{			
			pageCode.append(" <li><a href='news?action=list&typeId="+typeId+"&page="+(currentPage+1)+"'>下一页</a></li>");
		}
		pageCode.append("</ul>");
		return pageCode.toString();
	}
	
	
/*	<nav class="pagination" role="navigation">
		<a class="older-posts" href="${pageContext.request.contextPath}/blog/post/2" style="text-decoration: none;  padding-right: 18px;">
			<i	class="fa fa-angle-left"></i>上一篇
		</a>
		<a class="older-posts" href="${pageContext.request.contextPath}/blog/post/2" style="text-decoration: none;  padding-right: 18px;">
			<i	class="fa fa-angle-right"></i>下一篇
		</a>
	</nav>
	*/
	
	public static String getUpAndDwonPage(List<Post> newsList,String basePath){
		Post upPage=newsList.get(0);
		Post downPage=newsList.get(1);
		StringBuffer pageCode = new StringBuffer();
		pageCode.append("<nav class='pagination' role='navigation'>");
		if(upPage.getId()==-1){
			pageCode.append("<a class='older-posts' href='#' style='text-decoration: none;  margin:10px 10px; padding-right: 18px;'><i	class='fa fa-angle-left'></i>没有了</a>");
		}else{
			pageCode.append("<a class='older-posts' href='"+basePath+"/blog/post/"+upPage.getId()+"' style='text-decoration: none; margin:10px 10px;  padding-right: 18px;' title="+upPage.getTitle()+"><i	class='fa fa-angle-left'></i>上一篇:"+(upPage.getTitle().length()>10?upPage.getTitle().substring(0,10):upPage.getTitle())+"</a>");
		}
		if(downPage.getId()==-1){
			pageCode.append("<a class='older-posts' href='#' style='text-decoration: none; margin:10px 10px; padding-right: 18px;'><i	class='fa fa-angle-right'></i>没有了</a>");
		}else{
			pageCode.append("<a class='older-posts' href='"+basePath+"/blog/post/"+downPage.getId()+"' style='text-decoration: none;  margin:10px 10px; padding-right: 18px;' title="+downPage.getTitle()+"><i	class='fa fa-angle-right'></i>下一篇:"+(downPage.getTitle().length()>10?downPage.getTitle().substring(0,10):downPage.getTitle())+"</a>");
		}
		
		return pageCode.toString();
	}
	
	public static String getUpAndDwonPageCode(int totalNum,int currentPage ,int pageSize){
		//获取总页数  一个计算总页数的常用算法
		int totalPage=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
		System.out.println("总页数:"+totalPage);
		StringBuffer pageCode = new StringBuffer();
		pageCode.append("<ul class='pager'>");
		if(currentPage==1){
			pageCode.append(" <li class='disabled'><a href='#'>上一页</a></li>");
		}else{
			pageCode.append(" <li><a href='link?action=backlist&page="+(currentPage-1)+"'>上一页</a></li>");
		}
		pageCode.append("&nbsp;&nbsp;");
		if(totalPage==currentPage){
			pageCode.append(" <li class='disabled'><a href='#'>下一页</a></li>");
		}else{			
			pageCode.append(" <li><a href='link?action=backlist&page="+(currentPage+1)+"'>下一页</a></li>");
		}
		pageCode.append("</ul>");
		return pageCode.toString();
	}
	
	public static String getUpAndDwonPageCode2(int totalNum,int currentPage ,int pageSize){
		//获取总页数  一个计算总页数的常用算法
		int totalPage=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
		System.out.println("总页数:"+totalPage);
		StringBuffer pageCode = new StringBuffer();
		pageCode.append("<ul class='pagination'>");
		
		pageCode.append(" <li ><a href='comment?action=backlist&page=1'>首页</a></li>");
		if(currentPage==1){
			pageCode.append(" <li class='disabled'><a href='#'>上一页</a></li>");
		}else{
			pageCode.append(" <li><a href='comment?action=backlist&page="+(currentPage-1)+"'>上一页</a></li>");
		}
		pageCode.append("&nbsp;&nbsp;");
//		if(currentPage>2&&currentPage<totalPage-2){
//			
//			for(int i= currentPage-2;i<currentPage+2;i++){
//				pageCode.append(" <li><a href='comment?action=backlist&page="+i+"'>"+i+"</a></li>");
//			}
//		}
		for(int i=currentPage-2;i<=currentPage+2;i++){
			if(i<1 || i>totalPage){
				continue;
			}
			if(i==currentPage){
				pageCode.append("<li class='active'><a href='#'>"+i+"</a></li>");
			}else{
				pageCode.append("<li><a href='comment?action=backlist&page="+i+"'>"+i+"</a></li>");
			}
			
		}
		if(totalPage==currentPage){
			pageCode.append(" <li class='disabled'><a href='#'>下一页</a></li>");
		}else{			
			pageCode.append(" <li><a href='comment?action=backlist&page="+(currentPage+1)+"'>下一页</a></li>");
		}
		pageCode.append(" <li ><a href='comment?action=backlist&page="+totalPage+"'>尾页</a></li>");
		pageCode.append("</ul>");
		return pageCode.toString();
	}
	public static String getUpAndDownPagation(int totalNum,int currentPage,int pageSize,String typeId){
		int totalPage=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
		StringBuffer pageCode=new StringBuffer();
		pageCode.append("<ul class='pager'>");
		if(currentPage==1){
			pageCode.append("<li class='disabled'><a href='#'>上一页</a></li>");
		}else{
			pageCode.append("<li><a href='news?action=list&typeId="+typeId+"&page="+(currentPage-1)+"'>上一页</a></li>");			
		}
		pageCode.append("&nbsp;&nbsp;");
		if(currentPage==totalPage){
			pageCode.append("<li class='disabled'><a href='#'>下一页</a></li>");
		}else{
			pageCode.append("<li><a href='news?action=list&typeId="+typeId+"&page="+(currentPage+1)+"'>下一页</a></li>");			
		}
		pageCode.append("</ul>");
		return pageCode.toString();
	}
	
	public static String getPagation(String targetUrl,int totalNum,int currentPage,int pageSize){
		int totalPage=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
		StringBuffer pageCode=new StringBuffer();
	
		pageCode.append("<li ><a href='"+targetUrl+"'>首页</a></li>");
		if(currentPage==1){
			pageCode.append("<li class='disabled'><a href='#'>上一页</a></li>");
		}else{
			pageCode.append("<li><a href='"+targetUrl+"/page/"+(currentPage-1)+"'>上一页</a></li>");
		}
		
		for(int i=currentPage-2;i<=currentPage+2;i++){
			if(i<1 || i>totalPage){
				continue;
			}
			if(i==currentPage){
				pageCode.append("<li class='active'><a href='#'>"+i+"</a></li>");
			}else{
				pageCode.append("<li><a href='"+targetUrl+"/page/"+i+"'>"+i+"</a></li>");
			}
			
		}
		
		if(currentPage==totalPage){
			pageCode.append("<li class='disabled'><a href='#'>下一页</a></li>");
		}else{
			pageCode.append("<li><a href='"+targetUrl+"/page/"+(currentPage+1)+"'>下一页</a></li>");
		}
		pageCode.append("<li><a href='"+targetUrl+"/page/"+totalPage+"'>尾页</a></li>");
		return pageCode.toString();
	}
}
/**
 * <nav>
  <ul class="pagination">
    <li class="disabled"><a href="#">&laquo;</a></li>
    <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
    ...
  </ul>
</nav>



 *
 */


