/*
 * 验证码生成使用ActionClass
 *
 * VERSION  DATE        BY              REASON
 * -------- ----------- --------------- ------------------------------------------
 * 1.00     2011.11.15  FanZY           程序・发布
 * -------- ----------- --------------- ------------------------------------------
 * Copyright 2011 softvan System. - All Rights Reserved.
 *
 */
package cn.com.softvan.web.action;

import org.apache.log4j.Logger;

import cn.com.softvan.common.CommonConstant;
import cn.com.softvan.common.VerifyUtils;


/**
 * <p>验证码生成使用ActionClass</p>
 * <ol>[提供机能]
 * <li>验证码生成使用机能处理
 * </ol>
 *
 * @author FanZY
 */
public class VerifyImageAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4090202479166010857L;
	private static final transient Logger log = Logger.getLogger(VerifyImageAction.class);
	
    /** 默认的构造函数 */
    public VerifyImageAction() {
    	log.info("VerifyImageAction constructed");
    }
    
    /**
     * <p>生成验证码图片处理。</p>
     * <ol>[功能概要]
     * <div>生成验证码图片</div>
     * </ol>
     * @return String 
     * @throws Exception 
     */
	public String verifyImage() throws Exception {
		VerifyUtils.createVerifyCode(response, CommonConstant.SESSION_VERIFY_CODE, request);
		return null;
	}
}
