package com.LECFLY.LF.service.impl.member;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.InvalidTimeoutException;

import com.LECFLY.LF.model.dao.impl.Test;
import com.LECFLY.LF.model.dao.inf.Comment.ICommentDAO;
import com.LECFLY.LF.model.dao.inf.creator.ICreatorDAO;
import com.LECFLY.LF.model.dao.inf.creator.ILectureDAO;
import com.LECFLY.LF.model.dao.inf.creator.IVideoDAO;
import com.LECFLY.LF.model.dao.inf.cscenter.IQnaCommentDAO;
import com.LECFLY.LF.model.dao.inf.cscenter.IQnaDAO;
import com.LECFLY.LF.model.dao.inf.member.ILecAttendDAO;
import com.LECFLY.LF.model.dao.inf.member.ILecTypeDAO;
import com.LECFLY.LF.model.dao.inf.member.IMemberDAO;
import com.LECFLY.LF.model.vo.LecAttendVO;
import com.LECFLY.LF.model.vo.LecTypeVO;
import com.LECFLY.LF.model.vo.admin.PayHistoryVO;
import com.LECFLY.LF.model.vo.creator.CreatorVO;
import com.LECFLY.LF.model.vo.creator.KitVO;
import com.LECFLY.LF.model.vo.creator.LectureVO;
import com.LECFLY.LF.model.vo.cart.CouponVO;
import com.LECFLY.LF.model.vo.cart.TicketVO;
import com.LECFLY.LF.model.vo.creator.VideoVO;
import com.LECFLY.LF.model.vo.cscenter.QnaCommentVO;
import com.LECFLY.LF.model.vo.cscenter.QnaVO;
import com.LECFLY.LF.model.vo.member.CommentVO;
import com.LECFLY.LF.model.vo.member.MemberVO;
import com.LECFLY.LF.service.inf.member.IMypageSVC;


@Service
public class MyPageSVCImpl implements IMypageSVC {

	@Autowired
	private IMemberDAO mbDao;
	
	@Autowired
	private IVideoDAO vdDao;
	
	@Autowired
	private ICreatorDAO creDao;
	
	@Autowired
	private ILectureDAO lecDao;
	
	@Autowired
	private ICommentDAO comDao;
	
	@Autowired
	private IQnaDAO qnaDao;
	
	@Autowired				// 지금 저기에 분배할 sql 마이페이지에 필요한거 넣어뒀습니다 가져가시고 해당하는 인터페이스 같이 생성해주세요.
	private Test testDao;
	
//	@Autowired
//	private ICouponDAO couponDao;			// 디버그용 잠시닫음
	
	@Autowired
	private ILecTypeDAO ltDao;
	
	@Autowired
	private ILecAttendDAO laDao;
	
//	@Autowired
//	private ITiketDAO tiketDao;
	
//	@Autowired
//	private IPayHistoryDAO phisDao;
	
//	@Autowired  
//	private IKitDAO kitDao; // IKITDAO 로되어있는데 확인부탁.
	
	
	
	private static final int PAGE_SIZE = 10;
	
	public static final int ERR_CONT_PARAM = 20;
	public static final int ERR_DB_PARAM = 21;
	
	public static final Map<Integer, String> MYPAGE_ERR_MAP = new HashMap<Integer, String>(){
		{
			put(ERR_CONT_PARAM, "controller 에서 들어온값 오류");
			put(ERR_DB_PARAM, "DB에 들어가는 값 오류");
		}
	};
	
	
	
