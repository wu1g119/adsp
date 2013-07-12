/*
 * 子服务配置信息  manager 实现类
 *
 * VERSION  DATE        BY              REASON
 * -------- ----------- --------------- ------------------------------------------
 * 1.00     2013.03.13  wuxiaogang           程序・发布
 * -------- ----------- --------------- ------------------------------------------
 * Copyright 2013 adsp System. - All Rights Reserved.
 *
 */
package cn.com.softvan.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.com.softvan.bean.config.AdspServiceConfigInfoBean;
import cn.com.softvan.bean.config.AdspServiceSubInfoBean;
import cn.com.softvan.bean.config.ConfigObject2Bean;
import cn.com.softvan.common.CommonConstant;
import cn.com.softvan.common.IdUtils;
import cn.com.softvan.dao.IAdspServiceSubInfoDao;
import cn.com.softvan.dao.entity.AdspServiceConfigInfo;
import cn.com.softvan.dao.entity.AdspServiceSubInfo;
import cn.com.softvan.service.BaseManager;
import cn.com.softvan.service.IServiceConfigManager;
import cn.com.softvan.service.IServiceSubInfoManager;

/**
 * 子服务配置信息 manager 实现类
 * 
 * @author {wuxiaogang}
 * 
 */
public class ServiceSubInfoManager extends BaseManager implements IServiceSubInfoManager {
	/** 日志 */
	private static final transient Logger log = Logger
			.getLogger(ServiceSubInfoManager.class);

	/** 默认构造器 */
	public ServiceSubInfoManager() {

	}
	/**
	 * 子服务配置信息表DAO 接口类
	 */
	private IAdspServiceSubInfoDao adspServiceSubInfoDao;
	/** 服务配置信息  业务处理类 */
	private IServiceConfigManager serviceConfigManager;
	
