package com.LECFLY.LF.model.vo;

import java.sql.Timestamp;

public class CouponVO {
	int id;                //                    쿠폰 번호
	String code;           //                    쿠폰 코드 번호
	int makerId;             //                    쿠폰 발행자     "<<fk>>(회원테이블참조)	"
	int mbId;              //                    쿠폰 보유회원   <<fk>>
	int useCheck;          // 0                  	사용 여부       0:미사용 1:사용) 
	int category;          // 3                  	쿠폰 종류       (1:키트 2:펀딩 3:기타 ~~)
	int discount;          //                    할인금액
	Timestamp createdDay;  // CURRENT_TIMESTAMP  쿠폰 생성 날자  (사용기한등에 이용)
	Timestamp endDay;      //                    유효기간
	
	
	
	
}
