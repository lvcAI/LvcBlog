package party.pjc.blog.rediscache;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
/**
 * 
 * @author lvc
 * 单机版
 */
@Service("jedisClientSingleService")
public class JedisClientSingleService implements RedisClient{

	 @Autowired  
     private JedisPool jedisPool;   
       
	@Override
	public boolean exists(String key) {
		Jedis jedis = jedisPool.getResource();  
	    boolean result = jedis.exists(key);  
	    jedis.close();  
	    return result;  
	}
	 
     @Override  
     public String get(String key) {  
         Jedis jedis = jedisPool.getResource();  
         String string = jedis.get(key);  
         jedis.close();  
         return string;  
     }  

     @Override  
     public String set(String key, String value) {  
         Jedis jedis = jedisPool.getResource();  
         String string = jedis.set(key, value);  
         jedis.close();  
         return string;  
     }  

     @Override  
     public String hget(String hkey, String key) {  
         Jedis jedis = jedisPool.getResource();  
         String string = jedis.hget(hkey, key);  
         jedis.close();  
         return string;  
     }  

     /**
      * 设置 一个 hash 类型 的键值
      */
     @Override  
     public long hset(String hkey, String key, String value) {  
         Jedis jedis = jedisPool.getResource();  
         Long result = jedis.hset(hkey, key, value);  
         jedis.close();  
         return result;  
     }  

     /**
      * 自增 键 +1
      */
     @Override  
     public long incr(String key) {  
         Jedis jedis = jedisPool.getResource();  
         Long result = jedis.incr(key);  
         jedis.close();  
         return result;  
     }  

     /**
      * 设置 键的 活动时间
      */
     @Override  
     public long expire(String key, int second) {  
         Jedis jedis = jedisPool.getResource();  
         Long result = jedis.expire(key, second);  
         jedis.close();  
         return result;  
     }  
     /**
      * 获取 键 的 存活时间
      */
     @Override  
     public long ttl(String key) {  
         Jedis jedis = jedisPool.getResource();  
         Long result = jedis.ttl(key);  
         jedis.close();  
         return result;  
     }  

     /**
      * 删除一个键
      */
     @Override  
     public long del(String key) {  
         Jedis jedis = jedisPool.getResource();  
         Long result = jedis.del(key);  
         jedis.close();  
         return result;  
     }  

     /**
      * 删除一个 hash 类型的键值
      */
     @Override  
     public long hdel(String hkey, String key) {  
         Jedis jedis = jedisPool.getResource();  
         Long result = jedis.hdel(hkey, key);  
         jedis.close();  
         return result;  
     }  
}
