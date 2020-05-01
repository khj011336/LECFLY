package com.LECFLY.LF.model.vo;

import java.sql.Timestamp;

public class CSFileManagerVO {
	int id;           //                      순서번호
	int qnaOrNotice;  //                      게시판 구분      0: qna 1: notice
	int contentsId;   //                      글 번호          <<fk>>
	String fileName;     //                      파일제목
	String filePath;     //                      파일경로
	int fileSize;    		 //                      파일크기
	Timestamp updatedDate;  //  CURRENT_TIMESTAMP   업데이트 날짜
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQnaOrNotice() {
		return qnaOrNotice;
	}
	public void setQnaOrNotice(int qnaOrNotice) {
		this.qnaOrNotice = qnaOrNotice;
	}
	public int getContentsId() {
		return contentsId;
	}
	public void setContentsId(int contentsId) {
		this.contentsId = contentsId;
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
	public CSFileManagerVO(int id, int qnaOrNotice, int contentsId, String fileName, String filePath, int fileSize,
			Timestamp updatedDate) {
		super();
		this.id = id;
		this.qnaOrNotice = qnaOrNotice;
		this.contentsId = contentsId;
		this.fileName = fileName;
		this.filePath = filePath;
		this.fileSize = fileSize;
		this.updatedDate = updatedDate;
	}
	@Override
	public String toString() {
		return "CSFileManagerVO [id=" + id + ", qnaOrNotice=" + qnaOrNotice + ", contentsId=" + contentsId
				+ ", fileName=" + fileName + ", filePath=" + filePath + ", fileSize=" + fileSize + ", updatedDate="
				+ updatedDate + "]";
	}
	
	
}
