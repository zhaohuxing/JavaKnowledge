package com.sprint.bean;

import com.sprint.helloword.HelloApi;
import org.junit.Assert;
import org.junit.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class BeanTest {
	ApplicationContext context = new ClassPathXmlApplicationContext("helloword.xml"); 
	@Test
	public void testHelloImp2() {
		getBean("bean2").sayHello();
	}

	@Test
	public void testHelloApiStaticFactory() {
		getBean("bean3").sayHello();
	}

	@Test
	public void testHelloApiFactory() {
		getBean("bean4").sayHello();
	}

	@Test
	public void testHelloImp3() {
		getBean("bean5").sayHello();
		getBean("bean55").sayHello();
		getBean("bean555").sayHello();
	}

	@Test
	public void testDIStaticFactory() {
		getBean("bean6").sayHello();
		getBean("bean66").sayHello();
		getBean("bean666").sayHello();
	}

	@Test
	public void testDIFactory() {
		getBean("bean7").sayHello();
		getBean("bean77").sayHello();
		getBean("bean777").sayHello();
	}

	@Test
	public void testHelloImp4() {
		getBean("bean8").sayHello();
	}

	@Test
	public void testBoolean() {
		BooleanTestBean btb = context.getBean("bean9", BooleanTestBean.class);
		System.out.println(btb.isSuccess());
		btb = context.getBean("bean99", BooleanTestBean.class);
		System.out.println(btb.isSuccess());
		btb = context.getBean("bean999", BooleanTestBean.class);
		System.out.println(btb.isSuccess());
		
	}

	@Test
	public void testListBean() {
		ListTestBean ltb = (ListTestBean)getBean("listBean", ListTestBean.class);
		System.out.println(ltb.getValues());
	}

	@Test
	public void testSetBean() {
		CollectionTestBean ctb = (CollectionTestBean)getBean("setBean", CollectionTestBean.class);
		System.out.println(ctb.getValues());
	}

	@Test
	public void testArrayBean() {
		ArrayTestBean atb = (ArrayTestBean)getBean("arrayBean", ArrayTestBean.class);
		System.out.println(atb.getArray1()[0]);
		System.out.println(atb.getArray2());

	}
	private HelloApi getBean(String beanId) {
		HelloApi helloApi = context.getBean(beanId, HelloApi.class);
		return helloApi;
	}
	private Object getBean(String beanId, Class clazz) {
		Object object = context.getBean(beanId, clazz);
		return object;
	}

}
