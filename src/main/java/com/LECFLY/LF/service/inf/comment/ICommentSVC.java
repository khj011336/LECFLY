package com.LECFLY.LF.service.inf.comment;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Service;

import com.LECFLY.LF.model.vo.CommentVO;

@Service
public interface ICommentSVC {
	
	final int ADD_COMMENT_SUCCES = 1;	// 성공
	final int ADD_COMMENT_FAIL = 2;		// 댓글 추가 실패(DB오류)
	final int NONE_FIND_ATID = 3;		// 해당 글 없음
	final int FAIL_INCREASE = 4;		// order 증가 연산 실패
	
	// 댓글 등록		글쓴이번호	해당 글이 속한 테이블	해당 글		댓글 내용			글쓴이 닉네임	대댓글이면 해당 댓글의 id(VO에 속하지않은 인자)
	int addComment(int mbId, int tableCate, int atId, String comment, String mbNic, int targetCtId);
		// 기본 생성(일반적으로 사용해야됨
	
	boolean addComment(CommentVO ct);			// 절대 생성 사용x
	
	
	// 모든 댓글 조회
	List<CommentVO> selectAllComments();		// 사용 x
	// 한 댓글 조회
	CommentVO selectOneComment(int id);			// 기본 pk조회
	
	// 특정 조건 댓글 조회
		// 해당 글에 소속된 댓글리스트 호출	(강의창에서 댓글리스트를 불러올떄 주로 사용)
	List<CommentVO> selectCommentsByAtId(int atId);			//글별 조회	 // 일단 보류
	
		// 작성 회원으로 조회	(통계 및 마이페이지용)
	List<CommentVO> selectCommentsByMbId(int mbId);			//작성자별 조회
		// 작성된 스키마로 분류 조회	(통계에 사용)
	List<CommentVO> selectCommentsByScheme(int cate);		//작성된 글 종류에 따른 조회

	List<CommentVO> selectCommentsForOrderNumAsc(int cate, int atId);		//해당글의 댓글을 order올림차순으로 정렬하여 댓글을 받는다.
	List<CommentVO> selectCommentsForOrderNumDesc(int cate, int atId);	//해당글의 댓글을 order내림차순으로 정렬하여 댓글을 받는다.

	List<CommentVO> searchCommentsByMbNic(String nicname);	// 작성회원 닉네임으로 검색         
	List<CommentVO> searchCommentsByMbId(int mbId); 		// 작성회원 id로 검색
	List<CommentVO> searchCommentsByArticle(int atId);		// 글id로 검색 (해당 댓글을 소유한 글id)
	List<CommentVO> searchCommentsByContent(String key);	// 댓글에 들어가는 내용 검색
	
	
	
	// 댓글 수정
	boolean updateOneComment(CommentVO ct);
	boolean updateOneComment(CommentVO ct, String content);
	
	// 댓글 삭제
	boolean deleteOneComment(int id);
	boolean deleteOneCommentByVO(CommentVO ct);
	
	
	// 기능들
		// 댓글 추가시 그 댓글의 아래에 있는 댓글들의 order증가
	boolean increaseOrderNumComments(List<CommentVO> ctList, int order);
	boolean increaseOrderNumComment(CommentVO ct);
	
	
}
