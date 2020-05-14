package com.LECFLY.LF.service.impl.creator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LECFLY.LF.model.dao.inf.creator.IVideoDAO;
import com.LECFLY.LF.model.vo.creator.VideoVO;
import com.LECFLY.LF.service.inf.creator.IVideoSVC;
@Service
public class VideoSVCImpl implements IVideoSVC {
	@Autowired
	IVideoDAO viDAO ;
	final int PAGESIZE = 3;
	public List<VideoVO>  showLectureList(int CFID,int offset) {
		int  off = (offset-1) *PAGESIZE;
	
		return viDAO.selectVideoTrack(CFID, off, PAGESIZE);
	}
	public int checkOfLectureNumber(int CFID) {
		int totalRecords = viDAO.checkNumberOfVideo(CFID);
		System.out.println(totalRecords + "전체 레코드");
		System.out.println( totalRecords /PAGESIZE +(totalRecords % PAGESIZE == 0? 0:1) + "페이지수 ");
		return 	totalRecords /PAGESIZE +(totalRecords % PAGESIZE == 0? 0:1);
	}
}
