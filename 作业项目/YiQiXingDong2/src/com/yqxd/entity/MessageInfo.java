package com.yqxd.entity;

public class MessageInfo {
	int id;
	String phone;
	String time;
	String passage;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPassage() {
		return passage;
	}
	public void setPassage(String passage) {
		this.passage = passage;
	}
	public MessageInfo(int id, String phone, String time, String passage) {
		super();
		this.id = id;
		this.phone = phone;
		this.time = time;
		this.passage = passage;
	}
	public MessageInfo() {
		super();
	}
	@Override
	public String toString() {
		return "MessageInfo [id=" + id + ", phone=" + phone + ", time=" + time + ", passage=" + passage + "]";
	}
	
}
