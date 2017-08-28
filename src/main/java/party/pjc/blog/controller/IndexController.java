package party.pjc.blog.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import party.pjc.blog.lucene.PostIndex;
import party.pjc.blog.model.Notice;
import party.pjc.blog.model.PageBean;
import party.pjc.blog.model.Post;
import party.pjc.blog.model.vo.CountResult;
import party.pjc.blog.service.CategoriesService;
import party.pjc.blog.service.LinkService;
import party.pjc.blog.service.NoticeService;
import party.pjc.blog.service.PostService;
import party.pjc.blog.service.TagsService;
import party.pjc.blog.service.UserService;
import party.pjc.blog.util.FileUtil;
import party.pjc.blog.util.NoticeConvertUtil;
import party.pjc.blog.util.PageUtil;
import party.pjc.blog.util.PropertiesUtil;

@Controller
public class IndexController {
	
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

	@RequestMapping(value={"/",""})
	public ModelAndView index(HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView();
		HttpSession session =request.getSession();
		PageBean page = new PageBean(1, Integer.parseInt(PropertiesUtil.getValue("pageSize")));
		List<Post> posts =postService.selectPostsAndTags(page); 
		int totalPost = postService.getPostCount();
		//mav.addObject("posts",posts );
		session.setAttribute("posts", posts);
		session.setAttribute("indexPage", PageUtil.getIndexPage2(totalPost, 1, Integer.parseInt(PropertiesUtil.getValue("pageSize")), "blog/post/page/"));
		// 阅读排行榜
		session.setAttribute("post2rate", postService.findPostLimit(null));
		// 初始化添加索引
		//判断当前操作系统
		if(System.getProperty("os.name").toLowerCase().equals("windows 10")){
			FileUtil.deleteDir(new File("D://lucene"));
		}else{
			FileUtil.deleteDir(new File("//lucene"));
		}
							// 初始化添加索引
		PostIndex postIndex = new PostIndex();
		List<Post> indexpost =postService.findPostLimit(null); 
		for (Post post : indexpost) {
			try {
					postIndex.addIndex(post);
		} catch (Exception e) {
				e.printStackTrace();
					}
		}
		List<CountResult> catesResult = categoriesService.findPostCountByCates();
		session.setAttribute("categoriess",catesResult);
	
		session.setAttribute("tagss",tagsService.findAllTag());
		
		// notice 
		List<Notice> notices = NoticeConvertUtil.noticeConver(Integer.parseInt(PropertiesUtil.getValue("noticeSize")), noticeService);
		mav.addObject("app_notices",notices);
		session.setAttribute("app_friendlink",linkService.findAllLinkByType(0));		
		mav.setViewName("/index");
		return mav;
	} 
}
