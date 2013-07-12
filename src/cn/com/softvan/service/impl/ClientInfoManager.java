/*
 * 客户端信息  manager 实现类
 *
 * VERSION  DATE        BY              REASON
 * -------- ----------- --------------- ------------------------------------------
 * 1.00     2013.03.08  wuxiaogang           程序・发布
 * -------- ----------- --------------- ------------------------------------------
 * Copyright 2013 adsp System. - All Rights Reserved.
 *
 */
package cn.com.softvan.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.com.softvan.bean.client.AdspClientAuthorityInfoBean;
import cn.com.softvan.bean.client.AdspClientInfoBean;
import cn.com.softvan.bean.config.AdspServiceConfigInfoBean;
import cn.com.softvan.bean.config.ConfigJsonBean;
import cn.com.softvan.common.CommonConstant;
import cn.com.softvan.common.IdUtils;
import cn.com.softvan.common.JsonUtils;
import cn.com.softvan.common.Validator;
import cn.com.softvan.dao.IAdspClientInfoDao;
import cn.com.softvan.dao.entity.AdspClientAuthorityInfo;
import cn.com.softvan.dao.entity.AdspClientInfo;
import cn.com.softvan.service.BaseManager;
import cn.com.softvan.service.IClientAuthorityInfoManager;
import cn.com.softvan.service.IClientInfoManager;

/**
 * 客户端信息 manager 实现类
 * 
 * @author {wuxiaogang}
 * 
 */
public class ClientInfoManager extends BaseManager implements IClientInfoManager {
	/** 日志 */
	private static final transient Logger log = Logger
			.getLogger(ClientInfoManager.class);

