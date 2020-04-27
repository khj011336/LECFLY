package com.LECFLY.LF.model.vo.creator;

import java.sql.Timestamp;

public class CommentVO {
private int id ;		//id
private int fId;		//FK
private int lecId;		//FK 강의 id
private String name;	//댓글작성자
private int group;		//댓글이 작성된 그룹
private int order ;		//댓글순서
private int depth;		//댓글깊이
private String info;	//댓글내용
private Timestamp createdAt; //댓글 단시간 

}
