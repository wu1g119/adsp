/*
 * 字符串处理
 *
 * VERSION  DATE        BY           REASON
 * -------- ----------- ------------ ------------------------------------------
 * 1.00     2013-12-07  wuxiaogang   程序・发布
 * -------- ----------- ------------ ------------------------------------------
 * Copyright 2013 adsp System. - All Rights Reserved.
 *
 */

package cn.com.softvan.common;

/**
 * <p>字符串处理</p>
 * @author wuxiaogang
 *
 */
public class StrUtils {
	/**
	 * 字符串替换
	 * @param str
	 * @return
	 */
	public static String replaceAll(String str,String regex,String replacement){
		if(str!=null){
			return str.replaceAll(regex, replacement);
		}
		return "";
	}
	/**
	 * 字符串转换为大写
	 * @param str
	 * @return
	 */
	public static String toUpperCase(String str){
		if(str!=null){
			return str.toUpperCase();
		}
		return "";
	}
	/**
	 * 字符串转换为小写
	 * @param str
	 * @return
	 */
	public static String toLowerCase(String str){
		if(str!=null){
			return str.toLowerCase();
		}
		return "";
	}
}