	/**
	 *	마이페이지 들어올시 필요한 것들
	 *	Str카테고리리스트 (카테고리 이용권개수에 맞춰서(티켓)), 쿠폰개수, 강의신청 목록개수 + 
	 *	뷰단하단에 아무것도안보여주려고함(ResponseBody json map으로 데이터리턴해야될거같은데) 
	 */
	@Override
	public Map<String, Object> selectMyPageContents(int mbId) {
		System.out.println("selectMyPageContents()..");
		Map<String, Object> rMap = new HashMap<>(); 
		// Str카테고리리스트 (카테고리 이용권개수에 맞춰서(티켓)), 쿠폰개수, 강의신청 목록개수
	
		//쿠폰
		int cntCoupon = // couponDao.checkNumberOfCouponseByMbId(mbId);
				testDao.checkNumberOfCouponseByMbId(mbId);
		
		int cntLecture = 
				ltDao.checkNumberOfLectureByMbIdStatus(mbId, LecTypeVO.STATUS_ATTENDING); // 회원이듣는강의개수
	
		TicketVO ticket = //tiketDao.selectOneTiketByMbId(mbId);
				 testDao.selectOneTiketForCanUseByMbId(mbId);
		
		if(ticket != null) { // 티켓에대한정보들
			int cntUseCategory = ticket.getName();
			String ticketFrontName = "";
			String ticketName = "";
			List<String> strCateList = new ArrayList<>(); 
			System.out.println("mpSvc :: cntUseCategory = " + cntUseCategory);
			if(cntUseCategory == 1) {
				ticketFrontName = "1";
				ticketName = "카테고리 이용권";
				String strCate = 
						LecTypeVO.STR_CATEGORY[Integer.parseInt(ticket.getCategory())];
				strCateList.add(strCate);
			} else if(cntUseCategory == 2) {
				ticketFrontName = "3";
				ticketName = "카테고리 이용권";
				String[] arrayCategories = ticket.getCategory().split("_");
				for (int i = 0; i < arrayCategories.length; i++) {
					String strCate = 
							LecTypeVO.STR_CATEGORY[Integer.parseInt(arrayCategories[i])]; 
					strCateList.add(strCate);
				}
			} else if(cntUseCategory == 3) {
				ticketFrontName = "무제한";
				ticketName = "카테고리 이용권";
				String strCate = "";
				strCateList.add(strCate);
			}
			rMap.put("rt", "ok");
			rMap.put("ticketFrontName", ticketFrontName);
			rMap.put("ticketName", ticketName);
			rMap.put("strCateList", strCateList);
			rMap.put("tiketEndDay", ticket.getEndDay()); // 티켓의 종류날짜
		} else {
			System.out.println("ticket = null");
		}
		rMap.put("cntCoupon", cntCoupon);
		rMap.put("cntLecture", cntLecture);
		return rMap;
	}
	
	
	@Override // 마이페이지 멤버가 사진업데이트 하려면..~~~
	public boolean updateMemberProfileImg(int mbId, String pic) {
		System.out.println("updateMemberProfileImg()..."); 
		boolean r = mbDao.updateMemberProfileImg(mbId, pic); // 미구현
		if( r ) {
			System.out.println("member 사진 업데이트 성공");
			return true;
		} else {
			System.out.println("member 사진 업데이트 실패");
		}
		return false;
	}

	
	/**
	 *	mbId 랑 status 회원이 강의를 수강한건지 or 찜하기한건지 or 좋아요 한건지 구분을하고
	 *	mbId status 를 넣어 해당하는 lectureId를 가지고있는 LecTypeVO List를 뽑고
	 *	LecTypeVOList안에서 classId 를 뽑았으며
	 *	그 classId로 LecAttendVO 를 뽑아서 리스트로담아
	 *	리턴하였음
	 */
	@Override //회원이 신청한수강중인 강의목록(비디오) 표시하기
	public List<LecAttendVO> selectLecToStatusForMbIdStatus(int mbId, int status){
		System.out.println("mpSvc : selectLecToStatusForMbIdStatus()");
		if( mbId > 0 && 
			status >= LecTypeVO.STATUS_ATTENDING &&
			status <= LecTypeVO.STATUS_LIKE ) 
		{
			// 멤버아이디랑 저걸로 판달수있는거 lecType
			List<LecTypeVO> ltList = ltDao.selectAllLecTypeByMbIdStatus(mbId, status);
			
			//여기서 클래스아이디를 통해 내가 수강중인 비디로들을 뽑아야됨 얼마만큼 저거리스트만큼 돌아야되
			if(ltList != null) {
				List<LecAttendVO> rtLaList = new ArrayList<>();
				final int LT_LIST_SIZE = ltList.size();
				for (int i = 0; i < LT_LIST_SIZE; i++) {
					int classId = ltList.get(i).getClassId();
					List<LecAttendVO> laList = laDao.selectAllLecAttendByMbIdClassId(mbId, classId);
					if(laList.size() >= 0) {
						final int LA_LIST_SIZE = laList.size();
						for (int j = 0; j < LA_LIST_SIZE; j++) {
							LecAttendVO la = laList.get(j);
							rtLaList.add(la);
						}
						
					} else {
						System.out.println("laList < 0 ::  음수");
					}
				}
				
				return rtLaList;
			} else {
				System.out.println("ltList == null ");
			}
		} else {
			System.out.println(MYPAGE_ERR_MAP.get(ERR_CONT_PARAM) + 
							" / mbId = " + mbId  + " / status = " + status);
		}
		return null;
	}


