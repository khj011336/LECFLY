package com.LECFLY.LF.model.vo;

import java.sql.Timestamp;

/**
 * @author parksehyeon => 기존  LikeClassVO , WillShowClassVO 를 제거하고 
 * 	마이페이지에서 사용하기위하여 변경하였습니다 죄송합니다 - 0520 박세현 -
 *
 */
public class LecTypeVO {
	
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
	/** 최초 생성 날짜*/
	private Timestamp createAt;
	
	
	/**
	 *  더미생성자
	 */
	public LecTypeVO() {}
	
	
	/**
	 * 중간생성자 최소한의 필요한 정보
	 * @param mbId
	 * @param status
	 * @param classId
	 */
	public LecTypeVO(int mbId, int status, int classId) {
		this(0, mbId, status, classId, new Timestamp(System.currentTimeMillis()));
	}
	
	/**
	 * 풀생성자
	 * @param id
	 * @param mbId
	 * @param status
	 * @param classId
	 * @param createAt
	 */
	public LecTypeVO(int id, int mbId, int status, int classId, Timestamp createAt) {
		super();
		this.id = id;
		this.mbId = mbId;
		this.status = status;
		this.classId = classId;
		this.createAt = createAt;
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


	public Timestamp getCreateAt() {
		return createAt;
	}


	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}


	@Override
	public String toString() {
		return "LecTypeVO [id=" + id + ", mbId=" + mbId + ", status=" + status + ", classId=" + classId + ", createAt="
				+ createAt + "]";
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
    
	


	
	
} 