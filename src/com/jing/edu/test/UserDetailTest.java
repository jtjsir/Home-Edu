package com.jing.edu.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.jing.edu.common.BaseTest;
import com.jing.edu.mapper.joggle.UserDetailDao;
import com.jing.edu.model.UserDetailTea;

public class UserDetailTest extends BaseTest{

	UserDetailDao userDetailDao ;
	
	@Before
	public void setup(){
		userDetailDao = context.getBean(UserDetailDao.class) ;
	}
	
	@Test
	public void insertPhoto(){
		UserDetailTea tea = new UserDetailTea() ;
		tea.setName("xiaosen");
		tea.setRealName("小森");
		tea.setType(1);
		tea.setLevel("大学");
		tea.setIntroduction("a good man");
		tea.setSchool("杭州电子科技大学");
		tea.setHonor("获得多项荣誉");
		File file = new File("src/testgirl.jpg") ;
		byte[] image = new byte[(int)file.length()] ;
		try {
			new FileInputStream(file).read(image, 0, image.length) ;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		tea.setImage(image);
		tea.setSubject("小学数学,初中数学,高中数学");
		tea.setIsonline(0);
		tea.setPrice("6元/分");
		tea.setCity("浙江杭州");
		userDetailDao.insertDetail(tea);
	}
	
	@Test
	public void queryInfos(){
		System.out.println(userDetailDao.queryCountTeaInfos("浙江杭州市", "小学数学")) ;
	}
}
