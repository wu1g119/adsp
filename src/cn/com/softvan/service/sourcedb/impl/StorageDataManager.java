/*
 * 数据存储   manager 实现类
 *
 * VERSION  DATE        BY              REASON
 * -------- ----------- --------------- ------------------------------------------
 * 1.00     2012.12.18  wuxiaogang           程序・发布
 * -------- ----------- --------------- ------------------------------------------
 * Copyright 2013 adsp System. - All Rights Reserved.
 *
 */
package cn.com.softvan.service.sourcedb.impl;

import java.util.Map;

import org.apache.log4j.Logger;

import cn.com.softvan.dao.sourcedb.IStorageDataDao;
import cn.com.softvan.service.BaseManager;
import cn.com.softvan.service.sourcedb.IStorageDataManager;
/**
 * 数据存储   manager 实现类
 * @author {wuxiaogang}
 *
 */
public class StorageDataManager extends BaseManager implements IStorageDataManager{
	/** 日志 */
	private static final transient Logger log = Logger
			.getLogger(StorageDataManager.class);

	/** 默认构造器 */
	public StorageDataManager() {

	}
	/**
	 * 存储库 DAO
	 */
	private IStorageDataDao storageDataDao;

	/**
	 * 存储库 DAO取得
	 * @return 存储库 DAO
	 */
	public IStorageDataDao getStorageDataDao() {
	    return storageDataDao;
	}

	/**
	 * 存储库 DAO设定
	 * @param storageDataDao 存储库 DAO
	 */
	public void setStorageDataDao(IStorageDataDao storageDataDao) {
	    this.storageDataDao = storageDataDao;
	}
	/**
     * <p>检查数据信息是否存在</p>
     * <ol>[功能概要]
     * <div>检查数据信息是否存在</div>
     * </ol>
     * @param sql 
     * @return 
     * @throws Exception 数据库操作异常
     */
    public int isDataYN(Map<String,String> map){
    	try {
			return storageDataDao.isDataYN(map);
		} catch (Exception e) {
			log.error("数据同步过程!数据库数据处理错误", e);
		}
    	return 0;
    }
    /**
     * <p>新增数据信息。</p>
     * <ol>[功能概要]
     * <div>新增数据。</div>
     * </ol>
     * @param sql
     * @throws Exception 数据库操作异常
     */
    public void insertData(Map<String,String> map) throws Exception{
    	storageDataDao.insertData(map);
    }
    /**
     * <p>删除数据信息。</p>
     * <ol>[功能概要]
     * <div>删除数据。</div>
     * </ol>
     * @param sql
     * @throws Exception 数据库操作异常
     */
    public void deleteData(Map<String,String> map) throws Exception{
    	storageDataDao.deleteData(map);
    }
    /**
     * <p>修改数据信息。</p>
     * <ol>[功能概要]
     * <div>修改数据。</div>
     * </ol>
     * @param sql
     * @throws Exception 数据库操作异常
     */
    public void updateData(Map<String,String> map) throws Exception{
    	storageDataDao.updateData(map);
    }
}
