package com.LECFLY.LF.model.vo;

import java.sql.Timestamp;

public class NoticeVO {
	int id;         	//                          공지사항 번호
	int type;       	//                          공지 위치            0: 일반 페이지 1: 크리에이터 페이지
	String title;      	//                          제목
	String content;   	 //                          내용
	String file;       	//                          첨부파일             (다수인 경우 ,등 구분용 문자 삽입)
	Timestamp writedDay;  	//   CURRENT_TIMESTAMP      작성날짜
	Timestamp updatedDay; 	//   CURRENT_TIMESTAMP      갱신날짜
	int hits;		       //   0                    	조회수
}
