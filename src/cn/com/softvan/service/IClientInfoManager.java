/*
 * 子系统信息  manager 接口类
 *
 * VERSION  DATE        BY              REASON
 * -------- ----------- --------------- ------------------------------------------
 * 1.00     2013.03.13  wuxiaogang           程序・发布
 * -------- ----------- --------------- ------------------------------------------
 * Copyright 2013 adsp System. - All Rights Reserved.
 *
 */
package cn.com.softvan.service;

import java.util.List;

import cn.com.softvan.bean.client.AdspClientInfoBean;

/**
 * 子系统信息 manager 接口类
 * 
 * @author {wuxiaogang}
 * 
 */
public interface IClientInfoManager {
	/**
	 * 保存子系统信息
	 * @param bean
	 * @param ip
	 */
	public String saveOrUpdateClientInfo(AdspClientInfoBean bean) throws Exception ;

	/**
	 * 逻辑删除子系统信息
	 * 
	 * @param bean
	 * @return
	 */
	public String logicDeleteClientInfo(AdspClientInfoBean bean);

	/**
	 * 分页展示子系统信息
	 * 
	 * @param bean
	 * @return
	 */
	public List<AdspClientInfoBean> findAdspClientInfoBeanIsPage(
			AdspClientInfoBean bean);
	/**
	 * 列表展示子系统信息
	 * 
	 * @param bean
	 * @return
	 */
	public List<AdspClientInfoBean> findAdspClientInfoBeanList(
			AdspClientInfoBean bean);
	/**
	 * 子系统信息 详情
	 * 
	 * @param bean
	 * @return
	 */
	public AdspClientInfoBean findAdspClientInfoBeanById(AdspClientInfoBean bean);
	/**
	 * 更新客户端信息 缓存信息
	 * @param bean 客户端信息bean
	 */
	public void updateCacheClient(AdspClientInfoBean bean);
	/**
	 * 更新客户端权限 缓存信息
	 * @param bean 客户端信息bean
	 */
	public void updateCacheAuth(AdspClientInfoBean bean);
	
}
