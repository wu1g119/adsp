/*
 *  服务配置信息表DAO 接口类
 *
 * VERSION  		DATE       			 BY              REASON
 * -------- ----------- --------------- ------------------------------------------
 * 1.00     	    2013.02.22  	 	wuxiaogang       程序・发布                 
 * -------- ----------- --------------- ------------------------------------------
 * Copyright 2013 adsp System. - All Rights Reserved.
 *
 */
package cn.com.softvan.dao;

import java.util.List;

import cn.com.softvan.bean.config.AdspServiceConfigInfoBean;
import cn.com.softvan.dao.entity.IEntity;

/**
 * 服务配置信息表DAO 接口类
 * 
 * @author wuxiaogang
 */
public interface IAdspServiceConfigInfoDao{
	//需要缓存的DAO类上添加@CacheNamespace(implementation=MybatisRedisCache.class )
	/**
     * <p>提取服务配置信息List。</p>
     * <ol>[功能概要]
     * <div>提取服务配置List。</div>
     * </ol>
     * @param dto 
     * @return 提取服务配置信息List
     * @throws Exception 数据库操作异常
     */
    public List<AdspServiceConfigInfoBean> findAdspServiceConfigInfoList(IEntity dto) throws Exception;
    /**
     * <p>新增数据提取服务</p>
     * <ol>[功能概要]
     * <div>新增数据提取服务</div>
     * </ol>
     * @param dto 
     * @return 
     * @throws Exception 数据库操作异常
     */
    public void insertAdspServiceConfigInfo(IEntity dto) throws Exception;
    /**
     * <p>更新数据提取服务</p>
     * <ol>[功能概要]
     * <div>更新数据提取服务</div>
     * </ol>
     * @param dto 
     * @return 
     * @throws Exception 数据库操作异常
     */
    public void updateAdspServiceConfigInfo(IEntity dto) throws Exception;
    /**
     * <p>检查数据提取服务是否存在</p>
     * <ol>[功能概要]
     * <div>检查数据提取服务是否存在</div>
     * </ol>
     * @param dto 
     * @return 
     * @throws Exception 数据库操作异常
     */
    public int isAdspServiceConfigInfoYN(IEntity dto) throws Exception;
    /**
     * <p>数据提取服务分页显示</p>
     * <ol>[功能概要]
     * <div>数据提取服务分页显示</div>
     * </ol>
     * @param dto 
     * @return 
     * @throws Exception 数据库操作异常
     */
    public List<AdspServiceConfigInfoBean> findAdspServiceConfigInfoIsPage(IEntity dto) throws Exception;
    /**
     * <p>获取数据提取服务信息</p>
     * <ol>[功能概要]
     * <div>获取数据提取服务信息</div>
     * </ol>
     * @param dto 
     * @return bean
     * @throws Exception 数据库操作异常
     */
    public AdspServiceConfigInfoBean findAdspServiceConfigInfoById(IEntity dto) throws Exception;
    /**
     * <p>获取服务名</p>
     * <ol>[功能概要]
     * <div>获取服务名</div>
     * </ol>
     * @param dto 
     * @return bean
     * @throws Exception 数据库操作异常
     */
    public AdspServiceConfigInfoBean findServiceNameById(IEntity dto) throws Exception;
    
}
