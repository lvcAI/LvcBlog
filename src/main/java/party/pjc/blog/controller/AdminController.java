package party.pjc.blog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import party.pjc.blog.model.Categories;
import party.pjc.blog.model.Link;
import party.pjc.blog.model.PageBean;
import party.pjc.blog.model.Post;
import party.pjc.blog.model.Post_Categories;
import party.pjc.blog.model.Post_Tags;
import party.pjc.blog.model.Tags;
import party.pjc.blog.model.User;
import party.pjc.blog.service.CategoriesService;
import party.pjc.blog.service.LinkService;
import party.pjc.blog.service.PostService;
import party.pjc.blog.service.TagsService;
import party.pjc.blog.service.UserService;
import party.pjc.blog.sys.LvcBlogSystem;
import party.pjc.blog.util.PropertiesUtil;
import party.pjc.blog.util.ResponseUtil;
import party.pjc.blog.util.StringUtil;


@Controller
@RequestMapping("/admin")
public class AdminController {

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
	
	private LvcBlogSystem system;

	@RequestMapping(value="/admin",method=RequestMethod.GET)
	public String allTag(HttpServletRequest requset){
		
		return "/admin";
	}
	
	/*@RequestMapping(value="/post/add",method=RequestMethod.GET)
	public String addPost(HttpServletRequest requset){
		requset.setAttribute("mainPage", "post/addpost.jsp");
		requset.setAttribute("edit_post_tags",tagsService.findAllTag() );
		requset.setAttribute("edit_post_cates",categoriesService.findAllCategories());
		List<Post> posts =postService.selectPostsAndTags(new PageBean(1, Integer.parseInt(PropertiesUtil.getValue("pageSize")))); 
		HttpSession session = requset.getSession();
		session.setAttribute("posts",posts );
		return "/admin";
	}
	
	@RequestMapping(value="/post/delete/{postId}",method=RequestMethod.POST)
	public String deletePost(@PathVariable("postId") int postId,HttpServletRequest requset,HttpServletResponse response){
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
		return null;
	}

	
	@SuppressWarnings("unused")
	@RequestMapping(value="/post/save",method=RequestMethod.POST)
	public String savePost(Post post,HttpServletRequest requset){
		
		HttpSession session = requset.getSession();
		
		int postId =0;
		String tags1 = requset.getParameter("tags1");
		String categories1 = requset.getParameter("categories1");
		String updateId =requset.getParameter("updateId");
		
		if(StringUtil.isNotEmpty(updateId)){
			post.setId(Integer.parseInt(updateId));
			post.setState(1);
			postService.updatePost(post);
			System.out.println(postService.findPostById(Integer.parseInt(updateId)));
			List<Post> posts =postService.selectPostsAndTags(new PageBean(1, Integer.parseInt(PropertiesUtil.getValue("pageSize")))); 
			try {
				system = new LvcBlogSystem();
				system.refreshSystem(requset);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "redirect:/blog/post/"+Integer.parseInt(updateId);
		}else{		
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
			system = new LvcBlogSystem();
			system.refreshSystem(requset);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/admin/admin";
	}
	
	@RequestMapping(value="/post/list",method=RequestMethod.GET)
	public String postList(HttpServletRequest requset){
		requset.setAttribute("mainPage", "post/postlist.jsp");
		requset.setAttribute("pos_list", postService.findAllPost(1));
		return "/admin";
	}
	@RequestMapping(value="/post/update/{postId}",method=RequestMethod.GET)
	public String postUpdate(@PathVariable("postId") int postId,HttpServletRequest requset){
		
		Post update_post =postService.findPostById(postId);
		System.out.println(update_post);
		requset.setAttribute("update_post", update_post);
		requset.setAttribute("mainPage", "post/addpost.jsp");
		requset.setAttribute("pos_list", postService.findAllPost(1));
		return "/admin";
	}
	
	
	@RequestMapping(value="/post/trash",method=RequestMethod.GET)
	public String post(HttpServletRequest requset){
		requset.setAttribute("pos_list", postService.findAllPost(2));
		requset.setAttribute("mainPage", "post/postlist.jsp");
		return "/admin";
	}*/
	
//	Link 管理
/*	@RequestMapping(value="/links/add",method=RequestMethod.GET)
	public String addLink(HttpServletRequest requset){
		requset.setAttribute("mainPage", "link/addLink.jsp");
		
		return "/admin";
	}

	@RequestMapping(value="/links/save",method=RequestMethod.POST)
	public String saveLink(Link link,HttpServletRequest requset){
		String updateId = requset.getParameter("updateId");
		if(StringUtil.isEmpty(updateId)){
			linkService.insertLink(link);
		}else{
			
		}
		requset.setAttribute("mainPage", "link/Linklist.jsp");
		requset.setAttribute("link_list", linkService.findAllLink(new Link("test",null),null));
		return "/admin";
	}
	
	
	@RequestMapping(value="/links/list",method=RequestMethod.GET)
	public String linkList(HttpServletRequest requset){
		requset.setAttribute("mainPage", "link/Linklist.jsp");
		requset.setAttribute("link_list", linkService.findAllLink(new Link(null,1),null));
		return "/admin";
	}*/
	
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(User user,HttpServletRequest requset){
		
		HttpSession session = requset.getSession();
		
		
		if(user!=null){
			User currentUser = userService.login(user);
			session.setAttribute("currentUser", currentUser);
		}
		Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken(user.getUserName(),user.getPassword());
		System.out.println(user);
		try{
			subject.login(token);
			Session s = subject.getSession();
			s.setTimeout(7200000);//设置过期时间 为2小时，默认时间是30分钟，每次写个博客写完了，提交一下 会话过期，东西全没了
			return "redirect:/admin/admin";
		}catch(Exception e){
			e.printStackTrace();
			session.setAttribute("currentUser", user);
			session.setAttribute("errorMsg", "用户名或密码错误！");
			return "redirect:/login";
		}
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpServletRequest requset){
		Subject subject=SecurityUtils.getSubject();
		subject.logout();
		return "redirect:/";
	}
}
