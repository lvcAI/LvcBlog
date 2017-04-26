package party.pjc.blog.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import party.pjc.blog.model.Tags;
import party.pjc.blog.service.CategoriesService;
import party.pjc.blog.service.PostService;
import party.pjc.blog.service.TagsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		{"classpath:applicationContext.xml",
		"classpath:spring-mvc.xml"})
public class TagServiceImplTest {

	
	
	
	@Autowired
	private TagsService tagService;
	@Test
	public void testFindPostByTag() {
		Tags tags = tagService.findPostByTag("数据库");
		
			System.out.println(tags);
	}
	
	@Test
	public void testFindTagByTagName() {
		Tags tags = tagService.findTagsByName("数据库");
		
			System.out.println(tags);
	}
	

	
	@Test
	public void testFindPostCountByTags() {
		
		
			System.out.println("共有："+tagService.findPostCountByTags(new Tags("test")));
	}
	
}