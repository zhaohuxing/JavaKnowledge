package com.sprint.helloword;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class HelloTest {
	@Test
	public void testHello() {
		/*面向接口编程，而非实现*/
		ApplicationContext context = new ClassPathXmlApplicationContext("first.xml");
		HelloApi helloApi = context.getBean("hello", HelloApi.class);
		helloApi.sayHello();
	}

	
}
