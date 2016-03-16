package com.jing.edu.common;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BaseTest {
	public static ClassPathXmlApplicationContext context = null ;
	
	
	public BaseTest(){
		context = new ClassPathXmlApplicationContext("classpath:com/jing/resources/spring/springContext.xml") ;
	}
	
	@Test
	public void testClassPathXML(){
		Assert.assertNotNull(context);
	}
}
