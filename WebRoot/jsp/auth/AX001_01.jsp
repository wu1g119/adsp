<%--
/*
 * 客户端(列表 未删除)
 *
 * VERSION  DATE        BY           REASON
 * -------- ----------- ------------ ------------------------------------------
 * 1.00     2013-05-29  wuxiaogang        程序・发布
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
<form action="${basePath}/ax/ax_config_init.action" name="strategy_list1_form" id="strategy_list1_form" method="post" >

	<table class="tablexx" width="100%">
		<tr>
			<th colspan="11" >客户端信息-->列表
			<div style="float: right;">
			<input type="button" class="btn" onclick="loadUrl('ax/ax_config_', 'init', 'div_info_list',null);" value="新增" />
			</div>
			</th>
		</tr>
		<tr>
			<th width="5%"></th>
			<th width="10%">客户端IP</th>
			<th width="15%">客户端编号</th>
			<th width="15%">客户端名称</th>
			<th width="10%">备注</th>
			<th width="10%">创建日期</th>
			<th width="10%">建立者ID</th>
			<th width="5%">建立者IP</th>
			<th width="10%">更新日期</th>
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
					<td>${bean.client_ip} &nbsp;</td>
					<td>${bean.client_code} &nbsp;</td>
					<td>${bean.client_name} &nbsp;</td>
					<td>${bean.note} &nbsp;</td>
					<td>${bean.date_created} &nbsp;</td>
					<td>${bean.create_id} &nbsp;</td>
					<td>${bean.create_ip} &nbsp;</td>
					<td>${bean.last_updated} &nbsp;</td>
					<td>${bean.update_id} &nbsp;</td>
					<td>${bean.update_ip} &nbsp;</td>
				</tr>
			</c:forEach>
		</c:when>
		<c:otherwise>
		<tr>
			<td colspan="11">
				<div align="center" style="font-size: 14pt">暂无数据</div>
			</td>
		</tr>
		</c:otherwise>
		</c:choose>
		<tr>
			<td colspan="11">
				<div class="clear"></div> 
				<input type="button" onclick="if(checkInfo('id','radio')){submitFrom2('div_info_list','strategy_list1_form','${basePath}/ax/ax_info_detail.action');}else{myAlert('请选择你要查看的数据!');}" class="btn" value="详情" />
				<input type="button" onclick="if(checkInfo('id','radio')){submitFrom2('div_info_list','strategy_list1_form','${basePath}/ax/ax_config_init.action');}else{myAlert('请选择你要修改的数据!');}" class="btn" value="修改" />
				<customtag:pagingext func="loadUrlPage"
					params="'ax/ax_info_','list1','div_info_list_2'" />
			</td>
		</tr>
	</table>
</form>