package party.pjc.blog.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.druid.sql.PagerUtils;

import party.pjc.blog.lucene.PostIndex;
import party.pjc.blog.model.Categories;
import party.pjc.blog.model.PageBean;
import party.pjc.blog.model.Post;
import party.pjc.blog.model.Post_Categories;
import party.pjc.blog.model.Post_Tags;
import party.pjc.blog.model.Tags;
import party.pjc.blog.rediscache.JedisClientSingleService;
import party.pjc.blog.service.CategoriesService;
import party.pjc.blog.service.LinkService;
import party.pjc.blog.service.PostService;
import party.pjc.blog.service.TagsService;
import party.pjc.blog.service.UserService;
import party.pjc.blog.sys.LvcBlogSystem;
import party.pjc.blog.util.PageUtil;
import party.pjc.blog.util.PropertiesUtil;
import party.pjc.blog.util.ResponseUtil;
import party.pjc.blog.util.StringUtil;

@Controller
@RequestMapping("/admin/post")
public class PostAdminController {
	
	Logger _log = Logger.getLogger(PostAdminController.class);
	
	
	@Autowired
	private TagsService tagsService;
	@Autowired
	private UserService userService;
	@Autowired
	private CategoriesService categoriesService;
	@Autowired
	private PostService postService; 
	@Autowired
	private LinkService linkService;
	
	@Autowired
	private JedisClientSingleService jedisClientSingleService;
	
	private LvcBlogSystem system;
	
	private PostIndex postindex = new PostIndex();;
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addPost(HttpServletRequest requset){
		requset.setAttribute("mainPage", "post/addpost.jsp");
		requset.setAttribute("edit_post_tags",tagsService.findAllTag() );
		requset.setAttribute("edit_post_cates",categoriesService.findAllCategories());
		List<Post> posts =postService.selectPostsAndTags(new PageBean(1, Integer.parseInt(PropertiesUtil.getValue("pageSize")))); 
		HttpSession session = requset.getSession();
		session.setAttribute("posts",posts );
		
		
		return "/admin";
	}
	
