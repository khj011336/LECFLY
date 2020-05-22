package com.LECFLY.LF.model.dao.inf.creator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.LECFLY.LF.model.vo.creator.CreatorVO;
import com.LECFLY.LF.model.vo.creator.LectureVO;

public interface ILectureDAO {
	int ART =1;
	int MUSIC = 2;
	int COOKING = 3;
	int LIFESTYLE = 4;
	int WORKOUT = 5;
	int CAREER = 6;
	int TRAVEL = 7;
	default public String returnCate(int category){
		Map<Integer, String> df = new HashMap<>();
		df.put(1, "미술");df.put(2, "음악");df.put(3, "요리");df.put(4, "라이프스타일");
		df.put(5, "운동");df.put(6, "커리어");df.put(1, "여행");
		return df.get(category);
	}
	List<LectureVO> selectLectureList(int Fid , boolean order);
	List<LectureVO> selectLectureList(int Fid , int offset,  int limit);
	List<LectureVO> selectLectureList(int Fid , int offset, int limit,int order);
	int checkNumberOfLectures(int fid);
	boolean isCreator(int id);
	boolean insertNewLecture(LectureVO Lvo);
	boolean insertNewLecture(int category, String subTitle, String title, String titleImg, String infoImg,
			String info );
 boolean insertNewLecture(int fid , int category , String subTitle, String title , String titleImg, String infoImg , String infoImgb,
			String info ,int status, String nickname , String imgpath ) ;
 LectureVO selectOneLectureForUpdate(int fid);
	boolean updateLecture(LectureVO lecVO ,CreatorVO crVO, int id);
	boolean updateOnlyLecuture(LectureVO lecVO , int id);
	boolean updateLectureStatus(int id);
	boolean deleteLecture();
	
}
