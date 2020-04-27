package com.LECFLY.LF.model.vo;

import java.sql.Timestamp;

public class CommentClassVO {
	int cMId;        //                            클래스 댓글 ID
	int cMFId;       //                            클래스 댓글 소유자 ID
	int cMCFId;      //                            클래스 댓글 소속클래스 ID
	String cMName;      //                            클래스 댓글 소유자이름
	int cMGroup;     //                            클래스 댓글 그룹
	int cMOrder;     //                            클래스 댓글 순서
	int cMDepth;     //   1      					클래스 댓글 깊이
	String cMIF;        //   					클래스 댓글 내용
	Timestamp cMDate;      //   CURRENT_TIMESTAMP        클래스 댓글 등록날자
	
	
}
