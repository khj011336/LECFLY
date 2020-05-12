package com.LECFLY.LF.service.impl.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LECFLY.LF.model.dao.inf.Comment.ICommentDAO;
import com.LECFLY.LF.model.vo.CommentVO;
import com.LECFLY.LF.service.inf.comment.ICommentSVC;

@Service
public class CommentSVCImpl implements ICommentSVC {

	@Autowired
	private ICommentDAO ctDao;
//			// 작성 회원으로 조회	(통계 및 마이페이지용)
//		List<CommentVO> selectCommentsByMbId(int mbId);			//작성자별 조회
//			// 작성된 스키마로 분류 조회	(통계에 사용)
//		List<CommentVO> selectCommentsByScheme(int cate);		//작성된 글 종류에 따른 조회
//
//		List<CommentVO> searchCommentsByMbNic(String nicname);	// 작성회원 닉네임으로 검색         
//		List<CommentVO> searchCommentsByMbId(int mbId); 		// 작성회원 id로 검색
//		List<CommentVO> searchCommentsByArticle(int atId);		// 글id로 검색 (해당 댓글을 소유한 글id)
//		List<CommentVO> searchCommentsByContent(String key);	// 댓글에 들어가는 내용 검색
	@Override
	public boolean addComment(CommentVO ct) {
		System.out.println("jdbc:addComment() svc-ing");
		return ctDao.addComment(ct);
	}

	@Override
	public List<CommentVO> selectAllComments() {
		System.out.println("selectAllComments() svc-ing");
		return ctDao.selectAllComments();
	}

	@Override
	public CommentVO selectOneComment(int id) {
		System.out.println("selectOneComment() svc-ing");
		return ctDao.selectOneComment(id);
	}

	@Override
	public List<CommentVO> selectCommentsByAtId(int atId) {
		System.out.println("selectCommentsByAtId() svc-ing");
		return ctDao.selectCommentsByAtId(atId);
	}

	@Override
	public List<CommentVO> selectCommentsByMbId(int mbId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommentVO> selectCommentsByScheme(int cate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommentVO> searchCommentsByMbNic(String nicname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommentVO> searchCommentsByMbId(int mbId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommentVO> searchCommentsByArticle(int atId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommentVO> searchCommentsByContent(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateOneComment(CommentVO ct) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateOneComment(CommentVO ct, String content) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteOneComment(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteOneCommentByVO(CommentVO ct) {
		// TODO Auto-generated method stub
		return false;
	}

}
