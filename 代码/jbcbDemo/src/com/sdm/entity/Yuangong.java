package com.sdm.entity;

public class Yuangong {
	private int YuangongID;
	private String YuangongName;
	private String YuangongZhiwei;
	private int jingliId;
	private String RuzhiRiqi;
	private int Jibengongzi;
	private int jiangjin;
	private int bumenId;
	public int getYuangongID() {
		return YuangongID;
	}
	public void setYuangongID(int yuangongID) {
		YuangongID = yuangongID;
	}
	public String getYuangongName() {
		return YuangongName;
	}
	public void setYuangongName(String yuangongName) {
		YuangongName = yuangongName;
	}
	public String getYuangongZhiwei() {
		return YuangongZhiwei;
	}
	public void setYuangongZhiwei(String yuangongZhiwei) {
		YuangongZhiwei = yuangongZhiwei;
	}
	public int getJingliId() {
		return jingliId;
	}
	public void setJingliId(int jingliId) {
		this.jingliId = jingliId;
	}
	public String getRuzhiRiqi() {
		return RuzhiRiqi;
	}
	public void setRuzhiRiqi(String ruzhiRiqi) {
		RuzhiRiqi = ruzhiRiqi;
	}
	public int getJibengongzi() {
		return Jibengongzi;
	}
	public void setJibengongzi(int jibengongzi) {
		Jibengongzi = jibengongzi;
	}
	public int getJiangjin() {
		return jiangjin;
	}
	public void setJiangjin(int jiangjin) {
		this.jiangjin = jiangjin;
	}
	public int getBumenId() {
		return bumenId;
	}
	public void setBumenId(int bumenId) {
		this.bumenId = bumenId;
	}
	@Override
	public String toString() {
		return "Yuangong [YuangongID=" + YuangongID + ", YuangongName=" + YuangongName + ", YuangongZhiwei="
				+ YuangongZhiwei + ", jingliId=" + jingliId + ", RuzhiRiqi=" + RuzhiRiqi + ", Jibengongzi="
				+ Jibengongzi + ", jiangjin=" + jiangjin + ", bumenId=" + bumenId + "]";
	}
	public Yuangong(int yuangongID, String yuangongName, String yuangongZhiwei, int jingliId, String ruzhiRiqi,
			int jibengongzi, int jiangjin, int bumenId) {
		super();
		YuangongID = yuangongID;
		YuangongName = yuangongName;
		YuangongZhiwei = yuangongZhiwei;
		this.jingliId = jingliId;
		RuzhiRiqi = ruzhiRiqi;
		Jibengongzi = jibengongzi;
		this.jiangjin = jiangjin;
		this.bumenId = bumenId;
	}
	
}
