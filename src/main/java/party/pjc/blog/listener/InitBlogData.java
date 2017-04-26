package party.pjc.blog.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import party.pjc.blog.model.Categories;
import party.pjc.blog.model.PageBean;
import party.pjc.blog.model.Post;
import party.pjc.blog.service.CategoriesService;
import party.pjc.blog.service.PostService;
import party.pjc.blog.service.TagsService;
import party.pjc.blog.util.PageUtil;

public class  InitBlogData implements  ServletContextListener, ApplicationContextAware {


	private static ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		InitBlogData.applicationContext = applicationContext;
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContext application = sce.getServletContext();
	
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());  
		PostService postService = (PostService) context.getBean("postService");
		PageBean page = new PageBean(1, 2);
		List<Post> posts =postService.selectPostsAndTags(page); 
		int totalPost = postService.getPostCount();
		application.setAttribute("posts",posts );
		application.setAttribute("indexPage", PageUtil.getIndexPage2(totalPost, 1, 2, "blog/post/page/"));
		
	
		CategoriesService categoriesService = (CategoriesService) context.getBean("categoriesService");
		List<Categories> categoriess = categoriesService.findAllCategories();
		application.setAttribute("categoriess",categoriess);
	
		TagsService tagsService = (TagsService) context.getBean("tagsService");
		application.setAttribute("tagss",tagsService.findAllTag());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	
	
}
