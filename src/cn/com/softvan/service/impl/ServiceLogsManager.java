/*
 * 接口监控日志表  manager 实现类
 *
 * VERSION  DATE        BY              REASON
 * -------- ----------- --------------- ------------------------------------------
 * 1.00     2013.03.08  wuxiaogang           程序・发布
 * -------- ----------- --------------- ------------------------------------------
 * Copyright 2013 adsp System. - All Rights Reserved.
 *
 */
package cn.com.softvan.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import cn.com.softvan.bean.logs.AdspServiceLogsBean;
import cn.com.softvan.common.IdUtils;
import cn.com.softvan.dao.IAdspServiceLogsDao;
import cn.com.softvan.dao.entity.AdspServiceLogs;
import cn.com.softvan.service.BaseManager;
import cn.com.softvan.service.IServiceLogsManager;

/**
 * 接口监控日志表 manager 实现类
 * 
 * @author {wuxiaogang}
 * 
 */
public class ServiceLogsManager extends BaseManager implements IServiceLogsManager,Runnable {
	/** 日志 */
	private static final transient Logger log = Logger
			.getLogger(ServiceLogsManager.class);

	/** 默认构造器 */
	public ServiceLogsManager() {

	}
	/**接口日志dto*/
	private AdspServiceLogs dto=null; 
	/** 构造器
	 * @param _adspServiceLogsDao
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
	 *  */
	public ServiceLogsManager(IAdspServiceLogsDao _adspServiceLogsDao,
			String system,
			String port_name,
			String service_name,
			String service_argument,
			Long process_time,
			String error_msg,
			String language,
			String create_id,
			String create_ip,
			String sql_info) {
		adspServiceLogsDao=_adspServiceLogsDao;
		dto = new AdspServiceLogs();
		// id
		dto.setId(IdUtils.createUUID(32));
		//调用系统
		dto.setSystem(system);
		//接口名称
		dto.setPort_name(port_name);
		//服务名称
		dto.setService_name(service_name);
		//调用参数
		dto.setService_argument(service_argument);
		//处理时间
		dto.setProcess_time(process_time);
		//异常信息
		dto.setError_msg(error_msg);
		//接口语言
		dto.setLanguage(language);
		//-----------------------
		// 建立者ID
		dto.setCreate_id(create_id);
		// 建立者IP
		dto.setCreate_ip(create_ip);
		//sql_info
		dto.setSql_info(sql_info);
	}
	/**
	 * 接口监控日志表表DAO 接口类
	 */
	private IAdspServiceLogsDao adspServiceLogsDao;
	
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
			String sql_info) {
		try {
			AdspServiceLogs dto = new AdspServiceLogs();
			// id
			dto.setId(IdUtils.createUUID(32));
			//调用系统
			dto.setSystem(system);
			//接口名称
			dto.setPort_name(port_name);
			//服务名称
			dto.setService_name(service_name);
			//调用参数
			dto.setService_argument(service_argument);
			//处理时间
			dto.setProcess_time(process_time);
			//异常信息
			dto.setError_msg(error_msg);
			//接口语言
			dto.setLanguage(language);
			//-----------------------
			// 建立者ID
			dto.setCreate_id(create_id);
			// 建立者IP
			dto.setCreate_ip(create_ip);
			//sql_info
			dto.setSql_info(sql_info);
			// --保存
			adspServiceLogsDao.insertServiceLogs(dto);
		} catch (Exception e) {
			log.error("保存接口监控日志表出错!", e);
		}
	}

	/**
	 * 删除接口监控日志表
	 * 
	 * @param bean
	 * @return
	 */
	public String deleteServiceLogs(AdspServiceLogsBean bean) {
		String msg = "1";
		try {
			AdspServiceLogs dto = new AdspServiceLogs();
			//id
			dto.setId(bean.getId());
			//--删除
			adspServiceLogsDao.deleteServiceLogs(dto);
		} catch (Exception e) {
			msg="保存接口监控日志表出错!";
			log.error(msg, e);
		}
		return msg;
	}

	/**
	 * 分页展示接口监控日志表
	 * 
	 * @param bean
	 * @return
	 */
	public List<AdspServiceLogsBean> findAdspServiceLogsbeanIsPage(
			AdspServiceLogsBean bean) {
		List<AdspServiceLogsBean> beans = null;
		try {
			AdspServiceLogs dto = new AdspServiceLogs();
			// id
			dto.setId(IdUtils.createUUID(32));
			//调用系统
			dto.setSystem(bean.getSystem());
			//接口名称
			dto.setPort_name(bean.getPort_name());
			//服务名称
			dto.setService_name(bean.getService_name());
			//调用参数
			dto.setService_argument(bean.getService_argument());
			//处理时间
			dto.setProcess_time(bean.getProcess_time());
			//异常信息
			dto.setError_msg(bean.getError_msg());
			//接口语言
			dto.setLanguage(bean.getLanguage());
			//-----------------------
			// 建立者ID
			dto.setCreate_id(bean.getCreate_id());
			// 建立者IP
			dto.setCreate_ip(bean.getCreate_ip());
			//分页
			dto.setPageinfo(bean.getPageinfo());
			//时间1
			dto.setDate1(bean.getDate1());
			//时间2
			dto.setDate2(bean.getDate2());
			//查询
			beans=adspServiceLogsDao.findAdspServiceLogsbeanIsPage(dto);
		} catch (Exception e) {
			log.error("接口监控日志筛选显示,数据库处理出错!", e);
		}
		return beans;
	}

	/**
	 * 接口监控日志表 详情
	 * 
	 * @param bean
	 * @return
	 */
	public AdspServiceLogsBean findAdspServiceLogsbeanById(AdspServiceLogsBean bean) {
		AdspServiceLogsBean bean1 = null;
		//TODO-------待完成
		return bean1;
	}

	/**
	 * 接口监控日志表表DAO 接口类取得
	 * @return 接口监控日志表表DAO 接口类
	 */
	public IAdspServiceLogsDao getAdspServiceLogsDao() {
	    return adspServiceLogsDao;
	}

	/**
	 * 接口监控日志表表DAO 接口类设定
	 * @param adspServiceLogsDao 接口监控日志表表DAO 接口类
	 */
	public void setAdspServiceLogsDao(IAdspServiceLogsDao adspServiceLogsDao) {
	    this.adspServiceLogsDao = adspServiceLogsDao;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			// --保存
			adspServiceLogsDao.insertServiceLogs(dto);
		} catch (Exception e) {
			log.error("保存接口监控日志表出错!", e);
		}
	}
}
