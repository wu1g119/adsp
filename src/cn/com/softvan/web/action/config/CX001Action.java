/*
 * 数据服务 (初始化页面显示)ActionClass
 *
 * VERSION  DATE        BY              REASON
 * -------- ----------- --------------- ------------------------------------------
 * 1.00     2013.03.08  wuxiaogang           程序・发布
 * -------- ----------- --------------- ------------------------------------------
 * Copyright 2013 adsp System. - All Rights Reserved.
 *
 */
package cn.com.softvan.web.action.config;

import java.util.List;

import org.apache.log4j.Logger;

import cn.com.softvan.bean.config.AdspServiceConfigInfoBean;
import cn.com.softvan.bean.user.AdspUserInfoBean;
import cn.com.softvan.common.CommonConstant;
import cn.com.softvan.common.Validator;
import cn.com.softvan.dao.entity.AdspServiceConfigInfo;
import cn.com.softvan.service.IServiceConfigManager;
import cn.com.softvan.web.action.BaseAction;
import cn.com.softvan.web.tag.PageInfo;
/**
 * 数据服务 (初始化页面显示)
 * @author {wuxiaogang}
 *
 */
public class CX001Action  extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4932264876200541720L;
	private static final transient Logger log = Logger
			.getLogger(CX001Action.class);

	/** 默认的构造函数 */
	public CX001Action() {
		log.info("CX001Action constructed");
	}
	/** 服务配置业务处理类 */
	private IServiceConfigManager serviceConfigManager;
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
		log.info("CX001Action init");
		return "init";
	}
	/**
	 * <p>
	 * 服务信息列表(未删除)。
	 * </p>
	 * <ol>
	 * [功能概要] <div>服务信息列表(未删除)。</div>
	 * </ol>
	 * 
	 * @return 转发字符串
	 */
	public String list1() throws Exception {
		log.info("CX001Action list1");
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
		AdspServiceConfigInfo dto = new AdspServiceConfigInfo();
		dto.setDel_flag("0");
		dto.setPageinfo(page);
		List<AdspServiceConfigInfoBean> beans=serviceConfigManager.findAdspServiceConfigInfoIsPage(dto);
		request.setAttribute("beans",beans);
		request.setAttribute(CommonConstant.PAGEROW_OBJECT_KEY,page);
		return "list1";
	}
	/**
	 * <p>
	 * 服务信息列表(已删除)。
	 * </p>
	 * <ol>
	 * [功能概要] <div>服务信息列表(已删除)。</div>
	 * </ol>
	 * 
	 * @return 转发字符串
	 */
	public String list2() throws Exception {
		log.info("CX001Action list2");
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
		AdspServiceConfigInfo dto = new AdspServiceConfigInfo();
		dto.setDel_flag("1");
		dto.setPageinfo(page);
		List<AdspServiceConfigInfoBean> beans=serviceConfigManager.findAdspServiceConfigInfoIsPage(dto);
		request.setAttribute("beans",beans);
		request.setAttribute(CommonConstant.PAGEROW_OBJECT_KEY,page);
		return "list2";
	}
	/**
	 * <p>
	 * 删除 服务信息。
	 * </p>
	 * <ol>
	 * [功能概要] <div>删除 服务信息。</div>
	 * </ol>
	 * 
	 * @return 转发字符串
	 */
	public String delInfo() throws Exception {
		log.info("CX001Action delInfo");
		//
		AdspUserInfoBean userBean=getAdminUserInfo();
		//
		AdspServiceConfigInfoBean bean=new AdspServiceConfigInfoBean();
		//id
		bean.setId(request.getParameter("id"));
		//修改用户ID
		bean.setUpdate_id(userBean.getUser_id());
		//修改用户IP
		bean.setUpdate_ip(getIpAddr());
		//删除标记
		bean.setDel_flag("1");
		//服务信息bean
		getWriter().write(serviceConfigManager.logicDeleteAdspServiceConfigInfo(bean));
		return null;
	}
	/**
	 * <p>
	 * 恢复 服务信息。
	 * </p>
	 * <ol>
	 * [功能概要] <div>恢复 服务信息。</div>
	 * </ol>
	 * 
	 * @return 转发字符串
	 */
	public String recoveryInfo() throws Exception {
		log.info("CX001Action recoveryInfo");
		//
		AdspUserInfoBean userBean=getAdminUserInfo();

		AdspServiceConfigInfoBean bean=new AdspServiceConfigInfoBean();
		//id
		bean.setId(request.getParameter("id"));
		//修改用户ID
		bean.setUpdate_id(userBean.getUser_id());
		//修改用户IP
		bean.setUpdate_ip(getIpAddr());
		//删除标记
		bean.setDel_flag("0");
		//服务信息bean
		getWriter().write(serviceConfigManager.logicDeleteAdspServiceConfigInfo(bean));
		return null;
	}
	/**
	 * <p>
	 * 服务配置 初始化处理。
	 * </p>
	 * <ol>
	 * [功能概要] <div>服务类型选择页面。</div>
	 * </ol>
	 * 
	 * @return 转发字符串
	 */
	public String config() throws Exception {
		log.info("CX001Action config");
		return "config";
	}
	/**
	 * <p>
	 * 服务配置 跳转到具体配置页面。
	 * </p>
	 * <ol>
	 * [功能概要] <div>跳转到具体配置页面。</div>
	 * </ol>
	 * 
	 * @return 转发字符串
	 */
	public String forward() throws Exception {
		log.info("CX001Action forward");
		//服务类型
		String sType=request.getParameter("s_type");
		if("Q".equalsIgnoreCase(sType)){
			return "Q";
		}else 
		if("U".equalsIgnoreCase(sType)){
			return "U";
		}else 
		if("I".equalsIgnoreCase(sType)){
			return "I";
		} else 
		if("D".equalsIgnoreCase(sType)){
			return "D";
		}
		//输出错误信息
		getWriter().print("请选择正确的服务类型!");
		return null;
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
}
