package com.LECFLY.LF.model.vo.member;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
@Component("memberVO")
public class MemberVO {
	
	public static final int GENDER_FEMAIL = 1; // 여성
	public static final int GENDER_ADMIN = 2; // 관리자 
	public static final int GENDER_MAIL = 3; // 남성
	public static final int AGREE_RECEIVE_CHECK_NO = 0; // 선택X
	public static final int AGREE_RECEIVE_CHECK_1 = 1; // 1번항목 체크
	public static final int AGREE_RECEIVE_CHECK_2 = 2; // 2번항목 체크
	public static final int AGREE_RECEIVE_CHECK_ALL = 3; // 3모두 체크
	public static final int USE_TICKET_NO = 0; // 이용권없음
	public static final int USE_TICKET_ALL = 1; // 전체권
	public static final int USE_TICKET_3 = 2; // 3개권
	public static final int USE_TICKET_1 = 3; // 1개권
	public static final int CHECK_CREATOR_NOMAL = 0; // 일반회원
	public static final int CHECK_CREATOR_APPLYING = 1; // 신청중인회원
	public static final int CHECK_CREATOR_REFUSAL = 2; // 거절된회원 
	public static final int CHECK_CREATOR_AUTHORITY = 3; // 크리에이터 권한이있는 회원
	
	// toString() 밑에.. Map을 이용하여 위의 fianl int 값을 넣으면 String으로 리턴하는 함수있음
	private static final Map<Integer, String>MAP_OF_GENDER = new HashMap<>(); //
	private static final Map<Integer, String>MAP_OF_AGREE_RECEIVE = new HashMap<>(); // 
	private static final Map<Integer, String>MAP_OF_USE_TICKET = new HashMap<>(); // 
	private static final Map<Integer, String>MAP_OF_CHECK_CREATER = new HashMap<>();	//
	
	int id;                //  id				int                pk ai                    
	String pic;            //  pic				varchar(128)                               
	String name;           //  name				varchar(16)        nn                  
	String nicname;        //  nicname			varchar(32)        nn uq                    
	Timestamp birthday;    //  birthday			Timestamp          nn                    
	int gender;            //  gender			tinyint            nn            (3:남 1여 2:관리자)
	String email;          //  email			varchar(64)        nn                    
	String password;       //  password			varchar(129)       nn                    
	String phNumber;       //  ph_number		varchar(12)        nn                    
	Timestamp joinedAt;    //  joined_at		timestamp      	   default CURRENT_TIMESTAMP                    
	int agreeReceive;      //  agree_receive	tinyint            default 0	 (0:선택x 1:1번항목체크 2:2번항목체크 3:모두체크) 
	int useTicket;         //  use_ticket		tinyint            default 0     (0:이용권없음 1:전체권 2:3개권 3:1개권 ...)
	int checkCreator;      //  check_creator	tinyint            default 0     (0:일반회원 1:신청중인회원 2:거절된 회원 3:크리에이터권한받은 회원)
	int loginCount;        //  login_count		int                                
	Timestamp loginedAt;   //  logined_at		timestamp                          
	String basicAddress;	//	basic_address	varchar(256)
	String detailAddress;	//	detail_address	varchar(256)
	int postalCode;			//	postalcode	int
	String addressName;		//	address_name	varchar(24)
	String receiverName;	//	receiver_name	varchar(24)
	
	/**
	 * 
	 */
	public MemberVO() {
		
	}
	
	
	/**
	 * 최소 회원가입할떄 필요한 최소정보들~
	 * @param name
	 * @param nicname
	 * @param birthday
	 * @param gender
	 * @param email
	 * @param password
	 * @param phNumber
	 */
	public MemberVO(String name, String nicname, Timestamp birthday, int gender, String email,
			String password, String phNumber) {
		this.id = 0;
		this.pic = null;
		this.name = name;
		this.nicname = nicname;
		this.birthday = birthday;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.phNumber = phNumber;
		this.joinedAt = null;
		this.agreeReceive = 0;
		this.useTicket = 0;
		this.checkCreator = 0;
		this.loginCount = 0;
		this.loginedAt = null;
		this.basicAddress = null;
		this.detailAddress = null;
		this.postalCode = 0;
		this.addressName = null;
		this.receiverName = null;
	}
	
