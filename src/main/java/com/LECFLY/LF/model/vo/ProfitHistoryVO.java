package com.LECFLY.LF.model.vo;

import java.sql.Timestamp;

public class ProfitHistoryVO {
	
	public static final int DEF_ID = 0;
	public static final int EVENT_LECTURE = 0;
	public static final int EVENT_KIT = 1;
	public static final int EVENT_FUNDING = 2;
	public static final int EVENT_ETC = 3;
	public static final int DEF_SAVE_MONEY = 0;
	public static final int DEF_GET_MONEY = 0;
	
	public static final String[] EVENT_STR = {"강의", "키트", "펀딩", "기타"};
	
	int id;           //        				번호
	int uploaderId;   //       					업로더 회원번호		<<FK>>
	int saveMoney;    //        				수익금
	int getMoney;     //        				출금금액
	int category;     //  3    					이벤트 분류           (0: 강의, 1: 키트,2: 펀딩,3: 기타)
	String detail;    //        				이벤트 내용
	Timestamp day;    //  CURRENT_TIMESTAMP		이벤트 생성날자
	
	public ProfitHistoryVO() {}
	
	public ProfitHistoryVO(int uploaderId) {
		this.id = DEF_ID;
		this.uploaderId = uploaderId;
		this.saveMoney = DEF_SAVE_MONEY;
		this.getMoney = DEF_GET_MONEY;
		this.category = EVENT_ETC;
		this.detail = null;
		this.day = null;
	}
	
	public ProfitHistoryVO(int id, int uploaderId, int saveMoney,
			int getMoney, int category, String detail, Timestamp day) {
		this.id = id;
		this.uploaderId = uploaderId;
		this.saveMoney = saveMoney;
		this.getMoney = getMoney;
		this.category = category;
		this.detail = detail;
		this.day = day;
	}

	// GETTER
	public static int getDefId() {
		return DEF_ID;
	}

	public static int getEventLecture() {
		return EVENT_LECTURE;
	}

	public static int getEventKit() {
		return EVENT_KIT;
	}

	public static int getEventFunding() {
		return EVENT_FUNDING;
	}

	public static int getEventEtc() {
		return EVENT_ETC;
	}

	public static int getDefSaveMoney() {
		return DEF_SAVE_MONEY;
	}

	public static int getDefGetMoney() {
		return DEF_GET_MONEY;
	}

	public static String[] getEventStr() {
		return EVENT_STR;
	}

	public int getId() {
		return id;
	}

	public int getUploaderId() {
		return uploaderId;
	}

	public int getSaveMoney() {
		return saveMoney;
	}

	public int getGetMoney() {
		return getMoney;
	}

	public int getCategory() {
		return category;
	}

	public String getDetail() {
		return detail;
	}

	public Timestamp getDay() {
		return day;
	}
		
	// SETTER
	public void setId(int id) {
		this.id = id;
	}

	public void setUploaderId(int uploaderId) {
		this.uploaderId = uploaderId;
	}

	public void setSaveMoney(int saveMoney) {
		this.saveMoney = saveMoney;
	}

	public void setGetMoney(int getMoney) {
		this.getMoney = getMoney;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public void setDay(Timestamp day) {
		this.day = day;
	}

	@Override
	public String toString() {
		return "ProfitHistoryVO [id=" + id + ", uploaderId=" + uploaderId + ", saveMoney=" + saveMoney + ", getMoney="
				+ getMoney + ", category=" + category + ", detail=" + detail + ", day=" + day + "]";
	}
	
	
	
	
	
}
