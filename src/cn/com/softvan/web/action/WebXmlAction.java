/*
 * 服务接口
 *
 * VERSION  DATE        BY              REASON
 * -------- ----------- --------------- ------------------------------------------
 * 1.00     2013.03.14  wuxiaogang           程序・发布
 * -------- ----------- --------------- ------------------------------------------
 * Copyright 2013 adsp System. - All Rights Reserved.
 *
 */
package cn.com.softvan.web.action;

import org.apache.log4j.Logger;

import cn.com.softvan.service.IWebServiceManager;

public class WebXmlAction  extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6103432072290645133L;
	private static final transient Logger log = Logger
			.getLogger(WebXmlAction.class);

	/** 默认的构造函数 */
	public WebXmlAction() throws Exception {
		log.info("WebXmlAction constructed");
	}
	/** WebService 业务处理类 */
	private IWebServiceManager webServiceManager;
	/**
	 * <div>
	 * 	<li>获取信息</li>
	 * </div>
	 * @param info
	 * @return info
	 * @throws Exception 
	 */
	public String getInfo() throws Exception {
		// TODO Auto-generated method stub
		 getWriter().print(webServiceManager.getInfo(request.getParameter("info"),getIpAddr()));
		 return null;
	}
	/**
	 * <div>
	 * 	<li>修改信息</li>
	 * </div>
	 * @param info
	 * @return info
	 */
	public String modifyInfo() throws Exception {
		// TODO Auto-generated method stub
		getWriter().print(webServiceManager.modifyInfo(request.getParameter("info"),getIpAddr()));
		return null;
	}
	/**
	 * <div>
	 * 	<li>保存信息</li>
	 * </div>
	 * @param info
	 * @return info
	 */
	public String saveInfo() throws Exception {
		// TODO Auto-generated method stub
		getWriter().print(webServiceManager.saveInfo(request.getParameter("info"),getIpAddr()));
		return null;
	}
	/**
	 * <div>
	 * 	<li>合并信息</li>
	 * </div>
	 * @param info
	 * @return info
	 */
	public String mergerInfo() throws Exception {
		// TODO Auto-generated method stub
		getWriter().print(webServiceManager.mergerInfo(request.getParameter("info"),getIpAddr()));
		return null;
	}
	/**
	 * <div>
	 * 	<li>删除信息</li>
	 * </div>
	 * @param info
	 * @return info
	 */
	public String delInfo() throws Exception {
		// TODO Auto-generated method stub
		getWriter().print(webServiceManager.delInfo(request.getParameter("info"),getIpAddr()));
		return null;
	}
	/**
	 * WebService 业务处理类取得
	 * @return WebService 业务处理类
	 */
	public IWebServiceManager getWebServiceManager(){
	    return webServiceManager;
	}
	/**
	 * WebService 业务处理类设定
	 * @param webServiceManager WebService 业务处理类
	 */
	public void setWebServiceManager(IWebServiceManager webServiceManager){
	    this.webServiceManager = webServiceManager;
	}
}
