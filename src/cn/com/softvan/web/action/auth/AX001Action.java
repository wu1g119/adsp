/*
 * 客户端权限设置 (信息显示页面)ActionClass
 *
 * VERSION  DATE        BY              REASON
 * -------- ----------- --------------- ------------------------------------------
 * 1.00     2013.05.29  wuxiaogang           程序・发布
 * -------- ----------- --------------- ------------------------------------------
 * Copyright 2013 adsp System. - All Rights Reserved.
 *
 */
package cn.com.softvan.web.action.auth;

import java.util.List;

import org.apache.log4j.Logger;

import cn.com.softvan.bean.client.AdspClientAuthorityInfoBean;
import cn.com.softvan.bean.client.AdspClientInfoBean;
import cn.com.softvan.common.CommonConstant;
import cn.com.softvan.common.Validator;
import cn.com.softvan.dao.entity.AdspServiceConfigInfo;
import cn.com.softvan.service.IClientAuthorityInfoManager;
import cn.com.softvan.service.IClientInfoManager;
import cn.com.softvan.web.action.BaseAction;
import cn.com.softvan.web.tag.PageInfo;
/**
 * 客户端权限设置 (信息显示页面)
 * @author {wuxiaogang}
 *
 */
public class AX001Action  extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4932264876200541720L;
	private static final transient Logger log = Logger
			.getLogger(AX001Action.class);

	/** 默认的构造函数 */
	public AX001Action() {
		log.info("AX001Action constructed");
	}
	/** 子系统信息 manager 业务处理类  */
	private IClientInfoManager clientInfoManager;
	/** 子系统权限配置信息 manager 业务处理类 */
	private IClientAuthorityInfoManager clientAuthorityInfoManager;
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
		log.info("AX001Action init");
		return "init";
	}
	/**
	 * <p>
	 * 客户端信息列表(未删除)。
	 * </p>
	 * <ol>
	 * [功能概要] <div>客户端信息列表(未删除)。</div>
	 * </ol>
	 * 
	 * @return 转发字符串
	 */
	public String list1() throws Exception {
		log.info("AX001Action list1");
		int offset = 0;
		// 分页偏移量
		if (!Validator.isNullEmpty(request.getParameter("offset"))
				&& Validator.isNum(request.getParameter("offset"))) {
			offset = Integer.parseInt(request.getParameter("offset"));
		}
		PageInfo page = new PageInfo(); 
		//当前页
		page.setCurrOffset(offset);
		//每页显示条数
		page.setPageRowCount(15);
		AdspClientInfoBean bean = new AdspClientInfoBean();
		bean.setDel_flag("0");
		bean.setPageinfo(page);
		List<AdspClientInfoBean> beans=clientInfoManager.findAdspClientInfoBeanIsPage(bean);
		request.setAttribute("beans",beans);
		request.setAttribute(CommonConstant.PAGEROW_OBJECT_KEY,page);
		return "list1";
	}
	/**
	 * <p>
	 * 客户端信息列表(已删除)。
	 * </p>
	 * <ol>
	 * [功能概要] <div>客户端信息列表(已删除)。</div>
	 * </ol>
	 * 
	 * @return 转发字符串
	 */
	public String list2() throws Exception {
		log.info("AX001Action list2");
		int offset = 0;
		// 分页偏移量
		if (!Validator.isNullEmpty(request.getParameter("offset"))
				&& Validator.isNum(request.getParameter("offset"))) {
			offset = Integer.parseInt(request.getParameter("offset"));
		}
		PageInfo page = new PageInfo(); 
		//当前页
		page.setCurrOffset(offset);
		//每页显示条数
		page.setPageRowCount(15);
		AdspClientInfoBean bean = new AdspClientInfoBean();
		bean.setDel_flag("1");
		bean.setPageinfo(page);
		List<AdspClientInfoBean> beans=clientInfoManager.findAdspClientInfoBeanIsPage(bean);
		request.setAttribute("beans",beans);
		request.setAttribute(CommonConstant.PAGEROW_OBJECT_KEY,page);
		return "list2";
	}
	/**
	 * <p>
	 * 客户端权限详情。
	 * </p>
	 * <ol>
	 * [功能概要] <div>客户端权限详情。</div>
	 * </ol>
	 * 
	 * @return 转发字符串
	 */
	public String detail() throws Exception {
		log.info("AX001Action detail");
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
		return "detail";
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
}
