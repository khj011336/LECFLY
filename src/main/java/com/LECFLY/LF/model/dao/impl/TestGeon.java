package com.LECFLY.LF.model.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.LECFLY.LF.model.vo.CommentClassVO;
import com.LECFLY.LF.model.vo.creator.CommentVO;
import com.LECFLY.LF.model.vo.creator.KitVO;
import com.LECFLY.LF.model.vo.creator.LectureVO;
import com.LECFLY.LF.model.vo.creator.VideoVO;

@Repository
public class TestGeon {

	@Autowired
	private JdbcTemplate jtem;
	
	
	//>>>>>>>>>>>>>>>>>>>> lectureDao
			
	final String SQL_SELECT_ONE_LECTURE_BY_LECID = 
			"select * from lectures where id = ?";
	
	// 
	public LectureVO selectOneLecture(int lecId) {
		System.out.println("selectOneLecture()...");
		try {
		return jtem.queryForObject(SQL_SELECT_ONE_LECTURE_BY_LECID, 
				BeanPropertyRowMapper.newInstance(LectureVO.class) , lecId);
		} catch(DataAccessException e) {
			System.out.println("DataAccessException ...");
			e.printStackTrace();
		}
		return null;
	}
		// 	>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	// kitDAO
	
	final String SQL_SELECT_ONE_KIT_BY_CFID = 
			"select * from kits where kit_c_f_id = ?";
	// 지금 kitVO 랑 mysql 이랑 안맞아서 beanpropertyRowMapper 못씀.
	public KitVO selectOneKitByCFId(int cFId) {
		System.out.println("selectOneKitByCFId()");
		try {
			return jtem.queryForObject(SQL_SELECT_ONE_KIT_BY_CFID, 
					BeanPropertyRowMapper.newInstance(KitVO.class), cFId);
		} catch(DataAccessException e) {
			System.out.println("DataAccessException..");
			e.printStackTrace();
		}
		return null;
	}
	// >>>>>>>>>>>>>>>>>>>>>>>>>>
	/////////////////////////////////////////////////////
	// videoDAO
	
	final String SQL_SELECT_ALL_VIDEO_BY_CFID = 
			"select * from videos where play_c_f_id = ?";
	
	public List<VideoVO> selectAllViedosByCFId(int cFId) {
		System.out.println("selectAllViedosByCFId()");
		try{
			return jtem.query(SQL_SELECT_ALL_VIDEO_BY_CFID, 
				BeanPropertyRowMapper.newInstance(VideoVO.class), cFId);
		} catch(DataAccessException e) {
			System.out.println("DataAccessException...");
			e.printStackTrace();
		}
		return null;
	}
	
	//////////////////////////////////////////////
	// CreatorDAO
	
	final String SQL_SELECT_CRE_NAME_AND_CRE_INFO_BY_ID = 
			"select cre_user_name as name, cre_user_i_f as info from creators where id = ?";
	
	public Map<String, Object> selectCreNameAndCreInfoByIdRtMap(int id) {
		try {
			return jtem.queryForMap(
					SQL_SELECT_CRE_NAME_AND_CRE_INFO_BY_ID, id);
		} catch(DataAccessException e) {
			System.out.println("DataAccessException...");
			e.printStackTrace();
		}
		return null;
	}
	////////////////////////////////////////
	// commentClassDAO
	final String SQL_SELECT_CFID_AND_BY_CFID = "select * from comment_classes where c_m_c_f_id = ? order by writed_day desc limit ?,10";
	
	public List<CommentClassVO> selectAllCommentByLecId(int cFId) {
		return jtem.query(SQL_SELECT_CFID_AND_BY_CFID, BeanPropertyRowMapper.newInstance(CommentClassVO.class), cFId);
	}
	
	
	/////////////////////////////////////////
}
