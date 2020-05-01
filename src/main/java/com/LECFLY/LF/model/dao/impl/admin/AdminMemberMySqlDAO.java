package com.LECFLY.LF.model.dao.impl.admin;

import com.LECFLY.LF.model.dao.inf.admin.IAdminMemberDAO;

public class AdminMemberMySqlDAO implements IAdminMemberDAO {
	public static final String SQL_ADMIN_MEMBER_SELECT_SHOW = 
		"select * from member where 1=1";
	
	public String makeSearchQuery(String searchString, String item, String personid) {
		String whereQuery = "";
		if(searchString != null || !searchString.equals("") ) {
			whereQuery += "and"+ item +"like '%"+searchString+"%'";
		}
		if(personid != null || !personid.equals("")) {
			whereQuery += "and personid = "+personid+"";
		}
		return whereQuery;
	}
	
}


