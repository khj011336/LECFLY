package com.LECFLY.LF.service.impl.creator;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.LECFLY.LF.model.dao.inf.creator.IVideoDAO;
import com.LECFLY.LF.model.vo.creator.VideoVO;
import com.LECFLY.LF.service.inf.creator.IVideoSVC;
@Service
public class VideoSVCImpl implements IVideoSVC {
	@Autowired
	IVideoDAO viDAO ;
	@Autowired
	FileSVCImpl fileSVC;
	final int PAGESIZE = 5;
	public List<VideoVO>  showLectureList(int CFID,int offset) {
		int  off = (offset-1) *PAGESIZE;
	
		return viDAO.selectVideoTrack(CFID, off, PAGESIZE);
	}
	public int checkOfLectureNumber(int CFID) {
		int totalRecords = viDAO.checkNumberOfVideo(CFID);
		return 	totalRecords /PAGESIZE +(totalRecords % PAGESIZE == 0? 0:1);
	}
	public HashMap<String, String> videoProc(VideoVO vio, MultipartFile videoFile , Model model){
		HashMap<String, String> imgfile = new HashMap<String, String>();
		VideoVO videoInput = vio;
		Map<String, String> storedFileName = fileSVC.writeFilesForvideo(videoFile, 1, "gong",vio);
		String png = storedFileName.get("png");
		String gif = storedFileName.get("gif");
		String video = storedFileName.get("video");
		String durationStr = storedFileName.get("duration");
		double duration  =  durationStr == null ? 0 : Double.parseDouble(durationStr);
		imgfile.put("gif", gif);
		imgfile.put("video", video);
		videoInput.setGifPath(gif);
		videoInput.setVideoPath(video);
		videoInput.setDuration((int)duration);
		videoInput.setImgPath(png);
		imgfile.put("png", png);
		model.addAttribute(videoInput);
		return imgfile;
	}
	public boolean insertNewVideo(VideoVO vo) {
		vo.setStatus(1);
		return viDAO.insertNewVideo(vo);
	}
	public String imgProc(VideoVO vio,MultipartFile addimgfile,Model model) {
		 VideoVO video = vio;
		 String png = video.getImgPath();
		if(addimgfile != null && !addimgfile.isEmpty()) {
			String userpath = FileSVCImpl.getPath("gong", 1);
			Map<String, String> changeimg = fileSVC.writeFile(addimgfile,userpath ,1,"gong");
			String splitImg[] = png.split("-");
			if(new File(userpath+splitImg[0]).delete()) {
				System.out.println("img1가 지워졌습니다");
				png = changeimg.get("file") +"-"+splitImg[1];
				System.out.println("추가 png 확인"+png);
				vio.setImgPath(png);
				model.addAttribute(vio);
			}
		}
		return png;
	}
	
	public String showVideoList(int cagtegory, int CFID,int MAXPAGE , int page , Model model ) {
//TODO			cfid 임시 번호 입력 연결후 때 수정
			model.addAttribute("category", cagtegory);
			model.addAttribute("CFId", CFID);
			model.addAttribute("maxPage", MAXPAGE);
			model.addAttribute("videoPage", page);
			model.addAttribute("lecList", showLectureList(CFID, page));
			return "creator/cre_play_list.page";
		
	}
}
