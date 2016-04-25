package com.jing.edu.model;

public class GoeasyAccount {

	// 接受消息与推送消息的key
	private String superKey;
	
	// 只接受消息的key
	private String subscribeKey;

	public String getSuperKey() {
		return superKey;
	}

	public void setSuperKey(String superKey) {
		this.superKey = superKey;
	}

	public String getSubscribeKey() {
		return subscribeKey;
	}

	public void setSubscribeKey(String subscribeKey) {
		this.subscribeKey = subscribeKey;
	}

}
