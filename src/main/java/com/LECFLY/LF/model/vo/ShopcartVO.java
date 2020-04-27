package com.LECFLY.LF.model.vo;

import java.sql.Timestamp;

public class ShopcartVO {
	int id;          	//        순서번호
	int addMbId;     	//        회원의 PK          <<fk>>
	int kOrF;       	//        상품분류        	0 키트 1 펀딩  
	int kOrFId;      	//        키트나 펀딩의 id	<<fk>>는아니고 kOrF 에따라서 select 로 가져올예정 여기서 해당 이미지 제목 가격을 뽑음    
	Timestamp addAt;	//        추가한 날짜        
	int kOrFCnt;     	//	1          키트나 펀딩의 량    
}                           
