<%--
/*
 * 客户端权限(编辑)
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
<script type="text/javascript">
//保存配置信息
function saveConfigInfo(obj){
	jQuery("#table_configInfo_form").ajaxSubmit(function(data) {
		try{
			if (data == "1") {
				//赋值
				myAlert('保存成功!');
				loadUrlPage(0, 'ax/ax_info_', 'list1', 'div_info_list');
			} else {
				myAlert(data);
			}
			obj.disabled=false;obj.className='btn';
		}catch(e){alert(e);}
	});
}
</script>
<form action="${basePath}/ax/ax_config_saveInfo.action" name="table_configInfo_form" id="table_configInfo_form" method="post" >
	<c:if test="${bean.id!=null}">
		<input type="hidden" name="bean.id" value="${bean.id}" />
	</c:if>
	<table class="tablexx" width="100%">
		<tr>
			<th colspan="2">
				客户端权限设置-->信息编辑
				<div style="float: right;">
					<input type="button" onclick="this.disabled=true;this.className='btn1';saveConfigInfo(this);" class="btn" value="保存" />
				</div>
			</th>
		</tr>
		<tr>
			<th width="70px">客户端IP</th>
			<td>
			<input type="text" class="textw2012 w90" name="bean.client_ip" value="${bean.client_ip}" />
			</td>
		</tr>
		<tr>
			<th width="70px">客户端编号</th>
			<td>
			<input type="text" class="textw2012 w90" 
			<c:if test="${bean.client_code!=null}">
			readonly="readonly" style="background-color: #eeeeee;"
			</c:if>
			 name="bean.client_code" value="${bean.client_code}" />
			 &nbsp;&nbsp;(命名规范:客户项目编号+年月份+客户端IP后三位)
			</td>
		</tr>
		<tr>
			<th width="70px">客户端名称</th>
			<td>
			<input type="text" class="textw2012 w90" name="bean.client_name" value="${bean.client_name}" />
			</td>
		</tr>
		<tr>
			<th width="70px">客户端备注</th>
			<td colspan="3">
			<input type="text" class="textw2012 w90" name="bean.note" value="${bean.note}" />
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
			<th width="5%"></th>
			<th width="5%">版本</th>
			<th width="5%">类型</th>
			<th width="13%">名称</th>
			<th width="10%">注释</th>
			<th width="5%">状态</th>
		</tr>
		<c:forEach varStatus="i" var="bean" items="${beans}">
		<tr>
			<td><label>
			<input type="checkbox" 
			 <c:forEach items="${auths}" var="auth">
			 	<c:if test="${auth.service_id==bean.id}">
			 	checked="checked"
			 	</c:if>
			 </c:forEach>
			 name="service_id" value="${bean.id}"/>
			${i.index+1}
			</label>
			</td>
			<td>${bean.version} &nbsp;</td>
			<td>${bean.type}<input type="hidden" name="type${bean.id}" value="${bean.type}"/> &nbsp;</td>
			<td>${bean.name}<input type="hidden" name="name${bean.id}" value="${bean.name}"/> &nbsp;</td>
			<td>${bean.note}<input type="hidden" name="note${bean.id}" value="${bean.note}"/> &nbsp;</td>
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
		</tr>
	</c:forEach>
	</table>
</form>