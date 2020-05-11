package com.LECFLY.LF.log.impl;

import javax.naming.SizeLimitExceededException;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartException;

@Service
public class CreatorAOPImpl {
	public void test() {
		System.out.println("test AOP");
	}
 
}
