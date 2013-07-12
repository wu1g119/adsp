<%--
/*
 * 头部共通部分画面
 *
 * VERSION  DATE        BY           REASON
 * -------- ----------- ------------ ------------------------------------------
 * 1.00     2011-11-19  wuxiaogang        程序・发布
 * -------- ----------- ------------ ------------------------------------------
 * Copyright 2013 adsp System. - All Rights Reserved.
 *
 */
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" session="false"%>
<%@page import="cn.com.softvan.common.CommonConstant"%>
<%@page import="cn.com.softvan.bean.user.AdspUserInfoBean"%>
<%
	String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path; 
request.setAttribute("path",path);
request.setAttribute("basePath",basePath);
%>
<div class="main_top">
	<div class="top_U">
		<div class="U_left">
			<div class="U_left_U"></div>
			<div >
				<div class="U_left_Da"></div>
				<div class="U_left_Db">
					<div class="U_left_Dba" style="margin-top: -8px;">
					<img alt="" src="${basePath}/images/logo.png"  height="40">
					</div>
				</div>
				<div class="U_left_Dc">
				</div>
			</div>
		</div>
		<div class="U_right">
			<div class="U_right_U">
				<div class="U_right_Ua">
				</div>
				<div class="U_right_Ubl" align="left">诚信、创新、真诚.</div>
				<div class="U_right_Ubr" align="right">
				<div class="U_right_Ubr_l"></div>
				<div class="U_right_Ubr_c">
				<%
					AdspUserInfoBean user=(AdspUserInfoBean)request.getSession().getAttribute(CommonConstant.SESSION_KEY_USER);
							if(user!=null){
				%>
					<div class="user_name">
						<font><%=user.getUser_id() %></font>
					</div>
					<div class="user_msg">
					消息
					</div>
					<div class="user_help">
					帮助
					</div>
					<div class="user_logout">
					<font><a href="<%=basePath%>/home_logout.action">退出</a></font>
					</div>
					<%
					}%>
				</div>
				<div class="U_right_Ubr_r"></div>
				</div>
			</div>
			<div class="U_right_D"></div>
		</div>
	</div>
	<div class="top_D">
		<div class="top_D_left" >
			<div class="D_left_right" align="center">
				<div class="D_left_right_U" ></div>
				<div class="D_left_right_C" >数据中间服务平台</div>
				<div class="D_left_right_D" >data adsp system</div>
			</div>
		</div>
		<div class="top_D_right">
			<div class="dt_tt"><a href="${basePath}/ax/ax_info_init.action">接口权限</a></div>
			<div class="dt_tt"><a href="${basePath}/cx/cx_info_init.action">接口服务</a></div>
			<div class="dt_tt"><a href="${basePath}/lx/lx_info_init.action">系统日志</a></div>
		</div>
	</div>
