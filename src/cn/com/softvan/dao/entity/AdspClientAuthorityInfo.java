/*
 *  子系统权限配置表
 *
 * VERSION  		DATE       			 BY              REASON
 * -------- ----------- --------------- ------------------------------------------
 * 1.00     	    2013.02.22  	 	wuxiaogang       程序・发布                 
 * -------- ----------- --------------- ------------------------------------------
 * Copyright 2013 adsp System. - All Rights Reserved.
 *
 */
package cn.com.softvan.dao.entity;

import cn.com.softvan.web.tag.PageInfo;

/**
 * 子系统权限配置表
 * 
 * @author wuxiaogang
 */
public class AdspClientAuthorityInfo implements IEntity {

	/** ID */
	private String id;
	/** 子系统id */
	private String client_id;
	/** 服务ID */
	private String service_id;
	/** 服务名称 */
	private String service_name;
	/** 服务描述 */
	private String note;
	/** 数据输入日期 */
	private String date_created;
	/** 建立者ID */
	private String create_id;
	/** 建立者IP */
	private String create_ip;
	/**分页对象*/
	private PageInfo pageinfo;
	/**时间1*/
	private String date1;
	/**时间2*/
	private String date2;
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
	 * 子系统id取得
	 * @return 子系统id
	 */
	public String getClient_id() {
	    return client_id;
	}
	/**
	 * 子系统id设定
	 * @param client_id 子系统id
	 */
	public void setClient_id(String client_id) {
	    this.client_id = client_id;
	}
	/**
	 * 服务ID取得
	 * @return 服务ID
	 */
	public String getService_id() {
	    return service_id;
	}
	/**
	 * 服务ID设定
	 * @param service_id 服务ID
	 */
	public void setService_id(String service_id) {
	    this.service_id = service_id;
	}
	/**
	 * 服务名称取得
	 * @return 服务名称
	 */
	public String getService_name() {
	    return service_name;
	}
	/**
	 * 服务名称设定
	 * @param service_name 服务名称
	 */
	public void setService_name(String service_name) {
	    this.service_name = service_name;
	}
	/**
	 * 服务描述取得
	 * @return 服务描述
	 */
	public String getNote() {
	    return note;
	}
	/**
	 * 服务描述设定
	 * @param note 服务描述
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
