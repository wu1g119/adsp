<%--
/*
 * 接口服务配置(服务类型选择页面)
 *
 * VERSION  DATE        BY           REASON
 * -------- ----------- ------------ ------------------------------------------
 * 1.00     2013-03-14  wuxiaogang        程序・发布
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
<form action="${basePath}/cx/cx_info_forward.action" name="strategy_init_form_type" id="strategy_init_form_type" method="post" >
<table class="tablexx" width="100%" frame="box">
	<tr>
		<th colspan="4">
			<font color="blue">0.选择服务类型</font>
		</th>
	</tr>
	<tr>
		<td>
			<label><input type="radio" checked="checked" value="Q" name="s_type">查询数据服务</label>
		</td>
		<td>
			<label><input type="radio" disabled="disabled" value="I" name="s_type">新增数据服务(...)</label>
		</td>
		<td>
			<label><input type="radio" disabled="disabled" value="U" name="s_type">修改数据服务(...)</label>
		</td>
		<td>
			<label><input type="radio" disabled="disabled" value="D" name="s_type">删除数据服务(...)</label>
		</td>
	</tr>
	<tr>
		<td colspan="10" style="text-align: center;">
			<input type="button" onclick="if(checkInfo('s_type','radio')){submitFrom2('service_config_init','strategy_init_form_type',null);}else{myAlert('请选择服务类型!');}" class="btn" value="NEXT" />
		</td>
	</tr>
</table>
</form>
<!-- 服务配置页面 -->
<div id="service_config_init"></div>