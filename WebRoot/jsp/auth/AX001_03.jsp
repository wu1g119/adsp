<%--
/*
 * 客户端权限(详情)
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
	<table class="tablexx" width="100%">
		<tr>
			<th colspan="2">
				客户端权限设置-->详情
			</th>
		</tr>
		<tr>
			<th width="70px">客户端IP</th>
			<td>
			${bean.client_ip}
			</td>
		</tr>
		<tr>
			<th width="70px">客户端编号</th>
			<td>
			${bean.client_code}
			</td>
		</tr>
		<tr>
			<th width="70px">客户端名称</th>
			<td>
			${bean.client_name}
			</td>
		</tr>
		<tr>
			<th width="70px">客户端备注</th>
			<td colspan="3">
			${bean.note}
			</td>
		</tr>
		<tr>
			<th colspan="2" align="center">
				----------服务列表---------
			</th>
		</tr>
		</table>
		<table class="tablexx" width="100%">
			<tr>
				<th width="10%"></th>
				<th width="30%">名称</th>
				<th width="60%">注释</th>
			</tr>
			<c:forEach varStatus="i" var="bean" items="${auths}">
			<tr>
				<td><label>
				${i.index+1}
				</label>
				</td>
				<td>${bean.service_name} &nbsp;</td>
				<td>${bean.note}&nbsp;</td>
				<td>
			</tr>
		</c:forEach>
		</table>
