package com.LECFLY.LF.service.impl.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LECFLY.LF.model.dao.inf.member.IMemberDAO;
import com.LECFLY.LF.service.inf.member.IMemberSVC;


@Service
public class IMemberSVCImpl implements IMemberSVC {

	@Autowired
	private IMemberDAO mbDao;
	
	@Override
	public boolean updateMemberProfileImg(int mbId, String filePath) {
		boolean r = mbDao.updateMemberProfileImg(mbId, filePath);
		
		
		return false;
	}
	
}
