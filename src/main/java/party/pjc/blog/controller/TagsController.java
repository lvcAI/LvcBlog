package party.pjc.blog.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.lang.reflect.Type;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.lucene.analysis.core.TypeTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xiaoleilu.hutool.util.NumberUtil;

import party.pjc.blog.model.Notice;
import party.pjc.blog.model.PageBean;
import party.pjc.blog.model.Post;
import party.pjc.blog.model.Tags;
import party.pjc.blog.rediscache.JedisClientSingleService;
import party.pjc.blog.service.NoticeService;
import party.pjc.blog.service.TagsService;
import party.pjc.blog.util.NoticeConvertUtil;
import party.pjc.blog.util.PageUtil;
import party.pjc.blog.util.PropertiesUtil;

@Controller
@RequestMapping("/tags")
public class TagsController {

	@Autowired
	private TagsService tagsService;
	@Autowired
	private NoticeService noticeService;
/*	@Autowired
	private JedisClientSingleService jedisClientSingleService;*/

	@SuppressWarnings("unchecked")
	@RequestMapping(value="/{tagName}",method=RequestMethod.GET)
	public String allTag(@PathVariable("tagName")String tagName,HttpServletRequest request){
		// 通知
		List<Notice> notices = NoticeConvertUtil.noticeConver(Integer.parseInt(PropertiesUtil.getValue("noticeSize")), noticeService);
		request.setAttribute("app_notices",notices);
		System.out.println(tagName);
		
			if("tag-cloud".equals(tagName)){
				List<Tags> tags=null;	
				Gson gson = new Gson();
				
				tags= tagsService.findAllTag();
				/*if(!jedisClientSingleService.exists(tagName)){
				 * Type listTags =	new TypeToken<List<Tags>>(){}.getType();
					tags= tagsService.findAllTag();
				
					String postToJosn = gson.toJson(tags);
					jedisClientSingleService.set(tagName, postToJosn);
					jedisClientSingleService.expire(tagName, 1000*60*60*6);//设置过期时间为 6 hour
					System.out.println("添加缓存!");
				}else{
					tags =(List<Tags>) gson.fromJson(jedisClientSingleService.get(tagName),new TypeToken<List<Tags>>(){}.getType());
					System.out.println("通过缓存获取tags"+tags);
				}*/
				
				request.setAttribute("allTags", tags);
				request.setAttribute("pageType","tags");
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
					request.setAttribute("navPage", PageUtil.getIndexPage(tag.getPosts().size(), pageBean.getPage(), pageBean.getPageSize(), basePath+"/tags/"+tagName+"/page/"));
					request.setAttribute("pageType","tags");
					return "/tags/post-tag";
			}
			
				
		
	}
	
	@RequestMapping("/{tagName}/page/{curpage}")
	public String showPagePost(@PathVariable("tagName") String tagName,@PathVariable("curpage") int curpage,HttpServletRequest request){
		
		// 通知
		List<Notice> notices = NoticeConvertUtil.noticeConver(Integer.parseInt(PropertiesUtil.getValue("noticeSize")), noticeService);
		request.setAttribute("app_notices",notices);
		//ModelAndView modelAndView = new ModelAndView();
		Tags tag = tagsService.findPostByTag(tagName);
		request.setAttribute("tagByPost", tag);

		PageBean pageBean = new PageBean(curpage,Integer.parseInt(PropertiesUtil.getValue("pageSize")));
		int totalPost = tagsService.findPostCountByTags(new Tags(tagName));
	//	int totalPage=totalPost%pageBean.getPageSize()==0?totalPost/pageBean.getPageSize():totalPost/pageBean.getPageSize()+1;
		
		String basePath = request.getContextPath();
		request.setAttribute("pageBean",pageBean );
		request.setAttribute("navPage", PageUtil.getIndexPage(tag.getPosts().size(), curpage, pageBean.getPageSize(), basePath+"/tags/"+tagName+"/page/"));
		request.setAttribute("pageType","tags");
		return "/tags/post-tag";
	}
	
	private int noticeSize(){
		int size = noticeService.size(null);
		Integer[] sizes =NumberUtil.generateBySet(1, size-3, 1);
		
		return sizes[0];
	}

}
