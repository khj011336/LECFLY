package com.LECFLY.LF.model.dao.inf.member;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.LECFLY.LF.model.vo.MemberVO;

public interface IMemberDAO {
	
	int LOGIN_NOT_FOUND = -1;
	int PASSWORD_MISMATCH = -2;
	
	Map<Integer, String> LOGINERROR_MAP = new HashMap<Integer, String>() {
		{
			put(LOGIN_NOT_FOUND, "이메일(아이디)이 없습니다");
			put(PASSWORD_MISMATCH, "비밀번호가 다릅니다.");
		}
	};
	
	// mb 타입넣으면 insert
	boolean insertNewMember(MemberVO mb);
	
	// 최소 조건 넣으면 insert
	boolean insertNewMember(String name, String nicname, Timestamp 
			birthday, int gender, String email, String password, String phNumber);
	// 최소조건 + 이미지 추가 insert
	boolean insertNewMember(String pic, String name, String nicname, 
			Timestamp birthday, int gender, String email, String password, String phNumber);

	// 모든 회원조회 id asc limit 10
	List<MemberVO> selectAllMemberAscLimitTen();
	
	// 모든 회원조회 id desc limit 10	
	List<MemberVO> selectAllMemberDescLimitTen();
	
	
	// 한달동안 가입한 회원의수 asc limit 10
	List<MemberVO> selectOneMonthInsertMemberAscLimitTen();
	
	// 한달동안 가입한 회원의수 desc limit 10
	List<MemberVO> selectOneMonthInsertMemberDescLimitTen();
	
	
	// id 로 회원조회
	MemberVO selectOneMemberById(int id);
	// nicname 으로 회원조회
	MemberVO selectOneMemberByNicName(String nicname);
	// email로 회원조회
	MemberVO selectOneMemberByEmail(String email);
	// 휴대전화번호로 회원조회
	MemberVO selectOneMemberByPhNumber(String phNumber);
	
	// id를통해 모든정보 update
	boolean updateMemberById(int id, MemberVO mb);
	// nicname를통해 모든정보 update	
	boolean updateMemberByNicName(String nicname, MemberVO mb);
	// email를통해 모든정보 update
	boolean updateMemberByEmail(String email, MemberVO mb);
	// phnumber를통해 모든정보 update
	boolean updateMemberByPhNumber(String phNumber, MemberVO mb);
	// id를통해 nicname 변경
	boolean updateMemberNicnameToId(int id, String nicname);
	// id를통해 eamil 변경
	boolean updateMemberEmailToId(int id, String email);
	// 이안에서 체크하는 게필요함 비밀번호를 바꾸게하려는 id에 해당하는애가 맞는지~~
	boolean updateMemberPasswordToId(int id, String password);
	// id를통해 항목체크를 바꿀수있다 (email 메세지 수신...)
	boolean updateMemberAgreeReceiveById(int id, int agreeReceive);
	// id를통해 있으면 이용권 바꿀수있다.  ==> 이용권 구매할때사용할거같음
	boolean updateMemberUseTicketById(int id, int useTicket);
	
	
	// email를통해 nicname 변경
	boolean updateMemberNicnameToEmail(String email, String nicname);
	// email을 통해 password 변경
	boolean updateMemberPasswordToEmail(String email, String password);
	// email을 통해 항목체크를 바꿀수있다 (email 메세지 수신...)
	boolean updateMemberAgreeReceiveByEmail(String email, int agreeReceive);
	// email을 통해 있으면 이용권 바꿀수있다.  ==> 이용권 구매할때사용할거같음
	boolean updateMemberUseTicketById(String email, int useTicket);
	
	// 로그인할떄 필요할거같음 이메일이랑 패스워드가 맞는지. 안에 select로 찾아야되나봄
	int doubleCheckEmailPassword(String email, String password);
	
	// 로그인이있느지 체크 
	int memberEamil(String email);
	
	// 비밀번호가 같은지 체크
	int memberPassword(String password);
	
//로그인하기
//회원가입하기
//이메일 찾기		
//비밀번호 찾기
//회원이 이용중인 이용권 갯수 표시 (마이페이지 정보 확인하기)
//회원이 보유중인 쿠폰 갯수 표시 (마이페이지 정보 확인하기)
//회원이 수강중인 강의 갯수 확인하기 (마이페이지 정보 확인하기)
//회원이 해당 강의 중 보던 영상 표시하기 (마이페이지 정보 확인하기)
//회원의 프로필 사진 수정하기			
//크리에이터 신청하기	
//회원이 신청한 강의목록 표시하기
//회원이 보던 영상 표시하기	
//회원이 좋아요한 강의 확인하기
//회원이 찜하기한 강의 확인하기		
//회원이 작성한 댓글내역 확인하기	
//회원이 문의한 qna내역 확인하기			
//펀딩신청내역 확인하기
//회원이 보유중인 쿠폰 표시
//회원이 이용중인 이용권 표시
//회원이 가입시 입력한 정보 수정하기
//회원의 비밀번호 변경하기
//회원이 결제한 물품의 배송정보 표시하기
//회원이 결제한 내역 확인하기
//장바구니 목록 확인하기
	
	
	
	
	
	
	
	
	
	// 현재 할 예정인 기능들
//	회원 이용권 구매하기
//
//
//	메인화면에 관리자가 설정한 추천강의 표시
//	메인화면에 카테고리 항목에서 클릭한 종류의 강의 표시
//	검색기능을 통해 관련 강의 알아보기
//
//	강의 상세보기
//	강의에 댓글 작성하기
//	강의 찜하기
//	강의 수강신청하기
//	강의 내 키트를 장바구니에 추가하기
//	강의 내 영상 시청하기
//	강의 좋아요하기
//	강의 후기 남기기
//
//	QnA페이지_게시물 목록 가져오기(개시글 10개씩 페이지 나누기) 
//	QnA페이지_글쓰기
//	QnA페이지_글쓰기 완료 후 게시글 내용페이지로 이동
//	QnA페이지_게시글 내용보기 + 조회수 증가
//	QnA페이지_게시글 수정하기
//	QnA페이지_게시글 수정완료 후 게시글 내용페이지로 이동
//	QnA페이지_게시글삭제
//
//	QnA페이지_게시글에 댓글달기
//	QnA페이지_게시글에 댓글 수정하기
//	QnA페이지_게시글에 댓글 삭제하기
//	QnA페이지_게시글 댓글에 대댓글 달기
//	QnA페이지_게시글 댓글에 대댓글 수정하기
//	QnA페이지_게시글 댓글에 대댓글 삭제하기
//
//	FAQ페이지 열람
//	NOTICE페이지 열람
	
	
	
	
}
