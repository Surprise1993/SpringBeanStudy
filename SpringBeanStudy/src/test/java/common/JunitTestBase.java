package common;

import org.junit.After;
import org.junit.Before;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

public class JunitTestBase {
	
	private ClassPathXmlApplicationContext context;

	private String springXmlPath;
	
	public JunitTestBase () {}
	
	public JunitTestBase (String springXmlpath) {
		this.springXmlPath = springXmlpath;
		System.out.println("springXmlpath 的 值是 " + this.springXmlPath);
	}
	
	@Before
	public void before () {
		System.out.println("开始执行 before, springXmlPath 的值是" + springXmlPath);
		if (StringUtils.isEmpty(springXmlPath)) {
			springXmlPath = "classpath*:spring-*.xml";
		}
		try {
			System.out.println("开始装载上下文信息");
//			读取XML的信息并将信息装载到context上下文当中
			String [] url = springXmlPath.split("[,\\s]+");
			context = new ClassPathXmlApplicationContext(url);
			context.start();
		} catch (BeansException e) {
			e.printStackTrace();
		}
	}
	
	@After
	public void after () {
		context.destroy();
	}
	
	@SuppressWarnings("unchecked")
	protected <T extends Object> T getBean(String beanId) {
		try {
			return (T)context.getBean(beanId);
		} catch (BeansException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	protected <T extends Object> T getBean(Class<T> clazz) {
		try {
			return context.getBean(clazz);
		} catch (BeansException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
