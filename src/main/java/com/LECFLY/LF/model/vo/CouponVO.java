package com.LECFLY.LF.model.vo;

import java.sql.Timestamp;

public class CouponVO {
	/** 쿠폰 번호 */
	int id; 
	/** 쿠폰 코드 번호 */
	String code; 
	/** 쿠폰 발행자 fk/(회원테이블참조*/
	int makerId;         
	/** 쿠폰 보유회원 /fk/*/
	int mbId;         
	/** 사용 여부       0:미사용 1:사용 */
	int useCheck;   
	/** 쿠폰 종류       (1:키트 2:펀딩 3:기타 ~~)	3*/
	int category;  
	/** 할인금액*/
	int discount;   
	/** 쿠폰 생성 날자  (사용기한등에 이용)	CURRENT_TIMESTAMP*/
	Timestamp createdDay; 
	/** 유효기간*/
	Timestamp endDay; 
	
	/**
	 * 더미
	 */
	public CouponVO() {
		
	}
	
	/**
	 * full constructor 
	 * @param id
	 * @param code
	 * @param makerId
	 * @param mbId
	 * @param useCheck
	 * @param category
	 * @param discount
	 * @param createdDay
	 * @param endDay
	 */
	public CouponVO(int id, String code, int makerId, int mbId, int useCheck, int category, int discount,
			Timestamp createdDay, Timestamp endDay) {
		super();
		this.id = id;
		this.code = code;
		this.makerId = makerId;
		this.mbId = mbId;
		this.useCheck = useCheck;
		this.category = category;
		this.discount = discount;
		this.createdDay = createdDay;
		this.endDay = endDay;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getMakerId() {
		return makerId;
	}
	public void setMakerId(int makerId) {
		this.makerId = makerId;
	}
	public int getMbId() {
		return mbId;
	}
	public void setMbId(int mbId) {
		this.mbId = mbId;
	}
	public int getUseCheck() {
		return useCheck;
	}
	public void setUseCheck(int useCheck) {
		this.useCheck = useCheck;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public Timestamp getCreatedDay() {
		return createdDay;
	}
	public void setCreatedDay(Timestamp createdDay) {
		this.createdDay = createdDay;
	}
	public Timestamp getEndDay() {
		return endDay;
	}
	public void setEndDay(Timestamp endDay) {
		this.endDay = endDay;
	}
	
	@Override
	public String toString() {
		return "CouponVO [id=" + id + ", code=" + code + ", makerId=" + makerId + ", mbId=" + mbId + ", useCheck="
				+ useCheck + ", category=" + category + ", discount=" + discount + ", createdDay=" + createdDay
				+ ", endDay=" + endDay + "]";
	}
	
	
	
}
