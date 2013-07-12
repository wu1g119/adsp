<%--
/*
 * 接口监控日志显示(列表)
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
	<table class="tablexx" width="100%">
		<tr>
			<th width="10%"></th>
			<th width="10%">客户端</th>
			<th width="10%">客户端IP</th>
			<th width="10%">接口名称</th>
			<th width="10%">服务名称</th>
			<th width="10%">处理时间</th>
			<th width="20%">调用参数</th>
			<th width="20%">异常信息</th>
		</tr>
		<c:choose>
			<c:when test="${fn:length(beans)>0}">
			<c:forEach varStatus="i" var="bean" items="${beans}">
				<tr>
					<td><label><input type="radio"  name="id" class="flag_bean_info_id" value="${bean.id}"/>
					${bean.id}
					</label>
					</td>
					<td>${bean.system} &nbsp;</td>
					<td>${bean.create_ip} &nbsp;</td>
					<td>${bean.port_name} &nbsp;</td>
					<td>${bean.service_name} &nbsp;</td>
					<td>${bean.process_time} &nbsp;</td>
					<td>${bean.service_argument} &nbsp;</td>
					<td>${bean.error_msg} &nbsp;</td>
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
				<input type="button" class="btn1" value="详情" />
				<customtag:pagingext func="submitFrom1"
					params="'lx_service_list1_form', null, 'div_info_list_2',null" />
			</td>
		</tr>
	</table>