	/**
	 * 회원가입시 사진이 있을수도 있어서
	 * @param pic
	 * @param name
	 * @param nicname
	 * @param birthday
	 * @param gender
	 * @param email
	 * @param password
	 * @param phNumber
	 */
	public MemberVO(String pic, String name, String nicname, 
			Timestamp birthday, int gender, String email, String password, String phNumber) {
		this.id = 0;
		this.pic = pic;
		this.name = name;
		this.nicname = nicname;
		this.birthday = birthday;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.phNumber = phNumber;
		this.joinedAt = null;
		this.agreeReceive = 0;
		this.useTicket = 0;
		this.checkCreator = 0;
		this.loginCount = 0;
		this.loginedAt = null;
		this.basicAddress = null;
		this.detailAddress = null;
		this.postalCode = 0;
		this.addressName = null;
		this.receiverName = null;
	}
	
	/**
	 * 세션상에 저장할 VO (패스워드만 세션에 놓지 않음)
	 * @param id
	 * @param pic
	 * @param name
	 * @param nicname
	 * @param birthday
	 * @param gender
	 * @param email
	 * @param phNumber
	 * @param joinedAt
	 * @param agreeReceive
	 * @param useTicket
	 * @param checkCreator
	 * @param loginCount
	 * @param loginedAt
	 * @param basicAddress
	 * @param detailAddress
	 * @param postalCode
	 * @param addressName
	 * @param receiverName
	 */
	public MemberVO(int id, String pic, String name, String nicname, Timestamp birthday, int gender, String email,
			String phNumber, Timestamp joinedAt, int agreeReceive, int useTicket, int checkCreator,
			int loginCount, Timestamp loginedAt, String basicAddress, String detailAddress, int postalCode,
			String addressName, String receiverName) {
		this(id, pic, name, nicname, birthday, gender, email, null, phNumber, joinedAt, 
				agreeReceive, useTicket, checkCreator, loginCount, loginedAt, basicAddress, detailAddress, 
				postalCode, addressName, receiverName);
	}
	
	/**
	 * 회원가입시 받을 모든 정보들 회원가입시에만 사용
	 * @param pic
	 * @param name
	 * @param nicname
	 * @param birthday
	 * @param gender
	 * @param email
	 * @param password
	 * @param phNumber
	 * @param agreeReceive
	 * @param basicAddress
	 * @param detailAddress
	 * @param postalCode
	 */
	public MemberVO(String pic, String name, String nicname, 
			Timestamp birthday, int gender, String email, String password, String phNumber, 
			int agreeReceive, String basicAddress, String detailAddress, int postalCode) {
		
		this(0, pic, name, nicname, birthday, gender, email, password, phNumber, 
				null, agreeReceive, 0, 0, 0, null, basicAddress, detailAddress, postalCode, null, null);
		
	}
	
	/**
	 * full constructor 
	 * @param id
	 * @param pic
	 * @param name
	 * @param nicname
	 * @param birthday
	 * @param gender
	 * @param email
	 * @param password
	 * @param phNumber
	 * @param joinedAt
	 * @param agreeReceive
	 * @param useTicket
	 * @param checkCreator
	 * @param loginCount
	 * @param loginedAt
	 * @param basicAddress
	 * @param detailAddress
	 * @param postalCode
	 * @param addressName
	 * @param receiverName
	 */
	public MemberVO(int id, String pic, String name, String nicname, Timestamp birthday, int gender, String email,
			String password, String phNumber, Timestamp joinedAt, int agreeReceive, int useTicket, int checkCreator,
			int loginCount, Timestamp loginedAt, String basicAddress, String detailAddress, int postalCode,
			String addressName, String receiverName) {
		super();
		this.id = id;
		this.pic = pic;
		this.name = name;
		this.nicname = nicname;
		this.birthday = birthday;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.phNumber = phNumber;
		this.joinedAt = joinedAt;
		this.agreeReceive = agreeReceive;
		this.useTicket = useTicket;
		this.checkCreator = checkCreator;
		this.loginCount = loginCount;
		this.loginedAt = loginedAt;
		this.basicAddress = basicAddress;
		this.detailAddress = detailAddress;
		this.postalCode = postalCode;
		this.addressName = addressName;
		this.receiverName = receiverName;
	}

	//getter
	public int getId() {
		return id;
	}

	public String getPic() {
		return pic;
	}

	public String getName() {
		return name;
	}

	public String getNicname() {
		return nicname;
	}

	public Timestamp getBirthday() {
		return birthday;
	}

