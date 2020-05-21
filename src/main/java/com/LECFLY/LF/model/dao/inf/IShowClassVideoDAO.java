package com.LECFLY.LF.model.dao.inf;

import java.util.List;

import com.LECFLY.LF.model.vo.ShowClassVideoVO;

public interface IShowClassVideoDAO {
	
	boolean insertNewSCVStatusAttending(ShowClassVideoVO scv);
	
	boolean insertNewSCVStatusWillAttending(ShowClassVideoVO scv);
	
	boolean insertNewSCVStatusLike(ShowClassVideoVO scv);
	
	boolean insertNewSCV(ShowClassVideoVO scv);
	
	public boolean insertNewSCV(int mbId, int status, int classId, int videoId, String videoName, 
			String videoPic, int viewingTime, float untilShow);
	
	int insertNewSCVRtPK(ShowClassVideoVO scv);
	
	int insertNewSCVStatusAttendingRtPK(ShowClassVideoVO scv);
	
	int insertNewSCVStatusWillAttendingRtPK(ShowClassVideoVO scv);
	
	int insertNewSCVStatusLikeRtPK(ShowClassVideoVO scv);
	
	public int insertNewSCVRtPK(int mbId, int status, int classId, int videoId, 
			String videoName, String videoPic, int viewingTime, float untilShow);
	
	List<ShowClassVideoVO> selectLecToStatusForMbId(int mbId, int status);
	
	List<Integer> selectLecToStatusForMbIdRtVdPk(int mbId, int status);
	
	boolean checkSCVStatusAttending(int mbId, int videoId);
	
	boolean checkSCVStatusWillAttending(int mbId, int videoId);
	
	boolean checkSCVStatusLike(int mbId, int videoId);
	
	boolean deleteOneSCV(int scvId);

	
	
	
	
}
