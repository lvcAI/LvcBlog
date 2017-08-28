package party.pjc.blog.controller;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xiaoleilu.hutool.util.NumberUtil;

import party.pjc.blog.model.Categories;
import party.pjc.blog.model.Notice;
import party.pjc.blog.model.PageBean;
import party.pjc.blog.model.Tags;
import party.pjc.blog.model.vo.CountResult;
import party.pjc.blog.rediscache.JedisClientSingleService;
import party.pjc.blog.service.CategoriesService;
import party.pjc.blog.service.NoticeService;
import party.pjc.blog.util.NoticeConvertUtil;
import party.pjc.blog.util.PageUtil;
import party.pjc.blog.util.PropertiesUtil;


@Controller
@RequestMapping("/categories")
public class CategoriesController {

	@Autowired
	private CategoriesService categoriesService;
	@Autowired
	private NoticeService noticeService;
/*	@Autowired
	private JedisClientSingleService jedisClientSingleService*/;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/{categoriesName}",method=RequestMethod.GET)
	public String allTag(@PathVariable("categoriesName")String categoriesName,HttpServletRequest request){
		
		System.out.println(categoriesName);
		HttpSession session = request.getSession();
		Gson gson = new Gson();
			if("categories-cloud".equals(categoriesName)){
			//	List<Categories> cates = categoriesService.findAllCategories();
				List<CountResult> catesResult = null;
				catesResult = categoriesService.findPostCountByCates();
				//	Type listTags =	new TypeToken<List<Tags>>(){}.getType();
					/*if(!jedisClientSingleService.exists(categoriesName)){
						catesResult = categoriesService.findPostCountByCates();
					
						String postToJosn = gson.toJson(catesResult);
						jedisClientSingleService.set(categoriesName, postToJosn);
						jedisClientSingleService.expire(categoriesName, 1000*60*60*6);//设置过期时间为 6 hour
						System.out.println("添加缓存!");
					}else{
						catesResult =(List<CountResult>) gson.fromJson(jedisClientSingleService.get(categoriesName),new TypeToken<List<CountResult>>(){}.getType());
						System.out.println("通过缓存获取tags"+catesResult);
					}*/
				request.setAttribute("catesResult",catesResult );
				request.setAttribute("pageType","categories");
				// 通知
				List<Notice> notices = NoticeConvertUtil.noticeConver(Integer.parseInt(PropertiesUtil.getValue("noticeSize")), noticeService);
				request.setAttribute("app_notices",notices);
				return "/categories/showcategories";		
			}else{
				/*Categories categories = null;
				if(!jedisClientSingleService.exists(categoriesName)){
					categories = categoriesService.findPostByCategorise(categoriesName);
				
					String postToJosn = gson.toJson(categories);
					jedisClientSingleService.set(categoriesName, postToJosn);
					jedisClientSingleService.expire(categoriesName, 1000*60*60*6);//设置过期时间为 6 hour
					System.out.println("添加缓存!");
				}else{
					categories = gson.fromJson(jedisClientSingleService.get(categoriesName),Categories.class);
					//System.out.println("通过缓存获取tags"+categories);
				}*/
				Categories categories = categoriesService.findPostByCategorise(categoriesName);
				request.setAttribute("cateByPost",categories );			
				PageBean pageBean = new PageBean(1,Integer.parseInt(PropertiesUtil.getValue("pageSize")));
			//	int totalPost = categoriesService.findPostCountByCate(new Categories(categoriesName));
				String basePath = request.getContextPath();
				request.setAttribute("pageBean",pageBean );
				request.setAttribute("navPage", PageUtil.getIndexPage(categories.getPosts().size(), pageBean.getPage(), pageBean.getPageSize(), basePath+"/categories/"+categoriesName+"/page/"));
				request.setAttribute("pageType","categories");
				// 通知
				List<Notice> notices = NoticeConvertUtil.noticeConver(Integer.parseInt(PropertiesUtil.getValue("noticeSize")), noticeService);
				request.setAttribute("app_notices",notices);
				return "/categories/post-categories";
			}
			
	}

	
	@RequestMapping("/{categoriesName}/page/{curpage}")
	public String showPagePost(@PathVariable("categoriesName") String categoriesName,@PathVariable("curpage") int curpage,HttpServletRequest request){
		// 通知
		List<Notice> notices = NoticeConvertUtil.noticeConver(Integer.parseInt(PropertiesUtil.getValue("noticeSize")), noticeService);
		request.setAttribute("app_notices",notices);
		
		//ModelAndView modelAndView = new ModelAndView();
		Categories categories = categoriesService.findPostByCategorise(categoriesName);
		request.setAttribute("cateByPost",categories );			

		PageBean pageBean = new PageBean(curpage,Integer.parseInt(PropertiesUtil.getValue("pageSize")));
	//	int totalPost = categoriesService.findPostCountByCate(new Categories(categoriesName));
		String basePath = request.getContextPath();
		request.setAttribute("pageBean",pageBean );
		request.setAttribute("navPage", PageUtil.getIndexPage(categories.getPosts().size(), curpage, pageBean.getPageSize(), basePath+"/categories/"+categoriesName+"/page/"));
		request.setAttribute("pageType","categories");
		return "/categories/post-categories";
	}

	
	
}
