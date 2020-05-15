package com.LECFLY.LF.service.impl.creator;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.LECFLY.LF.model.dao.inf.creator.ICreatorDAO;
import com.LECFLY.LF.model.dao.inf.creator.ILectureDAO;
import com.LECFLY.LF.model.vo.creator.CreatorVO;
import com.LECFLY.LF.model.vo.creator.LectureVO;
import com.LECFLY.LF.service.inf.creator.ILectureSVC;
@Service
public class LectureSVCImpl{
	@Autowired
	FileSVCImpl fileSVC;
	public static final int PAGESIZE = 3;
	@Autowired
	ILectureDAO LecDAO;
	@Autowired
	ICreatorDAO CreDAO;
	public List<LectureVO>  showLectureList(int fid,int offset,int order) {
		int  off = (offset-1) *PAGESIZE;
		List<LectureVO> LecVO = LecDAO.selectLectureList(fid, off, PAGESIZE, order);
		
		return LecVO;
	}
	public int checkOfLectureNumber(int fid) {
		int totalRecords = LecDAO.checkNumberOfLectures(fid);
		return 	totalRecords /PAGESIZE +(totalRecords % PAGESIZE == 0? 0:1);
	}
	public void storeProcess(LectureVO LecVO, HttpSession ses , CreatorVO cr,SessionStatus sesStatus,Model model) {
		fileProcessforLectures( LecVO ,  ses ,  model);
		int fid = (Integer)(ses.getAttribute("fid"));
		LecDAO.insertNewLecture(fid,LecVO.getCategory(),
				LecVO.getSubTitle(), LecVO.getTitle(), LecVO.getTitleImg(), LecVO.getInfoImg(), LecVO.getInfoImgb(),
				LecVO.getInfo(), cr.getNickname(),
				cr.getImgPath());
		CreDAO.insertNewCreator(fid, cr.getImgPath(), cr.getName(),
				cr.getNickname(), cr.getCellPhone(), cr.getSNS(), cr.getInfo());
		sesStatus.setComplete();
	}
	public void unloadProcess(String unload,LectureVO LecVO, HttpSession ses , CreatorVO cr,SessionStatus sesStatus) {
		int countNull = 0;
		if (unload.equals("y") ) {
			System.out.println("언로드진입");
			String nullcheck = LecVO.toString();
			String sep[] = nullcheck.split("=");
			for (int i = 0; i < 8; i++) {
				String value = sep[i].split(",")[0].trim();
				if ( !value.equals("0") &&!value.equals("null") &&!value.equals("category")) {
					if(!value.isEmpty()) {
						System.out.println(value);
					countNull++;
					}
				}
			}
			if (countNull >= 3) {
				System.out.println(" lec file > 3");
				int fid = (Integer)(ses.getAttribute("fid"));
				LecDAO.insertNewLecture(fid,LecVO.getCategory(),
						LecVO.getSubTitle(), LecVO.getTitle(), LecVO.getTitleImg(), LecVO.getInfoImg(), LecVO.getInfoImgb(),
						LecVO.getInfo(), cr.getNickname(),
						cr.getImgPath());
				CreDAO.insertNewCreator(fid, cr.getImgPath(), cr.getName(),
						cr.getNickname(), cr.getCellPhone(), cr.getSNS(), cr.getInfo());
				
			}
			sesStatus.setComplete();
		}
	}
	
	public void fileProcessforLectures(LectureVO LcVO , HttpSession ses , Model model) {
		int id = (Integer) ses.getAttribute("id");
		String newimgPath = null;
		String username = (String) ses.getAttribute("membertest");
		String userpath = fileSVC.getPath(username, 1);
		 
		if (LcVO.getTitleImgM() != null && !LcVO.getTitleImgM().isEmpty()) {
			if (fileSVC.makeDir(username)) {
				System.out.println("getTitleImgM진입");
				if (LcVO.getTitleImg()!= null && !LcVO.getTitleImg().isEmpty()) {
					new File(userpath + LcVO.getTitleImg()).delete();
					System.out.println(userpath + LcVO.getTitleImg() + "가 지워졌습니다");
				}
				HashMap<String, String> imgfilepath = (HashMap<String, String>) 
						fileSVC.writeFiles(Arrays.asList(LcVO.getTitleImgM()),userpath, id, username);
				newimgPath = imgfilepath.get(LcVO.getTitleImgM().getOriginalFilename());
				System.out.println(newimgPath +"getTitleImgM등록완료");
				LcVO.setTitleImg(newimgPath);
				LcVO.setTitleImgM(null);
				model.addAttribute(LcVO);
			}
		}
		if (LcVO.getInfoImgM() != null && !LcVO.getInfoImgM().isEmpty()) {
			if (fileSVC.makeDir(username)) {
				System.out.println("getInfoImgM진입");
				if (LcVO.getInfoImg()!= null && !LcVO.getInfoImg().isEmpty()) {
					new File(userpath + LcVO.getInfoImg()).delete();
					System.out.println(userpath + LcVO.getInfoImg() + "가 지워졌습니다");
				}
				HashMap<String, String> imgfilepath = (HashMap<String, String>) 
						fileSVC.writeFiles(Arrays.asList(LcVO.getInfoImgM()),userpath, id, username);
				newimgPath = imgfilepath.get(LcVO.getInfoImgM().getOriginalFilename());
				System.out.println(newimgPath +"imgfilepath등록완료");
				LcVO.setInfoImg(newimgPath);
				LcVO.setInfoImgM(null);
				model.addAttribute(LcVO);
			}
		}
		if (LcVO.getInfoImgbM() != null && !LcVO.getInfoImgbM().isEmpty()) {
			if (fileSVC.makeDir(username)) {
				System.out.println("getInfoImgbM진입");
				if (LcVO.getInfoImgb()!= null && !LcVO.getInfoImgb().isEmpty()) {
					new File(userpath + LcVO.getInfoImgb()).delete();
					System.out.println(userpath + LcVO.getInfoImgb() + "가 지워졌습니다");
				}
				HashMap<String, String> imgfilepath = (HashMap<String, String>) 
						fileSVC.writeFiles(Arrays.asList(LcVO.getInfoImgbM()),userpath, id, username);
				newimgPath = imgfilepath.get(LcVO.getInfoImgbM().getOriginalFilename());
				System.out.println(newimgPath +"getInfoImgb등록완료");
				LcVO.setInfoImgb(newimgPath);
				LcVO.setInfoImgbM(null);
				model.addAttribute(LcVO);
			}
		}
	}
}
