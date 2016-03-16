package com.jing.edu.mapper.joggle;

import java.util.List;

import com.jing.edu.model.StuTeacherRecord;
import com.jing.edu.model.UserDetailStu;
import com.jing.edu.model.UserDetailTea;

public interface UserRecordDao {

	void insertUserRecord(int stuid,int teacherid,int guideby,int isdelete);
	
	List<StuTeacherRecord> queryRecordsByStudent(int stuid);
	
	List<StuTeacherRecord> queryRecordsByTeacher(int teacherid) ;
	
	List<UserDetailTea> queryTeaRecordsBySubject(String sub) ;
	
	List<UserDetailStu> queryStuRecordsBySubject(String sub) ;
	
	void updateIsdelete(int stuid,int teacherid,int guideby);
}
