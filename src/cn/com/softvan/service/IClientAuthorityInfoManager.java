/*
 * 子系统权限配置信息  manager 接口类
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

import cn.com.softvan.bean.client.AdspClientAuthorityInfoBean;
import cn.com.softvan.bean.config.AdspServiceConfigInfoBean;
import cn.com.softvan.dao.entity.AdspClientAuthorityInfo;

/**
 * 子系统权限配置信息 manager 接口类
 * 
 * @author {wuxiaogang}
 * 
 */
public interface IClientAuthorityInfoManager {
	/**
	 * 保存子系统权限配置信息
	 * @param bean 子系统信息
	 * @param beans 服务列表
	 */
	public String saveOrUpdateClientAuthorityInfo(AdspClientAuthorityInfo bean,List<AdspClientAuthorityInfoBean> beans) throws Exception ;
	/**
	 * 列表展示子系统权限配置信息
	 * 
	 * @param bean
	 * @return
	 */
	public List<AdspClientAuthorityInfoBean> findAdspClientAuthorityInfoBeanList(
			AdspClientAuthorityInfoBean bean);
	/**
	 * 列表展示 客户端有权限访问的服务集合
	 * 
	 * @param bean
	 * @return
	 */
	public List<AdspServiceConfigInfoBean> findAdspServiceConfigInfoBeanList(
			AdspClientAuthorityInfoBean bean);
	
}
