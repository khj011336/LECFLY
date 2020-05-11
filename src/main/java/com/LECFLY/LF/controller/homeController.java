package com.LECFLY.LF.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.LECFLY.LF.model.vo.HomeFileManagerVO;
import com.LECFLY.LF.model.vo.creator.LectureVO;
import com.LECFLY.LF.service.inf.admin.IAdminSiteSVC;
@Controller
public class homeController {
	@Autowired
	private IAdminSiteSVC adSiteSvc;
	
	@RequestMapping(value = "/home.LF", method = RequestMethod.GET )
	public String temphome(HttpSession ses, Model model) {
		System.out.println("도착");
		List<HomeFileManagerVO> bannerList = adSiteSvc.selectBannerList();
		List<Integer> reIds = adSiteSvc.getRecommendIds();
		List<LectureVO> recoList =  adSiteSvc.selectRecommendLectureList(reIds);
		List<LectureVO> nomalList =  adSiteSvc.selectNomalLectureList();
		model.addAttribute("bannerList", bannerList);
		model.addAttribute("recoList", recoList);
		model.addAttribute("nomalList", nomalList);
		return "lecture/main.ho";
	}
	
	// 카테고리 설정 // 출력:${categoryMap[number]}
		@ModelAttribute("categoryMap")
		public Map<String, String> searchcategoryMap() {
			Map<String, String> categoryMap = new HashMap<>();
			categoryMap.put("0", "전체"); 
			categoryMap.put("1", "미술");  
			categoryMap.put("2", "음악"); 
			categoryMap.put("3", "요리"); 
			categoryMap.put("4", "라이프스타일");
			categoryMap.put("5", "운동"); 
			categoryMap.put("6", "커리어"); 
			categoryMap.put("7", "여행"); 
			
			return categoryMap;
		}
		
	// 강의 좋아요 기능 // 추후 비동기 처리
		@RequestMapping(value = "/like_lecture.LF", method = RequestMethod.GET)
		public String likeBtnClick(HttpSession ses, Model model, 
				@RequestParam(value = "status") int status,@RequestParam(value = "memberId") int memberId,@RequestParam(value = "lectureId") int lectureId) {
			boolean r = adSiteSvc.likeBtnClick(status, memberId, lectureId);
			if (r) {
				model.addAttribute("", "");
			} else {
				model.addAttribute("", "");
			}
			return "redirect:home.LF";
		}
		
	// 카테고리별 검색창 이동
		@RequestMapping(value = "/search_category.LF", method = RequestMethod.GET)
		public String searchCategory(@RequestParam(value = "category", defaultValue = "0") String category, Model model) {
			int categoryNum = Integer.parseInt(category);
			List<LectureVO> searchList;
			if (categoryNum == 0) {
				searchList =  adSiteSvc.selectNomalLectureList();
			} else {
				searchList =  adSiteSvc.selectLectureListForCategory(categoryNum);
			}
			model.addAttribute("searchList", searchList);
			model.addAttribute("cateSize", searchList.size());
			return "/lecture/search_category.ho";
		}
		
	// 키워드 검색창 이동
		@RequestMapping(value = "/search.LF", method = RequestMethod.GET)
		public String searchKeyword(@RequestParam(value = "keyword", defaultValue = "검색어 없음")String keyword, Model model) {
			List<LectureVO> searchList =  adSiteSvc.selectLectureListForKeyword(keyword);
			model.addAttribute("searchList", searchList);
			model.addAttribute("cateSize", searchList.size());
			return "/lecture/search.ho";
		}	
	
		
}
