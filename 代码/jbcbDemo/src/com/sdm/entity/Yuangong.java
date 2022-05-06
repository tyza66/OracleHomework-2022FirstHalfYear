package com.sdm.entity;

public class Yuangong {
	private int yuangongID;
	private String yuangongName;
	private String yuangongZhiwei;
	private int jingliId;
	private String ruzhiRiqi;
	private int jibengongzi;
	private int jiangjin;
	private int bumenId;

	public int getYuangongID() {
		return yuangongID;
	}

	public void setYuangongID(int yuangongID) {
		this.yuangongID = yuangongID;
	}

	public String getYuangongName() {
		return yuangongName;
	}

	public void setYuangongName(String yuangongName) {
		this.yuangongName = yuangongName;
	}

	public String getYuangongZhiwei() {
		return yuangongZhiwei;
	}

	public void setYuangongZhiwei(String yuangongZhiwei) {
		this.yuangongZhiwei = yuangongZhiwei;
	}

	public int getJingliId() {
		return jingliId;
	}

	public void setJingliId(int jingliId) {
		this.jingliId = jingliId;
	}

	public String getRuzhiRiqi() {
		return ruzhiRiqi;
	}

	public void setRuzhiRiqi(String ruzhiRiqi) {
		this.ruzhiRiqi = ruzhiRiqi;
	}

	public int getJibengongzi() {
		return jibengongzi;
	}

	public void setJibengongzi(int jibengongzi) {
		this.jibengongzi = jibengongzi;
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
		return "Yuangong [yuangongID=" + yuangongID + ", yuangongName=" + yuangongName + ", yuangongZhiwei="
				+ yuangongZhiwei + ", jingliId=" + jingliId + ", ruzhiRiqi=" + ruzhiRiqi + ", jibengongzi="
				+ jibengongzi + ", jiangjin=" + jiangjin + ", bumenId=" + bumenId + "]";
	}

	public Yuangong(int yuangongID, String yuangongName, String yuangongZhiwei, int jingliId, String ruzhiRiqi,
			int jibengongzi, int jiangjin, int bumenId) {
		super();
		this.yuangongID = yuangongID;
		this.yuangongName = yuangongName;
		this.yuangongZhiwei = yuangongZhiwei;
		this.jingliId = jingliId;
		this.ruzhiRiqi = ruzhiRiqi;
		this.jibengongzi = jibengongzi;
		this.jiangjin = jiangjin;
		this.bumenId = bumenId;
	}
}
