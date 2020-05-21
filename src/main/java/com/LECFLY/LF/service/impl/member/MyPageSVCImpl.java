package com.LECFLY.LF.service.impl.member;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LECFLY.LF.model.dao.impl.Test;

import com.LECFLY.LF.model.dao.inf.creator.ICreatorDAO;
import com.LECFLY.LF.model.dao.inf.creator.ILectureDAO;
import com.LECFLY.LF.model.dao.inf.creator.IVideoDAO;
import com.LECFLY.LF.model.dao.inf.cscenter.IQnaCommentDAO;
import com.LECFLY.LF.model.dao.inf.cscenter.IQnaDAO;
import com.LECFLY.LF.model.dao.inf.member.ILecAttendDAO;
import com.LECFLY.LF.model.dao.inf.member.ILecTypeDAO;
import com.LECFLY.LF.model.dao.inf.member.IMemberDAO;
import com.LECFLY.LF.model.vo.CouponVO;
import com.LECFLY.LF.model.vo.LecAttendVO;
import com.LECFLY.LF.model.vo.MemberVO;
import com.LECFLY.LF.model.vo.QnaCommentVO;
import com.LECFLY.LF.model.vo.QnaVO;
import com.LECFLY.LF.model.vo.LecTypeVO;
import com.LECFLY.LF.model.vo.creator.LectureVO;
import com.LECFLY.LF.model.vo.creator.VideoVO;
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
	
