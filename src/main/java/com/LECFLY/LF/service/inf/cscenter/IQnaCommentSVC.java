package com.LECFLY.LF.service.inf.cscenter;

import java.util.Date;
import java.util.List;

import com.LECFLY.LF.model.vo.QnaCommentVO;
import com.LECFLY.LF.model.vo.admin.QnaVO;




public interface IQnaCommentSVC {
//	comment_add	
	boolean commentAdd(QnaCommentVO qc);
	boolean commentAdd(String content, int qnaId, int mbId);
//	comment_list /all
	List<QnaCommentVO> commentList();
//	comment_list /article id	
	List<QnaCommentVO> commentListForQna(int qnaId);
//	comment_select_one
	QnaCommentVO commentSelectOne(int id);
//	comment_update
	boolean commentUpdate(QnaCommentVO qc);
//	comment_remove
	boolean commentDelete(int id);
//  comment_count /all
	public Integer[] checkNumberOfComments(List<QnaVO> qaList);
	int checkNumberOfCommentsForQna(int qnaId);
//	Comment_count /member id
	int checkNumberOfCommentsForMember(int mbId);
	
}
