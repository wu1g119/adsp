<%--
/*
 * 管理员操作日志信息(初始化页面)
 *
 * VERSION  DATE        BY           REASON
 * -------- ----------- ------------ ------------------------------------------
 * 1.00     2013-03-08  wuxiaogang   程序・发布
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
<form action="${basePath}/lx/lx_user_list1.action" name="lx_user_list1_form" id="lx_user_list1_form" method="post" >
	<input type="hidden" name="offset" id="offsetA" value="0">
	<table class="tablexx" width="100%">
		<tr>
			<th colspan="4" >系统日志-->管理员操作日志
			<div style="float: right;">
			</div>
			</th>
		</tr>
		<tr>
			<td>用户id
			</td>
			<td>
			<input type="text" class="textw2012 w40" name="bean.user_id">
			</td>
			<td>
			操作类型
			</td>
			<td>
			<select class="textw2012 w40" name="bean.type">
				<option value="I">新增</option>
				<option value="E">修改</option>
				<option value="D">删除 </option>
				<option value="R">恢复</option>
			</select>
			</td>
		</tr>
		<tr>
			<td>时间区间
			</td>
			<td colspan="3">
				<input name="bean.date1" readonly="readonly" id="birthday" type="text" class="textw2012 kd Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
				~
				<input name="bean.date2" readonly="readonly" id="birthday" type="text" class="textw2012 kd Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
			</td>
		</tr>
		<tr>
			<td colspan="4" align="center">
			<div align="center">
				<input type="button" onclick="this.disabled=true;this.className='btn1';submitFrom1(0,'lx_user_list1_form', null, 'div_info_list_2',this);" class="btn" value="搜索"  />
			</div>
			</td>
		</tr>
	</table>
</form>
<div id="div_info_list_2"></div>
<script type="text/javascript">submitFrom1(0,'lx_user_list1_form', null, 'div_info_list_2',null);</script>
