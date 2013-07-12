/*
 *  子服务配置信息表 BEAN CLASS
 *
 * VERSION  		DATE       			 BY              REASON
 * -------- ----------- --------------- ------------------------------------------
 * 1.00     	    2013.03.13  	 	wuxiaogang       程序・发布                 
 * -------- ----------- --------------- ------------------------------------------
 * Copyright 2013 adsp System. - All Rights Reserved.
 *
 */
package cn.com.softvan.bean.config;

import cn.com.softvan.bean.BaseBean;
import cn.com.softvan.web.tag.PageInfo;

/**
 * 子服务配置信息表
 * 
 * @author wuxiaogang
 */
public class AdspServiceSubInfoBean extends BaseBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7307455838941674478L;
	/** ID */
	private String id;
	/** version */
	private String version;
	/** 主服务 */
	private String config_id;
	/** 主服务 */
	private String config_name;
	/** 下级服务 */
	private String sub_config_id;
	/** 下级服务 */
	private String sub_config_name;
	/** 节点名称 */
	private String node_name;
	/** 删除标记 */
	private String del_flag;
	/** 备注 */
	private String note;
	/** 数据输入日期 */
	private String date_created;
	/** 建立者ID */
	private String create_id;
	/** 建立者IP */
	private String create_ip;
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
	 * 主服务取得
	 * @return 主服务
	 */
	public String getConfig_id() {
	    return config_id;
	}
	/**
	 * 主服务设定
	 * @param config_id 主服务
	 */
	public void setConfig_id(String config_id) {
	    this.config_id = config_id;
	}
	/**
	 * 主服务取得
	 * @return 主服务
	 */
	public String getConfig_name() {
	    return config_name;
	}
	/**
	 * 主服务设定
	 * @param config_name 主服务
	 */
	public void setConfig_name(String config_name) {
	    this.config_name = config_name;
	}
	/**
	 * 下级服务取得
	 * @return 下级服务
	 */
	public String getSub_config_id() {
	    return sub_config_id;
	}
	/**
	 * 下级服务设定
	 * @param sub_config_id 下级服务
	 */
	public void setSub_config_id(String sub_config_id) {
	    this.sub_config_id = sub_config_id;
	}
	/**
	 * 下级服务取得
	 * @return 下级服务
	 */
	public String getSub_config_name() {
	    return sub_config_name;
	}
	/**
	 * 下级服务设定
	 * @param sub_config_name 下级服务
	 */
	public void setSub_config_name(String sub_config_name) {
	    this.sub_config_name = sub_config_name;
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
