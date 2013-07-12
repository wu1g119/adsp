/*
 * 系统表(表 and 字段) BEAN CLASS
 *
 * VERSION  DATE          BY              REASON
 * -------- ------------- --------------- ------------------------------------------
 * 1.00     2013.04.17    wuxiaogang           程序・发布
 * -------- ------------- --------------- ------------------------------------------
 * Copyright 2013 adsp System. - All Rights Reserved.
 *
 */
package cn.com.softvan.bean.sourcedb;

import cn.com.softvan.bean.BaseBean;

public class TableColumnsBean extends BaseBean {
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -7650298727398562430L;

	/** 默认构造器 */
	public TableColumnsBean() {
	}
	
	/**目录名(数据库表)*/
	private String catalog_name;
	/**数据库名称(数据库表)*/
	private String schema_name;
	/**默认字符集名称(数据库表)*/
	private String default_character_set_name;
	/**默认排序规则名(数据库表)*/
	private String default_collation_name;
	/**sql路径(数据库表)*/
	private String sql_path;
	
	/** 数据库名称 */
	private String table_schema;
	/** 表名 */
	private String table_name;
	/** 表备注信息 */
	private String table_comment;
	/** 版本 */
	private String version;
	/** 数据条数 */
	private String table_rows;
	/** 平均数据记录字节长度 */
	private String avg_row_length;
	/** 总记录字节长度 */
	private String data_length;
	/** 表创建时间 */
	private String create_time;
	/** 表修改时间 */
	private String update_time;
	/** 字段名 */
	private String column_name;
	/** 字段序号 */
	private String ordinal_position;
	/** 默认值 */
	private String column_default;
	/** 可否为空 */
	private String is_nullable;
	/** 字段类型 */
	private String column_type;
	/** 是否主外键(PRI:主键 UNI:唯一 MUL:外键) */
	private String column_key;
	/** 字段注释 */
	private String column_comment;
	/** 数据类型 2013/12/03 wang*/
	private String data_type;
	/**是否已匹配列 2013/12/25*/
	private String match_columns_alias;
	/**触发器界面查询条件语句*/
	private String query_table_name_sql;
	
	/**表类型*/
	private String table_type;
	/**影子表查询条件*/
	private String qRef_tname;
	
	/**
	 * 目录名(数据库表)取得
	 * @return 目录名(数据库表)
	 */
	public String getCatalog_name() {
	    return catalog_name;
	}

	/**
	 * 目录名(数据库表)設定
	 * @param catalog_name 目录名(数据库表)
	 */
	public void setCatalog_name(String catalog_name) {
	    this.catalog_name = catalog_name;
	}

	/**
	 * 数据库名称(数据库表)取得
	 * @return 数据库名称(数据库表)
	 */
	public String getSchema_name() {
	    return schema_name;
	}

	/**
	 * 数据库名称(数据库表)設定
	 * @param schema_name 数据库名称(数据库表)
	 */
	public void setSchema_name(String schema_name) {
	    this.schema_name = schema_name;
	}

	/**
	 * 默认字符集名称(数据库表)取得
	 * @return 默认字符集名称(数据库表)
	 */
	public String getDefault_character_set_name() {
	    return default_character_set_name;
	}

	/**
	 * 默认字符集名称(数据库表)設定
	 * @param default_character_set_name 默认字符集名称(数据库表)
	 */
	public void setDefault_character_set_name(String default_character_set_name) {
	    this.default_character_set_name = default_character_set_name;
	}

	/**
	 * 默认排序规则名(数据库表)取得
	 * @return 默认排序规则名(数据库表)
	 */
	public String getDefault_collation_name() {
	    return default_collation_name;
	}

	/**
	 * 默认排序规则名(数据库表)設定
	 * @param default_collation_name 默认排序规则名(数据库表)
	 */
	public void setDefault_collation_name(String default_collation_name) {
	    this.default_collation_name = default_collation_name;
	}

	/**
	 * sql路径(数据库表)取得
	 * @return sql路径(数据库表)
	 */
	public String getSql_path() {
	    return sql_path;
	}

	/**
	 * sql路径(数据库表)設定
	 * @param sql_path sql路径(数据库表)
	 */
	public void setSql_path(String sql_path) {
	    this.sql_path = sql_path;
	}

	/**
	 * 数据库名称取得
	 * @return 数据库名称
	 */
	public String getTable_schema() {
	    return table_schema;
	}

	/**
	 * 数据库名称設定
	 * @param table_schema 数据库名称
	 */
	public void setTable_schema(String table_schema) {
	    this.table_schema = table_schema;
	}

	/**
	 * 表名取得
	 * @return 表名
	 */
	public String getTable_name() {
	    return table_name;
	}

	/**
	 * 表名設定
	 * @param table_name 表名
	 */
	public void setTable_name(String table_name) {
	    this.table_name = table_name;
	}

	/**
	 * 表备注信息取得
	 * @return 表备注信息
	 */
	public String getTable_comment() {
	    return table_comment;
	}

	/**
	 * 表备注信息設定
	 * @param table_comment 表备注信息
	 */
	public void setTable_comment(String table_comment) {
	    this.table_comment = table_comment;
	}

	/**
	 * 版本取得
	 * @return 版本
	 */
	public String getVersion() {
	    return version;
	}

	/**
	 * 版本設定
	 * @param version 版本
	 */
	public void setVersion(String version) {
	    this.version = version;
	}

	/**
	 * 数据条数取得
	 * @return 数据条数
	 */
	public String getTable_rows() {
	    return table_rows;
	}

	/**
	 * 数据条数設定
	 * @param table_rows 数据条数
	 */
	public void setTable_rows(String table_rows) {
	    this.table_rows = table_rows;
	}

