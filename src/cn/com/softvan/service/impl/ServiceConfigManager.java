/*
 * 服务配置  manager 实现类
 *
 * VERSION  DATE        BY              REASON
 * -------- ----------- --------------- ------------------------------------------
 * 1.00     2013.02.22  wuxiaogang           程序・发布
 * -------- ----------- --------------- ------------------------------------------
 * Copyright 2013 adsp System. - All Rights Reserved.
 *
 */
package cn.com.softvan.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import cn.com.softvan.bean.config.AdspServiceConfigInfoBean;
import cn.com.softvan.bean.config.ConfigJsonBean;
import cn.com.softvan.bean.config.DbConfigBean;
import cn.com.softvan.bean.config.ToInfoBean;
import cn.com.softvan.common.CommonConstant;
import cn.com.softvan.common.DbTypeUtils;
import cn.com.softvan.common.IdUtils;
import cn.com.softvan.common.JsonUtils;
import cn.com.softvan.common.StrUtils;
import cn.com.softvan.common.Validator;
import cn.com.softvan.dao.IAdspServiceConfigInfoDao;
import cn.com.softvan.dao.entity.AdspServiceConfigInfo;
import cn.com.softvan.dao.sourcedb.ISourceDataDao;
import cn.com.softvan.service.BaseManager;
import cn.com.softvan.service.IServiceConfigManager;
import cn.com.softvan.web.tag.PageInfo;
/**
 * 服务配置  manager 实现类
 * @author {wuxiaogang}
 *
 */
public class ServiceConfigManager extends BaseManager implements IServiceConfigManager{
	/** 日志 */
	private static final transient Logger log = Logger
			.getLogger(ServiceConfigManager.class);

