package com.LECFLY.LF.service.impl.member;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class PwSecurityEncoding {
	private String email;
	
	
	
	public void setEmail(String email) {
		String[] emailFirst = email.split("@");
		if( emailFirst.length >= 2)
			try {
				this.email = PwSecurityEncoding.pwChange(emailFirst[0]+"lec");
			} catch (NoSuchAlgorithmException e) {
				System.out.println("알고리즘 오류");
				this.email = null;
				e.printStackTrace();
			}
		else
			this.email = null;
	}
	public String getEmail() {
		return email;
	}
	public PwSecurityEncoding() {}
	public PwSecurityEncoding(String email) {
		super();
		setEmail(email);
		
	}

	// MessageDigest활용하여 해싱하는 함수
	private static String pwChange(String email) throws NoSuchAlgorithmException {
	    MessageDigest md = MessageDigest.getInstance("SHA-512");
	    md.update(email.getBytes());
	    String str = bytesToString(md.digest());
	    String result = str.substring(str.length()-10, str.length());;
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
	
	// 테스트
	public static void main(String[] args) {
		String test = "se7hyeon7@gmail.com";
		PwSecurityEncoding testing = new PwSecurityEncoding(test);
		System.out.println(test);
		System.out.println(testing.getEmail());
		
	}
}
