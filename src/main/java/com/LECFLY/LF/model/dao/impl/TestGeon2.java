package com.LECFLY.LF.model.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.LECFLY.LF.model.vo.CommentClassVO;
import com.LECFLY.LF.model.vo.CommentVO;
import com.LECFLY.LF.model.vo.creator.CreatorVO;
import com.LECFLY.LF.model.vo.creator.KitVO;
import com.LECFLY.LF.model.vo.creator.LectureVO;
import com.LECFLY.LF.model.vo.creator.VideoVO;

@Repository
public class TestGeon2 {

	@Autowired
	private JdbcTemplate jtem;
	
	// SQL 정의문
	private final String SQL_SELECT_LECTURE_ID = "select * from lectures where id = ?";
	// kitsVO와 mysql 컬럼명들의 동기화 필요.
	private final String SQL_SELECT_KIT_CFID = "select * from kit where CFId = ?";
	private final String SQL_SELECT_VIDEO_CFID = "select * from videos where play_c_f_id = ?";
	private final String SQL_SELECT_CREATOR = "select name, nickname, info from creator where id = ?";
	
	public LectureVO selectOneLecture(int lecId) {
		System.out.println("selectOneLecture()");
		try {
			return jtem.queryForObject(SQL_SELECT_LECTURE_ID, BeanPropertyRowMapper.newInstance(LectureVO.class), lecId);
		} catch (DataAccessException e) {
			System.out.println("Lecture DataAccessException");
			e.printStackTrace();
		}
		return null;
	}

	public KitVO selectOneKit(int CFId) {
		System.out.println("selectOneKit()");
		try {
			System.out.println(CFId);
			return jtem.queryForObject(SQL_SELECT_KIT_CFID, BeanPropertyRowMapper.newInstance(KitVO.class), CFId);
		} catch (DataAccessException e) {
			System.out.println("Kit DataAccessException");
			e.printStackTrace();
		}
		return null;
	}

	public List<VideoVO> selectOneVideo(int CFId) {
		System.out.println("selectOneVideo()");
		System.out.println("cfId = " +CFId);
		try {
		return jtem.query(SQL_SELECT_VIDEO_CFID, 
				BeanPropertyRowMapper.newInstance(VideoVO.class), CFId);
		} catch (DataAccessException e) {
			System.out.println("Video DataAccessException");
			e.printStackTrace();
		}
		return null;
	}

	public Map<String, Object> selectOneCreator(int Id) {
		System.out.println("selectOneCreator()");
		System.out.println("id =" + Id);
		try {
		return jtem.queryForMap(SQL_SELECT_CREATOR, Id);
		} catch (DataAccessException e) {
			System.out.println("creator DataAccessException");
			e.printStackTrace();
		}
		return null;
	} 
	
	private final String SQL_SELECT_KIT_ID = "select * from kit where id = ?";
	
	public KitVO selectOneKitbyId(int kitId) {
		
		System.out.println(SQL_SELECT_KIT_ID + "kitId = " + kitId);
		
		return jtem.queryForObject(SQL_SELECT_KIT_ID, 
				BeanPropertyRowMapper.newInstance(KitVO.class), kitId);
	}
	
	private final String SQL_SELECT_CREATOR_FID ="select * from creator where fId = ?";
	public CreatorVO selectOneCreByfId(int getfId) {
		
		System.out.println(SQL_SELECT_CREATOR_FID + "getfId = " + getfId);
		return jtem.queryForObject(SQL_SELECT_CREATOR_FID, BeanPropertyRowMapper.newInstance(CreatorVO.class), getfId);
	}

	
	
	
	
	
	
	
}
