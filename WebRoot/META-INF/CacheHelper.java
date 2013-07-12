/*
 * 缓存工具类
 *
 * VERSION  DATE        BY              REASON
 * -------- ----------- --------------- ------------------------------------------
 * 1.00     2012.02.17  Huyunlin           程序・发布
 * -------- ----------- --------------- ------------------------------------------
 * Copyright 2011 softvan System. - All Rights Reserved.
 *
 */
package cn.com.softvan.common;

import net.rubyeye.xmemcached.MemcachedClient;

import org.apache.log4j.Logger;

/**
 * <p>缓存工具类</p>
 * 
 *
 * @author Huyunlin
 */
public class CacheHelper {
	
	private static final transient Logger log = Logger.getLogger("cache"); 
	
    /**
     * Memcached客户端类
     */
    private MemcachedClient memcachedClient;
    
    public CacheHelper() {
    	log.info("CacheHelper init.");
    }
	
    /**
     * <p>根据KEY从缓存取值</p>
     * @return 结果
     */
    public Object get(String key) {  
    	
		try {
			return memcachedClient.get(key);
		} catch(Exception ex) {
        	log.error("从缓存取值异常", ex);
        	return null;
		}
    }
    
    /**
     * <p>缓存数据</p>
     * @return true:成功；false:失败
     */
    public boolean set(String key, int timeout, Object arg0) {  
    	
		try {
			return memcachedClient.set(key, timeout, arg0);
		} catch(Exception ex) {
        	log.error("放入缓存异常", ex);
        	return false;
		}
    }
    
    /**
     * <p>删除缓存数据</p>
     * @return true:成功；false:失败
     */
    public boolean delete(String key) {  
    	
		try {
			return memcachedClient.delete(key);
		} catch(Exception ex) {
        	log.error("删除缓存数据异常", ex);
        	return false;
		}
    }

	/**
	 * Memcached客户端类取得
	 * @return Memcached客户端类
	 */
	public MemcachedClient getMemcachedClient() {
	    return memcachedClient;
	}


	/**
	 * Memcached客户端类设定
	 * @param memcachedClient Memcached客户端类
	 */
	public void setMemcachedClient(MemcachedClient memcachedClient) {
	    this.memcachedClient = memcachedClient;
	}
	
	public static void main(String args[]) {

	}
}
