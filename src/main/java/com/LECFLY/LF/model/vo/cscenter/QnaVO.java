package com.LECFLY.LF.model.vo.cscenter;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class QnaVO {
	public static final String QNA_TYPE_0 = "회원관련";
	public static final String QNA_TYPE_1 = "결제/배송관련";
	public static final String QNA_TYPE_2 = "이용권";
	public static final String QNA_TYPE_3 = "강의";
	public static final String QNA_TYPE_4 = "펀딩";
	public static final String QNA_TYPE_5 = "기타";
	
	public static final String QNA_PRIVATE_0 = "전체공개";
	public static final String QNA_PRIVATE_1 = "비공개";
	
	/** qna 번호 */
	int id; 
	/** 작성자 번호       "fk	_member/id 출력은 nicname" */
	int mbId;
	/** 작성자 닉네임 */
	String mbNicname; 
	/** 분야              0: 회원관련 1: 결제/배송관련 2: 이용권 3: 강의 4: 펀딩 5: 기타 */
	int type;
	/** 분야 */
	String stype;
	/** 제목 */
	String title;
	/** 내용 */
	String content;
	/** 첨부파일	 (다수인 경우 ,등 구분용 문자 삽입) */
	String file; 
	/** 공개 여부	0: 공개 1: 비공개 0 */
	int showPrivate;
	/** 공개 여부 */
	String sshowPrivate;
	/** 작성날짜 CURRENT_TIMESTAMP */
	Timestamp writedDay; 
	/** 갱신날짜 CURRENT_TIMESTAMP */
	Timestamp updatedDay;
	/** 조회 수 _자동증가 */
	int hits; 
	/** 댓글 수 */
	int comment; 
	
	/**
	 * 더미
	 */
	public QnaVO() {
	}
	
	/**
	 * 최소 구조
	 * @param mbId
	 * @param mbNicname
	 * @param type
	 * @param title
	 * @param content
	 * @param showPrivate
	 */
	public QnaVO(int mbId, String mbNicname, int type, String title, String content,
			int showPrivate) {
		this(0, mbId, mbNicname, type, title, content, null, showPrivate, null, null, 0, 0);
	}
	
	/**
	 * 파일이 있는 QnA인 경우
	 * @param mbId
	 * @param mbNicname
	 * @param type
	 * @param title
	 * @param content
	 * @param file
	 * @param showPrivate
	 */
	public QnaVO(int mbId, String mbNicname, int type, String title, String content, String file ,
			int showPrivate) {
		this(0, mbId, mbNicname, type, title, content, file , showPrivate, null, null, 0, 0);
	}
	
	/**
	 * full constructor 
	 * @param id 
	 * @param mbId
	 * @param mbNicname
	 * @param type
	 * @param title
	 * @param content
	 * @param file
	 * @param showPrivate
	 * @param writedDay
	 * @param updatedDay
	 * @param hits
	 * @param comment
	 */
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
	public String getStype() {
		switch (type) {
		case 0:
			return QNA_TYPE_0;
		case 1:
			return QNA_TYPE_1;
		case 2:
			return QNA_TYPE_2;
		case 3:
			return QNA_TYPE_3;
		case 4:
			return QNA_TYPE_4;
		case 5:
			return QNA_TYPE_5;
		default:
			break;
		}
		return stype;
	}
	public void setStype(String stype) {
		this.stype = stype;
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
	public String getSshowPrivate() {
		switch (showPrivate) {
		case 0:
			return QNA_PRIVATE_0;
		case 1:
			return QNA_PRIVATE_1;
		default:
			break;
		}
		return sshowPrivate;
	}
	public void setSshowPrivate(String sshowPrivate) {
		this.sshowPrivate = sshowPrivate;
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
