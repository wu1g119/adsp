<%--
/*
 * 数据提取服务配置(数据库选择页面)
 *
 * VERSION  DATE        BY           REASON
 * -------- ----------- ------------ ------------------------------------------
 * 1.00     2013-03-07  wuxiaogang  程序・发布
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
<script type="text/javascript">
//为每个字段生成别名
function makeGuid(pk_flag,obj,alias){
	/*if(obj.checked){
		var uuid=guid();
		if(alias!=null){
			uuid=alias;
		}
		if(pk_flag==1){
			$('#columns_pk_alias_'+obj.id).attr('value',uuid);
		}
		$('#columns_alias_'+obj.id).attr('value',uuid);
	}else{
		if(pk_flag==1){
			$('#columns_pk_alias_'+obj.id).attr('value','');
		}
		$('#columns_alias_'+obj.id).attr('value','');
	}*/
}
//保存配置信息
function saveConfigInfo(from_action){
	//改变提交地址
	if(from_action!=null){
		jQuery("#table_configInfo_form").attr('action',from_action);
	}
	jQuery("#table_configInfo_form").ajaxSubmit(function(data) {
		try{
			var obj = eval( "(" + data + ")" );//转换后的JSON对象
			if (obj.info == "1") {
				//赋值
				$('.flag_bean_info_id').each(function(){ 
					$(this).attr("value",obj.id);
					//最后一个模块页面
					if($(this).attr("name")=='bean.id'){
						$('#flag_bean_info_id_label').html(obj.id);
					}
				}); 
				myAlert('保存成功!');
			} else {
				myAlert(obj.info);
			}
		}catch(e){alert(e);}
	});
}

</script>

<form action="${basePath}/cx/cx_config_q_list1.action" name="table_db_form" id="table_db_form" method="post" >
<input type="hidden" name="id" class="flag_bean_info_id" value="${id}" />
<table class="tablexx" width="100%" frame="box">
	<tr>
		<td colspan="6">
			<font color="blue">1.选择数据库</font>
		</td>
	</tr>
	<tr>
		<th width="5%"></th>
		<th width="10%">数据库名称</th>
		<th width="10%">默认字符集名称</th>
		<th width="10%">默认排序规则名</th>
		<th width="10%">sql路径</th>
		<th width="10%">目录名</th>
	</tr>
	<c:forEach var="bean" items="${dbs}" varStatus="i">
		<c:set var="xxinfo0" value="0" />
		<c:set var="xxinfo1" value="" />
		<c:forEach  var="old_db" items="${old_dbs}">
			<c:if test="${old_db.name==bean.schema_name}">
				<c:set var="xxinfo0" value="1" />
				<c:set var="xxinfo1" value="checkTR" />
			</c:if>
		</c:forEach>
	<tr class="${xxinfo1}">
		<td>
		${i.index+1}
		<input type="checkbox"
		<c:if test="${xxinfo0=='1'}">
		checked="checked"
		</c:if>
		 name="dbs" value="${bean.schema_name}" />
		</td>
		<td>
		${bean.schema_name}
		</td>
		<td>
		${bean.default_character_set_name}
		</td>
		<td>
		${bean.default_collation_name}
		</td>
		<td>
		${bean.sql_path}
		</td>
		<td>
		${bean.catalog_name}
		</td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="6" style="text-align: center;">
			<input type="button" onclick="if(checkInfo('dbs','checkbox')){submitFrom2('div_table_list','table_db_form',null);}else{myAlert('请选择你要操作的数据库!');}" class="btn" value="NEXT" />
		</td>
	</tr>
</table>
</form>
<!-- 数据库表列表 -->
<div id="div_table_list"></div>
<c:if test="${old_dbs!=null}">
	<script>submitFrom2('div_table_list','table_db_form',null);</script>
</c:if>
