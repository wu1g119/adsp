/*
 * 存放数据提取服务配置信息 BEAN CLASS
 *
 * VERSION  DATE          BY              REASON
 * -------- ------------- --------------- ------------------------------------------
 * 1.00     2013.02.26    wuxiaogang           程序・发布
 * -------- ------------- --------------- ------------------------------------------
 * Copyright 2013 adsp System. - All Rights Reserved.
 *
 */
package cn.com.softvan.bean.config;

import java.util.Map;

import cn.com.softvan.bean.BaseBean;

/**
 * 存放数据提取服务配置信息 BEAN CLASS
 * 
 * @author {wuxiaogang}
 * 
 */
public class DbConfigBean extends BaseBean {
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1890658163437696749L;

	/** 默认构造器 */
	public DbConfigBean() {
	}

	/** 数据库名称集合 */
	private String[] dbs;
	/** 数据库表名称集合 */
	private String[] table_names;
	/** 表列表 */
	private String[] output_table_names;
	/** 字段列表 */
	private String[] output_columns_names;
	/** 字段类型 */
	private Map<String, String> output_columns_types;
	/** 字段备注 */
	private Map<String, String> output_columns_comments;
	/** 字段别名 */
	private Map<String, String> output_columns_alias;
	/** 图文分离标记*/
	private Map<String, String> output_columns_itsts;
	/** 子服务使用参数标记*/
	private Map<String, String> output_columns_osubs;
	/** 数据库字段处理函数(#self代表当前字段本身)*/
	private Map<String, String> output_columns_funs;
	/** 主表名 */
	private String main_table_name;
	/** 从表名---标记 */
	private String[] join_infos;
	/** 从表--连接符 */
	private Map<String, String> join_table_way;
	/** 从表--表名 */
	private Map<String, String> join_table_name;
	/** 从表--连接sql */
	private Map<String, String> join_table_sql;
	/** 数据查询条件(固定参数) */
	private String sql_where;
	/** 表列表 */
	private String[] input_table_names;
	/** 字段列表 */
	private String[] input_columns_names;
	/** 字段类型 */
	private Map<String, String> input_columns_types;
	/** 字段备注 */
	private Map<String, String> input_columns_comments;
	/** 字段别名 */
	private Map<String, String> input_columns_alias;
	/** 默认值 标记 */
	private Map<String, String> input_columns_is_vals;
	/** 默认值 */
	private Map<String, String> input_columns_values;
	/** 连接符 */
	private Map<String, String> input_columns_ways;
	/** 入参来自主服务osub标记 */
	private Map<String, String> input_columns_isubs;
	/** 排序字段obc[order by columns]标记 */
	private Map<String, String> input_columns_obcs;
	/** 入参必填 mb标记 */
	private Map<String, String> input_columns_mbs;
	/** 数据排序 */
	private String sql_order;

	/**
	 * 数据库名称集合取得
	 * @return 数据库名称集合
	 */
	public String[] getDbs() {
	    return dbs;
	}

	/**
	 * 数据库名称集合设定
	 * @param dbs 数据库名称集合
	 */
	public void setDbs(String[] dbs) {
	    this.dbs = dbs;
	}

	/**
	 * 数据库表名称集合取得
	 * @return 数据库表名称集合
	 */
	public String[] getTable_names() {
	    return table_names;
	}

	/**
	 * 数据库表名称集合设定
	 * @param table_names 数据库表名称集合
	 */
	public void setTable_names(String[] table_names) {
	    this.table_names = table_names;
	}

	/**
	 * 表列表取得
	 * @return 表列表
	 */
	public String[] getOutput_table_names() {
	    return output_table_names;
	}

	/**
	 * 表列表设定
	 * @param output_table_names 表列表
	 */
	public void setOutput_table_names(String[] output_table_names) {
	    this.output_table_names = output_table_names;
	}

	/**
	 * 字段列表取得
	 * @return 字段列表
	 */
	public String[] getOutput_columns_names() {
	    return output_columns_names;
	}

	/**
	 * 字段列表设定
	 * @param output_columns_names 字段列表
	 */
	public void setOutput_columns_names(String[] output_columns_names) {
	    this.output_columns_names = output_columns_names;
	}

	/**
	 * 字段类型取得
	 * @return 字段类型
	 */
	public Map<String,String> getOutput_columns_types() {
	    return output_columns_types;
	}

	/**
	 * 字段类型设定
	 * @param output_columns_types 字段类型
	 */
	public void setOutput_columns_types(Map<String,String> output_columns_types) {
	    this.output_columns_types = output_columns_types;
	}

