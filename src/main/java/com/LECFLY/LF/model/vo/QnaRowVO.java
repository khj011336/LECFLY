package com.LECFLY.LF.model.vo;

import java.sql.Timestamp;

public class QnaRowVO {
	private int vId;
	private String vTitle;
	private int vType;
	private int vRc;
	private String vUser;
	private Timestamp vDay;
	private int vQcCnt;
	
	public QnaRowVO() {}
	
	public QnaRowVO(int vId, String vTitle, int vType, int vRc, String vUser, Timestamp vDay, int vQcCnt) {
		super();
		this.vId = vId;
		this.vTitle = vTitle;
		this.vType = vType;
		this.vRc = vRc;
		this.vUser = vUser;
		this.vDay = vDay;
		this.vQcCnt = vQcCnt;
	}

	public int getvId() {
		return vId;
	}

	public void setvId(int vId) {
		this.vId = vId;
	}

	public String getvTitle() {
		return vTitle;
	}

	public void setvTitle(String vTitle) {
		this.vTitle = vTitle;
	}

	public int getvType() {
		return vType;
	}

	public void setvType(int vType) {
		this.vType = vType;
	}

	public int getvRc() {
		return vRc;
	}

	public void setvRc(int vRc) {
		this.vRc = vRc;
	}

	public String getvUser() {
		return vUser;
	}

	public void setvUser(String vUser) {
		this.vUser = vUser;
	}

	public Timestamp getvDay() {
		return vDay;
	}

	public void setvDay(Timestamp vDay) {
		this.vDay = vDay;
	}

	public int getvQcCnt() {
		return vQcCnt;
	}

	public void setvQcCnt(int vQcCnt) {
		this.vQcCnt = vQcCnt;
	}

	@Override
	public String toString() {
		return "QnaRowVO [vId=" + vId + ", vTitle=" + vTitle + ", vType=" + vType + ", vRc=" + vRc + ", vUser=" + vUser
				+ ", vDay=" + vDay + ", vQcCnt=" + vQcCnt + "]";
	}
	
	
}
