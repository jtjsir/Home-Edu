package com.jing.edu.model;

/**
 * 学生教师关系表
 * @author jing
 *
 */
public class StuTeacherRecord {

	private int id ;
	private User student ;//对应stuid
	private User teacher ;//对应teacherid
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getStudent() {
		return student;
	}
	public void setStudent(User student) {
		this.student = student;
	}
	public User getTeacher() {
		return teacher;
	}
	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}
	
	
}