	/**
	 *	mbId 랑 status 회원이 강의를 수강한건지 or 찜하기한건지 or 좋아요 한건지 구분을하고
	 *	mbId status 를 넣어 해당하는 lectureId를 가지고있는 LecTypeVO List를 뽑고
	 *	리스트의 갯수만큼 LectureVO 의 파람 7개를 맵으로 뽑아서
	 *	각각의 파람들을 리스트로 만들어서
	 *	맵에담아리턴 Map<"ListName", ListValue>
	 */
	@Override
	public Map<String, Object> selectVideoAndCreImgPathAndCreNicname(int mbId, int status){
		System.out.println("MyPageSVCImpl / selectVideoAndCreImgPathAndCreNicname()..");
		if(mbId > 0 && status >= LecTypeVO.STATUS_ATTENDING 
								&& status <= LecTypeVO.STATUS_LIKE) {
			// 판단하는게 있어야되 회원을기준으로  찜하기/좋아요 한
			List<LecTypeVO> ltList = ltDao.selectAllLecTypeByMbIdStatus(mbId, status);
			if(ltList != null) {
				List<Integer> idList = new ArrayList<>();
				List<String> strCateList = new ArrayList<>();
				List<String> subTitleList = new ArrayList<>();
				List<String> imgPathList = new ArrayList<>();
				List<String> nickNameList = new ArrayList<>();
				List<Integer> likeCountList = new ArrayList<>();
				List<String> creatorImgPathList = new ArrayList<>();
				final int LTLIST_SIZE = ltList.size();
				for (int i = 0; i < LTLIST_SIZE; i++) {
					LecTypeVO lecType = ltList.get(i);
					int classId = lecType.getClassId();
					Map<String,Object> lecParamMap = // lecDao.Map<String, Object> selectOneIdFidCategotySubtitleTitleimgNicknameLikeCountImgPathById(classId); 
							testDao.selectOneIdCategotyTitleTitleimgNicknameLikeCountImgPathById(classId);
					if(lecParamMap != null) {
						int id = (int)lecParamMap.get("id");
						idList.add(id);
						
						int cate = (int)lecParamMap.get("category");
						String strCate = LecTypeVO.STR_CATEGORY[cate];
						strCateList.add(strCate);
						
						
						String subTitle = (String)lecParamMap.get("subtitle");
						subTitleList.add(subTitle);
						
						
						String titleImgPath = (String)lecParamMap.get("title_img");
						imgPathList.add(titleImgPath);
						
						
						String nickName = (String)lecParamMap.get("nickname");
						nickNameList.add(nickName);
						
						
						int likeCount = (int)lecParamMap.get("like_count");
						likeCountList.add(likeCount);
						
						
						/* 	크리에이터 프로필 이미지? 뽑는방법
						 * LectureVO 타입의 객체를 뽑는다. 그곳의 LectureVO.getImgPath() 
						 * 	를 하면 제일마지막 이미지 이름이나옴.<1>
						 * LectureVO.getImgPath().split("_")[1] 하면 크리에이터의 이름이나옴 <2>
						 * creatorDao.get 경로하면 폴더경로가나옴.    ...<3>
						 * <3> + <2> + img + <1> 하면 해당 이미지 사진의 경로가 완성이됨. 
						 * 	(경로니까 사이에 / 없으면 추가해주자)
						*/
						String localPath = "/Images/2020/";// creDao.
						String creImgPath = (String)lecParamMap.get("img_path");
						
						String creNickName = creImgPath.split("_")[1];
						
						String creatorImgPath = localPath + creNickName + "/Img" + creImgPath;
						creatorImgPathList.add(creatorImgPath);
						System.out.println("creatorImgPath = " + creatorImgPath);
					} else {
						System.out.println("lecParamMap == null");
					}
				}
				if( 	idList.size() > 0  && strCateList.size() > 0 && 
						subTitleList.size() > 0 && imgPathList.size() > 0 && 
						nickNameList.size() > 0 && likeCountList.size() > 0 &&
						creatorImgPathList.size() > 0 &&
						idList.size() == strCateList.size() &&
						idList.size() == subTitleList.size() && 
						idList.size() == imgPathList.size() &&
						idList.size() == nickNameList.size() && 
						idList.size() == likeCountList.size() &&
						idList.size() == creatorImgPathList.size() ) 
				{ // 위조건이 참일때.
					Map<String, Object> rMap = new HashMap<>();
					rMap.put("idList", idList);
					rMap.put("cateList", strCateList);
					rMap.put("titleList", subTitleList);
					rMap.put("imgPathList", imgPathList);
					rMap.put("nicList", nickNameList);
					rMap.put("likeCountList", likeCountList);
					rMap.put("creatorImgList", creatorImgPathList);
					return rMap;
				} else {
					System.out.println("list들의 사이즈가 0 이하거나 사이즈가 동일하지않음");
				}
			} else {
				System.out.println("ltList == null");
			}
		} else {
			System.out.println(MYPAGE_ERR_MAP.get(ERR_CONT_PARAM) + 
					" / mbId = " + mbId  + " / status = " + status);
		}
		return null;
	}
	
	public VideoVO selectLecVideo(int vdId) {
//		VideoVO vd = vdDao.selectOneVideo(vdId);
//		return vd;
		return null;
	}

	
	
	@Override
	public Map<String, Object> selectAllMyComment(int mbId, int pn) {
		System.out.println("mpSvc selectAllMyComment().");
		if(mbId > 0) {
			int totalRecords = //comDao.checkNumberOfCommentsForMember(mbId);
					testDao.checkNumberOfCommentsForMember(mbId);
			int maxPG = totalRecords / PAGE_SIZE + (totalRecords % PAGE_SIZE == 0 ? 0 : 1);
			System.out.println("totalRecorde = " + totalRecords + 
					" / maxPG = " + maxPG);
			if(pn > 0 && pn <= maxPG) {
				Map<String, Object> rMap = new HashMap<>();
				int offset = (pn-1) * 10;
				System.out.println("pn = " + pn + ", mbId = " + mbId + 
							", offset = " + offset +" ,PAGE_SIZE = " + PAGE_SIZE);
				List<CommentVO> comList = 
						//comDao.selectAllMyComment(mbId, offset, PAGE_SIZE);
						testDao.selectAllMyComment(mbId, offset, PAGE_SIZE);
				System.out.println("comList = " + comList);
				if(comList.size() >= 0) {
					
					// 원글제목필요함
					List<String> titleList = new ArrayList<>();
					final int COM_LIST_SIZE = comList.size();
					for (int i = 0; i < COM_LIST_SIZE; i++) {
						int id = comList.get(i).getAtId();
						if(comList.get(i).getTableCate() == 0) { //  0:클래스
							String title = //lecDao.selectLectureSubTitleById(id);
											 testDao.selectLectureTitleById(id);
							titleList.add(title);
						} else if(comList.get(i).getTableCate() == 1) { // 1:비디오 
							String title = //vdDao.selectVideoTitleById(id);
											 testDao.selectVideoTitleById(id);
							titleList.add(title);
						}
					}
					rMap.put("totalRecords", totalRecords);
					rMap.put("maxPG", maxPG);
					rMap.put("comList", comList);
					rMap.put("titleList", titleList);
					return rMap;
				} else {
					System.out.println("qnacomList.size() <0 :: 음수");
				}
			} else {
				System.out.println( MYPAGE_ERR_MAP.get(ERR_CONT_PARAM) );
				System.out.println("잘못된 페이지 번호: pn = " + pn);
			}
		}
		return null;
	}

