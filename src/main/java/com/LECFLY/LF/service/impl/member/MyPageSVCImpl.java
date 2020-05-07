package com.LECFLY.LF.service.impl.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LECFLY.LF.model.dao.inf.creator.IVideoDAO;
import com.LECFLY.LF.model.dao.inf.member.IMemberDAO;
import com.LECFLY.LF.model.vo.creator.VideoVO;
import com.LECFLY.LF.service.inf.member.IMypageSVC;


@Service
public class MyPageSVCImpl implements IMypageSVC {

	@Autowired
	private IMemberDAO mbDao;
	
	@Autowired
	private IVideoDAO vdDao;
	
	@Override // 마이페이지 멤버가 사진업데이트 하려면..~~~
	public boolean updateMemberProfileImg(int loginedId, int id, String pic) {
		System.out.println("updateMemberProfileImg()...");
		if(loginedId != id) {
			System.out.println("업데이트 대상 불일치");
			return false;
		}
		boolean r = mbDao.updateMemberProfileImg(id, pic);
		if( r ) {
			System.out.println("member 사진 업데이트 성공");
			return true;
		} else {
			System.out.println("member 사진 업데이트 실패");
		}
		return false;
	}

	
	@Override //회원이 신청한 강의목록 표시하기
	public List<VideoVO> showAllAttendingLec() {
		// vdDao.selectAll showAll 해서 비디오 리스를 받을라고함
		return null;
	}
	
}
