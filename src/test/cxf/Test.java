package test.cxf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import test.junit.WebServiceTest;

import com.clarkware.junitperf.LoadTest;
import com.clarkware.junitperf.TimedTest;

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

	public static LoadTest suite() {
		// 并发访问人数
		int maxUsers = 10;
		// 访问失败时间(毫秒)
		long maxElapsedTime = 3000;
		// 执行测试的方法函数
		WebServiceTest testCase = new WebServiceTest("test1");

		TimedTest timedTest = new TimedTest(testCase, maxElapsedTime);

		LoadTest loadTest = new LoadTest(timedTest, maxUsers);

		return loadTest;
	}
	//test
	public static void main(String[] args) throws Exception {
		junit.textui.TestRunner.run(suite());
	}
}
