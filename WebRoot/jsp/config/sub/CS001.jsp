<%--
/*
 * 子服务配置(初始化)
 *
 * VERSION  DATE        BY           REASON
 * -------- ----------- ------------ ------------------------------------------
 * 1.00     2013-06-03  wuxiaogang        程序・发布
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
			<th colspan="8" >子服务信息-->列表(设置关联)
			<div style="float: right;">
				<input type="button" class="btn" onclick="loadUrl('cs/cs_config_', 'init', 'div_strategy_list',null);" value="新增" />
				<input type="button"  class="btn1" value="详情" />
			</div>
			</th>
		</tr>
		<tr>
			<th width="5%"></th>
			<th width="10%">主服务</th>
			<th width="15%">子服务</th>
			<th width="10%">节点名称</th>
			<th width="10%">备注</th>
			<th width="10%">创建日期</th>
			<th width="10%">建立者ID</th>
			<th width="10%">操作</th>
		</tr>
		<c:choose>
			<c:when test="${fn:length(map)>0}">
			<c:forEach varStatus="i" var="map" items="${map}">
				<c:forEach varStatus="n" var="bean" items="${map.value}">
				<tr>
					<c:if test="${n.index==0 }">
					<td rowspan="${fn:length(map.value)}"><label><input type="radio"  name="id" class="flag_bean_info_id" value="${map.key}"/>
					${i.index+1}
					</label>
					</td>
					<td rowspan="${fn:length(map.value)}">${bean.config_name} &nbsp;</td>
					</c:if>
					<td>${bean.sub_config_name} &nbsp;</td>
					<td>${bean.node_name} &nbsp;</td>
					<td>${bean.note} &nbsp;</td>
					<c:if test="${n.index==0 }">
					<td rowspan="${fn:length(map.value)}">${bean.date_created} &nbsp;</td>
					<td rowspan="${fn:length(map.value)}">${bean.create_id} &nbsp;</td>
					<td rowspan="${fn:length(map.value)}">				
					<input type="button"   onclick="loadUrl('cs/cs_config_', 'init', 'div_strategy_list','id=${map.key}');" class="btn"  value="修改" />
					&nbsp;</td>
					</c:if>
				</tr>
				</c:forEach>
			</c:forEach>
		</c:when>
		<c:otherwise>
		<tr>
			<td colspan="8">
				<div align="center" style="font-size: 14pt">暂无数据</div>
			</td>
		</tr>
		</c:otherwise>
		</c:choose>
	</table>
