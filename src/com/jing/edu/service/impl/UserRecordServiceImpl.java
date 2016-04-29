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
import com.jing.edu.common.util.EmailUtil;
import com.jing.edu.common.util.StringUtil;
import com.jing.edu.mapper.joggle.UserDao;
import com.jing.edu.mapper.joggle.UserRecordDao;
import com.jing.edu.model.EduType.UserType;
import com.jing.edu.model.UserRecord;
import com.jing.edu.model.record.STRecord;
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

	@Resource
	public UserDao userDao;

	/**
	 * 根据stuid查询数据库得出相应的教师请求记录
	 */
	@Override
	public String queryRecordsByStudent(String stuname) {
		List<UserRecord> records = userRecordDao.queryRecordsByStudent(stuname);
		JSONObject headOb = new JSONObject();
		if (records != null && records.size() > 0) {
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
					teaObject.put("sex", teaUser.getSex());
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
	public String queryRecordsByTeacher(String teaname) {
		List<UserRecord> records = userRecordDao.queryRecordsByTeacher(teaname);
		//
		JSONObject headOb = new JSONObject();
		if (records != null && records.size() > 0) {
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
	public void setRecordIsIngnored(String detailPath, String stuname, String teaname, String guideby,
			String isdelete) {
		int guide = Integer.valueOf(guideby);
		// 邮箱反馈给订阅者
		String email = null;
		StringBuffer content = new StringBuffer();
		if ("1".equals(isdelete)) {
			userRecordDao.updateIsdelete(stuname, teaname, guide, 1);
			if (0 == guide) {
				email = userDao.queryUserByName(stuname).getEmail();
				// 拼装订阅失败内容
				content.append("<p>").append("亲爱的 <strong>").append(stuname).append("</strong> 用户,")
						.append("您订阅 <strong><a href='").append(detailPath).append("'>").append(teaname)
						.append(" </a></strong>用户的请求已被其推回</p>").append("<p>").append("时间: ")
						.append(StringUtil.getNowFormatTime());
			} else {
				email = userDao.queryUserByName(teaname).getEmail();
				content.append("<p>").append("亲爱的 <strong>").append(teaname).append("</strong> 用户,")
						.append("您订阅 <strong><a href='").append(detailPath).append("'>").append(stuname)
						.append(" </a></strong>用户的请求已被其推回</p>").append("<p>").append("时间: ")
						.append(StringUtil.getNowFormatTime());
			}
		} else {
			if (0 == guide) {
				email = userDao.queryUserByName(stuname).getEmail();
				// 拼装订阅成功内容
				content.append("<p>").append("亲爱的 <strong>").append(stuname).append("</strong> 用户,")
						.append("您订阅 <strong><a href='").append(detailPath).append("'>").append(teaname)
						.append(" </a></strong>用户的请求已被其接受</p>").append("<p>").append("时间: ")
						.append(StringUtil.getNowFormatTime());
			} else {
				email = userDao.queryUserByName(teaname).getEmail();
				content.append("<p>").append("亲爱的 <strong>").append(teaname).append("</strong> 用户,")
						.append("您订阅 <strong><a href='").append(detailPath).append("'>").append(stuname)
						.append(" </a></strong>用户的请求已被其接受</p>").append("<p>").append("时间: ")
						.append(StringUtil.getNowFormatTime());
			}
		}
		String title = "订阅信息反馈[在线家教网]";
		EmailUtil.sendEmail(email, title, content.toString());
	}

	/**
	 * username-被推荐的用户名 subject-根据课程推荐 searchType-查找的类别
	 */
	@Override
	public String queryRecordsBySubject(String username, String subject, String searchType) {
		String result = null;
		if (subject != null) {
			String[] res = StringUtil.seperateSubject(subject);
			Random random = new Random();
			result = res[random.nextInt(res.length)];
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
					return headOb.toString();
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
					return headOb.toString();
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
		int guideby = Integer.valueOf(paramMap.get("guideby"));
		STRecord record = userRecordDao.readRecord(paramMap.get("stuname"), paramMap.get("teaname"), guideby);
		// 判断
		if (null == record) {
			userRecordDao.insertUserRecord(paramMap.get("stuname"), paramMap.get("teaname"), guideby, 0);
		} else {
			userRecordDao.updateIsdelete(paramMap.get("stuname"), paramMap.get("teaname"), guideby, 0);
		}

	}

	@Override
	public boolean isSubsribed(String stuname, String teaname, String guideby) {
		boolean flag = false;
		int guide = Integer.valueOf(guideby);
		STRecord record = userRecordDao.readRecord(stuname, teaname, guide);
		// 不存在记录或者已经被忽略过
		if (null == record || record.getIsdelete() == 1) {
			flag = false;
		} else {
			flag = true;
		}
		return flag;
	}

}
