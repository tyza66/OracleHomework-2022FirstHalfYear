package com.sdm.entity;

/*
 * 私有属性，公开getset方法，有参/无参构造，重写toString方法
 */
public class Bumen {
	private int bumenId;
	private String bumenName;
	private String bumenDiZhi;

	public int getBumenId() {
		return bumenId;
	}

	public void setBumenId(int bumenId) {
		this.bumenId = bumenId;
	}

	public String getBumenName() {
		return bumenName;
	}

	public void setBumenName(String bumenName) {
		this.bumenName = bumenName;
	}

	public String getBumenDiZhi() {
		return bumenDiZhi;
	}

	public void setBumenDiZhi(String bumenDiZhi) {
		this.bumenDiZhi = bumenDiZhi;
	}

	public Bumen(int bumenId, String bumenName, String bumenDiZhi) {
		super();
		this.bumenId = bumenId;
		this.bumenName = bumenName;
		this.bumenDiZhi = bumenDiZhi;
	}

	public Bumen() {
		super();
	}

	@Override
	public String toString() {
		return "Bumen [bumenId=" + bumenId + ", bumenName=" + bumenName + ", bumenDiZhi=" + bumenDiZhi + "]\n";
	}

}
