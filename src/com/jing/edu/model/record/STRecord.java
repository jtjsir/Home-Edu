package com.jing.edu.model.record;

/**
 * core_stuteacher_record表Entity
 * @author jtj
 *
 */
public class STRecord {
	private int id;
	private String stuname;
	private String teaname;
	private int guideby;
	private int isdelete;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStuname() {
		return stuname;
	}

	public void setStuname(String stuname) {
		this.stuname = stuname;
	}

	public String getTeaname() {
		return teaname;
	}

	public void setTeaname(String teaname) {
		this.teaname = teaname;
	}

	public int getGuideby() {
		return guideby;
	}

	public void setGuideby(int guideby) {
		this.guideby = guideby;
	}

	public int getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}

}
