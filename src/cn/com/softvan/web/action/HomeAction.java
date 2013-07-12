/*
 * home
 *
 * VERSION  DATE        BY              REASON
 * -------- ----------- --------------- ------------------------------------------
 * 1.00     2013.02.22  wuxiaogang           程序・发布
 * -------- ----------- --------------- ------------------------------------------
 * Copyright 2013 adsp System. - All Rights Reserved.
 *
 */
package cn.com.softvan.web.action;

import org.apache.log4j.Logger;

import cn.com.softvan.bean.user.AdspUserInfoBean;
import cn.com.softvan.common.CommonConstant;

public class HomeAction  extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6103432072290645133L;
	private static final transient Logger log = Logger
			.getLogger(HomeAction.class);

	/** 默认的构造函数 */
	public HomeAction() {
		log.info("HomeAction constructed");
	}
	/**
	 * <p>
	 * 用户登录
	 * </p>
	 * <ol>
	 * [功能概要] <div>登陆。</div>
	 * </ol>
	 * @return 转发字符串
	 */
	public String login() throws Exception {
		log.info("HomeAction login");
			//用户名密码正确
			if("admin".equals(request.getParameter("username"))&&"admin-123".equals(request.getParameter("password"))){
				//用户信息
				AdspUserInfoBean userBean=new AdspUserInfoBean();
				//用户名
				userBean.setUser_id(request.getParameter("username"));
				request.getSession().setAttribute(CommonConstant.SESSION_KEY_USER, userBean);
				return "home";
			}else{
				request.setAttribute("msg","登陆失败!用户名或密码错误!");
			}
		return "login";
	}
	/**
	 * <p>
	 * 用户登出
	 * </p>
	 * <ol>
	 * [功能概要] <div>登出。</div>
	 * </ol>
	 * @return 转发字符串
	 */
	public String logout() throws Exception {
		log.info("HomeAction logout");
		//清空用户登录信息
		SessionUtils.clearAdminSession(request);
		return "login";
	}
}
