package com.LECFLY.LF.model.vo;

import java.sql.Timestamp;

public class MemberVO {
	int id;                //  id				int                pk ai                    
	String pic;            //  pic				varchar(128)                               
	String name;           //  name				varchar(16)        nn                  
	String nicname;        //  nicname			varchar(32)        nn uq                    
	Timestamp birthday;    //  birthday			Timestamp          nn                    
	int gender;            //  gender			tinyint            nn            (1:남 2여 3:관리자)
	String email;          //  email			varchar(64)        nn                    
	String password;       //  password			varchar(129)       nn                    
	String phNumber;       //  ph_number		varchar(12)        nn                    
	Timestamp joinedAt;    //  joined_at		timestamp      	   default CURRENT_TIMESTAMP                    
	int agreeReceive;      //  agree_receive	tinyint            default 0	 (0:선택x 1:1번항목체크 2:2번항목체크 3:모두체크) 
	int useTicket;         //  use_ticket		tinyint            default 0     (0:이용권없음 1:전체권 2:3개권 3:1개권 ...)
	int checkCreater;      //  check_creater	tinyint            default 0     (0:일반회원 1:신청중인회원 2:거절된 회원 3:크리에티어권한받은 회원)
	int loginCount;        //  login_count		int                                
	Timestamp loginedAt;   //  logined_at		timestamp                          
	String baiscAddress;	//	basic_address	varchar(256)
	String detailAddress;	//	detail_address	varchar(256)
	int postalCode;			//	postalcode	int
	String addressName;		//	address_name	varchar(24)
	String receiverName;	//	receiver_name	varchar(24)                       
	                                                                           
}
