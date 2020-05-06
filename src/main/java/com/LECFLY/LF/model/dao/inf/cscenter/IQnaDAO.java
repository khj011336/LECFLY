package com.LECFLY.LF.model.dao.inf.cscenter;

import java.util.List;

import com.LECFLY.LF.model.vo.QnaVO;

public interface IQnaDAO {
	//	회원이 신규 게시글을 등록 할 수 있다 (+파일업로드..)
	boolean insertNewQna(QnaVO qa);
	int insertNewQnaReturnKey(QnaVO qa);
	int insertNewQnaReturnKey2(QnaVO qa);
	
	boolean insertNewQna(int mbId, String mbNicname, int type, String title, String content,
			int showPrivate);
	
	//게시글 상세보기 할 수 있다 (+ 조회수 증가)
	QnaVO selectOneQna(int id);
	
	//회원이 자신의 게시글을 편집 갱신 할 수 있다
	boolean updateQna(int id, int type, String title, String content, int showPrivate);
	boolean increaseReadCount(int id); // rc++
	
	//회원이 자신의 게시글을 삭제 할 수 있다
	boolean deleteQna(int id);
	
	//게시글을 조회할 수 있다. (페이지네이션, 정렬)
	
	List<QnaVO> showAllQnas();
	List<QnaVO> showAllQnas(boolean order);	
	List<QnaVO> showAllQnas(int offset, int limit);
	List<QnaVO> showAllQnas(int offset, int limit, boolean order);
	int checkNumberOfQnas();

	
	
	
	
}
