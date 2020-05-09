package com.LECFLY.LF.model.vo;

import java.sql.Timestamp;

public class QnaCommentVO {
	/** 댓글 번호 */
	int id; 
	/** 작성자 fk/ 	_member/id 출력은 nicname */
	int mbId;
	/** 작성자 닉네임 */
	String mbLogin; 
	/** 원글 번호 fk/ _qna/id */
	int qnaId; 
	/**  댓글 내용 */
	String content; 
	/** 대댓글 부모 번qna_comment/id호*/
	int parentsId; 	
	/**  대댓 시퀀스	1*/
	int seq;    
	/** 작성날짜 CURRENT_TIMESTAMP */
	Timestamp writedDay; 
	/** 갱신날짜 CURRENT_TIMESTAMP */
	Timestamp updatedDay;
	
	/**
	 * 더미
	 */
	public QnaCommentVO() {
	}
	
	/**
	 * @param mbId
	 * @param mbLogin
	 * @param qnaId
	 * @param content
	 */
	public QnaCommentVO(int mbId, String mbLogin, int qnaId, String content) {
		this(0,mbId, mbLogin, qnaId, content, 0, 0 ,null, null);
	}
	
	/**
	 * @param mbId
	 * @param mbLogin
	 * @param qnaId
	 * @param content
	 * @param parentsId
	 * @param seq
	 */
	public QnaCommentVO(int mbId, String mbLogin, int qnaId, String content, int parentsId, int seq) {
		this(0,mbId, mbLogin, qnaId, content, parentsId, seq,null, null);
	}
	/**
	 * @param id
	 * @param mbId
	 * @param mbLogin
	 * @param qnaId
	 * @param content
	 * @param parentsId
	 * @param seq
	 * @param writedDay
	 * @param updatedDay
	 */
	public QnaCommentVO(int id, int mbId, String mbLogin, int qnaId, String content, int parentsId, int seq,
			Timestamp writedDay, Timestamp updatedDay) {
		super();
		this.id = id;
		this.mbId = mbId;
		this.mbLogin = mbLogin;
		this.qnaId = qnaId;
		this.content = content;
		this.parentsId = parentsId;
		this.seq = seq;
		this.writedDay = writedDay;
		this.updatedDay = updatedDay;
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
	public String getMbLogin() {
		return mbLogin;
	}
	public void setMbLogin(String mbLogin) {
		this.mbLogin = mbLogin;
	}
	public int getQnaId() {
		return qnaId;
	}
	public void setQnaId(int qnaId) {
		this.qnaId = qnaId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getParentsId() {
		return parentsId;
	}
	public void setParentsId(int parentsId) {
		this.parentsId = parentsId;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public Timestamp getWritedDay() {
		return writedDay;
	}
	public void setWritedDay(Timestamp writedDay) {
		this.writedDay = writedDay;
	}
	public Timestamp getUpdatedDay() {
		return updatedDay;
	}
	public void setUpdatedDay(Timestamp updatedDay) {
		this.updatedDay = updatedDay;
	}
	
	@Override
	public String toString() {
		return "QnaCommentVO [id=" + id + ", mbId=" + mbId + ", mbLogin=" + mbLogin + ", qnaId=" + qnaId + ", content="
				+ content + ", parentsId=" + parentsId + ", seq=" + seq + ", writedDay=" + writedDay + ", updatedDay="
				+ updatedDay + "]";
	}
}
