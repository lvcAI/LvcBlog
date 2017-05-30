package party.pjc.blog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import party.pjc.blog.lucene.PostIndex;
import party.pjc.blog.model.PageBean;
import party.pjc.blog.model.Post;
import party.pjc.blog.model.vo.EmailResult;
import party.pjc.blog.rediscache.JedisClientSingleService;
import party.pjc.blog.service.PostService;
import party.pjc.blog.sys.LvcBlogSystem;
import party.pjc.blog.util.EmailUtils;
import party.pjc.blog.util.PageUtil;
import party.pjc.blog.util.PropertiesUtil;
import party.pjc.blog.util.StringUtil;

@Controller
@RequestMapping("/blog")
public class PostController {
	
	private static Logger logger = Logger.getLogger(PostController.class);  
	
	@Autowired
	private PostService postService;
	@Autowired
	private JedisClientSingleService jedisClientSingleService;
	private LvcBlogSystem system;
	
	@RequestMapping("/post/{id}")
	public String index( @PathVariable("id") int id,HttpServletRequest request){
		//ModelAndView modelAndView = new ModelAndView();
		String url = request.getRequestURI();
		//在请求时，保存请求的路径，key= post/id,value=post
		Post post=null;
		post = postService.findPostById(id);
		logger.info("请求路径："+url);
		//这里不适合用缓存操作。每一次请求，都会有数据的变更。缓存适合用于大量的读取操作且内容`不`改变
/*	//	System.out.println("请求路径："+url);
		logger.info("--------开始进行缓存 读写 操作 开始-----------");
		Gson gson = new Gson();
		if(!jedisClientSingleService.exists(url)){
			post = postService.findPostById(id);
			String postToJosn = gson.toJson(post);
			jedisClientSingleService.set(url, postToJosn);
			jedisClientSingleService.expire(url, 1000*60*60*6);//设置过期时间为 6 hour
			System.out.println("添加缓存!");
		}else{
			post =gson.fromJson(jedisClientSingleService.get(url), Post.class);
		//	System.out.println("通过缓存获取Post"+post);
		}
		logger.info("--------开始进行缓存 读写 操作 结束-----------");*/
		// post = postService.findPostById(id);
		/*if(post.getState()==2){
			return null;
		}*/
		post.setRate(post.getRate()+1);
		postService.updatePostByRate(post);
		system = new LvcBlogSystem();
		//刷新系统换缓存
		try {
		//	system.refreshSystem(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	modelAndView.setViewName("/post/showpost");
		request.setAttribute("post", postService.findPostById(id));
		request.setAttribute("navPage", PageUtil.getUpAndDwonPage(postService.findUpAndDown(id), request.getContextPath()));
		
		/**
		 * 获取每个访问者的信息，获取Ip 信息，并发送一封邮件给管理员。
		 */
		EmailResult email = new  EmailResult("328097822@qq.com","有游客访问了你的网站。","\n访问的地址："+url+"；\n访问者Ip："+StringUtil.getIpAddr(request));
		try {
			EmailUtils.sendEmail(email);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("邮件发送错误："+e1);
		}
		return "/post/showpost";
	}
	
	@RequestMapping("/post/add")
	public String add(HttpServletRequest request){
	
		return "/post/addpost";
	}
	
	@RequestMapping("/post/page/{page}")
	public String showPagePost(@PathVariable("page") int page,HttpServletRequest request){
		//ModelAndView modelAndView = new ModelAndView();
		
		PageBean pageBean = new PageBean(page, Integer.parseInt(PropertiesUtil.getValue("pageSize")));
		int totalPost = postService.getPostCount();
	//	int totalPage=totalPost%pageBean.getPageSize()==0?totalPost/pageBean.getPageSize():totalPost/pageBean.getPageSize()+1;
		List<Post> posts = postService.selectPostsAndTags(pageBean);
		String basePath = request.getContextPath();
		request.setAttribute("postList", posts);
		request.setAttribute("navPage", PageUtil.getIndexPage(totalPost, page, pageBean.getPageSize(), basePath+"/blog/post/page/"));
		
		return "/post/index";
	}
	
	
	@RequestMapping("/post/draft")
	public ModelAndView draftPost(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/post/draft");
		return mav;
	}
	
	
	/**
	 * 根据关键字查询相关博客信息
	 * @param q
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/post/q")
	public ModelAndView search(@RequestParam(value="q",required=false)String q,@RequestParam(value="page",required=false)String page,HttpServletRequest request)throws Exception{
		System.out.println("q："+q);
		if(StringUtil.isEmpty(page)){
			page="1";
		}
		PostIndex postIndex = new PostIndex();
		ModelAndView mav=new ModelAndView();
	//	mav.addObject("mainPage", "foreground/blog/result.jsp");
		

		List<Post> blogList=postIndex.searchPost(q.trim());
		Integer toIndex=blogList.size()>=Integer.parseInt(page)*10?Integer.parseInt(page)*10:blogList.size();
		mav.addObject("blogList",blogList.subList((Integer.parseInt(page)-1)*10, toIndex));
	//	mav.addObject("pageCode",this.genUpAndDownPageCode(Integer.parseInt(page), blogList.size(), q,10,request.getServletContext().getContextPath()));
		mav.addObject("q",q);
		mav.addObject("resultTotal",blogList.size());
		mav.addObject("pageTitle","搜索关键字'"+q+"'结果页面");
		mav.setViewName("/post/result");
		return mav;
	}
	
	/**
	 * 获取下一篇博客和下一篇博客代码
	 * @param lastBlog
	 * @param nextBlog
	 * @return
	 */
	private String genUpAndDownPageCode(Post lastBlog,Post nextBlog,String projectContext){
		StringBuffer pageCode=new StringBuffer();
		if(lastBlog==null || lastBlog.getId()>0){
			pageCode.append("<p>上一篇：没有了</p>");
		}else{
			pageCode.append("<p>上一篇：<a href='"+projectContext+"/blog/articles/"+lastBlog.getId()+".html'>"+lastBlog.getTitle()+"</a></p>");
		}
		if(nextBlog==null || nextBlog.getId()>0){
			pageCode.append("<p>下一篇：没有了</p>");
		}else{
			pageCode.append("<p>下一篇：<a href='"+projectContext+"/blog/articles/"+nextBlog.getId()+".html'>"+nextBlog.getTitle()+"</a></p>");
		}
		return pageCode.toString();
	}
	
	/**
	 * 获取上一页，下一页代码 查询博客用到
	 * @param page 当前页
	 * @param totalNum 总记录数
	 * @param q 查询关键字
	 * @param pageSize 每页大小
	 * @param projectContext
	 * @return
	 */
	private String genUpAndDownPageCode(Integer page,Integer totalNum,String q,Integer pageSize,String projectContext){
		long totalPage=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
		StringBuffer pageCode=new StringBuffer();
		if(totalPage==0){
			return "";
		}else{
			pageCode.append("<nav>");
			pageCode.append("<ul class='pager' >");
			if(page>1){
				pageCode.append("<li><a href='"+projectContext+"/blog/q.html?page="+(page-1)+"&q="+q+"'>上一页</a></li>");
			}else{
				pageCode.append("<li class='disabled'><a href='#'>上一页</a></li>");
			}
			if(page<totalPage){
				pageCode.append("<li><a href='"+projectContext+"/blog/q.html?page="+(page+1)+"&q="+q+"'>下一页</a></li>");				
			}else{
				pageCode.append("<li class='disabled'><a href='#'>下一页</a></li>");				
			}
			pageCode.append("</ul>");
			pageCode.append("</nav>");
		}
		return pageCode.toString();
	}
}

