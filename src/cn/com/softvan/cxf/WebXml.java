package cn.com.softvan.cxf;

import javax.jws.WebService;

@WebService
public interface WebXml {
	/**
	 * <div>
	 * 	<li>连接测试</li>
	 * </div>
	 * @return str
	 */
	public String test();
	/**
	 * <div>
	 * 	<li>获取信息</li>
	 * </div>
	 * @param info
	 * @return info
	 */
	public String getInfo(String info);
	/**
	 * <div>
	 * 	<li>修改信息</li>
	 * </div>
	 * @param info
	 * @return info
	 */
	public String modifyInfo(String info);
	/**
	 * <div>
	 * 	<li>保存信息</li>
	 * </div>
	 * @param info
	 * @return info
	 */
	public String saveInfo(String info);
	/**
	 * <div>
	 * 	<li>合并信息</li>
	 * </div>
	 * @param info
	 * @return info
	 */
	public String mergerInfo(String info);
	/**
	 * <div>
	 * 	<li>删除信息</li>
	 * </div>
	 * @param info
	 * @return info
	 */
	public String delInfo(String info);
}
