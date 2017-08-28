package party.pjc.blog.sys;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.google.gson.Gson;

import party.pjc.blog.model.PageBean;
import party.pjc.blog.model.Post;
import party.pjc.blog.model.vo.CountResult;
import party.pjc.blog.model.vo.Result;
import party.pjc.blog.service.CategoriesService;
import party.pjc.blog.service.LinkService;
import party.pjc.blog.service.NoticeService;
import party.pjc.blog.service.PostService;
import party.pjc.blog.service.TagsService;
import party.pjc.blog.service.UserService;
import party.pjc.blog.util.PageUtil;
import party.pjc.blog.util.PropertiesUtil;
import party.pjc.blog.util.ResponseUtil;

/**
 * 
 * @author lvc
 * 系统配置
 */
public class LvcBlogSystem {

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
	private NoticeService noticeService;
	
	/**
	 * 刷新系统缓存
	 * @param response
	 * @param request
	 * @throws Exception
	 */
	public  void refreshSystem(HttpServletRequest request)throws Exception{
		ServletContext application=RequestContextUtils.getWebApplicationContext(request).getServletContext();
		
		PageBean page = new PageBean(1, Integer.parseInt(PropertiesUtil.getValue("pageSize")));
		List<Post> posts =postService.selectPostsAndTags(page); 
		int totalPost = postService.getPostCount();
		application.setAttribute("posts",posts );
		application.setAttribute("indexPage", PageUtil.getIndexPage2(totalPost, 1, Integer.parseInt(PropertiesUtil.getValue("pageSize")), "blog/post/page/"));
		
		
		List<CountResult> catesResult = categoriesService.findPostCountByCates();
		application.setAttribute("categoriess",catesResult);
	
		application.setAttribute("tagss",tagsService.findAllTag());
		application.setAttribute("app_notices", noticeService.findNotices());
	
	}
	public void refreshSystem(HttpServletRequest request,String type)throws Exception{
		// ServletContext application=RequestContextUtils.getWebApplicationContext(request).getServletContext();
		// application.setAttribute("post2rate", postService.findPostLimit(null));
		request.getSession().setAttribute("post2rate", postService.findPostLimit(null));
		request.getSession().setAttribute("app_notices", noticeService.findNotices());
	}
}
