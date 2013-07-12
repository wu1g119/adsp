package cn.com.softvan.cxf.client;

import java.net.URL;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for test complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="test">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "test")
public class Test {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		long sTime, eTime;
		for (int i = 0; i < 1; i++) {
			sTime = System.currentTimeMillis();
			WebXmlImplService server = new WebXmlImplService(new URL("http://localhost/services/webxml?wsdl"));
			WebXml service = server.getWebXmlImplPort();
			//////////////////////////////////////////
			System.out.println(service.getInfo("{\"system\": \"test001\", \"pageSize\": \"1\", \"pageNum\": \"1\", \"serviceName\": \"newsInfo\"}"));
			////////////////////////////////////////////
			eTime = System.currentTimeMillis();
			System.out.println(eTime - sTime);
		}
	}
}