	@Override
	public Map<String, Object> selectAllMyCommentQna(int mbId, int pn) {
		System.out.println("selectAllMyQna()");
		Map<String, Object> rMap = new HashMap<>();
		if(mbId > 0) {
			System.out.println("mbId = " + mbId);
			List<CommentVO> comList = //comDao.showAllCommentsQnasByMemberId(mbId);
									testDao.showAllCommentsQnasByMemberId(mbId);
			if(comList != null) {
				System.out.println( "comList.size() = " + comList.size() );
				int totalRecords = comList.size();
				int maxPG = totalRecords / PAGE_SIZE + (totalRecords % PAGE_SIZE == 0 ? 0 : 1);
				System.out.println("maxPG = " + maxPG);
				System.out.println("totalRecords = " + totalRecords + " / PAGE_SIZE = " + 
						PAGE_SIZE + " / totalRecords % PAGE_SIZE = " + (totalRecords % PAGE_SIZE) );
				if(pn > 0 && pn <= maxPG) {
					List<QnaVO> rtQnaList = new ArrayList<>();
					if(totalRecords > 0 && totalRecords <= PAGE_SIZE) {
						for (int i = 0; i < totalRecords; i++) {
							CommentVO com = comList.get( ((pn-1)*10) + i);
							QnaVO qna = qnaDao.selectOneQna(com.getAtId());
							rtQnaList.add(qna);
						}
					}
					else {
						for (int i = 0; i < PAGE_SIZE; i++) {
							CommentVO com = comList.get( ((pn-1)*10) + i);
							QnaVO qna = qnaDao.selectOneQna(com.getAtId());
							rtQnaList.add(qna);
						}
					}
					System.out.println("totalRecords = " + totalRecords + 
								", maxPG = " + maxPG + ", comList = " + comList );
					rMap.put("totalRecords", totalRecords);
					rMap.put("maxPG", maxPG);
					rMap.put("qnaList", rtQnaList);
					return rMap;
				} else {
					System.out.println("pn > 0 && pn <= maxPG :: false");
					System.out.println("pn = " + pn + " / maxPG = " + maxPG );
					
				}	
			} else {
				System.out.println(MYPAGE_ERR_MAP.get(ERR_DB_PARAM));
				System.out.println("qnaList = null / mbId = " + mbId);
				
			} 
		} else {
			System.out.println(MYPAGE_ERR_MAP.get(ERR_CONT_PARAM));
			System.out.println("mbId = " + mbId);
		}
		return null;
	}

	@Override
	public Map<String, Object> selectAllMyCoupon(int mbId, int pn) {
		Map<String, Object> rMap = new HashMap<>();
		if(mbId > 0) {
			List<CouponVO> couponList = 
						//couponDao.selectAllCouponByMbId(mbId);
						testDao.selectAllCouponByMbId(mbId);
			System.out.println("couponList.size() = " + couponList.size());
			System.out.println("couponList = " + couponList);
			if(couponList.size() > 0) {
				int totalRecords = couponList.size();
				int maxPG = totalRecords / PAGE_SIZE + (totalRecords % PAGE_SIZE == 0 ? 0 : 1);
				if(pn > 0 && pn <= maxPG) {
					List<CouponVO> rtCouponList = new ArrayList<>();
					List<String> strCouponApplyTo = new ArrayList<>();
					List<String> strCanUse = new ArrayList<>();
					if(totalRecords > 0 && totalRecords <= PAGE_SIZE) {
						for (int i = 0; i < totalRecords; i++) { 
							Timestamp creDay = couponList.get( ((pn-1)*10) + i).getCreatedDay();
							Timestamp endDay = couponList.get( ((pn-1)*10) + i).getEndDay();
							int useCheck = couponList.get( ((pn-1)*10) + i).getUseCheck();
							String rtStrCanuse = "";
							if(useCheck == 0 && endDay.getTime() >= System.currentTimeMillis()) {
								rtStrCanuse = "사용가능";
							} else if(useCheck == 1 && endDay.getTime() >= System.currentTimeMillis()) {
								rtStrCanuse = "사용완료";
							} else if(useCheck == 1 && endDay.getTime() <= System.currentTimeMillis()){
								rtStrCanuse = "기간만료";
							}
							strCanUse.add(rtStrCanuse);
							rtCouponList.add(couponList.get( ((pn-1)*10) + i) );
							int applyTo = couponList.get( ((pn-1)*10) + i).getApplyTo();
							String strApplyTo = CouponVO.STR_APPLY_TO[applyTo];
							strCouponApplyTo.add(strApplyTo);
						}
					} else {
						for (int i = 0; i < PAGE_SIZE; i++) {
							Timestamp creDay = couponList.get( ((pn-1)*10) + i).getCreatedDay();
							Timestamp endDay = couponList.get( ((pn-1)*10) + i).getEndDay();
							int useCheck = couponList.get( ((pn-1)*10) + i).getUseCheck();
							String rtStrCanuse = "";
							if(useCheck == 0 && endDay.getTime() >= System.currentTimeMillis()) {
								rtStrCanuse = "사용가능";
							} else if(useCheck == 1 && endDay.getTime() >= System.currentTimeMillis()) {
								rtStrCanuse = "사용완료";
							} else if(useCheck == 1 && endDay.getTime() <= System.currentTimeMillis()){
								rtStrCanuse = "기간만료";
							}
							strCanUse.add(rtStrCanuse);
							rtCouponList.add(couponList.get( ((pn-1)*10) + i) );
							int applyTo = couponList.get( ((pn-1)*10) + i).getApplyTo();
							String strApplyTo = CouponVO.STR_APPLY_TO[applyTo];
							strCouponApplyTo.add(strApplyTo);
						}
					}
					rMap.put("strCanuse", strCanUse);
					rMap.put("strCouponApplyTo", strCouponApplyTo);
					rMap.put("totalRecords", totalRecords);
					rMap.put("maxPG", maxPG);
					rMap.put("qnaList", rtCouponList);
					System.out.println("rtCouponList.size() = " + rtCouponList.size());
					return rMap;
				} else {
					System.out.println("pn > 0 && pn <= maxPG :: false");
					System.out.println("pn = " + pn);
				}	
			} else {
				System.out.println("couponList.size() 는 0 이거나 음수");
				System.out.println("mbId = " + mbId);
			}
		} else {
			System.out.println(MYPAGE_ERR_MAP.get(ERR_CONT_PARAM));
			System.out.println("mbId = " + mbId);		
		}
		return null;
	}


