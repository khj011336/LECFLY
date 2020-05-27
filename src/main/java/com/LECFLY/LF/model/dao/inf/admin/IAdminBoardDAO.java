package com.LECFLY.LF.model.dao.inf.admin;

import java.util.List;

import com.LECFLY.LF.model.vo.CommentClassVO;
import com.LECFLY.LF.model.vo.cscenter.FaqVO;
import com.LECFLY.LF.model.vo.cscenter.NoticeVO;
import com.LECFLY.LF.model.vo.cscenter.QnaCommentVO;
import com.LECFLY.LF.model.vo.cscenter.QnaVO;
import com.LECFLY.LF.model.vo.member.CommentVO;


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
	boolean insertNewComment(CommentVO cm);
	// comment를 편집 할 수 있다.
	boolean updateComment(CommentVO cm);
	// comment를 삭제 할 수 있다.
	boolean deleteComment(CommentVO cm);
	// comment를 전체 조회할수 있다.
	List<CommentVO> showAllComments(int offset, int limit);
	int checkNumberOfComments();
		
}