	/** 默认构造器 */
	public ClientInfoManager() {

	}
	/**
	 * 客户端信息表DAO 接口类
	 */
	private IAdspClientInfoDao adspClientInfoDao;
	/** 客户端权限配置信息 manager 业务处理类 */
	private IClientAuthorityInfoManager clientAuthorityInfoManager;
	/**
	 * 保存客户端信息
	 * @param bean
	 * @param ip
	 * @throws Exception 
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = CommonConstant.DB_DEFAULT_TIMEOUT, rollbackFor = {
			Exception.class, RuntimeException.class })
	public String saveOrUpdateClientInfo(AdspClientInfoBean bean) throws Exception {
		String msg="";
			AdspClientInfo dto = new AdspClientInfo();
			/* ID */
			//id >20
			if(!Validator.isEmpty(bean.getId())&& bean.getId().trim().length()>20){
				dto.setId(bean.getId());
			}
			/* version */
			dto.setVersion(bean.getVersion());
			/* 客户端IP */
			dto.setClient_ip(bean.getClient_ip());
			/* 客户端编号 */
			dto.setClient_code(bean.getClient_code());
			/* 客户端名称 */
			dto.setClient_name(bean.getClient_name());
			/* 备注 */
			dto.setNote(bean.getNote());
			/* 删除标记 */
			dto.setDel_flag(bean.getDel_flag());
			/* 数据输入日期 */
			dto.setDate_created(bean.getDate_created());
			/* 建立者ID */
			dto.setCreate_id(bean.getCreate_id());
			/* 建立者IP */
			dto.setCreate_ip(bean.getCreate_ip());
			/* 资料更新日期 */
			dto.setLast_updated(bean.getLast_updated());
			/* 修改者ID */
			dto.setUpdate_id(bean.getUpdate_id());
			/* 修改者IP */
			dto.setUpdate_ip(bean.getUpdate_ip());
			//判断服务是否存在
			if(dto.getId()!=null && adspClientInfoDao.isAdspClientInfoYN(dto)>0){
				//服务存在 
				//更新
				adspClientInfoDao.updateAdspClientInfo(dto);
				//记录管理员操作日志
				userLogsManager.saveUserLogs(bean.getUpdate_id(),"E","客户端信息更新  adspClientInfo="+bean.getId(),bean.getUpdate_ip());
			}else{
				//服务不存在
				//生成ID
				dto.setId(IdUtils.createUUID(32));bean.setId(dto.getId());
				//VERSIONS
				dto.setVersion("1");
				//创建者IP
				dto.setCreate_ip(bean.getCreate_ip());
				//创建者ID
				dto.setCreate_id(bean.getCreate_id());
				//新增
				adspClientInfoDao.insertAdspClientInfo(dto);
				//记录管理员操作日志
				userLogsManager.saveUserLogs(bean.getUpdate_id(),"I","新增客户端信息  adspClientInfo="+bean.getId(),bean.getUpdate_ip());
			}
			//
			AdspClientAuthorityInfo dtoAuth=new AdspClientAuthorityInfo();
			//客户端id
			dtoAuth.setClient_id(dto.getId());
			//创建人id
			dtoAuth.setCreate_id(bean.getCreate_id());
			//IP
			dtoAuth.setCreate_ip(bean.getCreate_ip());
			//存储权限信息
			clientAuthorityInfoManager.saveOrUpdateClientAuthorityInfo(dtoAuth,bean.getClientAuthBeans());
			if("1".equals(jedisHelper.get("flag_updateCacheClient"))){
				//更新权限缓存信息
				updateCacheClient(bean);
			}else{
				//更新全部
				updateCacheClient(null);
			}
			if("1".equals(jedisHelper.get("flag_updateCacheAuth"))){
				//更新客户端缓存信息
				updateCacheAuth(bean);
			}else{
				//更新全部
				updateCacheAuth(null);
			}
			//
			msg="1";
		return msg;
	}
	/**
	 * 更新客户端信息 缓存信息
	 * @param bean 客户端信息bean
	 */
	public void updateCacheClient(AdspClientInfoBean bean){
			if(bean!=null){
				//TODO 保存  客户端信息缓存
				jedisHelper.set("client_"+bean.getClient_code(),bean,CommonConstant.JEDIS_TIME_OUT);
			}else{
				//缓存存在标记
				jedisHelper.set("flag_updateCacheClient", "1");
				
				//客户端系统列表
				AdspClientInfoBean clientInfoBean=new AdspClientInfoBean();
				//未删除
				clientInfoBean.setDel_flag("0");
				List<AdspClientInfoBean> clientBeans=this.findAdspClientInfoBeanList(clientInfoBean);
				if(clientBeans!=null){
					//遍历客户端系统
					for(AdspClientInfoBean clientBean:clientBeans){
						//TODO 保存  客户端权限缓存
						jedisHelper.set("client_"+clientBean.getClient_code(),clientBean,CommonConstant.JEDIS_TIME_OUT);
					}
				}
			}
			log.info("\n----------------------------更新客户端信息 缓存信息------------------------\n");
	}
	/**
	 * 更新客户端权限 缓存信息
	 * @param bean 客户端信息bean
	 */
	public void updateCacheAuth(AdspClientInfoBean bean){
		if(bean!=null){
			//客户端权限配置bean
			AdspClientAuthorityInfoBean clientAuthorityInfoBean=new AdspClientAuthorityInfoBean();
			//客户端id
			clientAuthorityInfoBean.setClient_id(bean.getId());
			//客户端有权限访问的服务集合
			List<AdspServiceConfigInfoBean> list=clientAuthorityInfoManager.findAdspServiceConfigInfoBeanList(clientAuthorityInfoBean);
			//客户端有权限访问的服务 解析集合
			Map<String,ConfigJsonBean> serviceMaps=new HashMap<String,ConfigJsonBean>();
			if(list!=null){
				//遍历 客户端有权限访问的服务集合
				for(AdspServiceConfigInfoBean bean1:list){
					try {
						//key:服务名称 value:服务配置 解析的json
						serviceMaps.put(bean1.getName(), (ConfigJsonBean)JsonUtils.jsonToBean2(bean1.getConfig()));
					} catch (Exception e) {
						log.error("缓存集合生成错误",e);
					}
				}
			}
			//TODO 保存  客户端权限缓存
			jedisHelper.set("auth_"+bean.getClient_code(), serviceMaps,CommonConstant.JEDIS_TIME_OUT);
//				cacheHelper.set("client_"+clientBean.getClient_code(),MemcachedConstants.DEFAULT_TIMEOUT,serviceMaps);
//				chacheMap.put("client_"+clientBean.getClient_code(), serviceMaps);
		}else{
			//缓存存在标记
			jedisHelper.set("flag_updateCacheAuth", "1");
			
			//客户端系统列表
			AdspClientInfoBean clientInfoBean=new AdspClientInfoBean();
			//未删除
			clientInfoBean.setDel_flag("0");
			List<AdspClientInfoBean> clientBeans=this.findAdspClientInfoBeanList(clientInfoBean);
			if(clientBeans!=null){
				//遍历客户端系统
				for(AdspClientInfoBean clientBean:clientBeans){
					//客户端权限配置bean
					AdspClientAuthorityInfoBean clientAuthorityInfoBean=new AdspClientAuthorityInfoBean();
					//客户端id
					clientAuthorityInfoBean.setClient_id(clientBean.getId());
					//客户端有权限访问的服务集合
					List<AdspServiceConfigInfoBean> list=clientAuthorityInfoManager.findAdspServiceConfigInfoBeanList(clientAuthorityInfoBean);
					//客户端有权限访问的服务 解析集合
					Map<String,ConfigJsonBean> serviceMaps=new HashMap<String,ConfigJsonBean>();
					if(list!=null){
						//遍历 客户端有权限访问的服务集合
						for(AdspServiceConfigInfoBean bean1:list){
							try {
								//key:服务名称 value:服务配置 解析的json
								serviceMaps.put(bean1.getName(), (ConfigJsonBean)JsonUtils.jsonToBean2(bean1.getConfig()));
							} catch (Exception e) {
								log.error("缓存集合生成错误",e);
							}
						}
					}
					//TODO 保存  客户端权限缓存
					jedisHelper.set("auth_"+clientBean.getClient_code(), serviceMaps,CommonConstant.JEDIS_TIME_OUT);
	//				cacheHelper.set("client_"+clientBean.getClient_code(),MemcachedConstants.DEFAULT_TIMEOUT,serviceMaps);
	//				chacheMap.put("client_"+clientBean.getClient_code(), serviceMaps);
				}
			}
		}
		log.info("\n----------------------------更新客户端权限 缓存信息------------------------\n");
	}
	/**
	 * 删除客户端信息
	 * 
	 * @param bean
	 * @return
	 */
	public String logicDeleteClientInfo(AdspClientInfoBean bean) {
		String msg="1";
		try {
			//客户端dto
			AdspClientInfo dto=new AdspClientInfo();
			//id >20
			if(!Validator.isEmpty(bean.getId())&& bean.getId().trim().length()>20){
				dto.setId(bean.getId());
			}
			//修改者IP
			dto.setUpdate_ip(bean.getUpdate_ip());
			//修改者ID
			dto.setUpdate_id(bean.getUpdate_id());
			//是否删除
			dto.setDel_flag(bean.getDel_flag());
			//判断客户端是否存在
			if(dto.getId()!=null && adspClientInfoDao.isAdspClientInfoYN(dto)>0){
				//客户端存在 
				//更新
				adspClientInfoDao.updateAdspClientInfo(dto);
				//记录管理员操作日志
				if("1".equals(bean.getDel_flag())){
					//记录管理员操作日志
					userLogsManager.saveUserLogs(bean.getUpdate_id(),"D","逻辑删除服务调用客户端  adspClientInfo="+bean.getId(),bean.getUpdate_ip());
					//TODO  缓存更新 ========移除缓存===
//					System.out.println("dto=2=id-=="+dto.getId());
					if(bean!=null){
						jedisHelper.remove("client_"+bean.getClient_code());
					}
				}else{
					//记录管理员操作日志
					userLogsManager.saveUserLogs(bean.getUpdate_id(),"R","恢复服务调用客户端  adspClientInfo="+bean.getId(),bean.getUpdate_ip());
					//TODO  缓存更新 ========添加缓存===
//					System.out.println("dto=3=id-=="+dto.getId());
					AdspClientInfoBean clientBean=adspClientInfoDao.findAdspClientInfoBeanById(dto);
					if(clientBean!=null){
						jedisHelper.set("client_"+clientBean.getClient_code(),clientBean,CommonConstant.JEDIS_TIME_OUT);
					}
				}
			}else{
				//客户端不存在
				msg="操作失败!客户端不存在!";
			}
			
		} catch (Exception e) {
			msg="客户端信息数据库操作异常!";
			log.error("客户端信息数据库操作异常:", e);
		}
		return msg;
	}

	/**
	 * 分页展示客户端信息
	 * 
	 * @param bean
	 * @return
	 */
	public List<AdspClientInfoBean> findAdspClientInfoBeanIsPage(
			AdspClientInfoBean bean) {
		List<AdspClientInfoBean> beans = null;
		try {
			AdspClientInfo dto=new AdspClientInfo();
			/* ID */
			dto.setId(bean.getId());
			/* version */
			dto.setVersion(bean.getVersion());
			/* 客户端IP */
			dto.setClient_ip(bean.getClient_ip());
			/* 客户端编号 */
			dto.setClient_code(bean.getClient_code());
			/* 客户端名称 */
			dto.setClient_name(bean.getClient_name());
			/* 备注 */
			dto.setNote(bean.getNote());
			/* 删除标记 */
			dto.setDel_flag(bean.getDel_flag());
			/* 数据输入日期 */
			dto.setDate_created(bean.getDate_created());
			/* 建立者ID */
			dto.setCreate_id(bean.getCreate_id());
			/* 建立者IP */
			dto.setCreate_ip(bean.getCreate_ip());
			/* 资料更新日期 */
			dto.setLast_updated(bean.getLast_updated());
			/* 修改者ID */
			dto.setUpdate_id(bean.getUpdate_id());
			/* 修改者IP */
			dto.setUpdate_ip(bean.getUpdate_ip());
			//分页对象
			dto.setPageinfo(bean.getPageinfo());
			//时间1
			dto.setDate1(bean.getDate1());
			//时间2
			dto.setDate2(bean.getDate2());
			//run
			beans=adspClientInfoDao.findAdspClientInfoBeanIsPage(dto);
		} catch (Exception e) {
			log.error("客户端信息筛选显示,数据库处理出错!", e);
		}
		return beans;
	}
	/**
	 * 列表展示客户端信息
	 * 
	 * @param bean
	 * @return
	 */
	public List<AdspClientInfoBean> findAdspClientInfoBeanList(
			AdspClientInfoBean bean) {
		List<AdspClientInfoBean> beans = null;
		try {
			AdspClientInfo dto=new AdspClientInfo();
			/* ID */
			dto.setId(bean.getId());
			/* version */
			dto.setVersion(bean.getVersion());
			/* 客户端IP */
			dto.setClient_ip(bean.getClient_ip());
			/* 客户端编号 */
			dto.setClient_code(bean.getClient_code());
			/* 客户端名称 */
			dto.setClient_name(bean.getClient_name());
			/* 备注 */
			dto.setNote(bean.getNote());
			/* 删除标记 */
			dto.setDel_flag(bean.getDel_flag());
			/* 数据输入日期 */
			dto.setDate_created(bean.getDate_created());
			/* 建立者ID */
			dto.setCreate_id(bean.getCreate_id());
			/* 建立者IP */
			dto.setCreate_ip(bean.getCreate_ip());
			/* 资料更新日期 */
			dto.setLast_updated(bean.getLast_updated());
			/* 修改者ID */
			dto.setUpdate_id(bean.getUpdate_id());
			/* 修改者IP */
			dto.setUpdate_ip(bean.getUpdate_ip());
			//时间1
			dto.setDate1(bean.getDate1());
			//时间2
			dto.setDate2(bean.getDate2());
			//run
			beans=adspClientInfoDao.findAdspClientInfoBeanList(dto);
		} catch (Exception e) {
			log.error("客户端信息筛选显示,数据库处理出错!", e);
		}
		return beans;
	}
	/**
	 * 客户端信息 详情
	 * 
	 * @param bean
	 * @return
	 */
	public AdspClientInfoBean findAdspClientInfoBeanById(AdspClientInfoBean bean) {
		AdspClientInfoBean bean1 = null;
		if(bean!=null){
			try {
				AdspClientInfo dto=new AdspClientInfo();
				/* ID */
				dto.setId(bean.getId());
				//run
				bean1=adspClientInfoDao.findAdspClientInfoBeanById(dto);
			} catch (Exception e) {
				log.error("客户端信息 详情 获取数据库异常!", e);
			}
		}
		return bean1;
	}

	/**
	 * 客户端信息表DAO 接口类取得
	 * @return 客户端信息表DAO 接口类
	 */
	public IAdspClientInfoDao getAdspClientInfoDao() {
	    return adspClientInfoDao;
	}

	/**
	 * 客户端信息表DAO 接口类设定
	 * @param adspClientInfoDao 客户端信息表DAO 接口类
	 */
	public void setAdspClientInfoDao(IAdspClientInfoDao adspClientInfoDao) {
	    this.adspClientInfoDao = adspClientInfoDao;
	}
	/**
	 * 客户端权限配置信息 manager 业务处理类取得
	 * @return 客户端权限配置信息 manager 业务处理类
	 */
	public IClientAuthorityInfoManager getClientAuthorityInfoManager() {
	    return clientAuthorityInfoManager;
	}

	/**
	 * 客户端权限配置信息 manager 业务处理类设定
	 * @param clientAuthorityInfoManager 客户端权限配置信息 manager 业务处理类
	 */
	public void setClientAuthorityInfoManager(IClientAuthorityInfoManager clientAuthorityInfoManager) {
	    this.clientAuthorityInfoManager = clientAuthorityInfoManager;
	}
}
