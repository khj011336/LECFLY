package com.LECFLY.LF.model.vo.creator;

import java.sql.Timestamp;


public class CreatorVO {

private int id; 			 //PK AI  
private int fId; 			 //Fk 
private String imgPath; 	 // 이미지 파일경로 파일네이밍 규정에 따름 UQ
private String name; 		 // 크리에이터 이름
private String nickname;     // 크리에이터 닉네임 UQ
private String Cphone;		 // 크리에이터 셀폰
private String SNS; 		 // 크리에이터 SNS 연동아이디
private String info;		 // 크리에이터소개
private int status;			 // 크리에이터 상태 
private Timestamp grantDate; // 승인날자

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getFid() {
	return fId;
}
public void setFid(int fid) {
	fId = fid;
}
public String getImg() {
	return imgPath;
}
public void setImg(String img) {
	this.imgPath = img;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCphone() {
	return Cphone;
}
public void setCphone(String cphone) {
	Cphone = cphone;
}
public String getSNS() {
	return SNS;
}
public void setSNS(String sNS) {
	SNS = sNS;
}
public String getInfo() {
	return info;
}
public void setInfo(String info) {
	this.info = info;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public Timestamp getGrantDate() {
	return grantDate;
}
public void setGrantDate(Timestamp grantDate) {
	this.grantDate = grantDate;
}
public CreatorVO() {}
public String getNickname() {
	return nickname;
}
public void setNickname(String nickname) {
	this.nickname = nickname;
}
public CreatorVO( String imgPath, String nickname, String cphone, String sNS, String info,
		int status) {
	this(0, 0, imgPath, null, nickname, cphone, sNS, info, 2, null);
}
public CreatorVO(int id, int fid, String imgPath, String name, String nickname, String cphone, String sNS, String info,
		int status, Timestamp grantDate) {
	super();
	this.id = id;
	this.fId = fid;
	this.imgPath = imgPath;
	this.name = name;
	this.nickname = nickname;
	Cphone = cphone;
	SNS = sNS;
	this.info = info;
	this.status = status;
	this.grantDate = grantDate;
}

@Override
public String toString() {
	return "CreatorVO [id=" + id + ", Fid=" + fId + ", img=" + imgPath + ", name=" + name + ", nickname=" + nickname
			+ ", Cphone=" + Cphone + ", SNS=" + SNS + ", info=" + info + ", status=" + status + ", grantDate="
			+ grantDate + "]";
}

}
