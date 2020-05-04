package com.LECFLY.LF.model.vo;

import java.sql.Timestamp;

public class CommentClassVO {
	/** 클래스 댓글 ID*/
	int cMId;
	/** 클래스 댓글 소유자 ID*/
	int cMFId;
	/** 클래스 댓글 소속클래스 ID*/
	int cMCFId;
	/** 클래스 댓글 소유자이름*/
	String cMName;
	/** 클래스 댓글 그룹*/
	int cMGroup;
	/** 클래스 댓글 순서*/
	int cMOrder;
	/** 클래스 댓글 깊이*/
	int cMDepth;
	/** 클래스 댓글 내용*/
	String cMIF; 
	/** 클래스 댓글 등록날자 CURRENT_TIMESTAMP */
	Timestamp cMDate;
	
	/**
	 * 더미
	 */
	public CommentClassVO() {
		
	}
	
	/**
	 * full constructor 
	 * @param cMId
	 * @param cMFId
	 * @param cMCFId
	 * @param cMName
	 * @param cMGroup
	 * @param cMOrder
	 * @param cMDepth
	 * @param cMIF
	 * @param cMDate
	 */
	public CommentClassVO(int cMId, int cMFId, int cMCFId, String cMName, int cMGroup, int cMOrder, int cMDepth,
			String cMIF, Timestamp cMDate) {
		super();
		this.cMId = cMId;
		this.cMFId = cMFId;
		this.cMCFId = cMCFId;
		this.cMName = cMName;
		this.cMGroup = cMGroup;
		this.cMOrder = cMOrder;
		this.cMDepth = cMDepth;
		this.cMIF = cMIF;
		this.cMDate = cMDate;
	}
	
	public int getcMId() {
		return cMId;
	}
	public void setcMId(int cMId) {
		this.cMId = cMId;
	}
	public int getcMFId() {
		return cMFId;
	}
	public void setcMFId(int cMFId) {
		this.cMFId = cMFId;
	}
	public int getcMCFId() {
		return cMCFId;
	}
	public void setcMCFId(int cMCFId) {
		this.cMCFId = cMCFId;
	}
	public String getcMName() {
		return cMName;
	}
	public void setcMName(String cMName) {
		this.cMName = cMName;
	}
	public int getcMGroup() {
		return cMGroup;
	}
	public void setcMGroup(int cMGroup) {
		this.cMGroup = cMGroup;
	}
	public int getcMOrder() {
		return cMOrder;
	}
	public void setcMOrder(int cMOrder) {
		this.cMOrder = cMOrder;
	}
	public int getcMDepth() {
		return cMDepth;
	}
	public void setcMDepth(int cMDepth) {
		this.cMDepth = cMDepth;
	}
	public String getcMIF() {
		return cMIF;
	}
	public void setcMIF(String cMIF) {
		this.cMIF = cMIF;
	}
	public Timestamp getcMDate() {
		return cMDate;
	}
	public void setcMDate(Timestamp cMDate) {
		this.cMDate = cMDate;
	}
	
	
	@Override
	public String toString() {
		return "CommentClassVO [cMId=" + cMId + ", cMFId=" + cMFId + ", cMCFId=" + cMCFId + ", cMName=" + cMName
				+ ", cMGroup=" + cMGroup + ", cMOrder=" + cMOrder + ", cMDepth=" + cMDepth + ", cMIF=" + cMIF
				+ ", cMDate=" + cMDate + "]";
	}
	
	
	
	
	
}

