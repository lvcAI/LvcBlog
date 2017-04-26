package party.pjc.blog.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import party.pjc.blog.model.Tags;
import party.pjc.blog.service.CategoriesService;
import party.pjc.blog.service.TagsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		{"classpath:applicationContext.xml",
		"classpath:spring-mvc.xml"})
public class CategoriseServiceImplTest {

	@Autowired
	private CategoriesService categoriesService;
	@Test
	public void testFindPostByTag() {
		
		
			System.out.println(categoriesService.findPostByCategorise("Éú»î"));
	}
}