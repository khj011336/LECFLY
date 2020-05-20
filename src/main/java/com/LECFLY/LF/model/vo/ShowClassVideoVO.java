package com.LECFLY.LF.model.vo;

import java.sql.Timestamp;

/**
 * @author USER
 *
 */
public class ShowClassVideoVO {
	
	public static final String[] STR_STATUS = {"수강신청", "찜하기", "좋아요"};
	public static final int STATUS_ATTENDING = 0;
	public static final int STATUS_WILL_ATTENDING = 1;
	public static final int STATUS_LIKE = 2;
	//(0:전체 1:미술 2:음악 3:요리 4:라이프스타일 5:운동 6:커리어 7:여행)
	public static final String[] STR_CATEGORY = {"전체", "미술", "음악", "요리", 
			"라이프 스타일", "운동", "커리어", "여행"};
	
	
	/** 순서번호*/
	private int id;				
	/** 회원 번호*/	
	private int mbId;
	/** 뭐때매 생성되냐 0:수강신청 1:찜하기 2:좋아요 */
	private int status;
	/** 클래스 번호*/
	private int classId;      	
	/** 영상 번호 */
	private int videoId;     		
	/** 영상 제목*/
	private String videoName;   	   
	/** 영상 사진*/
	private String videoPic;     	
	/** 영상 총 시간  */
	private int viewingTime;  		 
	/** 시청했던 시간 비율 0*/
	private float untilShow;    	
	/** 시청했던 날자 CURRENT_TIMESTAMP*/
	private Timestamp showAt;          
	
	/**
	 * 더미 
	 */
	public ShowClassVideoVO() {
//		super();
	}
	/**
	 * 중간 constructor
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
	public ShowClassVideoVO(int mbId, int status, int classId, int videoId, 
			String videoName, String videoPic, int viewingTime, float untilShow) {
		this(0, mbId, status, classId, videoId, videoName, 
				videoPic, viewingTime, untilShow, null);
	}
	
	/**
	 * full constructor
	 * @param id
	 * @param mbId
	 * @param status
	 * @param classId
	 * @param videoId
	 * @param videoName
	 * @param videoPic
	 * @param viewingTime
	 * @param untilShow
	 * @param showAt
	 */
	public ShowClassVideoVO(int id, int mbId, int status, int classId, int videoId, String videoName, String videoPic,
			int viewingTime, float untilShow, Timestamp showAt) {
		super();
		this.id = id;
		this.mbId = mbId;
		this.status = status;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
		return "ShowClassVideoVO [id=" + id + ", mbId=" + mbId + ", status=" + status + ", classId=" + classId
				+ ", videoId=" + videoId + ", videoName=" + videoName + ", videoPic=" + videoPic + ", viewingTime="
				+ viewingTime + ", untilShow=" + untilShow + ", showAt=" + showAt + "]";
	}

	
	
} 