	/**
	 * 字段备注取得
	 * @return 字段备注
	 */
	public Map<String,String> getOutput_columns_comments() {
	    return output_columns_comments;
	}

	/**
	 * 字段备注设定
	 * @param output_columns_comments 字段备注
	 */
	public void setOutput_columns_comments(Map<String,String> output_columns_comments) {
	    this.output_columns_comments = output_columns_comments;
	}

	/**
	 * 字段别名取得
	 * @return 字段别名
	 */
	public Map<String,String> getOutput_columns_alias() {
	    return output_columns_alias;
	}

	/**
	 * 字段别名设定
	 * @param output_columns_alias 字段别名
	 */
	public void setOutput_columns_alias(Map<String,String> output_columns_alias) {
	    this.output_columns_alias = output_columns_alias;
	}

	/**
	 * 图文分离标记取得
	 * @return 图文分离标记
	 */
	public Map<String,String> getOutput_columns_itsts() {
	    return output_columns_itsts;
	}

	/**
	 * 图文分离标记设定
	 * @param output_columns_itsts 图文分离标记
	 */
	public void setOutput_columns_itsts(Map<String,String> output_columns_itsts) {
	    this.output_columns_itsts = output_columns_itsts;
	}

	/**
	 * 子服务使用参数标记取得
	 * @return 子服务使用参数标记
	 */
	public Map<String,String> getOutput_columns_osubs() {
	    return output_columns_osubs;
	}

	/**
	 * 子服务使用参数标记设定
	 * @param output_columns_osubs 子服务使用参数标记
	 */
	public void setOutput_columns_osubs(Map<String,String> output_columns_osubs) {
	    this.output_columns_osubs = output_columns_osubs;
	}

	/**
	 * 数据库字段处理函数(#self代表当前字段本身)取得
	 * @return 数据库字段处理函数(#self代表当前字段本身)
	 */
	public Map<String,String> getOutput_columns_funs() {
	    return output_columns_funs;
	}

	/**
	 * 数据库字段处理函数(#self代表当前字段本身)设定
	 * @param output_columns_funs 数据库字段处理函数(#self代表当前字段本身)
	 */
	public void setOutput_columns_funs(Map<String,String> output_columns_funs) {
	    this.output_columns_funs = output_columns_funs;
	}

	/**
	 * 主表名取得
	 * @return 主表名
	 */
	public String getMain_table_name() {
	    return main_table_name;
	}

	/**
	 * 主表名设定
	 * @param main_table_name 主表名
	 */
	public void setMain_table_name(String main_table_name) {
	    this.main_table_name = main_table_name;
	}

	/**
	 * 从表名---标记取得
	 * @return 从表名---标记
	 */
	public String[] getJoin_infos() {
	    return join_infos;
	}

	/**
	 * 从表名---标记设定
	 * @param join_infos 从表名---标记
	 */
	public void setJoin_infos(String[] join_infos) {
	    this.join_infos = join_infos;
	}

	/**
	 * 从表--连接符取得
	 * @return 从表--连接符
	 */
	public Map<String,String> getJoin_table_way() {
	    return join_table_way;
	}

	/**
	 * 从表--连接符设定
	 * @param join_table_way 从表--连接符
	 */
	public void setJoin_table_way(Map<String,String> join_table_way) {
	    this.join_table_way = join_table_way;
	}

	/**
	 * 从表--表名取得
	 * @return 从表--表名
	 */
	public Map<String,String> getJoin_table_name() {
	    return join_table_name;
	}

	/**
	 * 从表--表名设定
	 * @param join_table_name 从表--表名
	 */
	public void setJoin_table_name(Map<String,String> join_table_name) {
	    this.join_table_name = join_table_name;
	}

	/**
	 * 从表--连接sql取得
	 * @return 从表--连接sql
	 */
	public Map<String,String> getJoin_table_sql() {
	    return join_table_sql;
	}

	/**
	 * 从表--连接sql设定
	 * @param join_table_sql 从表--连接sql
	 */
	public void setJoin_table_sql(Map<String,String> join_table_sql) {
	    this.join_table_sql = join_table_sql;
	}

	/**
	 * 数据查询条件(固定参数)取得
	 * @return 数据查询条件(固定参数)
	 */
	public String getSql_where() {
	    return sql_where;
	}

	/**
	 * 数据查询条件(固定参数)设定
	 * @param sql_where 数据查询条件(固定参数)
	 */
	public void setSql_where(String sql_where) {
	    this.sql_where = sql_where;
	}

	/**
	 * 表列表取得
	 * @return 表列表
	 */
	public String[] getInput_table_names() {
	    return input_table_names;
	}

