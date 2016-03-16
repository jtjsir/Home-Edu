package com.jing.edu.service.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.jing.edu.common.BaseLogger;
import com.jing.edu.mapper.joggle.UserDetailDao;
import com.jing.edu.model.EduType.UserType;
import com.jing.edu.model.PageSet;
import com.jing.edu.model.UserDetailStu;
import com.jing.edu.model.UserDetailTea;
import com.jing.edu.service.FamilyService;

@Service
public class FamilyServiceImpl implements FamilyService,BaseLogger {

	private static final Logger logger = LogManager.getLogger(FamilyServiceImpl.class) ;
	
	@Resource
	public UserDetailDao userDetailDao;

	/**
	 * 根据City+grade+Subject关键字查询数据库将返回的字符串转换为json字符串
	 */
	@Override
	public String queryStuFamily(String city, String gradeSubject, String basePath,String page) {
		JSONArray stuArray = new JSONArray();
		JSONObject headOb = new JSONObject();

		PageSet pageSet = new PageSet() ;
		pageSet.setSize(4);
		pageSet.setPage(Integer.valueOf(page));
		List<UserDetailStu> stuFamily = userDetailDao.queryStuInfos(city, gradeSubject,pageSet.getOffset(),pageSet.getSize());
		//总记录数
		int count = userDetailDao.queryCountStuInfos(city, gradeSubject) ;
		if (stuFamily == null) {
			return null;
		} else {
			try {
				int size = stuFamily.size();
				for (int i = 0; i < size; i++) {
					JSONObject stuOb = new JSONObject();
					stuOb.put("name", stuFamily.get(i).getName());
					stuOb.put("realname", stuFamily.get(i).getRealName());
					stuOb.put("level", stuFamily.get(i).getLevel());
					stuOb.put("subjects", stuFamily.get(i).getSubject()) ;
					stuOb.put("imgpath", basePath + "/family/stu/photo?imgid=" + stuFamily.get(i).getName());
					stuArray.put(stuOb);
				}
				headOb.put("familys", stuArray);
				headOb.put("size", size) ;
				headOb.put("count", count) ;
				this.getLogger().debug("查询到的学生数据为: " + headOb.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return headOb.toString();
		}
	}

	@Override
	public String queryTeaFamily(String city, String gradeSubject, String basePath,String page) {
		JSONArray teaArray = new JSONArray();
		JSONObject headOb = new JSONObject();
		
		PageSet pageSet = new PageSet() ;
		pageSet.setSize(4);
		pageSet.setPage(Integer.valueOf(page));
		List<UserDetailTea> teaFamily = userDetailDao.queryTeaInfos(city, gradeSubject,pageSet.getOffset(),pageSet.getSize());
		//总记录数
		int count = userDetailDao.queryCountTeaInfos(city, gradeSubject) ;
		if (teaFamily == null) {
			return null;
		} else {
			try {
				int size = teaFamily.size();
				for (int i = 0; i < size; i++) {
					JSONObject teaOb = new JSONObject();
					teaOb.put("name", teaFamily.get(i).getName());
					teaOb.put("realname", teaFamily.get(i).getRealName());
					teaOb.put("level", teaFamily.get(i).getLevel());
					teaOb.put("subjects", teaFamily.get(i).getSubject()) ;
					teaOb.put("imgpath", basePath + "/family/tea/photo?imgid=" + teaFamily.get(i).getName());
					teaArray.put(teaOb);
				}
				headOb.put("familys", teaArray);
				headOb.put("size", size) ;
				headOb.put("count", count) ;
				this.getLogger().debug("查询到的教师数据为: " + headOb.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}

			return headOb.toString();
		}
	}

	@Override
	public Logger getLogger() {
		return this.logger;
	}

	@Override
	public InputStream getPhoto(String imgid,String userType) {
		InputStream is = null ;
		if(UserType.TEACHER.getName().equals(userType)){
			UserDetailTea tea = userDetailDao.queryTeaInfo(imgid) ;
			if(tea!=null){
				is = new ByteArrayInputStream(tea.getImage()) ;
			}
		}else if(UserType.STUDENT.getName().equals(userType)){
			UserDetailStu stu = userDetailDao.queryStuInfo(imgid) ;
			if(stu!=null){
				is = new ByteArrayInputStream(stu.getImage()) ;
			}
		}
		return is;
	}

	@Override
	public String queryAllStuFamily(String gradeSubject, String basePath, String page) {
		JSONArray stuArray = new JSONArray();
		JSONObject headOb = new JSONObject();

		PageSet pageSet = new PageSet() ;
		pageSet.setSize(4);
		pageSet.setPage(Integer.valueOf(page));
		List<UserDetailStu> stuFamily = userDetailDao.queryAllStuInfos(gradeSubject,pageSet.getOffset(),pageSet.getSize());
		//总记录数
		int count = userDetailDao.queryCountAllStuInfos(gradeSubject) ;
		if (stuFamily == null) {
			return null;
		} else {
			try {
				int size = stuFamily.size();
				for (int i = 0; i < size; i++) {
					JSONObject stuOb = new JSONObject();
					stuOb.put("name", stuFamily.get(i).getName()) ;
					stuOb.put("realname", stuFamily.get(i).getRealName());
					stuOb.put("level", stuFamily.get(i).getLevel());
					stuOb.put("subjects", stuFamily.get(i).getSubject()) ;
					stuOb.put("imgpath", basePath + "/family/stu/photo?imgid=" + stuFamily.get(i).getName());
					stuArray.put(stuOb);
				}
				headOb.put("familys", stuArray);
				headOb.put("size", size) ;
				headOb.put("count", count) ;
				this.getLogger().debug("查询到的学生数据为: " + headOb.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return headOb.toString();
		}
	}

	@Override
	public String queryAllTeaFamily(String gradeSubject, String basePath, String page) {
		JSONArray teaArray = new JSONArray();
		JSONObject headOb = new JSONObject();

		PageSet pageSet = new PageSet() ;
		pageSet.setSize(4);
		pageSet.setPage(Integer.valueOf(page));
		List<UserDetailTea> teaFamily = userDetailDao.queryAllTeaInfos(gradeSubject,pageSet.getOffset(),pageSet.getSize());
		//总记录数
		int count = userDetailDao.queryCountAllTeaInfos(gradeSubject) ;
		if (teaFamily == null) {
			return null;
		} else {
			try {
				int size = teaFamily.size();
				for (int i = 0; i < size; i++) {
					JSONObject teaOb = new JSONObject();
					teaOb.put("name", teaFamily.get(i).getName()) ;
					teaOb.put("realname", teaFamily.get(i).getRealName());
					teaOb.put("level", teaFamily.get(i).getLevel());
					teaOb.put("subjects", teaFamily.get(i).getSubject()) ;
					teaOb.put("imgpath", basePath + "/family/tea/photo?imgid=" + teaFamily.get(i).getName());
					teaArray.put(teaOb);
				}
				headOb.put("familys", teaArray);
				headOb.put("size", size) ;
				headOb.put("count", count) ;
				this.getLogger().debug("查询到的教师数据为: " + headOb.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return headOb.toString();
		}
	}
	

}