	@RequestMapping(value="/delete/{postId}",method=RequestMethod.POST)
	public String deletePost(@PathVariable("postId") int postId,HttpServletRequest requset,HttpServletResponse response){
		_log.info("======== 执行 post 删除操作 ==========");
		int result= postService.updatePost(new Post(postId,2));
		requset.setAttribute("pos_list", postService.findAllPost(1));
		requset.setAttribute("mainPage", "post/postlist.jsp");
		try {
			if(result>0){
				ResponseUtil.write(1, response);
			}else{
				ResponseUtil.write(0, response);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			system = new LvcBlogSystem();
			system.refreshSystem(requset);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		_log.info("======== 执行 post 删除操作结束 ==========");
		return null;
	}

	
	@SuppressWarnings("unused")
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String savePost(Post post,HttpServletRequest requset){
		_log.info("======== 执行 post 保存或更新操作 ==========");
		HttpSession session = requset.getSession();
		
		int postId =0;
		String tags1 = requset.getParameter("tags1");
		String categories1 = requset.getParameter("categories1");
		String updateId =requset.getParameter("updateId");
		
		if(StringUtil.isNotEmpty(updateId)){
			_log.info("======== 执行 post 更新操作 ==========");
			post.setId(Integer.parseInt(updateId));
			post.setState(1);
			postService.updatePost(post);
			System.out.println(postService.findPostById(Integer.parseInt(updateId)));
			List<Post> posts =postService.selectPostsAndTags(new PageBean(1, Integer.parseInt(PropertiesUtil.getValue("pageSize")))); 
			try {
				_log.info("======== 刷新缓存 ==========");
				system = new LvcBlogSystem();
				system.refreshSystem(requset);
				_log.info("======== 刷新结束 ==========");
				//更新索引
				_log.info("======== 更新索引 ==========");
				
				postindex.updateIndex(postService.findPostById(Integer.parseInt(updateId)));
				_log.info("======== 更新索引结束 ==========");
				_log.info("======== 执行 post 更新借宿 ==========");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return "redirect:/blog/post/"+Integer.parseInt(updateId);
		}else{
			_log.info("======== 执行 post 更新操作 ==========");
			if(post.getTitle()!=null || post.getTitle()!="" ){
				post.setState(1);
				int result = postService.insertPost(post);
				if(result>0){
					postId = postService.findPostByTitle(post.getTitle()).getId();
					requset.setAttribute("pos_list", postService.findAllPost(1));
					requset.setAttribute("mainPage", "post/postlist.jsp");
					
				}
			}
			
			if(StringUtil.isNotEmpty(tags1)){
				String[] tags =tags1.trim().split(",");
				int tagsId=0;
				for(int i=0;i<tags.length;i++){
					
					Tags tag = tagsService.findTagsByName(tags[i]);
					
					if(tag==null){
						tagsService.insertTag(new Tags(tags[i]));
						tagsId=tagsService.findTagsByName(tags[i]).getId();
					}else{
						tagsId = tag.getId();
					}
					
					postService.insertPostAndTag(new Post_Tags(postId,tagsId));
				}
				
			}
			if(StringUtil.isNotEmpty(categories1)){
				String[] categories =categories1.trim().split(",");
				int cateId=0;
				Categories cate = categoriesService.findCategoriesByName(categories[0].trim());	
				
				if(cate==null){
					categoriesService.insertCategories(new Categories(categories1.trim()));
					cateId=categoriesService.findCategoriesByName(categories1.trim()).getId();
				}else{
					cateId=cate.getId();
				}
				
				postService.insertPostAndCate(new Post_Categories(postId,cateId));
			}
		}
		session.setAttribute("posts", postService.selectPostsAndTags(new PageBean(1, Integer.parseInt(PropertiesUtil.getValue("pageSize")))));
		try {
			
			_log.info("======== 添加索引 ==========");
			postindex.addIndex(postService.findPostByTitle(post.getTitle()));
			_log.info("======== 添加索引结束 ==========");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/admin/admin";
	}
	

	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String postList(HttpServletRequest requset){
		String basePath = requset.getContextPath();
		requset.setAttribute("navPage",PageUtil.getPagation(basePath+"/admin/post/list", postService.getPostCount(), 1, 10));
		requset.setAttribute("mainPage", "post/postlist.jsp");
		requset.setAttribute("pos_list", postService.selectPostsAndTags(new PageBean(1, 10)));
		return "/admin";
	}
	
	@RequestMapping(value="/list/page/{page}",method=RequestMethod.GET)
	public String postListPage(@PathVariable("page") String page,HttpServletRequest requset){
		
		int currentPage =0;
		if(page==null){
			currentPage=1;
		}else{
			currentPage = Integer.parseInt(page);
		}
		String basePath = requset.getContextPath();
		requset.setAttribute("mainPage", "post/postlist.jsp");
		requset.setAttribute("pos_list", postService.selectPostsAndTags(new PageBean(currentPage, 10)));
		requset.setAttribute("navPage",PageUtil.getPagation(basePath+"/admin/post/list", postService.getPostCount(), currentPage, 10));
		System.out.println("说点是什么吧！");
		return "/admin";
	}
	
	
	@RequestMapping(value="/update/{postId}",method=RequestMethod.GET)
	public String postUpdate(@PathVariable("postId") int postId,HttpServletRequest requset){
		
		Post update_post =postService.findPostById(postId);
		System.out.println(update_post);
		requset.setAttribute("update_post", update_post);
		requset.setAttribute("mainPage", "post/addpost.jsp");
		requset.setAttribute("pos_list", postService.findAllPost(1));
		return "/admin";
	}
	
	
	@RequestMapping(value="/trash",method=RequestMethod.GET)
	public String post(HttpServletRequest requset){
		requset.setAttribute("pos_list", postService.findAllPost(2));
		requset.setAttribute("mainPage", "post/postlist.jsp");
		return "/admin";
	}
	
	// 保存为草稿，只做数据的保存，不存在数据库中。
	@RequestMapping(value="/presave",method=RequestMethod.POST)
	public void presave(HttpServletRequest requset,HttpServletResponse response){
		// 获取 表单 数据 
		String updateId =requset.getParameter("updateId");
		String title =requset.getParameter("title");
		String markdown =requset.getParameter("markdown");
		String html =requset.getParameter("html");
		String tags =requset.getParameter("tags");
		String categories1 =requset.getParameter("categories1");
    	Post post = new Post();
    	post.setHtml(html);
    	post.setMarkdown(markdown);
    	post.setTitle(title);
    	post.setState(0);
    	post.setRate(0);
    	// 保存 草稿
    	int result=0;
    	if(StringUtil.isEmpty(updateId)){
    		postService.insertPost(post);    		
    		 result =postService.findPostByTitle(title).getId();
    	}else{
    		post.setId(Integer.parseInt(updateId));
    		result = postService.updatePost(post);
    	}
		//String result ="后台传回来的数据！";
		
		try {
			ResponseUtil.write(result, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
