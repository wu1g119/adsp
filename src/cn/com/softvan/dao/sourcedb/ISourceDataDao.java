/*
 * 数据提取 DAO 接口类
 *
 * VERSION  DATE        BY              REASON
 * -------- ----------- --------------- ------------------------------------------
 * 1.00     2012.12.10  wuxiaogang      程序・发布
 * -------- ----------- --------------- ------------------------------------------
 * Copyright 2013 wuxiaogang System. - All Rights Reserved.
 *
 */

package cn.com.softvan.dao.sourcedb;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.CacheNamespace;

import cn.com.softvan.dao.utils.MybatisRedisCache;




/**
 * <p>数据提取 DAO 接口类</p>
 * <ol>[提供機能]
 * <li>提取数据</li>
 * </ol>
 *
 * @author wuxiaogang
 */
//@CacheNamespace(implementation=MybatisRedisCache.class)
public interface ISourceDataDao {
	//需要缓存的DAO类上添加@CacheNamespace(implementation=MybatisRedisCache.class )
	/**
     * <p>test提取数据信息。</p>
     * <ol>[功能概要]
     * <div>传入sql获取数据。</div>
     * </ol>
     * @param testSql
     * @return data
     * @throws Exception 数据库操作异常
     */
    public List<Map<?,?>> testSqlIsPage(Map<String,String> map) throws Exception;
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
}
