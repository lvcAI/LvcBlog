package party.pjc.blog.listener;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import party.pjc.blog.lucene.PostIndex;
import party.pjc.blog.model.Categories;
import party.pjc.blog.model.PageBean;
import party.pjc.blog.model.Post;
import party.pjc.blog.model.vo.CountResult;
import party.pjc.blog.rediscache.JedisClientSingleService;
import party.pjc.blog.service.CategoriesService;
import party.pjc.blog.service.PostService;
import party.pjc.blog.service.TagsService;
import party.pjc.blog.util.FileUtil;
import party.pjc.blog.util.PageUtil;
import party.pjc.blog.util.PropertiesUtil;

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
		PageBean page = new PageBean(1, Integer.parseInt(PropertiesUtil.getValue("pageSize")));
		List<Post> posts =postService.selectPostsAndTags(page); 
		int totalPost = postService.getPostCount();
		application.setAttribute("posts",posts );
		application.setAttribute("indexPage", PageUtil.getIndexPage2(totalPost, 1, Integer.parseInt(PropertiesUtil.getValue("pageSize")), "blog/post/page/"));
		/**
		 * 为了不用每一次启动项目，都要去改配置文件，
		 * 先添加  SYS_PostIndex 系统——索引，是否已经有索引了
		 * sys_postIndex : 0:没有索引 ； 1：已有索引
		 */
	//	JedisClientSingleService  jedisClientSingleService = (JedisClientSingleService) context.getBean("jedisClientSingleService");
	/*	
		if(!jedisClientSingleService.exists("sys_postIndex")){
			// 开启一个子线程 去添加系统post索引
			Thread thread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					//判断当前操作系统
					if(System.getProperty("os.name").toLowerCase().equals("windows 10")){
						FileUtil.deleteDir(new File("D://lucene"));
					}else{
						FileUtil.deleteDir(new File("//lucene"));
					}
					jedisClientSingleService.set("sys_postIndex", "1");
					// 初始化添加索引
					PostIndex postIndex = new PostIndex();
					List<Post> indexpost =postService.findPostLimit(null); 
					for (Post post : indexpost) {
						try {
							postIndex.addIndex(post);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					jedisClientSingleService.del("sys_postIndex");
				}
				
				
			});
			thread.start();
			
		}*/
		
		// 初始化添加索引
		//判断当前操作系统
					if(System.getProperty("os.name").toLowerCase().equals("windows 10")){
						FileUtil.deleteDir(new File("D://lucene"));
					}else{
						FileUtil.deleteDir(new File("//lucene"));
					}
					// 初始化添加索引
					PostIndex postIndex = new PostIndex();
					List<Post> indexpost =postService.findPostLimit(null); 
					for (Post post : indexpost) {
						try {
							postIndex.addIndex(post);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
	
		CategoriesService categoriesService = (CategoriesService) context.getBean("categoriesService");
	//	List<Categories> categoriess = categoriesService.findAllCategories();
		List<CountResult> catesResult = categoriesService.findPostCountByCates();
		application.setAttribute("categoriess",catesResult);
	
		TagsService tagsService = (TagsService) context.getBean("tagsService");
		application.setAttribute("tagss",tagsService.findAllTag());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	
	
}
