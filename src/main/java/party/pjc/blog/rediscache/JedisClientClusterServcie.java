package party.pjc.blog.rediscache;

import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.JedisCluster;
/**
 * 
 * @author lvc
 * 集群 
 */
public class JedisClientClusterServcie implements RedisClient {
	

		@Autowired  
	    private JedisCluster jedisCluster;  
		
		@Override
		public boolean exists(String key) {
			// TODO Auto-generated method stub
			return jedisCluster.exists(key);
		}
	      
	    @Override  
	    public String get(String key) {  
	        return jedisCluster.get(key);  
	    }  
	  
	    @Override  
	    public String set(String key, String value) {  
	        return jedisCluster.set(key, value);  
	    }  
	  
	    @Override  
	    public String hget(String hkey, String key) {  
	        return jedisCluster.hget(hkey, key);  
	    }  
	  
	    @Override  
	    public long hset(String hkey, String key, String value) {  
	        return jedisCluster.hset(hkey, key, value);  
	    }  
	  
	    @Override  
	    public long incr(String key) {  
	        return jedisCluster.incr(key);  
	    }  
	  
	    @Override  
	    public long expire(String key, int second) {  
	        return jedisCluster.expire(key, second);  
	    }  
	  
	    @Override  
	    public long ttl(String key) {  
	        return jedisCluster.ttl(key);  
	    }  
	  
	    @Override  
	    public long del(String key) {  
	          
	        return jedisCluster.del(key);  
	    }  
	  
	    @Override  
	    public long hdel(String hkey, String key) {  
	          
	        return jedisCluster.hdel(hkey, key);  
	    }  

}
