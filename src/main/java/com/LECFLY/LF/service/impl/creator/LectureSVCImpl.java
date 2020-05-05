package com.LECFLY.LF.service.impl.creator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.LECFLY.LF.model.dao.inf.creator.ILectureDAO;
import com.LECFLY.LF.model.vo.creator.LectureVO;
import com.LECFLY.LF.service.inf.creator.ILectureSVC;
@Service
public class LectureSVCImpl{
	public static final int PAGESIZE = 3;
	@Autowired
	ILectureDAO LecDAO;
	public List<LectureVO>  showLectureList(int fid,int offset,int order) {
		int  off = (offset-1) *PAGESIZE;
		List<LectureVO> LecVO = LecDAO.selectLectureList(fid, off, PAGESIZE, order);
		
		return LecVO;
	}
	public int checkOfLectureNumber(int fid) {
		int totalRecords = LecDAO.checkNumberOfLectures(fid);
		System.out.println(totalRecords+"토탈 레코즈");
		return 	totalRecords /PAGESIZE +(totalRecords % PAGESIZE == 0? 0:1);
	}
}
