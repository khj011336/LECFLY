package com.LECFLY.LF.service.inf.creator;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.LECFLY.LF.model.vo.creator.CreatorVO;

public interface ICreatorSVC {
	void fileProcessforCreator(CreatorVO CrVO, HttpSession ses, Model model, String username, int userId);
}
