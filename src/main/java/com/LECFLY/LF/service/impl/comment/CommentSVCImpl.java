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
	public int addComment(
			int mbId, int tableCate, int atId, String comment, String mbNic, int targetCtId) {
		System.out.println("svc:addComment(대댓글 판별 및 order 부여)");
		CommentVO targetCt;
		CommentVO ct;
		int orderNum;
		int depth;
		// 댓글다는 해당 게시글들 판별
		List<CommentVO> ctList = selectCommentsForOrderNumDesc(tableCate, atId);
		if(targetCtId == 0) {
			if(ctList == null)
				orderNum = 0;
			else
				orderNum = ctList.get(0).getOrderNum();
			depth = 0;
			ct = new CommentVO(mbId, tableCate, atId, orderNum, depth, comment, mbNic);
			if(addComment(ct))
				return ADD_COMMENT_SUCCES;
			else
				return ADD_COMMENT_FAIL;
		} else {
			targetCt = selectOneComment(targetCtId);
			if(targetCt == null)
				return NONE_FIND_ATID;
			else {
				orderNum = targetCt.getOrderNum()+1;
				depth = targetCt.getDepth()+1;
				ct = new CommentVO(mbId, tableCate, atId, orderNum, depth, comment, mbNic);
				if(addComment(ct)) {
					if(increaseOrderNumComments(ctList, orderNum))
						return FAIL_INCREASE;
					else
						return ADD_COMMENT_SUCCES;
				} else
					return ADD_COMMENT_FAIL;
			}
		}
		// orderByDesc 필요
	}
	
	@Override
	public boolean addComment(CommentVO ct) {
		System.out.println("svc:addComment(기본 댓글)");
		return ctDao.addComment(ct);
		// ing 
	}

	@Override
	public List<CommentVO> selectAllComments() {
		System.out.println("svc:selectAllComments()");
		return ctDao.selectAllComments();
	}

	@Override
	public CommentVO selectOneComment(int id) {
		System.out.println("svc:selectOneComment()");
		return ctDao.selectOneComment(id);
	}

	@Override
	public List<CommentVO> selectCommentsByAtId(int atId) {
		System.out.println("svc:selectCommentsByAtId()");
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
	public List<CommentVO> selectCommentsForOrderNumAsc(int cate, int atId) {
		System.out.println("svc:selectCommentsForOrderNumDesc");
		return ctDao.selectCommentsForOrderNumAsc(cate, atId);
	}
	
	@Override
	public List<CommentVO> selectCommentsForOrderNumDesc(int cate, int atId) {
		System.out.println("svc:selectCommentsForOrderNumDesc");
		return ctDao.selectCommentsForOrderNumDesc(cate, atId);
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
	public boolean updateOneComment(int id, String content) {
		System.out.println("svc: updateOneComment");
		return ctDao.updateOneComment(id, content);
	}
	
	@Override
	public boolean updateOneComment(CommentVO ct) {
		System.out.println("svc: updateOneComment");
		return updateOneComment(ct.getId(), ct.getComment());
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
	
	@Override
	public boolean increaseOrderNumComments(List<CommentVO> ctList, int order) {
		System.out.println("svc: increaseOrderNumComments");
		int target = ctList.size() - order;
		for (int i = 0; i < target; i++) {
			if(!increaseOrderNumComment(ctList.get(i))) {
				System.out.println(ctList.get(i).getId() + "번 회원 order증가 실패");
				return false;
			}
			System.out.println(ctList.get(i).getId() + "번 회원 order증가 성공");
		}
		return true;
	}
	
	@Override
	public boolean increaseOrderNumComment(CommentVO ct) {
		System.out.println("svc: increaseOrderNumComment");
		return ctDao.increaseOrderNumComment(ct);
	}
}
