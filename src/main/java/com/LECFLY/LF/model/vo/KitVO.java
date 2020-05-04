package com.LECFLY.LF.model.vo;

public class KitVO {
	/** 클래스 판매킷트 ID */
	int kitId;        
	/** 클래스 판매킷트 소유ID*/
	int kitFId;      	
	/** 클래스 판매킷트 소속클래스ID*/
	int kitCFId;      	
	/** 클래스 판매킷트 카테고리*/
	int kitCate;     	
	/** 클래스 판매킷트 상품속성*/
	int kitAttr;      	
	/** 클래스 판매킷트 상품명*/
	String kitTilte;     
	/** 클래스 판매킷트 판매가*/
	int kitPDPrice;   	
	/** 클래스 판매킷트 재고수량*/
	int kitCount;     	
	/** 클래스 판매킷트 이미지경로*/
	String kitImgs;      
	/** 클래스 판매킷트 택배사*/
	String kitDeliver;  
	/** 클래스 판매킷트 배송비*/
	int kitDPrice;    	
	/** 클래스 판매킷트 발송지*/
	String kitFromTo;    
	/** 클래스 판매킷트 배송안내문구*/
	String kitDIF; 
	/** 클래스 판매킷트 상세정보 내용*/
	String kitIF;
	
	/**
	 * 더미
	 */
	public KitVO() {
	}
	
	/**
	 * full constructor 
	 * @param kitId
	 * @param kitFId
	 * @param kitCFId
	 * @param kitCate
	 * @param kitAttr
	 * @param kitTilte
	 * @param kitPDPrice
	 * @param kitCount
	 * @param kitImgs
	 * @param kitDeliver
	 * @param kitDPrice
	 * @param kitFromTo
	 * @param kitDIF
	 * @param kitIF
	 */
	public KitVO(int kitId, int kitFId, int kitCFId, int kitCate, int kitAttr, String kitTilte, int kitPDPrice,
			int kitCount, String kitImgs, String kitDeliver, int kitDPrice, String kitFromTo, String kitDIF,
			String kitIF) {
		super();
		this.kitId = kitId;
		this.kitFId = kitFId;
		this.kitCFId = kitCFId;
		this.kitCate = kitCate;
		this.kitAttr = kitAttr;
		this.kitTilte = kitTilte;
		this.kitPDPrice = kitPDPrice;
		this.kitCount = kitCount;
		this.kitImgs = kitImgs;
		this.kitDeliver = kitDeliver;
		this.kitDPrice = kitDPrice;
		this.kitFromTo = kitFromTo;
		this.kitDIF = kitDIF;
		this.kitIF = kitIF;
	}

	public int getKitId() {
		return kitId;
	}
	public void setKitId(int kitId) {
		this.kitId = kitId;
	}
	public int getKitFId() {
		return kitFId;
	}
	public void setKitFId(int kitFId) {
		this.kitFId = kitFId;
	}
	public int getKitCFId() {
		return kitCFId;
	}
	public void setKitCFId(int kitCFId) {
		this.kitCFId = kitCFId;
	}
	public int getKitCate() {
		return kitCate;
	}
	public void setKitCate(int kitCate) {
		this.kitCate = kitCate;
	}
	public int getKitAttr() {
		return kitAttr;
	}
	public void setKitAttr(int kitAttr) {
		this.kitAttr = kitAttr;
	}
	public String getKitTilte() {
		return kitTilte;
	}
	public void setKitTilte(String kitTilte) {
		this.kitTilte = kitTilte;
	}
	public int getKitPDPrice() {
		return kitPDPrice;
	}
	public void setKitPDPrice(int kitPDPrice) {
		this.kitPDPrice = kitPDPrice;
	}
	public int getKitCount() {
		return kitCount;
	}
	public void setKitCount(int kitCount) {
		this.kitCount = kitCount;
	}
	public String getKitImgs() {
		return kitImgs;
	}
	public void setKitImgs(String kitImgs) {
		this.kitImgs = kitImgs;
	}
	public String getKitDeliver() {
		return kitDeliver;
	}
	public void setKitDeliver(String kitDeliver) {
		this.kitDeliver = kitDeliver;
	}
	public int getKitDPrice() {
		return kitDPrice;
	}
	public void setKitDPrice(int kitDPrice) {
		this.kitDPrice = kitDPrice;
	}
	public String getKitFromTo() {
		return kitFromTo;
	}
	public void setKitFromTo(String kitFromTo) {
		this.kitFromTo = kitFromTo;
	}
	public String getKitDIF() {
		return kitDIF;
	}
	public void setKitDIF(String kitDIF) {
		this.kitDIF = kitDIF;
	}
	public String getKitIF() {
		return kitIF;
	}
	public void setKitIF(String kitIF) {
		this.kitIF = kitIF;
	}

	@Override
	public String toString() {
		return "KitVO [kitId=" + kitId + ", kitFId=" + kitFId + ", kitCFId=" + kitCFId + ", kitCate=" + kitCate
				+ ", kitAttr=" + kitAttr + ", kitTilte=" + kitTilte + ", kitPDPrice=" + kitPDPrice + ", kitCount="
				+ kitCount + ", kitImgs=" + kitImgs + ", kitDeliver=" + kitDeliver + ", kitDPrice=" + kitDPrice
				+ ", kitFromTo=" + kitFromTo + ", kitDIF=" + kitDIF + ", kitIF=" + kitIF + "]";
	}
	
}                       
