package com.LECFLY.LF.service.inf.cscenter;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.LECFLY.LF.model.vo.cscenter.FaqVO;


public interface IFaqSVC {
	
	//게시글 리스트를 조회할 수 있다. (페이지네이션, 정렬, 태그)
	List<FaqVO> showAllFaqs();
	List<FaqVO> showAllFaqs(boolean order);
	public static final int PAGE_SIZE = 10; // psf public static final 생략
	List<FaqVO> showAllFaqs(int pn);
	int checkMaxPageNumber(); // 현재 최대 페이지 번호
	
	List<FaqVO> showFaqsForType(int type);
	List<FaqVO> showFaqsForType(int type, boolean order);
	List<FaqVO> showFaqsForType(int type, int pn);
	int checkMaxPageNumberForType(int type);
}
