package com.yqxd.entity;

public class QuarantineQuarantine {


	public QuarantineQuarantine() {
		super();
	}
	public String getQuarantine_id() {
		return quarantine_id;
	}
	public void setQuarantine_id(String quarantine_id) {
		this.quarantine_id = quarantine_id;
	}
	public String getQuarantine_name() {
		return quarantine_name;
	}
	public void setQuarantine_name(String quarantine_name) {
		this.quarantine_name = quarantine_name;
	}
	public String getQuarantine_sex() {
		return quarantine_sex;
	}
	public void setQuarantine_sex(String quarantine_sex) {
		this.quarantine_sex = quarantine_sex;
	}
	public int getQuarantine_age() {
		return quarantine_age;
	}
	public void setQuarantine_age(int quarantine_age) {
		this.quarantine_age = quarantine_age;
	}
	public String getQuarantine_number() {
		return quarantine_number;
	}
	public void setQuarantine_number(String quarantine_number) {
		this.quarantine_number = quarantine_number;
	}
	public String getQuarantine_symptom() {
		return quarantine_symptom;
	}
	public void setQuarantine_symptom(String quarantine_symptom) {
		this.quarantine_symptom = quarantine_symptom;
	}
	public String getQuarantine_checkDate() {
		return quarantine_checkDate;
	}
	public void setQuarantine_checkDate(String quarantine_checkDate) {
		this.quarantine_checkDate = quarantine_checkDate;
	}
	public String getQuarantine_quarantineDate() {
		return quarantine_quarantineDate;
	}
	public void setQuarantine_quarantineDate(String quarantine_quarantineDate) {
		this.quarantine_quarantineDate = quarantine_quarantineDate;
	}
	public String getQuarantine_travelPath() {
		return quarantine_travelPath;
	}
	public void setQuarantine_travelPath(String quarantine_travelPath) {
		this.quarantine_travelPath = quarantine_travelPath;
	}
	public String getQuarantine_password() {
		return quarantine_password;
	}
	public void setQuarantine_password(String quarantine_password) {
		this.quarantine_password = quarantine_password;
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public String getRoom_id() {
		return room_id;
	}
	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}
	public String getNucleicAcidResult() {
		return nucleicAcidResult;
	}
	public void setNucleicAcidResult(String nucleicAcidResult) {
		this.nucleicAcidResult = nucleicAcidResult;
	}
	public QuarantineQuarantine(String quarantine_id, String quarantine_name, String quarantine_sex, int quarantine_age,
			String quarantine_number, String quarantine_symptom, String quarantine_checkDate,
			String quarantine_quarantineDate, String quarantine_travelPath, String quarantine_password,
			int department_id, String room_id, String nucleicAcidResult) {
		super();
		this.quarantine_id = quarantine_id;
		this.quarantine_name = quarantine_name;
		this.quarantine_sex = quarantine_sex;
		this.quarantine_age = quarantine_age;
		this.quarantine_number = quarantine_number;
		this.quarantine_symptom = quarantine_symptom;
		this.quarantine_checkDate = quarantine_checkDate;
		this.quarantine_quarantineDate = quarantine_quarantineDate;
		this.quarantine_travelPath = quarantine_travelPath;
		this.quarantine_password = quarantine_password;
		this.department_id = department_id;
		this.room_id = room_id;
		this.nucleicAcidResult = nucleicAcidResult;
	}

	@Override
	public String toString() {
		return "QuarantineQuarantine [quarantine_id=" + quarantine_id + ", quarantine_name=" + quarantine_name
				+ ", quarantine_sex=" + quarantine_sex + ", quarantine_age=" + quarantine_age + ", quarantine_number="
				+ quarantine_number + ", quarantine_symptom=" + quarantine_symptom + ", quarantine_checkDate="
				+ quarantine_checkDate + ", quarantine_quarantineDate=" + quarantine_quarantineDate
				+ ", quarantine_travelPath=" + quarantine_travelPath + ", quarantine_password=" + quarantine_password
				+ ", department_id=" + department_id + ", room_id=" + room_id + ", nucleicAcidResult="
				+ nucleicAcidResult + "]";
	}

	private String quarantine_id;
	private String quarantine_name;
	private String quarantine_sex;
	private int quarantine_age;
	private String quarantine_number;
	private String quarantine_symptom;
	private String quarantine_checkDate;
	private String quarantine_quarantineDate;
	private String quarantine_travelPath;
	private String quarantine_password;
	private int department_id;
	private String room_id;
	private String nucleicAcidResult;


}
