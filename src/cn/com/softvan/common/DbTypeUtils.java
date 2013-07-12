/*
 * 数据字段类型匹 处理  工具类
 *
 * VERSION  		DATE       			 BY              REASON
 * -------- ----------- --------------- ------------------------------------------
 * 1.00     	    2013.03.12  	 	wuxiaogang       程序・发布                 
 * -------- ----------- --------------- ------------------------------------------
 * Copyright 2013 adsp System. - All Rights Reserved.
 *
 */

package cn.com.softvan.common;



public class DbTypeUtils {
	//数据库类型
	public static enum dbType{Oracle,Sybase,Informix,SQLServer,Access,DB2,Mysql}
	/**
	 * 类型处理
	 * @param str
	 * @return type
	 */
	public static String typeCure(String str){
		if(str!=null){
			return str.replaceAll("\\([^\\)]*\\)", "");
		}
		return null;
	}
	/**
	 * 判断当前字段是否是数值型 
	 * @param dbType 枚举类型
	 * @param XmlNodeBean
	 * @return boolean true:数值型 false:字符串型
	 */
	public static boolean isColumnType(dbType db,String columnType){
		boolean flag=true;
		//数据库类型  Mysql,Oracle,Sybase,Informix,SQLServer,Access,DB2
		//获取mysql字段类型
		String type=typeCure(columnType);
		switch (db) {
			case Mysql:
				if(" TINYINT TINYINT BIT BOOL SMALLINT INT INTEGER BIGINT FLOAT DOUBLE REAL DECIMAL DEC NUMERIC FUN ".contains(StrUtils.toUpperCase(type))){
					//数值型 
					flag=true;
				}else{
					//字符串型
					flag=false;
				}
				break;
			case Oracle:
				if(type.contains("")){
					//数值型
				}else{
					//字符串型
				}
				break;
			case Sybase:
				if(type.contains("")){
					//数值型
				}else{
					//字符串型
				}
				break;
			case Informix:
				if(type.contains("")){
					//数值型
				}else{
					//字符串型
				}
				break;
			case SQLServer:
				if(type.contains("")){
					//数值型
				}else{
					//字符串型
				}
				break;
			case Access:
				if(type.contains("")){
					//数值型
				}else{
					//字符串型
				}
				break;
			case DB2:
				if(type.contains("")){
					//数值型
				}else{
					//字符串型
				}
				break;
			default:
				break;
		}
		return flag;
	}
}
