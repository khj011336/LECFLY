package com.LECFLY.LF.model.vo;

import java.sql.Timestamp;

public class TicketVO {
	int id;			//                     			순서번호
	int mbId;        //                     		이용중인 회원    해당 데이터 이용중인 회원 판별 용도
	int name;       //                     			이용권 명칭      (1: 1카테고리이용권  2: 3카테고리이용권  3:전체이용권)
	int category;    //                     		선택한 카테고리  (0:전체 1:미술 2:음악 3:요리 4:라이프스타일 5:운동 6:커리어 7:여행)
	int price;       //                     		이용권 가격
	Timestamp startDay;    //  CURRENT_TIMESTAMP  	이용권 시작일
	Timestamp endDay;      //  CURRENT_TIMESTAMP  	이용권 유효날자
	
	public TicketVO() {
	}
	
	public TicketVO(int id, int mbId, int name, int category, int price, Timestamp startDay, Timestamp endDay) {
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
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
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
