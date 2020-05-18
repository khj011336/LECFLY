package com.LECFLY.LF.model.vo;

import java.util.HashMap;
import java.util.Map;

public class FaqVO {
	public static final String FAQ_TYPE_0 = "전체"; // 
	public static final String FAQ_TYPE_1 = "이용안내"; // 이용안내
	public static final String FAQ_TYPE_2 = "강의수강"; // 강의수강
	public static final String FAQ_TYPE_3 = "준비물 키트"; // 준비물 키트
	public static final String FAQ_TYPE_4 = "결제/환불"; // 결제/환불
	public static final String FAQ_TYPE_5 = "크리에이터"; // 크리에이터
	public static final String FAQ_TYPE_6 = "기타"; // 기타
	
	/** 자주묻는질문 글번호*/
	int id; 
	/** 분야	 */
	int type; 
	/** 분야	 */
	String stype;
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
	 * @param type
	 * @param title
	 * @param content
	 */
	public FaqVO(int type, String title, String content) {
		this(0, type, title, content);
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
	public String getStype() {
		switch (type) {
		case 0:
			return FAQ_TYPE_0;
		case 1:
			return FAQ_TYPE_1;
		case 2:
			return FAQ_TYPE_2;
		case 3:
			return FAQ_TYPE_3;
		case 4:
			return FAQ_TYPE_4;
		case 5:
			return FAQ_TYPE_5;
		case 6:
			return FAQ_TYPE_6;
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
	
	@Override
	public String toString() {
		return "FaqVO [id=" + id + ", type=" + type + ", title=" + title + ", content=" + content + "]";
	}
	
	
//	public static String getFaqValueOfType(int typeKey) {
//		Map<Integer, String>MAP_OF_TYPE = new HashMap<>();
//		MAP_OF_TYPE.put(FAQ_TYPE_0, "전체");
//		MAP_OF_TYPE.put(FAQ_TYPE_1, "이용안내");
//		MAP_OF_TYPE.put(FAQ_TYPE_2, "강의수강");
//		MAP_OF_TYPE.put(FAQ_TYPE_3, "준비물 키트");
//		MAP_OF_TYPE.put(FAQ_TYPE_4, "결제/환불");
//		MAP_OF_TYPE.put(FAQ_TYPE_5, "크리에이터");
//		MAP_OF_TYPE.put(FAQ_TYPE_6, "기타");
//		return MAP_OF_TYPE.get(typeKey); 
//	}
	
}                                                   
