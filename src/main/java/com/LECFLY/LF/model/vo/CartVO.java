package com.LECFLY.LF.model.vo;

import java.sql.Timestamp;

public class CartVO {
	private int id;							// 장바구니번호		int(10)
	private int memberId;					// 회원 번호			int(4)
	private int goodsId;					// 상품 번호			int(4)
	private int count;						// 상품개수			int(4)
	private Timestamp createdAt;			// 생성일자			CURRENTTIME_STAMP
	
	public CartVO() {}
	public CartVO(int memberId, int goodsId, int count) {
		this(0, memberId, goodsId, count, null);
	}
	public CartVO(int id, int memberId, int goodsId, int count, Timestamp createdAt) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.goodsId = goodsId;
		this.count = count;
		this.createdAt = createdAt;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	
	@Override
	public String toString() {
		return "CartVO [id=" + id + ", memberId=" + memberId + ", goodsId=" + goodsId + ", count=" + count
				+ ", createdAt=" + createdAt + "]";
	}
	
}                           
