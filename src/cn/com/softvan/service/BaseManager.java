/*
 * 基础Manager类接口
 *
 * VERSION  DATE        BY              REASON
 * -------- ----------- --------------- ------------------------------------------
 * 1.00     2013.04.17  wuxiaogang      程序・发布
 * 2.00     2013.06.09  wuxiaogang      程序・更新  添加jedis缓存工具类
 * -------- ----------- --------------- ------------------------------------------
 * Copyright 2013 adsp System. - All Rights Reserved.
 *
 */
package cn.com.softvan.service;

import java.util.Observable;

import org.springframework.core.task.TaskExecutor;

import cn.com.softvan.common.JedisHelper;
import cn.com.softvan.dao.IAdspServiceLogsDao;

/**
 * 基础Manager类接口
 * @author {wuxiaogang}
 *
 */
public  class BaseManager extends Observable {
	/**
	 * 线程池
	 */
	protected TaskExecutor taskExecutor;
	/**管理员操作日志 业务处理*/
	protected IUserLogsManager userLogsManager;
	/**接口监控日志 DAO*/
	protected IAdspServiceLogsDao adspServiceLogsDao;
	/**接口监控日志  service类 */
	protected IServiceLogsManager serviceLogsManager;
	/**redis缓存工具类*/
	protected JedisHelper jedisHelper;
/**
	 * 管理员操作日志 业务处理设定
	 * @param userLogsManager 管理员操作日志 业务处理
	 */
	public void setUserLogsManager(IUserLogsManager userLogsManager) {
	    this.userLogsManager = userLogsManager;
	}

	/**
	 * 线程池设定
	 * @param taskExecutor 线程池
	 */
	public void setTaskExecutor(TaskExecutor taskExecutor) {
	    this.taskExecutor = taskExecutor;
	}

	/**
	 * 线程池取得
	 * @return 线程池
	 */
	public TaskExecutor getTaskExecutor() {
	return taskExecutor;
	}

	/**
	 * 管理员操作日志 业务处理取得
	 * @return 管理员操作日志 业务处理
	 */
	//	/**Memcached客户端类*/
	//	private static CacheHelper cacheHelper;
	/**
	 * 管理员操作日志 业务处理取得
	 * @return 管理员操作日志 业务处理
	 */
	public IUserLogsManager getUserLogsManager() {
	    return userLogsManager;
	}
	/**
	 * 接口监控日志 DAO取得
	 * @return 接口监控日志 DAO
	 */
	public IAdspServiceLogsDao getAdspServiceLogsDao() {
	    return adspServiceLogsDao;
	}

	/**
	 * 接口监控日志 DAO设定
	 * @param adspServiceLogsDao 接口监控日志 DAO
	 */
	public void setAdspServiceLogsDao(IAdspServiceLogsDao adspServiceLogsDao) {
	    this.adspServiceLogsDao = adspServiceLogsDao;
	}

	/**
	 * 接口监控日志  service类取得
	 * @return 接口监控日志  service类
	 */
	public IServiceLogsManager getServiceLogsManager() {
	    return serviceLogsManager;
	}

	/**
	 * 接口监控日志  service类设定
	 * @param serviceLogsManager 接口监控日志  service类
	 */
	public void setServiceLogsManager(IServiceLogsManager serviceLogsManager) {
	    this.serviceLogsManager = serviceLogsManager;
	}

	/**
	 * redis缓存工具类取得
	 * @return redis缓存工具类
	 */
	public JedisHelper getJedisHelper() {
	    return jedisHelper;
	}

	/**
	 * redis缓存工具类设定
	 * @param jedisHelper redis缓存工具类
	 */
	public void setJedisHelper(JedisHelper jedisHelper) {
	    this.jedisHelper = jedisHelper;
	}

}
