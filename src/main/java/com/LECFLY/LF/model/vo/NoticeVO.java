package com.LECFLY.LF.model.vo;

import java.sql.Timestamp;

public class NoticeVO {
	/** 공지사항 번호 */
	int id;
	/** 공지 위치            0: 일반 페이지 1: 크리에이터 페이지*/
	int type;
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
	 * full constructor 
	 * @param id
	 * @param type
	 * @param title
	 * @param content
	 * @param file
	 * @param writedDay
	 * @param updatedDay
	 * @param hits
	 */
	public NoticeVO(int id, int type, String title, String content, String file, Timestamp writedDay,
			Timestamp updatedDay, int hits) {
		super();
		this.id = id;
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
		return "NoticeVO [id=" + id + ", type=" + type + ", title=" + title + ", content=" + content + ", file=" + file
				+ ", writedDay=" + writedDay + ", updatedDay=" + updatedDay + ", hits=" + hits + "]";
	}
	
}
