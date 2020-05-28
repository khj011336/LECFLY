package com.LECFLY.LF.model.dao.impl.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.LECFLY.LF.model.dao.inf.admin.IAdminSiteDAO;
import com.LECFLY.LF.model.vo.admin.HomeFileManagerVO;
import com.LECFLY.LF.model.vo.creator.LectureVO;

@Repository
public class AdminSiteMysqlDAOImpl implements IAdminSiteDAO {
	
	@Autowired
	private JdbcTemplate jtem;
	
	// SQL 명령어
	// 메인배너 관련 FILE_DISPLAY_ON = 1
	/** 전체 배너목록 조회 */
	public static String SQL_ADMIN_SITE_SELECT_BANNER_ALL = 
			"SELECT * FROM HOME_FILE_MANAGER WHERE FILE_DISPLAY_ON = 1";
	/** 배너 상세 조회 */
	public static String SQL_ADMIN_SITE_SELECT_BANNER_ONE = 
			"SELECT * FROM HOME_FILE_MANAGER WHERE FILE_DISPLAY_ON = 1 AND ID = ?";
	/** 배너이미지 삭제 */
	public static String SQL_ADMIN_SITE_DELETE_BANNER = 
			"DELETE FROM HOME_FILE_MANAGER WHERE FILE_DISPLAY_ON = 1 AND ID = ?";
	/** 배너이미지 수정 */
	public static String SQL_ADMIN_SITE_UPDATE_BANNER = 
			"UPDATE HOME_FILE_MANAGER SET FILE_DISPLAY_NUM = ?, FILE_LECTURE_ID = ?, FILE_NAME=?,"
			+ "FILE_PATH=?, FILE_SIZE=?, UPDATED_DATE = NOW() "
			+ "WHERE FILE_DISPLAY_ON = 1 AND ID= ?";
	/** 전시배너 위치 지정(0~6) */
	public static String SQL_ADMIN_SITE_DISPLAY_BANNER =
			"UPDATE HOME_FILE_MANAGER SET FILE_DISPLAY_NUM = ? WHERE FILE_DISPLAY_ON = 1 AND ID=?";
	/** 전시 배너 등록 */
	public static String SQL_ADMIN_SITE_INSERT_BANNER = 
			"INSERT INTO home_file_manager VALUES (NULL,1,?,?,?,?,?,NOW())";
	
	// 추천강의 관련 FILE_DISPLAY_ON = 2
	/** 전체 추천 강의목록 조회 */
	public static String SQL_ADMIN_SITE_SELECT_RECOMMEND_LEC_ALL =
			"SELECT * FROM HOME_FILE_MANAGER WHERE FILE_DISPLAY_ON = 2";
	/** 전체 추천 강의목록의 id 조회 */
	public static String SQL_ADMIN_SITE_GET_RECOMMEND_IDS =
			"SELECT file_lecture_id FROM HOME_FILE_MANAGER WHERE FILE_DISPLAY_ON = 2";
	/** 추천 강의목록의 id로 lecture 조회 */
	public static String SQL_ADMIN_SITE_SELECT_RECOlIST_BY_IDS =
			"SELECT * FROM LECTURES WHERE FID ";
	/** 추천 강의목록 수정 */
	public static String SQL_ADMIN_SITE_UPDATE_RECOMMEND_LEC =
			"UPDATE HOME_FILE_MANAGER SET FILE_DISPLAY_NUM = ?, FILE_LECTURE_ID = ?, FILE_NAME=?, "
			+ "FILE_PATH=?, FILE_SIZE=?, UPDATED_DATE = NOW() WHERE FILE_DISPLAY_ON = 2 AND ID = ?";
	/** 추천 강의로 등록 */
	public static String SQL_ADMIN_SITE_INSERT_RECOMMEND_LEC =
			"INSERT INTO HOME_FILE_MANAGER VALUES()";
	
	// 일반강의 관련
	/** 전체 일반 강의목록 조회_최신순 */
	public static String SQL_ADMIN_SITE_SELECT_NOMAL_LEC_ALL = 
			"SELECT * FROM LECTURES WHERE STATUS = 3 ORDER BY ID DESC";
	
