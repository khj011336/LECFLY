package com.LECFLY.LF.model.vo.creator;

import java.sql.Timestamp;

public class VideoVO {
private int id;					// PK AI 
private int fId;				// FK 소유자 creator id
private int CFId;				// FK 클래스 소속
private String videoPath;		// UQ
private int duration;			// 동영상 재생길이
private String title;			// 동영상제목 UQ
private String info;			// 동영상 소개
private String imgPath;			// 이미지 파일 경로 UQ
private String gifPath;			// gif 파일 경로 UQ
private String orderInfo;		// 진행 순서 텍스트
private int category;			// 동영상 카테고리
private int commentYorN;		// 댓글허용
private int views;				// 조회수
private int status;				// 동영상 상태
private Timestamp createdAt;	// 만든시간
private Timestamp updatedAt;	// 업데이트 시간
private int likeCount;			// 좋아요수
private String likeOfmember;	// 좋아요한 멤버
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
public String getVideoPath() {
	return videoPath;
}
public void setVideoPath(String videoPath) {
	this.videoPath = videoPath;
}
public int getDuration() {
	return duration;
}
public void setDuration(int duration) {
	this.duration = duration;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getInfo() {
	return info;
}
public void setInfo(String info) {
	this.info = info;
}
public String getImgPath() {
	return imgPath;
}
public void setImgPath(String imgPath) {
	this.imgPath = imgPath;
}
public String getGifPath() {
	return gifPath;
}
public void setGifPath(String gifPath) {
	this.gifPath = gifPath;
}
public String getOrderInfo() {
	return orderInfo;
}
public void setOrderInfo(String orderInfo) {
	this.orderInfo = orderInfo;
}
public int getCategory() {
	return category;
}
public void setCategory(int category) {
	this.category = category;
}
public int getCommentYorN() {
	return commentYorN;
}
public void setCommentYorN(int commentYorN) {
	this.commentYorN = commentYorN;
}
public int getViews() {
	return views;
}
public void setViews(int views) {
	this.views = views;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
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
public int getLikeCount() {
	return likeCount;
}
public void setLikeCount(int likeCount) {
	this.likeCount = likeCount;
}
public String getLikeOfmember() {
	return likeOfmember;
}
public void setLikeOfmember(String likeOfmember) {
	this.likeOfmember = likeOfmember;
}

public VideoVO() {}

public VideoVO(  String videoPath, int duration, String title, String info, String imgPath,
		String gifPath, String orderInfo, int category, int commentYorN 
		) {
	
	this(0, 0,0, videoPath, duration,
			title, info, imgPath, gifPath, orderInfo, 
			category, commentYorN, 0, 2, null, null, 0, null);
}
public VideoVO(  String videoPath, int duration, String title, String info, String imgPath,
		String gifPath, String orderInfo, int category,int status,int commentYorN 
		) {
	
	this(0, 0,0, videoPath, duration,
			title, info, imgPath, gifPath, orderInfo, 
			category, commentYorN, 0, 2, null, null, status, null);
}
public VideoVO(int id, int fId, int cFId, String videoPath, int duration, String title, String info, String imgPath,
		String gifPath, String orderInfo, int category, int commentYorN, int views, int status, Timestamp createdAt,
		Timestamp updatedAt, int likeCount, String likeOfmember) {
	super();
	this.id = id;
	this.fId = fId;
	CFId = cFId;
	this.videoPath = videoPath;
	this.duration = duration;
	this.title = title;
	this.info = info;
	this.imgPath = imgPath;
	this.gifPath = gifPath;
	this.orderInfo = orderInfo;
	this.category = category;
	this.commentYorN = commentYorN;
	this.views = views;
	this.status = status;
	this.createdAt = createdAt;
	this.updatedAt = updatedAt;
	this.likeCount = likeCount;
	this.likeOfmember = likeOfmember;
}
@Override
public String toString() {
	return "VideoVO [id=" + id + ", fId=" + fId + ", CFId=" + CFId + ", videoPath=" + videoPath + ", duration="
			+ duration + ", title=" + title + ", info=" + info + ", imgPath=" + imgPath + ", gifPath=" + gifPath
			+ ", orderInfo=" + orderInfo + ", category=" + category + ", commentYorN=" + commentYorN + ", views="
			+ views + ", status=" + status + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", likeCount="
			+ likeCount + ", likeOfmember=" + likeOfmember + "]";
}


}
