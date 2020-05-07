package com.LECFLY.LF.model.dao.inf.cscenter;

import java.util.List;

import com.LECFLY.LF.model.vo.NoticeVO;

public interface INoticeDAO {
	// 관리자가 신규 게시글을 등록 할 수 있다 (+파일업로드..)
	boolean insertNewNotice(NoticeVO nt);
	int insertNewNoticeReturnKey(NoticeVO nt);
	int insertNewNoticeReturnKey2(NoticeVO nt);
	boolean insertNewNotice(int type, String title, String content, String file);
	
	// 게시글 상세보기 할 수 있다 (+ 조회수 증가)
	NoticeVO selectOneNotice(int id);
	
	// 관리자가 게시글을 편집 갱신 할 수 있다
	boolean updateNotice(int type, String title, String content, String file);
	boolean increaseReadCount(int id); // rc++
	
	// 관리자가 게시글을 삭제 할 수 있다
	boolean deleteNotice(int id);
	
	//게시글을 조회할 수 있다. (페이지네이션, 정렬)
	
	List<NoticeVO> showAllNotices();
	List<NoticeVO> showAllNotices(boolean order);	
	List<NoticeVO> showAllNotices(int offset, int limit);
	List<NoticeVO> showAllNotices(int offset, int limit, boolean order);
	int checkNumberOfNotices();

}
