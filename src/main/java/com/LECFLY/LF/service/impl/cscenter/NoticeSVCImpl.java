package com.LECFLY.LF.service.impl.cscenter;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LECFLY.LF.model.dao.inf.cscenter.IQnaDAO;
import com.LECFLY.LF.model.vo.QnaVO;
import com.LECFLY.LF.service.inf.cscenter.IQnaSVC;

@Service
public class NoticeSVCImpl implements IQnaSVC{
	@Autowired
	private IQnaDAO qaDao;
	
	@Override
	public boolean insertNewQna(QnaVO qa) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertNewQna(int mbId, String mbNicname, int type, String title, String content, int showPrivate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertNewQna(int mbId, String mbNicname, int type, String title, String content, String file,
			int showPrivate) {
		QnaVO qa = new QnaVO(mbId, mbNicname, type, title, content, file, showPrivate);
		return qaDao.insertNewQna(qa);
	}

	@Override
	public int insertNewQnaReturnKey(int mbId, String mbNicname, int type, String title, String content, String file,
			int showPrivate) {
		QnaVO qa = new QnaVO(mbId, mbNicname, type, title, content, file, showPrivate);
		return qaDao.insertNewQnaReturnKey(qa);
	}

	@Override
	public QnaVO selectOneQna(int id) {
		QnaVO qa = qaDao.selectOneQna(id);
		if( qa != null ) {
			if(qaDao.increaseReadCount(id))
				return qa;
		}
		return qa;
	}

	@Override
	public boolean updateQna(int id, int type, String title, String content, int showPrivate) {
		return qaDao.updateQna(id, type, title, content, showPrivate);
	}
	
	
	@Override
	public boolean increaseReadCount(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteQna(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<QnaVO> showAllQnas() {
		return qaDao.showAllQnas();
	}

	@Override
	public List<QnaVO> showAllQnas(boolean order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<QnaVO> showAllQnas(int pn) {
		int offset = (pn-1) * PAGE_SIZE;
		List<QnaVO>qaList = qaDao.showAllQnas(offset, PAGE_SIZE);
		System.out.println("qasvc: pn "+ pn +  " qna = " + qaList.size());
		return qaList;
	}

	@Override
	public int checkMaxPageNumber() {
		int totalRecords = qaDao.checkNumberOfQnas();
		int maxPg = totalRecords / PAGE_SIZE + (totalRecords % PAGE_SIZE == 0 ? 0 : 1);
		return maxPg;
	}

	@Override
	public boolean updateQna(QnaVO qa) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
