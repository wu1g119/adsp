package cn.com.softvan.cxf;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.apache.log4j.Logger;

import cn.com.softvan.service.IWebServiceManager;

public class WebXmlImpl implements WebXml {
	/** 日志 */
	private static final transient Logger log = Logger
			.getLogger(WebXmlImpl.class);
	@Resource
	private WebServiceContext context;
	/** WebService 业务处理类 */
	private IWebServiceManager webServiceManager;
	/**获取远程IP*/
	public String getIp() {
		String ip="";
		try {
			MessageContext ctx = context.getMessageContext();
			HttpServletRequest request = (HttpServletRequest) ctx
					.get(AbstractHTTPDestination.HTTP_REQUEST);
			 ip= request.getRemoteAddr();
		} catch (Exception e) {
			log.error("客户端IP地址获取失败!",e);
		}
		return ip;
	}
	/**
	 * <div>
	 * 	<li>连接测试</li>
	 * </div>
	 * @return str
	 */
	public String test(){
		return "1";
	}
	/**
	 * <div>
	 * 	<li>获取信息</li>
	 * </div>
	 * @param info
	 * @return info
	 */
	public String getInfo(String info) {
		// TODO Auto-generated method stub
		return webServiceManager.getInfo(info,getIp());
	}
	/**
	 * <div>
	 * 	<li>修改信息</li>
	 * </div>
	 * @param info
	 * @return info
	 */
	public String modifyInfo(String info) {
		// TODO Auto-generated method stub
		return webServiceManager.modifyInfo(info,getIp());
	}
	/**
	 * <div>
	 * 	<li>保存信息</li>
	 * </div>
	 * @param info
	 * @return info
	 */
	public String saveInfo(String info) {
		// TODO Auto-generated method stub
		return webServiceManager.saveInfo(info,getIp());
	}
	/**
	 * <div>
	 * 	<li>合并信息</li>
	 * </div>
	 * @param info
	 * @return info
	 */
	public String mergerInfo(String info) {
		// TODO Auto-generated method stub
		return webServiceManager.mergerInfo(info,getIp());
	}
	/**
	 * <div>
	 * 	<li>删除信息</li>
	 * </div>
	 * @param info
	 * @return info
	 */
	public String delInfo(String info) {
		// TODO Auto-generated method stub
		return webServiceManager.delInfo(info,getIp());
	}
	/**
	 * context取得
	 * @return context
	 */
	public WebServiceContext getContext() {
	    return context;
	}
	/**
	 * context设定
	 * @param context context
	 */
	public void setContext(WebServiceContext context) {
	    this.context = context;
	}
	/**
	 * WebService 业务处理类取得
	 * @return WebService 业务处理类
	 */
	public IWebServiceManager getWebServiceManager() {
	    return webServiceManager;
	}
	/**
	 * WebService 业务处理类设定
	 * @param webServiceManager WebService 业务处理类
	 */
	public void setWebServiceManager(IWebServiceManager webServiceManager) {
	    this.webServiceManager = webServiceManager;
	}
}
