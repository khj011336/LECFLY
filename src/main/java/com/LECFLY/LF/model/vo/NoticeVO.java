package com.LECFLY.LF.model.vo;

import java.sql.Timestamp;

public class NoticeVO {
	int id;         	//                          공지사항 번호
	int type;       	//                          공지 위치            0: 일반 페이지 1: 크리에이터 페이지
	String title;      	//                          제목
	String content;   	 //                          내용
	String file;       	//                          첨부파일             (다수인 경우 ,등 구분용 문자 삽입)
	Timestamp writedDay;  	//   CURRENT_TIMESTAMP      작성날짜
	Timestamp updatedDay; 	//   CURRENT_TIMESTAMP      갱신날짜
	int hits;		       //   0                    	조회수
	
	public NoticeVO() {
	}
	
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
