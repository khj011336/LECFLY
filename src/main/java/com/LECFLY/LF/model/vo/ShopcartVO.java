package com.LECFLY.LF.model.vo;

import java.sql.Timestamp;

public class ShopcartVO {
	/** 순서번호*/
	int id;          	
	/** 회원의 PK          /fk/*/
	int addMbId;     	
	/** 상품분류        	0 키트 1 펀딩*/
	int kOrF;       	 
	/** 키트나 펀딩의 id	/fk/ 는아니고 kOrF 에따라서 select 로 가져올예정 여기서 해당 이미지 제목 가격을 뽑음  */
	int kOrFId;      	    
	/** 추가한 날짜*/
	Timestamp addAt;	
	/** 키트나 펀딩의 량  1*/
	int kOrFCnt;     	    
	
	/**
	 * 더미
	 */
	public ShopcartVO() {
	}
	
	/**
	 * full constructor
	 * @param id
	 * @param addMbId
	 * @param kOrF
	 * @param kOrFId
	 * @param addAt
	 * @param kOrFCnt
	 */
	public ShopcartVO(int id, int addMbId, int kOrF, int kOrFId, Timestamp addAt, int kOrFCnt) {
		super();
		this.id = id;
		this.addMbId = addMbId;
		this.kOrF = kOrF;
		this.kOrFId = kOrFId;
		this.addAt = addAt;
		this.kOrFCnt = kOrFCnt;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAddMbId() {
		return addMbId;
	}
	public void setAddMbId(int addMbId) {
		this.addMbId = addMbId;
	}
	public int getkOrF() {
		return kOrF;
	}
	public void setkOrF(int kOrF) {
		this.kOrF = kOrF;
	}
	public int getkOrFId() {
		return kOrFId;
	}
	public void setkOrFId(int kOrFId) {
		this.kOrFId = kOrFId;
	}
	public Timestamp getAddAt() {
		return addAt;
	}
	public void setAddAt(Timestamp addAt) {
		this.addAt = addAt;
	}
	public int getkOrFCnt() {
		return kOrFCnt;
	}
	public void setkOrFCnt(int kOrFCnt) {
		this.kOrFCnt = kOrFCnt;
	}
	@Override
	public String toString() {
		return "ShopcartVO [id=" + id + ", addMbId=" + addMbId + ", kOrF=" + kOrF + ", kOrFId=" + kOrFId + ", addAt="
				+ addAt + ", kOrFCnt=" + kOrFCnt + "]";
	}
	
	
}                           
