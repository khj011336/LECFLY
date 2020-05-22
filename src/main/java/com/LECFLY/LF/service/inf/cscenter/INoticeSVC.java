package com.LECFLY.LF.service.inf.cscenter;

import java.util.List;

import com.LECFLY.LF.model.vo.admin.NoticeVO;



public interface INoticeSVC {
//	//신규 게시글을 등록 할 수 있다 (+파일업로드..)
//	boolean insertNewNotice(NoticeVO at);
//	boolean insertNewNotice(int mbId, int type, String title, String content);
//	boolean insertNewNotice(int mbId, int type, String title, String content, String file);
//	int insertNewNoticeReturnKey(int mbId, int type, String title, String content, String file);		
		
	//게시글 상세보기 할 수 있다
	NoticeVO selectOneNotice(int id);
		
//	//자신의 게시글을 편집 갱신 할 수 있다
//	boolean updateNotice(int id, int type, String title, String content);
//	boolean updateNotice(NoticeVO nt);
	boolean increaseReadCount(int id); // rc++
		
		
//	//자신의 게시글을 삭제 할 수 있다
//	boolean deleteNotice(int id);
		
	//게시글 리스트를 조회할 수 있다. (페이지네이션, 정렬, 태그)
	List<NoticeVO> showAllNotices();
	List<NoticeVO> showAllNotices(boolean order);
	public static final int PAGE_SIZE = 10; // psf public static final 생략
	List<NoticeVO> showAllNotices(int pn);
	
	int checkMaxPageNumber(); // 현재 최대 페이지 번호
		
	
}
