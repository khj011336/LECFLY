package com.LECFLY.LF.service.impl.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LECFLY.LF.model.dao.impl.member.PostscriptMysqlDAOImpl;
import com.LECFLY.LF.model.vo.PostscriptVO;
import com.LECFLY.LF.service.inf.member.IPostscriptSVC;

@Service
public class PostscriptSVCImpl implements IPostscriptSVC {
	
	@Autowired
	PostscriptMysqlDAOImpl psDao;

	@Override
	public boolean addPostscript(int classId, int mbId, String mbLogin, String content, float rate) {
		System.out.println("svc: addPostscript");
		// 이후 예외처리 해야됨.
		psDao.addPostscript(classId, mbId, mbLogin, content, rate);
		return false;
	}
	
	@Override
	public boolean addPostscript(PostscriptVO ps) {
//		System.out.println("svc: addPostscript");
//		return psDao.addPostscript(ps);
		return false;
	}

	@Override
	public List<PostscriptVO> readAllPostscriptInLec(int lecId) {
		System.out.println("SVC: readAllPostscriptInLec");
		// 이후 예외처리 해야됨.
		List<PostscriptVO> psList = psDao.readAllPostscriptInLec(lecId);
		return psList;
	}

	@Override
	public PostscriptVO readOnePostscript(int id) {
		System.out.println("SVC: readOnePostscript");
		// 이후 예외처리 해야됨.
		// + 여러 바리엥이션으로 만들어야됨
		PostscriptVO ps = psDao.readOnePostscript(id);
		return ps;
	}

	@Override
	public boolean updateOnePostscript(PostscriptVO ps) {
		System.out.println("SVC: updateOnePostscript");
		// 이후 예외처리 해야됨.
		return psDao.updateOnePostscript(ps);
	}

	@Override
	public boolean deleteOnePostscript(int id) {
		System.out.println("SVC: updateOnePostscript");
		// 이후 예외처리 해야됨.
		return psDao.deleteOnePostscript(id);
	}

	@Override
	public boolean deleteAllPostscriptInLec(int lecId) {
		// TODO Auto-generated method stub
		return false;
	}

}
