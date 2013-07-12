/*
 * 子服务配置信息  manager 接口类
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

import cn.com.softvan.bean.config.AdspServiceConfigInfoBean;
import cn.com.softvan.bean.config.AdspServiceSubInfoBean;
import cn.com.softvan.dao.entity.AdspServiceSubInfo;

/**
 * 子服务配置信息 manager 接口类
 * 
 * @author {wuxiaogang}
 * 
 */
public interface IServiceSubInfoManager {
	/**
	 * 保存子服务配置信息
	 * @param bean 子系统信息
	 * @param beans 服务列表
	 * @throws Exception 
	 */
	public String saveOrUpdateServiceSubInfo(AdspServiceSubInfoBean bean,List<AdspServiceSubInfoBean> beans) throws Exception;
	/**
	 * 列表展示 子服务配置信息
	 * 
	 * @param bean
	 * @return
	 */
	public List<AdspServiceSubInfoBean> findAdspServiceSubInfoBeanList(
			AdspServiceSubInfoBean bean);
	/**
	 * 列表展示 子服务集合
	 * 
	 * @param bean
	 * @return
	 */
	public List<AdspServiceConfigInfoBean> findAdspServiceConfigInfoBeanList(
			AdspServiceSubInfoBean bean);
	/**
	 * 更新服务配置 子服务 缓存信息
	 * @param configBean
	 */
	public void updateChcheSubService(AdspServiceSubInfoBean subConfigBean);
}
