package com.LECFLY.LF.model.vo.cart;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class TicketVO {

	public static final Map<Integer, String> STR_TICKET_NAME_MAP = new HashMap<Integer, String>(){
		{
			put(1, "1카테고리이용권");
			put(2, "3카테고리이용권");
			put(3, "무제한이용권");
		}
	};

	public static final Map<Integer, Integer> TICKET_PRICE_MAP = new HashMap<Integer, Integer>() {
		{
			put(1, 12900);
			put(2, 30900);
			put(3, 49900);
		}
	};

	/** 순서번호*/
	int id;
	/** 이용중인 회원    해당 데이터 이용중인 회원 판별 용도*/
	int mbId;
	/** 이용권 명칭    FK / TicketList_ID  (1: 1카테고리이용권  2: 3카테고리이용권  3:전체이용권)*/
	int name;
	/** 선택한 카테고리  (전체, 미술, 음악, 요리, 라이프스타일, 운동, 커리어, 여행)*/
	String category;
	/** 이용권 가격*/
	int price;
	/** 이용권 시작일 CURRENT_TIMESTAMP*/
	Timestamp startDay;
	/** 이용권 유효날자 CURRENT_TIMESTAMP*/
	Timestamp endDay;

	/**
	 * 더미
	 */
	public TicketVO() {
	}

	/**
	 * full constructor
	 * @param id
	 * @param mbId
	 * @param name
	 * @param category
	 * @param price
	 * @param startDay
	 * @param endDay
	 */
	public TicketVO(int id, int mbId, int name, String category, int price, Timestamp startDay, Timestamp endDay) {
		super();
		this.id = id;
		this.mbId = mbId;
		this.name = name;
		this.category = category;
		this.price = price;
		this.startDay = startDay;
		this.endDay = endDay;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMbId() {
		return mbId;
	}
	public void setMbId(int mbId) {
		this.mbId = mbId;
	}
	public int getName() {
		return name;
	}
	public void setName(int name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Timestamp getStartDay() {
		return startDay;
	}
	public void setStartDay(Timestamp startDay) {
		this.startDay = startDay;
	}
	public Timestamp getEndDay() {
		return endDay;
	}
	public void setEndDay(Timestamp endDay) {
		this.endDay = endDay;
	}

	@Override
	public String toString() {
		return "TicketVO [id=" + id + ", mbId=" + mbId + ", name=" + name + ", category=" + category + ", price="
				+ price + ", startDay=" + startDay + ", endDay=" + endDay + "]";
	}

}
