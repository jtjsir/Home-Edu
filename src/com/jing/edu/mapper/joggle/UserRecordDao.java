package com.jing.edu.mapper.joggle;

import java.util.List;

import com.jing.edu.model.UserRecord;
import com.jing.edu.model.UserDetailStu;
import com.jing.edu.model.UserDetailTea;

public interface UserRecordDao {

	void insertUserRecord(String stuname,String teaname,int guideby,int isdelete);
	
	List<UserRecord> queryRecordsByStudent(String stuname);
	
	List<UserRecord> queryRecordsByTeacher(String teaname) ;
	
	List<UserDetailTea> queryTeaRecordsBySubject(String sub) ;
	
	List<UserDetailStu> queryStuRecordsBySubject(String sub) ;
	
	void updateIsdelete(String stuname,String teaname,int guideby,int isdelete);
}
