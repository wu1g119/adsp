/*
 * json to bean BEAN CLASS
 *
 * VERSION  DATE          BY              REASON
 * -------- ------------- --------------- ------------------------------------------
 * 1.00     2013.03.06    wuxiaogang           程序・发布
 * -------- ------------- --------------- ------------------------------------------
 * Copyright 2013 adsp System. - All Rights Reserved.
 *
 */
package cn.com.softvan.bean.config;

import java.util.List;

import cn.com.softvan.bean.BaseBean;

/**
 *json to bean BEAN CLASS
 * 
 * @author {wuxiaogang}
 * 
 */
public class ConfigJsonBean extends BaseBean {
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1890658163437696749L;

	/** 默认构造器 */
	public ConfigJsonBean() {
	}
	/**数据库名*/
	private List<ToInfoBean> dbs;
	/**数据库表名*/
	private List<ToInfoBean> tables;
	/**返回参数*/
	private List<ToInfoBean> outputs;
	/**图文分离字段*/
	private List<ToInfoBean> itsts;
	/**主服务输出参数(作为子服务入参使用   字段汇总)*/
	private List<ToInfoBean> osubs;
	/**主表名*/
	private String joins_main;
	/**从表连接信息*/
	private List<ToInfoBean> joins_other;
	/**固定参数*/
	private String where;
	/**活动参数*/
	private List<ToInfoBean> inputs;
	/**子服务输入参数(入参由主服务提供   字段汇总)*/
	private List<ToInfoBean> isubs;
	/**入参必填字段汇总*/
	private List<ToInfoBean> mbs;
	/**排序sql*/
	private String order;
	/**返回信息sql去除select*/
	private String outputs_sql;
	/**从表关联关系*/
	private String joins_other_sql;
	/**活动参数 有默认值的*/
	private String inputs_sql;
	/**
	 * 数据库名取得
	 * @return 数据库名
	 */
	public List<ToInfoBean> getDbs() {
	    return dbs;
	}

	/**
	 * 数据库名设定
	 * @param dbs 数据库名
	 */
	public void setDbs(List<ToInfoBean> dbs) {
	    this.dbs = dbs;
	}

	/**
	 * 数据库表名取得
	 * @return 数据库表名
	 */
	public List<ToInfoBean> getTables() {
	    return tables;
	}

	/**
	 * 数据库表名设定
	 * @param tables 数据库表名
	 */
	public void setTables(List<ToInfoBean> tables) {
	    this.tables = tables;
	}

	/**
	 * 返回参数取得
	 * @return 返回参数
	 */
	public List<ToInfoBean> getOutputs() {
	    return outputs;
	}

	/**
	 * 返回参数设定
	 * @param outputs 返回参数
	 */
	public void setOutputs(List<ToInfoBean> outputs) {
	    this.outputs = outputs;
	}

	/**
	 * 图文分离字段取得
	 * @return 图文分离字段
	 */
	public List<ToInfoBean> getItsts() {
	    return itsts;
	}

	/**
	 * 图文分离字段设定
	 * @param itsts 图文分离字段
	 */
	public void setItsts(List<ToInfoBean> itsts) {
	    this.itsts = itsts;
	}

	/**
	 * 主服务输出参数(作为子服务入参使用   字段汇总)取得
	 * @return 主服务输出参数(作为子服务入参使用   字段汇总)
	 */
	public List<ToInfoBean> getOsubs() {
	    return osubs;
	}

	/**
	 * 主服务输出参数(作为子服务入参使用   字段汇总)设定
	 * @param osubs 主服务输出参数(作为子服务入参使用   字段汇总)
	 */
	public void setOsubs(List<ToInfoBean> osubs) {
	    this.osubs = osubs;
	}

	/**
	 * 主表名取得
	 * @return 主表名
	 */
	public String getJoins_main() {
	    return joins_main;
	}

	/**
	 * 主表名设定
	 * @param joins_main 主表名
	 */
	public void setJoins_main(String joins_main) {
	    this.joins_main = joins_main;
	}

	/**
	 * 从表连接信息取得
	 * @return 从表连接信息
	 */
	public List<ToInfoBean> getJoins_other() {
	    return joins_other;
	}

	/**
	 * 从表连接信息设定
	 * @param joins_other 从表连接信息
	 */
	public void setJoins_other(List<ToInfoBean> joins_other) {
	    this.joins_other = joins_other;
	}

	/**
	 * 固定参数取得
	 * @return 固定参数
	 */
	public String getWhere() {
	    return where;
	}

	/**
	 * 固定参数设定
	 * @param where 固定参数
	 */
	public void setWhere(String where) {
	    this.where = where;
	}

	/**
	 * 活动参数取得
	 * @return 活动参数
	 */
	public List<ToInfoBean> getInputs() {
	    return inputs;
	}

	/**
	 * 活动参数设定
	 * @param inputs 活动参数
	 */
	public void setInputs(List<ToInfoBean> inputs) {
	    this.inputs = inputs;
	}

	/**
	 * 子服务输入参数(入参由主服务提供   字段汇总)取得
	 * @return 子服务输入参数(入参由主服务提供   字段汇总)
	 */
	public List<ToInfoBean> getIsubs() {
	    return isubs;
	}

	/**
	 * 子服务输入参数(入参由主服务提供   字段汇总)设定
	 * @param isubs 子服务输入参数(入参由主服务提供   字段汇总)
	 */
	public void setIsubs(List<ToInfoBean> isubs) {
	    this.isubs = isubs;
	}
	/**
	 * 入参必填字段汇总取得
	 * @return 入参必填字段汇总
	 */
	public List<ToInfoBean> getMbs() {
	    return mbs;
	}

	/**
	 * 入参必填字段汇总设定
	 * @param mbs 入参必填字段汇总
	 */
	public void setMbs(List<ToInfoBean> mbs) {
	    this.mbs = mbs;
	}

	/**
	 * 排序sql取得
	 * @return 排序sql
	 */
	public String getOrder() {
	    return order;
	}

	/**
	 * 排序sql设定
	 * @param order 排序sql
	 */
	public void setOrder(String order) {
	    this.order = order;
	}

	/**
	 * 返回信息sql去除select取得
	 * @return 返回信息sql去除select
	 */
	public String getOutputs_sql() {
	    return outputs_sql;
	}

	/**
	 * 返回信息sql去除select设定
	 * @param outputs_sql 返回信息sql去除select
	 */
	public void setOutputs_sql(String outputs_sql) {
	    this.outputs_sql = outputs_sql;
	}

	/**
	 * 从表关联关系取得
	 * @return 从表关联关系
	 */
	public String getJoins_other_sql() {
	    return joins_other_sql;
	}

	/**
	 * 从表关联关系设定
	 * @param joins_other_sql 从表关联关系
	 */
	public void setJoins_other_sql(String joins_other_sql) {
	    this.joins_other_sql = joins_other_sql;
	}

	/**
	 * 活动参数 有默认值的取得
	 * @return 活动参数 有默认值的
	 */
	public String getInputs_sql() {
	    return inputs_sql;
	}

	/**
	 * 活动参数 有默认值的设定
	 * @param inputs_sql 活动参数 有默认值的
	 */
	public void setInputs_sql(String inputs_sql) {
	    this.inputs_sql = inputs_sql;
	}
	
}
