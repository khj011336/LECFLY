package com.LECFLY.LF.service.impl.creator;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.LECFLY.LF.model.vo.creator.CreatorVO;
@Service
public class CreatorSVCImpl {
	@Autowired
	FileSVCImpl fileSVC;
 public void fileProcessforCreator(CreatorVO CrVO, HttpSession ses ,Model  model) {
	 String username = (String) ses.getAttribute("membertest");
	 int id = (Integer) ses.getAttribute("id");
	 String userpath = fileSVC.getPath(username, 1);
	 String newimgPath = null;
	 
	 if (CrVO.getImgPathM() != null && !CrVO.getImgPathM().isEmpty()) {
			if (fileSVC.makeDir(username)) {
				System.out.println("진입");
				if (CrVO.getImgPath() != null && !CrVO.getImgPath().isEmpty()) {
					new File(userpath + CrVO.getImgPath()).delete();
					System.out.println(userpath + CrVO.getImgPath() + "가 지워졌습니다");
				}
				HashMap<String, String> imgfilepath = (HashMap<String, String>) fileSVC
						.writeFiles(Arrays.asList(CrVO.getImgPathM()), userpath, id, username);
				newimgPath = imgfilepath.get(CrVO.getImgPathM().getOriginalFilename());
				System.out.println(newimgPath +"등록완료");
				CrVO.setImgPath(newimgPath);
				CrVO.setImgPathM(null);
				model.addAttribute(CrVO);
			}
		}
 }
}