//	@Autowired
//	private IQnaCommentDAO qnacomDao;		// 디버그용 잠시닫음
	
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
		
		return null;
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
			status >= LecTypeVO.STATUS_WILL_ATTENDING &&
			status <= LecTypeVO.STATUS_LIKE ) 
		{
			// 멤버아이디랑 저걸로 판달수있는거 lecType
			List<LecTypeVO> ltList = ltDao.selectAllLecTypeByMbIdStatus(mbId, status);
			//여기서 클래스아이디를 통해 내가 수강중인 비디로들을 뽑아야됨 얼마만큼 저거리스트만큼 돌아야되
			if(ltList != null) {
				List<LecAttendVO> rtLaList = new ArrayList<>();
				final int LT_LIST_SIZE = ltList.size();
				for (int i = 0; i < LT_LIST_SIZE; i++) {
					LecTypeVO lt = ltList.get(i);
					int classId = lt.getClassId();
					LecAttendVO la = laDao.selectOneLecAttendByMbIdClassId(mbId, classId);
					rtLaList.add(la);
				}
				if(rtLaList.size() > 0) {
					return rtLaList;
				}
				System.out.println("rtLaList.size() =< 0  //  0 or 음수 ");
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
		if(mbId > 0 && status >= LecTypeVO.STATUS_WILL_ATTENDING 
								&& status <= LecTypeVO.STATUS_LIKE) {
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
							testDao.selectOneIdFidCategotySubtitleTitleimgNicknameLikeCountImgPathById(classId);
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
						String localPath = "";// creDao.
						String creImgPath = (String)lecParamMap.get("img_path");
						String creNickName = creImgPath.split("_")[1];
						System.out.println("creNickName = " + creNickName);
						String creatorImgPath = localPath + creNickName + "img" + creImgPath;
						creatorImgPathList.add(creatorImgPath);
						
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
			int totalRecords = //qnacomDao.checkNumberOfQnaCommentsForMember(mbId);
					testDao.checkNumberOfQnaCommentsForMember(mbId);
			int maxPG = totalRecords / PAGE_SIZE + (totalRecords % PAGE_SIZE == 0 ? 0 : 1);
			if(pn > 0 && pn <= maxPG) {
				Map<String, Object> rMap = new HashMap<>();
				int offset = (pn-1) * 10;
				System.out.println("pn = " + pn + ", mbId = " + mbId + 
							", offset = " + offset +" ,PAGE_SIZE = " + PAGE_SIZE);
				List<QnaCommentVO> qnacomList = 
						//qnacomDao.selectAllMyComment(mbId, offset, PAGE_SIZE);
						testDao.selectAllMyComment(mbId, offset, PAGE_SIZE);
				System.out.println("qnacomList = " + qnacomList);
				if(qnacomList.size() > 0) {
					final int QNACOM_LIST_SIZE = qnacomList.size();
					List<QnaVO> qnaList = new ArrayList<>(QNACOM_LIST_SIZE);
					for (int i = 0; i < QNACOM_LIST_SIZE; i++) {
						QnaVO qna = qnaDao.selectOneQna(qnacomList.get(i).getQnaId());
						if(qna != null)
							qnaList.add(qna);
						else {
							System.out.println( MYPAGE_ERR_MAP.get(ERR_DB_PARAM) );
							System.out.println("qnacomList.get(i).getQnaId() = " + 
															qnacomList.get(i).getQnaId());
							rMap.put("err", MYPAGE_ERR_MAP.get(ERR_DB_PARAM));
							break;
						}
					}
					rMap.put("totalRecords", totalRecords);
					rMap.put("maxPG", maxPG);
					rMap.put("qnacomList", qnacomList);
					rMap.put("qnaList", qnaList);
					return rMap;
				} else {
					System.out.println("qnacomList.size()는 0 이거나 음수");
				}
			} else {
				System.out.println( MYPAGE_ERR_MAP.get(ERR_CONT_PARAM) );
				System.out.println("잘못된 페이지 번호: pn = " + pn);
			}
		}
		return null;
	}

	@Override
	public Map<String, Object> selectAllMyQna(int mbId, int pn) {
		System.out.println("selectAllMyQna()");
		Map<String, Object> rMap = new HashMap<>();
		if(mbId > 0) {
			System.out.println("mbId = " + mbId);
			List<QnaVO> qnaList = //qnaDao.showAllQnasByMemberId(mbId);
									testDao.showAllQnasByMemberId(mbId);
			if(qnaList != null) {
				System.out.println( "qnaList.size() = " + qnaList.size() );
				int totalRecords = qnaList.size();
				int maxPG = totalRecords / PAGE_SIZE + (totalRecords % PAGE_SIZE == 0 ? 0 : 1);
				System.out.println("maxPG = " + maxPG);
				System.out.println("totalRecords = " + totalRecords + " / PAGE_SIZE = " + 
						PAGE_SIZE + " / totalRecords % PAGE_SIZE = " + (totalRecords % PAGE_SIZE) );
				if(pn > 0 && pn <= maxPG) {
					List<QnaVO> rtQnaList = new ArrayList<>();
					if(totalRecords > 0 && totalRecords <= PAGE_SIZE) {
						for (int i = 0; i < totalRecords; i++) {
							rtQnaList.add(qnaList.get( ((pn-1)*10) + i));
						}
					}
					else {
						for (int i = 0; i < PAGE_SIZE; i++) {
							rtQnaList.add(qnaList.get( ((pn-1)*10) + i));
						}
					}
					System.out.println("totalRecords = " + totalRecords + 
								", maxPG = " + maxPG + ", qnaList = " + qnaList );
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
					if(totalRecords > 0 && totalRecords <= PAGE_SIZE) {
						for (int i = 0; i < totalRecords; i++) { 
							rtCouponList.add(couponList.get( ((pn-1)*10) + i) );
						}
					} else {
						for (int i = 0; i < PAGE_SIZE; i++) { 
							rtCouponList.add(couponList.get( ((pn-1)*10) + i) );
						}
					}
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
		if(mbId > 0) {
			
			
			
			
		} else {
			System.out.println(MYPAGE_ERR_MAP.get(ERR_CONT_PARAM));
			System.out.println("mbId = " + mbId);
		}
		return null;
	}
	
	@Override
	public boolean updateOneMemberInfo(MemberVO mb, String nickname, String ph1, String ph2, String agreeEmail, String agreeSms,
			int postalcode, String basicAddress, String detailAddress) {
		System.out.println("svc: updateOneMemberInfo");
		if(!nickname.isEmpty() && nickname!=null)
			mb.setNicname(nickname);
		if(!ph1.isEmpty() && ph1!=null && !ph2.isEmpty() && ph2!=null) {
			String ph="010"+ph1+ph2;
			mb.setPhNumber(ph);
		}
		if(agreeEmail!=null && !agreeEmail.isEmpty() && agreeSms!=null && !agreeSms.isEmpty()) {
			int agreeReceive = 0;
			if( agreeEmail.equals("agree_email"))
				agreeReceive += 1;
			if( agreeSms.equals("agree_sms"))
				agreeReceive += 2;
			mb.setAgreeReceive(agreeReceive);
		}
		if(postalcode!=0)
			mb.setPostalCode(postalcode);
		if(!basicAddress.isEmpty() && basicAddress!=null)
			mb.setbasicAddress(basicAddress);
		if(!detailAddress.isEmpty() && detailAddress!=null)
			mb.setDetailAddress(detailAddress);
		
		return updateOneMember(mb);
	}

	@Override
	public boolean updateOneMember(MemberVO mb) {
		System.out.println("svc: updateOneMember");
		return mbDao.updateOneMemberInfo(mb);
	}

	
	@Override
	public boolean updateOneMemberPw(String email, String pw) {
		System.out.println("svc: updateOneMemberPw");
		return mbDao.updateMemberPasswordToEmail(email, pw);
	}
}