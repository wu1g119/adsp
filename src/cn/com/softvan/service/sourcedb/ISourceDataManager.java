/*
 * 数据来源  manager接口类
 *
 * VERSION  DATE        BY              REASON
 * -------- ----------- --------------- ------------------------------------------
 * 1.00     2012.12.11  wuxiaogang           程序・发布
 * -------- ----------- --------------- ------------------------------------------
 * Copyright 2013 adsp System. - All Rights Reserved.
 *
 */
package cn.com.softvan.service.sourcedb;

import java.util.List;
import java.util.Map;

import cn.com.softvan.bean.sourcedb.TableColumnsBean;
import cn.com.softvan.dao.entity.IEntity;
import cn.com.softvan.dao.entity.sourcedb.Columns;
import cn.com.softvan.dao.entity.sourcedb.Db;
import cn.com.softvan.dao.entity.sourcedb.Table;
import cn.com.softvan.web.tag.PageInfo;

/**
 * 数据来源  manager接口类
 * @author {wuxiaogang}
 *
 */
public interface ISourceDataManager {
		
	/**
     * <p>提取数据信息。</p>
     * <ol>[功能概要]
     * <div>传入sql获取数据。</div>
     * </ol>
     * @param sql
     * @return data
     * @throws Exception 数据库操作异常
     */
    public List<Map<?,?>> getData(Map<String,String> map) throws Exception;
    /**
     * <p>提取数据信息(分页)。</p>
     * <ol>[功能概要]
     * <div>传入sql获取数据。</div>
     * </ol>
     * @param sql
     * @return data
     * @throws Exception 数据库操作异常
     */
    public List<Map<?,?>> getDataIsPage(Map<String,String> map) throws Exception;
    /**
     * <p>系统表(表) 列表 分页查询。</p>
     * </ol>
     * @param dto 
     * @return 系统表(表) 列表List  分页查询
     * @throws Exception 数据库操作异常
     */
    public  List<TableColumnsBean>  findTableIsPage(PageInfo page);
    
    /**
     * <p>表(字段) map。</p>
     * </ol>
     * @param tables<String> 
     * @return 表(字段)map<table_name,table_Columns_list>
     * @throws Exception 数据库操作异常
     */
    public Map<String,List<TableColumnsBean>> getTableInfoMaps(String[] tables);
    /**
     * 系统表(数据库) 列表 查询
     * @param dto
     * @return
     */
    public List<TableColumnsBean> findDbList(Db dto);
    /**
     * 系统表(表) 列表 查询
     * @param dto
     * @return
     */
    public List<TableColumnsBean> findTableList(IEntity dto);
    /**
     * 系统表(表) 列表 查询 
     * @param 数据库列表
     * @return
     */
    public List<TableColumnsBean> findTableList(String[] dbs);
    /**
	 * 获取tablename对应表的主键信息
     * @throws Exception 
	 */
	public List<TableColumnsBean> findTablePKInfo(Table table);
	/**
	 * 根据数据表名、数据库名称获取数据表字段集合
	 * @param dto
	 * @return
	 */
	public List<TableColumnsBean> findColumns(Columns dto);
	/**
	 * 根据页面的查询条件查询
	 * @param beans
	 * @return
	 */
	public List<TableColumnsBean> findTablesBySql(TableColumnsBean beans);
	
}