	@Override
	public MemberVO selectOneMember(int mbId) {
		MemberVO mb = mbDao.selectOneMemberById(mbId);
		if(mb != null) {
			return mb;
		}
		return null;
	}


	@Override	/** mypage delivery_info 배송정보 조회*/
	public Map<String, Object> selectMyPageDeliveryInfoMap(int mbId) {
		System.out.println("mpSvc : selectMyPageDeliveryInfoMap()..");
		if(mbId > 0) {
			Map<String, Object> rMap = new HashMap<>();
			List<PayHistoryVO> phisList =  //phisDao.
											testDao.selectAllPayHistoriesByMbId(mbId);
			System.out.println("mp: svc  phisList = " + phisList);
			if(phisList != null) { // 기록이있어야 보여줄수있는것들
				List<CreatorVO> creList = new ArrayList<>();
				List<KitVO> kitList = new ArrayList<>();
				
				int deliveryStatusPaymentWaiting = 0;
				int deliveryStatusDeliveryPreparation = 0;
				int deliveryStatusShippingInProgress = 0;
				int deliveryStatusDeliveryCompleted = 0;
				/* Order confirmation 주문서확인   == Payment waiting 결제 대기중  
					Preparing product 상품준비중 == Delivery Preparation 배송준비
					Shipping in progress 배송중
					Delivery completed 	배송완료		*/
				int kitCount = 0;
				
				final int P_HIS_LIST_SIZE = phisList.size();
				for (int i = 0; i < P_HIS_LIST_SIZE; i++) {
					int deliveryStatus = phisList.get(i).getDeliveryStatus();
					// 상수가 있었으면 좋겠다
					switch(deliveryStatus) {
						case 0: // 주문확인(결제 대기중)
							deliveryStatusPaymentWaiting 
								= (deliveryStatusPaymentWaiting + 1); break;
						case 1: // 상품준비중(배송준비)
							deliveryStatusDeliveryPreparation 
								= (deliveryStatusDeliveryPreparation + 1); break;
						case 2: // 배송중
							deliveryStatusShippingInProgress 
								= (deliveryStatusShippingInProgress + 1); break;
						case 3: // 배송완료
							deliveryStatusDeliveryCompleted 
								= (deliveryStatusDeliveryCompleted + 1); break;
					}
					String creatorIds = phisList.get(i).getSellMbId();
	
					String kitIds = phisList.get(i).getGoodsId();
					
					if(kitIds.length() >= 3) {
						String[] arrayCreatorIds = creatorIds.split("_");
						String[] arrayKitIds = kitIds.split("_");
						kitCount = arrayKitIds.length;
						
						if(arrayCreatorIds.length >= 0 ) {
							
							for (int j = 0; j < arrayKitIds.length; j++) {
								int intCreatorId = Integer.parseInt(arrayCreatorIds[j]);
								int intKitId = Integer.parseInt(arrayKitIds[j]);
								
								// creDao.selectOneCreator(id) <== 이거쓰려고했으나 fid로 찾는거라서 내가찾는거는 Creator를찾는거라 사용할수없었음
								CreatorVO cre = //creDao.selectOneCreatorById(intCreatorId);
												testDao.selectOneCreatorById(intCreatorId);
								KitVO kit = //kitDao.selectOneKitById(intKitId);
											testDao.selectOneKitById(intKitId);
								creList.add(cre);
								kitList.add(kit);
							}
						} else {
							System.out.println("arrayCreatorIds.length 는 음수 ");
						}
					} else {
						
						CreatorVO cre = //creDao.selectOneCreatorById(intCreatorId);
								testDao.selectOneCreatorById(Integer.parseInt(creatorIds));
						KitVO kit = //kitDao.selectOneKitById(intKitId);
								testDao.selectOneKitById(Integer.parseInt(kitIds));
						creList.add(cre);
						kitList.add(kit);
					}
				}
				
				int[] deliveryStatus = { deliveryStatusPaymentWaiting,  
						deliveryStatusDeliveryPreparation, 
						deliveryStatusShippingInProgress, 
						deliveryStatusDeliveryCompleted };
				rMap.put("kitCount", kitCount);
				rMap.put("phisList", phisList);
				rMap.put("creList", creList);
				rMap.put("kitList", kitList);
				rMap.put("deliveryStatusArray", deliveryStatus);
				
			} else {
				System.out.println("phisList == null");
			}
			return rMap;
		} else {
			System.out.println(MYPAGE_ERR_MAP.get(ERR_CONT_PARAM));
			System.out.println("mbId = " + mbId);
		}
		return null;
	}
	
