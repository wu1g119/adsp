/*
 * 客户端权限设置 (信息编辑页面)ActionClass
 *
 * VERSION  DATE        BY              REASON
 * -------- ----------- --------------- ------------------------------------------
 * 1.00     2013.05.29  wuxiaogang           程序・发布
 * -------- ----------- --------------- ------------------------------------------
 * Copyright 2013 adsp System. - All Rights Reserved.
 *
 */
package cn.com.softvan.web.action.auth;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import cn.com.softvan.bean.client.AdspClientAuthorityInfoBean;
import cn.com.softvan.bean.client.AdspClientInfoBean;
import cn.com.softvan.bean.user.AdspUserInfoBean;
import cn.com.softvan.dao.entity.AdspServiceConfigInfo;
import cn.com.softvan.service.IClientAuthorityInfoManager;
import cn.com.softvan.service.IClientInfoManager;
import cn.com.softvan.service.IServiceConfigManager;
import cn.com.softvan.web.action.BaseAction;
/**
 * 客户端权限设置 (信息编辑页面)
 * @author {wuxiaogang}
 *
 */
public class AX002Action  extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4932264876200541720L;
	private static final transient Logger log = Logger
			.getLogger(AX002Action.class);

	/** 默认的构造函数 */
	public AX002Action() {
		log.info("AX002Action constructed");
	}
	/** 子系统信息 manager 业务处理类  */
	private IClientInfoManager clientInfoManager;
	/** 子系统权限配置信息 manager 业务处理类 */
	private IClientAuthorityInfoManager clientAuthorityInfoManager;
	/** 服务配置业务处理类 */
	private IServiceConfigManager serviceConfigManager;
	/** 子系统列表 BEAN CLASS */
	private AdspClientInfoBean bean;
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
		log.info("AX002Action init");
		//获取客户端id
		String id=request.getParameter("id");
		if(id!=null){
			AdspClientInfoBean bean=new AdspClientInfoBean();
			bean.setId(id);
			//获取客户端详情
			request.setAttribute("bean", clientInfoManager.findAdspClientInfoBeanById(bean));
			AdspClientAuthorityInfoBean auth=new AdspClientAuthorityInfoBean();
			auth.setClient_id(id);
			//获取客户端权限列表
			request.setAttribute("auths",clientAuthorityInfoManager.findAdspClientAuthorityInfoBeanList(auth));
		}
		AdspServiceConfigInfo dto=new AdspServiceConfigInfo();
		//未删除
		dto.setDel_flag("0");
		//
		request.setAttribute("beans", serviceConfigManager.findAdspServiceConfigInfoList(dto));
		
		return "init";
	}
	/**
	 * <p>
	 * 保存客户端权限信息
	 * </p>
	 * <ol>
	 * [功能概要] <div>保存客户端权限信息。</div>
	 * </ol>
	 * 
	 * @return 转发字符串
	 */
	public String saveInfo() throws Exception {
		log.info("AX002Action saveInfo");
		AdspUserInfoBean userBean=getAdminUserInfo();

		String msg="1";
		if(bean!=null){
			/* 建立者ID */
			bean.setCreate_id(userBean.getUser_id());
			/* 建立者IP */
			bean.setCreate_ip(getIpAddr());
			/* 修改者ID */
			bean.setUpdate_id(userBean.getUser_id());
			/* 修改者IP */
			bean.setUpdate_ip(getIpAddr());
			/* 服务信息列表 */
			String[] service_ids=(request.getParameterValues("service_id"));
			if(service_ids!=null){
				List<AdspClientAuthorityInfoBean> clientAuthBeans=new ArrayList<AdspClientAuthorityInfoBean>();
				AdspClientAuthorityInfoBean bean1=null;
				for(int i=0;i<service_ids.length;i++){
					bean1=new AdspClientAuthorityInfoBean();
					bean1.setClient_id(bean.getId());//子系统id
					bean1.setService_id(service_ids[i]);//服务id
					bean1.setService_name(request.getParameter("name"+service_ids[i]));//服务名称
					bean1.setNote(request.getParameter("note"+service_ids[i]));//服务描述
					bean1.setCreate_id(userBean.getUser_id());//建立者ID
					bean1.setCreate_ip(getIpAddr());//建立者IP
					//add
					clientAuthBeans.add(bean1);
				}
				bean.setClientAuthBeans(clientAuthBeans);
			}
			//保存
			try {
				msg=clientInfoManager.saveOrUpdateClientInfo(bean);
			} catch (Exception e) {
				msg="子系统信息数据库操作异常!";
				log.error("子系统信息数据库操作异常:", e);
			}
		}else{
			msg="保存失败!信息不完整!";
		}
		getWriter().print(msg);
		return null;
	}
	/**
	 * 子系统信息 manager 业务处理类取得
	 * @return 子系统信息 manager 业务处理类
	 */
	public IClientInfoManager getClientInfoManager() {
	    return clientInfoManager;
	}
	/**
	 * 子系统信息 manager 业务处理类设定
	 * @param clientInfoManager 子系统信息 manager 业务处理类
	 */
	public void setClientInfoManager(IClientInfoManager clientInfoManager) {
	    this.clientInfoManager = clientInfoManager;
	}
	/**
	 * 子系统权限配置信息 manager 业务处理类取得
	 * @return 子系统权限配置信息 manager 业务处理类
	 */
	public IClientAuthorityInfoManager getClientAuthorityInfoManager() {
	    return clientAuthorityInfoManager;
	}
	/**
	 * 子系统权限配置信息 manager 业务处理类设定
	 * @param clientAuthorityInfoManager 子系统权限配置信息 manager 业务处理类
	 */
	public void setClientAuthorityInfoManager(IClientAuthorityInfoManager clientAuthorityInfoManager) {
	    this.clientAuthorityInfoManager = clientAuthorityInfoManager;
	}
	/**
	 * 服务配置业务处理类取得
	 * @return 服务配置业务处理类
	 */
	public IServiceConfigManager getServiceConfigManager() {
	    return serviceConfigManager;
	}
	/**
	 * 服务配置业务处理类设定
	 * @param serviceConfigManager 服务配置业务处理类
	 */
	public void setServiceConfigManager(IServiceConfigManager serviceConfigManager) {
	    this.serviceConfigManager = serviceConfigManager;
	}
	/**
	 * 子系统列表 BEAN CLASS取得
	 * @return 子系统列表 BEAN CLASS
	 */
	public AdspClientInfoBean getBean() {
	    return bean;
	}
	/**
	 * 子系统列表 BEAN CLASS设定
	 * @param bean 子系统列表 BEAN CLASS
	 */
	public void setBean(AdspClientInfoBean bean) {
	    this.bean = bean;
	}
}
