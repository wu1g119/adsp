<%--
/*
 * 接口服务配置显示(列表)
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
<form action="${basePath}/cx/cx_info_list2.action" name="strategy_list1_form" id="strategy_list1_form" method="post" >
	<table class="tablexx" width="100%">
		<tr>
			<th colspan="12" >接口服务-->信息列表
			<div style="float: right;">
			<input type="button" class="btn" onclick="loadUrl('cx/cx_info_', 'config', 'div_strategy_list',null);" value="新增" />
			</div>
			</th>
		</tr>
		<tr>
			<th width="5%"></th>
			<th width="5%">VERSIONS</th>
			<th width="2%">类型</th>
			<th width="13%">名称</th>
			<th width="15%">注释</th>
			<th width="5%">状态</th>
			<th width="10%">创建</th>
			<th width="10%">建立者ID</th>
			<th width="5%">建立者IP</th>
			<th width="10%">更新</th>
			<th width="5%">修改者ID</th>
			<th width="5%">修改者IP</th>
		</tr>
<c:choose>
	<c:when test="${fn:length(beans)>0}">
		<c:forEach varStatus="i" var="bean" items="${beans}">
			<tr>
				<td><label><input type="radio"  name="id" class="flag_bean_info_id" value="${bean.id}"/>
				${i.index+1}
				</label>
				</td>
				<td>${bean.version} &nbsp;</td>
				<td>${bean.type} &nbsp;</td>
				<td>${bean.name} &nbsp;</td>
				<td>${bean.note} &nbsp;</td>
				<td>
				<c:choose>
				<c:when test="${bean.status==1}">
					启用
				</c:when>
				<c:otherwise>
					停用
				</c:otherwise>
			</c:choose>
				&nbsp;</td>
				<td>${bean.date_created} &nbsp;</td>
				<td>${bean.create_id} &nbsp;</td>
				<td>${bean.create_ip} &nbsp;</td>
				<td>${bean.last_updated} &nbsp;</td>
				<td>${bean.update_id} &nbsp;</td>
				<td>${bean.update_ip} &nbsp;</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="12">
				<div class="clear"></div> 
				<input type="button" onclick="if(checkInfo('id','radio')){submitFrom2('edit_div_strategy_list','strategy_list1_form','${basePath}/cx/cx_config_q_dblist.action');}else{myAlert('请选择你要修改的数据!');}" class="btn" value="修改" />
				<input type="button" class="btn1" value="详情" />
				<input type="button" onclick="if(checkInfo('id','radio')){delInfo('strategy_list1_form','${basePath}/cx/cx_info_delInfo.action');}else{myAlert('请选择你要删除的数据!');}" class="btn" value="删除" />
				<customtag:pagingext func="loadUrlPage"
					params="'cx/cx_info_','list1','div_strategy_list'" />
			</td>
		</tr>
</c:when>
<c:otherwise>
	<tr>
	<td colspan="12">
		<div align="center" style="font-size: 14pt">暂无数据</div>
	</td>
	</tr>
</c:otherwise>
</c:choose>
	</table>
</form>
<div id="edit_div_strategy_list"></div>