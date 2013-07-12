/*
 *  子服务配置信息表DAO 接口类
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

import cn.com.softvan.bean.config.AdspServiceConfigInfoBean;
import cn.com.softvan.bean.config.AdspServiceSubInfoBean;
import cn.com.softvan.dao.entity.IEntity;

/**
 * 子服务配置信息表DAO 接口类
 * 
 * @author wuxiaogang
 */
public interface IAdspServiceSubInfoDao {
	//需要缓存的DAO类上添加@CacheNamespace(implementation=MybatisRedisCache.class )
	/**
	 * 保存子服务配置信息
	 * 
	 * @param bean
	 * @return
	 */
	public void insertAdspServiceSubInfo(IEntity dto) throws Exception;

	/**
	 * 删除子服务配置信息
	 * 
	 * @param bean
	 * @return
	 */
	public void deleteAdspServiceSubInfoByConfigId(IEntity dto) throws Exception;

	/**
	 * 列表展示子服务配置信息
	 * 
	 * @param bean
	 * @return
	 */
	public List<AdspServiceSubInfoBean> findAdspServiceSubInfoBeanList(IEntity dto) throws Exception;
	/**
	 * 列表展示 子服务集合
	 * 
	 * @param bean
	 * @return
	 */
	public List<AdspServiceConfigInfoBean> findAdspServiceConfigInfoBeanList(IEntity dto) throws Exception;

}
