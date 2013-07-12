/*
 *  接口监控日志表DAO 接口类
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

import cn.com.softvan.bean.logs.AdspServiceLogsBean;
import cn.com.softvan.dao.entity.IEntity;

/**
 * 接口监控日志表DAO 接口类
 * 
 * @author wuxiaogang
 */
public interface IAdspServiceLogsDao {
	//需要缓存的DAO类上添加@CacheNamespace(implementation=MybatisRedisCache.class )
	/**
	 * 保存接口监控日志表
	 * 
	 * @param bean
	 * @return
	 */
	public void insertServiceLogs(IEntity dto) throws Exception;

	/**
	 * 删除接口监控日志表
	 * 
	 * @param bean
	 * @return
	 */
	public void deleteServiceLogs(IEntity dto) throws Exception;

	/**
	 * 分页展示接口监控日志表
	 * 
	 * @param bean
	 * @return
	 */
	public List<AdspServiceLogsBean> findAdspServiceLogsbeanIsPage(IEntity dto) throws Exception;

	/**
	 * 接口监控日志表 详情
	 * 
	 * @param bean
	 * @return
	 */
	public AdspServiceLogsBean findAdspServiceLogsbeanById(IEntity dto) throws Exception;
}
