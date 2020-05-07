package com.LECFLY.LF.model.vo;

public class FaqVO {
	/** 자주묻는질문 글번호*/
	int id; 
	/** 분야	 0: 회원관련 1: 결제/배송관련 2: 이용권 3: 강의 4: 펀딩 5: 기타*/
	int type; 
	/** 제목*/
	String title;        
	/** 내용 */
	String content;
	
	/**
	 * 더미
	 */
	public FaqVO() {
		
	}
	
	/**
	 * full constructor 
	 * @param id
	 * @param type
	 * @param title
	 * @param content
	 */
	public FaqVO(int id, int type, String title, String content) {
		super();
		this.id = id;
		this.type = type;
		this.title = title;
		this.content = content;
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
	
	@Override
	public String toString() {
		return "FaqVO [id=" + id + ", type=" + type + ", title=" + title + ", content=" + content + "]";
	}
	
	
	
}                                                   
