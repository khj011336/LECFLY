package com.LECFLY.LF.model.vo;

import java.sql.Timestamp;

public class CouponVO {
	
	public static final String[] STR_APPLY_TO = {"신규회원"};
	/** 쿠폰 번호 */
	private int id; 
	/** 쿠폰 코드 번호 */
	private String code; 
	/** 쿠폰이름 (ex: 신규회원쿠폰)*/
	private String couponName;
	/** 적용대상 (0: 신규회원 1:??회원)*/
	private int applyTo;
	/** 쿠폰 발행자 fk/(회원테이블참조*/
	private int makerId;         
	/** 쿠폰 보유회원 /fk/*/
	private int mbId;         
	/** 사용 여부       0:미사용 1:사용 */
	private int useCheck;   
	/** 쿠폰 종류       (1:키트 2:펀딩 3:기타 ~~)	3*/
	private int category;  
	/** 할인금액*/
	private int discount;   
	/** 쿠폰 생성 날자  (사용기한등에 이용)	CURRENT_TIMESTAMP*/
	private Timestamp createdDay; 
	/** 유효기간*/
	private Timestamp endDay;
	
	
	
	/** 더미 */
	public CouponVO() {}
	
	/**
	 * 중간생성자 최소 필요한거
	 * @param code
	 * @param couponName
	 * @param applyTo
	 * @param makerId
	 * @param mbId
	 * @param useCheck
	 * @param category
	 * @param discount
	 * @param endDay
	 */
	public CouponVO(String code, String couponName, int applyTo, 
			int makerId, int mbId, int useCheck, int category, 
				int discount, Timestamp endDay) {
		this(0, code, couponName, applyTo, makerId, 
				mbId, useCheck, category, discount, null, endDay);
	}
	
	
	/**
	 * full constructor
	 * @param id
	 * @param code
	 * @param couponName
	 * @param applyTo
	 * @param makerId
	 * @param mbId
	 * @param useCheck
	 * @param category
	 * @param discount
	 * @param createdDay
	 * @param endDay
	 */
	public CouponVO(int id, String code, String couponName, int applyTo, int makerId, int mbId, int useCheck,
			int category, int discount, Timestamp createdDay, Timestamp endDay) {
		super();
		this.id = id;
		this.code = code;
		this.couponName = couponName;
		this.applyTo = applyTo;
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

	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}

	public int getApplyTo() {
		return applyTo;
	}

	public void setApplyTo(int applyTo) {
		this.applyTo = applyTo;
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
		return "CouponVO [id=" + id + ", code=" + code + ", couponName=" + couponName + ", applyTo=" + applyTo
				+ ", makerId=" + makerId + ", mbId=" + mbId + ", useCheck=" + useCheck + ", category=" + category
				+ ", discount=" + discount + ", createdDay=" + createdDay + ", endDay=" + endDay + "]";
	}

	
	
}
