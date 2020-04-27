package com.LECFLY.LF.model.vo.creator;

import java.sql.Timestamp;

public class LectureVO {

private int  id; 				//pk AI
private int  Fid; 				// FK
private int  category; 			// 클래스 카테고리 1~8
private String  subTitle; 		// 서브제목
private String  title; 			// 대제목  UQ
private String TitleImg; 		// 타이틀 이미지 파일경로 UQ
private String infoImg; 		// 강의 소개 이미지 파일경로  UQ
private String info; 			// 강의소개
private int status; 			// 클래스 상태 1 ~ 미정 
private String MBofLikes; 		// 좋아요한 멤버들 , 로 구분
private int likeCount; 			// 좋아요 카운트
private int videoTrack;  		// 강의 비디오개수
private Timestamp createdAt; 	// 만든시간 
private Timestamp updatedAt;  	// 업데이트시간 
public int getVideoTrack() {
	return videoTrack;
}
public void setVideoTrack(int videoTrack) {
	this.videoTrack = videoTrack;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getFid() {
	return Fid;
}
public void setFid(int fid) {
	Fid = fid;
}
public int getCategory() {
	return category;
}
public void setCategory(int category) {
	this.category = category;
}
public String getSubTitle() {
	return subTitle;
}
public void setSubTitle(String subTitle) {
	this.subTitle = subTitle;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getTitleImg() {
	return TitleImg;
}
public void setTitleImg(String titleImg) {
	TitleImg = titleImg;
}
public String getInfoImg() {
	return infoImg;
}
public void setInfoImg(String infoImg) {
	this.infoImg = infoImg;
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
public String getMBofLikes() {
	return MBofLikes;
}
public void setMBofLikes(String mBofLikes) {
	MBofLikes = mBofLikes;
}
public int getLikeCount() {
	return likeCount;
}
public void setLikeCount(int likeCount) {
	this.likeCount = likeCount;
}
public Timestamp getCreatedAt() {
	return createdAt;
}
public void setCreatedAt(Timestamp createdAt) {
	this.createdAt = createdAt;
}
public Timestamp getUpdatedAt() {
	return updatedAt;
}
public void setUpdatedAt(Timestamp updatedAt) {
	this.updatedAt = updatedAt;
}
public LectureVO() {}

public LectureVO( int category, String subTitle, String title, String titleImg, String infoImg,
		String info) {
	this(0, 0,0, subTitle, title, titleImg, infoImg, info, 2, null, 0,0 , null, null);

}
public LectureVO(int id, int fid, int category, String subTitle, String title, String titleImg, String infoImg,
		String info, int status, String mBofLikes, int likeCount, int videoTrack, Timestamp createdAt,
		Timestamp updatedAt) {
	super();
	this.id = id;
	Fid = fid;
	this.category = category;
	this.subTitle = subTitle;
	this.title = title;
	TitleImg = titleImg;
	this.infoImg = infoImg;
	this.info = info;
	this.status = status;
	MBofLikes = mBofLikes;
	this.likeCount = likeCount;
	this.videoTrack = videoTrack;
	this.createdAt = createdAt;
	this.updatedAt = updatedAt;
}
 


}
