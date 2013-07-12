<%--
/*
 * 子服务配置
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
<form action="${basePath}/cs/cs_config_view.action" name="sub_config_form" id="sub_config_form" method="post" >
	<table class="tablexx" width="100%">
		<tr>
			<th colspan="5" >子服务配置-->配置页面
			<div style="float: right;">
			</div>
			</th>
		</tr>
		<tr>
			<th width="10%">主服务</th>
			<th width="15%">主服务名称</th>
			<th width="15%">子服务</th>
			<th width="10%">子服务名称</th>
			<th width="10%">节点名称</th>
		</tr>
		<c:choose>
			<c:when test="${fn:length(beans)>0}">
			<c:forEach varStatus="i" var="bean" items="${beans}">
				<tr>
				<c:choose>
			       <c:when test="${fn:length(map)>0}">
				       <c:forEach varStatus="i1" var="map" items="${map}">
				      <c:choose>
							<c:when test="${map.key==bean.id}">
								<td class="checkTR">
								<label><input checked="checked" type="radio" name="mainId" value="${bean.id}"/>
								${i.index+1}
								</label>
								${bean.name} &nbsp;</td>
								<td class="checkTR">${bean.note} &nbsp;</td>
							</c:when>
							<c:otherwise>
								<td >
								<label><input disabled="disabled" type="radio" name="mainId" value="${bean.id}"/>
								${i.index+1}
								</label>
								${bean.name} &nbsp;</td>
								<td>${bean.note} &nbsp;</td>
							</c:otherwise>
						</c:choose>
						<%--高亮样式 --%>
						<c:set var="checkTR" value=""/>
						<%--选中 --%>
						<c:set var="checkBox" value=""/>
						<%--节点 --%>
						<c:set var="checkNode" value=""/>
						
						<c:forEach var="bean1" items="${map.value}">
							<c:if test="${bean1.sub_config_id==bean.id}">
								 <c:set var="checkTR" value="checkTR"/>
								 <c:set var="checkBox" value='checked="checked"'/>
								 <c:set var="checkNode" value="${bean1.node_name}"/>
							</c:if>
					    </c:forEach>
						<td class="${checkTR}">
						<label><input type="checkbox"  ${checkBox} name="subId"  value="${bean.id}"/>
						${i.index+1}
						</label>
						${bean.name} &nbsp;</td>
						<td class="${checkTR}">${bean.note} &nbsp;</td>
						<td class="${checkTR}">						
						<input type="text" class="textw2012 w100"  name="node1${bean.id}" value="${checkNode}" style="color:red;">
						 &nbsp;
						</c:forEach>
					</c:when>
					<c:otherwise>
						<td>
						<label><input type="radio" name="mainId" value="${bean.id}"/>
						${i.index+1}
						</label>
						${bean.name} &nbsp;</td>
						<td>${bean.note} &nbsp;</td>
						<td>
						<label><input type="checkbox"  name="subId"  value="${bean.id}"/>
						${i.index+1}
						</label>
						${bean.name} &nbsp;</td>
						<td>${bean.note} &nbsp;</td>
						<td>						
						<input type="text" class="textw2012 w100"  name="node1${bean.id}" value="" style="color:red;">
						 &nbsp;
						 </td>
					</c:otherwise>
				</c:choose>
				</tr>
			</c:forEach>
		</c:when>
		<c:otherwise>
		<tr>
			<td colspan="5">
				<div align="center" style="font-size: 14pt">暂无数据</div>
			</td>
		</tr>
		</c:otherwise>
		</c:choose>
		<tr>
			<td colspan="5">
				<div>
				<input type="button" class="btn" onclick="submitFrom2('subView','sub_config_form','${basePath}/cs/cs_config_view.action');" value="NEXT" />
				</div>
			</td>
		</tr>
	</table>
</form>
<div id="subView"></div>