/*
 *  字典表
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
 * 字典表
 * 
 * @author wuxiaogang
 */
public class AdspDataDictionary implements IEntity {

	/** id */
	private String id;
	/** version */
	private String version;
	/** 名称 */
	private String name;
	/** 描述 */
	private String note;
	/** 分类key */
	private String type_key;
	/** 分类名称 */
	private String type_name;
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
	/**分页对象*/
	private PageInfo pageinfo;
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
	 * 名称取得
	 * @return 名称
	 */
	public String getName() {
	    return name;
	}
	/**
	 * 名称设定
	 * @param name 名称
	 */
	public void setName(String name) {
	    this.name = name;
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
	 * 分类key取得
	 * @return 分类key
	 */
	public String getType_key() {
	    return type_key;
	}
	/**
	 * 分类key设定
	 * @param type_key 分类key
	 */
	public void setType_key(String type_key) {
	    this.type_key = type_key;
	}
	/**
	 * 分类名称取得
	 * @return 分类名称
	 */
	public String getType_name() {
	    return type_name;
	}
	/**
	 * 分类名称设定
	 * @param type_name 分类名称
	 */
	public void setType_name(String type_name) {
	    this.type_name = type_name;
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

}
