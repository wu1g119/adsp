/*
 * jerdis 工具类
 *
 * VERSION  		DATE       			 BY              REASON
 * -------- ----------- --------------- ------------------------------------------
 * 1.00     	    2013.03.12  	 	wuxiaogang       程序?发布                 
 * -------- ----------- --------------- ------------------------------------------
 * Copyright 2013 adsp System. - All Rights Reserved.
 *
 */

package cn.com.softvan.common;

import java.util.Set;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import cn.com.softvan.dao.utils.SerializeUtil;

public class JedisHelper {
	private static final transient Logger log = Logger.getLogger("cache");
	// 操作redis客户端
	private static Jedis jedis;
	/** spring jredis factory */
	private redis.clients.jedis.JedisPool jedisPool;

	public JedisHelper() {

	}

	/**
	 * 获取一个jedis 客户端
	 * 
	 * @return
	 */
	public Jedis getJedis() {
		if (jedis == null) {
			return jedisPool.getResource();
		}
		return jedis;
	}

	/**
	 * 通过key删除（字节）
	 * 
	 * @param key
	 */
	public void del(byte[] key) {
		try{
			this.getJedis().del(key);
		}finally{
			jedisPool.returnResource(this.getJedis());
		}
	}

	/**
	 * 通过key删除
	 * 
	 * @param key
	 */
	public void del(String key) {
		try {
			if(key==null){
				return ;
			}
			this.getJedis().del(key.getBytes());
		}finally{
			jedisPool.returnResource(this.getJedis());
		}
	}

	/**
	 * 添加key value 并且设置存活时间(byte)
	 * 
	 * @param key
	 * @param value
	 * @param liveTime
	 */
	public void set(byte[] key, byte[] value, int liveTime) {
		try{
			this.set(key, value);
			this.getJedis().expire(key, liveTime);
		}finally{
			jedisPool.returnResource(this.getJedis());
		}
	}

	/**
	 * 添加key value 并且设置存活时间
	 * 
	 * @param key
	 * @param value
	 * @param liveTime
	 */
	public void set(String key, Object value, int liveTime) {
		try {
			log.debug(">=========setObject==="+key+"===="+value);
			if(key==null){
				return ;
			}
			this.getJedis().set(key.getBytes(),SerializeUtil.serialize(value));
			this.getJedis().expire(key.getBytes(), liveTime);
		}finally{
			jedisPool.returnResource(this.getJedis());
		}
	}

	/**
	 * 添加key value
	 * 
	 * @param key
	 * @param value
	 */
	public void set(String key, Object value) {
		try {
			if(key==null){
				return ;
			}
			this.getJedis().set(key.getBytes(), SerializeUtil.serialize(value));
		}finally{
			jedisPool.returnResource(this.getJedis());
		}
	}

	/**
	 * 添加key value (字节)(序列化)
	 * 
	 * @param key
	 * @param value
	 */
	public void set(byte[] key, byte[] value) {
		try {
			this.getJedis().set(key, value);
		}finally{
			jedisPool.returnResource(this.getJedis());
		}
	}

	/**
	 * 获取redis value (String)
	 * 
	 * @param key
	 * @return
	 */
	public Object get(String key) {
		log.debug(">===========getObject="+key);
		try {
			if (key == null) {
				return null;
			}
			byte[] bs = this.getJedis().get(key.getBytes());
			return SerializeUtil.unserialize(bs);
		}finally{
			jedisPool.returnResource(this.getJedis());
		}
	}

	/**
	 * 获取redis value (byte [] )(反序列化)
	 * 
	 * @param key
	 * @return
	 */
	public byte[] get(byte[] key) {
		try {
			return this.getJedis().get(key);
		}finally{
			jedisPool.returnResource(this.getJedis());
		}
	}

	/**
	 * 通过正则匹配keys
	 * 
	 * @param pattern
	 * @return
	 */
	public Set<String> keys(String pattern) {
		try {
			return this.getJedis().keys(pattern);
		}finally{
			jedisPool.returnResource(this.getJedis());
		}
	}

	/**
	 * 检查key是否已经存在
	 * 
	 * @param key
	 * @return
	 */
	public boolean exists(String key) {
		try {
			if (key == null) {
				return false;
			}
			return this.getJedis().exists(key.getBytes());
		}finally{
			jedisPool.returnResource(this.getJedis());
		}
	}

	/**
	 * 清空redis 所有数据
	 * 
	 * @return
	 */
	public String flushDB() {
		try {
			return this.getJedis().flushDB();
		}finally{
			jedisPool.returnResource(this.getJedis());
		}
	}
	public Object remove(String key) {
		try{
			if(key==null){
				return null;
			}
			return this.getJedis().expire(key.getBytes(),0);
		}finally{  
	   	 jedisPool.returnResource(this.getJedis());
	    } 
	}
	/**
	 * 查看redis里有多少数据
	 */
	public long dbSize() {
		try {
			return this.getJedis().dbSize();
		}finally{
			jedisPool.returnResource(this.getJedis());
		}
	}

	/**
	 * 检查是否连接成功
	 * 
	 * @return
	 */
	public String ping() {
		try {
			return this.getJedis().ping();
		}finally{
			jedisPool.returnResource(this.getJedis());
		}
	}
	/**
	 * spring jredis factory取得
	 * @return spring jredis factory
	 */
	public redis.clients.jedis.JedisPool getJedisPool() {
	    return jedisPool;
	}

	/**
	 * spring jredis factory设定
	 * @param jedisPool spring jredis factory
	 */
	public void setJedisPool(redis.clients.jedis.JedisPool jedisPool) {
	    this.jedisPool = jedisPool;
	}
}
