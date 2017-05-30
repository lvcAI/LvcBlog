package party.pjc.blog.rediscache;

public interface RedisClient {
	
	 String get(String key);  
	 String set(String key, String value);  
	 String hget(String hkey, String key);  
	 boolean exists(String key);
	 long hset(String hkey, String key, String value);  
	 long incr(String key);  
	 long expire(String key, int second);  
	 long ttl(String key);  
	 long del(String key);  
	 long hdel(String hkey, String key);  
}
