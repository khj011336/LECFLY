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
import com.LECFLY.LF.model.vo.creator.VideoVO;
import com.LECFLY.LF.service.inf.member.IMypageSVC;


@Service
public class MyPageSVCImpl implements IMypageSVC {

	@Autowired
	private IMemberDAO mbDao;
	
	@Autowired
	private IVideoDAO vdDao;
	
//	@Autowired
//	private ICreatorDAO creDao;
	
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

	
	@Override //회원이 신청한수강중인 강의목록(비디오) 표시하기
	public List<LecAttendVO> selectLecToStatusForMbIdStatus(int mbId, int status){
		// 멤버아이디랑 저걸로 판달수있는거 lecType
		List<LecTypeVO> ltList = ltDao.selectAllLecTypeByMbIdStatus(mbId, status);
		//여기서 클래스아이디를 통해 내가 수강중인 비디로들을 뽑아야됨 얼마만큼 저거리스트만큼 돌아야되
		
		
		List<LecAttendVO> rtLaList = new ArrayList<>();
		return null;
	}


	@Override // 회원이 좋아요, 찜하기한 크리에이터의 이미지Path랑 nickName을 리스트로 뽑아야서 맵으로 담을꺼야
	public Map<String, Object> selectVideoAndCreImgPathAndCreNicname(int mbId, int status){
		System.out.println("MyPageSVCImpl / selectVideoAndCreImgPathAndCreNicname()..");
		
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
	

	
}