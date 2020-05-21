package com.LECFLY.LF.model.dao.inf.member;

import com.LECFLY.LF.model.vo.LecAttendVO;

public interface ILecAttendDAO {
	
	boolean insertNewLecAttendByVO(LecAttendVO la);
	boolean insertNewLecAttend(int mbId, int classId, int videoId, int videoName, int videoPic);
	
	LecAttendVO selectOneLecAttendByMbIdClassId(int mbId, int classId);

}
