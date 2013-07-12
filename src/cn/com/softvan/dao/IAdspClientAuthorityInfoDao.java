/*
 *  子系统权限配置表DAO 接口类
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

import cn.com.softvan.bean.client.AdspClientAuthorityInfoBean;
import cn.com.softvan.bean.config.AdspServiceConfigInfoBean;
import cn.com.softvan.dao.entity.IEntity;

/**
 * 子系统权限配置表DAO 接口类
 * 
 * @author wuxiaogang
 */
public interface IAdspClientAuthorityInfoDao{
//需要缓存的DAO类上添加@CacheNamespace(implementation=MybatisRedisCache.class )
	/**
	 * 保存子系统权限配置信息
	 * 
	 * @param bean
	 * @return
	 */
	public void insertAdspClientAuthorityInfo(IEntity dto) throws Exception;

	/**
	 * 删除子系统权限配置信息
	 * 
	 * @param bean
	 * @return
	 */
	public void deleteAdspClientAuthorityInfoByClientId(IEntity dto) throws Exception;

	/**
	 * 列表展示子系统权限配置信息
	 * 
	 * @param bean
	 * @return
	 */
	public List<AdspClientAuthorityInfoBean> findAdspClientAuthorityInfoBeanList(IEntity dto) throws Exception;
	/**
	 * 列表展示 客户端有权限访问的服务集合
	 * 
	 * @param bean
	 * @return
	 */
	public List<AdspServiceConfigInfoBean> findAdspServiceConfigInfoBeanList(IEntity dto) throws Exception;
}
