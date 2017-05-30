package party.pjc.blog.redis;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;

import party.pjc.blog.model.Post;
import party.pjc.blog.rediscache.JedisClientSingleService;
import party.pjc.blog.service.PostService;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		{"classpath:applicationContext.xml",
		"classpath:spring-mvc.xml",
		"classpath:spring-redis.xml"})
public class RedisTest {

	@Autowired
	private PostService postService;
	@Autowired  
    private JedisPool jedisPool;  
	@Autowired
	private JedisClientSingleService jedisClientSingleService;
	
	@Test
	public void setPost(){
		
		Jedis jedis =jedisPool.getResource();
		//Jedis jedis = new Jedis("120.24.244.80");
		jedis.auth("123456");
		
		System.out.println(jedis.ping());
		Post post =postService.findPostById(1);
		Gson gson = new Gson();
		System.out.println("格式化 post："+post);
		String s  = gson.toJson(post);
		System.out.println("格式化后："+s);
		//jedis.set("post:34", s);
		System.out.println("从redis中获取：");
		//jedis.exists(key)
		System.out.println(jedis.get("post:34"));
		Post post1 =gson.fromJson(jedis.get("post:34"), Post.class);
		System.out.println(post1);
		jedis.close();
	
		
		
	}
	
	@Test
	public void testRedisSingleService(){
		
		//System.out.println(jedisClientSingleService.get("lvc"));
		System.out.println(jedisClientSingleService.del("lvc"));
		System.out.println(jedisClientSingleService.ttl("/LvcBlog/blog/post/30"));
	}
	
	
	@Test
	public void test(){
		
		//System.out.println(jedisClientSingleService.get("lvc"));
		Jedis jedis =jedisPool.getResource();
	//	Jedis jedis = new Jedis("120.24.244.80");
		jedis.auth("123456");
		System.out.println(jedis.ping());
	}
	
}
