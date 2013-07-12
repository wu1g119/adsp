package test.junit;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Before;

import junit.framework.TestCase;
import cn.com.softvan.cxf.client.WebXml;
import cn.com.softvan.cxf.client.WebXmlImplService;

//测试类，继承公用抽像测试类
public class WebServiceTest extends TestCase {
	public WebServiceTest(String name) {
		super(name);
	}
	@Before
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	/**
	 * now_info_flag_a=1  //实时信息标记  不带此标记的信息将被缓存30分钟
	 */
	
	//正式环境
//	String wsdl="http://localhost/adsp/services/webxml?wsdl";
	//测试环境
//	String wsdl="http://192.168.1.249:9080/adsp/services/webxml?wsdl";
	//开发环境
	String wsdl="http://localhost/services/webxml?wsdl";
	// 获取新闻详情
	public void test1() throws MalformedURLException {
		WebXmlImplService webXmlImplService = new WebXmlImplService(new URL(wsdl));
		WebXml service = webXmlImplService.getWebXmlImplPort();
		System.out.println(service.getInfo("{\"system\": \"test001\", \"pageSize\": \"1\", \"pageNum\": \"1\", \"serviceName\": \"news_list\"}"));
	}

	// 获取景点信息
	public void test2() throws MalformedURLException {
		WebXmlImplService webXmlImplService = new WebXmlImplService(new URL(wsdl));
		WebXml service = webXmlImplService.getWebXmlImplPort();
		System.out.println(service.getInfo("{\"system\": \"test001\", \"pageSize\": \"1\", \"pageNum\": \"1\", \"serviceName\": \"scene_info_list\"}"));
	}

	// 获取景点信息
	public void test3() throws MalformedURLException {
		WebXmlImplService webXmlImplService = new WebXmlImplService(new URL(wsdl));
		WebXml service = webXmlImplService.getWebXmlImplPort();
		System.out.println(service.getInfo("{\"system\": \"test001\", \"pageSize\": \"1\", \"pageNum\": \"1\", \"serviceName\": \"scene_type_list\"}"));
	}
}