package com.LECFLY.LF.model.dao.inf.member;

import java.util.List;

import com.LECFLY.LF.model.vo.LecAttendVO;

public interface ILecAttendDAO {
	
	boolean insertNewLecAttendByVO(LecAttendVO la);
	boolean insertNewLecAttend(int mbId, int classId, int videoId, int videoName, int videoPic);
	
	List<LecAttendVO> selectAllLecAttendByMbIdClassId(int mbId, int classId);

}
