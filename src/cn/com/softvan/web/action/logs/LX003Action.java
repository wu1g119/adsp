/*
 * 管理员操作日志 ActionClass
 *
 * VERSION  DATE        BY              REASON
 * -------- ----------- --------------- ------------------------------------------
 * 1.00     2013.03.08  wuxiaogang           程序・发布
 * -------- ----------- --------------- ------------------------------------------
 * Copyright 2013 adsp System. - All Rights Reserved.
 *
 */
package cn.com.softvan.web.action.logs;

import org.apache.log4j.Logger;

import cn.com.softvan.bean.logs.AdspServiceLogsBean;
import cn.com.softvan.bean.logs.AdspUserLogsBean;
import cn.com.softvan.common.CommonConstant;
import cn.com.softvan.common.Validator;
import cn.com.softvan.service.IUserLogsManager;
import cn.com.softvan.web.action.BaseAction;
import cn.com.softvan.web.tag.PageInfo;
/**
 * 管理员操作日志 ActionClass
 * @author {wuxiaogang}
 *
 */
public class LX003Action  extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7079166727262506587L;
	private static final transient Logger log = Logger
			.getLogger(LX003Action.class);

	/** 默认的构造函数 */
	public LX003Action() {
		log.info("LX003Action constructed");
	}

	/**ID*/
	private String id;
	/**管理员操作日志 bean class*/
	private AdspUserLogsBean bean;
	/**
	 * <p>初始化处理。</p>
	 * <ol>[功能概要] 
	 * <div>初始化处理。</div>
	 * </ol>
	 * 
	 * @return 转发字符串
	 */
	public String init() throws Exception {
		log.info("LX003Action init");
		
		return "init";
	}
	/**
	 * <p>加载信息列表。</p>
	 * <ol>[功能概要] 
	 * <div>加载信息列表。</div>
	 * </ol>
	 * @return 转发字符串
	 */
	public String list1() throws Exception {
		log.info("LX003Action list1");
		if(bean==null){
			bean=new AdspUserLogsBean();
		}
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
		//
		bean.setPageinfo(page);
		//信息
		request.setAttribute("beans", userLogsManager.findAdspUserLogsbeanIsPage(bean));
		//分页对象
		request.setAttribute(CommonConstant.PAGEROW_OBJECT_KEY,page);
		return "list1";
	}
	/**
	 * ID取得
	 * @return ID
	 */
	public String getId() {
	    return id;
	}
	/**
	 * ID设定
	 * @param id ID
	 */
	public void setId(String id) {
	    this.id = id;
	}
	/**
	 * 管理员操作日志 bean class取得
	 * @return 管理员操作日志 bean class
	 */
	public AdspUserLogsBean getBean() {
	    return bean;
	}
	/**
	 * 管理员操作日志 bean class设定
	 * @param bean 管理员操作日志 bean class
	 */
	public void setBean(AdspUserLogsBean bean) {
	    this.bean = bean;
	}
}
