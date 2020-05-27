package com.LECFLY.LF.model.dao.inf.creator;

import java.util.List;

import com.LECFLY.LF.model.vo.creator.VideoVO;

public interface IVideoDAO {
	boolean insertNewVideo(VideoVO Vvo);

	boolean insertNewVideo(int fid, int cfid, String videoPath, int duration, String title, String info, String imgPath,
			String gifPath, String orderInfo, int category, int commentYorN, int views, int status);

	boolean updateVideo(VideoVO viVO, int CFID, int id);

	VideoVO selectOneVideo(int CFID, int id);

	int checkNumberOfVideo(int CFID);

	List<VideoVO> selectVideoTrack(int fid, int CFID);

	List<VideoVO> selectVideoTrack(int CFID, int offset, int limit);
}
