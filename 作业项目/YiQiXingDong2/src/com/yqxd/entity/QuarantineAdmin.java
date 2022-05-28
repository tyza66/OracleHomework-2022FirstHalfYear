package com.yqxd.entity;

public class QuarantineAdmin {
	int admin_id;
	String admin_name;
	String admin_sex;
	String admin_number;
	String admin_workDate;
	String admin_workCondition;
	String admin_password;
	int department_id;

	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public String getAdmin_sex() {
		return admin_sex;
	}

	public void setAdmin_sex(String admin_sex) {
		this.admin_sex = admin_sex;
	}

	public String getAdmin_number() {
		return admin_number;
	}

	public void setAdmin_number(String admin_number) {
		this.admin_number = admin_number;
	}

	public String getAdmin_workDate() {
		return admin_workDate;
	}

	public void setAdmin_workDate(String admin_workDate) {
		this.admin_workDate = admin_workDate;
	}

	public String getAdmin_workCondition() {
		return admin_workCondition;
	}

	public void setAdmin_workCondition(String admin_workCondition) {
		this.admin_workCondition = admin_workCondition;
	}

	public String getAdmin_password() {
		return admin_password;
	}

	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	@Override
	public String toString() {
		return "QuarantineAdmin [admin_id=" + admin_id + ", admin_name=" + admin_name + ", admin_sex=" + admin_sex
				+ ", admin_number=" + admin_number + ", admin_workDate=" + admin_workDate + ", admin_workCondition="
				+ admin_workCondition + ", admin_password=" + admin_password + ", department_id=" + department_id + "]";
	}

	public QuarantineAdmin() {
		super();
	}

	public QuarantineAdmin(int admin_id, String admin_name, String admin_sex, String admin_number,
			String admin_workDate, String admin_workCondition, String admin_password, int department_id) {
		super();
		this.admin_id = admin_id;
		this.admin_name = admin_name;
		this.admin_sex = admin_sex;
		this.admin_number = admin_number;
		this.admin_workDate = admin_workDate;
		this.admin_workCondition = admin_workCondition;
		this.admin_password = admin_password;
		this.department_id = department_id;
	}

}
