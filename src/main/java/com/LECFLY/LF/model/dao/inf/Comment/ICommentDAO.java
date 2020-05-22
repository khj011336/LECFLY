package com.LECFLY.LF.model.dao.inf.Comment;

import java.util.List;

import com.LECFLY.LF.model.vo.member.CommentVO;

public interface ICommentDAO {

	// 댓글 등록
	boolean addComment(CommentVO ct);
	
	// 모든 댓글 조회
	List<CommentVO> selectAllComments();
	// 한 댓글 조회
	CommentVO selectOneComment(int id);	// 기본 pk조회
	// 댓글 작성 일자   
	
	// 특정 조건 댓글 조회
		// 해당 글에 소속된 댓글리스트 호출	(강의창에서 댓글리스트를 불러올떄 주로 사용)
	List<CommentVO> selectCommentsByAtId(int atId);			//글별 조회
		// 작성 회원으로 조회	(통계 및 마이페이지용)
	List<CommentVO> selectCommentsByMbId(int mbId);			//작성자별 조회
		// 작성된 스키마로 분류 조회	(통계에 사용)
	List<CommentVO> selectCommentsByScheme(int cate);		//작성된 글 종류에 따른 조회
	
	List<CommentVO> selectCommentsForOrderNumDesc(int cate, int atId);//해당글의 댓글을 order내림차순으로 정렬하여 댓글을 받는다.
	List<CommentVO> selectCommentsForOrderNumAsc(int cate, int atId);	//해당글의 댓글을 order올림림차순으로 정렬하여 댓글을 받는다.
	

	List<CommentVO> searchCommentsByMbNic(String nicname);	// 작성회원 닉네임으로 검색         
	List<CommentVO> searchCommentsByMbId(int mbId); 		// 작성회원 id로 검색
	List<CommentVO> searchCommentsByArticle(int atId);		// 글id로 검색 (해당 댓글을 소유한 글id)
	List<CommentVO> searchCommentsByContent(String key);	// 댓글에 들어가는 내용 검색
	
	// 댓글 수정
	boolean updateOneComment(int id, String content);
	
	// 댓글 삭제
	boolean deleteOneComment(int id);
	boolean deleteOneCommentByVO(CommentVO ct);
	
	boolean increaseOrderNumComment(CommentVO ct);
}
