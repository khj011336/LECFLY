package com.LECFLY.LF.model.dao.impl.creator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.LECFLY.LF.model.dao.inf.creator.IVideoDAO;
import com.LECFLY.LF.model.vo.creator.LectureVO;
import com.LECFLY.LF.model.vo.creator.VideoVO;
@Repository
public class VideoMysqlDAOImpl implements IVideoDAO {
	final int PAGESIZE = 3;
	@Autowired
	JdbcTemplate jtem ;
	final String SELECT_ViDEO_limit = "select * from video where fid = ? order by created_at desc  limit ?,? ";
	final String SELECT_CLASS_ViDEO_limit = "select * from video where CFId = ? order by created_at desc  limit ?,? ";
	final String COUNT_VIDEO = "select count(*) as vi from video where CFId =? ";
	final String INSERT= "insert into video values(null,?,?,?,?,?,?,?,"
	+ "?,?,?,?,?,?,now(),now(),0,' ')";
	final String SELECT_ONE_VIDEO = "select * from video where CFId = ? and id = ?";
	final String UPDATE_VIDEO ="update video set video_path = ? , duration = ? , title = ? , info = ? , img_path =  ? , gif_path = ? ,order_info = ?,"+
	"comment_y_n = ? , status = ? , updated_at = now() where CFId = ? and id = ?";
	final String SELECT_ALL_VIDEOTRACK = "select * from video where CFId = ?";

	@Override
	public boolean insertNewVideo(VideoVO Vvo) {
	int r = jtem.update(INSERT, Vvo.getfId(),Vvo.getcFId(),Vvo.getVideoPath(),Vvo.getDuration(),Vvo.getTitle(),Vvo.getInfo(),Vvo.getImgPath()
				,Vvo.getGifPath(),Vvo.getOrderInfo(),Vvo.getCategory(),Vvo.getCommentYorN(),Vvo.getViews(),Vvo.getStatus());
		return r == 1;
	}
	@Override
	public boolean insertNewVideo(int fid,int cfid,String videoPath, int duration, String title, String info, String imgPath,
			String gifPath, String orderInfo, int category, int commentYorN ,int views, int status) {
		int r = jtem.update(INSERT, fid, cfid, videoPath, duration, title, info , imgPath , gifPath , orderInfo,category,commentYorN,views,status );
		return r ==1;
	}

	@Override
	public boolean updateVideo(VideoVO viVO,int CFID, int id) {
		int r=jtem.update(UPDATE_VIDEO,viVO.getVideoPath(),viVO.getDuration(),viVO.getTitle(),viVO.getInfo(),viVO.getImgPath(),
				viVO.getGifPath(),viVO.getOrderInfo(),viVO.getCommentYorN(),viVO.getStatus(),CFID,id);
		return r==1;
	}

	@Override
	public VideoVO selectOneVideo(int CFID,int id) {
		try {
		return jtem.queryForObject(SELECT_ONE_VIDEO, BeanPropertyRowMapper.newInstance(VideoVO.class),CFID,id);
		}catch (DataAccessException e) {
			System.out.println("videoVO select error");
			System.out.println(e);
			return null;
		}
	}
	@Override
	public List<VideoVO> selectVideoTrack( int CFID) {
		return jtem.query(SELECT_ALL_VIDEOTRACK, BeanPropertyRowMapper.newInstance(VideoVO.class),CFID);

	}
	@Override
	public int checkNumberOfVideo(int CFID){
		int r = jtem.queryForObject(COUNT_VIDEO, Integer.class,CFID );
		return 	r;

	}
	@Override
	public List<VideoVO> selectVideoTrack(  int CFID, int offset, int limit) {
		return jtem.query(SELECT_CLASS_ViDEO_limit,BeanPropertyRowMapper.newInstance(VideoVO.class) ,CFID,offset,limit);

	}

}
