<%--
/*
 * 数据新增服务配置(服务配置结果查看页面)
 *
 * VERSION  DATE        BY           REASON
 * -------- ----------- ------------ ------------------------------------------
 * 1.00     2013-03-14  wuxiaogang  程序・发布
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
<script type="text/javascript" src="${basePath}/js/config/CX001_04.js"></script>

<form action="${basePath}/cx/cx_config_i_saveConfigInfo.action" name="table_configInfo_form" id="table_configInfo_form" method="post" >
<table class="tablexx" width="100%" frame="box">
	<tr>
		<td>
			<font color="blue">6.查看配置结果</font>
		</td>
	</tr>
	<tr>
		<td>
			<font color="blue">生成SQL</font>
		</td>
	</tr>
	<tr>
		<td>
			${sql}
			<input type="hidden"  name="sql" value="${sql}" />
		</td>
	</tr>
	<!-- xxxxxxx生成配置信息xxxxxxxxxxxxxxxxxxxx -->
	<tr>
		<th>
			<font color="blue">生成配置信息</font>${error_msg}
		</th>
	</tr>
	<tr>
		<td valign="top" id="Canvas_div">
					<textarea id="RawJson" class="chackTextarea-area hide" name="bean.config">${jsonConfg}</textarea>
					<div id="Canvas" class="Canvas" style="width: 1000px;height: 100px;overflow: auto;"></div>
					<script type="text/javascript">Process('RawJson','Canvas');</script>
		</td>
	</tr>
	<!-- xxxxxxxx服务调用数据实例xxxxxxxxxxxxxxxxxxx -->
	<tr>
		<th>
			<font color="blue">服务调用参数实例</font>${error_msg_input}
		</th>
	</tr>
	<tr>
		<td id="Canvas2_div">
			<textarea id="RawJson2" class="chackTextarea-area hide" name="jsonInput">${jsonInput}</textarea>
			<div id="Canvas2" class="Canvas" style="width: 1000px;height: 100px;overflow: scroll;"></div>
			<script type="text/javascript">Process('RawJson2','Canvas2');</script>
		</td>
	</tr>
	<!-- xxxxxxxx服务返回数据实例xxxxxxxxxxxxxxxxxxx -->
	<tr>
		<th>
			<font color="blue">服务返回数据实例</font>${error_msg_output}
		</th>
	</tr>
	<tr>
		<td id="Canvas3_div">
			<textarea id="RawJson3" class="chackTextarea-area hide"  name="jsonOutput">${jsonOutput}</textarea>
			<div id="Canvas3" class="Canvas" style="width: 1000px;height: 100px;overflow: scroll;"></div>
			<script type="text/javascript">Process('RawJson3','Canvas3');</script>
		</td>
	</tr>
</table>
<!-- 主表数据库 -->
<input type="hidden" name="bean.db_name" value="${db_name}" />
<!-- 主表 -->
<input type="hidden" name="bean.db_table_name" value="${db_table_name}" />
<table class="tablexx" width="100%" frame="box">
	<tr>
		<td>
			<font color="blue">7.填写新增服务基本信息</font>
		</td>
	</tr>
	<tr>
		<th width="20%">
			ID
		</th>
		<td>
			<input type="hidden" class="flag_bean_info_id" name="bean.id" value="${bean.id}" /><label id="flag_bean_info_id_label">${bean.id}</label>
		</td>
	</tr>
	<tr>
		<th width="20%">
			服务类型
		</th>
		<td>
			<input type="hidden" class="textw2012 w70" name="bean.type" value="I" />I新增
		</td>
	</tr>
	<tr>
		<th width="20%">
			服务调用名
		</th>
		<td>
			<input type="text" class="textw2012 w70" name="bean.name" value="${bean.name}" />
		</td>
	</tr>
	<tr>
		<th width="20%">
			服务中文注释
		</th>
		<td>
			<input type="text" class="textw2012 w70"name="bean.note" value="${bean.note}" />
		</td>
	</tr>
	<tr>
		<th width="20%">
			服务状态
		</th>
		<td>
			<c:set var="status1" value="" />
			<c:set var="status2" value="" />
			<c:choose>
				<c:when test="${bean.status=='1'}">
					<c:set var="status1" value="checked='checked'" />
				</c:when>
				<c:otherwise>
					<c:set var="status2" value="checked='checked'" />
				</c:otherwise>
			</c:choose>
			<label><input type="radio" ${status1} name="bean.status" value="1" />启用</label>
			<label><input type="radio" ${status2} name="bean.status" value="0" />停用</label>
		</td>
	</tr>
	<tr>
		<td colspan="2" style="text-align: center;">
			<input type="button" onclick="initValidateSt00104();if(st00104Validator.form()){this.disabled=true;this.className='btn1';saveConfigInfo('${basePath}/cx/cx_config_i_saveConfigInfo.action');this.disabled=false;this.className='btn';}" class="btn" value="保存" />
		</td>
	</tr>
</table>
</form>
<script type="text/javascript">
	$('#Canvas').width($('#Canvas_div').width());
	$('#Canvas2').width($('#Canvas2_div').width());
	$('#Canvas3').width($('#Canvas3_div').width());
</script>

