/*
 * 配置文件信息(json转换bean使用) BEAN CLASS
 *
 * VERSION  DATE          BY              REASON
 * -------- ------------- --------------- ------------------------------------------
 * 1.00     2013.03.06    wuxiaogang           程序・发布
 * -------- ------------- --------------- ------------------------------------------
 * Copyright 2013 adsp System. - All Rights Reserved.
 *
 */
package cn.com.softvan.bean.config;

import cn.com.softvan.bean.BaseBean;

/**
 * 配置文件信息(json转换bean使用) BEAN CLASS
 * 
 * @author {wuxiaogang}
 * 
 */
public class ToInfoBean extends BaseBean {
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1890658163437696749L;

	/** 默认构造器 */
	public ToInfoBean() {
	}

	/** 名称 */
	private String name;
	/** 类型 */
	private String type;
	/** 别名 */
	private String alias;
	/** 连接符 */
	private String way;
	/** sql */
	private String sql;
	/** 是否使用默认值标记(1使用0不使用) */
	private String is_val;
	/** 默认值 */
	private String value;
	/** 图文分离标记 0:no,1:分离*/
	private String itst;
	/** 出参标记*/
	private String osub;
	/** 入参标记*/
	private String isub;
	/** 排序字段标记 */
	private String obc;
	/** 入参必填字段 标记 */
	private String mb;
	/**数据库字段处理函数(#self代表当前字段本身)*/
	private String fun;
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
	 * 别名取得
	 * @return 别名
	 */
	public String getAlias() {
	    return alias;
	}

	/**
	 * 别名设定
	 * @param alias 别名
	 */
	public void setAlias(String alias) {
	    this.alias = alias;
	}

	/**
	 * 连接符取得
	 * @return 连接符
	 */
	public String getWay() {
	    return way;
	}

	/**
	 * 连接符设定
	 * @param way 连接符
	 */
	public void setWay(String way) {
	    this.way = way;
	}

	/**
	 * sql取得
	 * @return sql
	 */
	public String getSql() {
	    return sql;
	}

	/**
	 * sql设定
	 * @param sql sql
	 */
	public void setSql(String sql) {
	    this.sql = sql;
	}

	/**
	 * 是否使用默认值标记(1使用0不使用)取得
	 * @return 是否使用默认值标记(1使用0不使用)
	 */
	public String getIs_val() {
	    return is_val;
	}

	/**
	 * 是否使用默认值标记(1使用0不使用)设定
	 * @param is_val 是否使用默认值标记(1使用0不使用)
	 */
	public void setIs_val(String is_val) {
	    this.is_val = is_val;
	}

	/**
	 * 默认值取得
	 * @return 默认值
	 */
	public String getValue() {
	    return value;
	}

	/**
	 * 默认值设定
	 * @param value 默认值
	 */
	public void setValue(String value) {
	    this.value = value;
	}

	/**
	 * 图文分离标记 0:no,1:分离取得
	 * @return 图文分离标记 0:no,1:分离
	 */
	public String getItst() {
	    return itst;
	}

	/**
	 * 图文分离标记 0:no,1:分离设定
	 * @param itst 图文分离标记 0:no,1:分离
	 */
	public void setItst(String itst) {
	    this.itst = itst;
	}

	/**
	 * 出参标记取得
	 * @return 出参标记
	 */
	public String getOsub() {
	    return osub;
	}

	/**
	 * 出参标记设定
	 * @param osub 出参标记
	 */
	public void setOsub(String osub) {
	    this.osub = osub;
	}

	/**
	 * 入参标记取得
	 * @return 入参标记
	 */
	public String getIsub() {
	    return isub;
	}

	/**
	 * 入参标记设定
	 * @param isub 入参标记
	 */
	public void setIsub(String isub) {
	    this.isub = isub;
	}

	/**
	 * 排序字段标记取得
	 * @return 排序字段标记
	 */
	public String getObc() {
	    return obc;
	}

	/**
	 * 排序字段标记设定
	 * @param obc 排序字段标记
	 */
	public void setObc(String obc) {
	    this.obc = obc;
	}

	/**
	 * 入参必填字段 标记取得
	 * @return 入参必填字段 标记
	 */
	public String getMb() {
	    return mb;
	}

	/**
	 * 入参必填字段 标记设定
	 * @param mb 入参必填字段 标记
	 */
	public void setMb(String mb) {
	    this.mb = mb;
	}

	/**
	 * 数据库字段处理函数(#self代表当前字段本身)取得
	 * @return 数据库字段处理函数(#self代表当前字段本身)
	 */
	public String getFun() {
	    return fun;
	}

	/**
	 * 数据库字段处理函数(#self代表当前字段本身)设定
	 * @param fun 数据库字段处理函数(#self代表当前字段本身)
	 */
	public void setFun(String fun) {
	    this.fun = fun;
	}
	

}
