# SW 요구사항 명확화

## 개요 
> 인터넷 강의를 서비스해주고, 필요에 따라 펀딩기능을 지원하거나 강의에 필요한 물품들을 위탁 판매하는 서비스

## 주요 요구사항 (Storyboard)
- 
-
-
-

## 액터 (Actors)
- 회원
- 비회원
- 업로더
- 관리자 	

## 주요 기능 (Usecases Diagram)
1.회원가입을 할 수 있다.
2.결제를 할 수 있다.
3.영상을 시청할 수 있다.
4.


## 도메인 (모델/데이터) 정의

### 모델 스키마
- 회원, Member => MemberVO : members table
- 업로더, Uploader => UploaderVO : uploaders table
- 업로더 수익분배내역, ProfitHistoryVO : profit_histories talbe
- 클래스, Class => ClassVO : classes table
- 영상, Video => VideoVO : videos table
- 후기, Postscript => PostscriptVO : postscripts table
- 강의도구, Kit => KitVO : kits table
- 공지사항, Notice => NoticeVO : notices table
- 질문과 답변, Qna => QnaVO : qnas table
- 댓글, Comment => CommentVO : comments table
- 쿠폰목록, Coupon => CouponVO : coupons table
- 결제내역, PayHistory => PayHistoryVO : pay_histories table

### 엔티티 스키마 (ERD- 논리/개념) 
#### MemberVO
- int id	 		<<PK>>	회원번호
- String pic		프로필사진
- String name 		이름
- String nicname 	<<UQ>>	닉네임
- Date birthday 	생년월일
- int gender 		성별	(1:남 2여 3:관리자)
- String email		이메일
- String password	비밀번호(해시값)
- String salt		salt값
- String phNumber 	휴대전화
- String adress 	주소
- int payment 		사용중인 이용권	(0:이용권없음 1:전체권 2:3개권 3:1개권 ...)
- Date joinedAt 	가입일
- String shopCart	장바구니
- int agreeReceive 	수신동의 (0:선택x 1:1번항목체크 2:2번항목체크 3:모두체크) 

- 로그인횟수,최근로그인일자 등....

#### UploaderVO
- int id 			<<PK>> 번호
- int memberId	 	<<FK>> 업로더 개인의 회원번호
- int can			활동 승인 여부	(0:미승인 1:승인)
- String why		미승인 이유

#### ProfitHistoryVO
- int id			<<PK>> 번호
- int uploaderId	<<fk>> 업로더 번호
- int saveMoney		수익금
- int getMoney		출금금액
- Date day			이벤트 생성 날자

#### ClassVO
- int id 			<<pk>>	클래스 번호
- int uploaderId	<<fk>>	강의를 만든 업로더의 번호	
- String title		제목
- int category		카테고리	(1:미술 2:음악 3:요리 4:라이프스타일 5:운동 6:커리어 7:여행)
- String thumbnail	썸네일 
- String tag		태그	
- String introduce	강의소개글
- String introducePic	강의소개글사진
- String introduceCreater	작가소개글	
- Date createdAt	등록날자
- String likeMb		좋아요한회원
- String willMb		찜하기한회원
- String showMb		이용중인회원

#### CommentClassVO
- int id			<<pk>>	댓글번호
- int mbId			<<fk>>	작성회원번호
- String content	댓글 내용
- int parentsId		<<fk>>	부모테이블번호
- int order			순서번호
- int depth			댓글깊이
- Date writedDay	댓글 쓴 날자

#### VideoVO
- int id			<<pk>>	영상번호
- int classId		<<fk>>	클래스번호
- String title		영상제목
- String content	영상내용
- String pic		미리보기 이미지
- Date uploadAt		업로드날자

#### PostscriptVO
- int id			<<pk>>	후기번호
- int classId		<<fk>>	클래스번호
- int mbId			<<fk>>	작성회원번호
- String content	후기 내용
- float rate		별점 평가
- Date writedDay	작성 날자
- int mbIdComt		<<fk>>	댓글 작성회원번호
- String contentComt댓글내용
- Date writeDayComt	댓글작성일자

#### KitVO
- int id			<<pk>>	강의도구번호
- int classId		<<fk>>	클래스번호
- String name		키트 이름
- int price			가격
- String desc		설명
- int inventory		재고량
- Date startedDay	판매시작날자

#### NoticeVO
- int id			<<pk>>	공지사항번호
- String title		제목
- String content	내용
- String file		첨부 사진or영상
- Date writedDay	작성날자
- boolean checkFaq	faq 확인

#### QnaVO
- int id			<<pk>>	질문번호
- int mbId			<<fk>>	질문한 회원번호
- String title		제목
- String content	내용
- String file		첨부 사진or영상
- boolean checkPrivate	비공개 여부
- Date writedDay	작성날자
- int mbIdComt		<<fk>>	댓글 작성회원번호
- String contentComt댓글내용
- Date writeDayComt	댓글작성일자

