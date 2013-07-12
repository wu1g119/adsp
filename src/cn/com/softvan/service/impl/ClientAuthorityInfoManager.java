/*
 * 子系统权限配置信息  manager 实现类
 *
 * VERSION  DATE        BY              REASON
 * -------- ----------- --------------- ------------------------------------------
 * 1.00     2013.03.13  wuxiaogang           程序・发布
 * -------- ----------- --------------- ------------------------------------------
 * Copyright 2013 adsp System. - All Rights Reserved.
 *
 */
package cn.com.softvan.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import cn.com.softvan.bean.client.AdspClientAuthorityInfoBean;
import cn.com.softvan.bean.config.AdspServiceConfigInfoBean;
import cn.com.softvan.common.IdUtils;
import cn.com.softvan.dao.IAdspClientAuthorityInfoDao;
import cn.com.softvan.dao.entity.AdspClientAuthorityInfo;
import cn.com.softvan.service.BaseManager;
import cn.com.softvan.service.IClientAuthorityInfoManager;
import cn.com.softvan.service.IUserLogsManager;

/**
 * 子系统权限配置信息 manager 实现类
 * 
 * @author {wuxiaogang}
 * 
 */
public class ClientAuthorityInfoManager extends BaseManager implements IClientAuthorityInfoManager {
	/** 日志 */
	private static final transient Logger log = Logger
			.getLogger(ClientAuthorityInfoManager.class);

	/** 默认构造器 */
	public ClientAuthorityInfoManager() {

	}
	/**
	 * 子系统权限配置信息表DAO 接口类
	 */
	private IAdspClientAuthorityInfoDao adspClientAuthorityInfoDao;
	/**
	 * 保存子系统权限配置信息
	 * @param bean 子系统信息
	 * @param beans 服务列表
	 * @throws Exception 
	 */
	public String saveOrUpdateClientAuthorityInfo(AdspClientAuthorityInfo bean,List<AdspClientAuthorityInfoBean> beans) throws Exception {
		String msg="1";
		//清空权限配置信息
		AdspClientAuthorityInfo dto = new AdspClientAuthorityInfo();
		dto.setClient_id(bean.getClient_id());//子系统id
		adspClientAuthorityInfoDao.deleteAdspClientAuthorityInfoByClientId(dto);
		if(beans!=null){
			//添加新的权限配置信息
			for(AdspClientAuthorityInfoBean bean1:beans){
				dto = new AdspClientAuthorityInfo();
				dto.setId(IdUtils.createUUID(32));//ID
				dto.setClient_id(bean.getClient_id());//子系统id
				dto.setService_id(bean1.getService_id());//服务id
				dto.setService_name(bean1.getService_name());//服务名称
				dto.setNote(bean1.getNote());//服务描述
				dto.setCreate_id(bean1.getCreate_id());//建立者ID
				dto.setCreate_ip(bean1.getCreate_ip());//建立者IP
				//新增
				adspClientAuthorityInfoDao.insertAdspClientAuthorityInfo(dto);
			}
			//记录管理员操作日志
			userLogsManager.saveUserLogs(bean.getCreate_id(),"E","新增子系统权限配置信息  adspClientAuthorityInfo  client_id="+bean.getClient_id(),bean.getCreate_ip());
		}
		return msg;
	}
	/**
	 * 列表展示子系统权限配置信息
	 * 
	 * @param bean
	 * @return
	 */
	public List<AdspClientAuthorityInfoBean> findAdspClientAuthorityInfoBeanList(
			AdspClientAuthorityInfoBean bean) {
		List<AdspClientAuthorityInfoBean> beans = null;
		try {
			if(bean!=null){
				AdspClientAuthorityInfo dto=new AdspClientAuthorityInfo();
				dto = new AdspClientAuthorityInfo();
				dto.setId(bean.getId());//ID
				dto.setClient_id(bean.getClient_id());//子系统id
				dto.setService_id(bean.getService_id());//服务id
				dto.setService_name(bean.getService_name());//服务名称
				dto.setNote(bean.getNote());//服务描述
				dto.setCreate_id(bean.getCreate_id());//建立者ID
				dto.setCreate_ip(bean.getCreate_ip());//建立者IP
				//run
				beans=adspClientAuthorityInfoDao.findAdspClientAuthorityInfoBeanList(dto);
			}
		} catch (Exception e) {
			log.error("子系统权限配置信息筛选显示,数据库处理出错!", e);
		}
		return beans;
	}
	/**
	 * 列表展示 客户端有权限访问的服务集合
	 * 
	 * @param bean
	 * @return
	 */
	public List<AdspServiceConfigInfoBean> findAdspServiceConfigInfoBeanList(
			AdspClientAuthorityInfoBean bean){
		 List<AdspServiceConfigInfoBean> beans=null;
		 try {
				if(bean!=null){
					AdspClientAuthorityInfo dto=new AdspClientAuthorityInfo();
					dto.setClient_id(bean.getClient_id());//子系统id
					dto.setService_id(bean.getService_id());//服务id
					dto.setService_name(bean.getService_name());//服务名称
					//run
					beans=adspClientAuthorityInfoDao.findAdspServiceConfigInfoBeanList(dto);
				}
			} catch (Exception e) {
				log.error("子系统权限配置信息筛选显示,数据库处理出错!", e);
			}
		 
		 return beans;
	}
	/**
	 * 子系统权限配置信息表DAO 接口类取得
	 * @return 子系统权限配置信息表DAO 接口类
	 */
	public IAdspClientAuthorityInfoDao getAdspClientAuthorityInfoDao() {
	    return adspClientAuthorityInfoDao;
	}

	/**
	 * 子系统权限配置信息表DAO 接口类设定
	 * @param adspClientAuthorityInfoDao 子系统权限配置信息表DAO 接口类
	 */
	public void setAdspClientAuthorityInfoDao(IAdspClientAuthorityInfoDao adspClientAuthorityInfoDao) {
	    this.adspClientAuthorityInfoDao = adspClientAuthorityInfoDao;
	}
}
