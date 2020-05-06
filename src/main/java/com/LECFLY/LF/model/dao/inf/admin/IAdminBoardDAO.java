package com.LECFLY.LF.model.dao.inf.admin;

import java.util.List;

import com.LECFLY.LF.model.vo.CommentClassVO;
import com.LECFLY.LF.model.vo.FaqVO;
import com.LECFLY.LF.model.vo.NoticeVO;
import com.LECFLY.LF.model.vo.QnaCommentVO;
import com.LECFLY.LF.model.vo.QnaVO;


public interface IAdminBoardDAO {
	// QnA 게시판 관리
	
	// 게시글을 등록할 수 있다.
	boolean insertNewQna(QnaVO qa);
	// 게시글 상세보기를 할 수 있다.
	List<QnaVO> selectOneQna(QnaVO qa);
	// 게시글을 편집 할 수 있다.
	boolean updateQna(QnaVO qa);
	// 게시글을 삭제 할 수 있다.
	boolean deleteQna(QnaVO qa);
	// 게시글을 전체 조회할수 있다.
	List<QnaVO> showAllQnas(int offset, int limit);
	int checkNumberOfQnas();
	// 게시글에 답변을 남길 수 있다.
	boolean insertNewComment(QnaCommentVO QC);
	
	
	// FAQ 게시판 관리
	
	// 게시글을 등록할 수 있다.
	boolean insertNewQna(FaqVO fq);
	// 게시글을 편집 할 수 있다.
	boolean updateFaq(FaqVO fq);
	// 게시글을 삭제 할 수 있다.
	boolean deleteFaq(FaqVO fq);
	// 게시글을 전체 조회할수 있다.
	List<FaqVO> showAllFaqs(int offset, int limit);
	int checkNumberOfFaqs();
	
	
	// Notice 게시판 관리
	
	// 게시글을 등록할 수 있다.
	boolean insertNewNotice(NoticeVO nt);
	// 게시글 상세보기를 할 수 있다.
	List<NoticeVO> selectOneNotice(NoticeVO nt);
	// 게시글을 편집 할 수 있다.
	boolean updateNotice(NoticeVO nt);
	// 게시글을 삭제 할 수 있다.
	boolean deleteNotice(NoticeVO nt);
	// 게시글을 전체 조회할수 있다.
	List<NoticeVO> showAllNotices(int offset, int limit);
	int checkNumberOfNotices();
	
	
	// COMMENT 게시판 관리
	
	// comment를 등록할 수 있다.
	boolean insertNewComment(CommentClassVO cm);
	// comment를 편집 할 수 있다.
	boolean updateComment(CommentClassVO cm);
	// comment를 삭제 할 수 있다.
	boolean deleteComment(CommentClassVO cm);
	// comment를 전체 조회할수 있다.
	List<CommentClassVO> showAllComments(int offset, int limit);
	int checkNumberOfComments();
		
}
