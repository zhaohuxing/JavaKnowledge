package com.sprint.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.ApplicationContext;
import org.junit.Assert;
import org.junit.Test;
public class ATestTest {

	ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
	@Test
	public void test() {
		ATest at = ctx.getBean(ATestImpl.class);
		at.print();
	}
}