	/**
	 * 平均数据记录字节长度取得
	 * @return 平均数据记录字节长度
	 */
	public String getAvg_row_length() {
	    return avg_row_length;
	}

	/**
	 * 平均数据记录字节长度設定
	 * @param avg_row_length 平均数据记录字节长度
	 */
	public void setAvg_row_length(String avg_row_length) {
	    this.avg_row_length = avg_row_length;
	}

	/**
	 * 总记录字节长度取得
	 * @return 总记录字节长度
	 */
	public String getData_length() {
	    return data_length;
	}

	/**
	 * 总记录字节长度設定
	 * @param data_length 总记录字节长度
	 */
	public void setData_length(String data_length) {
	    this.data_length = data_length;
	}

	/**
	 * 表创建时间取得
	 * @return 表创建时间
	 */
	public String getCreate_time() {
	    return create_time;
	}

	/**
	 * 表创建时间設定
	 * @param create_time 表创建时间
	 */
	public void setCreate_time(String create_time) {
	    this.create_time = create_time;
	}

	/**
	 * 表修改时间取得
	 * @return 表修改时间
	 */
	public String getUpdate_time() {
	    return update_time;
	}

	/**
	 * 表修改时间設定
	 * @param update_time 表修改时间
	 */
	public void setUpdate_time(String update_time) {
	    this.update_time = update_time;
	}

	/**
	 * 字段名取得
	 * @return 字段名
	 */
	public String getColumn_name() {
	    return column_name;
	}

	/**
	 * 字段名設定
	 * @param column_name 字段名
	 */
	public void setColumn_name(String column_name) {
	    this.column_name = column_name;
	}

	/**
	 * 字段序号取得
	 * @return 字段序号
	 */
	public String getOrdinal_position() {
	    return ordinal_position;
	}

	/**
	 * 字段序号設定
	 * @param ordinal_position 字段序号
	 */
	public void setOrdinal_position(String ordinal_position) {
	    this.ordinal_position = ordinal_position;
	}

	/**
	 * 默认值取得
	 * @return 默认值
	 */
	public String getColumn_default() {
	    return column_default;
	}

	/**
	 * 默认值設定
	 * @param column_default 默认值
	 */
	public void setColumn_default(String column_default) {
	    this.column_default = column_default;
	}

	/**
	 * 可否为空取得
	 * @return 可否为空
	 */
	public String getIs_nullable() {
	    return is_nullable;
	}

	/**
	 * 可否为空設定
	 * @param is_nullable 可否为空
	 */
	public void setIs_nullable(String is_nullable) {
	    this.is_nullable = is_nullable;
	}

	/**
	 * 字段类型取得
	 * @return 字段类型
	 */
	public String getColumn_type() {
	    return column_type;
	}

	/**
	 * 字段类型設定
	 * @param column_type 字段类型
	 */
	public void setColumn_type(String column_type) {
	    this.column_type = column_type;
	}

	/**
	 * 是否主外键(PRI:主键 UNI:唯一 MUL:外键)取得
	 * @return 是否主外键(PRI:主键 UNI:唯一 MUL:外键)
	 */
	public String getColumn_key() {
	    return column_key;
	}

	/**
	 * 是否主外键(PRI:主键 UNI:唯一 MUL:外键)設定
	 * @param column_key 是否主外键(PRI:主键 UNI:唯一 MUL:外键)
	 */
	public void setColumn_key(String column_key) {
	    this.column_key = column_key;
	}

	/**
	 * 字段注释取得
	 * @return 字段注释
	 */
	public String getColumn_comment() {
	    return column_comment;
	}

	/**
	 * 字段注释設定
	 * @param column_comment 字段注释
	 */
	public void setColumn_comment(String column_comment) {
	    this.column_comment = column_comment;
	}

	/**
	 * 数据类型 2013/12/03 wang取得
	 * @return 数据类型 2013/12/03 wang
	 */
	public String getData_type() {
	    return data_type;
	}

	/**
	 * 数据类型 2013/12/03 wang設定
	 * @param data_type 数据类型 2013/12/03 wang
	 */
	public void setData_type(String data_type) {
	    this.data_type = data_type;
	}

	/**
	 * 是否已匹配列 2013/12/25取得
	 * @return 是否已匹配列 2013/12/25
	 */
	public String getMatch_columns_alias() {
	    return match_columns_alias;
	}

	/**
	 * 是否已匹配列 2013/12/25設定
	 * @param match_columns_alias 是否已匹配列 2013/12/25
	 */
	public void setMatch_columns_alias(String match_columns_alias) {
	    this.match_columns_alias = match_columns_alias;
	}

	/**
	 * 触发器界面查询条件语句取得
	 * @return 触发器界面查询条件语句
	 */
	public String getQuery_table_name_sql() {
	    return query_table_name_sql;
	}

	/**
	 * 触发器界面查询条件语句設定
	 * @param query_table_name_sql 触发器界面查询条件语句
	 */
	public void setQuery_table_name_sql(String query_table_name_sql) {
	    this.query_table_name_sql = query_table_name_sql;
	}

	
	/**
	 * 表类型取得
	 * @return 表类型
	 */
	public String getTable_type() {
	    return table_type;
	}

	/**
	 * 表类型設定
	 * @param table_type 表类型
	 */
	public void setTable_type(String table_type) {
	    this.table_type = table_type;
	}

	

	/**
	 * 影子表查询条件取得
	 * @return 影子表查询条件
	 */
	public String getqRef_tname() {
	    return qRef_tname;
	}

	/**
	 * 影子表查询条件設定
	 * @param qRef_tname 影子表查询条件
	 */
	public void setqRef_tname(String qRef_tname) {
	    this.qRef_tname = qRef_tname;
	}

	

	

}
