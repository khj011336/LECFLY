package com.LECFLY.LF.service.inf.creator;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.support.SessionStatus;

import com.LECFLY.LF.model.vo.creator.CreatorVO;
import com.LECFLY.LF.model.vo.creator.LectureVO;

public interface ILectureSVC {
	List<LectureVO> showLectureList(int fid, int offset, int order);

	int checkOfLectureNumber(int fid);

	void storeProcess(LectureVO LecVO, int memberId, CreatorVO cr, SessionStatus sesStatus, Model model,
			String username, int isCreator);

	void unloadProcess(String unload, LectureVO LecVO, HttpSession ses, CreatorVO cr, SessionStatus sesStatus,
			String username, int memberId, int isCreator);

	void fileProcessforLectures(LectureVO LcVO, int memberId, Model model, String username);
}
