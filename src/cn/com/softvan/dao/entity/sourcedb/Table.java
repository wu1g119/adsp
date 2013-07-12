/*
 * 系统表的数据库类(表)
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
 * 系统表的数据库类(表)
 * 
 * @author wuxiaogang
 */
public class Table implements IEntity {

	/** 数据库名称 */
	private String TABLE_SCHEMA;
	/** 表名 */
	private String TABLE_NAME;
	/** 表备注信息 */
	private String TABLE_COMMENT;
	/** 版本 */
	private String VERSION;
	/** 数据条数 */
	private String TABLE_ROWS;
	/** 索引长度 */
	private String INDEX_LENGTH;
	/** 平均数据记录字节长度 */
	private String AVG_ROW_LENGTH;
	/** 总记录字节长度 */
	private String DATA_LENGTH;
	/** 自增长字段信息 */
	private String AUTO_INCREMENT;
	/** 表创建时间 */
	private String CREATE_TIME;
	/** 表修改时间 */
	private String UPDATE_TIME;
	
	/**表类型*/
	private String TABLE_TYPE;

	/**
	 * 数据库名称取得
	 * @return 数据库名称
	 */
	public String getTABLE_SCHEMA() {
		return TABLE_SCHEMA;
	}

	/**
	 * 数据库名称設定
	 * @param TABLE_SCHEMA 数据库名称
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
	 * 表名設定
	 * @param TABLE_NAME 表名
	 */
	public void setTABLE_NAME(String TABLE_NAME) {
		this.TABLE_NAME = TABLE_NAME;
	}

	/**
	 * 表备注信息取得
	 * @return 表备注信息
	 */
	public String getTABLE_COMMENT() {
		return TABLE_COMMENT;
	}

	/**
	 * 表备注信息設定
	 * @param TABLE_COMMENT 表备注信息
	 */
	public void setTABLE_COMMENT(String TABLE_COMMENT) {
		this.TABLE_COMMENT = TABLE_COMMENT;
	}

	/**
	 * 版本取得
	 * @return 版本
	 */
	public String getVERSION() {
		return VERSION;
	}

	/**
	 * 版本設定
	 * @param VERSION 版本
	 */
	public void setVERSION(String VERSION) {
		this.VERSION = VERSION;
	}

	/**
	 * 数据条数取得
	 * @return 数据条数
	 */
	public String getTABLE_ROWS() {
		return TABLE_ROWS;
	}

	/**
	 * 数据条数設定
	 * @param TABLE_ROWS 数据条数
	 */
	public void setTABLE_ROWS(String TABLE_ROWS) {
		this.TABLE_ROWS = TABLE_ROWS;
	}

	/**
	 * 索引长度取得
	 * @return 索引长度
	 */
	public String getINDEX_LENGTH() {
		return INDEX_LENGTH;
	}

	/**
	 * 索引长度設定
	 * @param INDEX_LENGTH 索引长度
	 */
	public void setINDEX_LENGTH(String INDEX_LENGTH) {
		this.INDEX_LENGTH = INDEX_LENGTH;
	}

	/**
	 * 平均数据记录字节长度取得
	 * @return 平均数据记录字节长度
	 */
	public String getAVG_ROW_LENGTH() {
		return AVG_ROW_LENGTH;
	}

	/**
	 * 平均数据记录字节长度設定
	 * @param AVG_ROW_LENGTH 平均数据记录字节长度
	 */
	public void setAVG_ROW_LENGTH(String AVG_ROW_LENGTH) {
		this.AVG_ROW_LENGTH = AVG_ROW_LENGTH;
	}

	/**
	 * 总记录字节长度取得
	 * @return 总记录字节长度
	 */
	public String getDATA_LENGTH() {
		return DATA_LENGTH;
	}

	/**
	 * 总记录字节长度設定
	 * @param DATA_LENGTH 总记录字节长度
	 */
	public void setDATA_LENGTH(String DATA_LENGTH) {
		this.DATA_LENGTH = DATA_LENGTH;
	}

	/**
	 * 自增长字段信息取得
	 * @return 自增长字段信息
	 */
	public String getAUTO_INCREMENT() {
		return AUTO_INCREMENT;
	}

	/**
	 * 自增长字段信息設定
	 * @param AUTO_INCREMENT 自增长字段信息
	 */
	public void setAUTO_INCREMENT(String AUTO_INCREMENT) {
		this.AUTO_INCREMENT = AUTO_INCREMENT;
	}

	/**
	 * 表创建时间取得
	 * @return 表创建时间
	 */
	public String getCREATE_TIME() {
		return CREATE_TIME;
	}

	/**
	 * 表创建时间設定
	 * @param CREATE_TIME 表创建时间
	 */
	public void setCREATE_TIME(String CREATE_TIME) {
		this.CREATE_TIME = CREATE_TIME;
	}

	/**
	 * 表修改时间取得
	 * @return 表修改时间
	 */
	public String getUPDATE_TIME() {
		return UPDATE_TIME;
	}

	/**
	 * 表修改时间設定
	 * @param UPDATE_TIME 表修改时间
	 */
	public void setUPDATE_TIME(String UPDATE_TIME) {
		this.UPDATE_TIME = UPDATE_TIME;
	}

	/**
	 * 表类型取得
	 * @return 表类型
	 */
	public String getTABLE_TYPE() {
	    return TABLE_TYPE;
	}

	/**
	 * 表类型設定
	 * @param TABLE_TYPE 表类型
	 */
	public void setTABLE_TYPE(String TABLE_TYPE) {
	    this.TABLE_TYPE = TABLE_TYPE;
	}

	

}
