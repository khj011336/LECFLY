package com.LECFLY.LF.service.impl.cscenter;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LECFLY.LF.model.dao.inf.cscenter.IQnaCommentDAO;
import com.LECFLY.LF.model.vo.QnaCommentVO;
import com.LECFLY.LF.model.vo.QnaVO;
import com.LECFLY.LF.service.inf.cscenter.IQnaCommentSVC;


@Service
public class QnaCommentSVCImpl implements IQnaCommentSVC{
	@Autowired
	private IQnaCommentDAO qcDao;

	@Override
	public boolean commentAdd(QnaCommentVO qc) {
		if( qc == null || qc.getContent() == null || qc.getContent().isEmpty())
			return false;
		return qcDao.qnaCommentAdd(qc);
	}

	@Override
	public boolean commentAdd(String content, int qnaId, int mbId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<QnaCommentVO> commentList() {
		return qcDao.qnaCommentList();
	}

	@Override
	public List<QnaCommentVO> commentListForQna(int qnaId) {
		// TODO Auto-generated method stub
		return qcDao.qnaCommentListForQna(qnaId);
	}

	@Override
	public QnaCommentVO commentSelectOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean commentUpdate(QnaCommentVO qc) {
		// TODO Auto-generated method stub
		return this.qcDao.qnaCommentUpdate(qc);
	}

	@Override
	public boolean commentDelete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Integer[] checkNumberOfComments(List<QnaVO> qaList) {
		Integer[] cntComments = new Integer[qaList.size()];
		for(int i = 0; i < qaList.size(); i++) {
			int cntQC = this.checkNumberOfCommentsForQna(qaList.get(i).getId());
			cntComments[i] = cntQC;
		}
		return cntComments;
	}

	@Override
	public int checkNumberOfCommentsForQna(int qnaId) {
		return qcDao.checkNumberOfQnaCommentsForQna(qnaId);
	}

	@Override
	public int checkNumberOfCommentsForMember(int mbId) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}
