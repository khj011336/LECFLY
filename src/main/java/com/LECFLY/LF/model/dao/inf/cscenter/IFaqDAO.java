package com.LECFLY.LF.model.dao.inf.cscenter;

import java.util.List;

import com.LECFLY.LF.model.vo.FaqVO;


public interface IFaqDAO {
	// 관리자가 신규 게시글을 등록 할 수 있다 (+파일업로드..)
	boolean insertNewFaq(FaqVO fq);
	int insertNewFaqReturnKey(FaqVO fq);
	int insertNewFaqReturnKey2(FaqVO fq);
	boolean insertNewFaq(int type, String title, String content);
	
	// 관리자가 게시글을 편집 갱신 할 수 있다
	boolean updateFaq(int type, String title, String content);
	
	// 관리자가 게시글을 삭제 할 수 있다
	boolean deleteFaq(int id);
	
	//게시글을 조회할 수 있다. (페이지네이션, 정렬)
	List<FaqVO> showAllFaqs();
	List<FaqVO> showAllFaqs(boolean order);	
	List<FaqVO> showAllFaqs(int offset, int limit);
	List<FaqVO> showAllFaqs(int offset, int limit, boolean order);
	int checkNumberOfFaqs();

}
