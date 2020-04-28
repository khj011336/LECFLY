package com.LECFLY.LF.model.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.LECFLY.LF.model.dao.inf.IProfitHistoryDAO;
import com.LECFLY.LF.model.vo.ProfitHistoryVO;

@Repository
public class PropitHistoryMySqlImpl implements IProfitHistoryDAO {
	
	@Autowired
	JdbcTemplate jtem;
	
	private final int ERROR_BY_ID = -1; 
	private final int ERROR_BY_UPLOADER_ID = -2;
	private final int ERROR_BY_SAVE_MONEY = -3;
	private final int ERROR_BY_GET_MONEY = -4;
	private final int ERROR_BY_CATEGORY = -5;
	private final int ERROR_BY_DETAIL = -6;
	private final int ERROR_BY_DAY = -7;
	private static final int PASS_CHECK_NUM = 1;
	
	private static final Map<Integer, String> INT_ERROR_RT_STR = new HashMap<>();
	
	// 더미 생성자함수 // private final 상수쓸라고 생성..
	public PropitHistoryMySqlImpl() {}
	
	// Map 에 해당하는 값을 리턴하려고함
	private static String getErrorStr(int intErrorCode) {
		System.out.println("intErrorCode = " + intErrorCode); 
		PropitHistoryMySqlImpl phmi = new PropitHistoryMySqlImpl();
		INT_ERROR_RT_STR.put(phmi.ERROR_BY_ID, "id는 0이거나 음수");
		INT_ERROR_RT_STR.put(phmi.ERROR_BY_UPLOADER_ID, "uploaderId는 0이거나 음수");
		INT_ERROR_RT_STR.put(phmi.ERROR_BY_SAVE_MONEY, "saveMoney는  음수");
		INT_ERROR_RT_STR.put(phmi.ERROR_BY_GET_MONEY, "getMoney는  음수");
		INT_ERROR_RT_STR.put(phmi.ERROR_BY_CATEGORY, "category는 지정한범위 (1, 2, 3) 이외의 수");
		INT_ERROR_RT_STR.put(phmi.ERROR_BY_DETAIL, "detail == null");
		INT_ERROR_RT_STR.put(phmi.ERROR_BY_DAY, "day == null");
		INT_ERROR_RT_STR.put(PASS_CHECK_NUM, "checkGetSqlProfitHistoryVO().. 통과성공");
		return INT_ERROR_RT_STR.get(intErrorCode);
	}
	
	
	// profitHistory 모든값 제대로 들어왔는지 체크하는함수 -1 ~ -7/ 1 rt
	private static int checkGetSqlProfitHistoryVO(ProfitHistoryVO profitHistory) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 - HH시 mm분 ss초");
		PropitHistoryMySqlImpl phmi = new PropitHistoryMySqlImpl();
		
		int id = profitHistory.getId();
		int uploderId = profitHistory.getUploaderId();
		int saveMoney = profitHistory.getSaveMoney();
		int getMoney = profitHistory.getGetMoney();
		int category = profitHistory.getCategory();
		String detail = profitHistory.getDetail();
		Timestamp day = profitHistory.getDay();
		
