/*
 * 接口监控日志表  manager 接口类
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

import cn.com.softvan.bean.logs.AdspServiceLogsBean;

/**
 * 接口监控日志表 manager 接口类
 * 
 * @author {wuxiaogang}
 * 
 */
public interface IServiceLogsManager {

	/**
	 * 保存接口监控日志表
	 * @param system 调用系统
	 * @param port_name 接口名称
	 * @param service_name 服务名称
	 * @param service_argument 调用参数
	 * @param process_time 处理时间
	 * @param error_msg 异常信息
	 * @param language 接口语言
	 * @param create_id 建立者ID
	 * @param create_ip 建立者IP
	 * @param sql_info sql信息
	 */
	public void saveServiceLogs(String system,
			String port_name,
			String service_name,
			String service_argument,
			Long process_time,
			String error_msg,
			String language,
			String create_id,
			String create_ip,
			String sql_info);

	/**
	 * 删除接口监控日志表
	 * 
	 * @param bean
	 * @return
	 */
	public String deleteServiceLogs(AdspServiceLogsBean bean);

	/**
	 * 分页展示接口监控日志表
	 * 
	 * @param bean
	 * @return
	 */
	public List<AdspServiceLogsBean> findAdspServiceLogsbeanIsPage(
			AdspServiceLogsBean bean);

	/**
	 * 接口监控日志表 详情
	 * 
	 * @param bean
	 * @return
	 */
	public AdspServiceLogsBean findAdspServiceLogsbeanById(AdspServiceLogsBean bean);
}
