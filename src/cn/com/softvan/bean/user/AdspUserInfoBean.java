/*
 * 用户信息 BEAN CLASS
 *
 * VERSION  DATE          BY              REASON
 * -------- ------------- --------------- ------------------------------------------
 * 1.00     2013.01.06    wuxiaogang           程序・发布
 * -------- ------------- --------------- ------------------------------------------
 * Copyright 2013 adsp System. - All Rights Reserved.
 *
 */
package cn.com.softvan.bean.user;

import cn.com.softvan.bean.BaseBean;

public class AdspUserInfoBean extends BaseBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5005753904648618417L;
	/**id*/
	private String id;
	/** 用户ID */
	private String user_id;
	/**密码*/
	private String pwd;
	/** 真实名称 */
	private String real_name;
	/** 是否可用 */
	private int is_enabled;
	/** 备注 */
	private String note;
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
	/**是否删除 0:未删除 1:已删除*/
	private String del_flag;
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
	 * 真实名称取得
	 * @return 真实名称
	 */
	public String getReal_name() {
	    return real_name;
	}
	/**
	 * 真实名称设定
	 * @param real_name 真实名称
	 */
	public void setReal_name(String real_name) {
	    this.real_name = real_name;
	}
	/**
	 * 是否可用取得
	 * @return 是否可用
	 */
	public int getIs_enabled() {
	    return is_enabled;
	}
	/**
	 * 是否可用设定
	 * @param is_enabled 是否可用
	 */
	public void setIs_enabled(int is_enabled) {
	    this.is_enabled = is_enabled;
	}
	/**
	 * 备注取得
	 * @return 备注
	 */
	public String getNote() {
	    return note;
	}
	/**
	 * 备注设定
	 * @param note 备注
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
	 * 是否删除 0:未删除 1:已删除取得
	 * @return 是否删除 0:未删除 1:已删除
	 */
	public String getDel_flag() {
	    return del_flag;
	}
	/**
	 * 是否删除 0:未删除 1:已删除设定
	 * @param del_flag 是否删除 0:未删除 1:已删除
	 */
	public void setDel_flag(String del_flag) {
	    this.del_flag = del_flag;
	}
}
