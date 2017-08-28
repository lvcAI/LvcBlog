package party.pjc.blog.service.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;

import party.pjc.blog.model.PageBean;
import party.pjc.blog.model.Post;
import party.pjc.blog.model.Tags;
import party.pjc.blog.service.CategoriesService;
import party.pjc.blog.service.PostService;
import party.pjc.blog.service.TagsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		{"classpath:applicationContext.xml",
		"classpath:spring-mvc.xml"})
public class PostServiceTest {

	
	
	@Autowired
	private PostService postService;
	
	@Test
	public void testFindPostByTag() {
		
			System.out.println(postService.findAllPost(1));
	}
	
	@Test
	public void testfindPostLimit() {
		//PageBean page = new PageBean(1, 2);
		//	System.out.println(postService.findPostLimit(null));
	}
	
	@Test
	public void testGetPostCount() {
		
			System.out.println(postService.getPostCount());
	}
	
	@Test
	public void testSelectPostsAndTags() {
		
		//	System.out.println(postService.selectPostsAndTags(null));
	}
	
	@Test
	public void testFindPostById(){
		System.out.println(postService.findPostById(40));
		
	}
	@Test
	public void testFindUpAndDown(){
		System.out.println(postService.findUpAndDown(3));
	}
	
	@Test 
	public void testPostClick(){
	
			List<Post> posts = postService.findAllPost(1);
			System.out.println(posts);
			String data = new Gson().toJson(posts);
			System.out.println(data);
	}
}