package cn.com.softvan.web.action;

import javax.servlet.http.HttpServletRequest;

import cn.com.softvan.bean.user.AdspUserInfoBean;
import cn.com.softvan.common.CommonConstant;
import cn.com.softvan.common.Validator;


public class SessionUtils {
	// 后台需要检查登录的模块
	private static StringBuilder modules = new StringBuilder();
	static {
//		modules.append("/a001Action.do"); // 查看角色信息列表页面
	}
	/**
	 * 检查后台用户是否已经登录过
	 * @param req
	 * @return true:已经登录；false:未登录
	 */
	public static boolean checkAdminIsLogin(HttpServletRequest req) {
		String servletPath = req.getServletPath();
		if (modules.toString().indexOf(servletPath) != -1) {
			AdspUserInfoBean userBean = (AdspUserInfoBean) req.getSession().getAttribute(CommonConstant.SESSION_KEY_USER);
			if (userBean != null && !Validator.isNullEmpty(userBean.getUser_id())) {
				return true;
			} else {
				return false;
			}
		}
		return true;
	}
	/**
	 * 后台用户退出登录或者清空Session
	 * @param req
	 */
	public static void clearAdminSession(HttpServletRequest req) {
    	req.getSession().removeAttribute(CommonConstant.SESSION_KEY_USER);
    	req.getSession().invalidate();
	}
}
