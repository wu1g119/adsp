/*
 * 数据来源   manager 实现类
 *
 * VERSION  DATE        BY              REASON
 * -------- ----------- --------------- ------------------------------------------
 * 1.00     2012.11.30  wuxiaogang           程序・发布
 * -------- ----------- --------------- ------------------------------------------
 * Copyright 2013 adsp System. - All Rights Reserved.
 *
 */
package cn.com.softvan.service.sourcedb.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import cn.com.softvan.bean.sourcedb.TableColumnsBean;
import cn.com.softvan.dao.entity.IEntity;
import cn.com.softvan.dao.entity.sourcedb.Columns;
import cn.com.softvan.dao.entity.sourcedb.Db;
import cn.com.softvan.dao.entity.sourcedb.Table;
import cn.com.softvan.dao.sourcedb.IColumnsDao;
import cn.com.softvan.dao.sourcedb.IDbDao;
import cn.com.softvan.dao.sourcedb.ISourceDataDao;
import cn.com.softvan.dao.sourcedb.ITableDao;
import cn.com.softvan.service.BaseManager;
import cn.com.softvan.service.sourcedb.ISourceDataManager;
import cn.com.softvan.web.tag.PageInfo;
/**
 * 数据来源   manager 实现类
 * @author {wuxiaogang}
 *
 */
public class SourceDataManager extends BaseManager implements ISourceDataManager{
	/** 日志 */
	private static final transient Logger log = Logger
			.getLogger(SourceDataManager.class);

	/** 默认构造器 */
	public SourceDataManager() {

	}
	/**
	 * 来源库 DAO
	 */
	private ISourceDataDao sourceDataDao;
	/**
	 * 系统表(数据库)DAO
	 */
	private IDbDao dbDao;
	/**
	 * 系统表(表)DAO
	 */
	private ITableDao tableDao;
	/**
	 * 系统表(字段)DAO
	 */
	private IColumnsDao columnsDao;
    /**
     * <p>提取数据信息。</p>
     * <ol>[功能概要]
     * <div>传入sql获取数据。</div>
     * </ol>
     * @param sql
     * @return data
     * @throws Exception 数据库操作异常
     */
    public List<Map<?,?>> getData(Map<String,String> map) throws Exception{
			return sourceDataDao.getData(map);
    }
    /**
     * <p>提取数据信息(分页)。</p>
     * <ol>[功能概要]
     * <div>传入sql获取数据。</div>
     * </ol>
     * @param sql
     * @return data
     * @throws Exception 数据库操作异常
     */
    public List<Map<?,?>> getDataIsPage(Map<String,String> map) throws Exception{
			return sourceDataDao.getDataIsPage(map);
    }
	/**
	 * 来源库 DAO取得
	 * @return 来源库 DAO
	 */
	public ISourceDataDao getSourceDataDao() {
	    return sourceDataDao;
	}

	/**
	 * 来源库 DAO设定
	 * @param sourceDataDao 来源库 DAO
	 */
	public void setSourceDataDao(ISourceDataDao sourceDataDao) {
	    this.sourceDataDao = sourceDataDao;
	}
	
	 /**
     * <p>表(字段) map。</p>
     * </ol>
     * @param tables<String> 
     * @return 表(字段) map<table_name,table_Columns_list>
     * @throws Exception 数据库操作异常
     */
    public Map<String,List<TableColumnsBean>> getTableInfoMaps(String[] tables){
    	//保存各 数据表 字段集合
		Map<String,List<TableColumnsBean>> maps=new HashMap<String, List<TableColumnsBean>>();
    	try {
			Columns dto=null;
			//
			String[] strs=null;
			// 遍历 所有表 找出 该表字段信息
			for(String table_name:tables){
				dto=new Columns();
				//拆
				strs=table_name.split("\\.");
				//数据库名称
				dto.setTABLE_SCHEMA(strs[0]);
				//表名
				dto.setTABLE_NAME(strs[1]);
				//添加
				maps.put(table_name,columnsDao.findColumnsList(dto));//
			}
		} catch (Exception e) {
			log.error("数据库数据处理错误", e);
		}
		return maps;
	}

