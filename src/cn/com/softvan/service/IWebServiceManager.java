/*
 * WebService  manager 接口类
 *
 * VERSION  DATE        BY              REASON
 * -------- ----------- --------------- ------------------------------------------
 * 1.00     2013.03.11  wuxiaogang           程序・发布
 * -------- ----------- --------------- ------------------------------------------
 * Copyright 2013 adsp System. - All Rights Reserved.
 *
 */
package cn.com.softvan.service;


/**
 * WebService manager 接口类
 * 
 * @author {wuxiaogang}
 * 
 */
public interface IWebServiceManager {
	
	/**
	 * <div>
	 * 	<li>获取信息</li>
	 * </div>
	 * @param info
	 * @param ip
	 * @return info
	 */
	public String getInfo(String info,String ip);
	/**
	 * <div>
	 * 	<li>修改信息</li>
	 * </div>
	 * @param info
	 * @param ip
	 * @return info
	 */
	public String modifyInfo(String info,String ip);
	/**
	 * <div>
	 * 	<li>保存信息</li>
	 * </div>
	 * @param info
	 * @return info
	 */
	public String saveInfo(String info,String ip);
	/**
	 * <div>
	 * 	<li>合并信息</li>
	 * </div>
	 * @param info
	 * @param ip
	 * @return info
	 */
	public String mergerInfo(String info,String ip);
	/**
	 * <div>
	 * 	<li>删除信息</li>
	 * </div>
	 * @param info
	 * @param ip
	 * @return info
	 */
	public String delInfo(String info,String ip);
	
}
