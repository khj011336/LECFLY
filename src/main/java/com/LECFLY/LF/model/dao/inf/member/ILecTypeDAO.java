package com.LECFLY.LF.model.dao.inf.member;

import java.util.List;

import com.LECFLY.LF.model.vo.LecTypeVO;

public interface ILecTypeDAO {
	
	int insertNewLecTypeRtPK(LecTypeVO lt);
	
	List<LecTypeVO> selectAllLecTypeByMbIdStatus(int mbId, int status);

	int checkNumberOfLectureByMbIdStatus(int mbId, int status);

	boolean checkLecTypeByMbidClassId(int mbId, int lecId);

	LecTypeVO selectOneLecTypeByMbidClassId(int mbId, int lecId);

	boolean insertNewLecType(LecTypeVO lt);

	boolean deleteOneLecTypeById(int id);

}