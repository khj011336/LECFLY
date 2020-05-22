package com.LECFLY.LF.service.inf.admin;

import java.util.List;
import java.util.Map;

import com.LECFLY.LF.model.vo.CommentClassVO;
import com.LECFLY.LF.model.vo.cscenter.FaqVO;
import com.LECFLY.LF.model.vo.cscenter.NoticeVO;
import com.LECFLY.LF.model.vo.cscenter.QnaCommentVO;
import com.LECFLY.LF.model.vo.cscenter.QnaVO;

public interface IAdminBoardSVC {
	public static int AD_PAGE_SIZE = 30;
	
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
	
	Map<String, Integer> checkMaxPageNumberOfQna();
	List<QnaVO> selectAllQna(int pageNumber);
	
	
	
	// FAQ 게시판 관리
	
	// 게시글을 등록할 수 있다.
	boolean insertNewFaq(FaqVO fq);
	// 게시글을 편집 할 수 있다.
	boolean updateFaq(FaqVO fq);
	// 게시글을 삭제 할 수 있다.
	boolean deleteFaq(FaqVO fq);
	// 게시글을 전체 조회할수 있다.
	List<FaqVO> showAllFaqs(int offset, int limit);
	int checkNumberOfFaqs();
	
	Map<String, Integer> checkMaxPageNumberOfFaq();
	List<FaqVO> selectAllFaq(int pageNumber);
	
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
	
	Map<String, Integer> checkMaxPageNumberOfNotice();
	List<NoticeVO> selectAllNotice(int pageNumber);
	
	// COMMENT 게시판 관리
	
	// comment를 등록할 수 있다.
	boolean insertNewComment(QnaCommentVO cm);
	// comment를 편집 할 수 있다.
	boolean updateComment(QnaCommentVO cm);
	// comment를 삭제 할 수 있다.
	boolean deleteComment(QnaCommentVO cm);
	// comment를 전체 조회할수 있다.
	List<QnaCommentVO> showAllComments(int offset, int limit);
	int checkNumberOfComments();
	
	Map<String, Integer> checkMaxPageNumberOfComment();
	List<QnaCommentVO> selectAllComment(int pageNumber);
	
}