	/** 默认构造器 */
	public ServiceConfigManager() {

	}
	/**服务DAO*/
	private IAdspServiceConfigInfoDao adspServiceConfigInfoDao;
	/**DAO*/
	private ISourceDataDao sourceDataDao;
	/**
	 * 根据参数获取 服务sql
	 * @param sType Q查询U修改I新增D删除
	 * @param bean
	 * @return sql
	 */
	public String getSQl(String sType,DbConfigBean bean){
		//sql
		StringBuffer sql=new StringBuffer("");
		//TODO--数据查询服务--
		if("Q".equalsIgnoreCase(sType)){
			sql.append(getSQl_Q(bean));
		}else
		//TODO--数据修改服务--
		if("U".equalsIgnoreCase(sType)){
			sql.append(getSQl_U(bean));
		}else
		//TODO--数据新增服务--
		if("I".equalsIgnoreCase(sType)){
			sql.append(getSQl_I(bean));
		}else
		//TODO--数据删除服务--
		if("D".equalsIgnoreCase(sType)){
			sql.append(getSQl_D(bean));
		}
		return sql.toString();
	}
	/**
	 * 获取服务配置json
	 * @param sType Q查询U修改I新增D删除
	 * @param bean
	 * @return json
	 */
	public String getJsonConfig(String sType,DbConfigBean bean){
		//demo /META-INF/接口服务配置格式*.txt
		//sql
		StringBuffer json=new StringBuffer("{");
		/**dbs*******************************************************/
		json.append("\"dbs\":[");
		//数据库集合
		String[] dbs=bean.getDbs();
		if(dbs!=null){
			//遍历
			for(int i=0;i<dbs.length;i++){
				json.append("{\"name\":\""+dbs[i]+"\"}");
				if(i<(dbs.length-1)){
					json.append(",");
				}
			}
		}
		json.append("],");
		/**tables*******************************************************/
		json.append("\"tables\":[");
		//数据表集合
		String[] table_names=bean.getTable_names();
		if(table_names!=null){
			//遍历
			for(int i=0;i<table_names.length;i++){
				json.append("{\"name\":\""+table_names[i]+"\"}");
				if(i<(table_names.length-1)){
					json.append(",");
				}
			}
		}
		json.append("],");
		/**outputs*******************************************************/
		StringBuffer outputs_sql=new StringBuffer("");
		json.append("\"outputs\":[");
		/*字段列表 */
		String[] output_columns_names=bean.getOutput_columns_names();
		//别名
		Map<String, String> output_columns_alias=bean.getOutput_columns_alias();
		//类型
		Map<String, String> output_columns_types=bean.getOutput_columns_types();
		//图文分离标记
		Map<String,String> output_columns_itsts=bean.getOutput_columns_itsts();
		//图文分离字段汇总
		List<String> itsts=new ArrayList<String>();
		//(子)入参 标记
		Map<String,String> output_columns_osubs=bean.getOutput_columns_osubs();
		//(子)入参 字段汇总
		List<String> osubs=new ArrayList<String>();
		//数据库字段处理函数(#self代表当前字段本身)
		Map<String, String> output_columns_funs=bean.getOutput_columns_funs();
		if(output_columns_names!=null){
			for(int i=0;i<output_columns_names.length;i++){
				//数据库字段处理函数(#self代表当前字段本身)
				String fun=output_columns_funs.get(output_columns_names[i]);
				if(Validator.notEmpty(fun)){
					outputs_sql.append(StrUtils.replaceAll(fun, "#self", output_columns_names[i])+" as "+output_columns_alias.get(output_columns_names[i]));
				}else{
					outputs_sql.append(output_columns_names[i]+" as "+output_columns_alias.get(output_columns_names[i]));
				}
				//name
				json.append("{\"name\":\""+output_columns_names[i]+"\",");
				//type
				json.append("\"type\":\""+DbTypeUtils.typeCure(output_columns_types.get(output_columns_names[i]))+"\",");
				//itst 图文分离标记
				if(output_columns_itsts.get(output_columns_names[i])!=null){
					json.append("\"itst\":\"1\",");
					itsts.add(output_columns_alias.get(output_columns_names[i]));
				}
				//(子)入参 标记
				if(output_columns_osubs.get(output_columns_names[i])!=null){
					json.append("\"osub\":\"1\",");
					osubs.add(output_columns_alias.get(output_columns_names[i]));
				}
				//数据库字段处理函数(#self代表当前字段本身)
				if(fun!=null){
					json.append("\"fun\":\""+fun+"\",");
				}
				//alias
				json.append("\"alias\":\""+output_columns_alias.get(output_columns_names[i])+"\"}");
				if(i<(output_columns_names.length-1)){
					json.append(",");
					outputs_sql.append(",");
				}
			}
		}
		json.append("],");
		/**itsts*******************************************************/
		json.append("\"itsts\":[");
		if(itsts!=null){
		 for (int i=0;i<itsts.size();i++) {
	          json.append("{\"alias\":\""+itsts.get(i)+"\"}");
	          if(i<(itsts.size()-1)){
					json.append(",");
			  }
		 }
		}
		json.append("],");
		/**osubs*******************************************************/
		json.append("\"osubs\":[");
		if(osubs!=null){
		 for (int i=0;i<osubs.size();i++) {
	          json.append("{\"alias\":\""+osubs.get(i)+"\"}");
	          if(i<(osubs.size()-1)){
					json.append(",");
			  }
		 }
		}
		json.append("],");
		/**joins_main*******************************************************/
		/*主表名 */
		json.append("\"joins_main\":\""+bean.getMain_table_name()+"\",");
		/**joins_other*******************************************************/
		StringBuffer joins_other_sql=new StringBuffer("");
		json.append("\"joins_other\":[");
		//从表-标记
		String[] join_infos=bean.getJoin_infos();
		//从表-连接符
		Map<String,String> join_table_way=bean.getJoin_table_way();
		//从表-名称
		Map<String,String> join_table_name=bean.getJoin_table_name();
		//从表-关联sql
		Map<String,String> join_table_sql=bean.getJoin_table_sql();
		if(join_infos!=null&&join_infos.length>0){
			for(int i=0;i<join_infos.length;i++){
				String str=join_infos[i];
				json.append("{\"name\":\""+join_table_name.get(str)+"\",\"way\":\""+join_table_way.get(str)+"\",\"sql\":\""+join_table_sql.get(str)+"\"}");
				
				joins_other_sql.append(" "+join_table_way.get(str)+" "+join_table_name.get(str)+" on "+join_table_sql.get(str));
				
				if(i<(join_infos.length-1)){
					json.append(",");
				}
			}
			
		}
		json.append("],");
		/**where*******************************************************/
		json.append("\"where\":\""+bean.getSql_where()+"\",");
		
		/**inputs*******************************************************/
		StringBuffer inputs_sql=new StringBuffer("");
		json.append("\"inputs\":[");
		//参数字段列表
		String[] input_columns_names=bean.getInput_columns_names();
		/* 字段类型 */
		Map<String, String> input_columns_types=bean.getInput_columns_types();
		/* 别名*/
		Map<String, String> input_columns_alias=bean.getInput_columns_alias();
		/* 默认值 标记 */
		Map<String, String> input_columns_is_vals=bean.getInput_columns_is_vals();
		/* 默认值 */
		Map<String, String> input_columns_values=bean.getInput_columns_values();
		/* 连接符 */
		Map<String, String> input_columns_ways=bean.getInput_columns_ways();
		//(主)出参 标记
		Map<String,String> input_columns_isubs=bean.getInput_columns_isubs();
		//(主)出参  字段汇总
		List<String> isubs=new ArrayList<String>();
		//排序字段obc[order by columns]标记 
		Map<String,String> input_columns_obcs=bean.getInput_columns_obcs();
		//入参必填 标记
		Map<String,String> input_columns_mbs=bean.getInput_columns_mbs();
		//入参必填  字段汇总
		List<String> mbs=new ArrayList<String>();
		if(input_columns_names!=null){
			String is_val;
			int num_count=0;
			for(int i=0;i<input_columns_names.length;i++){
				
				is_val=input_columns_is_vals.get(input_columns_names[i]);
				//name
				json.append("{\"name\":\""+input_columns_names[i]+"\",");
				//type
				json.append("\"type\":\""+DbTypeUtils.typeCure(input_columns_types.get(input_columns_names[i]))+"\",");
				//alias
				json.append("\"alias\":\""+input_columns_alias.get(input_columns_names[i])+"\",");
				//is_default
				
				if(is_val!=null){
					json.append("\"is_val\":\"1\",");
					//---------------s--------------------------
					if(num_count>0){
						inputs_sql.append(" and ");
					}
					inputs_sql.append(""+input_columns_names[i]+" "+input_columns_ways.get(input_columns_names[i]));
					//判断类型
					if(DbTypeUtils.isColumnType(DbTypeUtils.dbType.Mysql,DbTypeUtils.typeCure(input_columns_types.get(input_columns_names[i])))){
						//数值型
						inputs_sql.append(" "+input_columns_values.get(input_columns_names[i]));
					}else{
						//字符串型
						inputs_sql.append(" '"+input_columns_values.get(input_columns_names[i])+"'");
					}
					num_count++;
					//---------------e--------------------------
					//value
					json.append("\"value\":\""+input_columns_values.get(input_columns_names[i])+"\",");
				}
				//(主)出参 标记
				if(input_columns_isubs.get(input_columns_names[i])!=null){
					json.append("\"isub\":\"1\",");
					isubs.add(input_columns_alias.get(input_columns_names[i]));
				}
				///排序字段obc[order by columns]标记
				if(input_columns_obcs.get(input_columns_names[i])!=null){
					json.append("\"obc\":\"1\",");
				}
				//入参必填 标记
				if(input_columns_mbs.get(input_columns_names[i])!=null){
					json.append("\"mb\":\"1\",");
					mbs.add(input_columns_alias.get(input_columns_names[i]));
				}
				//way
				json.append("\"way\":\""+input_columns_ways.get(input_columns_names[i])+"\"}");
				
				if(i<(input_columns_names.length-1)){
					json.append(",");
				}
			}
		}
		json.append("],");
		/**isubs*******************************************************/
		json.append("\"isubs\":[");
		if(isubs!=null){
		 for (int i=0;i<isubs.size();i++) {
	          json.append("{\"alias\":\""+isubs.get(i)+"\"}");
	          if(i<(isubs.size()-1)){
					json.append(",");
			  }
		 }
		}
		json.append("],");
		/**mbs*******************************************************/
		json.append("\"mbs\":[");
		if(mbs!=null){
		 for (int i=0;i<mbs.size();i++) {
	          json.append("{\"alias\":\""+mbs.get(i)+"\"}");
	          if(i<(mbs.size()-1)){
					json.append(",");
			  }
		 }
		}
		json.append("],");
		/**order*******************************************************/
		json.append("\"order\":\""+bean.getSql_order()+"\",");
		/**outputs_sql*************************************************/
		json.append("\"outputs_sql\":\""+outputs_sql+"\",");
		/**joins_other_sql*************************************************/
		json.append("\"joins_other_sql\":\""+joins_other_sql+"\",");
		/**inputs_sql*************************************************/
		json.append("\"inputs_sql\":\""+inputs_sql+"\"");
		
		json.append("}");
		//to
		return json.toString();
	}
	/**
	 * 获取服务参数json
	 * @param sType Q查询U修改I新增D删除
	 * @param bean
	 * @return json
	 */
	public String getJsonInput(String sType,DbConfigBean bean){
		//{"system":"iTravles","pageSize":"100","pageNum":"1","serviceName":"服务名称","parameters1":"参数","obcs":{"别名":"1","别名":"0"}}
		StringBuffer json=new StringBuffer("{");
		//系统名称(用于统计)
		json.append("\"system\":\"?\",");
		//每个数据页的大小
		json.append("\"pageSize\":\"?\",");
		//数据页码
		json.append("\"pageNum\":\"?\",");
		//服务名称
		json.append("\"serviceName\":\"?\"");
		//参数字段列表
		String[] input_columns_names=bean.getInput_columns_names();
		//参数字段别名
		Map<String, String> input_columns_alias=bean.getInput_columns_alias();
		if(input_columns_names!=null){
			for(int i=0;i<input_columns_names.length;i++){
				if(i==0){
					json.append(",");
				}
				json.append("\""+input_columns_alias.get(input_columns_names[i])+"\":\"?\"");
				if(i<(input_columns_names.length-1)){
					json.append(",");
				}
			}
		}
		//活动排序字段
		Map<String, String> input_columns_obcs=bean.getInput_columns_obcs();
		if(input_columns_obcs!=null && input_columns_obcs.size()>0){
			json.append(",\"obcs\":{");
			Iterable<Entry<String, String>> m=input_columns_obcs.entrySet();
			int i=1;
			for(Entry<String, String> e:m){
				if(e!=null){
					json.append("\""+input_columns_alias.get(e.getKey())+"\":\"?\"");
					if(i<(input_columns_obcs.size())){
						json.append(",");
					}
					i++;
				}
			}
			json.append("}");
		}
		json.append("}");
		return json.toString();
	}
	/**
	 * 获取服务返回信息json
	 * @param sType Q查询U修改I新增D删除
	 * @param bean
	 * @return json
	 */
	public String getJsonOutput(String sType,DbConfigBean bean){
		/*
		 * {"pageSize":"10","totalCount":"2","totalPage":"1","currentCount":"2","currentPage":"1",
			"item":[{"name":"名称1"}]}
		 */
		StringBuffer json=new StringBuffer("{");
		//每个数据页的大小
		json.append("\"pageSize\":\"?\",");
		//总的数据条数
		json.append("\"totalCount\":\"?\",");
		//总的数据页数
		json.append("\"totalPage\":\"?\",");
		//当前页的数据条数
		json.append("\"currentCount\":\"?\",");
		//当前数据页码
		json.append("\"currentPage\":\"?\",");
		//信息
		json.append("\"item\":[");
		/*字段列表 */
		String[] output_columns_names=bean.getOutput_columns_names();
		//别名
		Map<String, String> output_columns_alias=bean.getOutput_columns_alias();
		//图文分离 标记
		Map<String, String> output_columns_itsts=bean.getOutput_columns_itsts();
		if(output_columns_names!=null){
			json.append("{");
			for(int i=0;i<output_columns_names.length;i++){
				if("1".equals(output_columns_itsts.get(output_columns_names[i]))){
					//图文分离
					json.append("\""+output_columns_alias.get(output_columns_names[i])+"\":{");
					//文字信息
					json.append("\"txt\":\"?\"");
					//图片列表
					json.append(",\"img\":[{\"url\":\"?\",\"txt\":\"?\"}]");
					json.append("}");
				}else{
					//alias
					json.append("\""+output_columns_alias.get(output_columns_names[i])+"\":\"?\"");
				}
				if(i<(output_columns_names.length-1)){
					json.append(",");
				}
			}
			json.append("}");
		}
		json.append("]");
		json.append("}");
		return json.toString();
	}
	/**
	 * 修改或保存服务
	 * @param bean
	 * @return msg json
	 */
	public String saveOrUpdateAdspServiceConfigInfo(AdspServiceConfigInfoBean bean){
		String msg="{info:\"1\"}";
		try {
			//服务dto
			AdspServiceConfigInfo dto=new AdspServiceConfigInfo();
			//id >20
			if(!Validator.isEmpty(bean.getId())&& bean.getId().trim().length()>20){
				dto.setId(bean.getId());
			}
			//服务类型 1日志增量2影子表增量
			dto.setType(bean.getType());
			//服务名称
			dto.setName(bean.getName());
			//服务配置信息
			dto.setConfig(bean.getConfig());
			//服务状态
			dto.setStatus(bean.getStatus());
			//主表所在数据库名
			dto.setDb_name(bean.getDb_name());
			//主表名
			dto.setDb_table_name(bean.getDb_table_name());
			//备注
			dto.setNote(bean.getNote());
			//修改者IP
			dto.setUpdate_ip(bean.getUpdate_ip());
			//修改者ID
			dto.setUpdate_id(bean.getUpdate_id());
			//是否删除
			dto.setDel_flag(bean.getDel_flag());
			//判断服务是否存在
			if(dto.getId()!=null && adspServiceConfigInfoDao.isAdspServiceConfigInfoYN(dto)>0){
				//服务存在 
				//更新
				adspServiceConfigInfoDao.updateAdspServiceConfigInfo(dto);
				//记录管理员操作日志
				userLogsManager.saveUserLogs(bean.getUpdate_id(),"E","服务配置更新  adspServiceConfigInfo="+bean.getId(),bean.getUpdate_ip());
			}else{
				//服务不存在
				//生成ID
				dto.setId(IdUtils.createUUID(32));bean.setId(dto.getId());
				//VERSIONS
				dto.setVersion("1");
				//创建者IP
				dto.setCreate_ip(bean.getCreate_ip());
				//创建者ID
				dto.setCreate_id(bean.getCreate_id());
				//新增
				adspServiceConfigInfoDao.insertAdspServiceConfigInfo(dto);
				//记录管理员操作日志
				userLogsManager.saveUserLogs(bean.getUpdate_id(),"I","新增服务配置  adspServiceConfigInfo="+bean.getId(),bean.getUpdate_ip());
			}
			if("1".equals(jedisHelper.get("flag_updateChcheService"))){
				//TODO 更新服务配置 缓存信息
				updateChcheService(bean);
			}else{
				//TODO 更新服务配置 缓存信息
				updateChcheService(null);
			}
			//
			msg="{info:\"1\",id:\""+dto.getId()+"\"}";
		} catch (Exception e) {
			msg="{info:\"服务配置数据库操作异常!\"}";
			log.error("服务配置数据库操作异常:", e);
		}
		return msg;
	}
	/**
	 * 更新服务配置 缓存信息
	 * @param configBean
	 */
	public void updateChcheService(AdspServiceConfigInfoBean configBean){
		if(configBean!=null){
				try {
					//TODO 保存  服务配置信息 缓存
					jedisHelper.set("service_"+configBean.getName(),(ConfigJsonBean)JsonUtils.jsonToBean2(configBean.getConfig()),CommonConstant.JEDIS_TIME_OUT);
//					cacheHelper.set("service_"+configBean.getName(),MemcachedConstants.DEFAULT_TIMEOUT,(ConfigJsonBean)JsonUtils.jsonToBean2(configBean.getConfig()));
				} catch (Exception e) {
					log.error("保存服务配置信息缓存失败!",e);
				}
		}else{
			//缓存存在标记
			jedisHelper.set("flag_updateChcheService", "1");
			
			AdspServiceConfigInfo dto=new AdspServiceConfigInfo();
			//详情
			dto.setXx_flag(null);
			//获取服务列表
			List<AdspServiceConfigInfoBean> list=this.findAdspServiceConfigInfoList(dto);
			if(list!=null){
				//遍历服务集合
				for(AdspServiceConfigInfoBean bean:list){
					try {
						//TODO 保存  服务配置信息 缓存
						jedisHelper.set("service_"+bean.getName(),(ConfigJsonBean)JsonUtils.jsonToBean2(bean.getConfig()),CommonConstant.JEDIS_TIME_OUT);
//						cacheHelper.set("service_"+bean.getName(),MemcachedConstants.DEFAULT_TIMEOUT,(ConfigJsonBean)JsonUtils.jsonToBean2(bean.getConfig()));
					} catch (Exception e) {
						log.error("保存服务配置信息缓存失败!",e);
					}

				}
			}
		}
		log.info("\n----------------------------更新服务配置 缓存信息------------------------\n");
	}
	/**
	 * 逻辑删除服务
	 * @param bean
	 * @return msg json
	 */
	public String logicDeleteAdspServiceConfigInfo(AdspServiceConfigInfoBean bean){
		String msg="1";
		try {
			//服务dto
			AdspServiceConfigInfo dto=new AdspServiceConfigInfo();
			//id >20
			if(!Validator.isEmpty(bean.getId())&& bean.getId().trim().length()>20){
				dto.setId(bean.getId());
			}
			System.out.println("dto=1=id-=="+dto.getId());
			//修改者IP
			dto.setUpdate_ip(bean.getUpdate_ip());
			//修改者ID
			dto.setUpdate_id(bean.getUpdate_id());
			//是否删除
			dto.setDel_flag(bean.getDel_flag());
			//判断服务是否存在
			if(dto.getId()!=null && adspServiceConfigInfoDao.isAdspServiceConfigInfoYN(dto)>0){
				//服务存在 
				//更新
				adspServiceConfigInfoDao.updateAdspServiceConfigInfo(dto);
				if("1".equals(bean.getDel_flag())){
					//记录管理员操作日志
					userLogsManager.saveUserLogs(bean.getUpdate_id(),"D","逻辑删除服务配置  adspServiceConfigInfo="+bean.getId(),bean.getUpdate_ip());
					//TODO  缓存更新 ========移除缓存===
//					System.out.println("dto=2=id-=="+dto.getId());
					AdspServiceConfigInfoBean configBean=adspServiceConfigInfoDao.findServiceNameById(dto);
					if(configBean!=null){
						jedisHelper.remove("service_"+configBean.getName());
					}
				}else{
					//记录管理员操作日志
					userLogsManager.saveUserLogs(bean.getUpdate_id(),"R","恢复服务配置  adspServiceConfigInfo="+bean.getId(),bean.getUpdate_ip());
					//TODO  缓存更新 ========添加缓存===
//					System.out.println("dto=3=id-=="+dto.getId());
					AdspServiceConfigInfoBean configBean=adspServiceConfigInfoDao.findAdspServiceConfigInfoById(dto);
					if(configBean!=null){
						jedisHelper.set("service_"+configBean.getName(),(ConfigJsonBean)JsonUtils.jsonToBean2(configBean.getConfig()),CommonConstant.JEDIS_TIME_OUT);
					}
				}
			}else{
				//服务不存在
				msg="操作失败!服务不存在!";
			}
			
		} catch (Exception e) {
			msg="服务配置数据库操作异常!";
			log.error("服务配置数据库操作异常:", e);
		}
		return msg;
	}
	/**
	 * 获取服务详情
	 * @param bean
	 * @return msg
	 */
	public AdspServiceConfigInfoBean findAdspServiceConfigInfoById(AdspServiceConfigInfoBean bean){
		try {
			if(bean!=null){
				//服务
				AdspServiceConfigInfo dto=new AdspServiceConfigInfo();
				//id
				dto.setId(bean.getId());
				//TODO--
				return adspServiceConfigInfoDao.findAdspServiceConfigInfoById(dto);
			}
		} catch (Exception e) {
			log.error("服务获取数据库异常!",e);
		}
		return null;
	}
	
	
	/**
     * <p>服务分页显示</p>
     * <ol>[功能概要]
     * <div>服务分页显示</div>
     * </ol>
     * @param page 
     * @return 
     * @throws Exception 数据库操作异常
     */
    public List<AdspServiceConfigInfoBean> findAdspServiceConfigInfoIsPage(AdspServiceConfigInfo dto){
    	try {
    		//TODO--
    		return adspServiceConfigInfoDao.findAdspServiceConfigInfoIsPage(dto);
		} catch (Exception e) {
			log.error("数据库数据处理错误", e);
		}
		return null;
    }
    /**
     * <p>服务 列表显示</p>
     * <ol>[功能概要]
     * <div>服务 列表显示</div>
     * </ol>
     * @param page 
     * @return 
     * @throws Exception 数据库操作异常
     */
    public List<AdspServiceConfigInfoBean> findAdspServiceConfigInfoList(AdspServiceConfigInfo dto){
    	try {
    		//TODO--
    		return adspServiceConfigInfoDao.findAdspServiceConfigInfoList(dto);
		} catch (Exception e) {
			log.error("数据库数据处理错误", e);
		}
		return null;
    }
    /**
	 * TestSQL
	 * @param sql
	 * @return msg
	 */
	public List<Map<?,?>> TestSql(String config,StringBuffer sqlObject){
		List<Map<?,?>> list=new ArrayList<Map<?,?>>();
		try {
			ConfigJsonBean bean=JsonUtils.jsonToBean2(config);
			/**返回参数*/
			List<ToInfoBean> outputs=bean.getOutputs();
			if(outputs!=null){
				Map<String,String> m=new HashMap<String,String>();
				for(ToInfoBean t:outputs){
					m.put(t.getAlias(),"xinxi");
				}
				list.add(m);
			}
			//
			Map map=new HashMap();
//			//select
			map.put("column", bean.getOutputs_sql());
			sqlObject.append(" select "+bean.getOutputs_sql());
//			//from 
			map.put("table", bean.getJoins_main());
			sqlObject.append(" from "+bean.getJoins_main());
//			//join
			map.put("join", bean.getJoins_other_sql());
			sqlObject.append(" "+bean.getJoins_other_sql());
//			//where
			map.put("where", bean.getWhere());
			
			sqlObject.append(" where 1=1 ");
			if(bean.getWhere()!=null && bean.getWhere().trim().length()>0){
				sqlObject.append(" and ("+bean.getWhere()+")");
			}
			//inputs_sql
			map.put("inputs_sql",bean.getInputs_sql());
			if(bean.getInputs_sql()!=null && bean.getInputs_sql().trim().length()>0){
				sqlObject.append(" and ("+bean.getInputs_sql()+")");
			}
//			//order
			map.put("order", bean.getOrder());
			sqlObject.append(" "+bean.getOrder());
			
			//分页
			PageInfo page=new PageInfo();
			//
			page.setCurrOffset(0);
			//
			page.setPageRowCount(5);
			//
			map.put("pageinfo", page);
			//run
			list.addAll(sourceDataDao.testSqlIsPage(map));
		} catch (Exception e) {
			list=new ArrayList<Map<?,?>>();
			Map<String,String> map=new HashMap<String,String>();
			map.put("配置sql有错误!错误详情如下!", e.getMessage());
			list.add(map);
			log.error("配置sql有错误!错误详情如下!",e);
		}
		return list;
	}
	
