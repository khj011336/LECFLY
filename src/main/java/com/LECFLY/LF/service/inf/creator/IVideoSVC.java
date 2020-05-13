package com.LECFLY.LF.service.inf.creator;

import java.util.List;

import com.LECFLY.LF.model.vo.creator.VideoVO;

public interface IVideoSVC {
	List<VideoVO>  showLectureList(int CFID,int offset) ;
	int checkOfLectureNumber(int CFID) ;
}
