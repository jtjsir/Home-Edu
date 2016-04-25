package com.jing.edu.model;

import java.util.List;

public class GoeasyApp {

	String applicationName;
	String createTime;
	List<GoeasyAccount> accounts;

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public List<GoeasyAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<GoeasyAccount> accounts) {
		this.accounts = accounts;
	}

}
