package com.jing.edu.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.jing.edu.common.BaseLogger;
import com.jing.edu.common.util.StringUtil;
import com.jing.edu.mapper.joggle.UserRecordDao;
import com.jing.edu.model.EduType.UserType;
import com.jing.edu.model.StuTeacherRecord;
import com.jing.edu.model.User;
import com.jing.edu.model.UserDetailStu;
import com.jing.edu.model.UserDetailTea;
import com.jing.edu.service.UserRecordService;

/**
 * 学生教师订阅表处理service
 * 
 * @author jing
 *
 */
@Service
public class UserRecordServiceImpl implements UserRecordService, BaseLogger {

	private static final Logger logger = LogManager.getLogger(UserRecordServiceImpl.class);

	@Resource
	public UserRecordDao userRecordDao;

	/**
	 * 根据stuid查询数据库得出相应的教师请求记录
	 */
	@Override
	public String queryRecordsByStudent(String stuid) {
		int id = Integer.valueOf(stuid);
		List<StuTeacherRecord> records = userRecordDao.queryRecordsByStudent(id);
		JSONObject headOb = new JSONObject();
		if (records != null) {
			// 转换为jsonArray
			JSONArray teArray = new JSONArray();
			int recordsLen = records.size();
			try {
				for (int i = 0; i < recordsLen; i++) {
					JSONObject teaObject = new JSONObject();
					User teaUser = records.get(i).getTeacher();
					teaObject.put("id", teaUser.getId());
					teaObject.put("username", teaUser.getUsername());
					teaObject.put("age", teaUser.getAge());
					teaObject.put("level", teaUser.getLevel());
					teArray.put(teaObject);
				}
				headOb.put("records", teArray);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			this.getLogger().debug(records.get(0).getStudent().getUsername() + "　收到的订阅信息为: " + headOb.toString());

		} else {
			return null;
		}

		return headOb.toString();
	}

	/**
	 * 根据teaid查询数据库得出相应的学生请求记录
	 */
	@Override
	public String queryRecordsByTeacher(String teaid) {
		int id = Integer.valueOf(teaid);
		List<StuTeacherRecord> records = userRecordDao.queryRecordsByTeacher(id);
		//
		JSONObject headOb = new JSONObject();
		if (records != null) {
			JSONArray stuArray = new JSONArray();
			int recordsLen = records.size();
			try {
				for (int i = 0; i < recordsLen; i++) {
					JSONObject stuObject = new JSONObject();
					User stUser = records.get(i).getStudent();
					// 获取id 姓名、年龄、学历
					stuObject.put("id", stUser.getId());
					stuObject.put("username", stUser.getUsername());
					stuObject.put("age", stUser.getAge());
					stuObject.put("sex", stUser.getSex());
					stuObject.put("level", stUser.getLevel());
					stuArray.put(stuObject);
				}
				headOb.put("records", stuArray);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			this.getLogger().debug(records.get(0).getTeacher().getUsername() + "　收到的订阅信息为: " + headOb.toString());
		} else {
			return null;
		}

		return headOb.toString();
	}

	@Override
	public Logger getLogger() {
		return this.logger;
	}

	/**
	 * 设置该条消息为忽略状态
	 */
	@Override
	public void setRecordIngnored(String stuid, String teacherid, String guideby) {
		int stu = Integer.valueOf(stuid);
		int teacher = Integer.valueOf(teacherid);
		int guide = Integer.valueOf(guideby);

		userRecordDao.updateIsdelete(stu, teacher, guide);
	}

	/**
	 * username-被推荐的用户名
	 * subject-根据课程推荐
	 * searchType-查找的类别
	 */
	@Override
	public String queryRecordsBySubject(String username, String subject, String searchType) {
		String result = null;
		if (subject != null) {
			String[] res = StringUtil.seperateSubject(subject);
			Random random = new Random();
			result = res[random.nextInt(3)];
			JSONArray contentArray = new JSONArray();
			JSONObject headOb = new JSONObject();
			if (UserType.TEACHER.getName().equals(searchType)) {
				List<UserDetailStu> stus = userRecordDao.queryStuRecordsBySubject(result);
				if (stus != null) {
					try {
						int len = stus.size();
						for (int i = 0; i < len; i++) {
							JSONObject oneStu = new JSONObject();
							UserDetailStu stu = stus.get(i);
							oneStu.put("username", stu.getName());
							oneStu.put("level", stu.getLevel());
							oneStu.put("price", stu.getPrice());
							contentArray.put(oneStu);
						}
						headOb.put("recommRecords", contentArray);
					} catch (Exception e) {
						e.printStackTrace();
					}
					this.getLogger().debug(username + "　收到的推荐资源信息为: " + headOb.toString());
					return headOb.toString() ;
				}
			} else if (UserType.STUDENT.getName().equals(searchType)) {
				List<UserDetailTea> teas = userRecordDao.queryTeaRecordsBySubject(result);
				if (teas != null) {
					try {
						int len = teas.size();
						for (int i = 0; i < len; i++) {
							JSONObject onetea = new JSONObject();
							UserDetailTea tea = teas.get(i);
							onetea.put("username", tea.getName());
							onetea.put("level", tea.getLevel());
							onetea.put("price", tea.getPrice());
							contentArray.put(onetea);
						}
						headOb.put("recommRecords", contentArray);
					} catch (Exception e) {
						e.printStackTrace();
					}
					this.getLogger().debug(username + "　收到的推荐资源信息为: " + headOb.toString());
					return headOb.toString() ;
				}
			}
		}
		return null;
	}

	/**
	 * 插入数据库订阅信息
	 */
	@Override
	public void addSubscribtion(Map<String, String> paramMap) {
		String stu = paramMap.get("stuid") ;
		int stuid = Integer.valueOf(stu) ;
		int teacherid = Integer.valueOf(paramMap.get("teacherid")) ;
		int guideby = Integer.valueOf(paramMap.get("guideby")) ;
		//默认为0
		int isdelete = 0 ;
		if(paramMap.get("isdelete")!=null){
			isdelete = Integer.valueOf(paramMap.get("isdelete")) ;
		}
		userRecordDao.insertUserRecord(stuid, teacherid, guideby, isdelete);
		
	}

}
