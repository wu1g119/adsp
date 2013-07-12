/*
 * 数据删除服务(配置) ActionClass
 *
 * VERSION  DATE        BY              REASON
 * -------- ----------- --------------- ------------------------------------------
 * 1.00     2013.03.08  wuxiaogang           程序・发布
 * -------- ----------- --------------- ------------------------------------------
 * Copyright 2013 adsp System. - All Rights Reserved.
 *
 */
package cn.com.softvan.web.action.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import cn.com.softvan.bean.config.AdspServiceConfigInfoBean;
import cn.com.softvan.bean.config.ConfigJsonBean;
import cn.com.softvan.bean.config.DbConfigBean;
import cn.com.softvan.bean.sourcedb.TableColumnsBean;
import cn.com.softvan.bean.user.AdspUserInfoBean;
import cn.com.softvan.common.CommonConstant;
import cn.com.softvan.common.JsonUtils;
import cn.com.softvan.common.StrUtils;
import cn.com.softvan.common.Validator;
import cn.com.softvan.service.IServiceConfigManager;
import cn.com.softvan.service.sourcedb.ISourceDataManager;
import cn.com.softvan.web.action.BaseAction;
/**
 * 数据删除服务(配置)
 * @author {wuxiaogang}
 *
 */
public class CX005Action  extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7079166727262506587L;
	private static final transient Logger log = Logger
			.getLogger(CX005Action.class);

	/** 默认的构造函数 */
	public CX005Action() {
		log.info("CX005Action constructed");
	}

	/** 数据来源  service类 */
	private ISourceDataManager sourceDataManager;
	/** 服务配置业务处理类 */
	private IServiceConfigManager serviceConfigManager;
	/**服务配置Bean*/
	private AdspServiceConfigInfoBean bean;
	/**ID*/
	private String id;
	/**数据库名称集合*/
	private String[] dbs;
	/***/
	private String[] tables;
	/**
	 * <p>
	 * 初始化处理。
	 * </p>
	 * <ol>
	 * [功能概要] <div>初始化处理。</div>
	 * </ol>
	 * 
	 * @return 转发字符串
	 */
	public String init() throws Exception {
		log.info("CX005Action init");
		return "init";
	}
	/**
	 * <p>
	 * 数据库列表。
	 * </p>
	 * <ol>
	 * [功能概要] <div>数据库列表。</div>
	 * </ol>
	 * 
	 * @return 转发字符串
	 */
	public String dblist() throws Exception {
		log.info("CX005Action dblist");
		//数据库列表
		request.setAttribute("dbs", sourceDataManager.findDbList(null));
		//获取已经配置的表列表
		if(!Validator.isEmpty(id)){
			AdspServiceConfigInfoBean bean=new AdspServiceConfigInfoBean();
			bean.setId(id);
			bean=serviceConfigManager.findAdspServiceConfigInfoById(bean);
			if(bean!=null){
				//TODO--old_dbs
				ConfigJsonBean old_info=JsonUtils.jsonToBean2(bean.getConfig());
				if(old_info!=null){
					request.setAttribute("old_dbs",old_info.getDbs());
				}
			}
		}
		return "dblist";
	}
	/**
	 * <p>
	 * 数据表列表。
	 * </p>
	 * <ol>
	 * [功能概要] <div>数据表列表。</div>
	 * </ol>
	 * 
	 * @return 转发字符串
	 */
	public String list1() throws Exception {
		log.info("CX005Action list1");
		
		List<TableColumnsBean> tables=sourceDataManager.findTableList(dbs);
		request.setAttribute("tables",tables);
		//获取已经配置的表列表
		if(!Validator.isEmpty(id)){
			AdspServiceConfigInfoBean bean=new AdspServiceConfigInfoBean();
			bean.setId(id);
			bean=serviceConfigManager.findAdspServiceConfigInfoById(bean);
			if(bean!=null){
				//TODO--old_tables
				ConfigJsonBean old_info=JsonUtils.jsonToBean2(bean.getConfig());
				if(old_info!=null){
					request.setAttribute("old_tables", old_info.getTables());
				}
			}
		}
		return "list1";
	}
	/**
	 * <p>
	 * 数据表 字段列表。
	 * </p>
	 * <ol>
	 * [功能概要] <div>数据表 字段列表。</div>
	 * </ol>
	 * 
	 * @return 转发字符串
	 */
	public String list2() throws Exception {
		log.info("CX005Action list2");
		// 获取表名称列表
		tables=request.getParameterValues("tableName");
		//set
		request.setAttribute("maps",sourceDataManager.getTableInfoMaps(tables));
		//获取已经配置的详细信息
		if(!Validator.isEmpty(id)){
			AdspServiceConfigInfoBean bean=new AdspServiceConfigInfoBean();
			bean.setId(id);
			bean=serviceConfigManager.findAdspServiceConfigInfoById(bean);
			if(bean!=null){
				//TODO--old_info
				request.setAttribute("old_info", JsonUtils.jsonToBean2(bean.getConfig()));
			}
		}
		return "list2";
	}
	/**
	 * <p>
	 * 显示 删除服务结果
	 * </p>
	 * <ol>
	 * [功能概要] <div>显示 删除服务结果。</div>
	 * </ol>
	 * 
	 * @return 转发字符串
	 */
	public String configInfo() throws Exception {
		log.info("CX005Action configInfo");
		//存放数据删除服务配置信息 BEAN CLASS
		DbConfigBean dbConfigBean=new DbConfigBean();
		/****************************************************************************************************/
		//TODO--输出信息配置--
		//表列表
		String[] output_table_names=request.getParameterValues("output_table_name");
		//字段列表
		String[] output_columns_names=request.getParameterValues("output_columns_name");
		//字段类型
		Map<String,String> output_columns_types=new HashMap<String,String>();
		//字段备注
		Map<String,String> output_columns_comments=new HashMap<String,String>();
		//字段别名
		Map<String,String> output_columns_alias=new HashMap<String,String>();
		if(output_columns_names!=null){
			//取得 选中字段的,类型 备注 别名
			for(String str:output_columns_names){
				//类型
				output_columns_types.put(str, request.getParameter("output_columns_type_"+StrUtils.replaceAll(str,"\\.", "_")));
				//备注
				output_columns_comments.put(str, request.getParameter("output_columns_comment_"+StrUtils.replaceAll(str,"\\.", "_")));
				//别名
				output_columns_alias.put(str, request.getParameter("output_columns_alias_"+StrUtils.replaceAll(str,"\\.", "_")));
			}
		}
		/****************************************************************************************************/
		//TODO--表连接关系配置--
		//主表名
		String main_table_name=request.getParameter("main_table_name");
		//从表名---标记
		String[] join_infos=request.getParameterValues("join_info");
		//从表--连接符
		Map<String,String> join_table_way=new HashMap<String,String>();
		//从表--表名
		Map<String,String> join_table_name=new HashMap<String,String>();
		//从表--连接sql
		Map<String,String> join_table_sql=new HashMap<String,String>();
		if(join_infos!=null){
			//取得 从表 连接符, 表名,sql
			for(String str:join_infos){
				//连接符
				join_table_way.put(str, request.getParameter("join_table_way_"+str));
				//表名
				join_table_name.put(str, request.getParameter("join_table_name_"+str));
				//sql
				join_table_sql.put(str, request.getParameter("join_table_sql_"+str));
			}
		}
		/****************************************************************************************************/
		//TODO--查询参数配置--
		//数据查询条件(固定参数)
		String sql_where=request.getParameter("sql_where");
		//数据查询条件(活动参数)
		//表列表
		String[] input_table_names=request.getParameterValues("input_table_name");
		//字段列表
		String[] input_columns_names=request.getParameterValues("input_columns_name");
		//字段类型
		Map<String,String> input_columns_types=new HashMap<String,String>();
		//字段备注
		Map<String,String> input_columns_comments=new HashMap<String,String>();
		//字段别名
		Map<String,String> input_columns_alias=new HashMap<String,String>();
		//默认值 标记
		Map<String,String> input_columns_is_vals=new HashMap<String,String>();
		//默认值
		Map<String,String> input_columns_values=new HashMap<String,String>();
		//连接符
		Map<String,String> input_columns_ways=new HashMap<String,String>();
		if(input_columns_names!=null){
			//取得 选中字段的,类型 备注 别名
			for(String str:input_columns_names){
				//类型
				input_columns_types.put(str, request.getParameter("input_columns_type_"+StrUtils.replaceAll(str,"\\.", "_")));
				//备注
				input_columns_comments.put(str, request.getParameter("input_columns_comment_"+StrUtils.replaceAll(str,"\\.", "_")));
				//别名
				input_columns_alias.put(str, request.getParameter("input_columns_alias_"+StrUtils.replaceAll(str,"\\.", "_")));
				//默认值 标记
				input_columns_is_vals.put(str, request.getParameter("input_columns_is_val_"+StrUtils.replaceAll(str,"\\.", "_")));
				//默认值 标记
				input_columns_values.put(str, request.getParameter("input_columns_value_"+StrUtils.replaceAll(str,"\\.", "_")));
				//连接符
				input_columns_ways.put(str, request.getParameter("input_columns_way_"+StrUtils.replaceAll(str,"\\.", "_")));
			}
		}
		//TODO--排序信息配置--
		//数据排序
		String sql_order=request.getParameter("sql_order");
		
		/* 数据库名称集合 */
		dbConfigBean.setDbs(dbs);
		/* 数据库表名称集合 */
		dbConfigBean.setTable_names(tables);
		/* 表列表 */
		dbConfigBean.setOutput_table_names(output_table_names);
		/* 字段列表 */
		dbConfigBean.setOutput_columns_names(output_columns_names);
		/* 字段类型 */
		dbConfigBean.setOutput_columns_types(output_columns_types);
		/* 字段备注 */
		dbConfigBean.setOutput_columns_comments(output_columns_comments);
		/* 字段别名 */
		dbConfigBean.setOutput_columns_alias(output_columns_alias);
		/* 主表名 */
		dbConfigBean.setMain_table_name(main_table_name);
		/* 从表名---标记 */
		dbConfigBean.setJoin_infos(join_infos);
		/* 从表--连接符 */
		dbConfigBean.setJoin_table_way(join_table_way);
		/* 从表--表名 */
		dbConfigBean.setJoin_table_name(join_table_name);
		/* 从表--连接sql */
		dbConfigBean.setJoin_table_sql(join_table_sql);
		/* 数据查询条件(固定参数) */
		dbConfigBean.setSql_where(sql_where);
		/* 表列表 */
		dbConfigBean.setInput_table_names(input_table_names);
		/* 字段列表 */
		dbConfigBean.setInput_columns_names(input_columns_names);
		/* 字段类型 */
		dbConfigBean.setInput_columns_types(input_columns_types);
		/* 字段备注 */
		dbConfigBean.setInput_columns_comments(input_columns_comments);
		/* 字段别名 */
		dbConfigBean.setInput_columns_alias(input_columns_alias);
		/* 默认值 标记 */
		dbConfigBean.setInput_columns_is_vals(input_columns_is_vals);
		/* 默认值 */
		dbConfigBean.setInput_columns_values(input_columns_values);
		/* 连接符 */
		dbConfigBean.setInput_columns_ways(input_columns_ways);
		/* 数据排序 */
		dbConfigBean.setSql_order(sql_order);
		/****************************************************************************************************/
		//获取sql
		request.setAttribute("sql", serviceConfigManager.getSQl("D",dbConfigBean));
//		//获取服务配置JSON
		String jsonConfg=serviceConfigManager.getJsonConfig("D",dbConfigBean);
		
		request.setAttribute("jsonConfg",jsonConfg);
		//获取服务参数JSON
		String jsonInput=serviceConfigManager.getJsonInput("D",dbConfigBean);
		
		request.setAttribute("jsonInput",jsonInput);
		//获取服务返回信息JSON
		String jsonOutput=serviceConfigManager.getJsonOutput("D",dbConfigBean);
		
		request.setAttribute("jsonOutput",jsonOutput);
		
		//获取主表与其数据库
		String[] mds=main_table_name.split("\\.");
		//主表所在数据库名称
		request.setAttribute("db_name", mds[0]);
		//主表名称
		request.setAttribute("db_table_name", mds[1]);
		
		//获取已经配置的详细信息
		if(!Validator.isEmpty(id)){
			AdspServiceConfigInfoBean bean=new AdspServiceConfigInfoBean();
			bean.setId(id);
			bean=serviceConfigManager.findAdspServiceConfigInfoById(bean);
			if(bean!=null){
				request.setAttribute("bean", bean);
			}
		}
		return "configInfo";
	}
	/**
	 * <p>
	 * 保存服务结果
	 * </p>
	 * <ol>
	 * [功能概要] <div>保存服务结果。</div>
	 * </ol>
	 * 
	 * @return 转发字符串
	 */
	public String saveConfigInfo() throws Exception {
		log.info("CX005Action saveConfigInfo");
		AdspUserInfoBean userBean=getAdminUserInfo();
		//创建用户ID
		bean.setCreate_id(userBean.getUser_id());
		//创建用户IP
		bean.setCreate_ip(getIpAddr());
		//修改用户ID
		bean.setUpdate_id(userBean.getUser_id());
		//修改用户IP
		bean.setUpdate_ip(getIpAddr());
		//服务信息bean
		getWriter().write(serviceConfigManager.saveOrUpdateAdspServiceConfigInfo(bean));
		return null;
	}
	/**
	 * <p>
	 * TestSql
	 * </p>
	 * <ol>
	 * [功能概要] <div>TestSql。</div>
	 * </ol>
	 * 
	 * @return 转发字符串
	 */
	public String testSql() throws Exception {
		log.info("CX005Action testSql");
		//test
		StringBuffer sql=new StringBuffer("");
		request.setAttribute("list", serviceConfigManager.TestSql(request.getParameter("bean.config"),sql));
		request.setAttribute("sql",sql);
		return "testSql";
	}
	/**
	 * 数据来源  service类取得
	 * @return 数据来源  service类
	 */
	public ISourceDataManager getSourceDataManager() {
	    return sourceDataManager;
	}
	/**
	 * 数据来源  service类设定
	 * @param sourceDataManager 数据来源  service类
	 */
	public void setSourceDataManager(ISourceDataManager sourceDataManager) {
	    this.sourceDataManager = sourceDataManager;
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
	 * 服务配置Bean取得
	 * @return 服务配置Bean
	 */
	public AdspServiceConfigInfoBean getBean() {
	    return bean;
	}
	/**
	 * 服务配置Bean设定
	 * @param bean 服务配置Bean
	 */
	public void setBean(AdspServiceConfigInfoBean bean) {
	    this.bean = bean;
	}
	/**
	 * ID取得
	 * @return ID
	 */
	public String getId() {
	    return id;
	}
	/**
	 * ID设定
	 * @param id ID
	 */
	public void setId(String id) {
	    this.id = id;
	}
	/**
	 * 数据库名称集合取得
	 * @return 数据库名称集合
	 */
	public String[] getDbs() {
	    return dbs;
	}
	/**
	 * 数据库名称集合设定
	 * @param dbs 数据库名称集合
	 */
	public void setDbs(String[] dbs) {
	    this.dbs = dbs;
	}
	/**
	 * tables取得
	 * @return tables
	 */
	public String[] getTables() {
	    return tables;
	}
	/**
	 * tables设定
	 * @param tables tables
	 */
	public void setTables(String[] tables) {
	    this.tables = tables;
	}
}
