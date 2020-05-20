package com.LECFLY.LF.model.vo.creator;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

public class LectureVO {

	private int id; // pk AI
	private int fid; // FK
	private int category; // 클래스 카테고리 1~8
	private String subTitle; // 서브제목
	private String title; // 대제목 UQ
	private String titleImg; // 타이틀 이미지 파일경로 UQ
	private String infoImg; // 강의 소개 이미지 파일경로 UQ
	private String infoImgb; // 강의 소개 이미지 파일경로 UQ
	private String info; // 강의소개
	private int status; // 클래스 상태 1 ~ 미정
	private String MBofLikes; // 좋아요한 멤버들 , 로 구분
	private int likeCount; // 좋아요 카운트
	private int videoTrack; // 강의 비디오개수2
	private String nickname; // 메인화면 클래스 업로드를위한 닉네임 크리에이터VO nickname과 같음
	private String imgPath; // 메인화면 클래스 업로드를 위한 이미지패스 마찬가지로 크리에이터VO와 중복
	private Timestamp createdAt; // 만든시간
	private Timestamp updatedAt; // 업데이트시간
	private MultipartFile TitleImgM;
	private MultipartFile infoImgM;
	private MultipartFile infoImgbM;

	public MultipartFile getTitleImgM() {
		return TitleImgM;
	}

	public void setTitleImgM(MultipartFile titleImgM) {
		TitleImgM = titleImgM;
	}

	public MultipartFile getInfoImgM() {
		return infoImgM;
	}

	public void setInfoImgM(MultipartFile infoImgM) {
		this.infoImgM = infoImgM;
	}

	public MultipartFile getInfoImgbM() {
		return infoImgbM;
	}

	public void setInfoImgbM(MultipartFile infoImgbM) {
		this.infoImgbM = infoImgbM;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

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
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
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
		return titleImg;
	}

	public void setTitleImg(String titleImg) {
		this.titleImg = titleImg;
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

	public LectureVO() {
	}

	public LectureVO(int category, String subTitle, String title, String titleImg, String infoImg, String info) {
		this(0, 0, 0, subTitle, title, titleImg, infoImg, info, 2, null, 0, 0, null, null, null, null);

	}

	public LectureVO(int id, int fid, int category, String subTitle, String title, String titleImg, String infoImg,
			String info, int status, String mBofLikes, int likeCount, int videoTrack, String nickname, String imgPath,
			Timestamp createdAt, Timestamp updatedAt) {
		super();
		this.id = id;
		this.fid = fid;
		this.category = category;
		this.subTitle = subTitle;
		this.title = title;
		this.titleImg = titleImg;
		this.infoImg = infoImg;
		this.info = info;
		this.status = status;
		MBofLikes = mBofLikes;
		this.likeCount = likeCount;
		this.videoTrack = videoTrack;
		this.nickname = nickname;
		this.imgPath = imgPath;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return " category=" + category + ", subTitle=" + subTitle + ", title=" + title + ", TitleImg=" + titleImg
				+ ", infoImg=" + infoImg + ", info=" + info + ", nickname=" + nickname + ", imgPath=" + imgPath;
	}

	public String getInfoImgb() {
		return infoImgb;
	}

	public void setInfoImgb(String infoImgb) {
		this.infoImgb = infoImgb;
	}

}