	/**
	 * <p>
	 * 系统表(表) 列表 分页查询。
	 * </p>
	 * </ol>
	 * 
	 * @param dto
	 * @return 系统表(表) 列表List 分页查询
	 * @throws Exception
	 *             数据库操作异常
	 */
	public  List<TableColumnsBean>  findTableIsPage(PageInfo page) {
		try {
			return tableDao.findTablePage(page);
		} catch (Exception e) {
			log.error("数据库数据处理错误", e);
		}
		return null;
	}
	 /**
     * 系统表(数据库) 列表 查询
     * @param dto
     * @return
     */
    public List<TableColumnsBean> findDbList(Db dto){
    	try {
			return dbDao.findDbList(dto);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("数据库数据处理错误", e);
		}
    	return null;
    }
	/**
	 * 系统表(表) 列表 查询
	 */
	public List<TableColumnsBean> findTableList(IEntity dto){
		try {
			return tableDao.findTableList(dto);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("数据库数据处理错误", e);
			return null;
		}
	}


	/**
	 * 系统表(数据库)DAO取得
	 * @return 系统表(数据库)DAO
	 */
	public IDbDao getDbDao() {
	    return dbDao;
	}

	/**
	 * 系统表(数据库)DAO设定
	 * @param dbDao 系统表(数据库)DAO
	 */
	public void setDbDao(IDbDao dbDao) {
	    this.dbDao = dbDao;
	}

	/**
	 * 系统表(表)DAO取得
	 * @return 系统表(表)DAO
	 */
	public ITableDao getTableDao() {
		return tableDao;
	}

	/**
	 * 系统表(表)DAO设定
	 * @param tableDao 系统表(表)DAO
	 */
	public void setTableDao(ITableDao tableDao) {
		this.tableDao = tableDao;
	}

	/**
	 * 系统表(字段)DAO取得
	 * @return 系统表(字段)DAO
	 */
	public IColumnsDao getColumnsDao() {
		return columnsDao;
	}
	/**
	 * 获取tablename对应表的主键信息
	 * @throws Exception 
	 */
	public List<TableColumnsBean> findTablePKInfo(Table table) {
		// TODO Auto-generated method stub
		Columns column = new Columns();
		column.setTABLE_NAME(table.getTABLE_NAME());
		column.setCOLUMN_KEY("PRI");
		column.setTABLE_SCHEMA(table.getTABLE_SCHEMA());
		List<TableColumnsBean> list =new ArrayList<TableColumnsBean>();
		try {
			list =columnsDao.findColumnsList(column);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("获取tablename对应表的主键信息查询失败", e);
		}
		return list;
	}

	/**
	 * 系统表(字段)DAO设定
	 * @param columnsDao 系统表(字段)DAO
	 */
	public void setColumnsDao(IColumnsDao columnsDao) {
		this.columnsDao = columnsDao;
	}
	
	
	/**
     * 系统表(表) 列表 查询 
     * @param 数据库列表
     * @return
     */
    public List<TableColumnsBean> findTableList(String[] dbs){
    	
    	try {
			return tableDao.findTableListByDBs(dbs);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("数据库数据处理错误", e);
		}
    	return null;
    }
    /**
     * 根据数据表名、数据库名称获取数据表字段集合
     */
	public List<TableColumnsBean> findColumns(Columns dto) {
		// TODO Auto-generated method stub
		try {
			return columnsDao.findColumnsList(dto);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("findColumnsList方法 数据库处理错误.....",e);
			log.error(e);
		}
		return null;
	}

	/**
	 * 根据页面的查询条件查询
	 */
	public List<TableColumnsBean> findTablesBySql(TableColumnsBean beans) {
		// TODO Auto-generated method stub
		try {
			return tableDao.findTablesBySql(beans);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("findTablesBySql方法 数据库处理错误.....",e);
			log.error(e);
		}
		return null;
	}
}
