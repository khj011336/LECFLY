package com.LECFLY.LF.model.vo;

import java.sql.Timestamp;

public class PostscriptVO {
	int id;                      // 후기번호
	int classId;                 // 클래스번호         	 <<fk>>
	int mbId;                    // 작성회원번호       	 <<fk>>
	String mbLogin;                 // 작성자 닉네임
	String content;                 // 후기 내용
	float rate;                    // 별점 평가
	Timestamp writedDay;               // 작성 날자
	int creatorIdComt;           // 댓글 작성크리에이터	<<fk>>  *후기에 대한 댓글은 업로더만 작성가능  
	String creatorUserNameComt;     // 댓글작성자 닉네임   
	String contentComt;             // 댓글내용            
	Timestamp writeDayComt;            // 댓글작성일자        
}                                      // 
