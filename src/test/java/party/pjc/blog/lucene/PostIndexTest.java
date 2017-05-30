package party.pjc.blog.lucene;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import party.pjc.blog.model.Post;
import party.pjc.blog.service.PostService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		{"classpath:applicationContext.xml",
		"classpath:spring-mvc.xml"})
public class PostIndexTest {

	private PostIndex postIndex = new PostIndex();
	@Autowired
	private PostService postService;
	
	@Test
	public void testAddPostIndex() {
		List<Post> post =postService.findPostLimit(null);
		try {
			for (Post post2 : post) {
				postIndex.addIndex(post2);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