	@Override
	public Map<String, Object> updateOneMemberInfo(MemberVO mb, String nickname, String ph1, String ph2, String agreeEmail, String agreeSms,
			int postalcode, String basicAddress, String detailAddress) {
		System.out.println("svc: updateOneMemberInfo");
		Map<String, Object> rMap = new HashMap<String, Object>();
		if(!nickname.isEmpty() && nickname!=null)
			mb.setNicname(nickname);
		if(!ph1.isEmpty() && ph1!=null && !ph2.isEmpty() && ph2!=null) {
			String ph="010"+ph1+ph2;
			mb.setPhNumber(ph);
		}
//		if(agreeEmail!=null && !agreeEmail.isEmpty() && agreeSms!=null && !agreeSms.isEmpty()) {
//			int agreeReceive = 0;
//			if( agreeEmail.equals("agree_email"))
//				agreeReceive += 1;
//			if( agreeSms.equals("agree_sms"))
//				agreeReceive += 2;
//			mb.setAgreeReceive(agreeReceive);
//		}
		if(agreeEmail==null || agreeEmail.isEmpty() || agreeSms==null || agreeSms.isEmpty()) {
			rMap.put("update_info_msg", "체크박스 오류 발생!");
			return rMap;
		} else{
			int agreeReceive = 0;
			if( agreeEmail.equals("agree_email"))
				agreeReceive += 1;
			if( agreeSms.equals("agree_sms"))
				agreeReceive += 2;
			System.out.println("agree있음");
			mb.setAgreeReceive(agreeReceive);
			System.out.println(mb.getAgreeReceive());
		}
			
		
		if(postalcode!=0)
			mb.setPostalCode(postalcode);
		if(!basicAddress.isEmpty() && basicAddress!=null)
			mb.setbasicAddress(basicAddress);
		if(!detailAddress.isEmpty() && detailAddress!=null)
			mb.setDetailAddress(detailAddress);
		if(updateOneMember(mb)) {
			rMap.put("update_info_msg", "회원정보 수정 성공");
			rMap.put("update_member", mb);
		}else
			rMap.put("update_info_msg", "회원정보 수정 실패");
		return rMap;
	}

	@Override
	public boolean updateOneMember(MemberVO mb) {
		System.out.println("svc: updateOneMember");
		return mbDao.updateOneMemberInfo(mb);
	}
	
	
	@Override
	public Map<String, Object> updateOneMemberPw(String email, String newPw, String newPwConfirm) {
		System.out.println("svc: updateOneMemberPw");
		Map<String, Object> rMap = new HashMap<String, Object>();
		if(newPw.isEmpty() || newPw==null)
			rMap.put("update_pw_msg","새 비밀번호를 입력하세요");
		if(newPwConfirm.isEmpty() || newPwConfirm==null)
			rMap.put("update_pw_msg","새 비밀번호를 다시 입력하세요");
		if(newPw.equals(newPwConfirm)) {
			if(updateOneMember(email, newPw))
				rMap.put("update_pw_msg","비밀번호 변경 성공");
			else
				rMap.put("update_pw_msg","비밀번호 변경 실패");
		} else {
			rMap.put("update_pw_msg","같은 비밀번호를 입력하세요");
		}
		return rMap;
	}
	
	@Override
	public boolean updateOneMember(String email, String pw) {
		System.out.println("svc: updateOneMemberPw");
		return mbDao.updateMemberPasswordToEmail(email, pw);
	}


