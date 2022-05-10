package com.sdm.dao;
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
	public Departments(int departmentId, String departmentName, int managerId, int loactionId) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.managerId = managerId;
		this.loactionId = loactionId;
	}
	public Departments() {
		super();
	}
	@Override
	public String toString() {
		return "Departments [departmentId=" + departmentId + ", departmentName=" + departmentName + ", managerId="
				+ managerId + ", loactionId=" + loactionId + "]\n";
	}
	
}
