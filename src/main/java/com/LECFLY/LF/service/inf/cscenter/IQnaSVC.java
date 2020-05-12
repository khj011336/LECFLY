package com.LECFLY.LF.service.inf.cscenter;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.LECFLY.LF.model.vo.QnaVO;


public interface IQnaSVC {
	//회원이 신규 게시글을 등록 할 수 있다 (+파일업로드..)
	boolean insertNewQna(QnaVO at);
	boolean insertNewQna(int mbId, String mbNicname, int type, String title, String content, int showPrivate);
	boolean insertNewQna(int mbId, String mbNicname, int type, String title, String content, String file, int showPrivate);

	int insertNewQnaReturnKey(int mbId, String mbNicname, int type, String title, String content, String file, int showPrivate);		
		
	//게시글 상세보기 할 수 있다
	QnaVO selectOneQna(int id);
	Map<String, Object> selectOneQnaWithComments(int id);
	//회원이 자신의 게시글을 편집 갱신 할 수 있다
	boolean updateQna(int id, int type, String title, String content, int showPrivate);
	boolean updateQna(QnaVO qa);
	boolean increaseReadCount(int id); // rc++
		
		
	//회원이 자신의 게시글을 삭제 할 수 있다
	boolean deleteQna(int id);
		
	//게시글 리스트를 조회할 수 있다. (페이지네이션, 정렬, 태그)
	List<QnaVO> showAllQnas();
	List<Map<String, Object>> showAllQnasForMap(int pn);
	
	List<QnaVO> showAllQnas(boolean order);
	public static final int PAGE_SIZE = 10; // psf public static final 생략
	List<QnaVO> showAllQnas(int pn);
	
	int checkMaxPageNumber(); // 현재 최대 페이지 번호
		
	
}
