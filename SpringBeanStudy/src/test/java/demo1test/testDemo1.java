package demo1test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import common.JunitTestBase;
import demo1.OneInterface;

@RunWith(BlockJUnit4ClassRunner.class)
public class testDemo1 extends JunitTestBase{
	
	public testDemo1 () {
		super("classpath*:spring-bean.xml");
	}
	
	@Test
	public void testHello() {
		OneInterface oneInterface = super.getBean("oneInterface");
		System.out.println(oneInterface.hello("this is my tset word !"));
	}
}
