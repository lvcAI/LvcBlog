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
import party.pjc.blog.model.Link;
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
@RequestMapping("/admin/links")
public class LinkAdminController {
	
	Logger _log = Logger.getLogger(LinkAdminController.class);
	
	
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
	
//	Link 管理
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addLink(HttpServletRequest requset){
		requset.setAttribute("mainPage", "link/addLink.jsp");
		
		return "/admin";
	}

	@RequestMapping(value="/save",method=RequestMethod.POST)
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
	
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String linkList(HttpServletRequest requset){
		requset.setAttribute("mainPage", "link/Linklist.jsp");
		requset.setAttribute("link_list", linkService.findAllLink(new Link(null,1),new PageBean(1,10)));
		String basepath =requset.getContextPath();
		requset.setAttribute("navPage", PageUtil.getPagation(basepath+"/admin/links/list", linkService.findLinkCount(new Link(1)), 1, 10));
		return "/admin";
	}
	
	@RequestMapping(value="/list/page/{page}",method=RequestMethod.GET)
	public String linkListPage(@PathVariable("page") String page,HttpServletRequest requset){
		
		int currentPage =0;
		if(page==null){
			currentPage=1;
		}else{
			currentPage = Integer.parseInt(page);
		}
		String basePath = requset.getContextPath();
		requset.setAttribute("mainPage", "link/Linklist.jsp");
		requset.setAttribute("link_list", linkService.findAllLink(new Link(null,1),new PageBean(currentPage,10)));
	//	String basepath =requset.getContextPath();
		requset.setAttribute("navPage", PageUtil.getPagation(basePath+"/admin/links/list", linkService.findLinkCount(new Link(1)), currentPage, 10));
		
		return "/admin";
	}
	
	
}
