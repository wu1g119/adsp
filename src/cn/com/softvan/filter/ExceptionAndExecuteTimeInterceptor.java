package cn.com.softvan.filter;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import cn.com.softvan.bean.user.AdspUserInfoBean;
import cn.com.softvan.common.CommonConstant;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * struts2 监听 异常\调用时间
 * @author {wuxiaogang}
 *
 */
public class ExceptionAndExecuteTimeInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = -6442157043443401725L;

	private static final Log log = LogFactory
			.getLog(ExceptionAndExecuteTimeInterceptor.class);

	private static final String EQUAL_SIGN = "=";
	private static final String PLUS_SIGN = "+";
	private static final String AND = "&";

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		/*
		 * 获取该http请求的一些信息，下面的日志会使用到
		 */
		HttpServletRequest request = ServletActionContext.getRequest(); // 获取客户端发过来的HTTP请求
		 String path = request.getContextPath();
	     String basePath = null;
//       log.info("访问端口号："+ request.getServerPort());
        
        if (request.getServerPort() != 80) {
    		basePath = request.getScheme() + "://" + request.getServerName() 
					+ ":" + request.getServerPort() + path;	
        } else {
        	basePath = request.getScheme() + "://" + request.getServerName() + path;
        }
		request.setAttribute("path", path);
		request.setAttribute("basePath", basePath);
//		log.info("basePath值："+ basePath);
		String actionName=invocation.getInvocationContext().getName();
//		//用户信息
//		AdspUserInfoBean userBean=new AdspUserInfoBean();
//		//用户名
//		userBean.setUser_id("admin");
//		//
//		request.getSession().setAttribute(CommonConstant.SESSION_KEY_USER, userBean);
		//判断用户是否登陆 
		if(request.getSession().getAttribute(CommonConstant.SESSION_KEY_USER)==null
				&&!"home_login".equals(actionName)
				&&!"verifyImage".equals(actionName)
				){
			//回到登录页面
			return "login";
		}
		String remoteHost = request.getRemoteAddr(); // 获取客户端的主机名
		String requestURL = request.getRequestURL().toString(); // 获取客户端请求的URL
		Map<String, String[]> paramsMap = (Map<String, String[]>) request
				.getParameterMap(); // 获取所有的请求参数

		/*
		 * 获取所有参数的名值对信息的字符串表示，存储在变量paramsStr中
		 */
		StringBuilder paramsStrSb = new StringBuilder();
		if (paramsMap != null && paramsMap.size() > 0) {
			Set<Entry<String, String[]>> paramsSet = paramsMap.entrySet();
			for (Entry<String, String[]> param : paramsSet) {
				StringBuilder paramStrSb = new StringBuilder();
				String paramName = param.getKey(); // 参数的名字
				String[] paramValues = param.getValue(); // 参数的值
				if (paramValues.length == 1) { // 参数只有一个值，绝大多数情况
					paramStrSb.append(paramName).append(EQUAL_SIGN)
							.append(paramValues[0]);
				} else {
					paramStrSb.append(paramName).append(EQUAL_SIGN);
					for (String paramValue : paramValues) {
						paramStrSb.append(paramValue);
						paramStrSb.append(PLUS_SIGN);
					}
					paramStrSb.deleteCharAt(paramStrSb.length() - 1);
				}
				paramsStrSb.append(paramStrSb).append(AND);
			}
			paramsStrSb.deleteCharAt(paramsStrSb.length() - 1);
		}
		String paramsStr = paramsStrSb.toString();

		/*
		 * 如果Action的执行过程中抛出异常，则记录到日志里； 或者Action执行成功，但执行时间过长，也记录到日志里
		 */
		String result = null;
		// 获得Action执行的开始时间
		long start = System.currentTimeMillis();
		try {
			// 执行该拦截器的下一个拦截器，或者如果没有下一个拦截器，直接执行Action的execute方法
			result = invocation.invoke();
		} catch (Exception e) {
			String msg = "抛出了异常！" + remoteHost + "的请求，URL:" + requestURL
					+ "，参数：" + paramsStr;
			log.error(msg, e);
			return "exception";
		}
		// 获得Action执行的结束时间
		long end = System.currentTimeMillis();
		// 如果该Action的执行时间超过了500毫秒，则日志记录下来
		final int MAX_TIME = 500;
		long executeTimeMillis = end - start;
		if (executeTimeMillis >= MAX_TIME) {
			log.info("Action执行时间过长！执行" + remoteHost + "的请求，URL:" + requestURL
					+ "，参数：" + paramsStr + "，共用时" + executeTimeMillis + "毫秒");
		}
		return result;
	}
}
