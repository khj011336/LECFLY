package com.LECFLY.LF.model.dao.inf.creator;

import java.util.List;

import com.LECFLY.LF.model.vo.creator.LectureVO;

public interface ILectureDAO {
	List<LectureVO> selectLectureList(int Fid , boolean order);
	List<LectureVO> selectLectureList(int Fid , int offset,  int limit);
	List<LectureVO> selectLectureList(int Fid , int offset, int limit,int order);
	int checkNumberOfLectures(int fid);
	boolean isCreator(int id);
	boolean insertNewLecture(LectureVO Lvo);
	boolean insertNewLecture(int category, String subTitle, String title, String titleImg, String infoImg,
			String info );
	
	boolean updateLecture();
	boolean updateLectureStatus(int id);
	boolean deleteLecture();
	
}
