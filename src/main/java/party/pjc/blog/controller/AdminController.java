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
		requset.setAttribute("mainPage", "admin/index.jsp");
		return "/admin";
	}
	

	
	
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
			requset.setAttribute("mainPage", "admin/index.jsp");
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
