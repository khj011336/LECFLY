package com.LECFLY.LF.model.vo;

import java.sql.Timestamp;

public class PostscriptVO {
	int id;                      // 후기번호
	int classId;                 // 클래스번호         	 <<fk>>
	int mbId;                    // 작성회원번호       	 <<fk>>
	String mbLogin;                 // 작성자 닉네임
	String content;                 // 후기 내용
	float rate;                    // 별점 평가
	Timestamp writedDay;               // 작성 날자
	int creatorIdComt;           // 댓글 작성크리에이터	<<fk>>  *후기에 대한 댓글은 업로더만 작성가능  
	String creatorUserNameComt;     // 댓글작성자 닉네임   
	String contentComt;             // 댓글내용            
	Timestamp writeDayComt;            // 댓글작성일자        
	
	public PostscriptVO() {
	}
	
	public PostscriptVO(int id, int classId, int mbId, String mbLogin, String content, float rate, Timestamp writedDay,
			int creatorIdComt, String creatorUserNameComt, String contentComt, Timestamp writeDayComt) {
		super();
		this.id = id;
		this.classId = classId;
		this.mbId = mbId;
		this.mbLogin = mbLogin;
		this.content = content;
		this.rate = rate;
		this.writedDay = writedDay;
		this.creatorIdComt = creatorIdComt;
		this.creatorUserNameComt = creatorUserNameComt;
		this.contentComt = contentComt;
		this.writeDayComt = writeDayComt;
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
	public int getMbId() {
		return mbId;
	}
	public void setMbId(int mbId) {
		this.mbId = mbId;
	}
	public String getMbLogin() {
		return mbLogin;
	}
	public void setMbLogin(String mbLogin) {
		this.mbLogin = mbLogin;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public Timestamp getWritedDay() {
		return writedDay;
	}
	public void setWritedDay(Timestamp writedDay) {
		this.writedDay = writedDay;
	}
	public int getCreatorIdComt() {
		return creatorIdComt;
	}
	public void setCreatorIdComt(int creatorIdComt) {
		this.creatorIdComt = creatorIdComt;
	}
	public String getCreatorUserNameComt() {
		return creatorUserNameComt;
	}
	public void setCreatorUserNameComt(String creatorUserNameComt) {
		this.creatorUserNameComt = creatorUserNameComt;
	}
	public String getContentComt() {
		return contentComt;
	}
	public void setContentComt(String contentComt) {
		this.contentComt = contentComt;
	}
	public Timestamp getWriteDayComt() {
		return writeDayComt;
	}
	public void setWriteDayComt(Timestamp writeDayComt) {
		this.writeDayComt = writeDayComt;
	}
	
	@Override
	public String toString() {
		return "PostscriptVO [id=" + id + ", classId=" + classId + ", mbId=" + mbId + ", mbLogin=" + mbLogin
				+ ", content=" + content + ", rate=" + rate + ", writedDay=" + writedDay + ", creatorIdComt="
				+ creatorIdComt + ", creatorUserNameComt=" + creatorUserNameComt + ", contentComt=" + contentComt
				+ ", writeDayComt=" + writeDayComt + "]";
	}
	
}                                       
