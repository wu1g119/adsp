/*
 * 系统表(数据库)DAO 接口类
 *
 * VERSION  DATE        BY              REASON
 * -------- ----------- --------------- ------------------------------------------
 * 1.00     2012.04.17  wuxiaogang      程序・发布
 * -------- ----------- --------------- ------------------------------------------
 * Copyright 2013 wuxiaogang System. - All Rights Reserved.
 *
 */

package cn.com.softvan.dao.sourcedb;

import java.util.List;

import org.apache.ibatis.annotations.CacheNamespace;

import cn.com.softvan.bean.sourcedb.TableColumnsBean;
import cn.com.softvan.dao.entity.IEntity;
import cn.com.softvan.dao.utils.MybatisRedisCache;


/**
 * <p>系统表(数据库)DAO 接口类</p>
 * <ol>[提供機能]
 * <li>系统表(数据库)信息List</li>
 * </ol>
 *
 * @author wuxiaogang
 */
//@CacheNamespace(implementation=MybatisRedisCache.class)
public interface IDbDao {
	//需要缓存的DAO类上添加@CacheNamespace(implementation=MybatisRedisCache.class )
    /**
     * <p>系统表(数据库)信息List。</p>
     * <ol>[功能概要]
     * <div>系统表(数据库)List。</div>
     * </ol>
     * @param dto 
     * @return 系统表(数据库)信息List
     * @throws Exception 数据库操作异常
     */
    public List<TableColumnsBean> findDbList(IEntity dto) throws Exception;
}