	/**
	 * 表列表设定
	 * @param input_table_names 表列表
	 */
	public void setInput_table_names(String[] input_table_names) {
	    this.input_table_names = input_table_names;
	}

	/**
	 * 字段列表取得
	 * @return 字段列表
	 */
	public String[] getInput_columns_names() {
	    return input_columns_names;
	}

	/**
	 * 字段列表设定
	 * @param input_columns_names 字段列表
	 */
	public void setInput_columns_names(String[] input_columns_names) {
	    this.input_columns_names = input_columns_names;
	}

	/**
	 * 字段类型取得
	 * @return 字段类型
	 */
	public Map<String,String> getInput_columns_types() {
	    return input_columns_types;
	}

	/**
	 * 字段类型设定
	 * @param input_columns_types 字段类型
	 */
	public void setInput_columns_types(Map<String,String> input_columns_types) {
	    this.input_columns_types = input_columns_types;
	}

	/**
	 * 字段备注取得
	 * @return 字段备注
	 */
	public Map<String,String> getInput_columns_comments() {
	    return input_columns_comments;
	}

	/**
	 * 字段备注设定
	 * @param input_columns_comments 字段备注
	 */
	public void setInput_columns_comments(Map<String,String> input_columns_comments) {
	    this.input_columns_comments = input_columns_comments;
	}

	/**
	 * 字段别名取得
	 * @return 字段别名
	 */
	public Map<String,String> getInput_columns_alias() {
	    return input_columns_alias;
	}

	/**
	 * 字段别名设定
	 * @param input_columns_alias 字段别名
	 */
	public void setInput_columns_alias(Map<String,String> input_columns_alias) {
	    this.input_columns_alias = input_columns_alias;
	}

	/**
	 * 默认值 标记取得
	 * @return 默认值 标记
	 */
	public Map<String,String> getInput_columns_is_vals() {
	    return input_columns_is_vals;
	}

	/**
	 * 默认值 标记设定
	 * @param input_columns_is_vals 默认值 标记
	 */
	public void setInput_columns_is_vals(Map<String,String> input_columns_is_vals) {
	    this.input_columns_is_vals = input_columns_is_vals;
	}

	/**
	 * 默认值取得
	 * @return 默认值
	 */
	public Map<String,String> getInput_columns_values() {
	    return input_columns_values;
	}

	/**
	 * 默认值设定
	 * @param input_columns_values 默认值
	 */
	public void setInput_columns_values(Map<String,String> input_columns_values) {
	    this.input_columns_values = input_columns_values;
	}

	/**
	 * 连接符取得
	 * @return 连接符
	 */
	public Map<String,String> getInput_columns_ways() {
	    return input_columns_ways;
	}

	/**
	 * 连接符设定
	 * @param input_columns_ways 连接符
	 */
	public void setInput_columns_ways(Map<String,String> input_columns_ways) {
	    this.input_columns_ways = input_columns_ways;
	}

	/**
	 * 入参来自主服务osub标记取得
	 * @return 入参来自主服务osub标记
	 */
	public Map<String,String> getInput_columns_isubs() {
	    return input_columns_isubs;
	}

	/**
	 * 入参来自主服务osub标记设定
	 * @param input_columns_isubs 入参来自主服务osub标记
	 */
	public void setInput_columns_isubs(Map<String,String> input_columns_isubs) {
	    this.input_columns_isubs = input_columns_isubs;
	}

	/**
	 * 排序字段obc[order by columns]标记取得
	 * @return 排序字段obc[order by columns]标记
	 */
	public Map<String,String> getInput_columns_obcs() {
	    return input_columns_obcs;
	}

	/**
	 * 排序字段obc[order by columns]标记设定
	 * @param input_columns_obcs 排序字段obc[order by columns]标记
	 */
	public void setInput_columns_obcs(Map<String,String> input_columns_obcs) {
	    this.input_columns_obcs = input_columns_obcs;
	}

	/**
	 * 入参必填 mb标记取得
	 * @return 入参必填 mb标记
	 */
	public Map<String,String> getInput_columns_mbs() {
	    return input_columns_mbs;
	}

	/**
	 * 入参必填 mb标记设定
	 * @param input_columns_mbs 入参必填 mb标记
	 */
	public void setInput_columns_mbs(Map<String,String> input_columns_mbs) {
	    this.input_columns_mbs = input_columns_mbs;
	}

	/**
	 * 数据排序取得
	 * @return 数据排序
	 */
	public String getSql_order() {
	    return sql_order;
	}

	/**
	 * 数据排序设定
	 * @param sql_order 数据排序
	 */
	public void setSql_order(String sql_order) {
	    this.sql_order = sql_order;
	}

}
