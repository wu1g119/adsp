/*
 * WebService  manager 实现类
 *
 * VERSION  DATE        BY              REASON
 * -------- ----------- --------------- ------------------------------------------
 * 1.00     2013.03.11  wuxiaogang           程序・发布
 * 2.00     2013-06-04  wuxiaogang  程序・功能完善   项目重新启动  修复N多bug
 * 3.00     2013-06-04  wuxiaogang  程序・功能完善  新增  图文分离功能(坑爹的IPTV)
 * 4.00     2013-06-05  wuxiaogang  程序・功能完善  子服务功能
 * 5.00     2013-06-13  wuxiaogang  程序・功能完善   redis多种bug修复
 * 6.00     2013-06-19  wuxiaogang  程序・功能完善   [活动的排序字段order by columns]
 * 7.00     2013-06-19  wuxiaogang  程序・功能完善   新增 [IN,>大于,<小于] 信息匹配符
 * -------- ----------- --------------- ------------------------------------------
 * Copyright 2013 adsp System. - All Rights Reserved.
 *
 */
package cn.com.softvan.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.tags.ImageTag;
import org.htmlparser.util.NodeList;

import cn.com.softvan.bean.ObjBean;
import cn.com.softvan.bean.client.AdspClientInfoBean;
import cn.com.softvan.bean.config.ConfigJsonBean;
import cn.com.softvan.bean.config.ConfigObject2Bean;
import cn.com.softvan.bean.config.ToInfoBean;
import cn.com.softvan.common.DbTypeUtils;
import cn.com.softvan.common.JsonUtils;
import cn.com.softvan.common.StrUtils;
import cn.com.softvan.common.Validator;
import cn.com.softvan.service.BaseManager;
import cn.com.softvan.service.IClientInfoManager;
import cn.com.softvan.service.IServiceConfigManager;
import cn.com.softvan.service.IServiceSubInfoManager;
import cn.com.softvan.service.IWebServiceManager;
import cn.com.softvan.service.sourcedb.ISourceDataManager;
import cn.com.softvan.service.sourcedb.IStorageDataManager;
import cn.com.softvan.web.tag.PageInfo;

/**
 * WebService manager 实现类
 * 
 * @author {wuxiaogang}
 * 
 */
public class WebServiceManager extends BaseManager implements IWebServiceManager {
	/** 日志 */
	private static final transient Logger log = Logger
			.getLogger(WebServiceManager.class);

	/** 默认构造器 */
	public WebServiceManager() {

	}
	/**查询数据  业务处理类*/
	private ISourceDataManager sourceDataManager;
	/**更新数据  业务处理类*/
	private IStorageDataManager storageDataManager;
	/**子系统信息 manager 业务处理*/
	private static IClientInfoManager clientInfoManager;
	/**服务配置信息 业务处理*/
	private static IServiceConfigManager serviceConfigManager;
	/**子服务配置信息 业务处理*/
	private static IServiceSubInfoManager serviceSubInfoManager;
	/**日期转换的6个转换符 年月日时分秒*/
	private final String[] df={"","%Y","%m","%d","%H","%i","%s"};
	/**通通到碗里来  放入缓存*/
	private void initJedis(){
		if(!"1".equals(jedisHelper.get("flag_updateCacheClient"))){
			//更新客户端缓存信息
			clientInfoManager.updateCacheClient(null);
		}
		if(!"1".equals(jedisHelper.get("flag_updateCacheAuth"))){
			//更新权限缓存信息
			clientInfoManager.updateCacheAuth(null);
		}
		if(!"1".equals(jedisHelper.get("flag_updateChcheService"))){
			//TODO 更新服务配置 缓存信息
			serviceConfigManager.updateChcheService(null);
		}
		if(!"1".equals(jedisHelper.get("flag_updateChcheSubService"))){
			//TODO 更新服务配置 子服务 缓存信息
			serviceSubInfoManager.updateChcheSubService(null);
		}
  }
	/**
	 * 查询数据  业务处理类取得
	 * @return 查询数据  业务处理类
	 */
	public ISourceDataManager getSourceDataManager() {
	    return sourceDataManager;
	}

	/**
	 * 查询数据  业务处理类设定
	 * @param sourceDataManager 查询数据  业务处理类
	 */
	public void setSourceDataManager(ISourceDataManager sourceDataManager) {
	    this.sourceDataManager = sourceDataManager;
	}

	/**
	 * 更新数据  业务处理类取得
	 * @return 更新数据  业务处理类
	 */
	public IStorageDataManager getStorageDataManager() {
	    return storageDataManager;
	}

