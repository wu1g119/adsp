package cn.com.softvan.dao.utils;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import cn.com.softvan.common.Resources;


public class MybatisRedisCache implements Cache {
	
	private static final transient Logger log = Logger.getLogger("cache");
	private Jedis redisClient=createReids();
	 /** The ReadWriteLock. */  
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock(); 
    /**缓存池*/
    private redis.clients.jedis.JedisPool jedisPool;
	private String id;
	public MybatisRedisCache(){};
	public MybatisRedisCache(final String id) {  
		if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
		log.debug(">>>>>>>>>>>>>>>>>>>>>>>>MybatisRedisCache:id="+id);
        this.id = id;
    }  
	public String getId() {
		return this.id;
	}

	public int getSize() {
		try{
			return Integer.valueOf(createReids().dbSize().toString());
		}finally{  
		    jedisPool.returnResource(redisClient);
	    } 
	}

	public void putObject(Object key, Object value) {
		try{
			if(key==null){
				return;
			}
			log.debug(">>>>>>>>>>>>>>>>>>>>>>>>putObject:"+key+"="+value);
			createReids().set(key.toString().getBytes(), SerializeUtil.serialize(value));
		}finally{  
	   	 jedisPool.returnResource(redisClient);
	    } 
	}

	public Object getObject(Object key) {
		try{
			if(key==null){
				return null;
			}
			Object value = SerializeUtil.unserialize(createReids().get(key.toString().getBytes()));
			log.debug(">>>>>>>>>>>>>>>>>>>>>>>>getObject:"+key+"="+value);
			return value;
		}finally{  
	   	 jedisPool.returnResource(redisClient);
	    } 
	}

	public Object removeObject(Object key) {
		try{
			if(key==null){
				return null;
			}
			return createReids().expire(key.toString().getBytes(),0);
		}finally{  
	   	 jedisPool.returnResource(redisClient);
	    } 
	}

	public void clear() {
		try{
			createReids().flushDB();
		}finally{  
		   	 jedisPool.returnResource(redisClient);
		} 
	}
	
	public ReadWriteLock getReadWriteLock() {
		return readWriteLock;
	}
	private static String redis_host=null;
	private static int redis_port=6379;
	private static String redis_pass=null;
	private static int redis_timeout=15000;
	private static int redis_maxActive=-1;
	private static int redis_maxIdle=10;
	private static int redis_maxWait=15000;
	static{
		redis_host=Resources.getData("redis-manager-config.properties","redis.host");
		redis_pass=Resources.getData("redis-manager-config.properties","redis.pass");
		try {
			redis_port=Integer.parseInt(Resources.getData("redis-manager-config.properties","redis.port"));
			redis_timeout=Integer.parseInt(Resources.getData("redis-manager-config.properties","redis.timeout"));
			redis_maxActive=Integer.parseInt(Resources.getData("redis-manager-config.properties","redis.maxActive"));
			redis_maxIdle=Integer.parseInt(Resources.getData("redis-manager-config.properties","redis.maxIdle"));
			redis_maxWait=Integer.parseInt(Resources.getData("redis-manager-config.properties","redis.maxWait"));
		} catch (Exception e) {
			redis_port=6379;
			redis_timeout=15000;
			redis_maxActive=-1;
			redis_maxIdle=10;
			redis_maxWait=15000;
		}
	}
    protected  Jedis createReids(){
    	if(redisClient==null){
			//设置
	    	 JedisPoolConfig config = new JedisPoolConfig();  
	         config.setMaxActive(redis_maxActive);  
	         config.setMaxIdle(redis_maxIdle);  
	         config.setMinIdle(0);  
	         config.setMaxWait(redis_maxWait);  
	         config.setMinEvictableIdleTimeMillis(300000);  
	         config.setSoftMinEvictableIdleTimeMillis(-1);  
	         config.setNumTestsPerEvictionRun(3);  
	         config.setTestOnBorrow(false);  
	         config.setTestOnReturn(false);  
	         config.setTestWhileIdle(false);  
	         config.setTimeBetweenEvictionRunsMillis(60000);//一分钟  
	         config.setWhenExhaustedAction((byte)1);  
	         jedisPool = new JedisPool(config,redis_host,redis_port,redis_timeout,redis_pass,12);  
	         redisClient= jedisPool.getResource();//从pool中获取资源  
    	}
        return redisClient;
    }
    /**test*/
	public static void main(String[] args){
		MybatisRedisCache j=new MybatisRedisCache();
		j.putObject("11","11");
		System.out.println(j.getObject("11"));
		j.putObject("11","22");
		System.out.println(j.getObject("11"));
		j.removeObject("11");
		System.out.println(j.getObject("11"));
		System.out.println(j.getObject("11"));
	}
}