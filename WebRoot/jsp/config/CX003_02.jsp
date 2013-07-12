<%--
/*
 * 数据新增服务配置(数据库数据表列表 选择页面)
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
<form action="${basePath}/cx/cx_config_i_list2.action" name="table_list1_form" id="table_list1_form" method="post" >
	<c:forEach items="${dbs}" var="db">
		<input type="hidden" name="dbs" value="${db}" />
	</c:forEach>
	<input type="hidden" name="id" class="flag_bean_info_id" value="${id}" />
	<table class="tablexx" width="100%" frame="box">
		<tr>
			<td colspan="10">
				<font color="blue">2.选择数据表</font>
			</td>
		</tr>
		<tr>
			<th width="5%"></th>
			<th width="5%">数据库</th>
			<th width="15%">表名</th>
			<th width="15%">表备注</th>
			<th width="5%">版本</th>
			<th width="5%">总记录</th>
			<th width="15%">平均数据记录字节长度</th>
			<th width="10%">总记录字节长度</th>
			<th width="5%">表创建时间</th>
			<th width="5%">表修改时间</th>
		</tr>
		<c:forEach varStatus="i" var="bean" items="${tables}">
			<c:set var="db_table"  value="${bean.table_schema}.${bean.table_name}" />
			<c:set var="xxinfo1" value=""/>
			<c:set var="xxinfo2" value="0"/>
			<c:forEach  var="old_bean" items="${old_tables}">
				<c:if test="${db_table==old_bean.name}">
					<c:set var="xxinfo1" value='checkTR'/>
					<c:set var="xxinfo2" value='1'/>
				</c:if>
			</c:forEach>
			<tr class='${xxinfo1}'>
				<td>
				<label><input type="radio" 
				<c:if test="${xxinfo2=='1'}">
					checked="checked"
				</c:if>
				 name="tableName" value="${bean.table_schema}.${bean.table_name}"/>
				${i.index+1+offsetA}</label>
				</td>
				<td>${bean.table_schema} &nbsp;</td>
				<td>${bean.table_name} &nbsp;</td>
				<td>${bean.table_comment} &nbsp;</td>
				<td>${bean.version} &nbsp;</td>
				<td>${bean.table_rows} &nbsp;</td>
				<td>${bean.avg_row_length} &nbsp;</td>
				<td>${bean.data_length} &nbsp;</td>
				<td>${bean.create_time} &nbsp;</td>
				<td>${bean.update_time} &nbsp;</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="10" style="text-align: center;">
				<input type="button" onclick="if(checkInfo('tableName','radio')){submitFrom2('div_table_columns_list','table_list1_form',null);}else{myAlert('请选择你要操作的数据库表!');}" class="btn" value="NEXT" />
			</td>
		</tr>
	</table>
</form>
<div class="clear"></div>
<!-- 数据库表 字段集合 -->
<div id="div_table_columns_list"></div>
<c:if test="${old_tables!=null}">
	<script>submitFrom2('div_table_columns_list','table_list1_form',null);</script>
</c:if>