	@Override
	public Map<String, Object> selectMyPageDeliveryStatMap(int mbId, int deliveryStat) {
		System.out.println("mpSvc : selectMyPageDeliveryStatMap()..");
		System.out.println("mbId = " + mbId + " / deliveryStat = " + deliveryStat);
		if(mbId > 0 && deliveryStat >= 0 && deliveryStat < 4) {
			List<PayHistoryVO> phisList = //phisDao.selectAllPayHistoriesByMbIdDeliveryStatus(mbId, deliveryStat);
											testDao.selectAllPayHistoriesByMbIdDeliveryStatus(mbId, deliveryStat);
			if(phisList != null) {
				for (int i = 0; i < phisList.size(); i++) {
					int order = 10000000 + i;
					phisList.get(i).setCheckSameOrder(String.valueOf(order));
				}
			}
			List<CreatorVO> creList = new ArrayList<>();
			List<KitVO> kitList = new ArrayList<>();
			if(phisList != null) {
				final int PHIS_LIST_SIZE = phisList.size();
				for (int i = 0; i < PHIS_LIST_SIZE; i++) {
					String creatorIds = phisList.get(i).getSellMbId();
					String kitIds = phisList.get(i).getGoodsId();
					// 이부분은 payhistries 에서 구분자를 무엇으로할꺼냐에서 달라진다.
					
					if(creatorIds.length() > 2) {
					
						String[] arrayCreatorIds = creatorIds.split("_");
						String[] arrayKitIds = kitIds.split("_");
						
						
						if(arrayCreatorIds.length >= 0 ) {
							for (int j = 0; j < arrayKitIds.length; j++) {
								int intCreatorId = Integer.parseInt(arrayCreatorIds[j]);
								int intKitId = Integer.parseInt(arrayKitIds[j]);
								System.out.println("intKitId = " + intKitId);
								// creDao.selectOneCreator(id) <== 이거쓰려고했으나 fid로 찾는거라서 내가찾는거는 Creator를찾는거라 사용할수없었음
								CreatorVO cre = //creDao.selectOneCreatorById(intCreatorId);
												testDao.selectOneCreatorById(intCreatorId);
								KitVO kit = //kitDao.selectOneKitById(intKitId);
											testDao.selectOneKitById(intKitId);
								creList.add(cre);
								kitList.add(kit);
							}
						} else {
							System.out.println("arrayCreatorIds.length 는 음수 ");
						}
					} else {
						
						int intCreatorId = Integer.parseInt(creatorIds);
						int intKitId = Integer.parseInt(kitIds);
						CreatorVO cre = //creDao.selectOneCreatorById(intCreatorId);
								testDao.selectOneCreatorById(intCreatorId);
						KitVO kit = //kitDao.selectOneKitById(intKitId);
									testDao.selectOneKitById(intKitId);
						
						creList.add(cre);
						kitList.add(kit);
					}	
				} // for 문끝
				Map<String, Object> rMap = new HashMap<>();
				rMap.put("phisList", phisList);
				rMap.put("creList", creList);
				rMap.put("kitList", kitList);
				System.out.println("creList = " + creList);
				System.out.println("kitList = " + kitList);
				
				return rMap;
			} else {
				System.out.println("phisList == null");
			}
		} else {
			System.out.println(MYPAGE_ERR_MAP.get(ERR_CONT_PARAM));
		}
		return null;
	}

	
	@Override
	public Map<String, Object> showMyPageDeliveryContentsByMbIdDeliveryStat(int mbId, int deliveryStat) {
		System.out.println("mpSvc : showMyPageDeliveryContentsByMbIdDeliveryStat()");
		System.out.println("mbId = " + mbId + " / deliveryStat = " + deliveryStat);
		Map<String, Object> rMap = new HashMap<>();
		if(mbId > 0 && deliveryStat >= 0 && deliveryStat < 4) {
			List<PayHistoryVO> phisList = //phisDao.selectAllPayHistoriesByMbIdDeliveryStatus(mbId, deliveryStat);
									testDao.selectAllPayHistoriesByMbIdDeliveryStatus(mbId, deliveryStat);
			String strDeliveryStat = "";
			switch(deliveryStat) {
				case 0: strDeliveryStat="결제대기"; break;
				case 1: strDeliveryStat="배송준비"; break;
				case 2: strDeliveryStat="배송중"; break;
				case 3: strDeliveryStat="배송완료"; break;
			}
			StringBuffer sbTemp = new StringBuffer();
			sbTemp.append("<div class=\"mypage_bottom_info\">");
			sbTemp.append("<h2 class=\"mypage_bottom_title\"><c:out value=\"" + strDeliveryStat + "\"/></h2>");
			sbTemp.append("<div class=\"mypage_bottom_contents\">");
			sbTemp.append("<div class=\"mypage_table\">");
			
			List<CreatorVO> creList = new ArrayList<>();
			List<KitVO> kitList = new ArrayList<>();
			if(phisList != null) {
				System.out.println("여기들림");
				
				// 들리는데 스트링버퍼에 안담김.. ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅂㄱㅈㅂㅈ거ㅔㅂ먀러ㅔㅂ
				final int PHIS_LIST_SIZE = phisList.size();
				for (int i = 0; i < PHIS_LIST_SIZE; i++) {
					String creatorIds = phisList.get(i).getSellMbId();
					String kitIds = phisList.get(i).getGoodsId();
					// 이부분은 payhistries 에서 구분자를 무엇으로할꺼냐에서 달라진다.
					String[] arrayCreatorIds = creatorIds.split("_");
					String[] arrayKitIds = kitIds.split("_");
					
					sbTemp.append("<table border=\"0\">");
					sbTemp.append("<tr>");
					
					
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
					if(arrayCreatorIds.length >= 0 ) {
						for (int j = 0; j < arrayKitIds.length; j++) {
							int intCreatorId = Integer.parseInt(arrayCreatorIds[j]);
							int intKitId = Integer.parseInt(arrayKitIds[j]);
							
							// creDao.selectOneCreator(id) <== 이거쓰려고했으나 fid로 찾는거라서 내가찾는거는 Creator를찾는거라 사용할수없었음
							CreatorVO cre = //creDao.selectOneCreatorById(intCreatorId);
											testDao.selectOneCreatorById(intCreatorId);
							KitVO kit = //kitDao.selectOneKitById(intKitId);
										testDao.selectOneKitById(intKitId);
							sbTemp.append("<tr>");
							sbTemp.append("<th rowspan=\"3\" style='width: 250px;'><img src=\"<c:out value='" + kit.getImgPath() + "' />\" width=\"240px\" height=\"125px\"></th>");
							sbTemp.append("<td colspan=\"2\"><b><c:out value=\"" + kit.getTitle() + "\" /></b></td><td></td><td><button>주문상세조회</button></td>");
							sbTemp.append("</tr>");
							sbTemp.append("<tr>");
							sbTemp.append("<td>판매자:</td><td><c:out value=\"" + cre.getNickname() + "\" /></td><td>주문번호 : <c:out value=\"" + phisList.get(i).getCheckSameOrder() + "\" /></td><td>주문일자 : " + sdf.format(phisList.get(i).getDealDay()) + "");          
							sbTemp.append("</tr>");
							sbTemp.append("<tr>");
							sbTemp.append("<td>수량: </td><td><c:out value=\"" + phisList.get(i).getBuyProductCount() + "\"/>개</td><td>총 결제금액:</td><td><c:out value=\"" + phisList.get(i).getPayHistorySum() + "\"/>원</td>");
							sbTemp.append("</tr>");
							sbTemp.append("<tr>");
							sbTemp.append("<td></td>");
						}
						sbTemp.append("</tr>");
						sbTemp.append("</table>");
						sbTemp.append("</div>");
						
					} else {
						System.out.println("arrayCreatorIds.length 는 음수 ");
					}
				} // for 문끝
				
			} else {
				System.out.println("phisList == null");
				String strDelStat = "";
				switch(deliveryStat) {
					case 0: strDelStat="결제대기중인"; break;
					case 1: strDelStat="배송준비중인"; break;
					case 2: strDelStat="배송중인"; break;
					case 3: strDelStat="배송완료된"; break;
				}
				
				
				sbTemp.append("<table border=\"0\">");
				sbTemp.append("<tr>");	
				sbTemp.append("<th>현재 <c:out value=\"" + strDelStat + "\"/> 상품이 없습니다.</th>");
				sbTemp.append("</tr>");
				sbTemp.append("</table>");
				sbTemp.append("</div>");
			}
			sbTemp.append("</div>");
			sbTemp.append("</div>");
			rMap.put("template", sbTemp.toString());
			return rMap;
		} else {
			System.out.println(MYPAGE_ERR_MAP.get(ERR_CONT_PARAM));
		}
		return null;
	}
	
	

