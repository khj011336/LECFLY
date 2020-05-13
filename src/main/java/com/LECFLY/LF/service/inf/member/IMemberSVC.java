package com.LECFLY.LF.service.inf.member;

public interface IMemberSVC {
	// 회원의 id 를 입력하면 사진 업데이트함
	boolean updateMemberProfileImg(int mbId, String filePath);

}
