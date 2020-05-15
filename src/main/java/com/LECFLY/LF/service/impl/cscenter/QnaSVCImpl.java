package com.LECFLY.LF.service.impl.cscenter;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LECFLY.LF.model.dao.inf.cscenter.IQnaCommentDAO;
import com.LECFLY.LF.model.dao.inf.cscenter.IQnaDAO;
import com.LECFLY.LF.model.vo.QnaCommentVO;
import com.LECFLY.LF.model.vo.QnaVO;
import com.LECFLY.LF.service.inf.cscenter.IQnaSVC;


@Service
public class QnaSVCImpl implements IQnaSVC{
	@Autowired
	private IQnaDAO qaDao;
	@Autowired
	private IQnaCommentDAO qcDao;
	
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
	public Map<String,Object> selectOneQnaWithComments(int id) {
		QnaVO qa = qaDao.selectOneQna(id);
		if( qa != null ) {
			List<QnaCommentVO> qcList = qcDao.qnaCommentListForQna(qa.getId());			
			if( !qaDao.increaseReadCount(id) )
				System.out.println("조회수 증가 실패! "+id);
			HashMap<String, Object> rMap = new HashMap<String, Object>();
			rMap.put("qa", qa);
			rMap.put("qcList", qcList);
			return rMap;
		}
		return null;
	}
	
	@Override
	public boolean updateQna(int id, String title, String content, int showPrivate) {
		System.out.println("svcimpl test : "+ id+title+content+showPrivate);
		return qaDao.updateQna(id, title, content, showPrivate);
	}
	
	
	@Override
	public boolean increaseReadCount(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteQna(int id) {
		return qaDao.deleteQna(id);
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
	public List<Map<String, Object>> showAllQnasForMap(int pn) {
		int offset = (pn-1) * PAGE_SIZE;
		List<Map<String, Object>> qaMapList = qaDao.showAllQnasForMap(offset, PAGE_SIZE);
		System.out.println("qasvc: pn "+ pn +  " qnas for Map = " + qaMapList.size());
		return qaMapList;
	}
	
	@Override
	public int checkMaxPageNumber() {
		int totalRecords = qaDao.checkNumberOfQnas();
		int maxPg = totalRecords / PAGE_SIZE + (totalRecords % PAGE_SIZE == 0 ? 0 : 1);
		return maxPg;
	}
	
	@Override
	public int checkPageNumber(int qaid) {
		int totalRecords = qaDao.checkNumberOfQnas();
			return ((totalRecords - qaid) / PAGE_SIZE)+1;
//		int maxPg = totalRecords / PAGE_SIZE + (totalRecords % PAGE_SIZE == 0 ? 0 : 1);
//		int endPgRecords = totalRecords -(totalRecords / PAGE_SIZE );
//		if( qaid <= endPgRecords) {
//			return maxPg;
//		}else {
//			return qaid / PAGE_SIZE;
//		}
	}

	@Override
	public boolean updateQna(QnaVO qa) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	
}
