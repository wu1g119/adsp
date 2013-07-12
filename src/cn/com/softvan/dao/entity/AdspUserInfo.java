/*
 *  系统用户表
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
 * 系统用户表
 * 
 * @author wuxiaogang
 */
public class AdspUserInfo implements IEntity {

	/** ID */
	private String id;
	/** version */
	private String version;
	/** 昵称 */
	private String nickname;
	/** 用户名 */
	private String username;
	/** 密码 */
	private String pwd;
	/** 状态 */
	private String status;
	/** 最后登录时间 */
	private String last_login_time;
	/** 最后登录IP */
	private String last_login_ip;
	/** 删除标记 */
	private String del_flag;
	/** 数据输入日期 */
	private String date_created;
	/** 建立者ID */
	private String create_id;
	/** 建立者IP */
	private String create_ip;
	/** 资料更新日期 */
	private String last_updated;
	/** 修改者ID */
	private String update_id;
	/** 修改者IP */
	private String update_ip;
	/**分页对象**/
	private PageInfo pageinfo;
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
	 * 昵称取得
	 * @return 昵称
	 */
	public String getNickname() {
	    return nickname;
	}
	/**
	 * 昵称设定
	 * @param nickname 昵称
	 */
	public void setNickname(String nickname) {
	    this.nickname = nickname;
	}
	/**
	 * 用户名取得
	 * @return 用户名
	 */
	public String getUsername() {
	    return username;
	}
	/**
	 * 用户名设定
	 * @param username 用户名
	 */
	public void setUsername(String username) {
	    this.username = username;
	}
	/**
	 * 密码取得
	 * @return 密码
	 */
	public String getPwd() {
	    return pwd;
	}
	/**
	 * 密码设定
	 * @param pwd 密码
	 */
	public void setPwd(String pwd) {
	    this.pwd = pwd;
	}
	/**
	 * 状态取得
	 * @return 状态
	 */
	public String getStatus() {
	    return status;
	}
	/**
	 * 状态设定
	 * @param status 状态
	 */
	public void setStatus(String status) {
	    this.status = status;
	}
	/**
	 * 最后登录时间取得
	 * @return 最后登录时间
	 */
	public String getLast_login_time() {
	    return last_login_time;
	}
	/**
	 * 最后登录时间设定
	 * @param last_login_time 最后登录时间
	 */
	public void setLast_login_time(String last_login_time) {
	    this.last_login_time = last_login_time;
	}
	/**
	 * 最后登录IP取得
	 * @return 最后登录IP
	 */
	public String getLast_login_ip() {
	    return last_login_ip;
	}
	/**
	 * 最后登录IP设定
	 * @param last_login_ip 最后登录IP
	 */
	public void setLast_login_ip(String last_login_ip) {
	    this.last_login_ip = last_login_ip;
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
	 * 资料更新日期取得
	 * @return 资料更新日期
	 */
	public String getLast_updated() {
	    return last_updated;
	}
	/**
	 * 资料更新日期设定
	 * @param last_updated 资料更新日期
	 */
	public void setLast_updated(String last_updated) {
	    this.last_updated = last_updated;
	}
	/**
	 * 修改者ID取得
	 * @return 修改者ID
	 */
	public String getUpdate_id() {
	    return update_id;
	}
	/**
	 * 修改者ID设定
	 * @param update_id 修改者ID
	 */
	public void setUpdate_id(String update_id) {
	    this.update_id = update_id;
	}
	/**
	 * 修改者IP取得
	 * @return 修改者IP
	 */
	public String getUpdate_ip() {
	    return update_ip;
	}
	/**
	 * 修改者IP设定
	 * @param update_ip 修改者IP
	 */
	public void setUpdate_ip(String update_ip) {
	    this.update_ip = update_ip;
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

}
