<%--
/*
 * 子服务配置 格式预览
 *
 * VERSION  DATE        BY           REASON
 * -------- ----------- ------------ ------------------------------------------
 * 1.00     2013-06-04  wuxiaogang        程序・发布
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
//服务恢复
function saveSubConfigInfo(f_action) {
	if(f_action){
		jQuery("#sub_config_form").attr('action',f_action);
	}
	//提交
	jQuery("#sub_config_form").ajaxSubmit(function(data) {
		if (data == "1") {
			myAlert('保存成功!');
			loadUrl('cs/cs_info_', 'init', 'div_strategy_list',null);
		} else {
			myAlert("信息保存失败!\n"+data);
		}
	});
}
</script>
<form action="${basePath}/ax/ax_config_init.action" name="strategy_list1_form" id="strategy_list1_form" method="post" >
	<table class="tablexx" width="100%">
		<tr>
			<th>---格式预览---
			<div style="float: right;">
			</div>
			</th>
		</tr>
		<tr>
			<td>
			<div align="center" style="font-size: 14pt">${configForamt}</div>
			</td>
		</tr>
		<tr>
			<td>
				<div>
				<input type="button"  onclick="this.disabled=true;this.className='btn1';saveSubConfigInfo('${basePath}/cs/cs_config_save.action',this);" class="btn" value="保存" />
				</div>
			</td>
		</tr>
	</table>
</form>