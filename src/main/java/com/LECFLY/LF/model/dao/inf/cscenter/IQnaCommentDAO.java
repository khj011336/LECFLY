package com.LECFLY.LF.model.dao.inf.cscenter;

import java.util.List;

import com.LECFLY.LF.model.vo.QnaCommentVO;
import com.LECFLY.LF.model.vo.admin.QnaVO;


public interface IQnaCommentDAO {
//	qnaComment_add	
	boolean qnaCommentAdd(QnaCommentVO qc);
	boolean qnaCommentAdd(String content, int qnaId, int mbId, String mbLogin);
//	qnaComment_list /all
	List<QnaCommentVO> qnaCommentList();
	
//	QnaComment_list /qna id	
	List<QnaCommentVO> qnaCommentListForQna(int qnaId);

//	qnaComment_select_one
	QnaCommentVO qnaCommentSelectOne(int id);
//	qnaComment_update
	boolean qnaCommentUpdate(QnaCommentVO qc);
//	qnaComment_remove
	boolean qnaCommentRemove(int id);
//  qnaComment_count /all
	Integer[] checkNumberOfQnaComments();

//  qnaComment_count /Qna id
	int checkNumberOfQnaCommentsForQna(int qnaId);
	
//	qnaComment_count /member id
	int checkNumberOfQnaCommentsForMember(int mbId);	
}
