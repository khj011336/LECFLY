package com.LECFLY.LF.model.vo;

import java.sql.Timestamp;

public class QnaCommentVO {
	int id;        		//                       댓글 번호
	int mbId;      		//                       "작성자	"  "<<fk>>	_member/id 출력은 nicname"
	String mbLogin;   	//                       작성자 닉네임
	int qnaId;     		//                       "원글 번호	"  <<fk>>_qna/id
	String content;   	//                       댓글 내용
	int parentsId; 		//                       대댓글 부모 번qna_comment/id호
	int seq;       		//  	1     		               대댓 시퀀스
	Timestamp writedDay;  //  CURRENT_TIMESTAMP    작성날짜
	Timestamp updatedDay; //  CURRENT_TIMESTAMP    갱신날짜
	
	public QnaCommentVO() {
	}
	
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
