/*
 * 格式化工具类
 *
 * VERSION  DATE        BY              REASON
 * -------- ----------- --------------- ------------------------------------------
 * 1.00     2013.03.01  wuxiaogang        新开发
 * -------- ----------- --------------- ------------------------------------------
 * Copyright 2013 adsp System. - All Rights Reserved.
 *
 */
package cn.com.softvan.common;

import java.text.DecimalFormat;
/**
 * <p>格式化工具类</p>
 * <ol>[提供机能]
 * <li>格式化工具类
 * </ol>
 *
 * @author wuxiaogang
 */
public class ObjectFormat {

	/**
	 * 格式化 价格
	 */
	public final static String formatNum(Double num){
		DecimalFormat nf =new DecimalFormat("0.00");
		 return nf.format(num);
	}
}
