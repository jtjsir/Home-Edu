package com.jing.edu.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.jing.edu.mapper.joggle.UserDao;
import com.jing.edu.mapper.joggle.UserDetailDao;
import com.jing.edu.mapper.joggle.UserNoticeDao;
import com.jing.edu.model.EduType.UserType;
import com.jing.edu.model.User;
import com.jing.edu.model.UserDetail;
import com.jing.edu.model.UserDetailStu;
import com.jing.edu.model.UserDetailTea;
import com.jing.edu.model.UserNotice;
import com.jing.edu.service.UserNormalService;

@Service
public class UserNormalServiceImpl implements UserNormalService {

	private static final Logger normalServiceLogger = LogManager.getLogger(UserNormalServiceImpl.class);

	@Resource
	UserDao userDao;
	@Resource
	UserDetailDao userDetailDao;

	@Resource
	UserNoticeDao noticeDao;

	@Override
	public UserDetailStu getStuDetail(String name) {
		UserDetailStu detailStu = userDetailDao.queryStuInfo(name);
		if (detailStu == null) {
			return null;
		} else {
			return detailStu;
		}
	}

	@Override
	public UserDetailTea getTeaDetail(String name) {
		UserDetailTea detailTea = userDetailDao.queryTeaInfo(name);
		if (detailTea == null) {
			return null;
		} else {
			return detailTea;
		}
	}

	@Override
	public User getUser(String name) {
		User user = userDao.queryUserByName(name);
		if (user == null) {
			return null;
		} else {
			return user;
		}
	}

	@Override
	public void updateIsonline(String username, String type, int onlineValue) {
		Map<String, Object> map = new HashMap<>();
		map.put("username", username);
		map.put("type", type);
		map.put("onlineValue", onlineValue);
		userDetailDao.setIsonline(map);
	}

	@Override
	public void addDetail(UserDetail userDetail) {
		userDetailDao.insertDetail(userDetail);
		normalServiceLogger.debug("<<第一次添加用户详细信息成功>>");
	}

	@Override
	public void updateNotices(UserNotice userNotice) {
		String username = userNotice.getUsername();
		String fromname = userNotice.getFromname();
		if (null != noticeDao.readNoticeByName(username, fromname)) {
			noticeDao.updateNotice(userNotice);
		} else {
			// fromname第一次赞username的人
			noticeDao.insertNotice(userNotice);
		}
	}

	@Override
	public int readNoticeNums(String username) {
		return noticeDao.readNoticeNums(username) ;
	}

	@Override
	public boolean isNoticedByFromName(String username, String fromname) {
		boolean flag = false ;
		UserNotice userNotice = noticeDao.readNoticeByName(username, fromname) ;
		if(null!=userNotice){
			if(userNotice.getIsnotice()==1){
				flag = true ;
			}
		}
		return flag;
	}
	
	
}
