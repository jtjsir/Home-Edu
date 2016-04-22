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
import com.jing.edu.common.util.SortUtil;
import com.jing.edu.mapper.joggle.UserDao;
import com.jing.edu.mapper.joggle.UserDetailDao;
import com.jing.edu.mapper.joggle.UserNoticeDao;
import com.jing.edu.model.EduType.LevelType;
import com.jing.edu.model.EduType.SortType;
import com.jing.edu.model.EduType.UserType;
import com.jing.edu.model.PageSet;
import com.jing.edu.model.User;
import com.jing.edu.model.UserDetail;
import com.jing.edu.model.UserDetailStu;
import com.jing.edu.model.UserDetailTea;
import com.jing.edu.model.UserNotice;
import com.jing.edu.service.FamilyService;
import com.jing.edu.service.util.FamilyUtil;

@Service
public class FamilyServiceImpl implements FamilyService, BaseLogger {

	private static final Logger logger = LogManager.getLogger(FamilyServiceImpl.class);

	@Resource
	public UserDetailDao userDetailDao;
	
	@Resource
	public UserDao userDao ;
	
	@Resource
	public UserNoticeDao noticeDao ;

	/**
	 * 根据City+grade+Subject关键字查询数据库将返回的字符串转换为json字符串
	 */
	@Override
	public String queryStuFamily(String city, String gradeSubject, String userType, String basePath, String page) {
		PageSet pageSet = new PageSet();
		pageSet.setSize(4);
		pageSet.setPage(Integer.valueOf(page));

		List<UserDetailStu> stuFamily = null;
		stuFamily = userDetailDao.queryStuInfos(city, gradeSubject, pageSet.getOffset(), pageSet.getSize());
		// 总记录数
		int stuCount = userDetailDao.queryCountStuInfos(city, gradeSubject);

		return this.packToJsonStr(userType, basePath, stuFamily, stuCount);
	}

	@Override
	public String queryTeaFamily(String city, String gradeSubject, String userType, String basePath, String page) {
		PageSet pageSet = new PageSet();
		pageSet.setSize(4);
		pageSet.setPage(Integer.valueOf(page));

		List<UserDetailTea> teaFamily = null;
		teaFamily = userDetailDao.queryTeaInfos(city, gradeSubject, pageSet.getOffset(), pageSet.getSize());
		// 总记录数
		int count = userDetailDao.queryCountTeaInfos(city, gradeSubject);

		return this.packToJsonStr(userType, basePath, teaFamily, count);
	}

	@Override
	public Logger getLogger() {
		return logger;
	}

	@Override
	public InputStream getPhoto(String imgid, String userType) {
		InputStream is = null;
		if (UserType.TEACHER.getName().equals(userType)) {
			UserDetailTea tea = userDetailDao.queryTeaInfo(imgid);
			if (tea != null) {
				is = new ByteArrayInputStream(tea.getImage());
			}
		} else if (UserType.STUDENT.getName().equals(userType)) {
			UserDetailStu stu = userDetailDao.queryStuInfo(imgid);
			if (stu != null) {
				is = new ByteArrayInputStream(stu.getImage());
			}
		}
		return is;
	}

	@Override
	public String queryPageStuFamily(String userType, String gradeSubject, String basePath, String page) {
		PageSet pageSet = new PageSet();
		pageSet.setSize(4);
		pageSet.setPage(Integer.valueOf(page));

		List<UserDetailStu> allStuFamily = null;
		allStuFamily = userDetailDao.queryAllStuInfos(gradeSubject, pageSet.getOffset(), pageSet.getSize());
		int count = userDetailDao.queryCountAllStuInfos(gradeSubject);

		return this.packToJsonStr(userType, basePath, allStuFamily, count);
	}

	@Override
	public String queryPageTeaFamily(String gradeSubject, String userType, String basePath, String page) {
		PageSet pageSet = new PageSet();
		pageSet.setSize(4);
		pageSet.setPage(Integer.valueOf(page));

		List<UserDetailTea> allTeaFamily = null;
		allTeaFamily = userDetailDao.queryAllTeaInfos(gradeSubject, pageSet.getOffset(), pageSet.getSize());
		// 总记录数
		int count = userDetailDao.queryCountAllTeaInfos(gradeSubject);

		return this.packToJsonStr(userType, basePath, allTeaFamily, count);
	}

