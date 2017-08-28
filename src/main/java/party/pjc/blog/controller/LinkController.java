package party.pjc.blog.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import party.pjc.blog.model.vo.EmailResult;
import party.pjc.blog.service.LinkService;
import party.pjc.blog.service.TagsService;
import party.pjc.blog.util.EmailUtils;
import party.pjc.blog.util.PageUtil;
import party.pjc.blog.util.PropertiesUtil;
import party.pjc.blog.util.ResponseUtil;
import party.pjc.blog.util.StringUtil;

@Controller
@RequestMapping("/FAQ")
public class LinkController {

	@Autowired
	private LinkService linkService;
	

	@RequestMapping(value="/links-could",method=RequestMethod.GET)
	public String allTag(HttpServletRequest request){

		List<Link> allLinks= linkService.findAllLink(new Link(null,1), new PageBean(1,Integer.parseInt(PropertiesUtil.getValue("linkSize"))));
		request.setAttribute("allLinks", allLinks);
		int totalLink = linkService.findLinkCount(new Link(1));
		request.setAttribute("totalLink", totalLink);			
		//	int totalPage=totalPost%pageBean.getPageSize()==0?totalPost/pageBean.getPageSize():totalPost/pageBean.getPageSize()+1;
		String basePath = request.getContextPath();
		request.setAttribute("navPage", PageUtil.getIndexPage(totalLink, 1,Integer.parseInt(PropertiesUtil.getValue("linkSize")), basePath+"/FAQ/links-could/page/"));
		request.setAttribute("pageType", "link");
		return "/link/showLinks";		
	
	}
	
	@RequestMapping("/links-could/page/{curpage}")
	public String showPagePost(@PathVariable("curpage") int curpage,HttpServletRequest request){
		//ModelAndView modelAndView = new ModelAndView();

		PageBean pageBean = new PageBean(curpage,Integer.parseInt(PropertiesUtil.getValue("linkSize")));
		int totalLink = linkService.findLinkCount(new Link(1));
		String basePath = request.getContextPath();
		List<Link> allLinks= linkService.findAllLink(new Link(null,1),pageBean);
		request.setAttribute("allLinks", allLinks);
		request.setAttribute("totalLink", totalLink);	
		request.setAttribute("navPage", PageUtil.getIndexPage(totalLink, curpage, pageBean.getPageSize(), basePath+"/FAQ/links-could/page/"));
		request.setAttribute("pageType", "link");
		return "/link/showLinks";
	}
	
	@RequestMapping(value="/links/fastsave",method=RequestMethod.POST)
	public String saveLink(HttpServletRequest requset,HttpServletResponse response){
		
		String urlname =requset.getParameter("urlname");
		String url = requset.getParameter("url");
		Link link = new Link();
		link.setUrlname(urlname);
		link.setUrl(url);
		link.setState(1);
		int result= linkService.insertLink(link);
		EmailResult email = new  EmailResult("328097822@qq.com","来自 iLvc.me 的提示","您的网站添加了一条新的FAQ 通过快速添加。"+urlname+":"+url);
		try {
			EmailUtils.sendEmail(email);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("邮件发送错误："+e1);
		}
		try {
			ResponseUtil.write(result, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

}
