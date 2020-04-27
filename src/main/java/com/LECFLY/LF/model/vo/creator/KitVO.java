package com.LECFLY.LF.model.vo.creator;

public class KitVO {
private int id ;		//PK AI
private int fId;		//FK
private int CFId;		//FK
private int category;   // 상품 해당 카테고리
private int attribute;	// 상퓸속성
private String title;	// 상품이름
private int price;		// 상품가격
private int remain;
private String deliver;
private int deliveryPrice;
private String fromTo;
private String info;
private String DetailInfo;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getfId() {
	return fId;
}
public void setfId(int fId) {
	this.fId = fId;
}
public int getCFId() {
	return CFId;
}
public void setCFId(int cFId) {
	CFId = cFId;
}
public int getCategory() {
	return category;
}
public void setCategory(int category) {
	this.category = category;
}
public int getAttribute() {
	return attribute;
}
public void setAttribute(int attribute) {
	this.attribute = attribute;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getRemain() {
	return remain;
}
public void setRemain(int remain) {
	this.remain = remain;
}
public String getDeliver() {
	return deliver;
}
public void setDeliver(String deliver) {
	this.deliver = deliver;
}
public int getDeliveryPrice() {
	return deliveryPrice;
}
public void setDeliveryPrice(int deliveryPrice) {
	this.deliveryPrice = deliveryPrice;
}
public String getFromTo() {
	return fromTo;
}
public void setFromTo(String fromTo) {
	this.fromTo = fromTo;
}
public String getInfo() {
	return info;
}
public void setInfo(String info) {
	this.info = info;
}
public String getDetailInfo() {
	return DetailInfo;
}
public void setDetailInfo(String detailInfo) {
	DetailInfo = detailInfo;
}
public KitVO() {}
public KitVO( int category, int attribute, String title, int price, int remain,
		String deliver, int deliveryPrice, String fromTo, String info, String detailInfo) {
	this(0,0,0, category, attribute, title, price,remain ,deliver, deliveryPrice, fromTo, info, detailInfo);
}
	
public KitVO(int id, int fId, int cFId, int category, int attribute, String title, int price, int remain,
		String deliver, int deliveryPrice, String fromTo, String info, String detailInfo) {
	super();
	this.id = id;
	this.fId = fId;
	CFId = cFId;
	this.category = category;
	this.attribute = attribute;
	this.title = title;
	this.price = price;
	this.remain = remain;
	this.deliver = deliver;
	this.deliveryPrice = deliveryPrice;
	this.fromTo = fromTo;
	this.info = info;
	DetailInfo = detailInfo;
}
@Override
public String toString() {
	return "KitVO [id=" + id + ", fId=" + fId + ", CFId=" + CFId + ", category=" + category + ", attribute=" + attribute
			+ ", title=" + title + ", price=" + price + ", remain=" + remain + ", deliver=" + deliver
			+ ", deliveryPrice=" + deliveryPrice + ", fromTo=" + fromTo + ", info=" + info + ", DetailInfo="
			+ DetailInfo + "]";
}

}
