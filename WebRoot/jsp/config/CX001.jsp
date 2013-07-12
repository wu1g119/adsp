<%--
/*
 * 数据提取服务(初始化页面)
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
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>服务配置【数据中间服务平台】</title>
<%@ include file="../include/public_js_css.jsp"%>
<script>
	$(document).ready(function() {
		loadUrlPage(0, 'cx/cx_info_', 'list1', 'div_strategy_list');
	});
	// 分页查询
	function loadUrlPage(offset, url, event, divId) {
		if (url == null || url == "" || divId == null || divId == "") {
			return;
		}
		var load = "<a class='loading' >信息努力加载中...</a>";
		jQuery("#" + divId).html(load);
		jQuery.ajax({
			url : '${basePath}/' + url + event+'.action?offset='
					+ offset + '&time=' + new Date().getTime(),
			success : function(req) {
				jQuery("#" + divId).html(req);
			},
			error : function() {
				jQuery("#" + divId).html("信息加载发生错误");
			}
		});
	}
	// 加载链接
	function loadUrl(url, event, divId,obj) {
		if (url == null || url == "" || divId == null || divId == "") {
			return;
		}
		//
		if(obj!=null){
			var myPattern = new RegExp("/^[&]{1}/"); //以&开头
			if(!myPattern.exec("obj")) {//如果不是
				obj='&'+obj;//加上
			}
		}else{
			obj='';
		}
		var load = "<a class='loading' >信息努力加载中...</a>";
		jQuery("#" + divId).html(load);
		jQuery.ajax({
			url : '${basePath}/' + url + event+'.action?time=' + new Date().getTime()+obj,
			success : function(req) {
				jQuery("#" + divId).html(req);
			},
			error : function() {
				jQuery("#" + divId).html("信息加载发生错误");
			}
		});
	}
	// 提交from
	function submitFrom2(divId,from_id,from_action) {
		var load = "<a class='loading' >信息努力加载中...</a>";
		jQuery("#"+divId).html(load);
		//改变提交地址
		if(from_action!=null){
			jQuery("#"+from_id).attr('action',from_action);
		}
		//提交
		jQuery("#"+from_id).ajaxSubmit(function(data) {
			if (data != "2") {
				jQuery("#"+divId).html(data);
			} else {
				myAlert("信息处理失败!");
			}
		});
	}
	// 服务删除
	function delInfo(from_id,from_action) {
		//改变提交地址
		if(from_action!=null){
			jQuery("#"+from_id).attr('action',from_action);
		}
		//提交
		jQuery("#"+from_id).ajaxSubmit(function(data) {
			if (data == "1") {
				myAlert('信息删除成功!');
				//重新加载当前页面
				loadUrlPage(0, 'cx/cx_info_', 'list1', 'div_strategy_list');
			} else {
				myAlert("信息处理失败!");
			}
		});
	}
	// 服务恢复
	function recoveryInfo() {
		//提交
		jQuery("#strategy_list2_form").ajaxSubmit(function(data) {
			if (data == "1") {
				myAlert('信息恢复成功!');
				//重新加载当前页面
				loadUrlPage(0, 'cx/cx_info_', 'list2', 'div_strategy_list');
			} else {
				myAlert("信息处理失败!");
			}
		});
	}
</script>
</head>
<body>
	<div class="wrap">
	<%@ include file="../include/header.jsp"%>
		<table class="subject">
			<tr>
				<td class="menu_body" valign="top">
					 <div id="sidebar">
   						 <ul id="menu">
	   						 <li class="item"><a href="javascript:void(0)"  class="title" name="1">服务管理</a>
								<ul id="opt_1" class="optiton" style="vertical-align:middle;">
									<li>▪<a href="javascript:void(0);" onclick="loadUrl('cx/cx_info_', 'config', 'div_strategy_list',null);" >&nbsp;&nbsp;新增服务</a></li>
					 				<li>▪<a href="javascript:void(0);" onclick="loadUrlPage(0, 'cx/cx_info_', 'list1', 'div_strategy_list');">&nbsp;&nbsp;信息列表</a></li>
					 				<li>▪<a href="javascript:void(0);" onclick="loadUrlPage(0, 'cx/cx_info_', 'list2', 'div_strategy_list');">&nbsp;&nbsp;信息回收站</a></li>
								</ul>
							</li>
							<li class="item"><a href="javascript:void(0)"  class="title" name="2">子服务管理</a>
								<ul id="opt_2" class="optiton" style="vertical-align:middle;">
									<li>▪<a href="javascript:void(0);" onclick="loadUrl('cs/cs_config_', 'init', 'div_strategy_list',null);" >&nbsp;&nbsp;新增子服务</a></li>
					 				<li>▪<a href="javascript:void(0);" onclick="loadUrl('cs/cs_info_', 'init', 'div_strategy_list',null);" >&nbsp;&nbsp;信息列表</a></li>
								</ul>
							</li>
   						 </ul>
   					  </div>
   					  <script>menuLeftInit();</script>
				</td>
				<td valign="top">
					<div id="div_strategy_list"></div>
					<div class="clear"></div>
				</td>
			</tr>
		</table>
	<%@ include file="../include/footer.jsp"%>
	</div>
</body>
</html>
