package com.LECFLY.LF.service.inf.creator;

import org.springframework.ui.Model;

public interface IStatSVC {
	String StatSvc(Model model , int memberId , int lecId , int net);
}
