package com.LECFLY.LF.model.dao.impl.creator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.LECFLY.LF.model.dao.inf.creator.IVideoDAO;
import com.LECFLY.LF.model.vo.creator.VideoVO;
@Repository
public class VideoMysqlDAOImpl implements IVideoDAO {
	final int PAGESIZE = 3;
	@Autowired
	JdbcTemplate jtem ;
	final String SELECT_ViDEO_limit = "select * from video where fid = ? order by created_at desc  limit ?,? ";
	final String SELECT_CLASS_ViDEO_limit = "select * from video where CFId = ? order by created_at desc  limit ?,? ";
	final String COUNT_VIDEO = "select count(*) as vi from video where CFId =? ";
	final String INSERT= "insert into video values(null,fid,cfid,videoPath,duration,title,info,imgPath,gifPath,"
	+ "orderInfo,category,comment_y_n,views,status,now(),now(),likecount,likeofmember)";
	@Override
	public boolean insertNewVideo(VideoVO Vvo) {
		
		return false;
	}

	@Override
	public boolean insertNewVideo(String videoPath, int duration, String title, String info, String imgPath,
			String gifPath, String orderInfo, int category, int commentYorN) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateVideo(int id, int FK) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateVideo(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteVideo(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<VideoVO> selectVideoTrack(int fid, int CFID) {
		// TODO Auto-generated method stub
		return null;
	}
	public int checkNumberOfVideo(int CFID){
		int r = jtem.queryForObject(COUNT_VIDEO, Integer.class,CFID );
		System.out.println(r);
		return 	r;
		
	}
	@Override
	public List<VideoVO> selectVideoTrack(  int CFID, int offset, int limit) {
		return jtem.query(SELECT_CLASS_ViDEO_limit,BeanPropertyRowMapper.newInstance(VideoVO.class) ,CFID,offset,limit);
		
	}

}
