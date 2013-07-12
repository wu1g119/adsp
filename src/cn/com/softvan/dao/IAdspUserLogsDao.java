/*
 *  管理员操作日志表DAO 接口类
 *
 * VERSION  		DATE       			 BY              REASON
 * -------- ----------- --------------- ------------------------------------------
 * 1.00     	    2013.02.22  	 	wuxiaogang       程序・发布                 
 * -------- ----------- --------------- ------------------------------------------
 * Copyright 2013 adsp System. - All Rights Reserved.
 *
 */
package cn.com.softvan.dao;

import java.util.List;

import cn.com.softvan.bean.logs.AdspUserLogsBean;
import cn.com.softvan.dao.entity.IEntity;

/**
 * 管理员操作日志表DAO 接口类
 * @author wuxiaogang
 */
public interface IAdspUserLogsDao{
	//需要缓存的DAO类上添加@CacheNamespace(implementation=MybatisRedisCache.class )
	/**
	 * 保存管理员操作日志
	 * 
	 * @param bean
	 * @return
	 */
	public void insertUserLogs(IEntity dto) throws Exception;

	/**
	 * 删除管理员操作日志
	 * 
	 * @param bean
	 * @return
	 */
	public void deleteUserLogs(IEntity dto) throws Exception;

	/**
	 * 分页展示管理员操作日志
	 * 
	 * @param bean
	 * @return
	 */
	public List<AdspUserLogsBean> findAdspUserLogsbeanIsPage(IEntity dto) throws Exception;

	/**
	 * 管理员操作日志 详情
	 * 
	 * @param bean
	 * @return
	 */
	public AdspUserLogsBean findAdspUserLogsbeanById(IEntity dto) throws Exception;
}
