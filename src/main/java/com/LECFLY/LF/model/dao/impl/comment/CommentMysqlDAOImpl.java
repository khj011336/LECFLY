package com.LECFLY.LF.model.dao.impl.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.LECFLY.LF.model.dao.inf.Comment.ICommentDAO;
import com.LECFLY.LF.model.vo.member.CommentVO;

@Repository
public class CommentMysqlDAOImpl implements ICommentDAO {
	
	public static final String SQL_ADD_COMMNET = "insert into comments value(null,?,?,?,?,?,?,?,now());";
	public static final String SQL_ALL_COMMENTS = "SELECT * FROM comments";
	public static final String SQL_ONE_COMMENTS = "SELECT * FROM comments where id=?";
	public static final String SQL_SHOW_COMMENTS_ASC =
			"SELECT * FROM comments where table_cate=? AND at_id=? ORDER BY order_num";
	public static final String SQL_SHOW_COMMENTS_DESC = 
			"SELECT * FROM comments where table_cate=? AND at_id=? ORDER BY order_num DESC";
	public static final String SQL_INCREASE_ORDER_NUM = 
			"UPDATE comments SET order_num = ? WHERE id = ?"; 
	public static final String SQL_UPDATE_COMMENT = "update comments set comment=? where id=?";
	
	@Autowired
	private JdbcTemplate jtem;
	
	@Override
	public boolean addComment(CommentVO ct) {
		System.out.println("jdbc: addComment");
		int r = jtem.update(SQL_ADD_COMMNET, ct.getMbId(), ct.getTableCate(), ct.getAtId(), ct.getOrderNum(),
				ct.getDepth(), ct.getComment(), ct.getMbNic());
		return r == 1;
	}

	@Override
	public List<CommentVO> selectAllComments() {
		System.out.println("jdbc: selectAllComments");
		return jtem.query(SQL_ALL_COMMENTS, BeanPropertyRowMapper.newInstance(CommentVO.class));
	}

	@Override
	public CommentVO selectOneComment(int id) {
		System.out.println("jdbc: selectOneComment");
		return jtem.queryForObject(SQL_ONE_COMMENTS, BeanPropertyRowMapper.newInstance(CommentVO.class), id);
	}

	@Override
	public List<CommentVO> selectCommentsByAtId(int atId) {
		// TODO Auto-generated method stub
		return null;
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
		System.out.println("jdbc: selectCommentsForOrderNumAsc");
		return jtem.query(SQL_SHOW_COMMENTS_ASC, BeanPropertyRowMapper.newInstance(CommentVO.class), cate, atId);
	}
	
	@Override
	public List<CommentVO> selectCommentsForOrderNumDesc(int cate, int atId) {
		System.out.println("jdbc: selectCommentsForOrderNumDesc");
		return jtem.query(SQL_SHOW_COMMENTS_DESC, BeanPropertyRowMapper.newInstance(CommentVO.class), cate, atId);
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
		System.out.println("jdbc: updateOneComment");
		int r = jtem.update(SQL_UPDATE_COMMENT, content, id);
		return r==1;
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
	public boolean increaseOrderNumComment(CommentVO ct) {
		System.out.println("jdbc: increaseOrderNumComment");
		int r = jtem.update(SQL_INCREASE_ORDER_NUM, ct.getOrderNum()+1, ct.getId());
		return r==1;
	}

}
