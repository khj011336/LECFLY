package com.LECFLY.LF.model.vo;

import java.sql.Timestamp;

public class HomeFileManagerVO {
	int id;               //                   			순서번호
	int fileDisplayOn;    //		0                  	노출위치          (0: 메인 1:지정위치1 2:지정위치2)
	int fileDisplayNum;   //                   			노출순서          (0~ 6.  index3 메인노출)
	String fileName;      //                      		파일 제목
	String filePath;      //                      		파일 경로
	int fileSize;         //                   			파일크기
	Timestamp updatedDate;//      CURRENT_TIMESTAMP  업데이트 날짜
}