	// 검색 관련
	/** 카테고리별 강의 검색  */
	public static String SQL_ADMIN_SELECT_LECTURE_FOR_CATEGORY =
			"SELECT * FROM LECTURES WHERE CATEGORY = ? ORDER BY CREATED_AT DESC";
	/** 키워드별 강의 검색 */
	public static String SQL_ADMIN_SEARCH_ANYCOLULM = 
			"SELECT * FROM LECTURES WHERE TITLE LIKE concat('%%',?,'%%') OR SUBTITLE LIKE concat('%%',?,'%%') OR NICKNAME LIKE concat('%%',?,'%%')";
	
	// 관리자 계정 관련
	/** 관리자 계정 생성 */
	public static String SQL_ADMIN_SITE_INSERT_ACCOUNT =
			"INSERT INTO MEMBERS VALUES(NULL, '', ?,?,NOW(),3,?,?,?,NOW(),0,0,0,0,NULL,'','',0,'','') ";
	/** 관리자 계정 수정 */
	public static String SQL_ADMIN_SITE_UPDATE_ACCOUNT =
			"UPDATE MEMBERS SET NICNAME = ?, EMAIL = ?, PH_NUMBER=? WHERE GENDER = 3 AND ID = ? ";
	/** 관리자 계정 삭제 */
	public static String SQL_ADMIN_SITE_DELETE_ACCOUNT =
			"DELECT FROM MEMBERS WHERE GENDER = 3 AND ID = ? ";
	/** 관리자 계정 조회 */
	public static String SQL_ADMIN_SITE_SELECT_ACCOUNT_ONE =
			"SELECT * FROM MEMBERS WHERE GETNDER = 3 AND ID = ?";
	/** 관리자 계정 목록 조회 */
	public static String SQL_ADMIN_SITE_SELECT_ACCOUNT_ALL =
			"SELECT * FROM MEMBERS WHERE GERDER = 3";
	
	// 메인 관련 기능
	/** 좋아요 버튼 클릭 강의테이블에 반영 */
	public static String SQL_UPDATE_LECTURE_LIKE = 
			"UPDATE LECTURES SET LIKE_COUNT = LIKE_COUNT +1 WHERE FID = ? ";
	/** 좋아요 취소 강의 테이블에 반영 */
	public static String SQL_UPDATE_LECTURE_DISLIKE = 
			"UPDATE LECTURES SET LIKE_COUNT = LIKE_COUNT -1 WHERE FID = ? ";
	/** 좋아요 목록 테이블에 추가 */
	public static String SQL_INSERT_lIKECLASS_ID = 
			"INSERT INTO LIKE_CLASS VALUES(NULL,?,?,NOW())";
	/** 좋아요 목록 테이블에서 삭제 */
	public static String SQL_DELETE_lIKECLASS_ID = 
			"DELETE FROM LIKE_CLASS WHERE ID = ? AND MB_ID = ? ";
	/** 좋아요 목록 테이블 조회 */
	public static String SQL_SELECE_LIKE_ALL = 
			"SELECT CLASS_ID FROM LIKE_CLASS WHERE MB_ID = ?";
	
	
	@Override
	public boolean insertBanner(HomeFileManagerVO vo) {
//		System.out.println("dao insert 시작");
//		System.out.println(vo.toString());
		int r = jtem.update(SQL_ADMIN_SITE_INSERT_BANNER, 
				vo.getFileDisplayNum(), vo.getFileLectureId(), vo.getFileName(), vo.getFilePath(), vo.getFileSize());
		return r == 1;
	}

	@Override
	public boolean updateBanner(HomeFileManagerVO vo) {
		int r = jtem.update(SQL_ADMIN_SITE_UPDATE_BANNER, vo.getFileDisplayNum(), vo.getFileLectureId(), vo.getFileName(), vo.getFilePath(), vo.getFileSize(), vo.getId());
		return r == 1;
	}

	@Override
	public boolean deleteBanner(HomeFileManagerVO vo) {
		int r = jtem.update(SQL_ADMIN_SITE_DELETE_BANNER, vo.getId());
		return r == 1;
	}

