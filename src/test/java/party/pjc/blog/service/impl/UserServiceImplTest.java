package party.pjc.blog.service.impl;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import party.pjc.blog.model.Tags;
import party.pjc.blog.model.User;
import party.pjc.blog.service.CategoriesService;
import party.pjc.blog.service.PostService;
import party.pjc.blog.service.TagsService;
import party.pjc.blog.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		{"classpath:applicationContext.xml",
		"classpath:spring-mvc.xml"})
public class UserServiceImplTest {

	
	
	
	@Autowired
	private UserService userService;
	@Test
	public void testFindPostByTag() {
		
		User user = new User();
		user.setUserName("lvc");
		user.setPassword("123456");
		
		
			System.out.println(userService.login(user));
	}
	
	@Test
	public void test1() {
		
		/*String str = "Lvc159357";  
		String base64Encoded = Base64.encodeToString(str.getBytes());  
		String str2 = Base64.decodeToString(base64Encoded);  
		System.out.println(base64Encoded);
		Assert.assertEquals(str, str2);   */
		String str = "hello";  
		String salt = "123";  
		String sha1 = new Sha256Hash(str, salt).toString();
		System.out.println(sha1);
		
	}
	
	
	@Test
	public void test2() {
		
		System.out.println(userService.getByUserName("lvc"));
		
	}
}