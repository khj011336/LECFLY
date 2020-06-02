package com.LECFLY.LF.model.vo.cart;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;
@Component("cartVO")
public class CartVO {

	public static final String[] STR_CATEGORY_ID = {"회원권", "키트"};
	public static final int CATEGORY_ID_TICKET = 0;
	public static final int CATEGORY_ID_KIT = 1;

	public static final String[] STR_CATEGORY_STATE = {"결제대기", "결제완료", "결제실패", "결제오류"};
	public static final int CATEGORY_STATE_WAIT = 0;
	public static final int CATEGORY_STATE_SUCCEED = 1;
	public static final int CATEGORY_STATE_FAILED = 2;
	public static final int CATEGORY_STATE_ERROR = 3;

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
	int gdsCnt;    
	/** 주문시 같이 했을경우 고유 id (주문주문 시 같이 구매한 내역일 경우 같은 번호로 표시번호)*/
	String checkSameOrder;
	/** 추가한 날짜*/
	Timestamp createdAt;
	/** 주문/결제 기록용 상태 (1.결제 전 2.성공 3.실패 4.기타 오류)*/
	int state;


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
	public CartVO(int mbId, int categoryId, int gdsId, String gdsName, int gdsPrice, String checkSameOrder, int state) {
		this(0, mbId, categoryId, gdsId, gdsName, gdsPrice, 1, checkSameOrder, null, state);
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
	public CartVO(int id, int mbId, int categoryId, int gdsId, String gdsName, int gdsPrice, int gdsCnt,
			String checkSameOrder, Timestamp createdAt, int state) {
		super();
		this.id = id;
		this.mbId = mbId;
		this.categoryId = categoryId;
		this.gdsId = gdsId;
		this.gdsName = gdsName;
		this.gdsPrice = gdsPrice;
		this.gdsCnt = gdsCnt;
		this.checkSameOrder = checkSameOrder;
		this.createdAt = createdAt;
		this.state = state;
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
	public String getGdsName() {
		return gdsName;
	}
	public void setGdsName(String gdsName) {
		this.gdsName = gdsName;
	}
	public int getGdsPrice() {
		return gdsPrice;
	}
	public void setGdsPrice(int gdsPrice) {
		this.gdsPrice = gdsPrice;
	}
	public int getGdsCnt() {
		return gdsCnt;
	}
	public void setGdsCnt(int gdsCnt) {
		this.gdsCnt = gdsCnt;
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
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public static String[] getStrCategoryId() {
		return STR_CATEGORY_ID;
	}
	public static int getCategoryIdTicket() {
		return CATEGORY_ID_TICKET;
	}
	public static int getCategoryIdKit() {
		return CATEGORY_ID_KIT;
	}
	
	@Override
	public String toString() {
		return "CartVO [id=" + id + ", mbId=" + mbId + ", categoryId=" + categoryId + ", gdsId=" + gdsId + ", gdsName="
				+ gdsName + ", gdsPrice=" + gdsPrice + ", gdsCnt=" + gdsCnt + ", checkSameOrder=" + checkSameOrder
				+ ", createdAt=" + createdAt + ", state=" + state + "]";
	}
}