package com.LECFLY.LF.model.vo;

import java.sql.Timestamp;

public class ShowClassVideoVO {
	int id;					//							순서번호
	int mbId;        		 //                          회원 번호
	int classId;      		//                          클래스 번호
	int videoId;     		 //                          영상 번호      
	String videoName;   	 //                          영상 제목      
	String videoPic;     	//                          영상 사진      
	int viewingTime;  		//                           영상 총 시간   
	float untilShow;    	//    0                    	시청했던 시간 비율 
	Timestamp showAt;       //    CURRENT_TIMESTAMP     시청했던 날자    
}                                                       
