package com.LECFLY.LF.model.vo;

import java.sql.Timestamp;

public class QnaVO {
	int id;             		//                        qna 번호
	int mbId;           		//                        작성자 번호       "<<fk>>	_member/id 출력은 nicname"
	String mbNicname;            //                        작성자 닉네임
	int type;                	//  5                     	분야              0: 회원관련 1: 결제/배송관련 2: 이용권 3: 강의 4: 펀딩 5: 기타
	String title;                 //                        제목
	String content;               //                        내용
	String file;                  //                        첨부파일 
	int private;             	//  0                     	공개 여부         (다수인 경우 ,등 구분용 문자 삽입)
	Timestamp writedDay;     	 //  CURRENT_TIMESTAMP     작성날짜          0: 공개 1: 비공개
	Timestamp updatedDay;    	 //  CURRENT_TIMESTAMP     갱신날짜
	int hits;          			 //  0                     	조회 수
	int comment;        		//  0                     	댓글 수
}
