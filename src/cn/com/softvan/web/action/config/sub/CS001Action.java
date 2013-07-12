/*
 * 子服务配置 (初始化页面显示)ActionClass
 *
 * VERSION  DATE        BY              REASON
 * -------- ----------- --------------- ------------------------------------------
 * 1.00     2013.06.03  wuxiaogang           程序・发布
 * -------- ----------- --------------- ------------------------------------------
 * Copyright 2013 adsp System. - All Rights Reserved.
 *
 */
package cn.com.softvan.web.action.config.sub;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import cn.com.softvan.bean.config.AdspServiceSubInfoBean;
import cn.com.softvan.service.IServiceSubInfoManager;
import cn.com.softvan.web.action.BaseAction;

/**
 * 子服务配置 (初始化页面显示)
 * 
 * @author {wuxiaogang}
 * 
 */
public class CS001Action extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4932264876200541720L;
	private static final transient Logger log = Logger
			.getLogger(CS001Action.class);

	/** 默认的构造函数 */
	public CS001Action() {
		log.info("CS001Action constructed");
	}

	/** 子服务配置信息 业务处理类 */
	private IServiceSubInfoManager serviceSubInfoManager;

	/**
	 * <p>
	 * 初始化处理。
	 * </p>
	 * <ol>
	 * [功能概要] <div>初始化处理。</div>
	 * </ol>
	 * 
	 * @return 转发字符串
	 */
	public String init() throws Exception {
		log.info("CS001Action init");
		List<AdspServiceSubInfoBean> beans=serviceSubInfoManager.findAdspServiceSubInfoBeanList(new AdspServiceSubInfoBean());
		// 遍历List 按照类型分类组装map对象
		Map<String, List<AdspServiceSubInfoBean>> map = new HashMap<String, List<AdspServiceSubInfoBean>>();
		for (AdspServiceSubInfoBean bean : beans) {
			List<AdspServiceSubInfoBean> tempList = map.get(bean.getConfig_id());
			if (tempList == null) {
				tempList = new LinkedList<AdspServiceSubInfoBean>();
				map.put(bean.getConfig_id(), tempList);
			}
			tempList.add(bean);
		}
		// 已配置 子服务列表
		request.setAttribute("map", map);
		return "init";
	}
	/**
	 * 子服务配置信息 业务处理类取得
	 * 
	 * @return 子服务配置信息 业务处理类
	 */
	public IServiceSubInfoManager getServiceSubInfoManager() {
		return serviceSubInfoManager;
	}

	/**
	 * 子服务配置信息 业务处理类设定
	 * 
	 * @param serviceSubInfoManager
	 *            子服务配置信息 业务处理类
	 */
	public void setServiceSubInfoManager(
			IServiceSubInfoManager serviceSubInfoManager) {
		this.serviceSubInfoManager = serviceSubInfoManager;
	}
}
