<%--
/*
 * 登陆页面
 *
 * VERSION  DATE        BY           REASON
 * -------- ----------- ------------ ------------------------------------------
 * 1.00     2012-11-26  wuxiaogang   程序・发布
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
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path; 
request.setAttribute("path",path);
request.setAttribute("basePath",basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户登录【数据中间服务平台】</title>
<%@ include file="jsp/include/public_js_css.jsp"%>
<link rel="stylesheet" type="text/css" href="${basePath}/css/login.css" />
<script type="text/javaScript" language="javaScript">
 	 if (window != top){ 
        top.location.href = location.href;
      }
	function login(){
		var username=document.getElementById("username").value;
		var password=document.getElementById("password").value;
		if(username==""||password==""){
			myAlert("用户名或密码不能为空！");
		}else{
			document.frm1.method="post";
			document.frm1.target="_parent";
			document.frm1.action="${basePath}/home_login.action";
			document.frm1.submit();
		}
	}
</script>
</head>
<body>
<center>
	<br />
	<br /><br />
	<br /><br />
	<form name="frm1" id="frm1" action="${basePath}/home_login.action" onsubmit="javascript:login();">
	<div class="usercheck">
		<div class="one">
			<div class="up">
				<div class="up_left" align="left">
					<div class="titleA">
						数据中间服务平台
					</div>	
					<div class="linesU"></div>            
				</div>
				
				<div class="up_right">
					<div class="up_rightA">
						
					</div>
					<div align="left">
						&nbsp;&nbsp;&nbsp;&nbsp;
						<span class="up_rightB1">用户登陆</span>
						<span class="up_rightB2">ADMINISTRATOR LOGIN</span>
					</div>
				</div>
			</div>
		</div>
		<hr size=1 style="color:#779DB7; border-style: ridge;width:90%" align="center"/> 
		<div class="down">
			<div class="down_left">
				<div class="down_ico">
					<img src="${basePath}/images/login_ico.gif" />
				</div>
				<div class="linesD"></div>
			</div>
			<div class="down_right" align="left">
			<table class="down_table">
			  <tr>
			  	<td style="color: red;text-align: center;" colspan="2">${msg}</td>
			  </tr>
			  <tr>
				<td width="120px" align="right"><span>用户名：</span></td>
				<td width="195px"><label>
				  <input name="username" type="text" id="username" size="25" />
				</label></td>
			  </tr>
			  <tr>
				<td  align="right"><span>密&nbsp;&nbsp;&nbsp;&nbsp;码：</span></td>
				<td><label>
				  <input name="password" type="password" id="password" size="25" />
				</label></td>
			  </tr>
			  <tr>
				<td  align="right"><span>验证码：</span></td>
				<td valign="middle">
				<div style="">
					<div class="authCodeText">
					  <input name="authCode" type="text" id="authCode" size="12" />
					</div>
					<div  class="authCodeImage" align="center">
						<img id="verifyCode" src="${basePath}/verifyImage.action" 
						onclick="this.src='${basePath}/verifyImage.action?&ymd='+new Date().getTime()" 
						style="cursor:pointer;" alt="点击换一张"/>
					</div>
				</div>
				</td>
			  </tr>
			  <tr>
				<td colspan="2" align="center"><label>
				  <input type="submit" name="Submit" value="提交" class="btn"/>
				</label>
				  <label>
				  <input type="reset" name="Submit2" value="重置" class="btn" />
			    </label></td>
			  </tr>
			</table>
			</div>
		</div>
	</div>
</form>
<div>Copyright 2013 (c) softvan Co., LTD</div>
</center>
</body>
</html>
