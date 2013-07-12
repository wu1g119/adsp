<%--
/*
 * 数据提取服务配置(具体服务配置页面)
 *
 * VERSION  DATE        BY           REASON
 * -------- ----------- ------------ ------------------------------------------
 * 1.00     2013-03-14  wuxiaogang  程序・发布
 * 2.00     2013-06-04  wuxiaogang  程序・功能完善   新增itst图文分离标记(坑爹的IPTV)
 * 3.00     2013-06-05  wuxiaogang  程序・功能完善   新增osub 子服务使用出参标记  isub子服务使用入参标记
 * 4.00     2013-06-19  wuxiaogang  程序・功能完善   新增obc[活动的排序字段order by columns]标记
 * 5.00     2013-06-19  wuxiaogang  程序・功能完善   新增 [IN,>大于,<小于] 信息匹配符
 * 6.00     2013-06-20  wuxiaogang  程序・功能完善   新增 mb入参必填标记
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
<script type="text/javascript" src="${basePath}/js/config/CX002_03.js"></script>
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
<form action="${basePath}/cx/cx_config_q_configInfo.action" name="table_list2_form" id="table_list2_form" method="post" >
<input type="hidden" name="id" class="flag_bean_info_id" value="${id}" />
<c:forEach items="${dbs}" var="db">
		<input type="hidden" name="dbs" value="${db}" />
</c:forEach>
<c:forEach items="${tables}" var="table">
		<input type="hidden" name="tables" value="${table}" />
</c:forEach>
<!-- outputs -->
<table class="tablexx" width="100%" frame="box">
	<tr>
		<td colspan="9">
			<font color="blue">3.配置输出字段</font>
		</td>
	</tr>
		<tr>
			<th width="10%">表名</th>
			<th width="10%">字段名&nbsp;<input type="checkbox" name="columnschecked" id="columnschecked" value="" />(全选)</th>
			<th width="10%">字段注释</th>
			<th width="5%">字段类型</th>
			<th width="5%">可否为空</th>
			<th width="5%">键设置</th>
			<th width="5%">图文分离</th>
			<th width="5%">(子)入参</th>
			<th width="20%">别名</th>
			<th width="10%">库函数</th>
		</tr>
		<c:forEach items="${maps}" var="map" varStatus="num">
			<c:forEach varStatus="i" var="bean" items="${map.value}">
				<!-- 判断 -->
				<c:set var="xxinfo3" value="" />
				<c:set var="tt_ff" value="0" />
				<c:set var="config_alias" value=""/>
				<!-- 拼 -->
				<c:set var="tt_cc" value='${bean.table_schema}.${bean.table_name}.${bean.column_name}' />
				<!-- 标记 -->
				<c:set var="itst_check" value=""/>
				<c:set var="osub_check" value=""/>
				<c:forEach items="${old_info.outputs}" var="output">
					<c:if test="${output.name==tt_cc}">
						<c:set var="tt_ff" value="1" />
						<c:set var="xxinfo3" value="checkTR" />
						<c:set var="config_alias" value="${output.alias}"/>
						<c:if test="${output.itst=='1'}">
							<c:set var="itst_check" value='checked="checked"'/>
						</c:if>
						<c:if test="${output.osub=='1'}">
							<c:set var="osub_check" value='checked="checked"'/>
						</c:if>
					</c:if>
				</c:forEach>
			<tr class="${xxinfo3}">
				<c:if test="${i.index==0}">
					<td style="background: #fff;" rowspan="${fn:length(map.value)}"><font color="red">${num.index+1}.</font>${bean.table_schema}.${bean.table_name}
					<input type="hidden" name="output_table_name" value="${bean.table_schema}.${bean.table_name}" />
					</td>
				</c:if>
				<c:set var="pk_flag" value="0" />
				<c:if test="${bean.column_key=='PRI'}">
					<c:set var="pk_flag" value="1" />
				</c:if>
				<!-- 选中 -->
				<c:if test="${tt_ff=='1'}">
					<td><label>
					<input type="checkbox" name="output_columns_name" 
					<c:if test="${bean.column_key=='PRI'}">
						class="${bean.table_schema}_${bean.table_name}"
					</c:if>
					 checked="checked" id="${bean.table_schema}_${bean.table_name}_${bean.column_name}" value="${bean.table_schema}.${bean.table_name}.${bean.column_name}" onclick="makeGuid(${pk_flag},this,'${config_alias}')" />
					<font color="red">${bean.ordinal_position}.</font> ${bean.column_name}</label></td>
					<td>${bean.column_comment}
					<input type="hidden" name="output_columns_comment_${bean.table_schema}_${bean.table_name}_${bean.column_name}" value="${bean.column_comment}" />
					</td>
					<td>${bean.column_type}
					<input type="hidden" name="output_columns_type_${bean.table_schema}_${bean.table_name}_${bean.column_name}" value="${bean.column_type}" />
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
					<label><input type="checkbox" ${itst_check} name="output_columns_itst_${bean.table_schema}_${bean.table_name}_${bean.column_name}" id="output_columns_itst_${bean.table_schema}_${bean.table_name}_${bean.column_name}" value="1"/>&nbsp;</label>
					&nbsp;</td>
					<td>
					<label><input type="checkbox" ${osub_check} name="output_columns_osub_${bean.table_schema}_${bean.table_name}_${bean.column_name}" id="output_columns_osub_${bean.table_schema}_${bean.table_name}_${bean.column_name}" value="1"/>&nbsp;</label>
					&nbsp;</td>
					<td>
						<input readonly="readonly" type="text" alias="${bean.table_schema}.${bean.table_name}" class="textw2012 w100" name="output_columns_alias_${bean.table_schema}_${bean.table_name}_${bean.column_name}" id="output_columns_alias_${bean.table_schema}_${bean.table_name}_${bean.column_name}" value="${config_alias}" style="color:red;">
					</td>
					<td>
						<input type="text" class="textw2012 w100" name="output_columns_fun_${bean.table_schema}_${bean.table_name}_${bean.column_name}" id="output_columns_fun_${bean.table_schema}_${bean.table_name}_${bean.column_name}" value="${config_fun}" style="color:blue;">
					</td>
				</c:if>
				<!-- 没选中 -->
				<c:if test="${tt_ff=='0'}">
					<td><label>
					<input type="checkbox"
					<c:if test="${bean.column_key=='PRI'}">
						class="${bean.table_schema}_${bean.table_name}"
					</c:if>
					 name="output_columns_name"  id="${bean.table_schema}_${bean.table_name}_${bean.column_name}" value="${bean.table_schema}.${bean.table_name}.${bean.column_name}" onclick="makeGuid(${pk_flag},this,null);" />
					<font color="red">${bean.ordinal_position}.</font> ${bean.column_name}</label></td>
					<td>${bean.column_comment}
					<input type="hidden" name="output_columns_comment_${bean.table_schema}_${bean.table_name}_${bean.column_name}" value="${bean.column_comment}" />
					</td>
					<td>${bean.column_type}
					<input type="hidden" name="output_columns_type_${bean.table_schema}_${bean.table_name}_${bean.column_name}" value="${bean.column_type}" />
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
					<label><input type="checkbox" name="output_columns_itst_${bean.table_schema}_${bean.table_name}_${bean.column_name}" id="output_columns_itst_${bean.table_schema}_${bean.table_name}_${bean.column_name}" value="1"/>&nbsp;</label>
					&nbsp;</td>
					<td>
					<label><input type="checkbox" name="output_columns_osub_${bean.table_schema}_${bean.table_name}_${bean.column_name}" id="output_columns_osub_${bean.table_schema}_${bean.table_name}_${bean.column_name}" value="1"/>&nbsp;</label>
					&nbsp;</td>
					<td>
						<input type="text" class="textw2012 w100"  name="output_columns_alias_${bean.table_schema}_${bean.table_name}_${bean.column_name}" id="output_columns_alias_${bean.table_schema}_${bean.table_name}_${bean.column_name}" value="" style="color:red;">
					</td>
					<td>
						<input type="text" class="textw2012 w100" name="output_columns_fun_${bean.table_schema}_${bean.table_name}_${bean.column_name}" id="output_columns_fun_${bean.table_schema}_${bean.table_name}_${bean.column_name}" value="" style="color:blue;">
					</td>
				</c:if>
			</tr>
		</c:forEach>
	</c:forEach>
</table>

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
	<!-- 从表 -->
	<c:if test="${fn:length(maps)>1}">
		<c:forEach items="${maps}" var="map" varStatus="i">
			<!-- 存在标记 -->
			<c:set var="tt_ff" value="0" />
			<!-- 连接符 -->
			<c:set var="way" value="" />
			<!-- 表名 -->
			<c:set var="table_name" value="" />
			<!-- sql -->
			<c:set var="sql" value="" />
			<c:forEach items="${old_info.joins_other}" var="old_joins" varStatus="num">
				<c:if test="${map.key==old_joins.name}">
					<!-- 存在标记 -->
					<c:set var="tt_ff" value="1" />
					<!-- 连接符 -->
					<c:set var="way" value="${old_joins.way}" />
					<!-- 表名 -->
					<c:set var="table_name" value="${old_joins.name}" />
					<!-- sql -->
					<c:set var="sql" value="${old_joins.sql}" />
				</c:if>
			</c:forEach>
			<!-- 存在 -->
			<c:if test="${tt_ff=='1'}">
				<tr>
					<td width="50">
						从表
					</td>
					<td style="margin-left: 30px;">
						<input type="hidden" name="join_info" value="${i.index}" />
						 <select name="join_table_way_${i.index}" id="join_table_way_${i.index}" style="margin-left: 30px;">
						 	<option value="${way}">${way}</option>
						 	<option value="left join">left join</option>
						 	<option value="right join">right join</option>
						 	<option value="inner join">inner join</option>
						 </select>
						 <select name="join_table_name_${i.index}" id="join_table_name_${i.index}" style="margin-left: 30px;">
							<c:forEach items="${maps}" var="map1">
								<option <c:if test="${table_name==map1.key}"> selected="selected" </c:if>  value="${map1.key}">${map1.key}</option>
							</c:forEach>
						</select><font color="red"  style="margin-left: 20px;">on</font>
						<br/>
						<font color="red" style="margin-left: 0px;float:left;">查询sql关联信息</font>
						<br/>
						<textarea name="join_table_sql_${i.index}" style="width: 97%;height: 50px;border: 1px solid #999;font-size: 18px;">${sql}</textarea>
					
					</td>
				</tr>
			</c:if>
			<!-- 不存在 -->
			<c:if test="${(old_info==null&&i.index!=0)||(old_info!=null&&tt_ff=='0' && map.key!=old_info.joins_main)}">
				<tr>
					<td width="50">
						从表
					</td>
					<td style="margin-left: 30px;">
						<input type="hidden" name="join_info" value="${i.index}" />
						 <select name="join_table_way_${i.index}" id="join_table_way_${i.index}" style="margin-left: 30px;">
						 	<option value="left join">left join</option>
						 	<option value="right join">right join</option>
						 	<option value="inner join">inner join</option>
						 </select>
						 <select name="join_table_name_${i.index}" id="join_table_name_${i.index}" style="margin-left: 30px;">
							<c:forEach items="${maps}" var="map1" varStatus="num1">
								<option <c:if test="${num1.index==i.index}"> selected="selected" </c:if> value="${map1.key}">${map1.key}</option>
							</c:forEach>
						</select><font color="red"  style="margin-left: 20px;">on</font>
						<br/>
						<font color="red" style="margin-left: 0px;float:left;">查询sql关联信息</font>
						<br/>
						<textarea name="join_table_sql_${i.index}" style="width: 97%;height: 50px;border: 1px solid #999;font-size: 18px;"></textarea>
					
					</td>
				</tr>
			</c:if>
		</c:forEach>
	</c:if>
</table> 
<!-- where固定条件 -->
<table class="tablexx" width="100%" frame="box">
	<tr>
		<td>
			<font color="blue">5.配置数据提取条件(固定条件)</font>
		</td>
	</tr>
	<tr>
		<td style="text-align: center;">
			<font color="red" style="margin-left: 20px;float:left;">查询sql条件,去掉where关键字</font>
			<textarea name="sql_where" style="width: 97%;height: 50px;border: 1px solid #999;font-size: 18px;">${old_info.where}</textarea>
		</td>
	</tr>
</table>
<!-- where活动参数 inputs -->
<table class="tablexx" width="100%" frame="box">
	<tr>
		<td colspan="12">
			<font color="blue">6.配置数据提取条件(参数)</font>
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
			<th width="5%">数据匹配符</th>
			<th width="5%">(主)出参</th>
			<th width="5%">排序</th>
			<th width="5%">必填</th>
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
				<!-- 标记 -->
				<c:set var="isub_check" value=""/>
				<c:set var="obc_check" value=""/>
				<c:set var="mb_check" value=""/>
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
						<c:if test="${config.isub=='1'}">
							<c:set var="isub_check" value='checked="checked"'/>
						</c:if>
						<c:if test="${config.obc=='1'}">
							<c:set var="obc_check" value='checked="checked"'/>
						</c:if>
						<c:if test="${config.mb=='1'}">
							<c:set var="mb_check" value='checked="checked"'/>
						</c:if>
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
					<select class="textw2012 w100" name="input_columns_way_${bean.table_schema}_${bean.table_name}_${bean.column_name}" id="input_columns_way_${bean.table_schema}_${bean.table_name}_${bean.column_name}">
					 	<option value="like">模糊</option>
					 	<option value="="  <c:if test="${config_way=='='}"> selected="selected" </c:if> >精确</option>
					 	<option value="x3" <c:if test="${config_way=='x3'}"> selected="selected" </c:if>>区间</option>
					 	<option value="x4" <c:if test="${config_way=='x4'}"> selected="selected" </c:if>>IN</option>
					 	<option value="x1" <c:if test="${config_way=='x1'}"> selected="selected" </c:if>>小于</option>
					 	<option value="x5" <c:if test="${config_way=='x5'}"> selected="selected" </c:if>>小于等于</option>
					 	<option value="x2" <c:if test="${config_way=='x2'}"> selected="selected" </c:if>>大于</option>
					 	<option value="x6" <c:if test="${config_way=='x6'}"> selected="selected" </c:if>>大于等于</option>
					 	<option value="!=" <c:if test="${config_way=='!='}"> selected="selected" </c:if>>不等于</option>
					 </select>	
					 </td>
					 <td>
					 <label><input type="checkbox" ${isub_check} name="input_columns_isub_${bean.table_schema}_${bean.table_name}_${bean.column_name}" id="input_columns_isub_${bean.table_schema}_${bean.table_name}_${bean.column_name}" value="1"/>&nbsp;</label>
					&nbsp;</td>
					<td>
					 <label><input type="checkbox" ${obc_check} name="input_columns_obc_${bean.table_schema}_${bean.table_name}_${bean.column_name}" id="input_columns_obc_${bean.table_schema}_${bean.table_name}_${bean.column_name}" value="1"/>&nbsp;</label>
					&nbsp;</td>
					<td>
					 <label><input type="checkbox" ${mb_check} name="input_columns_mb_${bean.table_schema}_${bean.table_name}_${bean.column_name}" id="input_columns_mb_${bean.table_schema}_${bean.table_name}_${bean.column_name}" value="1"/>&nbsp;</label>
					&nbsp;</td>
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
					<select class="textw2012 w100" name="input_columns_way_${bean.table_schema}_${bean.table_name}_${bean.column_name}" id="input_columns_way_${bean.table_schema}_${bean.table_name}_${bean.column_name}">
					 	<option value="=">精确</option>
					 	<option value="like">模糊</option>
					 	<option value="x3">区间</option>
					 	<option value="x4">IN</option>
					 	<option value="x1">小于</option>
					 	<option value="x5">小于等于</option>
					 	<option value="x2">大于</option>
					 	<option value="x6">大于等于</option>
					 	<option value="!=">不等于</option>
					 </select>	
					 </td>
					 <td>
					 <label><input type="checkbox"  name="input_columns_isub_${bean.table_schema}_${bean.table_name}_${bean.column_name}" id="input_columns_isub_${bean.table_schema}_${bean.table_name}_${bean.column_name}" value="1"/>&nbsp;</label>
					&nbsp;</td>
					<td>
					 <label><input type="checkbox"  name="input_columns_obc_${bean.table_schema}_${bean.table_name}_${bean.column_name}" id="input_columns_obc_${bean.table_schema}_${bean.table_name}_${bean.column_name}" value="1"/>&nbsp;</label>
					&nbsp;</td>
					<td>
					 <label><input type="checkbox"  name="input_columns_mb_${bean.table_schema}_${bean.table_name}_${bean.column_name}" id="input_columns_mb_${bean.table_schema}_${bean.table_name}_${bean.column_name}" value="1"/>&nbsp;</label>
					&nbsp;</td>
				</c:if>
			</tr>
		</c:forEach>
	</c:forEach>
</table>
<table class="tablexx" width="100%" frame="box">
	<tr>
		<td >
			<font color="blue">7.数据排序sql</font>
		</td>
	</tr>
	<tr>
		<td style="text-align: center;">
			<font color="red" style="margin-left: 20px;float:left;">排序</font>
			<textarea name="sql_order" style="width: 97%;height: 50px;border: 1px solid #999;font-size: 18px;">${old_info.order}</textarea>
		</td>
	</tr>
</table>
<table class="tablexx" width="100%" frame="box">
	<tr>
		<td style="text-align: center;">
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