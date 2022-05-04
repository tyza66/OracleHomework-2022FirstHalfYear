package com.chinasoft.wxx.entity;
/**
 * departments实体类 -- 对数据进行封装
 * 封装：隐藏事务实现细节 公开安全的使用方法
 * 
 * 封装良好的实体类组成：
 * 私有属性，
 * 公开的get/set方法
 * 带参/无参 构造器
 * toString 方法
 * 
 * @author xiaoxi
 *
 */
public class Departments {
//	私有属性
	private int departmentId;
	private String departmentName;
	private int managerId;
	private int locationId;
//	提供公开的 get/set方法来实现对 属性的获取 和设置
//	Source ---> Generate Getters and Setters ----> select all ---> ok
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
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	//提供有参构造器【创建对象 并给属性直接赋值】，
//	Source ---> Generate Constructor using fields ----> select all ---> ok
	public Departments(int departmentId, String departmentName, int managerId, int locationId) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.managerId = managerId;
		this.locationId = locationId;
	}
//	无参构造器【创建空对象】
//	Source ---> Generate Constructor using fields ----> deselect all ---> ok
	public Departments() {
		super();
	}
//	重写父类Object的toString方法  以实现 可以直接输出对象的具体属性值
//	Source ---> Generate toString  ---> ok
	@Override
	public String toString() {
		return "Departments [departmentId=" + departmentId + ", departmentName=" + departmentName + ", managerId="
				+ managerId + ", locationId=" + locationId + "]\n";
	}
	
	
	
	
}
