package com.LECFLY.LF.service.impl.creator;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.LECFLY.LF.model.vo.creator.CreatorVO;
import com.LECFLY.LF.service.inf.creator.ICreatorSVC;

@Service
public class CreatorSVCImpl implements ICreatorSVC{
	@Autowired
	FileSVCImpl fileSVC;

	public void fileProcessforCreator(CreatorVO CrVO, HttpSession ses, Model model, String username, int userId) {
		String userpath = FileSVCImpl.getPath(username, 1);
		System.out.println("전체 저장경로 ->" + userpath);
		String newimgPath = null;

		if (CrVO.getImgPathM() != null && !CrVO.getImgPathM().isEmpty()) {
			if (fileSVC.makeDir(username)) {
				System.out.println("[Creator ImgPath]진입");
				if (CrVO.getImgPath() != null && !CrVO.getImgPath().isEmpty()) {
					new File(userpath + CrVO.getImgPath()).delete();
					System.out.println(userpath + CrVO.getImgPath() + "가 지워졌습니다");
				}
				HashMap<String, String> imgfilepath = (HashMap<String, String>) fileSVC
						.writeFiles(Arrays.asList(CrVO.getImgPathM()), userpath, userId, username);
				newimgPath = imgfilepath.get(CrVO.getImgPathM().getOriginalFilename());
				System.out.println(newimgPath + "[Creator ImgPath]등록완료");
				CrVO.setImgPath(newimgPath);
				CrVO.setImgPathM(null);
				model.addAttribute(CrVO);
			}
		}
	}
}