	/**
	 * 服务DAO取得
	 * @return 服务DAO
	 */
	public IAdspServiceConfigInfoDao getAdspServiceConfigInfoDao() {
	    return adspServiceConfigInfoDao;
	}
	/**
	 * 服务DAO设定
	 * @param adspServiceConfigInfoDao 服务DAO
	 */
	public void setAdspServiceConfigInfoDao(IAdspServiceConfigInfoDao adspServiceConfigInfoDao) {
	    this.adspServiceConfigInfoDao = adspServiceConfigInfoDao;
	}
	/**
	 * DAO取得
	 * @return DAO
	 */
	public ISourceDataDao getSourceDataDao() {
	    return sourceDataDao;
	}
	/**
	 * DAO设定
	 * @param sourceDataDao DAO
	 */
	public void setSourceDataDao(ISourceDataDao sourceDataDao) {
	    this.sourceDataDao = sourceDataDao;
	}
	/**
	 * 根据参数获取 查询sql
	 * @param bean
	 * @return sql
	 */
	private StringBuffer getSQl_Q(DbConfigBean bean){
		//sql
		StringBuffer sql=new StringBuffer("select ");
			/*字段列表 */
			String[] output_columns_names=bean.getOutput_columns_names();
			Map<String, String> output_columns_alias=bean.getOutput_columns_alias();
			if(output_columns_names!=null){
				//数据库字段处理函数(#self代表当前字段本身)
				Map<String, String> output_columns_funs=bean.getOutput_columns_funs();
				for(int i=0;i<output_columns_names.length;i++){
					//数据库字段处理函数(#self代表当前字段本身)
					String fun=output_columns_funs.get(output_columns_names[i]);
					if(fun!=null){
						sql.append(" "+StrUtils.replaceAll(fun, "#self", output_columns_names[i])+" as "+output_columns_alias.get(output_columns_names[i]));
					}else{
						sql.append(" "+output_columns_names[i]+" as "+output_columns_alias.get(output_columns_names[i]));
					}
					if(i<output_columns_names.length-1){
						sql.append(",");
					}
				}
			}
			/*主表名 */
			String main_table_name=bean.getMain_table_name();
			sql.append(" from "+main_table_name);
			/*标间连接关系 */
			//从表-标记
			String[] join_infos=bean.getJoin_infos();
			//从表-连接符
			Map<String,String> join_table_way=bean.getJoin_table_way();
			//从表-名称
			Map<String,String> join_table_name=bean.getJoin_table_name();
			//从表-关联sql
			Map<String,String> join_table_sql=bean.getJoin_table_sql();
			if(join_infos!=null){
				for(String str:join_infos){
					sql.append(" "+join_table_way.get(str)+" "+join_table_name.get(str)+" on "+join_table_sql.get(str));
				}
			}
			/*数据查询条件 */
			String sql_where=bean.getSql_where();
			//flag
			boolean where_flag=false;
			boolean inputs_flag=false;
			//参数字段列表
			String[] input_columns_names=bean.getInput_columns_names();
			/* 字段类型 */
			Map<String, String> input_columns_types=bean.getInput_columns_types();
			/* 默认值 标记 */
			Map<String, String> input_columns_is_vals=bean.getInput_columns_is_vals();
			/* 默认值 */
			Map<String, String> input_columns_values=bean.getInput_columns_values();
			/* 连接符 */
			Map<String, String> input_columns_ways=bean.getInput_columns_ways();
			if(sql_where!=null && sql_where.trim().length()>0){
				where_flag=true;
			}
			if(input_columns_names!=null && input_columns_names.length>0){
				inputs_flag=true;
			}
			//有查询参数
			if(where_flag||inputs_flag){
				//
				sql.append(" where 1=1 ");
				//固定参数
				if(where_flag){
					sql.append(" and ("+sql_where+") ");
				}
				//活动参数
				if(inputs_flag){
					//
					String is_default=null;
					sql.append(" and (");
					//遍历
					for(int i=0;i<input_columns_names.length;i++){
						//标记
						is_default=input_columns_is_vals.get(input_columns_names[i]);
						//第不是第一条
						if(i>0){
							sql.append(" and ");
						}
						sql.append(" "+input_columns_names[i]+" "+input_columns_ways.get(input_columns_names[i]));
						//有默认值
						if("1".equals(is_default)){
							//判断类型
							if(DbTypeUtils.isColumnType(DbTypeUtils.dbType.Mysql,DbTypeUtils.typeCure(input_columns_types.get(input_columns_names[i])))){
								//数值型
								sql.append(" "+input_columns_values.get(input_columns_names[i]));
							}else{
								//字符串型
								sql.append(" '"+input_columns_values.get(input_columns_names[i])+"'");
							}
						}else{
							sql.append(" ? ");
						}
					
					}
					sql.append(")");
				}
			}
			//order  排序
			sql.append(" "+bean.getSql_order());
		return sql;
	}
	/**
	 * 根据参数获取 修改sql
	 * @param bean
	 * @return sql
	 */
	private StringBuffer getSQl_U(DbConfigBean bean){
		//TODO--待完成--
		//sql
		StringBuffer sql=new StringBuffer("update ");
//			/*主表名 */
//			String main_table_name=bean.getMain_table_name();
//			sql.append(" "+main_table_name+" set ");
//			/*数据查询条件 */
//			String sql_where=bean.getSql_where();
//			//flag
//			boolean where_flag=false;
//			boolean inputs_flag=false;
//			//参数字段列表
//			String[] input_columns_names=bean.getInput_columns_names();
//			/* 字段类型 */
//			Map<String, String> input_columns_types=bean.getInput_columns_types();
//			/* 默认值 标记 */
//			Map<String, String> input_columns_is_vals=bean.getInput_columns_is_vals();
//			/* 默认值 */
//			Map<String, String> input_columns_values=bean.getInput_columns_values();
//			/* 连接符 */
//			Map<String, String> input_columns_ways=bean.getInput_columns_ways();
//			if(sql_where!=null && sql_where.trim().length()>0){
//				where_flag=true;
//			}
//			if(input_columns_names!=null && input_columns_names.length>0){
//				inputs_flag=true;
//			}
//			//有查询参数
//			if(where_flag||inputs_flag){
//				//
//				sql.append(" where 1=1 ");
//				//固定参数
//				if(where_flag){
//					sql.append(" and ("+sql_where+") ");
//				}
//				//活动参数
//				if(inputs_flag){
//					//
//					String is_default=null;
//					sql.append(" and (");
//					//遍历
//					for(int i=0;i<input_columns_names.length;i++){
//						//标记
//						is_default=input_columns_is_vals.get(input_columns_names[i]);
//						//第不是第一条
//						if(i>0){
//							sql.append(" and ");
//						}
//						sql.append(" "+input_columns_names[i]+" "+input_columns_ways.get(input_columns_names[i]));
//						//有默认值
//						if("1".equals(is_default)){
//							//判断类型
//							if(DbTypeUtils.isColumnType(DbTypeUtils.dbType.Mysql,DbTypeUtils.typeCure(input_columns_types.get(input_columns_names[i])))){
//								//数值型
//								sql.append(" "+input_columns_values.get(input_columns_names[i]));
//							}else{
//								//字符串型
//								sql.append(" '"+input_columns_values.get(input_columns_names[i])+"'");
//							}
//						}else{
//							sql.append(" ? ");
//						}
//					
//					}
//					sql.append(")");
//				}
//			}
		return sql;
	}
	/**
	 * 根据参数获取 新增sql
	 * @param bean
	 * @return sql
	 */
	private StringBuffer getSQl_I(DbConfigBean bean){
		//TODO--待完成--
		//sql
		StringBuffer sql=new StringBuffer("");
		//参数字段列表
		String[] input_columns_names=bean.getInput_columns_names();
			//活动参数
			if(input_columns_names!=null && input_columns_names.length>0){
				sql.append("insert into ");
				/*主表名 */
				String main_table_name=bean.getMain_table_name();
				sql.append(""+main_table_name+" ");
				
				/* 字段类型 */
				Map<String, String> input_columns_types=bean.getInput_columns_types();
				/* 默认值 标记 */
				Map<String, String> input_columns_is_vals=bean.getInput_columns_is_vals();
				/* 默认值 */
				Map<String, String> input_columns_values=bean.getInput_columns_values();
				//字段列表
				StringBuffer sql_s=new StringBuffer("(");
				//字段值列表
				StringBuffer sql_e=new StringBuffer("(");
				//
				String is_default=null;
				//遍历
				for(int i=0;i<input_columns_names.length;i++){
					//标记
					is_default=input_columns_is_vals.get(input_columns_names[i]);
					sql_s.append(" "+input_columns_names[i]+" ");
					//有默认值
					if("1".equals(is_default)){
						//判断类型
						if(DbTypeUtils.isColumnType(DbTypeUtils.dbType.Mysql,DbTypeUtils.typeCure(input_columns_types.get(input_columns_names[i])))){
							//数值型
							sql_e.append(" "+input_columns_values.get(input_columns_names[i]));
						}else{
							//字符串型
							sql_e.append(" '"+input_columns_values.get(input_columns_names[i])+"'");
						}
					}else{
						sql_e.append(" ? ");
					}
				
					if(i<(input_columns_names.length-1)){
						sql_s.append(",");
						sql_e.append(",");
					}
					
				}
				//字段列表
				sql.append(sql_s);
				//values
				sql.append(")values(");
				//值列表
				sql.append(sql_e);
				
				sql.append(")");
			}
		return sql;
	}
	/**
	 * 根据参数获取 删除sql
	 * @param bean
	 * @return sql
	 */
	private StringBuffer getSQl_D(DbConfigBean bean){
		//TODO--待完成--
		//sql
		StringBuffer sql=new StringBuffer("delete ");
//		/*主表名 */
//		String main_table_name=bean.getMain_table_name();
//		sql.append(" from "+main_table_name);
//		/*数据查询条件 */
//		String sql_where=bean.getSql_where();
//		//flag
//		boolean where_flag=false;
//		boolean inputs_flag=false;
//		//参数字段列表
//		String[] input_columns_names=bean.getInput_columns_names();
//		/* 字段类型 */
//		Map<String, String> input_columns_types=bean.getInput_columns_types();
//		/* 默认值 标记 */
//		Map<String, String> input_columns_is_vals=bean.getInput_columns_is_vals();
//		/* 默认值 */
//		Map<String, String> input_columns_values=bean.getInput_columns_values();
//		/* 连接符 */
//		Map<String, String> input_columns_ways=bean.getInput_columns_ways();
//		if(sql_where!=null && sql_where.trim().length()>0){
//			where_flag=true;
//		}
//		if(input_columns_names!=null && input_columns_names.length>0){
//			inputs_flag=true;
//		}
//		//有查询参数
//		if(where_flag||inputs_flag){
//			//
//			sql.append(" where 1=1 ");
//			//固定参数
//			if(where_flag){
//				sql.append(" and ("+sql_where+") ");
//			}
//			//活动参数
//			if(inputs_flag){
//				//
//				String is_default=null;
//				sql.append(" and (");
//				//遍历
//				for(int i=0;i<input_columns_names.length;i++){
//					//标记
//					is_default=input_columns_is_vals.get(input_columns_names[i]);
//					//第不是第一条
//					if(i>0){
//						sql.append(" and ");
//					}
//					sql.append(" "+input_columns_names[i]+" "+input_columns_ways.get(input_columns_names[i]));
//					//有默认值
//					if("1".equals(is_default)){
//						//判断类型
//						if(DbTypeUtils.isColumnType(DbTypeUtils.dbType.Mysql,DbTypeUtils.typeCure(input_columns_types.get(input_columns_names[i])))){
//							//数值型
//							sql.append(" "+input_columns_values.get(input_columns_names[i]));
//						}else{
//							//字符串型
//							sql.append(" '"+input_columns_values.get(input_columns_names[i])+"'");
//						}
//					}else{
//						sql.append(" ? ");
//					}
//				
//				}
//				sql.append(")");
//			}
//		}
		return sql;
	}
}
