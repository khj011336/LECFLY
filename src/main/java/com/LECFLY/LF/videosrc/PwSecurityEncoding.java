package etc.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class PwSecurityEncoding {
	private String password;
	private String hashing;
	private String salt;
	
	
	// setter
	public void setPassword(String password) {
		this.password = password;
	}
	
	// getter DB에 사용될 값들
	public String getHashing() {
		return hashing;
	}
	public String getSalt() {
		return salt;
	}
	
	
	// 비밀번호 생성시 사용할 생성자
	public PwSecurityEncoding(String password) throws NoSuchAlgorithmException {
		this(password, makeSalt());
	}
	// 비밀번호 확인시 사용할 생성자
	public PwSecurityEncoding(String password, String salt) throws NoSuchAlgorithmException {
		this(password, pwChange(password + salt), salt);
	}
	// full constructor
	public PwSecurityEncoding(String password, String hashing, String salt) {
		super();
		this.password = password;
		this.hashing = hashing;
		this.salt = salt;
	}
	
	// MessageDigest활용하여 해싱하는 함수
	private static String pwChange(String msg) throws NoSuchAlgorithmException {
	    MessageDigest md = MessageDigest.getInstance("SHA-512");
	    md.update(msg.getBytes());
	    String result = bytesToString(md.digest());
	    return result;
	}
	
	// byte[]를 16진수로 변환하고 이어서 문자열화하는 함수
	private static String bytesToString(byte[] bytes) {
	    StringBuilder builder = new StringBuilder();
	    for (byte b: bytes) {
	      builder.append(String.format("%02x", b));
	    }
	    return builder.toString();
	}
	
	// salt생성하는 함수 *DB에 필수로 저장해야됨*
	private static String makeSalt() {
		String result = "";
		int times = (int)(Math.random()*20);
		for (int i = 0; i < times; i++) {
			int ran = (int)(Math.random()*16);
			if( ran>=0 && ran<10 )
				ran += 48;
			else if( ran>=10 && ran<16 )
				ran += 87;
			result += (char)ran;
		}
		return result;
	}
	
	// 테스트
	public static void main(String[] args) {
		// 임시 DB
		String[] db = new String[2];
		
		// 비밀 번호 생성 테스트
		String password = "1q2w3e4r!";
		String hashing = "";
		String salt = "";
		try {
			PwSecurityEncoding pwEncode = new PwSecurityEncoding(password);
			hashing = pwEncode.getHashing();
			salt = pwEncode.getSalt();
			System.out.println("비밀번호 생성 성공!");
			// db에 저장하는 것 가정
			db[0] = hashing;
			db[1] = salt;
			
		} catch (NoSuchAlgorithmException e) {
			System.out.println("비밀번호 생성 실패");
			e.printStackTrace();
		}
		
		// 비밀 번호 확인(비교)
		Scanner sc = new Scanner(System.in);
		System.out.print("비밀번호를 입력하세요: ");
		String inputPw = sc.next();
		try {
			PwSecurityEncoding pwDecode = new PwSecurityEncoding(inputPw, db[1]);
			
			// db에서 확인하는 것 가정
			if( pwDecode.getHashing().equals(db[0]) ) {
				System.out.println("해시: "+ db[0]);
				System.out.println("솔트: "+ db[1]);
				System.out.println("비밀번호 일치!");
				
			} else { 
				System.out.println("비밀번호 불일치...");
			}
		} catch (NoSuchAlgorithmException e) {
			System.out.println("비밀번호 해시 생성 실패");
			e.printStackTrace();
		}
		
	}
}