	/**
	 * 更新数据  业务处理类设定
	 * @param storageDataManager 更新数据  业务处理类
	 */
	public void setStorageDataManager(IStorageDataManager storageDataManager) {
	    this.storageDataManager = storageDataManager;
	}
	/**
	 * <div>
	 * 	<li>获取信息</li>
	 * </div>
	 * @param info
	 * @return info
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String getInfo(String info,String ip){
		Long s=System.currentTimeMillis();
		//缓存对象是否存在
		initJedis();
		//返回信息
		StringBuffer json=new StringBuffer("{");
		String error_msg="";
		String system="";
		String serviceName="";
		String sql_limt="";
		//记录日志用 sql
		StringBuffer sqlObject=new StringBuffer("");
		//参数不能为空
		if(!StringUtils.isBlank(info)){
			Map<String,Object> infoMap=null;
			try {
				try {
					//解析json参数
					infoMap=JsonUtils.jsonToMap2(info);
				} catch (Exception e1) {
					error_msg=e1.getMessage();
					json=new StringBuffer("{");
					addData(null,json, "error_msg","参数格式有误!请仔细检查!");
					log.error("客户端参数问题!",e1);
					//闭合
					json.append("}");
					//记录日志
					taskExecutor.execute(new ServiceLogsManager(adspServiceLogsDao,system, "getInfo", serviceName, info, (System.currentTimeMillis()-s), error_msg, "zh", "", ip,sqlObject.toString()+sql_limt));
//					serviceLogsManager.saveServiceLogs(system, "getInfo", serviceName, info, (System.currentTimeMillis()-s), error_msg, "zh", "", ip,sqlObject.toString()+sql_limt);
					return json.toString();
				}
				//获取调用系统名称
				system=(String) infoMap.get("system");
				//获取服务名称
				serviceName=(String) infoMap.get("serviceName");
				//每个数据页的大小
				String pageSize=(String) infoMap.get("pageSize");
				//数据页码
				String pageNum=(String) infoMap.get("pageNum");
				//实时信息标记[算是 隐藏属性 么]
				String now_info_flag_a=(String) infoMap.get("now_info_flag_a");
				//
//				log.debug("--------2--------------");
				//判断客户端是否存在
				if(jedisHelper.exists("client_"+system)){
					AdspClientInfoBean clientBean=(AdspClientInfoBean) jedisHelper.get("client_"+system);
					//ip认证
					if(clientBean!=null&&ip.equals(clientBean.getClient_ip())){
						//获取调用系统可调用服务集合
						Map<String,String> serviceMaps=(Map<String, String>) jedisHelper.get("auth_"+system);
						//判断客户端权限
						if(serviceMaps.get(serviceName)!=null){
							//获取服务配置信息
							ConfigJsonBean bean=(ConfigJsonBean) jedisHelper.get("service_"+serviceName);
							//
							if(bean!=null){
								//提取数据用 sql
								Map sqlMap=new HashMap();
								//TODO 拼装sql
								getSelectSql(sqlObject, bean, infoMap);
								//提取数据
								sqlMap.put("sql", sqlObject);
								//分页对象
								PageInfo page=new PageInfo();
								//起始数据变量
								Integer offsetA=0;
								//每页显示条数
								Integer pageSizeA=10;
								//分页参数验证
								if(Validator.isNum(pageSize)&&Validator.isNum(pageNum)){
									offsetA=Integer.parseInt(pageSize)*(Integer.parseInt(pageNum)-1);
									pageSizeA=Integer.parseInt(pageSize);
								}
								//数据起始
								page.setCurrOffset(offsetA);
								//每页显示条数
								page.setPageRowCount(pageSizeA);
								//TODO--分页必须
								sqlMap.put("pageinfo", page);
								//cc
								sql_limt=(" limit "+(offsetA)+","+(offsetA+pageSizeA));
								//分页对象key
					  		    String page_key="page_"+(sqlObject.toString()+sql_limt);
//					  		 	log.debug("1="+((sqlObject.toString().trim()+sql_limt)));
					  		    //实时信息标记
					  		    if(!"1".equals(now_info_flag_a)){
									//TODO cache的两种方案测试  1.直接保存封装好的对象
									// b.使用对象
									String json_cache=(String) jedisHelper.get("json_"+page_key);
									if(null!=json_cache){
										//记录日志
										taskExecutor.execute(new ServiceLogsManager(adspServiceLogsDao,system, "getInfo", serviceName, info, (System.currentTimeMillis()-s), error_msg, "zh", "", ip,sqlObject.toString()+sql_limt));
//										serviceLogsManager.saveServiceLogs(system, "getInfo", serviceName, info, (System.currentTimeMillis()-s), error_msg, "zh", "", ip,sqlObject.toString()+sql_limt);
										log.debug("============缓存命中=========");
										return json_cache;
									}else{
										log.debug("============新调用=========");
									}
					  		    }
								//读取数据=====================================start===============================================
								List<Map<?, ?>> list=sourceDataManager.getDataIsPage(sqlMap);
	//							//TODO cache的两种方案测试  2.存储数据库对象
	//				  		    //对象为空或者or分页cache标记存在
	//							if("1".equals(jedisHelper.get("flag_"+page_key))){
	//								page=(PageInfo) jedisHelper.get(page_key);
	//								if(page==null){
	//									page=(PageInfo) sqlMap.get("pageinfo");
	//									if(page==null){
	//										page=new PageInfo();
	//									}
	//								}
	//							}
								//封装数据
								//头信息
								json.append(getHeader(page.getRecordCount(),page.getPageRowCount(),page.getCurrentPageNo()));
								//具体数据 start
								json.append(",\"item\":[");
								//图文分离字段列表
								List<ToInfoBean> itsts=bean.getItsts();
								//图文分离字段Map
								Map<String,String> itstMap=null;
								if(itsts!=null){
									itstMap=new HashMap<String,String>();
									for(ToInfoBean tb:itsts){
										itstMap.put(tb.getAlias(),"1");
									}
								}
								//(子)入参 字段列表
								List<ToInfoBean> osubs=bean.getOsubs();
								//(子)入参 字段Map
								Map<String,String> osubsMap=null;
								//验证
								if(list!=null && list.size()>0){
									//计数器
									int mapNum=1;
									//遍历
									for(Map<?,?> map:list){
										json.append("{");
										//验证
										if(map!=null){
											Set<?> set = map.entrySet();
											if(set!=null){
												//(子)入参 字段Map  key:value  具体参数集合
												if(osubs!=null){
													osubsMap=new HashMap<String,String>();
													for(ToInfoBean osub:osubs){
														osubsMap.put(osub.getAlias(),(String) map.get(osub.getAlias()));
													}
												}
												//计数器
												int iteratorNum=1;
												//遍历
										        for (Iterator it = set.iterator(); it.hasNext();) {
										            Map.Entry<String, ?> entry = (Map.Entry<String, String>) it.next();
										           //
										            if(entry!=null){
										            	//单节点封装
										        	   addData(itstMap,json, entry.getKey(),entry.getValue());
										        	    //间隔符,
										        	   if(iteratorNum<set.size()){
										        		   json.append(",");
										        	   }
										        	   //计数器 ++
										        	   iteratorNum++;
										           }
										        }
										      //TODO-子服务封装处理-完成-2013/06/05
												{
													// 1.获取子服务集合
													List<ConfigObject2Bean> subServiceLists=(List<ConfigObject2Bean>) jedisHelper.get("sub_"+serviceName);
													if(subServiceLists!=null&&subServiceLists.size()>0){
														//子服务 数据分割
														json.append(",");
														//子服务基本信息
														ConfigObject2Bean object2Bean=null;
														//服务配置信息
														ConfigJsonBean sub_bean=null;
														// 2.遍历子服务
												        for(int subS_num=0;subS_num<subServiceLists.size();subS_num++) {
												        	
												        	object2Bean=(ConfigObject2Bean)subServiceLists.get(subS_num);
												           //
												            if(object2Bean!=null){
												            	//获取服务配置信息
												            	sub_bean=(ConfigJsonBean) jedisHelper.get("service_"+object2Bean.getServiceName());
												            	//1.找到主服务的输出字段(标记作为子服务的入参)
												            	List<ToInfoBean> isubs=sub_bean.getIsubs();
												            	//2.拼成调用参数 json格式
												            	StringBuffer input_sub_json=new StringBuffer("{");
												            	if(isubs!=null){
												            		ToInfoBean isub=null;
												            		for(int isub_num=0;isub_num<isubs.size();isub_num++){
												            			isub=isubs.get(isub_num);
												            			if(isub!=null){
												            				input_sub_json.append("\""+isub.getAlias()+"\":\""+osubsMap.get(isub.getAlias())+"\"");
											            				   //间隔符,
															        	   if(isub_num<isubs.size()-1){
															        		   input_sub_json.append(",");
															        	   }
												            			}
												            		}
												            	}
												            	input_sub_json.append("}");
												            	//3.封装子服务信息
													            json.append(infoPacking_node(input_sub_json.toString(),object2Bean.getNode_name(),sub_bean));
												            	if(subS_num<subServiceLists.size()-1){
												            		json.append(",");
												            	}
												            }
												        }
													}
												}
											}
										}
										json.append("}");
										//间隔符,
										if(mapNum<list.size()){
											json.append(",");
										}
										//计数器自增
										mapNum++;
									}
								}
								json.append("]");
	//							 //实时信息标记
	//				  		    if(!"1".equals(now_info_flag_a)){
									//TODO cache的两种方案测试 
									//2.直接保存封装好的对象   a.保存对象  缓存30分钟
									jedisHelper.set("json_"+page_key,(json+"}").toString(),30*60*1000);
	//				  		    }
							}else{
								error_msg="服务不存在!serviceName="+serviceName+"!";
								json=new StringBuffer("{");
								addData(null,json,"error_msg",error_msg);
							}
						}else{
							error_msg="服务访问权限受限!serviceName="+serviceName+"!";
							json=new StringBuffer("{");
							addData(null,json,"error_msg",error_msg);
						}
					}else{
						error_msg="客户端IP未注册!IP="+ip;
						json=new StringBuffer("{");
						addData(null,json,"error_msg",error_msg);
					}
				}else{
					error_msg="客户端system="+system+"未注册!";
					json=new StringBuffer("{");
					addData(null,json,"error_msg",error_msg);
				}
			} catch (Exception e) {
				error_msg=e.getMessage();
				json=new StringBuffer("{");
				addData(null,json, "error_msg","接口服务异常,请与管理员联系!");
				log.error("调用获取信息接口错误!",e);
			}
		}else{
			error_msg="参数不能为空";
			json=new StringBuffer("{");
			addData(null,json, "error_msg",error_msg);
		}
		//闭合
		json.append("}");
		//记录日志
		taskExecutor.execute(new ServiceLogsManager(adspServiceLogsDao,system, "getInfo", serviceName, info, (System.currentTimeMillis()-s), error_msg, "zh", "", ip,sqlObject.toString()+sql_limt));
//		serviceLogsManager.saveServiceLogs(system, "getInfo", serviceName, info, (System.currentTimeMillis()-s), error_msg, "zh", "", ip,sqlObject.toString()+sql_limt);
		return json.toString();
	}
	/**
	 * <div>
	 * 	<li>获取日期时间转换字符串</li>
	 * </div>
	 * @param s_num
	 * @param e_num
	 * @param df_level
	 * @return
	 */
	private String getTDf(Integer s_num,Integer e_num,String df_level){
		String t_df="";
		Integer num=e_num;
		if(Validator.isIntNumber(df_level)){
			try {
				num=Integer.parseInt(df_level);
			} catch (Exception e) {
				num=e_num;
			}
			for(int num1=s_num;num1<=num;num1++){
				t_df+=df[num1];
			}
		}
		return t_df;
	}
	/**
	 * <div>
	 * 	<li>修改信息</li>
	 * </div>
	 * @param info
	 * @return info
	 */
	public String modifyInfo(String info,String ip){
		StringBuffer json=new StringBuffer("{");
		addData(null,json, "error_msg","接口未开放!");
		json.append("}");
		return json.toString();
	}
	/**
	 * <div>
	 * 	<li>保存信息</li>
	 * </div>
	 * @param info
	 * @return info
	 */
	public String saveInfo(String info,String ip){
		StringBuffer json=new StringBuffer("{");
		addData(null,json, "error_msg","接口未开放!");
		json.append("}");
		return json.toString();
	}
	/**
	 * <div>
	 * 	<li>合并信息</li>
	 * </div>
	 * @param info
	 * @return info
	 */
	public String mergerInfo(String info,String ip){
		StringBuffer json=new StringBuffer("{");
		addData(null,json, "error_msg","接口未开放!");
		json.append("}");
		return json.toString();
	}
	/**
	 * <div>
	 * 	<li>删除信息</li>
	 * </div>
	 * @param info
	 * @return info
	 */
	public String delInfo(String info,String ip){
		StringBuffer json=new StringBuffer("{");
		addData(null,json, "error_msg","接口未开放!");
		json.append("}");
		return json.toString();
	}
	
