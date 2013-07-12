/*
 * 子服务配置 (服务配置页面)ActionClass
 *
 * VERSION  DATE        BY              REASON
 * -------- ----------- --------------- ------------------------------------------
 * 1.00     2013.06.04  wuxiaogang           程序・发布
 * -------- ----------- --------------- ------------------------------------------
 * Copyright 2013 adsp System. - All Rights Reserved.
 *
 */
package cn.com.softvan.web.action.config.sub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import cn.com.softvan.bean.config.AdspServiceSubInfoBean;
import cn.com.softvan.bean.user.AdspUserInfoBean;
import cn.com.softvan.common.Validator;
import cn.com.softvan.dao.entity.AdspServiceConfigInfo;
import cn.com.softvan.service.IServiceConfigManager;
import cn.com.softvan.service.IServiceSubInfoManager;
import cn.com.softvan.web.action.BaseAction;
/**
 * 子服务配置 (服务配置页面)
 * @author {wuxiaogang}
 *
 */
public class CS002Action  extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4932264876200541720L;
	private static final transient Logger log = Logger
			.getLogger(CS002Action.class);

	/** 默认的构造函数 */
	public CS002Action() {
		log.info("CS002Action constructed");
	}
	/** 服务配置业务处理类 */
	private IServiceConfigManager serviceConfigManager;
	/** 子服务配置信息  业务处理类 */
	private IServiceSubInfoManager serviceSubInfoManager;
	/**
	 * <p>
	 * 子服务配置 初始化
	 * </p>
	 * <ol>
	 * [功能概要] <div>子服务配置 init。</div>
	 * </ol>
	 * 
	 * @return 转发字符串
	 */
	public String init() throws Exception {
		log.info("CS002Action config");
		AdspServiceConfigInfo dto=new AdspServiceConfigInfo();
		//未删除
		dto.setDel_flag("0");
		//(查询数据类型)服务
		dto.setType("Q");
		//get
		request.setAttribute("beans",serviceConfigManager.findAdspServiceConfigInfoList(dto));
		
		
		//
		String id=request.getParameter("id");
		if(Validator.notEmpty(id)){
			AdspServiceSubInfoBean subbean=new AdspServiceSubInfoBean();
			//服务id
			subbean.setConfig_id(id);
			//获取配置信息
			List<AdspServiceSubInfoBean> beans=serviceSubInfoManager.findAdspServiceSubInfoBeanList(subbean);
			// 遍历List 按照类型分类组装map对象
			Map<String, List<AdspServiceSubInfoBean>> map = new HashMap<String, List<AdspServiceSubInfoBean>>();
			for (AdspServiceSubInfoBean bean : beans) {
				List<AdspServiceSubInfoBean> tempList = map.get(bean.getConfig_id());
				if (tempList == null) {
					tempList = new LinkedList<AdspServiceSubInfoBean>();
					map.put(bean.getConfig_id(), tempList);
				}
				tempList.add(bean);
			}
			// 已配置 子服务列表
			request.setAttribute("map", map);
		}
		return "init";
	}
	/**
	 * <p>
	 * 子服务配置 格式预览
	 * </p>
	 * <ol>
	 * [功能概要] <div>子服务配置 格式预览。</div>
	 * </ol>
	 * 
	 * @return 转发字符串
	 */
	public String view() throws Exception {
		log.info("CS002Action view");
		//主服务
		String mainId=request.getParameter("mainId");
		//子服务
		String[] subIds=request.getParameterValues("subId");
		//
		request.setAttribute("configForamt","功能待完成!");
		return "view";
	}
	/**
	 * <p>
	 * 子服务配置 保存
	 * </p>
	 * <ol>
	 * [功能概要] <div>子服务配置 保存。</div>
	 * </ol>
	 * 
	 * @return 转发字符串
	 */
	public String save() throws Exception {
		log.info("CS002Action save");
		AdspUserInfoBean userBean=getAdminUserInfo();
		//主服务
		String mainId=request.getParameter("mainId");
		//子服务
		String[] subIds=request.getParameterValues("subId");
		//
		AdspServiceSubInfoBean bean=new AdspServiceSubInfoBean();
		//服务id
		 bean.setConfig_id(mainId);
		List<AdspServiceSubInfoBean> beans=null;
		if(subIds!=null){
			beans=new ArrayList<AdspServiceSubInfoBean>();
			AdspServiceSubInfoBean bean1=null;
			for(int i=0;i<subIds.length;i++){
				bean1=new AdspServiceSubInfoBean();
				//子服务id
				bean1.setSub_config_id(subIds[i]);
				//节点名称
				bean1.setNode_name(request.getParameter("node1"+subIds[i]));
				//创建人id
				bean1.setCreate_id(userBean.getUser_id());
				//创建人ip
				bean1.setCreate_ip(getIpAddr());
				//add
				beans.add(bean1);
			}
		}
		String msg="1";
		try{
			msg=serviceSubInfoManager.saveOrUpdateServiceSubInfo(bean, beans);
		} catch (Exception e) {
			msg="子服务配置信息数据库操作异常!";
			log.error("子服务配置信息数据库操作异常:", e);
		}
		getWriter().print(msg);
		return null;
	}
	/**
	 * 服务配置业务处理类取得
	 * @return 服务配置业务处理类
	 */
	public IServiceConfigManager getServiceConfigManager() {
	    return serviceConfigManager;
	}
	/**
	 * 服务配置业务处理类设定
	 * @param serviceConfigManager 服务配置业务处理类
	 */
	public void setServiceConfigManager(IServiceConfigManager serviceConfigManager) {
	    this.serviceConfigManager = serviceConfigManager;
	}
	/**
	 * 子服务配置信息  业务处理类取得
	 * @return 子服务配置信息  业务处理类
	 */
	public IServiceSubInfoManager getServiceSubInfoManager() {
	    return serviceSubInfoManager;
	}
	/**
	 * 子服务配置信息  业务处理类设定
	 * @param serviceSubInfoManager 子服务配置信息  业务处理类
	 */
	public void setServiceSubInfoManager(IServiceSubInfoManager serviceSubInfoManager) {
	    this.serviceSubInfoManager = serviceSubInfoManager;
	}
}
