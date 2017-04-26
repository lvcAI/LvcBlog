package party.pjc.blog.service.impl;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import party.pjc.blog.model.Comment;
import party.pjc.blog.model.Link;
import party.pjc.blog.model.PageBean;
import party.pjc.blog.model.Tags;
import party.pjc.blog.model.User;
import party.pjc.blog.service.CategoriesService;
import party.pjc.blog.service.CommentService;
import party.pjc.blog.service.LinkService;
import party.pjc.blog.service.PostService;
import party.pjc.blog.service.TagsService;
import party.pjc.blog.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		{"classpath:applicationContext.xml",
		"classpath:spring-mvc.xml"})
public class CommentServiceImplTest {

	
	
	
	@Autowired
	private CommentService commentService;
	
	
	@Test
	public void test1() {
		
		System.out.println(commentService.listComment(new Comment(0,null), new PageBean(1, 5)));
		
	}
	
	@Test
	public void test2() {
		
		
		System.out.println(commentService.countComment(new Comment()));
		
	}
	
	@Test
	public void test3() {
		
		Comment c = new Comment();
		c.setContext("this is a test ");
		c.setState(0);
		System.out.println(commentService.countComment(c));
		
	}
}