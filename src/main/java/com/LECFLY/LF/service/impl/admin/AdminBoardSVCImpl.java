package com.LECFLY.LF.service.impl.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LECFLY.LF.model.dao.inf.admin.IAdminBoardDAO;
import com.LECFLY.LF.model.vo.QnaCommentVO;
import com.LECFLY.LF.model.vo.admin.FaqVO;
import com.LECFLY.LF.model.vo.admin.NoticeVO;
import com.LECFLY.LF.model.vo.admin.QnaVO;
import com.LECFLY.LF.service.inf.admin.IAdminBoardSVC;

@Service
public class AdminBoardSVCImpl implements IAdminBoardSVC {

	@Autowired
	private IAdminBoardDAO abDao;
	
	@Override
	public boolean insertNewQna(QnaVO qa) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<QnaVO> selectOneQna(QnaVO qa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateQna(QnaVO qa) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteQna(QnaVO qa) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<QnaVO> showAllQnas(int offset, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int checkNumberOfQnas() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean insertNewFaq(FaqVO fq) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateFaq(FaqVO fq) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteFaq(FaqVO fq) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<FaqVO> showAllFaqs(int offset, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int checkNumberOfFaqs() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean insertNewNotice(NoticeVO nt) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<NoticeVO> selectOneNotice(NoticeVO nt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateNotice(NoticeVO nt) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteNotice(NoticeVO nt) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<NoticeVO> showAllNotices(int offset, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int checkNumberOfNotices() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean insertNewComment(QnaCommentVO cm) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateComment(QnaCommentVO cm) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteComment(QnaCommentVO cm) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<QnaCommentVO> showAllComments(int offset, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int checkNumberOfComments() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Integer> checkMaxPageNumberOfQna() {
		int totalRecords = abDao.checkNumberOfQnas();
		int maxPg = totalRecords / AD_PAGE_SIZE + (
				totalRecords % AD_PAGE_SIZE == 0 ? 0 : 1 );
		HashMap<String, Integer> rMap = new HashMap<>();
		rMap.put("totalRecords", totalRecords);
		rMap.put("maxPg", maxPg);
		return rMap;
	}

	@Override
	public List<QnaVO> selectAllQna(int pageNumber) {
		int offset = (pageNumber -1)*AD_PAGE_SIZE;
		List<QnaVO> qaList = abDao.showAllQnas(offset, AD_PAGE_SIZE);
		return qaList;
	}

	@Override
	public Map<String, Integer> checkMaxPageNumberOfFaq() {
		int totalRecords = abDao.checkNumberOfFaqs();
		int maxPg = totalRecords / AD_PAGE_SIZE + (
				totalRecords % AD_PAGE_SIZE == 0 ? 0 : 1 );
		HashMap<String, Integer> rMap = new HashMap<>();
		rMap.put("totalRecords", totalRecords);
		rMap.put("maxPg", maxPg);
		return rMap;
	}

	@Override
	public List<FaqVO> selectAllFaq(int pageNumber) {
		int offset = (pageNumber -1)*AD_PAGE_SIZE;
		List<FaqVO> fqList = abDao.showAllFaqs(offset, AD_PAGE_SIZE);
		return fqList;
	}

	@Override
	public Map<String, Integer> checkMaxPageNumberOfNotice() {
		int totalRecords = abDao.checkNumberOfNotices();
		int maxPg = totalRecords / AD_PAGE_SIZE + (
				totalRecords % AD_PAGE_SIZE == 0 ? 0 : 1 );
		HashMap<String, Integer> rMap = new HashMap<>();
		rMap.put("totalRecords", totalRecords);
		rMap.put("maxPg", maxPg);
		return rMap;
	}

	@Override
	public List<NoticeVO> selectAllNotice(int pageNumber) {
		int offset = (pageNumber -1)*AD_PAGE_SIZE;
		List<NoticeVO> ntList = abDao.showAllNotices(offset, AD_PAGE_SIZE);
		return ntList;
	}

	@Override
	public Map<String, Integer> checkMaxPageNumberOfComment() {
		int totalRecords = abDao.checkNumberOfComments();
		int maxPg = totalRecords / AD_PAGE_SIZE + (
				totalRecords % AD_PAGE_SIZE == 0 ? 0 : 1 );
		HashMap<String, Integer> rMap = new HashMap<>();
		rMap.put("totalRecords", totalRecords);
		rMap.put("maxPg", maxPg);
		return rMap;
	}

	@Override
	public List<QnaCommentVO> selectAllComment(int pageNumber) {
		int offset = (pageNumber -1)*AD_PAGE_SIZE;
		List<QnaCommentVO> qcList = abDao.showAllComments(offset, AD_PAGE_SIZE);
		return qcList;
	}

}