	public int getGender() {
		return gender;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getPhNumber() {
		return phNumber;
	}

	public Timestamp getJoinedAt() {
		return joinedAt;
	}

	public int getAgreeReceive() {
		return agreeReceive;
	}

	public int getUseTicket() {
		return useTicket;
	}

	public int getCheckCreator() {
		return checkCreator;
	}

	public int getLoginCount() {
		return loginCount;
	}

	public Timestamp getLoginedAt() {
		return loginedAt;
	}

	public String getbasicAddress() {
		return basicAddress;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public String getAddressName() {
		return addressName;
	}

	public String getReceiverName() {
		return receiverName;
	}

	// setter
	public void setId(int id) {
		this.id = id;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNicname(String nicname) {
		this.nicname = nicname;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhNumber(String phNumber) {
		this.phNumber = phNumber;
	}

	public void setJoinedAt(Timestamp joinedAt) {
		this.joinedAt = joinedAt;
	}

	public void setAgreeReceive(int agreeReceive) {
		this.agreeReceive = agreeReceive;
	}

	public void setUseTicket(int useTicket) {
		this.useTicket = useTicket;
	}

	public void setCheckCreator(int checkCreater) {
		this.checkCreator = checkCreater;
	}

	public void setLoginCount(int loginCount) {
		this.loginCount = loginCount;
	}

	public void setLoginedAt(Timestamp loginedAt) {
		this.loginedAt = loginedAt;
	}

	public void setbasicAddress(String basicAddress) {
		this.basicAddress = basicAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pic=" + pic + ", name=" + name + ", nicname=" + nicname + ", birthday="
				+ birthday + ", gender=" + gender + ", email=" + email + ", password=" + password + ", phNumber="
				+ phNumber + ", joinedAt=" + joinedAt + ", agreeReceive=" + agreeReceive + ", useTicket=" + useTicket
				+ ", checkCreator=" + checkCreator + ", loginCount=" + loginCount + ", loginedAt=" + loginedAt
				+ ", basicAddress=" + basicAddress + ", detailAddress=" + detailAddress + ", postalCode=" + postalCode
				+ ", addressName=" + addressName + ", receiverName=" + receiverName + "]";
	}
	                                                       
	
	
	public static String getValueOfCheckCreator(int checkCreatorKey) {
		MAP_OF_CHECK_CREATER.put(CHECK_CREATOR_NOMAL,"일반회원");
		MAP_OF_CHECK_CREATER.put(CHECK_CREATOR_APPLYING,"신청중인회원");
		MAP_OF_CHECK_CREATER.put(CHECK_CREATOR_REFUSAL,"거절된회원");
		MAP_OF_CHECK_CREATER.put(CHECK_CREATOR_AUTHORITY,"크리에이터 권한이있는 회원");
		return MAP_OF_CHECK_CREATER.get(checkCreatorKey);
	}
	
	public static String getValueOfUseTicket(int useTicketKey) {
		MAP_OF_USE_TICKET.put(USE_TICKET_NO, "이용권없음");
		MAP_OF_USE_TICKET.put(USE_TICKET_1, "전체권");
		MAP_OF_USE_TICKET.put(USE_TICKET_3, "3개권");
		MAP_OF_USE_TICKET.put(USE_TICKET_ALL, "1개권");
		return MAP_OF_USE_TICKET.get(useTicketKey);
	}
	
	public static String getValueOfAgreeReceve(int agreeReceveKey) {
		MAP_OF_AGREE_RECEIVE.put(AGREE_RECEIVE_CHECK_NO, "0. 선택X");
		MAP_OF_AGREE_RECEIVE.put(AGREE_RECEIVE_CHECK_1, "1. 1번항목 체크");
		MAP_OF_AGREE_RECEIVE.put(AGREE_RECEIVE_CHECK_2, "2. 2번항목 체크");
		MAP_OF_AGREE_RECEIVE.put(AGREE_RECEIVE_CHECK_ALL, "3. 모두 체크");
		return MAP_OF_AGREE_RECEIVE.get(agreeReceveKey);
	} 
	
	public static String getValueOfGender(int genderKey) {
		MAP_OF_GENDER.put(GENDER_FEMAIL, "여성");
		MAP_OF_GENDER.put(GENDER_MAIL, "남성");
		MAP_OF_GENDER.put(GENDER_ADMIN, "관리자");
		return MAP_OF_GENDER.get(genderKey); 
	}
	
	
	
	
	
	
}
