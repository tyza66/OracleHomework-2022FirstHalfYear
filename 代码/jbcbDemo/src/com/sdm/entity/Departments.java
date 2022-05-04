package com.sdm.entity;
public class Departments {
	private int departmentId;
	private String departmentName;
	private int managerId;
	private int loactionId;
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public int getLoactionId() {
		return loactionId;
	}
	public void setLoactionId(int loactionId) {
		this.loactionId = loactionId;
	}
}
