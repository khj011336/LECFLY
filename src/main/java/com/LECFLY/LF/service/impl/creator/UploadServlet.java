package com.LECFLY.LF.service.impl.creator;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
//@MultipartConfig(location = "C:\\fusion11\\apache-tomcat-8.5.50\\uploadTemp"
//,maxFileSize = 1204L,fileSizeThreshold = -1,maxRequestSize = -1)
public class UploadServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter writer = resp.getWriter();
		System.out.println("처리중...");
		String contenttype = req.getContentType();
		System.out.println(contenttype);
		if(contenttype != null && contenttype.toLowerCase().startsWith("multipart/")) {
			printPartInfo(req, writer);
			
		}else {
			System.out.println("예외");
		}
	
	}
	private void printPartInfo(HttpServletRequest req , PrintWriter writer)throws IOException , ServletException {
		Collection<Part> parts = req.getParts();
		for( Part part :parts) {
			System.out.println("<br/> name="+part.getName());
			String contentType = part.getContentType();
			System.out.println("<br/> contentType =" +contentType);
			if(part.getHeader("Content-Disposition").contains("filename=")) {
				
			System.out.println("<br/> size="+part.getSize());
				String fileName = part.getSubmittedFileName();
				System.out.println("<br/> filename="+fileName);
				if(part.getSize() >0) {
					part.write("C:\\fusion11\\"+fileName);
					part.delete();
				}else {
					String value = req.getParameter(part.getName());
					System.out.println("<br/> value = " +value);
				}
				 
			}
		}
	}
	
	
	 
 }