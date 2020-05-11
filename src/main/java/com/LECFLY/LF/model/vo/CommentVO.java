package com.LECFLY.LF.model.vo;

import java.sql.Timestamp;

public class CommentVO {
	int id; 		// id
	int mbId;		// 작성회원 id
	int tableCate;	// 해당 댓글이 소속되는 스키마	// 묶여서 판단
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
	
	
}

