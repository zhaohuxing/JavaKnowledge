package com.sprint.helloword;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class HelloTest {
	@Test
	public void testHello() {
		ApplicationContext context = new ClassPathXmlApplicationContext("helloword.xml"); 
		/*面向接口编程，而非实现*/
		HelloApi helloApi = context.getBean("bean1", HelloApi.class);
		helloApi.sayHello();
	}

	@Test
	public void testAlias() {
		ApplicationContext context = new ClassPathXmlApplicationContext("helloword.xml");
		String[] alias = context.getAliases("bean1");
		Assert.assertEquals(0, alias.length);
	}

	
}
