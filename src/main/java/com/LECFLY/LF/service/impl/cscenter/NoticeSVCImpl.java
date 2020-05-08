package com.LECFLY.LF.service.impl.cscenter;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LECFLY.LF.model.dao.inf.cscenter.INoticeDAO;
import com.LECFLY.LF.model.vo.NoticeVO;
import com.LECFLY.LF.service.inf.cscenter.INoticeSVC;

@Service
public class NoticeSVCImpl implements INoticeSVC{
	@Autowired
	private INoticeDAO ntDao;
	
	@Override
	public boolean insertNewNotice(NoticeVO nt) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertNewNotice(int mbId, int type, String title, String content) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertNewNotice(int mbId, int type, String title, String content, String file) {
		NoticeVO nt = new NoticeVO(mbId, type, title, content, file);
		return ntDao.insertNewNotice(nt);
	}

	@Override
	public int insertNewNoticeReturnKey(int mbId, int type, String title, String content, String file) {
		NoticeVO nt = new NoticeVO(mbId, type, title, content, file);
		return ntDao.insertNewNoticeReturnKey(nt);
	}

	@Override
	public NoticeVO selectOneNotice(int id) {
		NoticeVO nt = ntDao.selectOneNotice(id);
		if( nt != null ) {
			if(ntDao.increaseReadCount(id))
				return nt;
		}
		return nt;
	}

	@Override
	public boolean updateNotice(int id, int type, String title, String content) {
		return ntDao.updateNotice(id, type, title, content);
	}
	
	
	@Override
	public boolean increaseReadCount(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteNotice(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<NoticeVO> showAllNotices() {
		return ntDao.showAllNotices();
	}

	@Override
	public List<NoticeVO> showAllNotices(boolean order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NoticeVO> showAllNotices(int pn) {
		int offset = (pn-1) * PAGE_SIZE;
		List<NoticeVO>ntList = ntDao.showAllNotices(offset, PAGE_SIZE);
		System.out.println("ntsvc: pn "+ pn +  " notice = " + ntList.size());
		return ntList;
	}

	@Override
	public int checkMaxPageNumber() {
		int totalRecords = ntDao.checkNumberOfNotices();
		int maxPg = totalRecords / PAGE_SIZE + (totalRecords % PAGE_SIZE == 0 ? 0 : 1);
		return maxPg;
	}

	@Override
	public boolean updateNotice(NoticeVO nt) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
