package com.LECFLY.LF.model.vo;

import java.sql.Timestamp;

public class CommentVO {
	int id; 		// id
	int mbId;		// 작성회원 id
	int tableCate;	// 해당 댓글이 소속되는 스키마	// 0:클래스 1:비디오 2:qna
	int atId;		// 해당 댓글을 소유한 글id		//
	int order;		// 댓글의 순서				//
	int depth;		// 댓글의 깊이				//
	String comment;	// 댓글 내용
	String mbNic;	// 작성회원 닉네임
	Timestamp createdAt; // 댓글 작성 일자
	
	
	public CommentVO() {}
	//필수 입력값
	public CommentVO(int mbId, int tableCate, int atId, int order, int depth, String comment, String mbNic) {
		this(0, mbId, tableCate, atId, order, depth, comment, mbNic, null);
	}
	public CommentVO(int id, int mbId, int tableCate, int atId, int order, int depth, String comment, String mbNic,
			Timestamp createdAt) {
		super();
		this.id = id;
		this.mbId = mbId;
		this.tableCate = tableCate;
		this.atId = atId;
		this.order = order;
		this.depth = depth;
		this.comment = comment;
		this.mbNic = mbNic;
		this.createdAt = createdAt;
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
	public int getTableCate() {
		return tableCate;
	}
	public void setTableCate(int tableCate) {
		this.tableCate = tableCate;
	}
	public int getAtId() {
		return atId;
	}
	public void setAtId(int atId) {
		this.atId = atId;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getMbNic() {
		return mbNic;
	}
	public void setMbNic(String mbNic) {
		this.mbNic = mbNic;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	
	
	@Override
	public String toString() {
		return "CommentVO [id=" + id + ", mbId=" + mbId + ", tableCate=" + tableCate + ", atId=" + atId + ", order="
				+ order + ", depth=" + depth + ", comment=" + comment + ", mbNic=" + mbNic + ", createdAt=" + createdAt
				+ "]";
	}
	
}

