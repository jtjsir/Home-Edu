package com.jing.edu.test;

import java.io.File;

import org.junit.Assert;

import com.jing.edu.common.BaseTest;

public class UserContentTest extends BaseTest{
	
	public void testReadFile(){
		String filename = "src/com/jing/resources/html/personHTML.txt" ;
		File file = new File(filename) ;
		Assert.assertNotNull(file);
	}
	
}
