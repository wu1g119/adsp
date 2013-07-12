/*
 * 管理员操作日志  manager 接口类
 *
 * VERSION  DATE        BY              REASON
 * -------- ----------- --------------- ------------------------------------------
 * 1.00     2013.03.08  wuxiaogang           程序・发布
 * -------- ----------- --------------- ------------------------------------------
 * Copyright 2013 adsp System. - All Rights Reserved.
 *
 */
package cn.com.softvan.service;

import java.util.List;

import cn.com.softvan.bean.logs.AdspUserLogsBean;

/**
 * 管理员操作日志 manager 接口类
 * 
 * @author {wuxiaogang}
 * 
 */
public interface IUserLogsManager {

	/**
	 * 保存管理员操作日志
	 * @param user_id 用户ID
	 * @param type 操作类型  I 新增信息 E 信息修改 D 信息删除 R 信息恢复
	 * @param note
	 * @param ip
	 */
	public void saveUserLogs(String user_id,String type,String note,String ip);

	/**
	 * 删除管理员操作日志
	 * 
	 * @param bean
	 * @return
	 */
	public String deleteUserLogs(AdspUserLogsBean bean);

	/**
	 * 分页展示管理员操作日志
	 * 
	 * @param bean
	 * @return
	 */
	public List<AdspUserLogsBean> findAdspUserLogsbeanIsPage(
			AdspUserLogsBean bean);

	/**
	 * 管理员操作日志 详情
	 * 
	 * @param bean
	 * @return
	 */
	public AdspUserLogsBean findAdspUserLogsbeanById(AdspUserLogsBean bean);
}