		if(id < 0) {
			System.out.println("id <= 0 / id는 0이거나 음수");
			System.out.println("id = " + id);
			return phmi.ERROR_BY_ID;
		}
		if(uploderId <= 0) {
			System.out.println("uploaderId <= 0 / uploaderId는 0이거나 음수");
			System.out.println("uploderId = " + uploderId);
			return phmi.ERROR_BY_UPLOADER_ID;
		}
		if(saveMoney < 0) {
			System.out.println("saveMoney < 0 / saveMoney는  음수");
			System.out.println("saveMoney = " + saveMoney);
			return phmi.ERROR_BY_SAVE_MONEY;
		}
		if(getMoney < 0) {
			System.out.println("getMoney < 0 / getMoney는  음수");
			System.out.println("getMoney = " + getMoney);
			return phmi.ERROR_BY_GET_MONEY;
		}
		if (category < 0 || category > 3) {
			System.out.println("category < 0 || category > 3 / category는 지정한범위 (1, 2, 3) 이외의 수");
			System.out.println("category = " + category);
			return phmi.ERROR_BY_CATEGORY;
		}
		if(detail == null) {
			System.out.println("detail == null");
			return phmi.ERROR_BY_DETAIL;
		}
		if(day == null) {
			System.out.println("day == null");
			return phmi.ERROR_BY_DAY;
		}
		String fmtDay = sdf.format(day);
		System.out.printf("id = %d, uploderId = %d, saveMoney = %d, getMoney= %d, "
				+ "category = %d, detail = %d, fmtDay = %s", 
				id, uploderId, saveMoney, getMoney, category, detail, fmtDay);
		return PASS_CHECK_NUM;
	}
	
	// 내부클래스 RowMapper 구현
	class PropitHistoryImplRowMapper implements RowMapper<ProfitHistoryVO>{
		@Override
		public ProfitHistoryVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			PropitHistoryMySqlImpl phmi = new PropitHistoryMySqlImpl();
			int id = rs.getInt("id");
			int uploaderId = rs.getInt("uploader_id");
			int saveMoney = rs.getInt("save_money");   
			int getMoney = rs.getInt("get_money");    
			int category = rs.getInt("category");    
			String detail = rs.getString("detail");   
			Timestamp day = rs.getTimestamp("day");   
			
			ProfitHistoryVO phv = new ProfitHistoryVO(id, uploaderId, saveMoney, getMoney, category, detail, day);
			int checkPhv = checkGetSqlProfitHistoryVO(phv);
			if(checkPhv == PASS_CHECK_NUM) {
				System.out.println(phmi.getErrorStr(checkPhv)); // 안에 Map 이되어있어서 key int 값넣으면 해당 값을 리턴
				return phv;
			} else
				System.out.println(phmi.getErrorStr(checkPhv)); // 안에 Map 이되어있어서 key int 값넣으면 해당 값을 리턴
			return null;
		}
		
	}
		// insert 순서 id uploader_id, save_money, get_money, category, detail, day
	public static final String SQL_INSERT_NEW_PROFIT_HISTORY = 
			"insert into profit_histories values(null, ?, 0, 0, 3, '', CURRENT_TIMESTAMP)";
	
		// 전체 select 
	public static final String SQL_SELECT_ALL_PROFIT_HISTORYS =
			"select * from profit_histories";
	
		// 전체 select order by id 역순 리미트 10개 // 관리자가쓰려나요? 현재 이문장 사용X
	public static final String SQL_SELECT_ALL_PROFIT_HISTORYS_LIMIT_TEN =
			"select * from profit_histories order by id desc limit 10";
	
	public static final String SQL_SELECT_ONE_PROFIT_HISTORY_BY_ID = 
			"select * from profit_histories where id = ?";
	
	public static final String SQL_SELECT_ONE_PROFIT_HISTORY_BY_UPLOADER_ID = 
			"select * from profit_histories where upload_id = ?";
	
	public static final String SQL_SELECT_PROFIT_HISTORY_GET_UPLOADER_ID_TO_ID = 
			"select uploder_id from profit_histories where id = ?";
	
	public static final String SQL_SELECT_PROFIT_HISTORY_GET_ID_TO_UPLOADER_ID = 
			"select id from profit_histories where uploder_id = ?";
	
	@Override
	public boolean insertNewProfitHistory(ProfitHistoryVO profitHistory) {
		int r = jtem.update(SQL_INSERT_NEW_PROFIT_HISTORY, profitHistory.getUploaderId());
		System.out.println("r == 1 false 라면 확인필요");
		System.out.println("insertNewProfitHistory(ProfitHistoryVO profitHistory).. r = " + r );
		return (r == 1);
	}

	@Override
	public boolean insertNewProfitHistory(int uploaderId) {
		int r = jtem.update(SQL_INSERT_NEW_PROFIT_HISTORY, uploaderId);
		System.out.println("r == 1 false 라면 확인필요");
		System.out.println("insertNewProfitHistory(int uploaderId).. r = " + r );
		return (r == 1);
	}


	@Override
	public List<ProfitHistoryVO> selectAllProfitHistory() {
		List<ProfitHistoryVO> phvList = 
				jtem.query(SQL_SELECT_ALL_PROFIT_HISTORYS, new PropitHistoryImplRowMapper());
		System.out.println("selectAllProfitHistory()...");
		System.out.println("phVOList.get(0) = " + phvList.get(0) + 
				" / phVOList.size() = " + phvList.size());
		if(phvList.size() >= 0)
			return phvList;
		else
			System.out.println("phVOList = null");
			return null;
	}

	@Override
	public ProfitHistoryVO selectOneProfitHistoryById(int id) {
		System.out.println("selectOneProfitHistoryById");
		ProfitHistoryVO phv = jtem.queryForObject(SQL_SELECT_ONE_PROFIT_HISTORY_BY_ID, 
					new PropitHistoryImplRowMapper(), id);
		int checkPhv = checkGetSqlProfitHistoryVO(phv);
		if(checkPhv == PASS_CHECK_NUM) {
			System.out.println(getErrorStr(checkPhv));
			return phv;
		} else {
			System.out.println(getErrorStr(checkPhv));
			return null;
		}
	}

	@Override
	public ProfitHistoryVO selectOneProfitHistoryByUploaderId(int uploaderId) {
		System.out.println("selectOneProfitHistoryByUploaderId()..");
		ProfitHistoryVO phv = jtem.queryForObject(SQL_SELECT_ONE_PROFIT_HISTORY_BY_UPLOADER_ID, 
				new PropitHistoryImplRowMapper(), uploaderId);
		int checkPhv = checkGetSqlProfitHistoryVO(phv);
		if(checkPhv == PASS_CHECK_NUM) {
			System.out.println(getErrorStr(checkPhv));
			return phv;
		} else {
			System.out.println(getErrorStr(checkPhv));
			return null;
		}
	}

	@Override
	public int selectProfitHistoryGetUploaderIdToId(int id) {
		System.out.println("selectProfitHistoryGetUploaderIdToId()...");
		int uploaderId = jtem.queryForObject(SQL_SELECT_PROFIT_HISTORY_GET_UPLOADER_ID_TO_ID,
				Integer.class, id);
		if(uploaderId > 0) {
			System.out.println("uploaderId = " + uploaderId);
			return uploaderId;
		} else {
			System.out.println(getErrorStr(ERROR_BY_UPLOADER_ID));
			return ERROR_BY_UPLOADER_ID;
		}
		
	}

	@Override
	public int selectProfitHistoryGetIdToUploaderId(int uploaderId) {
		System.out.println("selectProfitHistoryGetIdToUploaderId()... ");
		int id = jtem.queryForObject(SQL_SELECT_PROFIT_HISTORY_GET_ID_TO_UPLOADER_ID,
				Integer.class, uploaderId);
		if(id > 0) {
			System.out.println("id = " + id);
			return id;
		} else {
			System.out.println(getErrorStr(ERROR_BY_ID));
			return ERROR_BY_ID;
		}
	}

	@Override
	public boolean updateProfitHistoryByUploaderId(int uploaderId, ProfitHistoryVO profitHistory) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProfitHistoryById(int id, ProfitHistoryVO profitHistory) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateSaveMoneyById(int id, int saveMoney) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updategetMoneyById(int id, int getMoney) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCateGoryById(int id, int saveMoney) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateDetailById(int id, String detail) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateSaveMoneyByUploaderId(int uploderId, int saveMoney) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updategetMoneyByUploaderId(int uploderId, int getMoney) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCateGoryByUploaderId(int uploderId, int saveMoney) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateDetailByUploaderId(int uploderId, String detail) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProfitHistoryById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProfitHistoryByUploaderId(int uploaderId) {
		// TODO Auto-generated method stub
		return false;
	}

}
