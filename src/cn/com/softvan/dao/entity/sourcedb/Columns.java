/*
 * 系统表的数据库类(字段)
 *
 * VERSION  		DATE       			 BY              REASON
 * -------- ----------- --------------- ------------------------------------------
 * 1.00     	    2013.04.17  	 	wuxiaogang       程序・发布                 
 * -------- ----------- --------------- ------------------------------------------
 * Copyright 2013 adsp System. - All Rights Reserved.
 *
 */
package cn.com.softvan.dao.entity.sourcedb;

import cn.com.softvan.dao.entity.IEntity;

/**
 * 系统表的数据库类(字段)
 * 
 * @author wuxiaogang
 */
public class Columns implements IEntity {

	/** 数据库名 */
	private String TABLE_SCHEMA;
	/** 表名 */
	private String TABLE_NAME;
	/** 字段名 */
	private String COLUMN_NAME;
	/** 字段序号 */
	private String ORDINAL_POSITION;
	/** 默认值 */
	private String COLUMN_DEFAULT;
	/** 可否为空 */
	private String IS_NULLABLE;
	/** 字段类型 */
	private String COLUMN_TYPE;
	/** 是否主外键(PRI:主键 UNI:唯一约束 MUL:外键) */
	private String COLUMN_KEY;
	/** 字段注释 */
	private String COLUMN_COMMENT;
	/**
	 * 数据库名取得
	 * @return 数据库名
	 */
	public String getTABLE_SCHEMA() {
	    return TABLE_SCHEMA;
	}
	/**
	 * 数据库名设定
	 * @param TABLE_SCHEMA 数据库名
	 */
	public void setTABLE_SCHEMA(String TABLE_SCHEMA) {
	    this.TABLE_SCHEMA = TABLE_SCHEMA;
	}
	/**
	 * 表名取得
	 * @return 表名
	 */
	public String getTABLE_NAME() {
	    return TABLE_NAME;
	}
	/**
	 * 表名设定
	 * @param TABLE_NAME 表名
	 */
	public void setTABLE_NAME(String TABLE_NAME) {
	    this.TABLE_NAME = TABLE_NAME;
	}
	/**
	 * 字段名取得
	 * @return 字段名
	 */
	public String getCOLUMN_NAME() {
	    return COLUMN_NAME;
	}
	/**
	 * 字段名设定
	 * @param COLUMN_NAME 字段名
	 */
	public void setCOLUMN_NAME(String COLUMN_NAME) {
	    this.COLUMN_NAME = COLUMN_NAME;
	}
	/**
	 * 字段序号取得
	 * @return 字段序号
	 */
	public String getORDINAL_POSITION() {
	    return ORDINAL_POSITION;
	}
	/**
	 * 字段序号设定
	 * @param ORDINAL_POSITION 字段序号
	 */
	public void setORDINAL_POSITION(String ORDINAL_POSITION) {
	    this.ORDINAL_POSITION = ORDINAL_POSITION;
	}
	/**
	 * 默认值取得
	 * @return 默认值
	 */
	public String getCOLUMN_DEFAULT() {
	    return COLUMN_DEFAULT;
	}
	/**
	 * 默认值设定
	 * @param COLUMN_DEFAULT 默认值
	 */
	public void setCOLUMN_DEFAULT(String COLUMN_DEFAULT) {
	    this.COLUMN_DEFAULT = COLUMN_DEFAULT;
	}
	/**
	 * 可否为空取得
	 * @return 可否为空
	 */
	public String getIS_NULLABLE() {
	    return IS_NULLABLE;
	}
	/**
	 * 可否为空设定
	 * @param IS_NULLABLE 可否为空
	 */
	public void setIS_NULLABLE(String IS_NULLABLE) {
	    this.IS_NULLABLE = IS_NULLABLE;
	}
	/**
	 * 字段类型取得
	 * @return 字段类型
	 */
	public String getCOLUMN_TYPE() {
	    return COLUMN_TYPE;
	}
	/**
	 * 字段类型设定
	 * @param COLUMN_TYPE 字段类型
	 */
	public void setCOLUMN_TYPE(String COLUMN_TYPE) {
	    this.COLUMN_TYPE = COLUMN_TYPE;
	}
	/**
	 * 是否主外键(PRI:主键 UNI:唯一 MUL:外键)取得
	 * @return 是否主外键(PRI:主键 UNI:唯一 MUL:外键)
	 */
	public String getCOLUMN_KEY() {
	    return COLUMN_KEY;
	}
	/**
	 * 是否主外键(PRI:主键 UNI:唯一 MUL:外键)设定
	 * @param COLUMN_KEY 是否主外键(PRI:主键 UNI:唯一 MUL:外键)
	 */
	public void setCOLUMN_KEY(String COLUMN_KEY) {
	    this.COLUMN_KEY = COLUMN_KEY;
	}
	/**
	 * 字段注释取得
	 * @return 字段注释
	 */
	public String getCOLUMN_COMMENT() {
	    return COLUMN_COMMENT;
	}
	/**
	 * 字段注释设定
	 * @param COLUMN_COMMENT 字段注释
	 */
	public void setCOLUMN_COMMENT(String COLUMN_COMMENT) {
	    this.COLUMN_COMMENT = COLUMN_COMMENT;
	}

}
