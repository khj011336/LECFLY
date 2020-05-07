package com.LECFLY.LF.model.vo;

import java.sql.Timestamp;

public class WillShowClassVO {
	/** 순서번호*/
	int id;      		
	/** 회원 번호	/fk/*/
	int mbId;    	
	/** 클래스 번호	클래스로부터 크리에이터 닉네임, 제목, 카테고리, 사진 받아오기*/
	int classId; 	
	/** 리스트 추가 일자 URRENT_TIMESTAMP*/
	Timestamp addAt; 
	
	/**
	 * 더미
	 */
	public WillShowClassVO() {
	}
	
	/**
	 * full constructor
	 * @param id
	 * @param mbId
	 * @param classId
	 * @param addAt
	 */
	public WillShowClassVO(int id, int mbId, int classId, Timestamp addAt) {
		super();
		this.id = id;
		this.mbId = mbId;
		this.classId = classId;
		this.addAt = addAt;
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
	public Timestamp getAddAt() {
		return addAt;
	}
	public void setAddAt(Timestamp addAt) {
		this.addAt = addAt;
	}

	@Override
	public String toString() {
		return "WillShowClassVO [id=" + id + ", mbId=" + mbId + ", classId=" + classId + ", addAt=" + addAt + "]";
	}

	
}                          	
                           		