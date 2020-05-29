package com.LECFLY.LF.service.impl.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LECFLY.LF.model.dao.inf.admin.IAdminMemberDAO;
import com.LECFLY.LF.model.vo.creator.CreatorVO;
import com.LECFLY.LF.model.vo.member.MemberVO;
import com.LECFLY.LF.model.vo.virtual.MemberStatVO;
import com.LECFLY.LF.service.inf.admin.IAdminMemberSVC;

@Service
public class AdminMemberSVCImpl implements IAdminMemberSVC {

	@Autowired
	private IAdminMemberDAO amDao;
	
	@Override
	public boolean insertNomalMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateNomalMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteNomalMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MemberVO selectNomalMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberVO> selectNomalMemberList() {
		return amDao.selectNomalMemberList();
	}

	@Override
	public boolean insertCreatorMember(CreatorVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCreatorMember(CreatorVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCreatorMember(CreatorVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CreatorVO selectCreatorMember(CreatorVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CreatorVO> selectCreatorMemberList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Integer> checkMaxPageNumber() {
		int totalRecords = amDao.checkNumberOfMembers();
		int maxPg = totalRecords / AD_PAGE_SIZE + (
				totalRecords % AD_PAGE_SIZE == 0 ? 0 : 1 );
		HashMap<String,Integer> rMap = new HashMap<>();
		rMap.put("totalRecords", totalRecords);
		rMap.put("maxPg", maxPg);
		return rMap;
	}
	
	@Override
	public Map<String, Integer> checkMaxPageNumberForCreator() {
		int totalRecords = amDao.checkNumberOfCreators();
		int maxPg = totalRecords / AD_PAGE_SIZE + (
				totalRecords % AD_PAGE_SIZE == 0 ? 0 : 1 );
		HashMap<String,Integer> rMap = new HashMap<>();
		rMap.put("totalRecords", totalRecords);
		rMap.put("maxPg", maxPg);
		return rMap;
	}

	@Override
	public List<MemberVO> selectAllMember(int pageNumber) {
		int offset = (pageNumber -1)*AD_PAGE_SIZE;
		List<MemberVO> mbList = amDao.searchMemberForAll(offset, AD_PAGE_SIZE);
		return mbList;
	}

	@Override
	public List<CreatorVO> selectAllCreator(int pageNumber) {
		int offset = (pageNumber -1)*AD_PAGE_SIZE;
		List<CreatorVO> crList = amDao.searchCreatorForAll(offset, AD_PAGE_SIZE);
		return crList;
	}

	@Override
	public List<MemberStatVO> statCountMemberByMonth() {
		return amDao.statCountMemberByMonth();
	}

	@Override
	public List<MemberVO> selectAllMemberByApproval(int pageNumber) {
		int offset = (pageNumber -1)*AD_PAGE_SIZE;
		List<MemberVO> mbList = amDao.searchMemberForAllByApproval(offset, AD_PAGE_SIZE);
		return mbList;
	}

	@Override
	public List<MemberVO> selectAllMemberByApprovalDone(int pageNumber) {
		int offset = (pageNumber -1)*AD_PAGE_SIZE;
		List<MemberVO> mbList = amDao.searchMemberForAllByApprovalDone(offset, AD_PAGE_SIZE);
		return mbList;
	}

	@Override
	public List<MemberVO> selectAllMemberByNew(int pageNumber) {
		int offset = (pageNumber -1)*AD_PAGE_SIZE;
		List<MemberVO> mbList = amDao.searchMemberForAllByNew(offset, AD_PAGE_SIZE);
		return mbList;
	}

}
