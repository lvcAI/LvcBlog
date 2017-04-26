package party.pjc.blog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import party.pjc.blog.model.PageBean;
import party.pjc.blog.model.Post;
import party.pjc.blog.service.PostService;
import party.pjc.blog.util.PageUtil;

@Controller
@RequestMapping("/blog")
public class PostController {

	@Autowired
	private PostService postService;
	
	@RequestMapping("/post/{id}")
	public String index( @PathVariable("id") Integer id,HttpServletRequest request){
		//ModelAndView modelAndView = new ModelAndView();
		Post post = postService.findPostById(id);
		post.setRate(post.getRate()+1);
		postService.updatePostByRate(post);
	//	modelAndView.setViewName("/post/showpost");
		request.setAttribute("post", post);
		request.setAttribute("navPage", PageUtil.getUpAndDwonPage(postService.findUpAndDown(id), request.getContextPath()));
		return "/post/showpost";
	}
	
	@RequestMapping("/post/add")
	public String add(HttpServletRequest request){
		//ModelAndView modelAndView = new ModelAndView();
		
	
		
		return "/post/addpost";
	}
	
	@RequestMapping("/post/page/{page}")
	public String showPagePost(@PathVariable("page") int page,HttpServletRequest request){
		//ModelAndView modelAndView = new ModelAndView();
		
		PageBean pageBean = new PageBean(page, 2);
		int totalPost = postService.getPostCount();
		int totalPage=totalPost%pageBean.getPageSize()==0?totalPost/pageBean.getPageSize():totalPost/pageBean.getPageSize()+1;
		List<Post> posts = postService.selectPostsAndTags(pageBean);
		String basePath = request.getContextPath();
		request.setAttribute("postList", posts);
		request.setAttribute("navPage", PageUtil.getIndexPage(totalPost, page, pageBean.getPageSize(), basePath+"/blog/post/page/"));
		
		return "/post/index";
	}
	
	
}
