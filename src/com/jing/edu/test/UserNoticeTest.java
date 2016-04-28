package com.jing.edu.test;

import org.junit.Before;
import org.junit.Test;

import com.jing.edu.common.BaseTest;
import com.jing.edu.mapper.joggle.UserNoticeDao;
import com.jing.edu.model.UserNotice;

public class UserNoticeTest extends BaseTest{

	UserNoticeDao noticeDao ;
	
	@Before
	public void setUp(){
		noticeDao = context.getBean(UserNoticeDao.class) ;
	}
	
	@Test
	public void testIn(){
		UserNotice notice = new UserNotice() ;
		notice.setUsername("yangkf");
		notice.setType(2);
		notice.setFromname("yangkf");
		notice.setIsnotice(1);
		noticeDao.insertNotice(notice);
	}
	
	@Test
	public void testRead(){
		System.err.println(noticeDao.readNoticeByType(1).get(0).getNoticeNums()) ;
	}
}
