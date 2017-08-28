package party.pjc.blog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xiaoleilu.hutool.util.NumberUtil;

import party.pjc.blog.model.Comment;
import party.pjc.blog.model.Notice;
import party.pjc.blog.model.PageBean;
import party.pjc.blog.service.CommentService;
import party.pjc.blog.service.NoticeService;
import party.pjc.blog.service.PostService;
import party.pjc.blog.util.NoticeConvertUtil;
import party.pjc.blog.util.PageUtil;
import party.pjc.blog.util.PropertiesUtil;

@Controller
public class CommenController {

	@Autowired
	private PostService postService; 
	@Autowired
	private CommentService commentService;
	@Autowired
	private NoticeService noticeService;
	
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public ModelAndView about(HttpServletRequest request){
		// 通知
		List<Notice> notices = NoticeConvertUtil.noticeConver(Integer.parseInt(PropertiesUtil.getValue("noticeSize")), noticeService);
		request.setAttribute("app_notices",notices);
		ModelAndView mad = new ModelAndView();
		mad.addObject("pageType", "about");
		mad.setViewName("/about/aboutme");
		mad.addObject("postcount", postService.getPostCount());
		return mad;
	}

	@RequestMapping(value = "/guestBook", method = RequestMethod.GET)
	public String guestBook(HttpServletRequest request){
		// 通知
		List<Notice> notices = NoticeConvertUtil.noticeConver(Integer.parseInt(PropertiesUtil.getValue("noticeSize")), noticeService);
		request.setAttribute("app_notices",notices);
		request.setAttribute("guestList",commentService.listComment(new Comment(0,null), new PageBean(1, 5)));
		request.setAttribute("pageType", "guestBook");
		return "/guestbook/guestbook";
	}
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String login(){
		return "/login";
	}
	
	
}
