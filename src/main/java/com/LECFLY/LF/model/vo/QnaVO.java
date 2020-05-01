package com.LECFLY.LF.model.vo;

import java.sql.Timestamp;

public class QnaVO {
	int id;             		//                        qna 번호
	int mbId;           		//                        작성자 번호       "<<fk>>	_member/id 출력은 nicname"
	String mbNicname;            //                        작성자 닉네임
	int type;                	//  5                     	분야              0: 회원관련 1: 결제/배송관련 2: 이용권 3: 강의 4: 펀딩 5: 기타
	String title;                 //                        제목
	String content;               //                        내용
	String file;                  //                        첨부파일 
	int showPrivate;             	//  0                     	공개 여부         (다수인 경우 ,등 구분용 문자 삽입)
	Timestamp writedDay;     	 //  CURRENT_TIMESTAMP     작성날짜          0: 공개 1: 비공개
	Timestamp updatedDay;    	 //  CURRENT_TIMESTAMP     갱신날짜
	int hits;          			 //  0                     	조회 수
	int comment;        		//  0                     	댓글 수
	
	public QnaVO() {
	}
	
	public QnaVO(int id, int mbId, String mbNicname, int type, String title, String content, String file,
			int showPrivate, Timestamp writedDay, Timestamp updatedDay, int hits, int comment) {
		super();
		this.id = id;
		this.mbId = mbId;
		this.mbNicname = mbNicname;
		this.type = type;
		this.title = title;
		this.content = content;
		this.file = file;
		this.showPrivate = showPrivate;
		this.writedDay = writedDay;
		this.updatedDay = updatedDay;
		this.hits = hits;
		this.comment = comment;
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
	public String getMbNicname() {
		return mbNicname;
	}
	public void setMbNicname(String mbNicname) {
		this.mbNicname = mbNicname;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public int getShowPrivate() {
		return showPrivate;
	}
	public void setShowPrivate(int showPrivate) {
		this.showPrivate = showPrivate;
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
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public int getComment() {
		return comment;
	}
	public void setComment(int comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "QnaVO [id=" + id + ", mbId=" + mbId + ", mbNicname=" + mbNicname + ", type=" + type + ", title=" + title
				+ ", content=" + content + ", file=" + file + ", showPrivate=" + showPrivate + ", writedDay="
				+ writedDay + ", updatedDay=" + updatedDay + ", hits=" + hits + ", comment=" + comment + "]";
	}
	
}
