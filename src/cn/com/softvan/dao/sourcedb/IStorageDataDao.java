/*
 * 数据存储入库(接收数据同步 录入数据库) DAO 接口类
 *
 * VERSION  DATE        BY              REASON
 * -------- ----------- --------------- ------------------------------------------
 * 1.00     2012.12.10  wuxiaogang      程序・发布
 * -------- ----------- --------------- ------------------------------------------
 * Copyright 2013 wuxiaogang System. - All Rights Reserved.
 *
 */

package cn.com.softvan.dao.sourcedb;

import java.util.Map;




/**
 * <p>数据存储入库 DAO 接口类</p>
 * <ol>[提供機能]
 * <li>数据存储入库(接收数据同步 录入数据库)</li>
 * </ol>
 *
 * @author wuxiaogang
 */
public interface IStorageDataDao {
	//需要缓存的DAO类上添加@CacheNamespace(implementation=MybatisRedisCache.class )
    /**
     * <p>新增数据信息。</p>
     * <ol>[功能概要]
     * <div>新增数据。</div>
     * </ol>
     * @param sql
     * @throws Exception 数据库操作异常
     */
    public void insertData(Map<String,String> map) throws Exception;
    /**
     * <p>删除数据信息。</p>
     * <ol>[功能概要]
     * <div>删除数据。</div>
     * </ol>
     * @param sql
     * @throws Exception 数据库操作异常
     */
    public void deleteData(Map<String,String> map) throws Exception;
    /**
     * <p>修改数据信息。</p>
     * <ol>[功能概要]
     * <div>修改数据。</div>
     * </ol>
     * @param sql
     * @throws Exception 数据库操作异常
     */
    public void updateData(Map<String,String> map) throws Exception;
    /**
     * <p>检查数据信息是否存在</p>
     * <ol>[功能概要]
     * <div>检查数据信息是否存在</div>
     * </ol>
     * @param sql 
     * @return 
     * @throws Exception 数据库操作异常
     */
    public int isDataYN(Map<String,String> map) throws Exception;
}
