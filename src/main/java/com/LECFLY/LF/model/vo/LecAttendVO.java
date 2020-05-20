package com.LECFLY.LF.model.vo;

import java.sql.Timestamp;

/**
 * @author parksehyeon  LecTypeVO를생성하면서 0일떄 같이 생성되는 VO 입니다. 
 * 수강중인영상 수강중인 강의 클릭의경우 비디오가 나와야하고, 좋아요 찜하기의경우 비디오가아닌 클래스가 나와야해서 수정하게 되었습니다
 * 
 *
 */
public class LecAttendVO {
	
	/** 자동생성 순서번호 */
	private int id;
	/** LecTypeVO 에서 0번으로 할시 선택된 클래스 아이디 그때말고는 생성되면안됨 */ 
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
	 * 더미생성자 
	 */
	public LecAttendVO() {}
	
	/**
	 *  중간생성자
	 * @param classId
	 * @param videoId
	 * @param videoName
	 * @param videoPic
	 * @param viewingTime
	 * @param untilShow
	 */
	public LecAttendVO(int classId, int videoId, 
			String videoName, String videoPic, int viewingTime, float untilShow) {
		this(0, classId, videoId, videoName, videoPic, 
				viewingTime, untilShow, new Timestamp(System.currentTimeMillis()));
	}
	
	/**
	 * 풀생성자
	 * @param id
	 * @param classId
	 * @param videoId
	 * @param videoName
	 * @param videoPic
	 * @param viewingTime
	 * @param untilShow
	 * @param showAt
	 */
	public LecAttendVO(int id, int classId, int videoId, String videoName, String videoPic, int viewingTime,
			float untilShow, Timestamp showAt) {
		super();
		this.id = id;
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
		return "LecAttendVO [id=" + id + ", classId=" + classId + ", videoId=" + videoId + ", videoName=" + videoName
				+ ", videoPic=" + videoPic + ", viewingTime=" + viewingTime + ", untilShow=" + untilShow + ", showAt="
				+ showAt + "]";
	}
	
}
