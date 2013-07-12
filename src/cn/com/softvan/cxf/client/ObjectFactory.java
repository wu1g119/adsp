package cn.com.softvan.cxf.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the cn.com.softvan.cxf.client package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

	private final static QName _ModifyInfo_QNAME = new QName(
			"http://cxf.softvan.com.cn/", "modifyInfo");
	private final static QName _ModifyInfoResponse_QNAME = new QName(
			"http://cxf.softvan.com.cn/", "modifyInfoResponse");
	private final static QName _SaveInfo_QNAME = new QName(
			"http://cxf.softvan.com.cn/", "saveInfo");
	private final static QName _Test_QNAME = new QName(
			"http://cxf.softvan.com.cn/", "test");
	private final static QName _DelInfo_QNAME = new QName(
			"http://cxf.softvan.com.cn/", "delInfo");
	private final static QName _SaveInfoResponse_QNAME = new QName(
			"http://cxf.softvan.com.cn/", "saveInfoResponse");
	private final static QName _DelInfoResponse_QNAME = new QName(
			"http://cxf.softvan.com.cn/", "delInfoResponse");
	private final static QName _GetInfo_QNAME = new QName(
			"http://cxf.softvan.com.cn/", "getInfo");
	private final static QName _GetInfoResponse_QNAME = new QName(
			"http://cxf.softvan.com.cn/", "getInfoResponse");
	private final static QName _TestResponse_QNAME = new QName(
			"http://cxf.softvan.com.cn/", "testResponse");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of
	 * schema derived classes for package: cn.com.softvan.cxf.client
	 * 
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link TestResponse }
	 * 
	 */
	public TestResponse createTestResponse() {
		return new TestResponse();
	}

	/**
	 * Create an instance of {@link DelInfo }
	 * 
	 */
	public DelInfo createDelInfo() {
		return new DelInfo();
	}

	/**
	 * Create an instance of {@link ModifyInfoResponse }
	 * 
	 */
	public ModifyInfoResponse createModifyInfoResponse() {
		return new ModifyInfoResponse();
	}

	/**
	 * Create an instance of {@link SaveInfo }
	 * 
	 */
	public SaveInfo createSaveInfo() {
		return new SaveInfo();
	}

	/**
	 * Create an instance of {@link GetInfoResponse }
	 * 
	 */
	public GetInfoResponse createGetInfoResponse() {
		return new GetInfoResponse();
	}

	/**
	 * Create an instance of {@link SaveInfoResponse }
	 * 
	 */
	public SaveInfoResponse createSaveInfoResponse() {
		return new SaveInfoResponse();
	}

	/**
	 * Create an instance of {@link ModifyInfo }
	 * 
	 */
	public ModifyInfo createModifyInfo() {
		return new ModifyInfo();
	}

	/**
	 * Create an instance of {@link Test }
	 * 
	 */
	public Test createTest() {
		return new Test();
	}

	/**
	 * Create an instance of {@link GetInfo }
	 * 
	 */
	public GetInfo createGetInfo() {
		return new GetInfo();
	}

	/**
	 * Create an instance of {@link DelInfoResponse }
	 * 
	 */
	public DelInfoResponse createDelInfoResponse() {
		return new DelInfoResponse();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link ModifyInfo }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://cxf.softvan.com.cn/", name = "modifyInfo")
	public JAXBElement<ModifyInfo> createModifyInfo(ModifyInfo value) {
		return new JAXBElement<ModifyInfo>(_ModifyInfo_QNAME, ModifyInfo.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ModifyInfoResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://cxf.softvan.com.cn/", name = "modifyInfoResponse")
	public JAXBElement<ModifyInfoResponse> createModifyInfoResponse(
			ModifyInfoResponse value) {
		return new JAXBElement<ModifyInfoResponse>(_ModifyInfoResponse_QNAME,
				ModifyInfoResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link SaveInfo }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://cxf.softvan.com.cn/", name = "saveInfo")
	public JAXBElement<SaveInfo> createSaveInfo(SaveInfo value) {
		return new JAXBElement<SaveInfo>(_SaveInfo_QNAME, SaveInfo.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Test }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://cxf.softvan.com.cn/", name = "test")
	public JAXBElement<Test> createTest(Test value) {
		return new JAXBElement<Test>(_Test_QNAME, Test.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link DelInfo }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://cxf.softvan.com.cn/", name = "delInfo")
	public JAXBElement<DelInfo> createDelInfo(DelInfo value) {
		return new JAXBElement<DelInfo>(_DelInfo_QNAME, DelInfo.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link SaveInfoResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://cxf.softvan.com.cn/", name = "saveInfoResponse")
	public JAXBElement<SaveInfoResponse> createSaveInfoResponse(
			SaveInfoResponse value) {
		return new JAXBElement<SaveInfoResponse>(_SaveInfoResponse_QNAME,
				SaveInfoResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link DelInfoResponse }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://cxf.softvan.com.cn/", name = "delInfoResponse")
	public JAXBElement<DelInfoResponse> createDelInfoResponse(
			DelInfoResponse value) {
		return new JAXBElement<DelInfoResponse>(_DelInfoResponse_QNAME,
				DelInfoResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link GetInfo }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://cxf.softvan.com.cn/", name = "getInfo")
	public JAXBElement<GetInfo> createGetInfo(GetInfo value) {
		return new JAXBElement<GetInfo>(_GetInfo_QNAME, GetInfo.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link GetInfoResponse }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://cxf.softvan.com.cn/", name = "getInfoResponse")
	public JAXBElement<GetInfoResponse> createGetInfoResponse(
			GetInfoResponse value) {
		return new JAXBElement<GetInfoResponse>(_GetInfoResponse_QNAME,
				GetInfoResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link TestResponse }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://cxf.softvan.com.cn/", name = "testResponse")
	public JAXBElement<TestResponse> createTestResponse(TestResponse value) {
		return new JAXBElement<TestResponse>(_TestResponse_QNAME,
				TestResponse.class, null, value);
	}

}