	// 组装成json字符串 私有方法
	private String packToJsonStr(String userType, String basePath, List<? extends UserDetail> family, int count) {
		JSONArray familyArray = new JSONArray();
		JSONObject headOb = new JSONObject();

		if (null == family) {
			return null;
		} else {
			try {
				int size = family.size();
				for (int i = 0; i < size; i++) {
					JSONObject teaOb = new JSONObject();
					teaOb.put("name", family.get(i).getName());
					teaOb.put("realname", family.get(i).getRealName());
					teaOb.put("level", family.get(i).getLevel());
					teaOb.put("subjects", family.get(i).getSubject());
					teaOb.put("imgpath", basePath + "/family/" + userType + "/photo?imgid=" + family.get(i).getName());
					familyArray.put(teaOb);
				}
				headOb.put("familys", familyArray);
				headOb.put("size", size);
				headOb.put("count", count);
				this.getLogger().debug("查询到的用户数据为: " + headOb.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return headOb.toString();
		}
	}

	@Override
	public String querySortFamily(String city, String gradeSubject, String userType, String basePath, String page,
			String grade, String order, SortType sortType) {
		String result = null;
		
		//得到所有的stu/tea详细信息数据
		List<? extends UserDetail> detailusers = null;
		int typeNum = 0 ;
		if (userType.equals(UserType.STUDENT.getName())) {
			typeNum = UserType.STUDENT.getTypeNum() ;
			detailusers = userDetailDao.queryStuInfos(city, gradeSubject, 0, -1);
		} else if (userType.equals(UserType.TEACHER.getName())) {
			typeNum = UserType.TEACHER.getTypeNum() ;
			detailusers = userDetailDao.queryTeaInfos(city, gradeSubject, 0, -1);
		}
		//配置偏移量
		int pageNum = Integer.valueOf(page);
		int startOffset = (pageNum - 1) * 4;
		int endOffset = pageNum * 4;
		
		int ordernum = Integer.valueOf(order);
		int count = userDetailDao.queryCountStuInfos(city, gradeSubject);
		switch (sortType) {
		case SORT_PRICE:
			LevelType levelType = null;
			// grade转换为LevelType
			if (LevelType.PRIMARY.getKeyname().equals(grade)) {
				levelType = LevelType.PRIMARY;
			} else if (LevelType.MEDIUM.getKeyname().equals(grade)) {
				levelType = LevelType.MEDIUM;
			} else if (LevelType.SENIOR.getKeyname().equals(grade)) {
				levelType = LevelType.SENIOR;
			}
			// 先排序
			SortUtil.sortByPrice(detailusers, ordernum, levelType);
			// 裁剪List
			List<? extends UserDetail> subList = FamilyUtil.subList(detailusers, startOffset, endOffset);
			result = this.packToJsonStr(userType, basePath, subList, count);
			break;
		case SORT_AGE:
			List<User> baseSortUsers = userDao.queryUsersByType(typeNum) ;
			SortUtil.sortByAge(baseSortUsers, ordernum);
			List<UserDetail> ageFamily = FamilyUtil.reAddAgeList(baseSortUsers, detailusers) ;
			List<? extends UserDetail> subAgeList = FamilyUtil.subList(ageFamily, startOffset, endOffset);
			this.packToJsonStr(userType, basePath, subAgeList, count) ;
			break;
		case SORT_NOTICE:
			List<UserNotice> userNotices = noticeDao.readNoticeByType(typeNum) ;
			SortUtil.sortByNotice(userNotices, ordernum);
			List<UserDetail> noticeFamily = FamilyUtil.reAddNoticeList(userNotices, detailusers) ;
			List<? extends UserDetail> subNoticeList = FamilyUtil.subList(noticeFamily, startOffset, endOffset);
			this.packToJsonStr(userType, basePath, subNoticeList, count) ;
			break;
		default:
			this.getLogger().debug("没有相应的排序方法与之相对");
			break;
		}
		return result;
	}
}
