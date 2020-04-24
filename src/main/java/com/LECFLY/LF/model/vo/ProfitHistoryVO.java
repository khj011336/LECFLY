package com.LECFLY.LF.model.vo;

import java.sql.Timestamp;

public class ProfitHistoryVO {
	int id;           //        				번호
	int uploaderId;   //       					업로더 회원번호
	int saveMoney;    //        				수익금
	int getMoney;     //        				출금금액
	int category;     //  3    					이벤트 분류
	String detail;    //        				이벤트 내용
	Timestamp day;    //  CURRENT_TIMESTAMP		이벤트 생성날자
	
}
