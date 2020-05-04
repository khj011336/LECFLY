package com.LECFLY.LF.model.vo;

import java.sql.Timestamp;

public class ShopcartVO {
	int id;          	//        순서번호
	int addMbId;     	//        회원의 PK          <<fk>>
	int kOrF;       	//        상품분류        	0 키트 1 펀딩  
	int kOrFId;      	//        키트나 펀딩의 id	<<fk>>는아니고 kOrF 에따라서 select 로 가져올예정 여기서 해당 이미지 제목 가격을 뽑음    
	Timestamp addAt;	//        추가한 날짜        
	int kOrFCnt;     	//	1          키트나 펀딩의 량    
	
	public ShopcartVO() {
	}
	
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
