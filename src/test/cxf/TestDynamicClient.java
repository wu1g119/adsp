/*
 *  动态cxf客户端
 *
 * VERSION  DATE        BY              REASON
 * -------- ----------- --------------- ------------------------------------------
 * 1.00     2013.07.08  wuxiaogang           程序・发布
 * -------- ----------- --------------- ------------------------------------------
 * Copyright 2013 adsp System. - All Rights Reserved.
 *
 */
package test.cxf;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

public class TestDynamicClient {
	public static void main(String[] args) throws Exception {
		// 动态客户端
		JaxWsDynamicClientFactory dynamicClient = JaxWsDynamicClientFactory
				.newInstance();
		// wsdl
		String wsdl = "http://localhost/services/webxml?wsdl";
		// 创建客户端
		Client client = dynamicClient.createClient(wsdl);
//		//-------------打印生成的代理类---与类的属性方法------
//		ServiceInfo serviceInfo=client.getEndpoint().getService().getServiceInfos().get(0);
//			Set<QName> qSet=serviceInfo.getMessages().keySet();
//			Iterator<QName> qIter=qSet.iterator();
//			while(qIter.hasNext()){
//				QName q=qIter.next();
//				//包名
//				String packageName=JAXBUtils.namespaceURIToPackage(serviceInfo.getName().getNamespaceURI());
//				//类名
//				String className=JAXBUtils.nameToIdentifier(q.getLocalPart(),JAXBUtils.IdentifierType.INTERFACE);
//				//获取生成代理类的全部完整路径
//				System.out.println("类="+packageName+"."+className);
//				//加载类
//				Object objArgs = Thread.currentThread().getContextClassLoader().loadClass(packageName+"."+className).newInstance();
//				//获取类的全部属性
//				Field[] fields=objArgs.getClass().getDeclaredFields();
//				for(Field f:fields){
//					System.out.println("\t属性="+f.getName());
//				}
//				System.out.println("\t--------------------");
//				Method[] methods=objArgs.getClass().getDeclaredMethods();
//				for(Method m:methods){
//					System.out.println("\t方法="+m.getName());
//				}
//				
//			}
		// ----------访问getInfo接口------------
		try {
			// 调用接口getInfo
			Object[] objArr1 = client.invoke("getInfo","{\"system\": \"test001\", \"pageSize\": \"1\", \"pageNum\": \"1\", \"serviceName\": \"news_list\"}");
			// 输出接口值
			System.out.println(objArr1[0]);

//			/* 例子2
//			 * 参数为对象 
//			 * eg. getInfo(String info,XX xx) 
//			 * 
//			 */
//			//创建xx对象
//			Object objArgs = Thread.currentThread().getContextClassLoader()
//					.loadClass("cn.com.softvan.cxf.XX").newInstance();
//			//为xx对象xx1属性赋值
//			Method xx1 = objArgs.getClass().getMethod("setXX1",String.class);
//			xx1.invoke(objArgs,"1");
//			//为xx对象xx2属性赋值
//			Method xx2 = objArgs.getClass().getMethod("setXX2",String.class);
//			xx2.invoke(objArgs,"2");
//			//传入值获取返回值
//			Object[] objArr2=client.invoke("getInfo",new Object[]{"第一个参数信息",objArgs});
//			//返回第一个信息
//			System.out.println(objArr2[0]);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
