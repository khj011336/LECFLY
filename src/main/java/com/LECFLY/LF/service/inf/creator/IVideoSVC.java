package com.LECFLY.LF.service.inf.creator;

import java.util.HashMap;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.LECFLY.LF.model.vo.creator.VideoVO;

public interface IVideoSVC {
	List<VideoVO>  showLectureList(int CFID,int offset) ;
	int checkOfLectureNumber(int CFID) ;
	String showVideoList(int cagtegory, int CFID,int MAXPAGE , int page , Model model );
	HashMap<String, String> videoProc(VideoVO vio, MultipartFile videoFile , Model model);
	String imgProc(VideoVO vio,MultipartFile addimgfile,Model model);
	boolean insertNewVideo(VideoVO vo);
}
