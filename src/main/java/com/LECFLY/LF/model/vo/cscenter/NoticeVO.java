package com.LECFLY.LF.model.vo.cscenter;

import java.sql.Timestamp;

public class NoticeVO {
	public static final String NOTICE_TYPE_0 = "일반 공지사항";
	public static final String NOTICE_TYPE_1 = "크리에이터 공지사항";
	
	/** 공지사항 번호 */
	int id;
	/** 작성자 id */
	int mbId;
	/** 공지 위치            0: 일반 페이지 1: 크리에이터 페이지*/
	int type;
	/** 공지위치 */
	String stype;
	/** 제목*/
	String title;
	/** 내용*/
	String content;
	/**  첨부파일             (다수인 경우 ,등 구분용 문자 삽입)*/
	String file;
	/** 작성날짜 CURRENT_TIMESTAMP*/
	Timestamp writedDay;
	/** 갱신날짜 CURRENT_TIMESTAMP*/
	Timestamp updatedDay; 
	/** 조회수*/
	int hits;	
	
	/**
	 * 더미 
	 */
	public NoticeVO() {
	}
	/**
	 * @param mbId
	 * @param type
	 * @param title
	 * @param content
	 * @param file
	 */
	public NoticeVO(int mbId, int type, String title, String content, String file) {
		this(0, mbId, type, title, content, file, null, null, 0);
	}
	/**
	 * @param mbId
	 * @param type
	 * @param title
	 * @param content
	 * @param file
	 * @param hits
	 */
	public NoticeVO(int mbId, int type, String title, String content, String file, int hits) {
		this(0, mbId, type, title, content, file, null, null, hits);
	}
	/**
	 * @param mbId
	 * @param type
	 * @param title
	 * @param content
	 * @param file
	 * @param writedDay
	 * @param updatedDay
	 * @param hits
	 */
	public NoticeVO(int mbId, int type, String title, String content, String file, Timestamp writedDay,
			Timestamp updatedDay, int hits) {
		this(0, mbId, type, title, content, file, writedDay, updatedDay, hits);
	}
	/**
	 * full constructor 
	 * @param id
	 * @param mbId
	 * @param type
	 * @param title
	 * @param content
	 * @param file
	 * @param writedDay
	 * @param updatedDay
	 * @param hits
	 */
	public NoticeVO(int id, int mbId, int type, String title, String content, String file, Timestamp writedDay,
			Timestamp updatedDay, int hits) {
		super();
		this.id = id;
		this.mbId = mbId;
		this.type = type;
		this.title = title;
		this.content = content;
		this.file = file;
		this.writedDay = writedDay;
		this.updatedDay = updatedDay;
		this.hits = hits;
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getStype() {
		switch (type) {
		case 0:
			return NOTICE_TYPE_0;
		case 1:
			return NOTICE_TYPE_1;
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
	
	@Override
	public String toString() {
		return "NoticeVO [id=" + id +", mbId=" + id +", type=" + type + ", title=" + title + ", content=" + content + ", file=" + file
				+ ", writedDay=" + writedDay + ", updatedDay=" + updatedDay + ", hits=" + hits + "]";
	}
	
}