	@Override
	public Map<String, Object> selectMemberPayHistoriesByPayStatusMbId
												(String payStatus, int mbId) {
		System.out.println("mpSvc :: selectMemberPayHistoriesByPayStatusMbId()");
		if(mbId > 0 && payStatus != null && !payStatus.isEmpty()) {
			int payStat = 0;
			switch(payStatus) {
				case "all" : payStat = 3; break;
				case "tickets" : payStat = 1; break;
				case "kits" : payStat = 2; break;
			}
			// PayHistoryVO 에서 1:이용권 2:키트
			// 상품명 결제금액 구매일 배송상태 카드종류
			List<Map<String,Object>> phisMapList = //phisDao.selectMemberPayHistoryByBuyMbIdgdsType(mbId, payStat);
												testDao.selectMemberPayHistoryByBuyMbIdgdsType(mbId, payStat);
			if(phisMapList != null) {
				final int PHIS_MAP_LIST_SIZE = phisMapList.size(); 
				for (int i = 0; i < PHIS_MAP_LIST_SIZE; i++) {
					Map<String, Object> pMap = phisMapList.get(i);
					int phisId = (int)pMap.get("id");
					String phisGdsId = (String)pMap.get("gds_id"); // split 해서 잘라서 구분해야함 이미위에서 이용권이냐 키트냐로 뽑음 
					int phisPayWay = (int)pMap.get("pay_way"); // 1 이면 신용카드 2면 카카오페이 
					Timestamp phisDealDay = (Timestamp)pMap.get("deal_day");
					String phisCheckSameOrder = (String)pMap.get("check_same_order"); // uuid String ver
					int phisDeliveryStatus = (int)pMap.get("delivery_status"); // 0주문서확인 1상품준비중 2배송중 3 배송완료
					int phisHistorySum = (int)pMap.get("pay_history_sum");
				}
				
				
			} else {
				System.out.println("phisListMap ==  null");
			}
			
		} else {
			System.out.println(MYPAGE_ERR_MAP.get(ERR_CONT_PARAM));
			System.out.println("payStatus = " + payStatus + " / mbId = " + mbId );
		}
		return null;
	}


	@Override
	public Map<String, Object> selectMypagePayHistoryListByMbId(int mbId, int pn) {
		if(mbId > 0) {
			int totalRecords = //phisDao.checkNumberOfPayHistoriesByBuyMbId(mbId);
					testDao.checkNumberOfPayHistoriesByBuyMbId(mbId);
			int maxPG = totalRecords / PAGE_SIZE + (totalRecords % PAGE_SIZE == 0 ? 0 : 1);
			System.out.println("totalRecorde = " + totalRecords + 
					" / maxPG = " + maxPG);
			if(pn > 0 && pn <= maxPG) {
				Map<String, Object> rMap = new HashMap<>();
				int offset = (pn-1) * 10;
				System.out.println("pn = " + pn + ", mbId = " + mbId + 
							", offset = " + offset +" ,PAGE_SIZE = " + PAGE_SIZE);
				List<PayHistoryVO> phisList = 
						//phisDao.selectAllMyPayHistory(mbId, offset, PAGE_SIZE);
						testDao.selectAllMyPayHistory(mbId, offset, PAGE_SIZE);
				for (int i = 0; i < phisList.size(); i++) {
					int order = 10000000 + i;
					phisList.get(i).setCheckSameOrder(String.valueOf(order));
				}
				System.out.println("phisList = " + phisList);
				if(phisList.size() >= 0) {
					List<String> kitTitleList =  new ArrayList<>();
					List<String> payDeliveryStatList =  new ArrayList<>();
					List<String> orderList = new ArrayList<>();
					for (int i = 0; i < phisList.size(); i++) {
						String strKitId = phisList.get(i).getGoodsId();
						KitVO kit = testDao.selectOneKitById(Integer.parseInt(strKitId));
						String kitTitle = kit.getTitle();
						
						kitTitleList.add(kitTitle);
						
						int deliveryStat = phisList.get(i).getDeliveryStatus();
						String strDelStatus = "";
						switch(deliveryStat) {
							case 0: strDelStatus="주문서 확인"; break;
							case 1: strDelStatus="배송준비"; break;
							case 2: strDelStatus="배송중"; break;
							case 3: strDelStatus="배송완료"; break;
						}
						
						
						payDeliveryStatList.add(strDelStatus);
					}
					
					rMap.put("payDeliveryStatList", payDeliveryStatList);
					rMap.put("totalRecords", totalRecords);
					rMap.put("maxPG", maxPG);
					rMap.put("kitTitleList", kitTitleList);
					rMap.put("phisList", phisList);
					return rMap;
				} else {
					System.out.println("qnacomList.size() <0 :: 음수");
				}
			} else {
				System.out.println( MYPAGE_ERR_MAP.get(ERR_CONT_PARAM) );
				System.out.println("잘못된 페이지 번호: pn = " + pn);
			}
		}
		return null;
	}

	


}