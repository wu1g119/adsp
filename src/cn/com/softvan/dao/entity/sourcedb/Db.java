/*
 * 系统表的数据库类(数据库)
 *
 * VERSION  		DATE       			 BY              REASON
 * -------- ----------- --------------- ------------------------------------------
 * 1.00     	    2013.12.07  	 	wuxiaogang       程序・发布                 
 * -------- ----------- --------------- ------------------------------------------
 * Copyright 2013 adsp System. - All Rights Reserved.
 *
 */
package cn.com.softvan.dao.entity.sourcedb;

import cn.com.softvan.dao.entity.IEntity;

/**
 * 系统表的数据库类(数据库)
 * 
 * @author wuxiaogang
 */
public class Db implements IEntity {

	/**目录名*/
	private String CATALOG_NAME;
	/**数据库名称*/
	private String SCHEMA_NAME;
	/**默认字符集名称*/
	private String DEFAULT_CHARACTER_SET_NAME;
	/**默认排序规则名*/
	private String DEFAULT_COLLATION_NAME;
	/**sql路径*/
	private String SQL_PATH;
	/**
	 * 目录名取得
	 * @return 目录名
	 */
	public String getCATALOG_NAME() {
	    return CATALOG_NAME;
	}
	/**
	 * 目录名设定
	 * @param CATALOG_NAME 目录名
	 */
	public void setCATALOG_NAME(String CATALOG_NAME) {
	    this.CATALOG_NAME = CATALOG_NAME;
	}
	/**
	 * 数据库名称取得
	 * @return 数据库名称
	 */
	public String getSCHEMA_NAME() {
	    return SCHEMA_NAME;
	}
	/**
	 * 数据库名称设定
	 * @param SCHEMA_NAME 数据库名称
	 */
	public void setSCHEMA_NAME(String SCHEMA_NAME) {
	    this.SCHEMA_NAME = SCHEMA_NAME;
	}
	/**
	 * 默认字符集名称取得
	 * @return 默认字符集名称
	 */
	public String getDEFAULT_CHARACTER_SET_NAME() {
	    return DEFAULT_CHARACTER_SET_NAME;
	}
	/**
	 * 默认字符集名称设定
	 * @param DEFAULT_CHARACTER_SET_NAME 默认字符集名称
	 */
	public void setDEFAULT_CHARACTER_SET_NAME(String DEFAULT_CHARACTER_SET_NAME) {
	    this.DEFAULT_CHARACTER_SET_NAME = DEFAULT_CHARACTER_SET_NAME;
	}
	/**
	 * 默认排序规则名取得
	 * @return 默认排序规则名
	 */
	public String getDEFAULT_COLLATION_NAME() {
	    return DEFAULT_COLLATION_NAME;
	}
	/**
	 * 默认排序规则名设定
	 * @param DEFAULT_COLLATION_NAME 默认排序规则名
	 */
	public void setDEFAULT_COLLATION_NAME(String DEFAULT_COLLATION_NAME) {
	    this.DEFAULT_COLLATION_NAME = DEFAULT_COLLATION_NAME;
	}
	/**
	 * sql路径取得
	 * @return sql路径
	 */
	public String getSQL_PATH() {
	    return SQL_PATH;
	}
	/**
	 * sql路径设定
	 * @param SQL_PATH sql路径
	 */
	public void setSQL_PATH(String SQL_PATH) {
	    this.SQL_PATH = SQL_PATH;
	}
}
