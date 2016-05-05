package com.jing.edu.service.impl;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.jing.edu.common.BaseLogger;
import com.jing.edu.common.util.ImageUtil;
import com.jing.edu.common.util.StringUtil;
import com.jing.edu.mapper.joggle.UserDetailDao;
import com.jing.edu.model.EduType.UserType;
import com.jing.edu.model.UserDetail;
import com.jing.edu.service.UserDetailService;
import com.jing.edu.thread.userdetail.UserPhotosToServer;

@Service
public class UserDetailServiceImpl implements UserDetailService,BaseLogger {

	private static final Logger logger = LogManager.getLogger(UserDetailServiceImpl.class) ;
	
	@Resource
	public UserDetailDao userdetailDao ;
	
	@Override
	public boolean validatePhoto(long imageSize) {
		return ImageUtil.isStrictImage(imageSize) ;
	}

	@Override
	public void insertDetailInfo(UserDetail userDetail) {
		//调整图片为先
		try {
			byte[] preImage = userDetail.getImage() ;
			byte[] image = ImageUtil.resizeImage(preImage, 200, "jpeg") ;
			userDetail.setImage(image);
		} catch (Exception e) {
			this.getLogger().debug(userDetail.getRealName() + " 的图片上传出错! ");
			e.printStackTrace();
		}
		userdetailDao.insertDetail(userDetail);
		this.getLogger().debug(userDetail.getRealName() + " 的图片上传成功! ");
	}

	@Override
	public Logger getLogger() {
		return logger;
	}

	@Override
	public void addPhotoToServer(String rootPath,String userType,String realname,String subjects,String level,byte[] images) {
		//通过另起一个线程去插入图片到服务端
		UserPhotosToServer userPhotoRun = new UserPhotosToServer(rootPath, userType, realname, subjects, level, images) ;
		new Thread(userPhotoRun).start();
	}

	/**
	 * 判断userdetail在表中是否有记录
	 */
	@Override
	public UserDetail queryUserDetail(String username, UserType userType) {
		UserDetail userdetail = null ;
		if(UserType.STUDENT.equals(userType)){
			userdetail = userdetailDao.queryStuInfo(username) ;
		}else if(UserType.TEACHER.equals(userType)){
			userdetail = userdetailDao.queryTeaInfo(username) ;
		}
		return userdetail ;
	}

	@Override
	public void update(UserDetail detail) {
		userdetailDao.updateDetail(detail);
		logger.debug(StringUtil.getNowFormatTime() + " " + detail.getName() + "更新数据成功！");
	}

}
