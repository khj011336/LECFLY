package com.LECFLY.LF.model.dao.inf;

import java.util.List;

import com.LECFLY.LF.model.vo.ProfitHistoryVO;

public interface IProfitHistoryDAO {
	
	// 추가할수있다.
	boolean insertNewProfitHistory(ProfitHistoryVO profitHistory);
	
	boolean insertNewProfitHistory(int uploaderId);
	
	// 전체 조회할수 있다
	List<ProfitHistoryVO> selectAllProfitHistory();
	
	ProfitHistoryVO selectOneProfitHistoryById(int id);
	
	ProfitHistoryVO selectOneProfitHistoryByUploaderId(int uploaderId);
	
	int selectProfitHistoryGetUploaderIdToId(int id);
	
	int selectProfitHistoryGetIdToUploaderId(int uploaderId);
	
	boolean updateProfitHistoryByUploaderId(int uploaderId, ProfitHistoryVO profitHistory);
	
	boolean updateProfitHistoryById(int id, ProfitHistoryVO profitHistory);
	
	boolean updateSaveMoneyById(int id, int saveMoney);
	
	boolean updategetMoneyById(int id, int getMoney);
	
	boolean updateCateGoryById(int id, int saveMoney);
	
	boolean updateDetailById(int id, String detail);
	
	boolean updateSaveMoneyByUploaderId(int uploderId, int saveMoney);
	
	boolean updategetMoneyByUploaderId(int uploderId, int getMoney);
	
	boolean updateCateGoryByUploaderId(int uploderId, int saveMoney);
	
	boolean updateDetailByUploaderId(int uploderId, String detail);
	
	boolean deleteProfitHistoryById(int id);
	
	boolean deleteProfitHistoryByUploaderId(int uploaderId);
	
}
