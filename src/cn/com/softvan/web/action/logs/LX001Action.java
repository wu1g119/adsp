/*
 * 系统日志初始化界面 ActionClass
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

import cn.com.softvan.web.action.BaseAction;
/**
 * 系统日志初始化界面  ActionClass
 * @author {wuxiaogang}
 *
 */
public class LX001Action  extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7079166727262506587L;
	private static final transient Logger log = Logger
			.getLogger(LX001Action.class);

	/** 默认的构造函数 */
	public LX001Action() {
		log.info("LX001Action constructed");
	}
	/**
	 * <p>初始化处理。</p>
	 * <ol>[功能概要] 
	 * <div>初始化处理。</div>
	 * </ol>
	 * 
	 * @return 转发字符串
	 */
	public String init() throws Exception {
		log.info("LX001Action init");
		
		return "init";
	}
}
