package com.LECFLY.LF.service.impl.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LECFLY.LF.model.dao.inf.admin.IAdminBoardDAO;
import com.LECFLY.LF.model.vo.CommentClassVO;
import com.LECFLY.LF.model.vo.FaqVO;
import com.LECFLY.LF.model.vo.NoticeVO;
import com.LECFLY.LF.model.vo.QnaCommentVO;
import com.LECFLY.LF.model.vo.QnaVO;
import com.LECFLY.LF.service.inf.admin.IAdminBoardSVC;

@Service
public class AdminBoardSVCImpl implements IAdminBoardSVC {

	@Autowired
	private IAdminBoardDAO bdDao;
	
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
	public boolean insertNewComment(QnaCommentVO QC) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertNewQna(FaqVO fq) {
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
	public boolean insertNewComment(CommentClassVO cm) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateComment(CommentClassVO cm) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteComment(CommentClassVO cm) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<CommentClassVO> showAllComments(int offset, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int checkNumberOfComments() {
		// TODO Auto-generated method stub
		return 0;
	}

}
