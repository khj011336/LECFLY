package com.LECFLY.LF.service.impl.cscenter;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LECFLY.LF.model.dao.inf.cscenter.IFaqDAO;
import com.LECFLY.LF.model.vo.admin.FaqVO;
import com.LECFLY.LF.model.vo.admin.QnaVO;
import com.LECFLY.LF.service.inf.cscenter.IFaqSVC;



@Service
public class FaqSVCImpl implements IFaqSVC{
	@Autowired
	private IFaqDAO fqDao;

	@Override
	public List<FaqVO> showAllFaqs() {
		return fqDao.showAllFaqs();
	}

	@Override
	public List<FaqVO> showAllFaqs(boolean order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FaqVO> showAllFaqs(int pn) {
		int offset = (pn-1) * PAGE_SIZE;
		List<FaqVO>fqList = fqDao.showAllFaqs(offset, PAGE_SIZE);
		System.out.println("fqsvc: pn "+ pn +  " faq = " + fqList.size());
		return fqList;
	}

	@Override
	public int checkMaxPageNumber() {
		int totalRecords = fqDao.checkNumberOfFaqs();
		int maxPg = totalRecords / PAGE_SIZE + (totalRecords % PAGE_SIZE == 0 ? 0 : 1);
		return maxPg;
	}
	
	@Override
	public List<FaqVO> showFaqsForType(int type) {
		return fqDao.showAllFaqsForType(type);
	}
	
	@Override
	public List<FaqVO> showFaqsForType(int type, boolean order) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<FaqVO> showFaqsForType(int type, int pn) {
		int offset = (pn-1) * PAGE_SIZE;
		List<FaqVO>fqList = fqDao.showAllFaqsForType(type, offset, PAGE_SIZE);
		System.out.println("fqsvc: pn "+ pn +  " faq = " + fqList.size() +" type = " + type);
		return fqList;
	}
	
	@Override
	public int checkMaxPageNumberForType(int type) {
		int totalRecords = fqDao.checkNumberOfFaqsForType(type);
		int maxPg = totalRecords / PAGE_SIZE + (totalRecords % PAGE_SIZE == 0 ? 0 : 1);
		return maxPg;
	}
	
	
	
	
}
