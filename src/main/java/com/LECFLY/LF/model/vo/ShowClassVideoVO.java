package com.LECFLY.LF.model.vo;

import java.sql.Timestamp;

public class ShowClassVideoVO {
	/** 순서번호*/
	int id;				
	/** 회원 번호*/
	int mbId;        		
	/** 클래스 번호*/
	int classId;      	
	/** 영상 번호 */
	int videoId;     		
	/** 영상 제목*/
	String videoName;   	   
	/** 영상 사진*/
	String videoPic;     	
	/** 영상 총 시간  */
	int viewingTime;  		 
	/** 시청했던 시간 비율 0*/
	float untilShow;    	
	/** 시청했던 날자 CURRENT_TIMESTAMP*/
	Timestamp showAt;          
	
	/**
	 * 더미 
	 */
	public ShowClassVideoVO() {
		super();
	}
	
	/**
	 * full constructor
	 * @param id
	 * @param mbId
	 * @param classId
	 * @param videoId
	 * @param videoName
	 * @param videoPic
	 * @param viewingTime
	 * @param untilShow
	 * @param showAt
	 */
	public ShowClassVideoVO(int id, int mbId, int classId, int videoId, String videoName, String videoPic,
			int viewingTime, float untilShow, Timestamp showAt) {
		super();
		this.id = id;
		this.mbId = mbId;
		this.classId = classId;
		this.videoId = videoId;
		this.videoName = videoName;
		this.videoPic = videoPic;
		this.viewingTime = viewingTime;
		this.untilShow = untilShow;
		this.showAt = showAt;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMbId() {
		return mbId;
	}
	public void setMbId(int mbId) {
		this.mbId = mbId;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public int getVideoId() {
		return videoId;
	}
	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	public String getVideoName() {
		return videoName;
	}
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	public String getVideoPic() {
		return videoPic;
	}
	public void setVideoPic(String videoPic) {
		this.videoPic = videoPic;
	}
	public int getViewingTime() {
		return viewingTime;
	}
	public void setViewingTime(int viewingTime) {
		this.viewingTime = viewingTime;
	}
	public float getUntilShow() {
		return untilShow;
	}
	public void setUntilShow(float untilShow) {
		this.untilShow = untilShow;
	}
	public Timestamp getShowAt() {
		return showAt;
	}
	public void setShowAt(Timestamp showAt) {
		this.showAt = showAt;
	}

	@Override
	public String toString() {
		return "ShowClassVideoVO [id=" + id + ", mbId=" + mbId + ", classId=" + classId + ", videoId=" + videoId
				+ ", videoName=" + videoName + ", videoPic=" + videoPic + ", viewingTime=" + viewingTime
				+ ", untilShow=" + untilShow + ", showAt=" + showAt + "]";
	}
	
}                                                       
