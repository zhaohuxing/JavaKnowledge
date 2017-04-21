package com.sprint.bean.details;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class DetailsTest {
	ApplicationContext context = new ClassPathXmlApplicationContext("/config/spring-bean-detail.xml");
	@Test
	public void testStraightValues() {
		StraightValues sv = context.getBean("straightValues", StraightValues.class);
		System.out.println(sv);
	}

	@Test
	public void testIdref() {
		Idref idref = context.getBean("idref", Idref.class);
		System.out.println(idref.getTargetName());
	}

	@Test 
	public void testRef() {
		Ref ref = context.getBean("ref", Ref.class);
		System.out.println(ref.getRef());
	}

	@Test
	public void testInnerBeans() {
		OutBean ob = context.getBean("inner", OutBean.class);
		System.out.println(ob.getInner());
	}

	@Test
	public void testCollections() {
		Collections collection = context.getBean("collections", Collections.class);
		System.out.println(collection.getAdminEmails());
		System.out.println(collection.getSomeList());
		System.out.println(collection.getSomeMap());
		System.out.println(collection.getSomeSet());
	}

	@Test
	public void testCollectionMerging() {
		CollectionMerging merging = context.getBean("subCollectionMerging", CollectionMerging.class);
		System.out.println(merging.getSomeList());
	}

	@Test
	public void testStronglyTypeCollection() {
		StronglyTypeCollection stc = context.getBean("strongCollection", StronglyTypeCollection.class);
		System.out.println(stc.getAccounts());
	}
}
