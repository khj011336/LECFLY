package com.LECFLY.LF.service.impl.creator;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.support.SessionStatus;

import com.LECFLY.LF.model.dao.inf.creator.ICreatorDAO;
import com.LECFLY.LF.model.dao.inf.creator.ILectureDAO;
import com.LECFLY.LF.model.vo.creator.CreatorVO;
import com.LECFLY.LF.model.vo.creator.LectureVO;
import com.LECFLY.LF.model.vo.member.CommentVO;
import com.LECFLY.LF.service.inf.comment.ICommentSVC;
import com.LECFLY.LF.service.inf.creator.ILectureSVC;
@Service
public class LectureSVCImpl implements ILectureSVC{
	final int INPUT_EMPTY_CHECK = 3;
	final int LECTURE_CHECK_VAR_SIZE = 8;
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
	public void storeProcess(LectureVO LecVO, int memberId , CreatorVO cr,SessionStatus sesStatus,Model model , String username, int isCreator) {
		fileProcessforLectures( LecVO ,  memberId ,  model , username);
		int fid =  memberId;
		
		LecDAO.insertNewLecture(fid,LecVO.getCategory(),
				LecVO.getSubTitle(), LecVO.getTitle(), LecVO.getTitleImg(), LecVO.getInfoImg(), LecVO.getInfoImgb(),
				LecVO.getInfo(),2, cr.getNickname(),
				cr.getImgPath());
		System.out.println("cr값확인");
		if(isCreator != 3) {
		cr.setStatus(2);
		System.out.println("크리에이터 등록완료");
		System.out.println(cr);
		CreDAO.insertNewCreator(fid, cr.getImgPath(), cr.getName(),
				cr.getNickname(), cr.getCellPhone(), cr.getSNS(), cr.getInfo(),2);
		}
		sesStatus.setComplete();
	}
	public void unloadProcess(String unload,LectureVO LecVO, HttpSession ses , CreatorVO cr,SessionStatus sesStatus 
			, String username,int memberId ,int isCreator) {
		int countNull = 0;
		if (unload.equals("y") ) {
			System.out.println("언로드진입 인풋 공백 체크중...");
			String nullcheck = LecVO.toString();
			String sep[] = nullcheck.split("=");
			for (int i = 0; i < LECTURE_CHECK_VAR_SIZE; i++) {
				String value = sep[i].split(",")[0].trim();
				if ( !value.equals("0") &&!value.equals("null") &&!value.equals("category")) {
					if(!value.isEmpty()) {
						System.out.println(value);
					countNull++;
					}
				}
			}
			if (countNull >= INPUT_EMPTY_CHECK) {
				System.out.println(" lecture input 지정사이즈[3]보다 많음 자동저장");
				LecVO.setStatus(4);
				cr.setStatus(4);
				LecDAO.insertNewLecture(memberId,LecVO.getCategory(),
						LecVO.getSubTitle(), LecVO.getTitle(), LecVO.getTitleImg(), LecVO.getInfoImg(), LecVO.getInfoImgb(),
						LecVO.getInfo(),4 ,cr.getNickname(),
						cr.getImgPath());
				if(isCreator != 3) {
				CreDAO.insertNewCreator(memberId, cr.getImgPath(), cr.getName(),
						cr.getNickname(), cr.getCellPhone(), cr.getSNS(), cr.getInfo(),4);
				System.out.println("초기 크레이터 등록");
				}
			}else {
				String path = FileSVCImpl.getPath(username, 1);
				if(LecVO.getImgPath() != null && !LecVO.getImgPath().isEmpty()) {
					if(new File(path+LecVO.getImgPath()).delete()) {
						System.out.println(LecVO.getImgPath()+"[imgPath]언로드로 인해 지워졌습니다");
					}
				}if(LecVO.getInfoImg() != null && !LecVO.getInfoImg().isEmpty()) {
					if(new File(path+LecVO.getInfoImg()).delete()) {
						System.out.println(LecVO.getInfoImg()+"[infoImg]언로드로 인해 지워졌습니다");
					}
				}if(LecVO.getTitleImg()!= null && !LecVO.getTitleImg().isEmpty()) {
					if(new File(path+LecVO.getTitleImg()).delete()) {
						System.out.println(LecVO.getTitleImg()+"[TitleImg]언로드로 인해 지워졌습니다");
					}
				}if(cr.getImgPath()!= null && !cr.getImgPath().isEmpty()) {
					if(new File(path+cr.getImgPath()).delete()) {
						System.out.println(cr.getImgPath()+"[creatorImg]언로드로 인해 지워졌습니다");
					}
				}
			}
			sesStatus.setComplete();
		}
	}
	