#### CommentQnaVO
- int id			<<pk>>	댓글번호
- int mbId			<<fk>>	작성회원번호
- String content	댓글 내용
- int parentsId		<<fk>>	부모테이블번호
- int order			순서번호
- int depth			댓글깊이
- Date writedDay	댓글 쓴 날자

#### CouponVO
- int id			<<pk>>	쿠폰순서번호
- String code		쿠폰 코드 번호
- int maker			쿠폰 발행자
- int mbId			<<fk>>쿠폰 보유회원
- boolean useCheck	사용 여부
- int category		쿠폰 종류(1:키트 2:펀딩 3:기타 ~~)
- Date created_day	생성날자 (사용기한 등에 이용)

#### PayHistoryVO
- int id			<<pk>>	결제내역번호
- int buyMbId		<<fk>>	구매회원아이디
- int sellMbId		<<fk>>	판매회원아이디
- String goods		매매품목(이용권or키트)
- int price			총 결제액
- int payWay		결제수단 (1:신용카드 2:무통장입금...)
- Date dealDay		결제날자
- int couponId		<<fk>>	사용한 쿠폰



### DB 스키마 (ERD - 물리적) 

#### members
- int id				회원번호		<<PK>> NN AI
- varchar(45) pic		프로필사진
- varchar(13) name	 	이름 			NN
- varchar(32) nicname 	닉네임		<<UQ>> NN
- timestamp birthday 	생년월일
- tinyint gender 		성별			(1:남 2여 3:관리자)
- varchar(64) email		이메일		NN
- varchar(129) pw		암호(해시값)	NN
- varchar(13) salt		salt값		NN
- varchar(12) ph_number 휴대전화
- varchar(128) adress 	주소
- tinyint payment	 	사용중인 이용권	(0:이용권없음 1:전체권 2:3개권 3:1개권 ...)
- timestamp joined_at	가입일 		NN
- varchar(128) shop_cart장바구니		("kit_id,kit_id,kit_id" 방식으로 저장
- tinyint agree_receive 수신동의 		(0:선택x 1:1번항목체크 2:2번항목체크 3:모두체크) 

- 로그인횟수,최근로그인일자 등....

#### uploaders
- int id 				번호			<<PK>> NN AI
- int mb_id				업로더 회원번호	<<FK>> <<UQ>>
- tinyint can			활동 승인 여부	(0:미승인 1:승인)
- varchar(45) why		미승인 이유

#### profit_histories
- int id				번호			<<PK>> NN AI
- int uploader_id		업로더 번호	<<fk>>
- int save_money		수익금
- int get_money			출금금액
- timestamp day			이벤트 생성 날자

#### classes
- int id 				클래스 번호	<<pk>> NN AI
- int uploader_id		업로더의 번호	<<fk>>
- varchar(64) title		제목
- tinyint category		카테고리		(1:미술 2:음악 3:요리 4:라이프스타일 5:운동 6:커리어 7:여행)
- varchar(128) thumbnail	썸네일 
- varchar(128) tag		태그
- varchar(256) introduce강의소개글
- varchar(128) introduce_pic	강의소개글사진
- varchar(256) introduce_creater작가소개글	
- timestamp created_at	등록날자
- varchar(256) like_mb	좋아요한회원	("mb_id,mb_id,mb_id,..."방식으로 저장)
- varchar(256) will_mb	찜하기한회원	("mb_id,mb_id,mb_id,..."방식으로 저장)
- varchar(256) show_mb	이용중인회원	("mb_id,mb_id,mb_id,..."방식으로 저장)

#### comment_classes
- int id			댓글 번호		<<pk>> NN AI
- int mb_id			작성회원번호	<<fk>>
- varchar(256) content	댓글 내용
- int parents_id	부모테이블번호	<<fk>>
- int order			순서번호
- int depth			댓글깊이
- timestap writed_day	댓글 쓴 날자

#### videos
- int id			영상 번호		<<pk>> NN AI
- int class_id		클래스번호		<<fk>>
- varchar(64) title	영상제목
- varchar(128) content	영상
- varchar(128) pic	미리보기 이미지
- timestamp upload_at	업로드날자

#### postscripts
- int id			후기 번호		<<pk>> NN AI
- int class_id		클래스번호		<<fk>>
- int mb_id			작성회원번호	<<fk>>
- varchar(256) content	후기 내용
- float rate		별점 평가		
- timestamp writed_day	작성 날자
- int mb_id_comt	댓글 작성회원번호	<<fk>>
- varchar(256) content_comt	댓글내용
- timestamp write_day_comt	댓글작성일자

#### kits
- int id			강의도구 번호	<<pk>> NN AI
- int class_id		클래스번호		<<fk>>	
- varchar(45) name	키트 이름		NN
- int price			가격
- varchar(128) desc	설명
- int inventory		재고량
- timestamp started_day	판매시작날자

#### notices
- int id			공지사항 번호	<<pk>> NN AI
- varchar(45) title	제목
- varchar(512) content	내용
- varchar(256) file	첨부 사진or영상	(다수인 경우 ,등 구분용 문자 삽입)
- tinyint check_faq	faq인지 아닌지	(0:일반 1:faq)
- timestamp writed_day	작성날자

#### qnas
- int id			질문 번호		<<pk>> NN AI
- int mb_id			질문한 회원번호	<<fk>>
- varchar(45) title	제목
- varchar(512) content	내용
- varchar(256) file	첨부 사진or영상	(다수인 경우 ,등 구분용 문자 삽입)
- tinyint check_private	비공개 여부	(0:비공개 1:공개)
- timestamp writed_day	작성날자
- int mb_id_comt	댓글 작성회원번호	<<fk>>
- varchar(256) content_comt	댓글내용
- timestamp write_day_comt	댓글작성일자

#### comment_qnas
- int id			댓글 번호		<<pk>> NN AI
- int mb_id			작성회원번호	<<fk>>
- varchar(256) content	댓글 내용
- int parents_id	부모테이블번호	<<fk>>
- int order			순서번호
- int depth			댓글깊이
- timestap writed_day	댓글 쓴 날자

#### coupons
- int id			쿠폰 번호		<<pk>> NN AI
- varchar(17) code	쿠폰 코드 번호
- int maker_id		쿠폰 발행자(회원테이블참조)	<<fk>>
- int mb_id			쿠폰 보유회원	<<fk>>
- tinyint useCheck	사용 여부	(0:미사용 1:사용)
- int category		쿠폰 종류(1:키트 2:펀딩 3:기타 ~~)
- timestamp	created_day	쿠폰 생성 날자	(사용기한등에 이용)

#### pay_histories
- int id			결제내역 번호	<<pk>> NN AI
- int buy_mb_id		구매회원아이디	<<fk>>
- int sell_mb_id	판매회원아이디	<<fk>>
- varchar(45) goods	매매품목명(이용권or키트)
- int price			총 결제액
- tinyint pay_way	결제수단 (1:신용카드 2:무통장입금...)
- timestamp deal_day결제날자
- int coupon_id		사용한 쿠폰	<<fk>>


## 디렉터리구조

### 패키지 구조 정의
src/
src/etc.
src/etc.security.
src/etc.security.PwSecurityEncoding
src/LECFLY.
src/LECFLY.model.
src/LECFLY.model.MemberVO
src/LECFLY.dao.
src/LECFLY.dao.impl.
src/LECFLY.dao.impl.AutopathFFmpeg
src/LECFLY.dao.impl.VideoTimeCut
src/LECFLY.dao.inf.
src/mvc.
src/mvc.CommandHandler
src/mvc.ControllerTemp
src/mvc.nullHandler
src/mvc.package-info

### webcontent 폴더구조 (UI, View)
문맥경로: 
/LF
/LF/home.jsp
/LF/common
	./common/header.jsp 헤더
	./common/footer.jsp 푸터
	./common/main_banner.jsp 메인광고배너
	./common/side_nav.jsp 사이드바
	./common/variable.jspf
	./common/temp.js
/LF/member
	./member/login.jsp 로그인
	./member/join.jsp 가입
	./member/find_id.jsp 아이디찾기
	./member/find_password.jsp 암호찾기
/LF/creator
	./creator/creator_center.jsp 크리에이터 센터
	./creator/creator_profile.jsp 크리에이터 정보 
	./creator/video_upload.jsp 비디오 업로드
	./creator/kit_register.jsp 키트등록
	./creator/class_des.jsp 클래스정보
	./creator/myclass.jsp 클래스
/LF/lecture
	./lecture/lecture_play.jsp 강의수강
	./lecture/lecture_register.jsp 강의등록
	./lecture/lecture_detail.jsp 강의상세정보
/LF/goods/
	./goods/goods_detail.jsp 상품상세정보
	./goods/goods_payment.jsp 상품결제
	./goods/ticket.jsp 이용권목록
	./goods/cart.jsp 장바구니
/LF/funding
	./funding/funding_payment.jsp 펀딩결제
	./funding/funding_register.jsp 펀딩등록
/LF/mypage
	./mypage/edit_profile.jsp 프로필수정
	./mypage/lec_list.jsp 수강목록
	./mypage/like_list.jsp 좋아요 목록
	./mypage/wish_list.jsp 찜하기 목록
	./mypage/coupon.jsp 쿠폰
	./mypage/qna_list.jsp 문의내역
	./mypage/buy_list.jsp 구매내역
/LF/cs_center/
	./cs_center/notice.jsp 공지사항
	./cs_center/qna.jsp 1대1문의
	./cs_center/faq.jsp 자주묻는 질문
	./cs_center/report.jsp 신고

