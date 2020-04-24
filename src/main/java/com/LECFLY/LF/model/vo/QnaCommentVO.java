package com.LECFLY.LF.model.vo;

import java.sql.Timestamp;

public class QnaCommentVO {
	int id;        		//                       댓글 번호
	int mbId;      		//                       "작성자	"  "<<fk>>	_member/id 출력은 nicname"
	String mbLogin;   	//                       작성자 닉네임
	int qnaId;     		//                       "원글 번호	"  <<fk>>_qna/id
	String content;   	//                       댓글 내용
	int parentsId; 		//                       대댓글 부모 번qna_comment/id호
	int seq;       		//  	1     		               대댓 시퀀스
	Timestamp writedDay;  //  CURRENT_TIMESTAMP    작성날짜
	Timestamp updatedDay; //  CURRENT_TIMESTAMP    갱신날짜
}