	public void fileProcessforLectures(LectureVO LcVO , int memberId , Model model, String username) {
		int id =  memberId;
		String newimgPath = null;
		String userpath = FileSVCImpl.getPath(username, 1);
		 
		if (LcVO.getTitleImgM() != null && !LcVO.getTitleImgM().isEmpty()) {
			if (fileSVC.makeDir(username)) {
				System.out.println("[TitleImg]진입");
				if (LcVO.getTitleImg()!= null && !LcVO.getTitleImg().isEmpty()) {
					new File(userpath + LcVO.getTitleImg()).delete();
					System.out.println(userpath + LcVO.getTitleImg() + "가 지워졌습니다[TitleImg]");
				}
				HashMap<String, String> imgfilepath = (HashMap<String, String>) 
						fileSVC.writeFiles(Arrays.asList(LcVO.getTitleImgM()),userpath, id, username);
				newimgPath = imgfilepath.get(LcVO.getTitleImgM().getOriginalFilename());
				System.out.println(newimgPath +"[TitleImg] 등록완료");
				LcVO.setTitleImg(newimgPath);
				LcVO.setTitleImgM(null);
				model.addAttribute(LcVO);
			}
		}
		if (LcVO.getInfoImgM() != null && !LcVO.getInfoImgM().isEmpty()) {
			if (fileSVC.makeDir(username)) {
				System.out.println("[InfoImg] 진입");
				if (LcVO.getInfoImg()!= null && !LcVO.getInfoImg().isEmpty()) {
					new File(userpath + LcVO.getInfoImg()).delete();
					System.out.println(userpath + LcVO.getInfoImg() + "가 지워졌습니다[InfoImg]");
				}
				HashMap<String, String> imgfilepath = (HashMap<String, String>) 
						fileSVC.writeFiles(Arrays.asList(LcVO.getInfoImgM()),userpath, id, username);
				newimgPath = imgfilepath.get(LcVO.getInfoImgM().getOriginalFilename());
				System.out.println(newimgPath +"[InfoImg] 등록완료");
				LcVO.setInfoImg(newimgPath);
				LcVO.setInfoImgM(null);
				model.addAttribute(LcVO);
			}
		}
		if (LcVO.getInfoImgbM() != null && !LcVO.getInfoImgbM().isEmpty()) {
			if (fileSVC.makeDir(username)) {
				System.out.println("[InfoImg-B-]진입");
				if (LcVO.getInfoImgb()!= null && !LcVO.getInfoImgb().isEmpty()) {
					new File(userpath + LcVO.getInfoImgb()).delete();
					System.out.println(userpath + LcVO.getInfoImgb() + "가 지워졌습니다[InfoImg-B-]");
				}
				HashMap<String, String> imgfilepath = (HashMap<String, String>) 
						fileSVC.writeFiles(Arrays.asList(LcVO.getInfoImgbM()),userpath, id, username);
				newimgPath = imgfilepath.get(LcVO.getInfoImgbM().getOriginalFilename());
				System.out.println(newimgPath +"[InfoImg-B-]등록완료");
				LcVO.setInfoImgb(newimgPath);
				LcVO.setInfoImgbM(null);
				model.addAttribute(LcVO);
			}
		}
	}
	public String tempCommentList(ICommentSVC ctSvc, int CFId, int lecCategory) {
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String comment = "";
//			List<CommentVO> ctList = ctSvc.selectCommentsForOrderNumAsc(lecCategory, CFId);
			List<CommentVO> ctList = ctSvc.selectCommentsForOrderNumAsc(ctSvc.LEC_ARTICLE, CFId);
			comment += "<div id='comment_all' style=\"padding: 40px;\">";
			for (int i = 0; i < ctList.size(); i++) {
				CommentVO ctori = ctList.get(i);
				String dep = "";
				int margin = 0;
				margin = 30;
				if(ctori.getDepth() != 0) {
					dep = "ㄴ";
					margin = margin - ctori.getDepth() * 10;
				} 
				comment += "			<div style='display:inline-block;margin-top:4px; width:160px; "+(ctori.getDepth()==0?"'":" padding-left:"+ctori.getDepth()*10+"px;'")+">"+dep+"<image src='resources/imges/unknown/no_profile_img.PNG' style='width:15px; heigth:15px;'/><label>" + ctori.getMbNic() + "님</label>\r\n</div>" + 
						"				<div style=\"display:inline-block;margin-top:4px; width:400px;  margin-left:"+margin+"px;\"><label style=\" \">" + ctori.getComment() + "</label>\r\n" +
						"				<small style=\"text-align:right; color:lightgrey;\">(" + sdf.format(ctori.getCreatedAt()) +")</small>\r\n" +
						"				<input type=\"hidden\" value='"+ ctori.getId()+"'><i id=\"under_comment\" style=\"padding-left:10px\" class=\"fas fa-comments\"></i>" + 
						"				</div><div id='udner_ct_form'></div>";
			}
			comment += "</div>";
			return comment;
	}
}
