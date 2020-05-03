package com.LECFLY.LF.model.dao.impl.creator;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.LECFLY.LF.model.dao.inf.creator.IVideoDAO;
import com.LECFLY.LF.model.vo.creator.VideoVO;
@Repository
public class VideoMysqlDAOImpl implements IVideoDAO {

	@Override
	public boolean insertNewVideo(VideoVO Vvo) {
		// TODO Auto-generated method stub
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

	@Override
	public List<VideoVO> selectVideoTrack(int fid, int CFID, int offset, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

}
