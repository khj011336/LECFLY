package com.LECFLY.LF.model.dao.impl.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.LECFLY.LF.model.dao.inf.admin.IAdminMemberDAO;
import com.LECFLY.LF.model.vo.MemberVO;
import com.LECFLY.LF.model.vo.creator.CreatorVO;
import com.LECFLY.LF.model.vo.creator.LectureVO;

@Repository
public class AdminMemberMysqlDAO implements IAdminMemberDAO {
	
	@Autowired
	private JdbcTemplate jtem;
	
	// SQL 명령어
	/** 전체 회원목록 조회 */
	public static String SQL_ADMIN_MEMBER_SELECT_ALL = 
			"SELECT * FROM MEMBERS";
	/** 회원 상세 조회 */
	public static String SQL_ADMIN_MEMBER_SELECT_ONE = 
			"SELECT * FROM MEMBERS WHERE ID = ?";
	/** 회원 크리에이터 승인 */
	public static String SQL_ADMIN_MEMBER_UPDATE = 
			"UPDATE MEMBERS SET CHECK_CREATOR = ? WHERE ID = ?";
	/** 회원 등록 */
	public static String SQL_ADMIN_MEMBER_INSERT = 
			"INSERT INTO MEMBERS VALUES()";
	/** 회원 삭제 */
	public static String SQL_ADMIN_MEMBER_DELETE = 
			"DELETE FROM MEMBERS WHERE ID = ?";
	/** 전체 멤버 중 크리에이터 목록 조회 */
	public static String SQL_ADMIN_MB_CREATOR_SELECT_ALL = 
			"SELECT * FROM MEMBERS WHERE CHECK_CREATOR = 3";
	/** 전체 멤버 중 크리에이터 신청 상태 조회 */
	public static String SQL_ADMIN_REGI_CREATOR_SELECT_ = 
			"SELECT * FROM MEMBERS WHERE CHECK_CREATOR = ?";
	
	/** 멤버 중 크리에이터 목록 상세 조회 */
	public static String SQL_ADMIN_MB_CREATOR_SELECT_ONE = 
			"SELECT * FROM MEMBERS WHERE CHECK_CREATOR = 3 AND ID = ?";
	/** 크리에이터 전체목록 조회 */
	public static String SQL_ADMIN_CREATOR_SELECT_ALL = 
			"SELECT * FROM MEMBERS WHERE ID = ?";
	/** 크리에이터 목록 업데이트 */
	public static String SQL_ADMIN_CREATOR_UPDATE = 
			"UPDATE CREATOR SET WHERE ID = ?";
	/** 크리에이터 등록 */
	public static String SQL_ADMIN_CREATOR_INSERT = 
			"INSERT INTO CREATOR VALUES()";
	/** 크리에이터 삭제 */
	public static String SQL_ADMIN_CREATOR_DELETE = 
			"DELETE FROM CREATOR WHERE ID = ?";
	
	/** 전체 멤버수 조회 */
	public static String SQL_SELECT_MEMBER_NUMBER = 
			"SELECT COUNT(ID) FROM MEMBERS";
	/** 전체 멤버목록 조회(페이지별) */
	public static String SQL_SELECT_MEMBER_ALL_PG = 
			"SELECT * FROM MEMBERS ORDER BY ID DESC LIMIT ?,?";

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
	public MemberVO selectNomalMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberVO> selectNomalMemberList() {
		return jtem.query(SQL_ADMIN_MEMBER_SELECT_ALL, BeanPropertyRowMapper.newInstance(MemberVO.class));
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
	public int checkNumberOfMembers() {
		return jtem.queryForObject(SQL_SELECT_MEMBER_NUMBER, Integer.class);
	}

	@Override
	public List<MemberVO> searchMemberForAll(int offset, int limit) {
		return jtem.query(SQL_SELECT_MEMBER_ALL_PG, BeanPropertyRowMapper.newInstance(MemberVO.class),
				offset, limit);
	}
	
}


