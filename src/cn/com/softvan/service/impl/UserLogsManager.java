/*
 * 管理员操作日志  manager 实现类
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

import cn.com.softvan.bean.logs.AdspUserLogsBean;
import cn.com.softvan.common.IdUtils;
import cn.com.softvan.dao.IAdspUserLogsDao;
import cn.com.softvan.dao.entity.AdspUserLogs;
import cn.com.softvan.service.BaseManager;
import cn.com.softvan.service.IUserLogsManager;

/**
 * 管理员操作日志 manager 实现类
 * 
 * @author {wuxiaogang}
 * 
 */
public class UserLogsManager extends BaseManager implements IUserLogsManager {
	/** 日志 */
	private static final transient Logger log = Logger
			.getLogger(UserLogsManager.class);

	/** 默认构造器 */
	public UserLogsManager() {

	}
	/**
	 * 管理员操作日志表DAO 接口类
	 */
	private IAdspUserLogsDao adspUserLogsDao;
	
	/**
	 * 保存管理员操作日志
	 * @param user_id 用户ID
	 * @param type 操作类型   I 新增信息 E 信息修改 D 信息删除 R 信息恢复
	 * @param note
	 * @param ip
	 */
	public void saveUserLogs(String user_id,String type,String note,String ip) {
		try {
			AdspUserLogs dto = new AdspUserLogs();
			// id
			dto.setId(IdUtils.createUUID(32));
			// 用户ID
			dto.setUser_id(user_id);
			// 类型
			dto.setType(type);
			// 描述
			dto.setNote(note);
			// 数据输入日期
			//-----------------------
			// 建立者ID
			dto.setCreate_id(user_id);
			// 建立者IP
			dto.setCreate_ip(ip);
			// --保存
			adspUserLogsDao.insertUserLogs(dto);
		} catch (Exception e) {
			log.error("保存管理员操作日志出错!", e);
		}
	}

	/**
	 * 删除管理员操作日志
	 * 
	 * @param bean
	 * @return
	 */
	public String deleteUserLogs(AdspUserLogsBean bean) {
		String msg = "1";
		try {
			AdspUserLogs dto = new AdspUserLogs();
			//id
			dto.setId(bean.getId());
			//--删除
			adspUserLogsDao.deleteUserLogs(dto);
		} catch (Exception e) {
			msg="保存管理员操作日志出错!";
			log.error(msg, e);
		}
		return msg;
	}

	/**
	 * 分页展示管理员操作日志
	 * 
	 * @param bean
	 * @return
	 */
	public List<AdspUserLogsBean> findAdspUserLogsbeanIsPage(
			AdspUserLogsBean bean) {
		List<AdspUserLogsBean> beans = null;
		try {
			AdspUserLogs dto=new AdspUserLogs();
			//id
			dto.setId(bean.getId());
			// 用户ID
			dto.setUser_id(bean.getUser_id());
			// 类型
			dto.setType(bean.getType());
			// 描述
			dto.setNote(bean.getNote());
			// 数据输入日期
			dto.setDate_created(bean.getDate_created());
			// 建立者ID
			dto.setCreate_id(bean.getCreate_id());
			// 建立者IP
			dto.setCreate_ip(bean.getCreate_ip());
			//分页对象
			dto.setPageinfo(bean.getPageinfo());
			//时间1
			dto.setDate1(bean.getDate1());
			//时间2
			dto.setDate2(bean.getDate2());
			//run
			beans=adspUserLogsDao.findAdspUserLogsbeanIsPage(dto);
		} catch (Exception e) {
			log.error("管理员操作日志筛选显示,数据库处理出错!", e);
		}
		return beans;
	}

	/**
	 * 管理员操作日志 详情
	 * 
	 * @param bean
	 * @return
	 */
	public AdspUserLogsBean findAdspUserLogsbeanById(AdspUserLogsBean bean) {
		AdspUserLogsBean bean1 = null;
		//TODO-------待完成
		return bean1;
	}

	/**
	 * 管理员操作日志表DAO 接口类取得
	 * @return 管理员操作日志表DAO 接口类
	 */
	public IAdspUserLogsDao getAdspUserLogsDao() {
	    return adspUserLogsDao;
	}

	/**
	 * 管理员操作日志表DAO 接口类设定
	 * @param adspUserLogsDao 管理员操作日志表DAO 接口类
	 */
	public void setAdspUserLogsDao(IAdspUserLogsDao adspUserLogsDao) {
	    this.adspUserLogsDao = adspUserLogsDao;
	}
}
