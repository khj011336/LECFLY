package com.LECFLY.LF.model.dao.inf.member;

import java.util.List;

import com.LECFLY.LF.model.vo.PostscriptVO;

public interface IPostscriptDAO {
	
	// 후기 등록
	boolean addPostscript(int classId, int mbId, String mbLogin, String content, float rate);
	boolean addPostscript(PostscriptVO ps);
	// 해당 클래스 후기글 불러오기
	List<PostscriptVO> readAllPostscriptInLec(int lecId);
	// 하나의 후기글 불러오기
	PostscriptVO readOnePostscript(int id);
	// 하나의 후기글 갱신하기
	boolean updateOnePostscript(PostscriptVO ps);
	// 하나의 후기글 삭제하기
	boolean deleteOnePostscript(int id);
	// 해당 클래스 후기글 전체 삭제하기
	boolean deleteAllPostscriptInLec(int lecId);
	
	// 크리에이터가 후기에 댓글을 달음?
	// 크리에이터의 대댓글을 불러오기
	// 크리에이터의 대댓글을 갱신하기
	// 크리에이터의 대댓글을 삭제하기
}
