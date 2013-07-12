/*
 *  接口监控日志表
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
 * 接口监控日志表
 * 
 * @author wuxiaogang
 */
public class AdspServiceLogs implements IEntity {

	/** 日志ID */
	private String id;
	/** version */
	private String version;
	/** 调用系统 */
	private String system;
	/** 接口名称 */
	private String port_name;
	/** 服务名称 */
	private String service_name;
	/** 调用参数 */
	private String service_argument;
	/** 处理时间 */
	private Long process_time;
	/** 异常信息 */
	private String error_msg;
	/** 接口语言 */
	private String language;
	/** 删除标记 */
	private String del_flag;
	/** 数据输入日期 */
	private String date_created;
	/** 建立者ID */
	private String create_id;
	/** 建立者IP */
	private String create_ip;
	/**分页对象**/
	private PageInfo pageinfo;
	/**时间1*/
	private String date1;
	/**时间2*/
	private String date2;
	/**sql信息*/
	private String sql_info;
	/**
	 * 日志ID取得
	 * @return 日志ID
	 */
	public String getId() {
	    return id;
	}
	/**
	 * 日志ID设定
	 * @param id 日志ID
	 */
	public void setId(String id) {
	    this.id = id;
	}
	/**
	 * version取得
	 * @return version
	 */
	public String getVersion() {
	    return version;
	}
	/**
	 * version设定
	 * @param version version
	 */
	public void setVersion(String version) {
	    this.version = version;
	}
	/**
	 * 调用系统取得
	 * @return 调用系统
	 */
	public String getSystem() {
	    return system;
	}
	/**
	 * 调用系统设定
	 * @param system 调用系统
	 */
	public void setSystem(String system) {
	    this.system = system;
	}
	/**
	 * 接口名称取得
	 * @return 接口名称
	 */
	public String getPort_name() {
	    return port_name;
	}
	/**
	 * 接口名称设定
	 * @param port_name 接口名称
	 */
	public void setPort_name(String port_name) {
	    this.port_name = port_name;
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
	 * 调用参数取得
	 * @return 调用参数
	 */
	public String getService_argument() {
	    return service_argument;
	}
	/**
	 * 调用参数设定
	 * @param service_argument 调用参数
	 */
	public void setService_argument(String service_argument) {
	    this.service_argument = service_argument;
	}
	/**
	 * 处理时间取得
	 * @return 处理时间
	 */
	public Long getProcess_time() {
	    return process_time;
	}
	/**
	 * 处理时间设定
	 * @param process_time 处理时间
	 */
	public void setProcess_time(Long process_time) {
	    this.process_time = process_time;
	}
	/**
	 * 异常信息取得
	 * @return 异常信息
	 */
	public String getError_msg() {
	    return error_msg;
	}
	/**
	 * 异常信息设定
	 * @param error_msg 异常信息
	 */
	public void setError_msg(String error_msg) {
	    this.error_msg = error_msg;
	}
	/**
	 * 接口语言取得
	 * @return 接口语言
	 */
	public String getLanguage() {
	    return language;
	}
	/**
	 * 接口语言设定
	 * @param language 接口语言
	 */
	public void setLanguage(String language) {
	    this.language = language;
	}
	/**
	 * 删除标记取得
	 * @return 删除标记
	 */
	public String getDel_flag() {
	    return del_flag;
	}
	/**
	 * 删除标记设定
	 * @param del_flag 删除标记
	 */
	public void setDel_flag(String del_flag) {
	    this.del_flag = del_flag;
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
	 * 分页对象*取得
	 * @return 分页对象*
	 */
	public PageInfo getPageinfo() {
	    return pageinfo;
	}
	/**
	 * 分页对象*设定
	 * @param pageinfo 分页对象*
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
	/**
	 * sql信息取得
	 * @return sql信息
	 */
	public String getSql_info() {
	    return sql_info;
	}
	/**
	 * sql信息设定
	 * @param sql_info sql信息
	 */
	public void setSql_info(String sql_info) {
	    this.sql_info = sql_info;
	}

}
