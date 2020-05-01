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
	@Autowired
	ILectureDAO LecDAO;
	public List<LectureVO>  showLectureList(int fid,int offset,int limit,int order) {
		
		List<LectureVO> LecVO = LecDAO.selectLectureList(fid, offset, limit, order);
		
		return LecVO;
	}
}
