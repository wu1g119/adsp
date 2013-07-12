/*
 * 存放 临时信息 BEAN CLASS
 *
 * VERSION  DATE          BY              REASON
 * -------- ------------- --------------- ------------------------------------------
 * 1.00     2013.03.13    wuxiaogang           程序・发布
 * -------- ------------- --------------- ------------------------------------------
 * Copyright 2013 adsp System. - All Rights Reserved.
 *
 */
package cn.com.softvan.bean.config;

import cn.com.softvan.bean.BaseBean;

/**
 * 存放数据提取服务配置信息 BEAN CLASS
 * 
 * @author {wuxiaogang}
 * 
 */
public class ConfigObject2Bean extends BaseBean {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1805864386178534896L;

	/** 默认构造器 */
	public ConfigObject2Bean() {
	}
	/** 节点名称 */
	private String node_name;
	/** 服务名 */
	private String serviceName;
	/**
	 * 节点名称取得
	 * @return 节点名称
	 */
	public String getNode_name() {
	    return node_name;
	}

	/**
	 * 节点名称设定
	 * @param node_name 节点名称
	 */
	public void setNode_name(String node_name) {
	    this.node_name = node_name;
	}

	/**
	 * 服务名取得
	 * @return 服务名
	 */
	public String getServiceName() {
	    return serviceName;
	}

	/**
	 * 服务名设定
	 * @param serviceName 服务名
	 */
	public void setServiceName(String serviceName) {
	    this.serviceName = serviceName;
	}
}
