package com.LECFLY.LF.model.vo.creator;

import org.springframework.web.multipart.MultipartFile;

public class KitVO {
private int id ;		//PK AI
private int fId;		//FK
private int cFId;		//FK
private int category;   // 상품 해당 카테고리
private String attribute;	// 상퓸속성
private String title;	// 상품이름
private int price;		// 상품가격
private int remain;
private String imgPath;
private String deliver;
private int deliveryPrice;
private String fromTo;
private String info;
private String detailInfo;
private MultipartFile kitImg;


public MultipartFile getKitImg() {
	return kitImg;
}
public void setKitImg(MultipartFile kitImg) {
	this.kitImg = kitImg;
}
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
	return cFId;
}
public void setCFId(int cFId) {
	this.cFId = cFId;
}
public int getCategory() {
	return category;
}
public void setCategory(int category) {
	this.category = category;
}
public String getAttribute() {
	return attribute;
}
public void setAttribute(String attribute) {
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
	return detailInfo;
}
public void setDetailInfo(String detailInfo) {
	this.detailInfo = detailInfo;
}

public String getImgPath() {
	return imgPath;
}
public void setImgPath(String imgPath) {
	this.imgPath = imgPath;
}
 
@Override
public String toString() {
	return "KitVO [id=" + id + ", fId=" + fId + ", CFId=" + cFId + ", category=" + category + ", attribute=" + attribute
			+ ", title=" + title + ", price=" + price + ", remain=" + remain + ", imgPath=" + imgPath + ", deliver="
			+ deliver + ", deliveryPrice=" + deliveryPrice + ", fromTo=" + fromTo + ", info=" + info + ", DetailInfo="
			+ detailInfo + "]";
}
public KitVO() {}
public KitVO( int fId, int cFId, int category, String attribute, String title, int price, int remain,
		String imgPath, String deliver, int deliveryPrice, String fromTo, String info, String detailInfo) {
	this(0, fId, cFId, category, attribute, title,
			price, remain, imgPath, deliver, deliveryPrice, fromTo, info, detailInfo);
}
public KitVO(int id, int fId, int cFId, int category, String attribute, String title, int price, int remain,
		String imgPath, String deliver, int deliveryPrice, String fromTo, String info, String detailInfo) {
	super();
	this.id = id;
	this.fId = fId;
	this.cFId = cFId;
	this.category = category;
	this.attribute = attribute;
	this.title = title;
	this.price = price;
	this.remain = remain;
	this.imgPath = imgPath;
	this.deliver = deliver;
	this.deliveryPrice = deliveryPrice;
	this.fromTo = fromTo;
	this.info = info;
	this.detailInfo = detailInfo;
}

}
