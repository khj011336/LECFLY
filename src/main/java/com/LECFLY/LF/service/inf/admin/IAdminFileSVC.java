package com.LECFLY.LF.service.inf.admin;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface IAdminFileSVC {
	String DEF_ADMIN_UPLOAD_DEST = "/admin_uploads";
	String DEF_ADMIN_UP_PREFIX = "";
	String ADMIN_MULTI_SEP = "|";
	
	String insertUploadFile(MultipartFile upfile, String realPath) ;

	Map<String, Object> writeUploadedMultipleFiles(List<MultipartFile> upfiles, String realPath, String login);

}
