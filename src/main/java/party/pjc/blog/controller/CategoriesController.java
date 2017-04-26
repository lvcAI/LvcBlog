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

import party.pjc.blog.model.Categories;
import party.pjc.blog.model.PageBean;
import party.pjc.blog.model.Tags;
import party.pjc.blog.service.CategoriesService;
import party.pjc.blog.util.PageUtil;
import party.pjc.blog.util.PropertiesUtil;


@Controller
@RequestMapping("/categories")
public class CategoriesController {

	@Autowired
	private CategoriesService categoriesService;
	
	@RequestMapping(value="/{categoriesName}",method=RequestMethod.GET)
	public String allTag(@PathVariable("categoriesName")String categoriesName,HttpServletRequest request){
		
		System.out.println(categoriesName);
		HttpSession session = request.getSession();
			if("categories-cloud".equals(categoriesName)){
				List<Categories> cates = categoriesService.findAllCategories();
				request.setAttribute("allcates",cates );
				return "/categories/showcategories";		
			}else{
					Categories categories = categoriesService.findPostByCategorise(categoriesName);
					request.setAttribute("cateByPost",categories );			
				System.out.println();
				PageBean pageBean = new PageBean(1,Integer.parseInt(PropertiesUtil.getValue("pageSize")));
				int totalPost = categoriesService.findPostCountByCate(new Categories(categoriesName));
				String basePath = request.getContextPath();
				request.setAttribute("pageBean",pageBean );
				request.setAttribute("navPage", PageUtil.getIndexPage(totalPost, pageBean.getPage(), pageBean.getPageSize(), basePath+"/categories/"+categoriesName+"/page/"));
				
				return "/categories/post-categories";
			}
			
	}

	
	@RequestMapping("/{categoriesName}/page/{curpage}")
	public String showPagePost(@PathVariable("categoriesName") String categoriesName,@PathVariable("curpage") int curpage,HttpServletRequest request){
		//ModelAndView modelAndView = new ModelAndView();
		Categories categories = categoriesService.findPostByCategorise(categoriesName);
		request.setAttribute("cateByPost",categories );			

		PageBean pageBean = new PageBean(curpage,Integer.parseInt(PropertiesUtil.getValue("pageSize")));
		int totalPost = categoriesService.findPostCountByCate(new Categories(categoriesName));
		String basePath = request.getContextPath();
		request.setAttribute("pageBean",pageBean );
		request.setAttribute("navPage", PageUtil.getIndexPage(totalPost, curpage, pageBean.getPageSize(), basePath+"/categories/"+categoriesName+"/page/"));
		
		return "/categories/post-categories";
	}

}
