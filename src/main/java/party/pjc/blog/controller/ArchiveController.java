package party.pjc.blog.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xiaoleilu.hutool.util.NumberUtil;

import party.pjc.blog.model.Notice;
import party.pjc.blog.model.PageBean;
import party.pjc.blog.model.Post;
import party.pjc.blog.service.NoticeService;
import party.pjc.blog.service.PostService;
import party.pjc.blog.service.TagsService;
import party.pjc.blog.util.NoticeConvertUtil;
import party.pjc.blog.util.PageUtil;
import party.pjc.blog.util.PropertiesUtil;
import party.pjc.blog.util.StringUtil;

@Controller

public class ArchiveController {

	@Autowired
	private TagsService tagsService;
	@Autowired
	private PostService postService;
	@Autowired
	private NoticeService noticeService;

	@RequestMapping(value="/archive",method=RequestMethod.GET)
	public ModelAndView allTag(HttpServletRequest requset){
		ModelAndView mad = new ModelAndView();
		// 通知
		List<Notice> notices = NoticeConvertUtil.noticeConver(Integer.parseInt(PropertiesUtil.getValue("noticeSize")), noticeService);
		mad.addObject("app_notices",notices);
		String basePath = requset.getContextPath();
		mad.setViewName("/archive/archive");
		List<Post> post_list =postService.selectPostsAndTags(new PageBean(1, 15));
		List<Post> posts = new ArrayList<Post>();
		for (Post post : post_list) {
			post.setContent(StringUtil.Html2Text(post.getHtml()));
			posts.add(post);
		}
		mad.addObject("post_list",posts);
		mad.addObject("navPage", PageUtil.getIndexPage( postService.getPostCount(), 1, 15,basePath+"/archive/page/"));
		mad.addObject("postcount", postService.getPostCount());
		requset.setAttribute("pageType","archive");
		return mad;
	}
			
	
	
	@RequestMapping(value="/archive/page/{page}",method=RequestMethod.GET)
	public ModelAndView postListPage(@PathVariable("page") String page,HttpServletRequest requset){
		ModelAndView mad = new ModelAndView();
		// 通知
		List<Notice> notices = NoticeConvertUtil.noticeConver(Integer.parseInt(PropertiesUtil.getValue("noticeSize")), noticeService);
		mad.addObject("app_notices",notices);
		mad.setViewName("/archive/archive");
		int currentPage =0;
		if(page==null){
			currentPage=1;
		}else{
			currentPage = Integer.parseInt(page);
		}
		String basePath = requset.getContextPath();
		List<Post> post_list =postService.selectPostsAndTags(new PageBean(currentPage, 15));
		List<Post> posts = new ArrayList<Post>();
		for (Post post : post_list) {
			post.setContent(StringUtil.Html2Text(post.getHtml()));
			posts.add(post);
		}
		mad.addObject("post_list", posts);
		
		mad.addObject("postcount", postService.getPostCount());
		mad.addObject("navPage",PageUtil.getIndexPage( postService.getPostCount(), currentPage, 15,basePath+"/archive/page/"));
		requset.setAttribute("pageType","archive");
		return mad;
	}
	
	private int noticeSize(){
		int size = noticeService.size(null);
		Integer[] sizes =NumberUtil.generateBySet(1, size-3, 1);
		
		return sizes[0];
	}
		
}
	
