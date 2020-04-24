package com.LECFLY.LF.model.vo;

import java.sql.Timestamp;

public class CSFileManagerVO {
	int id;           //                      순서번호
	int qnaOrNotice;  //                      게시판 구분      0: qna 1: notice
	int contentsId;   //                      글 번호          <<fk>>
	String fileName;     //                      파일제목
	String filePath;     //                      파일경로
	int fileSize;    		 //                      파일크기
	Timestamp updatedDate;  //  CURRENT_TIMESTAMP   업데이트 날짜
}
