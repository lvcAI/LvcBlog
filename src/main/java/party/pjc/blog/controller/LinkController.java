package party.pjc.blog.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import party.pjc.blog.model.Link;
import party.pjc.blog.model.PageBean;
import party.pjc.blog.model.Post;
import party.pjc.blog.model.Tags;
import party.pjc.blog.service.LinkService;
import party.pjc.blog.service.TagsService;
import party.pjc.blog.util.PageUtil;
import party.pjc.blog.util.PropertiesUtil;

@Controller
@RequestMapping("/FAQ")
public class LinkController {

	@Autowired
	private LinkService linkService;
	

	@RequestMapping(value="/links-could",method=RequestMethod.GET)
	public String allTag(HttpServletRequest request){

		List<Link> allLinks= linkService.findAllLink(new Link(null,1), new PageBean(1,10));
		request.setAttribute("allLinks", allLinks);
		int totalLink = linkService.findLinkCount(new Link(1));
		request.setAttribute("totalLink", totalLink);			
		//	int totalPage=totalPost%pageBean.getPageSize()==0?totalPost/pageBean.getPageSize():totalPost/pageBean.getPageSize()+1;
		String basePath = request.getContextPath();
		request.setAttribute("navPage", PageUtil.getIndexPage(totalLink, 1,10, basePath+"/FAQ/links-could/page/"));
		return "/link/showLinks";		
	
	}
	
	@RequestMapping("/links-could/page/{curpage}")
	public String showPagePost(@PathVariable("curpage") int curpage,HttpServletRequest request){
		//ModelAndView modelAndView = new ModelAndView();

		PageBean pageBean = new PageBean(curpage,5);
		int totalLink = linkService.findLinkCount(new Link(1));
		String basePath = request.getContextPath();
		List<Link> allLinks= linkService.findAllLink(new Link(null,1), new PageBean(curpage,10));
		request.setAttribute("allLinks", allLinks);
		request.setAttribute("totalLink", totalLink);	
		request.setAttribute("navPage", PageUtil.getIndexPage(totalLink, curpage, pageBean.getPageSize(), basePath+"/FAQ/links-could/page/"));
		
		return "/link/showLinks";
	}
	

}
