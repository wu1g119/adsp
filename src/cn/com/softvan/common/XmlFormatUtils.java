/*
 * XML格式化工具栏
 *
 * VERSION  DATE        BY           REASON
 * -------- ----------- ------------ ------------------------------------------
 * 1.00     2013-12-04  wuxiaogang   程序・发布
 * -------- ----------- ------------ ------------------------------------------
 * Copyright 2013 adsp System. - All Rights Reserved.
 *
 */
package cn.com.softvan.common;

import java.io.StringWriter;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 * XML格式化工具栏
 * 
 * @author wuxiaogang
 * 
 */
public class XmlFormatUtils{
	/** 日志 */
	private static final transient Logger log = Logger
			.getLogger(XmlFormatUtils.class);
	/**
	 * xml 格式化
	 * @param xmlStr
	 */
	public static String foramtXml(String xmlStr) {
		// System.out.println(xmlStr);
		try {
			Document doc = DocumentHelper.parseText(xmlStr);
			StringWriter writer = new StringWriter();
			OutputFormat format = OutputFormat.createPrettyPrint();//.createCompactFormat()
			format.setEncoding("UTF-8");

			XMLWriter xmlwriter = new XMLWriter(writer, format);
			xmlwriter.write(doc);
			//out 
			return writer.toString();
		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}
}
