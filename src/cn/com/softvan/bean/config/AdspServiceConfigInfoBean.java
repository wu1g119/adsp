/*
 *  服务配置信息表 BEAN CLASS
 *
 * VERSION  		DATE       			 BY              REASON
 * -------- ----------- --------------- ------------------------------------------
 * 1.00     	    2013.02.26  	 	wuxiaogang       程序・发布                 
 * -------- ----------- --------------- ------------------------------------------
 * Copyright 2013 adsp System. - All Rights Reserved.
 *
 */
package cn.com.softvan.bean.config;

import cn.com.softvan.bean.BaseBean;
import cn.com.softvan.web.tag.PageInfo;

/**
 * 服务配置信息表 BEAN CLASS
 * 
 * @author wuxiaogang
 */
public class AdspServiceConfigInfoBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1446255675325499404L;
	/** ID */
	private String id;
	/** version */
	private String version;
	/** 类型 */
	private String type;
	/** 数据库名 */
	private String db_name;
	/** 数据表名 */
	private String db_table_name;
	/** 名称 */
	private String name;
	/** 配置信息 */
	private String config;
	/** 备注 */
	private String note;
	/** 删除标记 */
	private String del_flag;
	/** 状态 */
	private String status;
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
	/** 分页对象 */
	private PageInfo pageinfo;
	/**时间1*/
	private String date1;
	/**时间2*/
	private String date2;
	/** 节点名称 */
	private String node_name;
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
	 * 数据库名取得
	 * @return 数据库名
	 */
	public String getDb_name() {
	    return db_name;
	}
	/**
	 * 数据库名设定
	 * @param db_name 数据库名
	 */
	public void setDb_name(String db_name) {
	    this.db_name = db_name;
	}
	/**
	 * 数据表名取得
	 * @return 数据表名
	 */
	public String getDb_table_name() {
	    return db_table_name;
	}
	/**
	 * 数据表名设定
	 * @param db_table_name 数据表名
	 */
	public void setDb_table_name(String db_table_name) {
	    this.db_table_name = db_table_name;
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
	 * 配置信息取得
	 * @return 配置信息
	 */
	public String getConfig() {
	    return config;
	}
	/**
	 * 配置信息设定
	 * @param config 配置信息
	 */
	public void setConfig(String config) {
	    this.config = config;
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
	 * 节点名称取得
	 * @return 节点名称
	 */
	public String getNode_name() {
	    return node_name;
	}
	/**
	 * 节点名称设定
	 * @param node_name 节点名称
	 */
	public void setNode_name(String node_name) {
	    this.node_name = node_name;
	}
}
