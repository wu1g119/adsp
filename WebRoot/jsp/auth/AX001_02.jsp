<%--
/*
 * 客户端(列表 已删除)
 *
 * VERSION  DATE        BY           REASON
 * -------- ----------- ------------ ------------------------------------------
 * 1.00     2013-05-30  wuxiaogang        程序・发布
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
	<table class="tablexx" width="100%">
		<tr>
			<th width="5%"></th>
			<th width="10%">客户端ID</th>
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
					${bean.id}
					</label>
					</td>
					<td>${bean.client_ip} &nbsp;</td>
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
				<customtag:pagingext func="loadUrlPage"
					params="'ax/ax_info_','list2','div_info_list_2'" />
			</td>
		</tr>
	</table>
