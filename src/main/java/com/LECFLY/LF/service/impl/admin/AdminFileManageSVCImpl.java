package com.LECFLY.LF.service.impl.admin;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.LECFLY.LF.service.inf.admin.IAdminFileSVC;

@Service
public class AdminFileManageSVCImpl implements IAdminFileSVC {

	// 파일이름 짓기
	private String makeUniqueFilename(String oriFile) {
		StringBuffer uniName = new StringBuffer();
		int lastExt = oriFile.lastIndexOf('.');
		String oriFileName = oriFile.substring(0, lastExt);
		String oriExt = oriFile.substring(lastExt+1).toLowerCase();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		UUID uuid = UUID.randomUUID();
		String myuuid = uuid.toString();
		//
		uniName.append(DEF_ADMIN_UP_PREFIX);
		uniName.append(oriFileName+"_");
		uniName.append(sdf.format(new Date())+"_");
		uniName.append(myuuid);
		uniName.append("."+oriExt);
		
		System.out.println(uniName);
		
		return uniName.toString();
	}
	
	// 파일 등록하기
	@Override
	public String insertUploadFile(MultipartFile upfile, String realPath) {
		String filePath = ""; 	
		String oriFilename = "";
		if( upfile != null && !upfile.isEmpty() ) {
			// 파일명 생성부
			oriFilename = upfile.getOriginalFilename();
			String storedFileName = makeUniqueFilename(oriFilename);	
			realPath += "/"+storedFileName;
			
			// 저장부
			File dest = new File(realPath);
			System.out.println("realPath: "+ realPath);
			try {
				upfile.transferTo(dest);
				filePath = DEF_ADMIN_UPLOAD_DEST + "/" +storedFileName;
				return filePath;
			} catch (IllegalStateException e) {	
				e.printStackTrace();				
			} catch (IOException e) {	
				e.printStackTrace();
			}
		}		
		return null;
	}

	// 여러 파일 등록하기
	@Override
	//public String writeUploadedMultipleFiles(
	public Map<String,Object> writeUploadedMultipleFiles(
			List<MultipartFile> upfiles, String realPath, String login) {
		StringBuffer sb = new StringBuffer();
		long totalByte = 0L;
		for (int i = 0; i < upfiles.size(); i++) {
			MultipartFile uf = upfiles.get(i);
			String fp = this.insertUploadFile(uf, realPath);
			if( fp != null) {
				sb.append(fp + (i != upfiles.size()-1 ? ADMIN_MULTI_SEP : ""));
				totalByte += uf.getSize();
			} else {
				System.out.println("파일저장 실패: " + uf.getOriginalFilename());
			}
		}		
		double totalMB = totalByte / (1024.0 * 1024.0);
		int fileCnt = upfiles.size();
		String muliFPs = sb.toString();
		
		HashMap<String,Object> rMap= new HashMap<String, Object>();
		rMap.put("totalMB", new Double(totalMB));
		rMap.put("fileCnt", new Integer(fileCnt));
		rMap.put("muliFPs", muliFPs);
		return rMap;
	}
}
