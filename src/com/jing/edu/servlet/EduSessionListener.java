package com.jing.edu.servlet;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jing.edu.model.EduType.UserType;
import com.jing.edu.common.util.StringUtil;
import com.jing.edu.model.User;
import com.jing.edu.service.UserNormalService;
import com.jing.edu.service.impl.UserNormalServiceImpl;

public class EduSessionListener implements HttpSessionListener {

	private static ClassPathXmlApplicationContext context ;
	
	private static final String classpathFile = "classpath:com/jing/resources/spring/springContext.xml" ;
	
	public UserNormalService normalService;

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println(StringUtil.getNowFormatTime() +" EduSessionListener监听到session已经创建");
		context = new ClassPathXmlApplicationContext(classpathFile) ;
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		normalService = context.getBean(UserNormalServiceImpl.class) ;
		// session失效更新状态
		String sessionId = event.getSession().getId();
		User user = (User) event.getSession().getAttribute(sessionId);
		if (null != user) {
			if (1 == user.getType()) {
				normalService.updateIsonline(user.getUsername(), UserType.TEACHER.getName(), 0);
			} else if (2 == user.getType()) {
				normalService.updateIsonline(user.getUsername(), UserType.STUDENT.getName(), 0);
			}
			System.out.println(StringUtil.getNowFormatTime() +" " + user.getUsername() + " 已经下线");
		}
		System.out.println(StringUtil.getNowFormatTime() +" EduSessionListener监听到session已经销毁");
	}

}
