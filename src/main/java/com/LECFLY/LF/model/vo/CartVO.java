package com.LECFLY.LF.model.vo;

import java.sql.Timestamp;


import org.springframework.stereotype.Component;
@Component("cartVO")
public class CartVO {
	/** 순서번호*/
	int id;
	/** 회원의 PK          		/fk/*/
	int mbId;
	/** 상품분류        				0 이용권 1 키트*/
	int categoryId;       	 			
	/** 이용권과 키트의 id			이용권과 키트에 따라 select로 가져올예정 여기서 해당 이미지 제목 가격을 뽑음  */
	int gdsId;
	/** 이용권 또는 키트의 수량 */
	int gdCnt;     	    		
	/** 추가한 날짜*/
	Timestamp createdAt;	
	
	/**
	 * 
	 */
	public CartVO() {

	}
	
	/**
	 * @param mbId
	 * @param categoryId
	 * @param gdsId
	 * @param gdCnt
	 */
	public CartVO(int mbId, int categoryId, int gdsId, int gdCnt) {
		this(0, mbId, categoryId, gdsId, gdCnt, null);
	}
	
	/**
	 * @param id
	 * @param mbId
	 * @param categoryId
	 * @param gdsId
	 * @param gdCnt
	 * @param createdAt
	 */

	public CartVO(int id, int mbId, int categoryId, int gdsId, int gdCnt, Timestamp createdAt) {
		super();
		this.id = id;
		this.mbId = mbId;
		this.categoryId = categoryId;
		this.gdsId = gdsId;
		this.gdCnt = gdCnt;
		this.createdAt = createdAt;
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

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getGdsId() {
		return gdsId;
	}

	public void setGdsId(int gdsId) {
		this.gdsId = gdsId;
	}

	public int getGdCnt() {
		return gdCnt;
	}

	public void setGdCnt(int gdCnt) {
		this.gdCnt = gdCnt;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "CartVO [id=" + id + ", mbId=" + mbId + ", categoryId=" + categoryId + ", gdsId=" + gdsId + ", gdCnt="
				+ gdCnt + ", createdAt=" + createdAt + "]";
	}
	
}                           
