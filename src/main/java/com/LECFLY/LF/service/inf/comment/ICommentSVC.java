package com.LECFLY.LF.service.inf.comment;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Service;

import com.LECFLY.LF.model.vo.member.CommentVO;

/*
 	**********필독: 대댓글의 모체(부모)를 삭제하면 안됨! 원글/원댓글 삭제시 대댓글처리문제 미정되어 구현 안한 상태!!*************
 	
	-댓글 등록 시: addComment(int mbId, int tableCate, int atId, String comment, String mbNic, int targetCtId);
		ㄴ해당 댓글 등록 시 성공/실패값을 리턴함(1~4)
		
	-해당 게시글의 전체 댓글들 조회 시: List<CommentVO> selectCommentsForOrderNumAsc(int cate, int atId);
		ㄴ해당 게시글의 댓글들을 순서대로 리스트에 입력됨.
		  (order순으로 즉 페이지에 띄우는 가정하에 depth로만 판별하여 댓글 출력하면 됨)
		
	-해당 댓글 수정 시: boolean updateOneComment(int id, String content);
				 boolean updateOneComment(CommentVO ct);
		ㄴ해당 댓글을 수정 후 성공/실패를 리턴함.
		
	-해당 댓글 삭제 시: boolean deleteOneComment(int id);
		ㄴ성공/실패를 boolean으로 리턴함
		
	*아직 검색/통계를 위한 service는 미구현상태임
	
*	***********************************************
*/
@Service
public interface ICommentSVC {
	
	// 댓글 등록 시 성공/실패값들
	final int ADD_COMMENT_SUCCES = 1;	// 성공
	final int ADD_COMMENT_FAIL = 2;		// 댓글 추가 실패(DB오류)
	final int NONE_FIND_ATID = 3;		// 해당 글 없음
	final int FAIL_INCREASE = 4;		// order 증가 연산 실패
	
	// 댓글 등록		글쓴이번호	해당 글이 속한 테이블	해당 글		댓글 내용			글쓴이 닉네임	대댓글이면 해당 댓글의 id(VO에 속하지않은 인자)
	int addComment(int mbId, int tableCate, int atId, String comment, String mbNic, int targetCtId);
		// 기본 생성(일반적으로 사용해야됨
	
	boolean addComment(CommentVO ct);			// 절대 생성 /사용x
	
	
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
		// 해당 테이블의 해당 댓글의 댓글들 모두 조회(오름차순/내림차순)
	List<CommentVO> selectCommentsForOrderNumAsc(int cate, int atId);	//해당글의 댓글을 order올림차순으로 정렬하여 댓글을 받는다.
	List<CommentVO> selectCommentsForOrderNumDesc(int cate, int atId);	//해당글의 댓글을 order내림차순으로 정렬하여 댓글을 받는다.

	List<CommentVO> searchCommentsByMbNic(String nicname);	// 작성회원 닉네임으로 검색         
	List<CommentVO> searchCommentsByMbId(int mbId); 		// 작성회원 id로 검색
	List<CommentVO> searchCommentsByArticle(int atId);		// 글id로 검색 (해당 댓글을 소유한 글id)
	List<CommentVO> searchCommentsByContent(String key);	// 댓글에 들어가는 내용 검색
	
	
	
	// 댓글 수정
	boolean updateOneComment(int id, String content);
	boolean updateOneComment(CommentVO ct);
	
	// 댓글 삭제
	boolean deleteOneComment(int id);
	boolean deleteOneCommentByVO(CommentVO ct);
	
	
	// 기능들
		// 댓글 추가시 그 댓글의 아래에 있는 댓글들의 order증가
	boolean increaseOrderNumComments(List<CommentVO> ctList, int order);
	boolean increaseOrderNumComment(CommentVO ct);
		// 댓글 추가시 해당 댓글에 이미 같은 깊이의 대댓글이 있다면 그 댓글들의 숫자를 확인하여 그 값을 리턴
	int selectOneCommentByOrder(List<CommentVO> ctList, int orderNum, int depth);
	
	
}
