package com.yqxd.entity;

public class Medical {
	int id;
	String time;
	String pname;
	String dname;
	String classify;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getClassify() {
		return classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}
	public Medical(int id, String time, String pname, String dname, String classify) {
		super();
		this.id = id;
		this.time = time;
		this.pname = pname;
		this.dname = dname;
		this.classify = classify;
	}
	public Medical() {
		super();
	}
	@Override
	public String toString() {
		return "Medical [id=" + id + ", time=" + time + ", pname=" + pname + ", dname=" + dname + ", classify="
				+ classify + "]";
	}
}
