package com.LECFLY.LF.model.vo;

import java.sql.Timestamp;

public class TicketVO {
	int id;			//                     			순서번호
	int mbId;        //                     		이용중인 회원    해당 데이터 이용중인 회원 판별 용도
	int name;       //                     			이용권 명칭      (1: 1카테고리이용권  2: 3카테고리이용권  3:전체이용권)
	int category;    //                     		선택한 카테고리  (0:전체 1:미술 2:음악 3:요리 4:라이프스타일 5:운동 6:커리어 7:여행)
	int price;       //                     		이용권 가격
	Timestamp startDay;    //  CURRENT_TIMESTAMP  	이용권 시작일
	Timestamp endDay;      //  CURRENT_TIMESTAMP  	이용권 유효날자
}
