package com.LECFLY.LF.model.dao.inf.creator;

import java.util.List;

import com.LECFLY.LF.model.vo.creator.VideoVO;

public interface IVideoDAO {
 boolean insertNewVideo(VideoVO Vvo);
 boolean insertNewVideo( String videoPath, int duration, String title, String info, String imgPath,
			String gifPath, String orderInfo, int category, int commentYorN );
 boolean updateVideo(int id ,int FK );
 boolean updateVideo(int id );
 boolean deleteVideo(int id );
 List<VideoVO> showVideoTrack(int fid , int CFID);
 List<VideoVO> showVideoTrack(int fid , int CFID , int offset, int limit );
}
