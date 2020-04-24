package com.LECFLY.LF.model.vo;

import java.sql.Timestamp;

public class LikeClassVO {
	int id;     	//  	     				순서번호
	int mbId;   	//       					회원 번호     <<fk>>
	int classId;	  //      					클래스 번호   클래스로부터 크리에이터 닉네임, 제목, 카테고리 받아오기
	Timestamp addAt;  // CURRENT_TIMESTAMP      리스트 추가
}
