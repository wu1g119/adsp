package test.junit;

import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

//公用的抽像类，继承已实现的spring junit类
@SuppressWarnings("deprecation")
public abstract class AbstractTest extends AbstractDependencyInjectionSpringContextTests {
	public AbstractTest(String name) {
		super(name);
	}
	public AbstractTest() {
		super();
	}
//  加载spring bean
//  protected String[] getConfigLocations() {
//      return new String[]{"classpath:/config/spring/applicationContext*.xml"};
//  }
}