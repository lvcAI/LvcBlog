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

import party.pjc.blog.model.PageBean;
import party.pjc.blog.model.Post;
import party.pjc.blog.model.Tags;
import party.pjc.blog.service.TagsService;
import party.pjc.blog.util.PageUtil;
import party.pjc.blog.util.PropertiesUtil;

@Controller
@RequestMapping("/tags")
public class TagsController {

	@Autowired
	private TagsService tagsService;
	

	@RequestMapping(value="/{tagName}",method=RequestMethod.GET)
	public String allTag(@PathVariable("tagName")String tagName,HttpServletRequest request){
		System.out.println(tagName);
		
			if("tag-cloud".equals(tagName)){
				List<Tags> tags= tagsService.findAllTag();
				request.setAttribute("allTags", tags);
				
				return "/tags/showtags";		
			}else{
					Tags tag = tagsService.findPostByTag(tagName);
					request.setAttribute("tagByPost", tag);
					System.out.println(tag);
					PageBean pageBean = new PageBean(1,Integer.parseInt(PropertiesUtil.getValue("pageSize")));
					int totalPost = tagsService.findPostCountByTags(new Tags(tagName));
					request.setAttribute("pageBean",pageBean );
				//	int totalPage=totalPost%pageBean.getPageSize()==0?totalPost/pageBean.getPageSize():totalPost/pageBean.getPageSize()+1;
					String basePath = request.getContextPath();
					request.setAttribute("navPage", PageUtil.getIndexPage(totalPost, pageBean.getPage(), pageBean.getPageSize(), basePath+"/tags/"+tagName+"/page/"));
				return "/tags/post-tag";
			}
			
				
		
	}
	
	@RequestMapping("/{tagName}/page/{curpage}")
	public String showPagePost(@PathVariable("tagName") String tagName,@PathVariable("curpage") int curpage,HttpServletRequest request){
		//ModelAndView modelAndView = new ModelAndView();
		Tags tag = tagsService.findPostByTag(tagName);
		request.setAttribute("tagByPost", tag);

		PageBean pageBean = new PageBean(curpage,Integer.parseInt(PropertiesUtil.getValue("pageSize")));
		int totalPost = tagsService.findPostCountByTags(new Tags(tagName));
		int totalPage=totalPost%pageBean.getPageSize()==0?totalPost/pageBean.getPageSize():totalPost/pageBean.getPageSize()+1;
		
		String basePath = request.getContextPath();
		request.setAttribute("pageBean",pageBean );
		request.setAttribute("navPage", PageUtil.getIndexPage(totalPost, curpage, pageBean.getPageSize(), basePath+"/tags/"+tagName+"/page/"));
		
		return "/tags/post-tag";
	}
	

}
