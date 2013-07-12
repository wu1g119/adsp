/*
 * 接口传输复杂对象 封装类
 *
 * VERSION  DATE        BY              REASON
 * -------- ----------- --------------- ------------------------------------------
 * 1.00     2012.11.26  wuxiaogang           程序发布
 * -------- ----------- --------------- ------------------------------------------
 * Copyright 2012 adsp System. - All Rights Reserved.
 *
 */
package cn.com.softvan.bean.cxf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.com.softvan.bean.sourcedb.TableColumnsBean;

/**
 * 接口传输复杂对象 封装类
 * @author {wuxiaogang}
 *
 */
public class WebXmlObject {
	//INIT
	public WebXmlObject(){}
	
	private ArrayList<Object> list;
	private Object[] array;
	private HashMap<Object,Object> map;
	private HashMap<Object,ArrayList<Object>> maps;
	private List<TableColumnsBean> tableColumnsBean;
	/**
	 * list取得
	 * @return list
	 */
	public ArrayList<Object> getList() {
	    return list;
	}
	/**
	 * list設定
	 * @param list list
	 */
	public void setList(ArrayList<Object> list) {
	    this.list = list;
	}
	/**
	 * array取得
	 * @return array
	 */
	public Object[] getArray() {
	    return array;
	}
	/**
	 * array設定
	 * @param array array
	 */
	public void setArray(Object[] array) {
	    this.array = array;
	}
	/**
	 * map取得
	 * @return map
	 */
	public HashMap<Object,Object> getMap() {
	    return map;
	}
	/**
	 * map設定
	 * @param map map
	 */
	public void setMap(HashMap<Object,Object> map) {
	    this.map = map;
	}
	/**
	 * maps取得
	 * @return maps
	 */
	public HashMap<Object,ArrayList<Object>> getMaps() {
	    return maps;
	}
	/**
	 * maps設定
	 * @param maps maps
	 */
	public void setMaps(HashMap<Object,ArrayList<Object>> maps) {
	    this.maps = maps;
	}
	/**
	 * tableColumnsBean取得
	 * @return tableColumnsBean
	 */
	public List<TableColumnsBean> getTableColumnsBean() {
	    return tableColumnsBean;
	}
	/**
	 * tableColumnsBean設定
	 * @param tableColumnsBean tableColumnsBean
	 */
	public void setTableColumnsBean(List<TableColumnsBean> tableColumnsBean) {
	    this.tableColumnsBean = tableColumnsBean;
	}
}
