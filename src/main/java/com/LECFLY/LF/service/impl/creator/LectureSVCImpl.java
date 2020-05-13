package com.LECFLY.LF.service.impl.creator;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.LECFLY.LF.model.dao.inf.creator.ILectureDAO;
import com.LECFLY.LF.model.vo.creator.LectureVO;
import com.LECFLY.LF.service.inf.creator.ILectureSVC;
@Service
public class LectureSVCImpl{
	@Autowired
	FileSVCImpl fileSVC;
	public static final int PAGESIZE = 3;
	@Autowired
	ILectureDAO LecDAO;
	public List<LectureVO>  showLectureList(int fid,int offset,int order) {
		int  off = (offset-1) *PAGESIZE;
		List<LectureVO> LecVO = LecDAO.selectLectureList(fid, off, PAGESIZE, order);
		
		return LecVO;
	}
	public int checkOfLectureNumber(int fid) {
		int totalRecords = LecDAO.checkNumberOfLectures(fid);
		return 	totalRecords /PAGESIZE +(totalRecords % PAGESIZE == 0? 0:1);
	}
	
	public void fileProcessforLectures(LectureVO LcVO , HttpSession ses , Model model) {
		int id = (Integer) ses.getAttribute("id");
		String newimgPath = null;
		String username = (String) ses.getAttribute("membertest");
		String userpath = fileSVC.getPath(username, 1);
		 
		if (LcVO.getTitleImgM() != null && !LcVO.getTitleImgM().isEmpty()) {
			if (fileSVC.makeDir(username)) {
				System.out.println("진입");
				if (LcVO.getTitleImg()!= null || !LcVO.getTitleImg().isEmpty()) {
					new File(userpath + LcVO.getTitleImg()).delete();
					System.out.println(userpath + LcVO.getTitleImg() + "가 지워졌습니다");
				}
				HashMap<String, String> imgfilepath = (HashMap<String, String>) 
						fileSVC.writeFiles(Arrays.asList(LcVO.getTitleImgM()),userpath, id, username);
				newimgPath = imgfilepath.get(LcVO.getTitleImgM().getOriginalFilename());
				System.out.println(newimgPath +"등록완료");
				LcVO.setTitleImg(newimgPath);
				LcVO.setTitleImgM(null);
				model.addAttribute(LcVO);
			}
		}
		if (LcVO.getInfoImgM() != null && !LcVO.getInfoImgM().isEmpty()) {
			if (fileSVC.makeDir(username)) {
				System.out.println("진입");
				if (LcVO.getInfoImg()!= null || !LcVO.getInfoImg().isEmpty()) {
					new File(userpath + LcVO.getInfoImg()).delete();
					System.out.println(userpath + LcVO.getInfoImg() + "가 지워졌습니다");
				}
				HashMap<String, String> imgfilepath = (HashMap<String, String>) 
						fileSVC.writeFiles(Arrays.asList(LcVO.getInfoImgM()),userpath, id, username);
				newimgPath = imgfilepath.get(LcVO.getInfoImgM().getOriginalFilename());
				System.out.println(newimgPath +"등록완료");
				LcVO.setInfoImg(newimgPath);
				LcVO.setInfoImgM(null);
				model.addAttribute(LcVO);
			}
		}
		if (LcVO.getInfoImgbM() != null && !LcVO.getInfoImgbM().isEmpty()) {
			if (fileSVC.makeDir(username)) {
				System.out.println("진입");
				if (LcVO.getInfoImgb()!= null || !LcVO.getInfoImgb().isEmpty()) {
					new File(userpath + LcVO.getInfoImgb()).delete();
					System.out.println(userpath + LcVO.getInfoImgb() + "가 지워졌습니다");
				}
				HashMap<String, String> imgfilepath = (HashMap<String, String>) 
						fileSVC.writeFiles(Arrays.asList(LcVO.getInfoImgbM()),userpath, id, username);
				newimgPath = imgfilepath.get(LcVO.getInfoImgbM().getOriginalFilename());
				System.out.println(newimgPath +"등록완료");
				LcVO.setInfoImgb(newimgPath);
				LcVO.setInfoImgbM(null);
				model.addAttribute(LcVO);
			}
		}
	}
}
