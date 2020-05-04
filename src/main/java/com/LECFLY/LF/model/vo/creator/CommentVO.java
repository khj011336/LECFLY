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
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getfId() {
	return fId;
}
public void setfId(int fId) {
	this.fId = fId;
}
public int getLecId() {
	return lecId;
}
public void setLecId(int lecId) {
	this.lecId = lecId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getGroup() {
	return group;
}
public void setGroup(int group) {
	this.group = group;
}
public int getOrder() {
	return order;
}
public void setOrder(int order) {
	this.order = order;
}
public int getDepth() {
	return depth;
}
public void setDepth(int depth) {
	this.depth = depth;
}
public String getInfo() {
	return info;
}
public void setInfo(String info) {
	this.info = info;
}
public Timestamp getCreatedAt() {
	return createdAt;
}
public void setCreatedAt(Timestamp createdAt) {
	this.createdAt = createdAt;
}
public CommentVO(int id, int fId, int lecId, String name, int group, int order, int depth, String info,
		Timestamp createdAt) {
	super();
	this.id = id;
	this.fId = fId;
	this.lecId = lecId;
	this.name = name;
	this.group = group;
	this.order = order;
	this.depth = depth;
	this.info = info;
	this.createdAt = createdAt;
}
@Override
public String toString() {
	return "CommentVO [id=" + id + ", fId=" + fId + ", lecId=" + lecId + ", name=" + name + ", group=" + group
			+ ", order=" + order + ", depth=" + depth + ", info=" + info + ", createdAt=" + createdAt + "]";
}


}
