package com.LECFLY.LF.model.vo;

import java.sql.Timestamp;

public class HomeFileManagerVO {

	/** 순서번호*/
	int id; 
	/** 노출위치          (0: 메인 1:지정위치1 2:지정위치2) 0*/
	int fileDisplayOn;
	/** 노출순서          (0~ 6.  index3 메인노출)*/
	int fileDisplayNum; 
	/** 강의 아이디*/
	String fileLectureId;
	/** 파일 제목*/
	String fileName; 
	/** 파일 경로*/
	String filePath; 
	/** 파일크기*/
	int fileSize; 
	/** 업데이트 날짜 CURRENT_TIMESTAMP*/
	Timestamp updatedDate;

	public HomeFileManagerVO() {
		
	}
	
	/**
	 * full constructor 
	 * @param id
	 * @param fileDisplayOn
	 * @param fileDisplayNum
	 * @param fileName
	 * @param filePath
	 * @param fileSize
	 * @param updatedDate
	 */
	public HomeFileManagerVO(int id, int fileDisplayOn, int fileDisplayNum, String fileName, String filePath,
			int fileSize, Timestamp updatedDate) {
		super();
		this.id = id;
		this.fileDisplayOn = fileDisplayOn;
		this.fileDisplayNum = fileDisplayNum;
		this.fileName = fileName;
		this.filePath = filePath;
		this.fileSize = fileSize;
		this.updatedDate = updatedDate;
	}
	
	public String getFileLectureId() {
		return fileLectureId;
	}
	public void setFileLectureId(String fileLectureId) {
		this.fileLectureId = fileLectureId;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFileDisplayOn() {
		return fileDisplayOn;
	}
	public void setFileDisplayOn(int fileDisplayOn) {
		this.fileDisplayOn = fileDisplayOn;
	}
	public int getFileDisplayNum() {
		return fileDisplayNum;
	}
	public void setFileDisplayNum(int fileDisplayNum) {
		this.fileDisplayNum = fileDisplayNum;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public int getFileSize() {
		return fileSize;
	}
	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}
	public Timestamp getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	@Override
	public String toString() {
		return "HomeFileManagerVO [id=" + id + ", fileDisplayOn=" + fileDisplayOn + ", fileDisplayNum=" + fileDisplayNum
				+ ", fileName=" + fileName + ", filePath=" + filePath + ", fileSize=" + fileSize + ", updatedDate="
				+ updatedDate + "]";
	}
	
	
}