	/**
	 * 保存子服务配置信息
	 * @param bean 子系统信息
	 * @param beans 服务列表
	 * @throws Exception 
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = CommonConstant.DB_DEFAULT_TIMEOUT, rollbackFor = {
			Exception.class, RuntimeException.class })
	public String saveOrUpdateServiceSubInfo(AdspServiceSubInfoBean bean,List<AdspServiceSubInfoBean> beans) throws Exception {
		String msg="1";
		//清空配置信息
		AdspServiceSubInfo dto = new AdspServiceSubInfo();
		dto.setConfig_id(bean.getConfig_id());//服务id
		adspServiceSubInfoDao.deleteAdspServiceSubInfoByConfigId(dto);
		if(beans!=null){
			//添加新的配置信息
			for(AdspServiceSubInfoBean bean1:beans){
				dto = new AdspServiceSubInfo();
				dto.setId(IdUtils.createUUID(32));//ID
//				dto.setVersion(bean1.getVersion());//version
				dto.setConfig_id(bean.getConfig_id());//主服务
				dto.setSub_config_id(bean1.getSub_config_id());//下级服务
				dto.setNode_name(bean1.getNode_name());//节点名称
//				dto.setDel_flag(bean1.getDel_flag());//删除标记
				dto.setNote(bean1.getNote());//备注
//				dto.setDate_created(bean1.getDate_created());//数据输入日期
				dto.setCreate_id(bean1.getCreate_id());//建立者ID
				dto.setCreate_ip(bean1.getCreate_ip());//建立者IP
				//新增
				adspServiceSubInfoDao.insertAdspServiceSubInfo(dto);
			}
			//记录管理员操作日志
			userLogsManager.saveUserLogs(bean.getCreate_id(),"E","新增子服务配置信息  adspServiceSubInfo  client_id="+bean.getConfig_id(),bean.getCreate_ip());
		}
		if("1".equals(jedisHelper.get("flag_updateChcheSubService"))){
			//TODO 更新服务配置 子服务 缓存信息
			updateChcheSubService(bean);
		}else{
			updateChcheSubService(null);
		}
		
		return msg;
	}
	/**
	 * 更新服务配置 子服务 缓存信息
	 * @param configBean
	 */
	public void updateChcheSubService(AdspServiceSubInfoBean subConfigBean){
		if(subConfigBean!=null){
			//服务信息bean
			AdspServiceConfigInfoBean configBean=new AdspServiceConfigInfoBean();
			configBean.setId(subConfigBean.getConfig_id());
			//获取否配置详情
			configBean=	serviceConfigManager.findAdspServiceConfigInfoById(configBean);	
			//子服务集合
			List<AdspServiceConfigInfoBean> list2=this.findAdspServiceConfigInfoBeanList(subConfigBean);
			if(list2!=null){
				//子服务 解析集合 
				List<ConfigObject2Bean> subServiceLists=new ArrayList<ConfigObject2Bean>();
				//遍历 子服务集合
				for(AdspServiceConfigInfoBean bean1:list2){
					try {
						ConfigObject2Bean configObject2Bean=new ConfigObject2Bean();
						//节点信息
						configObject2Bean.setNode_name(bean1.getNode_name());
						//服务名称
						configObject2Bean.setServiceName(bean1.getName());
						//add list
						subServiceLists.add(configObject2Bean);
					} catch (Exception e) {
						log.error("缓存集合生成错误",e);
					}
				}
				//TODO 保存  服务  子服务集合缓存
				jedisHelper.set("sub_"+configBean.getName(),subServiceLists,CommonConstant.JEDIS_TIME_OUT);
//				cacheHelper.set("sub_"+bean.getName(),MemcachedConstants.DEFAULT_TIMEOUT,subServiceLists);
//				chacheMap.put("sub_"+bean.getName(), subServiceLists);
			}
		}else{
			//缓存存在标记
			jedisHelper.set("flag_updateChcheSubService", "1");
			
			//服务列表
			AdspServiceConfigInfo dto=new AdspServiceConfigInfo();
			//精简数据
			dto.setXx_flag("xxxx");
			List<AdspServiceConfigInfoBean> list=serviceConfigManager.findAdspServiceConfigInfoList(dto);
			if(list!=null){
				//遍历服务集合
				for(AdspServiceConfigInfoBean bean:list){
					//服务信息bean
					AdspServiceSubInfoBean subBean=new AdspServiceSubInfoBean();
					subBean.setConfig_id(bean.getId());
					//子服务集合
					List<AdspServiceConfigInfoBean> list2=this.findAdspServiceConfigInfoBeanList(subBean);
					if(list2!=null){
						//子服务 解析集合 
						List<ConfigObject2Bean> subServiceLists=new ArrayList<ConfigObject2Bean>();
						//遍历 子服务集合
						for(AdspServiceConfigInfoBean bean1:list2){
							try {
								ConfigObject2Bean configObject2Bean=new ConfigObject2Bean();
								//节点信息
								configObject2Bean.setNode_name(bean1.getNode_name());
								//服务名称
								configObject2Bean.setServiceName(bean1.getName());
								//add list
								subServiceLists.add(configObject2Bean);
							} catch (Exception e) {
								log.error("缓存集合生成错误",e);
							}
						}
						//TODO 保存  服务  子服务集合缓存
						jedisHelper.set("sub_"+bean.getName(),subServiceLists,CommonConstant.JEDIS_TIME_OUT);
	//					cacheHelper.set("sub_"+bean.getName(),MemcachedConstants.DEFAULT_TIMEOUT,subServiceLists);
	//					chacheMap.put("sub_"+bean.getName(), subServiceLists);
					}
				}
			}
		}
		log.info("\n----------------------------更新服务配置 子服务 缓存信息------------------------\n");
	}
	/**
	 * 列表展示子服务配置信息
	 * 
	 * @param bean
	 * @return
	 */
	public List<AdspServiceSubInfoBean> findAdspServiceSubInfoBeanList(
			AdspServiceSubInfoBean bean) {
		List<AdspServiceSubInfoBean> beans = null;
		try {
			if(bean!=null){
				AdspServiceSubInfo dto=new AdspServiceSubInfo();
//				dto.setId(IdUtils.createUUID(32));//ID
//				dto.setVersion(bean.getVersion());//version
				dto.setConfig_id(bean.getConfig_id());//主服务
//				dto.setSub_config_id(bean.getSub_config_id());//下级服务
//				dto.setNode_name(bean.getNode_name());//节点名称
//				dto.setDel_flag(bean.getDel_flag());//删除标记
//				dto.setNote(bean.getNote());//备注
//				dto.setDate_created(bean.getDate_created());//数据输入日期
//				dto.setCreate_id(bean.getCreate_id());//建立者ID
//				dto.setCreate_ip(bean.getCreate_ip());//建立者IP
				//run
				beans=adspServiceSubInfoDao.findAdspServiceSubInfoBeanList(dto);
			}
		} catch (Exception e) {
			log.error("子服务配置信息筛选显示,数据库处理出错!", e);
		}
		return beans;
	}
	/**
	 * 列表展示 子服务集合
	 * 
	 * @param bean
	 * @return
	 */
	public List<AdspServiceConfigInfoBean> findAdspServiceConfigInfoBeanList(
			AdspServiceSubInfoBean bean){
		 List<AdspServiceConfigInfoBean> beans=null;
		 try {
				if(bean!=null){
					AdspServiceSubInfo dto=new AdspServiceSubInfo();
					dto.setConfig_id(bean.getConfig_id());//服务id
					//run
					beans=adspServiceSubInfoDao.findAdspServiceConfigInfoBeanList(dto);
				}
			} catch (Exception e) {
				log.error("子服务配置信息筛选显示,数据库处理出错!", e);
			}
		 
		 return beans;
	}
	/**
	 * 子服务配置信息表DAO 接口类取得
	 * @return 子服务配置信息表DAO 接口类
	 */
	public IAdspServiceSubInfoDao getAdspServiceSubInfoDao() {
	    return adspServiceSubInfoDao;
	}

	/**
	 * 子服务配置信息表DAO 接口类设定
	 * @param adspServiceSubInfoDao 子服务配置信息表DAO 接口类
	 */
	public void setAdspServiceSubInfoDao(IAdspServiceSubInfoDao adspServiceSubInfoDao) {
	    this.adspServiceSubInfoDao = adspServiceSubInfoDao;
	}
	/**
	 * 服务配置信息  业务处理类取得
	 * @return 服务配置信息  业务处理类
	 */
	public IServiceConfigManager getServiceConfigManager() {
	    return serviceConfigManager;
	}
	/**
	 * 服务配置信息  业务处理类设定
	 * @param serviceConfigManager 服务配置信息  业务处理类
	 */
	public void setServiceConfigManager(IServiceConfigManager serviceConfigManager) {
	    this.serviceConfigManager = serviceConfigManager;
	}
}
