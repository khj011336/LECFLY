package com.LECFLY.LF.service.impl.creator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.LECFLY.LF.model.dao.inf.creator.ILectureDAO;
import com.LECFLY.LF.model.dao.inf.creator.IVideoDAO;
import com.LECFLY.LF.model.vo.creator.LectureVO;
import com.LECFLY.LF.model.vo.creator.VideoVO;
import com.LECFLY.LF.service.inf.creator.IStatSVC;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class StatSVCImpl implements IStatSVC{
	@Autowired
	ILectureDAO LecDAO;
	@Autowired
	IVideoDAO ViDAO;
	public String StatSvc(Model model , int memberId , int lecId , int net) {
	List<LectureVO> lecvo = LecDAO.selectLectureListForSTAT(memberId);
	int add = 0;
	int likeCount = 0;
	  if(lecvo != null && !lecvo.isEmpty()) {
	  List<VideoVO> videoList = ViDAO.selectVideoTrack(lecvo.get(lecId).getId());
	  System.out.println(videoList);
	  ObjectMapper mapper = new ObjectMapper(); 
	  HashMap<String, Object> videoStat = new HashMap<String, Object>();
	  List<String> title = new ArrayList<String>();
	  List<Integer> like = new ArrayList<Integer>();
	  List<Integer> views = new ArrayList<Integer>();
	  List<Integer> statCfid = new ArrayList<Integer>();
	  List<String> videoTitle = new ArrayList<String>();
	  String mapping = null;
	  for(int i = 0 ; i< lecvo.size(); i++) {
		  title.add(lecvo.get(i).getTitle());
		  statCfid.add(lecvo.get(i).getId());
	  }
	  for(int i = 0 ; i < videoList.size(); i++) {
		  videoTitle.add(videoList.get(i).getTitle());
		 like.add(videoList.get(i).getLikeCount());
		 likeCount +=videoList.get(i).getLikeCount();
		 add += videoList.get(i).getViews();
		views.add(videoList.get(i).getViews());
	  }
	  videoStat.put("videoName",videoTitle);
	  videoStat.put("title", title);
	  videoStat.put("like",like);
	  videoStat.put("views",views);
	  videoStat.put("statCFID",statCfid);
	  videoStat.put("totalview",add);
	  videoStat.put("likeCount",likeCount);
	  try {
		mapping = mapper.writeValueAsString(videoStat);
	} catch (JsonProcessingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  model.addAttribute("videoJson",mapping);
	  model.addAttribute("videoStat",videoStat);
	  }
	  System.out.println(net);
	  if(net == 1) {
		  return "creator/_cre_statistics";
	  }else {
	return "creator/cre_statistics.page";
	  }
	}
}
