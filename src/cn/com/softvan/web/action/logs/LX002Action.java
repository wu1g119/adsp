/*
 * 接口监控日志 ActionClass
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
import cn.com.softvan.common.CommonConstant;
import cn.com.softvan.common.Validator;
import cn.com.softvan.service.IServiceLogsManager;
import cn.com.softvan.web.action.BaseAction;
import cn.com.softvan.web.tag.PageInfo;
/**
 * 接口监控日志 ActionClass
 * @author {wuxiaogang}
 *
 */
public class LX002Action  extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7079166727262506587L;
	private static final transient Logger log = Logger
			.getLogger(LX002Action.class);

	/** 默认的构造函数 */
	public LX002Action() {
		log.info("LX002Action constructed");
	}
	/**ID*/
	private String id;
	/**接口监控日志 bean*/
	private AdspServiceLogsBean bean;
	/**
	 * <p>初始化处理。</p>
	 * <ol>[功能概要] 
	 * <div>初始化处理。</div>
	 * </ol>
	 * @return 转发字符串
	 */
	public String init() throws Exception {
		log.info("LX002Action init");
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
		log.info("LX002Action list1");
		if(bean==null){
			bean=new AdspServiceLogsBean();
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
		request.setAttribute("beans", serviceLogsManager.findAdspServiceLogsbeanIsPage(bean));
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
	 * 接口监控日志 bean取得
	 * @return 接口监控日志 bean
	 */
	public AdspServiceLogsBean getBean() {
	    return bean;
	}
	/**
	 * 接口监控日志 bean设定
	 * @param bean 接口监控日志 bean
	 */
	public void setBean(AdspServiceLogsBean bean) {
	    this.bean = bean;
	}
}