	/**
	 * 根据数据总条数、页大小和当前页码生成相应的报文头
	 * 
	 * @param totalCount
	 *            数据总条数
	 * @param pageSize
	 *            页大小
	 * @param pageNum
	 *            当前页码
	 * @return 报文头
	 */
	private String getHeader(long totalCount, int pageSize, int pageNum) {
		StringBuffer result = new StringBuffer("totalCount:\"");
		result.append(totalCount);
		if (pageSize != -1) {
			result.append("\",pageSize:\"");
			result.append(pageSize);
			result.append("\",totalPage:\"");
			long totalPage = totalCount % pageSize == 0 ? totalCount / pageSize
					: totalCount / pageSize + 1;
			result.append(totalPage);
			result.append("\",currentCount:\"");
			if (pageNum > totalPage){
				result.append("0");
			}else{
				result.append(pageNum < totalPage ? pageSize : totalCount
						- (pageNum - 1) * pageSize);
			}
			result.append("\",currentPage:\"");
			result.append(pageNum);
			result.append("\"");
		} else {
			result.append("\",currentCount:\"");
			result.append(totalCount);
			result.append("\"");
		}
		return result.toString();
	}

	/**
	 * 为json元素添加属性
	 * @param itstMap 图文分离字段集合
	 * 
	 * @param data
	 *            文本
	 * @param attrName
	 *            属性名
	 * @param object
	 *            属性值
	 */
	private void addData(Map<String,String> itstMap,StringBuffer data, String attrName, Object object) {
		//字段值存在
		if (object != null) {
			String ti=String.valueOf(object);
			//
			if(itstMap!=null){
				//是否属于图文分离字段
				if(itstMap.get(attrName)!=null){
					//节点begin
					data.append("\""+attrName+"\":{");
					//temp original info(text images)
					//temp images obj
					StringBuffer imgjson=new StringBuffer("");
					//图文分离处理
					//1.找出所有图片
					List<ObjBean> imglist=getImgStr1(ti);
					//2.原信息中去掉图片信息
					if(imglist!=null){
						ObjBean o=null;
						for(int i=0;i<imglist.size();i++){
							o=imglist.get(i);
							if(o==null){
								continue;
							}
							//封装图片信息
							//a.图片链接
							imgjson.append("{\"url\":\""+StrUtils.replaceAll(o.getStr1(),"\"","\\\\\"")+"\"");
							//b.图片文字标题
							imgjson.append(",\"txt\":\""+StrUtils.replaceAll(o.getStr2(),"\"","\\\\\"")+"\"}");
							//
							//间隔符,
							if(i<imglist.size()-1){
								imgjson.append(",");
							}
							//分离图片信息
							ti=StrUtils.replaceAll(ti,o.getStr4(),"");
						}
					}
					//3.封装文字信息
					data.append("\"txt\":\""+StrUtils.replaceAll(ti,"\"","\\\\\"")+"\",");
					//4.封装图片信息
					data.append("\"img\":[");
					data.append(imgjson);
					data.append("]");
					//节点end
					data.append("}");
				}else{
					data.append("\""+attrName+"\":\""+StrUtils.replaceAll(ti,"\"","\\\\\"")+"\"");
				}
			}else{
				data.append("\""+attrName+"\":\""+StrUtils.replaceAll(ti,"\"","\\\\\"")+"\"");
			}
		}
	}
	/**
	 * 得到网页中图片的地址
	 */
	public List<ObjBean> getImgStr1(String htmlStr) {
		if(Validator.isEmpty(htmlStr)){
			return null;
		}
		List<ObjBean> list=null;
		try {
			Parser parser = new Parser();
			parser.setInputHTML(htmlStr);
			list=new ArrayList<ObjBean>();
			ObjBean objbean=null;
			NodeFilter nf=new NodeClassFilter(ImageTag.class);
			NodeList nodeList = (NodeList) parser.parse(nf);
			 for (int i = 0; i < nodeList.size(); i++) {
				 try {
					ImageTag xx=(ImageTag)nodeList.elementAt(i);
					objbean=new ObjBean();
					objbean.setStr1(xx.getImageURL());//图片地址
					objbean.setStr2(xx.getAttribute("title"));//图片文字
					if(Validator.isEmpty(objbean.getStr2())){
						objbean.setStr2(xx.getAttribute("alt"));//图片文字
					}
//					objbean.setStr3(xx.getAttribute("src"));
//					if(Validator.isEmpty(objbean.getStr3())){
//						//神奇
//						objbean.setStr3(xx.getAttribute("SRC"));
//					}
					//原始图片标签
					objbean.setStr4(xx.toHtml());
					list.add(objbean);
				} catch (Exception e) {
				}
			 }
		} catch (Exception e) {
		}
		return list;
	}
	/** 
	 * -----------------------------通用格式子信息--子数据封装---------------------------------------------------------------
	 * @param inValue
	 * @param node
	 * @param subNode
	 * @param configJsonBean
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private StringBuffer infoPacking_node(String inValue,
			String node,ConfigJsonBean configJsonBean){
		/* 
    	 * 1.解析子服务 
    	// 2.获取子服务 结点名称
		// 3.获取数据
		// 4.解析
		// 5.封装
		 * 
		 */
		//TODO--子服务解析封装--
		StringBuffer json=new StringBuffer("\""+node+"\":[");
		String serviceName="";
		//记录日志用 sql
		StringBuffer sqlObject=new StringBuffer("");
		try {
			//解析json参数
			Map<String,Object> infoMap=null;
			try {
				//解析json参数
				infoMap=JsonUtils.jsonToMap2(inValue);
			} catch (Exception e1) {
				json.append("{");
				addData(null,json, "error_msg","系统错误!请与管理员联系!");
				//闭合
				json.append("}]");
				log.error("子服务参数问题!",e1);
				return json;
			}
			//获取服务名称
			serviceName=(String) infoMap.get("serviceName");
			//获取服务配置信息
			ConfigJsonBean bean=configJsonBean;
			//服务存在
			if(bean!=null){
				//提取数据用 sql
				Map sqlMap=new HashMap();
				//TODO 拼装sql
				getSelectSql(sqlObject, bean, infoMap);
				//提取数据
				sqlMap.put("sql", sqlObject);
				//获取信息
				List<Map<?, ?>> list=sourceDataManager.getData(sqlMap);
				//封装数据
				//头信息
//				json.append(getHeader(page.getPageCount(),page.getPageRowCount(),page.getCurrentPageNo()));
				//具体数据 start
				//图文分离字段列表
				List<ToInfoBean> itsts=bean.getItsts();
				//图文分离字段Map
				Map<String,String> itstMap=null;
				if(itsts!=null){
					itstMap=new HashMap<String,String>();
					for(ToInfoBean tb:itsts){
						itstMap.put(tb.getAlias(),"1");
					}
				}
				//验证
				if(list!=null && list.size()>0){
					//计数器
					int mapNum=1;
					//遍历
					for(Map<?,?> map:list){
						json.append("{");
						//验证
						if(map!=null){
							Set<?> set = map.entrySet();
							if(set!=null){
								//计数器
								int iteratorNum=1;
								//遍历
						        for (Iterator<?> it = set.iterator(); it.hasNext();) {
						            Map.Entry<String, String> entry = (Map.Entry<String, String>) it.next();
						           //
						            if(entry!=null){
						            	//单节点封装
						        	   addData(itstMap,json, entry.getKey(),entry.getValue());
						        	    //间隔符,
						        	   if(iteratorNum<set.size()){
						        		   json.append(",");
						        	   }
						        	   //计数器++
						        	   iteratorNum++;
						           }
						        }
							}
						}
						json.append("}");
						//间隔符,
						if(mapNum<list.size()){
							json.append(",");
						}
						//计数器自增
						mapNum++;
					}
				}
			}
		}catch (Exception e) {
			log.error("子服务"+serviceName+"-sql="+sqlObject,e);
		}
		json.append("]");
		return json;
	}
	/**
	 * 拼装查询sql
	 * @param sqlObject
	 * @param bean
	 * @param infoMap
	 */
	@SuppressWarnings("unchecked")
	private void getSelectSql(StringBuffer sqlObject,ConfigJsonBean bean,Map<String,Object> infoMap){
		//select
		sqlObject.append("select "+bean.getOutputs_sql());
		//from 
		sqlObject.append(" from "+bean.getJoins_main());
		//join
		sqlObject.append(" "+bean.getJoins_other_sql());
		//where
		sqlObject.append(" where 1=1 ");
		if(bean.getWhere()!=null && bean.getWhere().trim().length()>0){
			sqlObject.append(" and ("+bean.getWhere()+")");
		}
		//inputs_sql
		if(bean.getInputs_sql()!=null && bean.getInputs_sql().trim().length()>0){
			sqlObject.append(" and ("+bean.getInputs_sql()+")");
		}
		//活动参数
		//参数存在标记
		boolean input_flag=false;
		//TODO---重要
		StringBuffer sqlObject_inputs=new StringBuffer("");
		//使用treeMap对排序字段建立顺序
		TreeMap<Integer,String> order_map=new TreeMap<Integer,String>();
		//入参集合
		List<ToInfoBean> inputs=bean.getInputs();
		//!=null
		if(inputs!=null){
			//排序字段入参集合
			Map<String,String> obcsMap=(Map<String, String>) infoMap.get("obcs");
			//必填字段集合
			List<ToInfoBean> mbs=bean.getMbs();
			//必填字段集合Map
			Map<String,String> mbs_map=new HashMap<String,String>();
			if(mbs!=null&&mbs.size()>0){
				for(ToInfoBean mb:mbs){
					if(mb!=null){
						mbs_map.put(mb.getAlias(),"1");
					}
				}
			}
			//
			int i=0;
			//遍历
			for(ToInfoBean obj:inputs){
				//活动参数
				if(!"1".equals(obj.getIs_val())){
					//参数值(客户端参数)
					String value=(String) infoMap.get(obj.getAlias());
					//参数信息匹配(参数存在)
					if(value!=null){
						//不是第一条
						if(i>0){
							sqlObject_inputs.append(" and ");
						}else{
							input_flag=true;
						}
						//判断连接符  
						if(" X1 X2 X5 X6 ".contains(StrUtils.toUpperCase(obj.getWay()))){
							//x1<小于< x5<=小于等于 x2>大于< x6>=大于等于
							String way="<";
							if("x5".equals(obj.getWay())){
								way="<=";
							}else
							if("x1".equals(obj.getWay())){
								way=">";
							}else
							if("x6".equals(obj.getWay())){
								way=">=";
							}
							//大于>
							//判断类型
							if(DbTypeUtils.isColumnType(DbTypeUtils.dbType.Mysql,obj.getType())){
								//字段名  匹配符
								sqlObject_inputs.append(" "+obj.getName()+" "+way);
								//数值型
								sqlObject_inputs.append(" "+value+" ");
							}else{
								//验证是否是时间日期型  **YEAR作为普通字符型处理
								if(" DATETIME DATE TIMESTAMP TIME ".contains(StrUtils.toUpperCase(DbTypeUtils.typeCure(obj.getType())))){
									//date_format('2011/11/11 11:11:11', '%Y-%m-%d %H:%i:%s')
									String[] x2val=value.split("&");
									if(x2val!=null&&x2val.length>=2){
										//TIME类型
										if(" TIME ".contains(StrUtils.toUpperCase(DbTypeUtils.typeCure(obj.getType())))){
											String t_df=getTDf(4,6,x2val[0]);
											sqlObject_inputs.append(" time_format("+obj.getName()+",'"+t_df+"') "+way+" time_format('"+x2val[1]+"','"+t_df+"') ");
										}else
										//DATE类型
										if(" DATE ".contains(StrUtils.toUpperCase(DbTypeUtils.typeCure(obj.getType())))){
											String t_df=getTDf(1,3,x2val[0]);
											if(Validator.notEmpty(x2val[1])){
												sqlObject_inputs.append(" date_format("+obj.getName()+",'"+t_df+"') "+way+" date_format('"+x2val[1]+"','"+t_df+"') ");
											}
										}else{
											// DATETIME TIMESTAMP类型
											String t_df=getTDf(1,6,x2val[0]);
											if(Validator.notEmpty(x2val[1])){
												sqlObject_inputs.append(" date_format("+obj.getName()+",'"+t_df+"') "+way+" date_format('"+x2val[1]+"','"+t_df+"') ");
											}
										}
									}else{
										//默认时间比较精确到日  **未带日期时间转码级别标记的
										sqlObject_inputs.append(" date_format("+obj.getName()+",'%Y%m%d') "+way+" date_format('"+value+"','%Y%m%d') ");
									}
								}else{
									//TODO 真的字符串型
									//字段名  匹配符
									sqlObject_inputs.append(" "+obj.getName()+" "+">");
									//字符串型
									sqlObject_inputs.append(" '"+value+"' ");
								}
							}
						}else if("x3".equalsIgnoreCase(obj.getWay())){
							//区间 xx>1 and xx<5 
							String[] x3val=value.split("&");
							if(x3val!=null&&x3val.length>=2){
								//判断类型
								if(DbTypeUtils.isColumnType(DbTypeUtils.dbType.Mysql,obj.getType())){
									//数值型 xx>1 and xx<5 
									if(Validator.isNumber1(x3val[0])){
										sqlObject_inputs.append(" "+obj.getName()+" "+">= "+x3val[0]);
									}
									if(Validator.isNumber1(x3val[0])&&Validator.isNumber1(x3val[1])){
										sqlObject_inputs.append(" and ");
									}
									if(Validator.isNumber1(x3val[1])){
										sqlObject_inputs.append(" "+obj.getName()+" "+"<= "+x3val[1]+" ");
									}
								}else{//字符串型
									//date_format('2011/11/11 11:11:11', '%Y-%m-%d %H:%i:%s')
									//验证是否是时间日期型  **YEAR作为普通字符型处理
									if(x3val.length>=3&&" DATETIME DATE TIMESTAMP TIME ".contains(StrUtils.toUpperCase(DbTypeUtils.typeCure(obj.getType())))){
										//TIME类型
										if(" TIME ".contains(StrUtils.toUpperCase(DbTypeUtils.typeCure(obj.getType())))){
											String t_df=getTDf(4,6,x3val[0]);
											if(Validator.notEmpty(x3val[1])){
												sqlObject_inputs.append(" time_format("+obj.getName()+",'"+t_df+"') "+">= time_format('"+x3val[1]+"','"+t_df+"') ");
											}
											if(Validator.notEmpty(x3val[1])&&Validator.notEmpty(x3val[2])){
												sqlObject_inputs.append(" and ");
											}
											if(Validator.notEmpty(x3val[2])){
												sqlObject_inputs.append(" time_format("+obj.getName()+",'"+t_df+"') "+"<= time_format('"+x3val[2]+"','"+t_df+"') ");
											}
										}else
										//DATE类型
										if(" DATE ".contains(StrUtils.toUpperCase(DbTypeUtils.typeCure(obj.getType())))){
											String t_df=getTDf(1,3,x3val[0]);
											if(Validator.notEmpty(x3val[1])){
												sqlObject_inputs.append(" date_format("+obj.getName()+",'"+t_df+"') "+">= date_format('"+x3val[1]+"','"+t_df+"') ");
											}
											if(Validator.notEmpty(x3val[1])&&Validator.notEmpty(x3val[2])){
												sqlObject_inputs.append(" and ");
											}
											if(Validator.notEmpty(x3val[2])){
												sqlObject_inputs.append(" date_format("+obj.getName()+",'"+t_df+"') "+"<= date_format('"+x3val[2]+"','"+t_df+"') ");
											}
										}else{
											// DATETIME TIMESTAMP类型
											String t_df=getTDf(1,6,x3val[0]);
											if(Validator.notEmpty(x3val[1])){
												sqlObject_inputs.append(" date_format("+obj.getName()+",'"+t_df+"') "+">= date_format('"+x3val[1]+"','"+t_df+"') ");
											}
											if(Validator.notEmpty(x3val[1])&&Validator.notEmpty(x3val[2])){
												sqlObject_inputs.append(" and ");
											}
											if(Validator.notEmpty(x3val[2])){
												sqlObject_inputs.append(" date_format("+obj.getName()+",'"+t_df+"') "+"<= date_format('"+x3val[2]+"','"+t_df+"') ");
											}
										}
									}else{
										//TODO 真的字符串型
										if(Validator.isIntNumber(x3val[0])){
											sqlObject_inputs.append(" "+obj.getName()+" "+">= '"+x3val[0]+"' ");
										}
										if(Validator.isIntNumber(x3val[0])&&Validator.isIntNumber(x3val[1])){
											sqlObject_inputs.append(" and ");
										}
										if(Validator.isIntNumber(x3val[1])){
											sqlObject_inputs.append(" "+obj.getName()+" "+"<= '"+x3val[1]+"' ");
										}
									}
								}
							}
						}else if("x4".equalsIgnoreCase(obj.getWay())){
							//in xx in (1,2,3,4,5)
							//字段名  匹配符
							sqlObject_inputs.append(" "+obj.getName()+" in ("+value+") ");
						}else{
							//判断类型
							if(DbTypeUtils.isColumnType(DbTypeUtils.dbType.Mysql,obj.getType())){
								//字段名  匹配符
								sqlObject_inputs.append(" "+obj.getName()+" "+obj.getWay());
								//数值型
								sqlObject_inputs.append(" "+value+" ");
							}else{
								//字符串型
								//date_format('2011/11/11 11:11:11', '%Y-%m-%d %H:%i:%s')
								//验证是否是时间日期型 **YEAR作为普通字符型处理
								if(" DATETIME DATE TIMESTAMP TIME ".contains(StrUtils.toUpperCase(DbTypeUtils.typeCure(obj.getType())))){
									String[] xxval=value.split("&");
									if(xxval!=null&&xxval.length>=2){
										//TIME类型
										if(" TIME ".contains(StrUtils.toUpperCase(DbTypeUtils.typeCure(obj.getType())))){
											String t_df=getTDf(4,6,xxval[0]);
											if(Validator.notEmpty(xxval[1])){
												sqlObject_inputs.append(" time_format("+obj.getName()+",'"+t_df+"') "+obj.getWay()+" time_format('"+xxval[1]+"','"+t_df+"') ");
											}
										}else
										//DATE类型
										if(" DATE ".contains(StrUtils.toUpperCase(DbTypeUtils.typeCure(obj.getType())))){
											String t_df=getTDf(1,3,xxval[0]);
											sqlObject_inputs.append(" date_format("+obj.getName()+",'"+t_df+"') "+obj.getWay()+" date_format('"+xxval[1]+"','"+t_df+"') ");
										}else{
											// DATETIME TIMESTAMP类型
											String t_df=getTDf(1,6,xxval[0]);
											sqlObject_inputs.append(" date_format("+obj.getName()+",'"+t_df+"') "+obj.getWay()+" date_format('"+xxval[1]+"','"+t_df+"') ");
										}
									}else{
										//默认时间比较精确到日  **未带日期时间转码级别标记的
										sqlObject_inputs.append(" date_format("+obj.getName()+",'%Y%m%d') "+obj.getWay()+" date_format('"+value+"','%Y%m%d') ");
									}
								}else{
									//字段名  匹配符
									sqlObject_inputs.append(" "+obj.getName()+" "+obj.getWay());
									//字符型
									sqlObject_inputs.append(" '"+value+"' ");
								}
							}
						}
						//i自增
						i++;
					}else{
						//判断是否为必填参数mustbe
						if("1".equals(mbs_map.get(obj.getAlias()))){
							//不是第一条
							if(i>0){
								sqlObject_inputs.append(" and ");
							}else{
								input_flag=true;
							}
							//字段名  匹配符
							sqlObject_inputs.append(" "+obj.getName()+" "+obj.getWay());
							//判断类型
							if(DbTypeUtils.isColumnType(DbTypeUtils.dbType.Mysql,obj.getType())){
								//数值型
								sqlObject_inputs.append(" "+0+" ");
							}else{
								//字符串型
								sqlObject_inputs.append(" '' ");
							}
							//i自增
							i++;
						}
					}
				}
				//[order by columns]获取到的排序字段
				if(obcsMap!=null && obcsMap.size()>0){
					String obc=obcsMap.get(obj.getAlias());
					//排序参数存在 
					if(obc!=null){
						String[] obc_val=obc.split("#");
						if(obc_val!=null){
							Integer key=0;
							if(Validator.isIntNumber(obc_val[1])){
								try {
									key=Integer.parseInt(obc_val[1]);
								} catch (Exception e) {
									key=0;
								}
							}
							//使用中特别说明(0升序,1降序)
							if("1".equals(obc_val[0])){
								order_map.put(key, obj.getName()+" desc");
							}else{
								order_map.put(key, obj.getName()+" asc");
							}
						}
					}
				}
			}
		}
		//接收到客户传递的参数
		if(input_flag){
			sqlObject.append(" and (");
			sqlObject.append(sqlObject_inputs);
			sqlObject.append(")");
		}
		//order
		if(order_map!=null && order_map.size()>0){
			sqlObject.append(" order by ");
			Iterable<Entry<Integer, String>> iter=order_map.entrySet();
			int i=1;
			for(Entry<Integer, String> e:iter){
				if(e!=null){
					sqlObject.append(e.getValue());
				}
				if(i<order_map.size()){
					sqlObject.append(",");
				}
				i++;
			}
		}else{
			if(StringUtils.isNotBlank(bean.getOrder())){
				if((bean.getOrder().toLowerCase()).contains("order by ")){
					sqlObject.append(" "+bean.getOrder());
				}else{
					sqlObject.append(" order by "+bean.getOrder());
				}
				
			}
		}
		
	}
	
	/**
	 * 子系统信息 manager 业务处理取得
	 * @return 子系统信息 manager 业务处理
	 */
	public IClientInfoManager getClientInfoManager() {
	    return clientInfoManager;
	}

	/**
	 * 子系统信息 manager 业务处理设定
	 * @param clientInfoManager 子系统信息 manager 业务处理
	 */
	@SuppressWarnings("static-access")
	public void setClientInfoManager(IClientInfoManager clientInfoManager) {
	    this.clientInfoManager = clientInfoManager;
	}
	/**
	 * 服务配置信息 业务处理取得
	 * @return 服务配置信息 业务处理
	 */
	public IServiceConfigManager getServiceConfigManager() {
	    return serviceConfigManager;
	}

	/**
	 * 服务配置信息 业务处理设定
	 * @param serviceConfigManager 服务配置信息 业务处理
	 */
	@SuppressWarnings("static-access")
	public void setServiceConfigManager(IServiceConfigManager serviceConfigManager) {
	    this.serviceConfigManager = serviceConfigManager;
	}
	/**
	 * test main
	 */
	public static void main(String[] args){
	}
	/**
	 * 子服务配置信息 业务处理取得
	 * @return 子服务配置信息 业务处理
	 */
	public IServiceSubInfoManager getServiceSubInfoManager() {
	    return serviceSubInfoManager;
	}
	/**
	 * 子服务配置信息 业务处理设定
	 * @param serviceSubInfoManager 子服务配置信息 业务处理
	 */
	@SuppressWarnings("static-access")
	public void setServiceSubInfoManager(IServiceSubInfoManager serviceSubInfoManager) {
	    this.serviceSubInfoManager = serviceSubInfoManager;
	}
	/**
	 * 日期转换的6个转换符 年月日时分秒取得
	 * @return 日期转换的6个转换符 年月日时分秒
	 */
	public String[] getDf() {
	    return df;
	}
}
