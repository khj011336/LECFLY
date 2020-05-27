package com.LECFLY.LF.model.vo.cart;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;
@Component("cartVO")
public class CartVO {

	public static final String[] STR_CATEGORY_ID = {"회원권", "키트"};
	public static final int CATEGORY_ID_TICKET = 0;
	public static final int CATEGORY_ID_KIT = 1;

	public static final String[] STR_CATEGORY_NAME = {"1카테고리 회원권", "3카테고리 회원권", "무제한 회원권"};

	/** 순서번호*/
	int id;
	/** 회원의 PK          		/fk/*/
	int mbId;
	/** 상품분류        				0 이용권 1 키트*/
	int categoryId;
	/** 이용권과 키트의 id			이용권과 키트에 따라 select로 가져올예정 여기서 해당 이미지 제목 가격을 뽑음  */
	int gdsId;
	/** 상품의 이름				*/
	String gdsName;
	/** 상품의 가격				*/
	int gdsPrice;
	/** 이용권 또는 키트의 수량 */
	int gdCnt;
	/** 주문시 같이 했을경우 고유 id (주문주문 시 같이 구매한 내역일 경우 같은 번호로 표시번호)*/
	String checkSameOrder;
	/** 추가한 날짜*/
	Timestamp createdAt;

	/**
	 *
	 */
	public CartVO() {}
	/**
	 * @param mbId
	 * @param categoryId
	 * @param gdsId
	 * @param gdCnt
	 * @param checkSameOrder
	 */
	public CartVO(int mbId, int categoryId, int gdsId, int gdCnt, String checkSameOrder) {
		this(0, mbId, categoryId, gdsId, gdCnt, checkSameOrder, null);
	}
	/**
	 * @param id
	 * @param mbId
	 * @param categoryId
	 * @param gdsId
	 * @param gdCnt
	 * @param checkSameOrder
	 * @param createdAt
	 */
	public CartVO(int id, int mbId, int categoryId, int gdsId, int gdCnt, String checkSameOrder, Timestamp createdAt) {
		super();
		this.id = id;
		this.mbId = mbId;
		this.categoryId = categoryId;
		this.gdsId = gdsId;
		this.gdCnt = gdCnt;
		this.checkSameOrder = checkSameOrder;
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
	public String getCheckSameOrder() {
		return checkSameOrder;
	}
	public void setCheckSameOrder(String checkSameOrder) {
		this.checkSameOrder = checkSameOrder;
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
				+ gdCnt + ", checkSameOrder=" + checkSameOrder + ", createdAt=" + createdAt + "]";
	}

}
