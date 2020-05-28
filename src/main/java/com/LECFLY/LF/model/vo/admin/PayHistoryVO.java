package com.LECFLY.LF.model.vo.admin;

import java.sql.Timestamp;

/**
 * @author USER
 *
 */
public class PayHistoryVO {
	/** "결제내역 번호	" */
	private int id;                   
	/** 구매회원아이디*/
	private int buyMbId;             
	/**  판매회원아이디*/
	private String sellMbId;            
	/** 구매한종류                        (1:이용권 2:키트 3:펀딩...)*/
	private int	goodsType;          
	/** 구매 품목 id       fk는 없지만 윗 컬럼으로 테이블 판별 후 해당 테이블에서 데이터를 가져와야됨*/
	private String goodsId;          
	/** 결제수단                          (1:신용카드 2:카카오페이)*/
	private int	payWay;             
	/** 사용한 쿠폰*/
	private int couponId;
	/** 결제한 총 상품 갯수*/
	private int buyProductCount;
	/** 배송비*/
	private int diliveryPrice;   
	/** 결제날자 CURRENT_TIMESTAMP*/
	private Timestamp dealDay;
	/** 주문시 같이 했을경우 고유 id (주문주문 시 같이 구매한 내역일 경우 같은 번호로 표시번호)*/
	private String checkSameOrder;
	/** 배송상태                               0: 주문서 확인 1:상품준비중 2: 배송중 3: 배송완료*/
	private int deliveryStatus;
	/** 배송요청 사항*/
	private String deliveryRequire;
	/** 상태업데이트 날짜                 최종 배송완료 시간으로 마지막 저장	CURRENT_TIMESTAMP*/
	private Timestamp updatedAt;
	/** 총 결제 금액*/
	private int payHistorySum;
	
	/**
	 * 더미 
	 */
	public PayHistoryVO() {}


	/**
	 * 중간생성자
	 * @param buyMbId
	 * @param sellMbId
	 * @param goodsType
	 * @param goodsId
	 * @param payWay
	 * @param couponId
	 * @param buyProductCount
	 * @param diliveryPrice
	 * @param checkSameOrder
	 * @param deliveryStatus
	 * @param deliveryRequire
	 * @param updatedAt
	 * @param payHistorySum
	 */
	public PayHistoryVO(int buyMbId, String sellMbId, int goodsType, 
			String goodsId, int payWay, int couponId, int buyProductCount, 
			int diliveryPrice, String checkSameOrder, int deliveryStatus, 
			String deliveryRequire, Timestamp updatedAt, int payHistorySum) {
		this(0, buyMbId, sellMbId, goodsType, goodsId, 
				payWay, couponId, buyProductCount, diliveryPrice, 
				null, checkSameOrder, deliveryStatus, 
				deliveryRequire, updatedAt, payHistorySum);
	}
	
	/**
	 * full constructor 
	 * @param id
	 * @param buyMbId
	 * @param sellMbId
	 * @param goodsType
	 * @param goodsId
	 * @param payWay
	 * @param couponId
	 * @param buyProductCount
	 * @param diliveryPrice
	 * @param dealDay
	 * @param checkSameOrder
	 * @param deliveryStatus
	 * @param deliveryRequire
	 * @param updatedAt
	 * @param payHistorySum
	 */
	public PayHistoryVO(int id, int buyMbId, String sellMbId, int goodsType, String goodsId, int payWay, int couponId,
			int buyProductCount, int diliveryPrice, Timestamp dealDay, String checkSameOrder, int deliveryStatus,
			String deliveryRequire, Timestamp updatedAt, int payHistorySum) {
		super();
		this.id = id;
		this.buyMbId = buyMbId;
		this.sellMbId = sellMbId;
		this.goodsType = goodsType;
		this.goodsId = goodsId;
		this.payWay = payWay;
		this.couponId = couponId;
		this.buyProductCount = buyProductCount;
		this.diliveryPrice = diliveryPrice;
		this.dealDay = dealDay;
		this.checkSameOrder = checkSameOrder;
		this.deliveryStatus = deliveryStatus;
		this.deliveryRequire = deliveryRequire;
		this.updatedAt = updatedAt;
		this.payHistorySum = payHistorySum;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getBuyMbId() {
		return buyMbId;
	}


	public void setBuyMbId(int buyMbId) {
		this.buyMbId = buyMbId;
	}


	public String getSellMbId() {
		return sellMbId;
	}


	public void setSellMbId(String sellMbId) {
		this.sellMbId = sellMbId;
	}


	public int getGoodsType() {
		return goodsType;
	}


	public void setGoodsType(int goodsType) {
		this.goodsType = goodsType;
	}


	public String getGoodsId() {
		return goodsId;
	}


	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}


	public int getPayWay() {
		return payWay;
	}


	public void setPayWay(int payWay) {
		this.payWay = payWay;
	}


	public int getCouponId() {
		return couponId;
	}


	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}


	public int getBuyProductCount() {
		return buyProductCount;
	}


	public void setBuyProductCount(int buyProductCount) {
		this.buyProductCount = buyProductCount;
	}


	public int getDiliveryPrice() {
		return diliveryPrice;
	}


	public void setDiliveryPrice(int diliveryPrice) {
		this.diliveryPrice = diliveryPrice;
	}


	public Timestamp getDealDay() {
		return dealDay;
	}


	public void setDealDay(Timestamp dealDay) {
		this.dealDay = dealDay;
	}


	public String getCheckSameOrder() {
		return checkSameOrder;
	}


	public void setCheckSameOrder(String checkSameOrder) {
		this.checkSameOrder = checkSameOrder;
	}


	public int getDeliveryStatus() {
		return deliveryStatus;
	}


	public void setDeliveryStatus(int deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}


	public String getDeliveryRequire() {
		return deliveryRequire;
	}


	public void setDeliveryRequire(String deliveryRequire) {
		this.deliveryRequire = deliveryRequire;
	}


	public Timestamp getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}


	public int getPayHistorySum() {
		return payHistorySum;
	}


	public void setPayHistorySum(int payHistorySum) {
		this.payHistorySum = payHistorySum;
	}


	@Override
	public String toString() {
		return "PayHistoryVO [id=" + id + ", buyMbId=" + buyMbId + ", sellMbId=" + sellMbId + ", goodsType=" + goodsType
				+ ", goodsId=" + goodsId + ", payWay=" + payWay + ", couponId=" + couponId + ", buyProductCount="
				+ buyProductCount + ", diliveryPrice=" + diliveryPrice + ", dealDay=" + dealDay + ", checkSameOrder="
				+ checkSameOrder + ", deliveryStatus=" + deliveryStatus + ", deliveryRequire=" + deliveryRequire
				+ ", updatedAt=" + updatedAt + ", payHistorySum=" + payHistorySum + "]";
	}
	
	
}
