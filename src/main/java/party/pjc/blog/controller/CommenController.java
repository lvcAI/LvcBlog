package party.pjc.blog.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import party.pjc.blog.model.Comment;
import party.pjc.blog.model.PageBean;
import party.pjc.blog.service.CommentService;
import party.pjc.blog.service.PostService;

@Controller
public class CommenController {

	@Autowired
	private PostService postService; 
	@Autowired
	private CommentService commentService;
	
	
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about(){
		return "/about/aboutme";
	}

	@RequestMapping(value = "/guestBook", method = RequestMethod.GET)
	public String guestBook(HttpServletRequest request){
		request.setAttribute("guestList",commentService.listComment(new Comment(0,null), new PageBean(1, 5)));
		return "/guestbook/guestbook";
	}
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String login(){
		return "redirect:/login.jsp";
	}
	
}
