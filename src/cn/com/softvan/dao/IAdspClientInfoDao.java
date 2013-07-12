/*
 *  子系统列表DAO 接口类
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

import cn.com.softvan.bean.client.AdspClientInfoBean;
import cn.com.softvan.dao.entity.IEntity;

/**
 * 子系统列表DAO 接口类
 * 
 * @author wuxiaogang
 */
public interface IAdspClientInfoDao {
	//需要缓存的DAO类上添加@CacheNamespace(implementation=MybatisRedisCache.class )
	/**
	 * 保存子系统信息
	 * 
	 * @param bean
	 * @return
	 */
	public void insertAdspClientInfo(IEntity dto) throws Exception;
	/**
	 * 判断 子系统信息 是否存在
	 * 
	 * @param bean
	 * @return
	 */
	public int isAdspClientInfoYN(IEntity dto) throws Exception;
	/**
	 * 更新子系统信息
	 * 
	 * @param bean
	 * @return
	 */
	public void updateAdspClientInfo(IEntity dto) throws Exception;

	/**
	 * 删除子系统信息
	 * 
	 * @param bean
	 * @return
	 */
	public void deleteAdspClientInfo(IEntity dto) throws Exception;

	/**
	 * 分页展示子系统信息
	 * 
	 * @param bean
	 * @return
	 */
	public List<AdspClientInfoBean> findAdspClientInfoBeanIsPage(IEntity dto) throws Exception;
	/**
	 * 列表展示子系统信息
	 * 
	 * @param bean
	 * @return
	 */
	public List<AdspClientInfoBean> findAdspClientInfoBeanList(IEntity dto) throws Exception;
	/**
	 * 子系统信息 详情
	 * 
	 * @param bean
	 * @return
	 */
	public AdspClientInfoBean findAdspClientInfoBeanById(IEntity dto) throws Exception;
}
