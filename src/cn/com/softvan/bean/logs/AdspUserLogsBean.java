/*
 *  管理员操作日志表 bean类
 *
 * VERSION  		DATE       			 BY              REASON
 * -------- ----------- --------------- ------------------------------------------
 * 1.00     	    2013.02.22  	 	wuxiaogang       程序・发布                 
 * -------- ----------- --------------- ------------------------------------------
 * Copyright 2013 adsp System. - All Rights Reserved.
 *
 */
package cn.com.softvan.bean.logs;

import cn.com.softvan.bean.BaseBean;
import cn.com.softvan.web.tag.PageInfo;

/**
 * 管理员操作日志表 bean类
 * 
 * @author wuxiaogang
 * 
 */
public class AdspUserLogsBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1291403373107854531L;

	public AdspUserLogsBean() {

	}

	/** id */
	private String id;
	/** 用户ID */
	private String user_id;
	/** 类型 */
	private String type;
	/** 描述 */
	private String note;
	/** 数据输入日期 */
	private String date_created;
	/** 建立者ID */
	private String create_id;
	/** 建立者IP */
	private String create_ip;
	/** 分页对象 */
	private PageInfo pageinfo;
	/**时间1*/
	private String date1;
	/**时间2*/
	private String date2;
	/**
	 * id取得
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * id设定
	 * @param id id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 用户ID取得
	 * @return 用户ID
	 */
	public String getUser_id() {
		return user_id;
	}

	/**
	 * 用户ID设定
	 * @param user_id 用户ID
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	/**
	 * 类型取得
	 * @return 类型
	 */
	public String getType() {
		return type;
	}

	/**
	 * 类型设定
	 * @param type 类型
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 描述取得
	 * @return 描述
	 */
	public String getNote() {
		return note;
	}

	/**
	 * 描述设定
	 * @param note 描述
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * 数据输入日期取得
	 * @return 数据输入日期
	 */
	public String getDate_created() {
		return date_created;
	}

	/**
	 * 数据输入日期设定
	 * @param date_created 数据输入日期
	 */
	public void setDate_created(String date_created) {
		this.date_created = date_created;
	}

	/**
	 * 建立者ID取得
	 * @return 建立者ID
	 */
	public String getCreate_id() {
		return create_id;
	}

	/**
	 * 建立者ID设定
	 * @param create_id 建立者ID
	 */
	public void setCreate_id(String create_id) {
		this.create_id = create_id;
	}

	/**
	 * 建立者IP取得
	 * @return 建立者IP
	 */
	public String getCreate_ip() {
		return create_ip;
	}

	/**
	 * 建立者IP设定
	 * @param create_ip 建立者IP
	 */
	public void setCreate_ip(String create_ip) {
		this.create_ip = create_ip;
	}

	/**
	 * 分页对象取得
	 * @return 分页对象
	 */
	public PageInfo getPageinfo() {
		return pageinfo;
	}

	/**
	 * 分页对象设定
	 * @param pageinfo 分页对象
	 */
	public void setPageinfo(PageInfo pageinfo) {
		this.pageinfo = pageinfo;
	}

	/**
	 * 时间1取得
	 * @return 时间1
	 */
	public String getDate1() {
	    return date1;
	}

	/**
	 * 时间1设定
	 * @param date1 时间1
	 */
	public void setDate1(String date1) {
	    this.date1 = date1;
	}

	/**
	 * 时间2取得
	 * @return 时间2
	 */
	public String getDate2() {
	    return date2;
	}

	/**
	 * 时间2设定
	 * @param date2 时间2
	 */
	public void setDate2(String date2) {
	    this.date2 = date2;
	}
}
