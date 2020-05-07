package com.LECFLY.LF.service.inf.cscenter;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;



public interface ICscenterFileSVC {
	String DEF_UPLOAD_DEST = "/uploads";
	String DEF_UP_PREFIX = "UP_";
	String MULTI_SEP = "|"; //","
	String writeUploadedFile(MultipartFile upfile, String realPath, String userName);
	boolean makeUserDir(HttpSession ses, String login);
	Map<String,Object> writeUploadedMultipleFiles(		
			List<MultipartFile> upfiles, String realPath, String login);
		
	
}
