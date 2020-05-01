package com.LECFLY.LF.model.vo;

import java.sql.Timestamp;

public class PayHistoryVO {
	int id;                   //                      "결제내역 번호	"
	int buyMbId;              //                      구매회원아이디
	int sellMbId;             //                      판매회원아이디
	int	goodsType;            //                      구매한종류                        (1:이용권 2:키트 3:펀딩...)
	int	goodsId;              //                      구매 품목 id       fk는 없지만 윗 컬럼으로 테이블 판별 후 해당 테이블에서 데이터를 가져와야됨
	int	payWay;               //                      결제수단                          (1:신용카드 2:카카오페이)
	int couponId;             //                      사용한 쿠폰
	int diliveryPrice;        // 0                	    배송비
	Timestamp dealDay;        // CURRENT_TIMESTAMP    결제날자
	int checkSameOrder;       //                      주문시 같이 했을경우 고유 id (주문주문 시 같이 구매한 내역일 경우 같은 번호로 표시번호)
	int deliveryStatus;       //                      배송상태                               0: 주문서 확인 1:상품준비중 2: 배송중 3: 배송완료
	String deliveryRequire;   //                      배송요청 사항
	Timestamp updatedAt;      // CURRENT_TIMESTAMP    상태업데이트 날짜                 최종 배송완료 시간으로 마지막 저장
	int PayHistorySum;        //                      총 결제 금액
	
	public PayHistoryVO() {
		super();
	}
	
	public PayHistoryVO(int id, int buyMbId, int sellMbId, int goodsType, int goodsId, int payWay, int couponId,
			int diliveryPrice, Timestamp dealDay, int checkSameOrder, int deliveryStatus, String deliveryRequire,
			Timestamp updatedAt, int payHistorySum) {
		super();
		this.id = id;
		this.buyMbId = buyMbId;
		this.sellMbId = sellMbId;
		this.goodsType = goodsType;
		this.goodsId = goodsId;
		this.payWay = payWay;
		this.couponId = couponId;
		this.diliveryPrice = diliveryPrice;
		this.dealDay = dealDay;
		this.checkSameOrder = checkSameOrder;
		this.deliveryStatus = deliveryStatus;
		this.deliveryRequire = deliveryRequire;
		this.updatedAt = updatedAt;
		this.PayHistorySum = payHistorySum;
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
	public int getSellMbId() {
		return sellMbId;
	}
	public void setSellMbId(int sellMbId) {
		this.sellMbId = sellMbId;
	}
	public int getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(int goodsType) {
		this.goodsType = goodsType;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
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
	public int getCheckSameOrder() {
		return checkSameOrder;
	}
	public void setCheckSameOrder(int checkSameOrder) {
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
		return PayHistorySum;
	}
	public void setPayHistorySum(int payHistorySum) {
		PayHistorySum = payHistorySum;
	}
	
	@Override
	public String toString() {
		return "PayHistoryVO [id=" + id + ", buyMbId=" + buyMbId + ", sellMbId=" + sellMbId + ", goodsType=" + goodsType
				+ ", goodsId=" + goodsId + ", payWay=" + payWay + ", couponId=" + couponId + ", diliveryPrice="
				+ diliveryPrice + ", dealDay=" + dealDay + ", checkSameOrder=" + checkSameOrder + ", deliveryStatus="
				+ deliveryStatus + ", deliveryRequire=" + deliveryRequire + ", updatedAt=" + updatedAt
				+ ", PayHistorySum=" + PayHistorySum + "]";
	}
	
	
}
