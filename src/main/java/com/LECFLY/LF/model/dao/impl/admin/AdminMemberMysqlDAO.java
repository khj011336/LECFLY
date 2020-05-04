package com.LECFLY.LF.model.dao.impl.admin;

import java.util.List;

import com.LECFLY.LF.model.dao.inf.admin.IAdminMemberDAO;
import com.LECFLY.LF.model.vo.MemberVO;
import com.LECFLY.LF.model.vo.creator.CreatorVO;

public class AdminMemberMysqlDAO implements IAdminMemberDAO {
	
//	public static final String SQL_ADMIN_MEMBER_SELECT_SHOW = 
//		"select * from member where 1=1";
//	
//	public String makeSearchQuery(String searchString, String item, String personid) {
//		String whereQuery = "";
//		if(searchString != null || !searchString.equals("") ) {
//			whereQuery += "and"+ item +"like '%"+searchString+"%'";
//		}
//		if(personid != null || !personid.equals("")) {
//			whereQuery += "and personid = "+personid+"";
//		}
//		return whereQuery;
//	}

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
	public List<MemberVO> selectNomalMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberVO> selectNomalMemberList(MemberVO vo) {
		// TODO Auto-generated method stub
		return null;
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
	public List<CreatorVO> selectCreatorMember(CreatorVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CreatorVO> selectCreatorMemberList(CreatorVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	
}


