<%--
/*
 * 数据新增服务配置(具体服务配置页面)
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
<script type="text/javascript" src="${basePath}/js/config/CX001_03.js"></script>
<script type="text/javascript">
$(function(){
	//模拟复选框选择
	$("#columnschecked").click(function(){
		var obj_=$("input[type='checkbox'][name='columns_name']");
		var obj_flag=false;
		if($(this).attr("checked")){
			obj_flag=true;
		}
		obj_.each(function(i,item){
			$(item).attr("checked",obj_flag);
 			
 			$(item).click();
 		   	
			$(item).attr("checked",obj_flag);
		});
	});
});
</script>
<form action="${basePath}/cx/cx_config_i_configInfo.action" name="table_list2_form" id="table_list2_form" method="post" >
<input type="hidden" name="id" class="flag_bean_info_id" value="${id}" />
<c:forEach items="${dbs}" var="db">
		<input type="hidden" name="dbs" value="${db}" />
</c:forEach>
<c:forEach items="${tables}" var="table">
		<input type="hidden" name="tables" value="${table}" />
</c:forEach>

<table class="tablexx" width="100%" frame="box">
	<tr>
		<td colspan="2">
			<font color="blue">4.配置表间关联关系</font>
		</td>
	</tr> 
	<!-- 主表 -->
	<tr>
		<td width="50">
			主表
		</td>
		<td style="margin-left: 30px;">
			 FROM 
			 <select name="main_table_name" id="main_table_name" style="margin-left: 30px;">
				<c:forEach items="${maps}" var="map" varStatus="num">
					<option 
					<c:if test="${old_info.joins_main==map.key}">
			 		selected="selected" 
			 		</c:if>
					value="${map.key}">${map.key}</option>
				</c:forEach>
			</select>
		</td>
	</tr>
</table> 
<!-- 活动参数 inputs -->
<table class="tablexx" width="100%" frame="box">
	<tr>
		<td colspan="6">
			<font color="blue">6.配置数据新增条件(参数)</font>
		</td>
	</tr>
		<tr>
			<th width="10%">表名</th>
			<th width="10%">字段名&nbsp;<input type="checkbox" name="columnschecked" id="columnschecked" value="" />(全选)</th>
			<th width="10%">字段注释</th>
			<th width="5%">字段类型</th>
			<th width="5%">可否为空</th>
			<th width="5%">键设置</th>
			<th width="10%">别名</th>
			<th width="10%">默认值</th>
			<th width="5%"></th>
		</tr>
		<c:forEach items="${maps}" var="map" varStatus="num">
			<c:forEach varStatus="i" var="bean" items="${map.value}">
				<!-- 判断 -->
				<c:set var="xxinfo3" value="" />
				<c:set var="tt_ff" value="0" />
				<c:set var="config_alias" value=""/>
				<c:set var="config_is_val" value=""/>
				<c:set var="config_value" value=""/>
				<c:set var="config_way" value=""/>
				<!-- 拼 -->
				<c:set var="tt_cc" value='${bean.table_schema}.${bean.table_name}.${bean.column_name}' />
				<c:forEach items="${old_info.inputs}" var="config">
					<c:if test="${config.name==tt_cc}">
						<c:set var="tt_ff" value="1" />
						<c:set var="xxinfo3" value="checkTR" />
						<c:set var="config_alias" value="${config.alias}"/>
						<c:set var="config_is_val" value="${config.is_val}"/>
						<c:set var="config_value" value="${config.value}"/>
						<c:set var="config_way" value="${config.way}"/>
					</c:if>
				</c:forEach>
			<tr class="${xxinfo3}">
				<c:if test="${i.index==0}">
					<td style="background: #fff;" rowspan="${fn:length(map.value)}"><font color="red">${num.index+1}.</font>${bean.table_schema}.${bean.table_name}
					<input type="hidden" name="input_table_name" value="${bean.table_schema}.${bean.table_name}" />
					</td>
				</c:if>
				<c:set var="pk_flag" value="0" />
				<c:if test="${bean.column_key=='PRI'}">
					<c:set var="pk_flag" value="1" />
				</c:if>
				<!-- 选中 -->
				<c:if test="${tt_ff=='1'}">
					<td><label>
					<input type="checkbox" name="input_columns_name" 
					<c:if test="${bean.column_key=='PRI'}">
						class="${bean.table_schema}_${bean.table_name}"
					</c:if>
					 checked="checked" id="${bean.table_schema}_${bean.table_name}_${bean.column_name}" value="${bean.table_schema}.${bean.table_name}.${bean.column_name}" onclick="makeGuid(${pk_flag},this,'${config_alias}')" />
					<font color="red">${bean.ordinal_position}.</font> ${bean.column_name}</label></td>
					<td>${bean.column_comment}
					<input type="hidden" name="input_columns_comment_${bean.table_schema}_${bean.table_name}_${bean.column_name}" value="${bean.column_comment}" />
					</td>
					<td>${bean.column_type}
					<input type="hidden" name="input_columns_type_${bean.table_schema}_${bean.table_name}_${bean.column_name}" value="${bean.column_type}" />
					</td>
					<td>${bean.is_nullable}</td>
					<td>
						<c:if test="${bean.column_key=='PRI'}">
							主键
						</c:if>
						<c:if test="${bean.column_key=='UNI'}">
							唯一约束
						</c:if> 
						<c:if test="${bean.column_key=='MUL'}">
							外键
						</c:if>
						 &nbsp;
					</td>
					<td>
						<input readonly="readonly" type="text" alias="${bean.table_schema}.${bean.table_name}" class="textw2012 w100" name="input_columns_alias_${bean.table_schema}_${bean.table_name}_${bean.column_name}" id="input_columns_alias_${bean.table_schema}_${bean.table_name}_${bean.column_name}" value="${config_alias}" style="color:red;">
					</td>
					<td><input class="textw2012 fl"
					<c:if test="${config_is_val=='1'}">
						checked="checked"
					</c:if>
					 value="1" type="checkbox" name="input_columns_is_val_${bean.table_schema}_${bean.table_name}_${bean.column_name}"><input class="textw2012 w80" type="text" name="input_columns_value_${bean.table_schema}_${bean.table_name}_${bean.column_name}" value="${config_value}"></td>
					<td>
					 </td>
				</c:if>
				<!-- 没选中 -->
				<c:if test="${tt_ff=='0'}">
					<td><label>
					<input type="checkbox"
					<c:if test="${bean.column_key=='PRI'}">
						class="${bean.table_schema}_${bean.table_name}"
					</c:if>
					 name="input_columns_name"  id="${bean.table_schema}_${bean.table_name}_${bean.column_name}" value="${bean.table_schema}.${bean.table_name}.${bean.column_name}" onclick="makeGuid(${pk_flag},this,null);" >
					<font color="red">${bean.ordinal_position}.</font> ${bean.column_name}</label></td>
					<td>${bean.column_comment}
					<input type="hidden" name="input_columns_comment_${bean.table_schema}_${bean.table_name}_${bean.column_name}" value="${bean.column_comment}" />
					</td>
					<td>${bean.column_type}
					<input type="hidden" name="input_columns_type_${bean.table_schema}_${bean.table_name}_${bean.column_name}" value="${bean.column_type}" />
					</td>
					<td>${bean.is_nullable}</td>
					<td>
						<c:if test="${bean.column_key=='PRI'}">
							主键
						</c:if>
						<c:if test="${bean.column_key=='UNI'}">
							唯一约束
						</c:if> 
						<c:if test="${bean.column_key=='MUL'}">
							外键
						</c:if>
						 &nbsp;
					</td>
					<td>
						<input type="text" class="textw2012 w100"  name="input_columns_alias_${bean.table_schema}_${bean.table_name}_${bean.column_name}" id="columns_alias_${bean.table_schema}_${bean.table_name}_${bean.column_name}" value="" style="color:red;">
					</td>
					<td><input class="textw2012 fl" value="1" type="checkbox" name="input_columns_is_val_${bean.table_schema}_${bean.table_name}_${bean.column_name}"><input class="textw2012 w80" type="text" name="input_columns_value_${bean.table_schema}_${bean.table_name}_${bean.column_name}" ></td>
					<td>
					 </td>
				</c:if>
			</tr>
		</c:forEach>
	</c:forEach>
</table>
<table class="tablexx" width="100%" frame="box">
	<tr>
		<td colspan="10" style="text-align: center;">
			<input type="button" onclick="if(checkSt0103()){submitFrom2('div_table_config_info','table_list2_form',null);}" class="btn" value="NEXT" />
		</td>
	</tr>
</table>
</form>
<div class="clear"></div>
<!-- 服务详细配置 -->
<div id="div_table_config_info"></div>
<c:if test="${old_info!=null}">
	<script>submitFrom2('div_table_config_info','table_list2_form',null);</script>
</c:if>