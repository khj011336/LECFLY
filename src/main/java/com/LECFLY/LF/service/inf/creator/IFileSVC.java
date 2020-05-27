package com.LECFLY.LF.service.inf.creator;

import java.util.Collection;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.web.multipart.MultipartFile;
import com.LECFLY.LF.model.vo.creator.VideoVO;

public interface IFileSVC {
	String fileNamingforVideo(String duration, String oriFileName, int id, String username);
	 
	Map<String, String> writeFiles(Collection<MultipartFile> files, String path, int id, String username);

	Map<String, String> writeFile(MultipartFile file, int id, String username);

	boolean makeDir(String username);

	Map<String, String> writeFilesForvideo(MultipartFile file, int id, String username, VideoVO changevideo,
			HttpSession ses);
}
