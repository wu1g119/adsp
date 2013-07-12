package test.junit;

import junit.framework.TestSuite;


//测试类
public class Test {
	public static void main(String[] args) throws Throwable {
		/**
		 * 1、测试某个类的所有方法
		 */
//		 TestRunner.run(WebServiceTest.class);//第一种方式

//		 TestSuite suite = new TestSuite("TestSuite");//第二种方式
//		 suite.addTestSuite(WebServiceTest.class);
//		 junit.textui.TestRunner.run(suite);

		/**
		 * 2、测试多个类的所有方法
		 */
		// TestSuite suite = new TestSuite("TestSuite");
		// suite.addTestSuite(WebServiceTest.class);
		// suite.addTestSuite(WebServiceTest.class);
		// junit.textui.TestRunner.run(suite);

		 /**
		 * 3、测试某个类的某个方法
		 */
		 TestSuite suite = new TestSuite("TestSuite");
		 suite.addTest(new WebServiceTest("test1"));
		 suite.addTest(new WebServiceTest("test2"));
		 suite.addTest(new WebServiceTest("test3"));
		 junit.textui.TestRunner.run(suite);

		/**
		 * 4、测试多个类的某个方法
		 */
		// TestSuite suite = new TestSuite("TestSuite");
		// suite.addTest(new WebServiceTest("testCommunity"));
		// suite.addTest(new WebServiceTest("testCommunity2"));
		// suite.addTest(new WebServiceTest("testCommunity3"));
		// suite.addTest(new WebServiceTest("testCommunity4"));
		// junit.textui.TestRunner.run(suite);
		 
		 
	}
}
