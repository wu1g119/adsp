/*
 * 服务配置  manager 接口类
 *
 * VERSION  DATE        BY              REASON
 * -------- ----------- --------------- ------------------------------------------
 * 1.00     2013.02.22  wuxiaogang           程序・发布
 * -------- ----------- --------------- ------------------------------------------
 * Copyright 2013 adsp System. - All Rights Reserved.
 *
 */
package cn.com.softvan.service;

import java.util.List;
import java.util.Map;

import cn.com.softvan.bean.config.AdspServiceConfigInfoBean;
import cn.com.softvan.bean.config.DbConfigBean;
import cn.com.softvan.dao.entity.AdspServiceConfigInfo;


/**
 * 服务配置  manager 接口类
 * @author {wuxiaogang}
 *
 */
public interface IServiceConfigManager {
	/**
	 * 根据参数获取 服务sql
	 * @param sType Q查询U修改I新增D删除
	 * @param bean
	 * @return sql
	 */
	public String getSQl(String sType,DbConfigBean bean);
	
	/**
	 * 获取服务配置json
	 * @param sType Q查询U修改I新增D删除
	 * @param bean
	 * @return json
	 */
	public String getJsonConfig(String sType,DbConfigBean bean);
	/**
	 * 获取服务参数json
	 * @param sType Q查询U修改I新增D删除
	 * @param bean
	 * @return json
	 */
	public String getJsonInput(String sType,DbConfigBean bean);
	/**
	 * 获取服务返回信息json
	 * @param sType Q查询U修改I新增D删除
	 * @param bean
	 * @return json
	 */
	public String getJsonOutput(String sType,DbConfigBean bean);
	
	/**
	 * 修改或保存服务
	 * @param bean
	 * @return msg
	 */
	public String saveOrUpdateAdspServiceConfigInfo(AdspServiceConfigInfoBean bean);
	/**
	 * 逻辑删除服务
	 * @param bean
	 * @return msg
	 */
	public String logicDeleteAdspServiceConfigInfo(AdspServiceConfigInfoBean bean);
	/**
	 * 获取服务详情
	 * @param bean
	 * @return msg
	 */
	public AdspServiceConfigInfoBean findAdspServiceConfigInfoById(AdspServiceConfigInfoBean bean);
	
	/**
     * <p>服务分页显示</p>
     * <ol>[功能概要]
     * <div>服务分页显示</div>
     * </ol>
     * @param page 
     * @return 
     * @throws Exception 数据库操作异常
     */
	public List<AdspServiceConfigInfoBean> findAdspServiceConfigInfoIsPage(AdspServiceConfigInfo dto);
    
	/**
     * <p>服务 列表显示</p>
     * <ol>[功能概要]
     * <div>服务列表显示</div>
     * </ol>
     * @param page 
     * @return 
     * @throws Exception 数据库操作异常
     */
	public List<AdspServiceConfigInfoBean> findAdspServiceConfigInfoList(AdspServiceConfigInfo dto);
  
    /**
	 * TestSQL
	 * @param sql
	 * @return msg
	 */
	public List<Map<?,?>> TestSql(String config,StringBuffer sqlObject);
	/**
	 * 更新服务配置 缓存信息
	 * @param configBean
	 */
	public void updateChcheService(AdspServiceConfigInfoBean configBean);
    
}
