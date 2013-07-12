<%--
/*
 * 接口监控日志显示(筛选)
 *
 * VERSION  DATE        BY           REASON
 * -------- ----------- ------------ ------------------------------------------
 * 1.00     2013-03-08  wuxiaogang        程序・发布
 * -------- ----------- ------------ ------------------------------------------
 * Copyright 2013 adsp System. - All Rights Reserved.
 *
 */
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" session="false"%>
<%@page import="cn.com.softvan.common.CommonConstant"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="customtag" uri="/custom-tags"%>
<form action="${basePath}/lx/lx_service_list1.action" name="lx_service_list1_form" id="lx_service_list1_form" method="post" >
	<input type="hidden" name="offset" id="offsetA" value="0">
	<table class="tablexx" width="100%">
		<tr>
			<th colspan="4" >系统日志-->接口监控日志
			<div style="float: right;">
			</div>
			</th>
		</tr>
		<tr>
			<td>调用系统
			</td>
			<td>
			<input class="textw2012 w100" type="text" name="bean.system">
			</td>
			<td>
			接口名称
			</td>
			<td>
			<input  class="textw2012 w100" type="text" name="bean.port_name">
			</td>
		</tr>
		<tr>
			<td>服务名称
			</td>
			<td>
			<input  class="textw2012 w100" type="text" name="bean.service_name">
			</td>
			<td>
			接口语言
			</td>
			<td>
			<input  class="textw2012 w100" type="text" name="bean.language">
			</td>
		</tr>
		<tr>
			<td>时间区间
			</td>
			<td colspan="3">
				<input name="bean.date1" readonly="readonly" id="birthday" type="text" class="kd Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
				~
				<input name="bean.date2" readonly="readonly" id="birthday" type="text" class="kd Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
			</td>
		</tr>
		<tr>
			<td>
				异常信息
			</td>
			<td colspan="3">
			<label><input type="checkbox" value="1" name="bean.error_msg">异常日志</label>
			</td>
		</tr>
		<tr>
			<td colspan="4" align="center">
			<div align="center">
				<input type="button" onclick="this.disabled=true;this.className='btn1';submitFrom1(0,'lx_service_list1_form', null, 'div_info_list_2',this);" class="btn" value="搜索"  />
			</div>
			</td>
		</tr>
	</table>
</form>
<div id="div_info_list_2"></div>
<script type="text/javascript">submitFrom1(0,'lx_service_list1_form', null, 'div_info_list_2',null);</script>
