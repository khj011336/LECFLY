package com.LECFLY.LF.model.vo.cart;

import java.sql.Timestamp;

public class TicketListVO {
	/** 순서번호*/
	int id;
	/** 이용권명 UQ*/
	String name;
	/** 설명*/
	String explanation;
	/** 가격*/
	int price;
	/** 현재이용중인 회원 수*/
	int numOfMember;
	/** 누적 이용 회원 수*/
	int accumulatedNumber;
	/** 현재 이용중인 회원 List*/
	String members;
	
	/**
	 * 더미
	 */
	public TicketListVO() {
	}

	/**
	 * full constructor
	 * @param id
	 * @param name
	 * @param explanation
	 * @param price
	 * @param numOfMember
	 * @param accumulatedNumber
	 * @param members
	 */
	public TicketListVO(int id, String name, String explanation, int price, int numOfMember, int accumulatedNumber,
			String members) {
		super();
		this.id = id;
		this.name = name;
		this.explanation = explanation;
		this.price = price;
		this.numOfMember = numOfMember;
		this.accumulatedNumber = accumulatedNumber;
		this.members = members;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNumOfMember() {
		return numOfMember;
	}

	public void setNumOfMember(int numOfMember) {
		this.numOfMember = numOfMember;
	}

	public int getAccumulatedNumber() {
		return accumulatedNumber;
	}

	public void setAccumulatedNumber(int accumulatedNumber) {
		this.accumulatedNumber = accumulatedNumber;
	}

	public String getMembers() {
		return members;
	}

	public void setMembers(String members) {
		this.members = members;
	}

	@Override
	public String toString() {
		return "TicketListVO [id=" + id + ", name=" + name + ", explanation=" + explanation + ", price=" + price
				+ ", numOfMember=" + numOfMember + ", accumulatedNumber=" + accumulatedNumber + ", members=" + members
				+ "]";
	}
	
	
	
}