	@Override
	public HomeFileManagerVO selectBanner(HomeFileManagerVO vo) {
		try {
			HomeFileManagerVO banner 
			= jtem.queryForObject(SQL_ADMIN_SITE_SELECT_BANNER_ONE, BeanPropertyRowMapper.newInstance(HomeFileManagerVO.class), vo.getId());
			return banner;
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch (DataAccessException e) {
			return null;
		}
	}

	@Override
	public List<HomeFileManagerVO> selectBannerList() {
		List<HomeFileManagerVO> bannerList 
		= jtem.query(SQL_ADMIN_SITE_SELECT_BANNER_ALL, BeanPropertyRowMapper.newInstance(HomeFileManagerVO.class));
		return bannerList;
	}
	
	public boolean changeBannerDisplay(HomeFileManagerVO vo) {
		int r  = jtem.update(SQL_ADMIN_SITE_DISPLAY_BANNER, vo.getFileDisplayNum(), vo.getId());
		return r == 1 ;
	}

	@Override
	public boolean insertRecommendLecture(LectureVO vo) {
		
		return false;
	}

	@Override
	public boolean updateRecommendLecture(LectureVO vo) {
		
		return false;
	}

	@Override
	public boolean deleteRecommendLecture(LectureVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LectureVO selectRecommendLecture(LectureVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LectureVO> selectRecommendLectureList(List<Integer> reIds) {
		String sql = SQL_ADMIN_SITE_SELECT_RECOlIST_BY_IDS;
		for(int i = 0 ; i < reIds.size(); i++) {
			if(i== 0) {
				sql+= "IN (";
				sql+= reIds.get(i)+",";
			} 
			if (i > 0 && i < reIds.size()-1) {
				sql+= reIds.get(i)+",";
			}
			if (i == reIds.size()-1) {
				sql+= reIds.get(i);
				sql+= ")";
			} 
		}
//		System.out.println(sql);
		return jtem.query(sql, BeanPropertyRowMapper.newInstance(LectureVO.class));
		
	}

	@Override
	public boolean insertNomalLecture(LectureVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateNomalLecture(LectureVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteNomalLecture(LectureVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LectureVO selectNomalLecture(LectureVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LectureVO> selectNomalLectureList() {
		// TODO Auto-generated method stub
		return jtem.query(SQL_ADMIN_SITE_SELECT_NOMAL_LEC_ALL, BeanPropertyRowMapper.newInstance(LectureVO.class));
	}

	@Override
	public List<Integer> getRecommendIds() {
		List<Integer> idList = new ArrayList<Integer>(); 
		idList =  jtem.queryForList(SQL_ADMIN_SITE_GET_RECOMMEND_IDS, Integer.class);
		return idList;
	}

	@Override
	public boolean likeBtnClick(int status, int memberId, int lectureId) {
		if( status == 0) { 
			int r = jtem.update(SQL_UPDATE_LECTURE_LIKE, lectureId); 
			if(r == 1) {
				System.out.println("강의테이블 반영성공 & 좋아요 테이블에 추가성공");
				jtem.update(SQL_INSERT_lIKECLASS_ID, memberId, lectureId);
				return true;
			} else {
				System.out.println("강의테이블 반영성공 & 좋아요 테이블에 등록실패");
				return false;
			}
		} else {
			int f = jtem.update(SQL_UPDATE_LECTURE_DISLIKE, lectureId);
			if(f == 1) {
				System.out.println("강의테이블 반영성공 & 좋아요 테이블에 삭제성공");
				jtem.update(SQL_DELETE_lIKECLASS_ID, memberId, lectureId);
				return true;
			}else {
				System.out.println("강의테이블 반영성공 & 좋아요 테이블에 삭제실패");
				return false;
			}
		}
	}

	@Override
	public List<LectureVO> selectLectureListForCategory(int category) {
		return jtem.query(SQL_ADMIN_SELECT_LECTURE_FOR_CATEGORY, BeanPropertyRowMapper.newInstance(LectureVO.class), category);
	}

	@Override
	public List<LectureVO> selectLectureListForKeyword(String keyword) {
		return jtem.query(SQL_ADMIN_SEARCH_ANYCOLULM, BeanPropertyRowMapper.newInstance(LectureVO.class), keyword, keyword, keyword);
	}

	@Override
	public List<Integer> getLikeLectures(int memberId) {
		List<Integer> idList = new ArrayList<Integer>(); 
		idList = jtem.queryForList(SQL_SELECE_LIKE_ALL, Integer.class, memberId);
		return idList;
	}
	
	

}
