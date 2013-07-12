<%--
/*
 * 数据提取服务配置(服务配置结果 SQL测试页面)
 *
 * VERSION  DATE        BY           REASON
 * -------- ----------- ------------ ------------------------------------------
 * 1.00     2013-03-10  wuxiaogang  程序・发布
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
<div style="height: 300px;">
<table class="tablexx" width="100%" frame="box">
	<tr>
		<td>
			<font color="blue">SQL测试结果</font>
		</td>
	</tr>
	<tr>
		<td>
			<font color="grred">SQL(去除活动参数)</font>
			<br/>
			<font color="red">${sql}</font>
		</td>
	</tr>
	<tr>
		<td>
			<table class="tablexx" width="100%" frame="box">
			    <c:set var="td_colspan" value="1" />
			    <c:set var="bean0" value="" />
				<c:forEach items="${list}" var="bean1" varStatus="i">
					<c:if test="${i.index==0}">
						<tr>
							<c:set var="bean0" value="${bean1}" />
							<c:set var="td_colspan" value="${fn:length(bean1)}" />
							<c:forEach items="${bean1}" var="bean2">
								<th>
									${bean2.key}
								</th>
							</c:forEach>
						</tr>
						<tr>
							<c:if test="${fn:length(list)==1}">
								<td colspan="${td_colspan}">
									<div style="font-size:20pt;">
										SQL语法没有错误!数据库中没有匹配的信息!
									</div>
								</td>
							</c:if>
						</tr>
					</c:if>
					<c:if test="${i.index>=1}">
						<c:if test="${fn:length(list)>1}">
							<tr>
								<c:forEach items="${bean0}" var="bean3">
									<td><c:forEach items="${bean1}" var="bean4"><c:if test="${bean3.key==bean4.key}">${bean4.value}</c:if></c:forEach></td>
								</c:forEach>
							</tr>
						</c:if>
					</c:if>
				</c:forEach>
			</table>
		</td>
	</tr>
</table>
</div>