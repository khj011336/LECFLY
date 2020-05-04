package com.LECFLY.LF.model.dao.impl.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.LECFLY.LF.model.dao.inf.admin.IAdminSiteDAO;
import com.LECFLY.LF.model.vo.HomeFileManagerVO;
import com.LECFLY.LF.model.vo.creator.LectureVO;

public class AdminSiteMysqlDAOImpl implements IAdminSiteDAO {
	
	@Autowired
	private JdbcTemplate jtem;
	
	// SQL 명령어
	// 메인배너 관련 FILE_DISPLAY_ON = 1
	/** 전체 배너목록 조회 */
	public static final String SQL_ADMIN_SITE_SELECT_BANNER_ALL = 
			"SELECT * FROM HOME_FILE_MANAGER WHERE FILE_DISPLAY_ON = 1";
	/** 배너 상세 조회 */
	public static final String SQL_ADMIN_SITE_SELECT_BANNER_ONE = 
			"SELECT * FROM HOME_FILE_MAMAGER WHERE FILE_DISPLAY_ON = 1, ID = ?";
	/** 배너이미지 삭제 */
	public static final String SQL_ADMIN_SITE_DELETE_BANNER_ONE = 
			"DELETE HOME_FILE_MAMAGER WHERE FILE_DISPLAY_ON = 1, ID = ?";
	/** 배너이미지 수정 */
	public static final String SQL_ADMIN_SITE_UPDATE_BANNER = 
			"UPDATE HOME_FILE_MANAGER SET FILE_DISPLAY_NUM = ?, FILE_LECTURE_ID = ?, FILE_NAME=?,"
			+ "FILE_PATH=?, FILE_SIZE=?, UPDATED_DATE = NOW() "
			+ "WHERE FILE_DISPLAY_ON = 1, ID= ?";
	/** 전시배너 위치 지정(0~6) */
	public static final String SQL_ADMIN_SITE_DISPLAY_BANNER =
			"UPDATE HOME_FILE_MANAGER SET FILE_DISPLAY_NUM = ? WHERE FILE_DISPLAY_ON = 1, ID=?";
	/** 전시 배너 등록 */
	public static final String SQL_ADMIN_SITE_INSERT_BANNER = 
			"INSERT INTO HOME_FILE_MANAGER VALUE (NULL,1,?,?,?,?,?,NOW())";
	
	// 추천강의 관련 FILE_DISPLAY_ON = 2
	/** 전체 추천 강의목록 조회 */
	public static final String SQL_ADMIN_SITE_SELECT_RECOMMEND_LEC_ALL =
			"SELECT * FROM HOME_FILE_MANAGER WHERE FILE_DISPLAY_ON = 2";
	/** 추천 강의목록 수정 */
	public static final String SQL_ADMIN_SITE_RECOMMEND_LEC_ALL =
			"UPDATE HOME_FILE_MANAGER SET FILE_DISPLAY_NUM = ?, FILE_LECTURE_ID = ?, FILE_NAME=?, "
			+ "FILE_PATH=?, FILE_SIZE=?, UPDATED_DATE = NOW() WHERE FILE_DISPLAY_ON = 2, ID = ?";
	
	// 일반강의 관련
	/** 전체 일반 강의목록 조회_최신순 */
	public static final String SQL_ADMIN_SITE_SELECT_NOMAL_LEC_ALL = 
			"SELECT * FROM LECTURES WHERE CREATED_AT DESC LIMIT 40";
	
	@Override
	public boolean insertBanner(HomeFileManagerVO vo) {
		System.out.println("=> insertBanenr() 기능 처리");
		int r = jtem.update(SQL_ADMIN_SITE_INSERT_BANNER, vo.getFileDisplayNum(), vo.getFileLectureId(), vo.getFileName(), vo.getFilePath(), vo.getFileSize());
		return r == 1;
	}

	@Override
	public boolean updateBanner(HomeFileManagerVO vo) {
		System.out.println("=> updateBanner() 기능 처리");
		
		return false;
	}

	@Override
	public boolean deleteBanner(HomeFileManagerVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<HomeFileManagerVO> selectBanner(HomeFileManagerVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HomeFileManagerVO> selectBannerList(HomeFileManagerVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertRecommendLecture(LectureVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateRecommendLecture(LectureVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteRecommendLecture(LectureVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<LectureVO> selectRecommendLecture(LectureVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LectureVO> selectRecommendLectureList(LectureVO vo) {
		// TODO Auto-generated method stub
		return null;
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
	public List<LectureVO> selectNomalLecture(LectureVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LectureVO> selectNomalLectureList(LectureVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
