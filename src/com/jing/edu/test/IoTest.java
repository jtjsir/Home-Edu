package com.jing.edu.test;

import org.junit.Test;

import com.jing.edu.common.BaseTest;

public class IoTest extends BaseTest{
	
	@Test
	public void testScanner(){
		java.util.Scanner scanner = new java.util.Scanner(System.in) ;
		while(scanner.hasNext()){
			String content = scanner.nextLine() ;
			System.out.println("输入的content值为: " + content);
		}
	}
}
