package movie.hub.comment.mapper;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import movie.hub.comment.entity.CommentVO;
import movie.hub.comment.entity.CurCommentVO;
import movie.hub.comment.entity.MyCommentVO;

@Repository
public class CommentDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void deleteCommentByAdmin(CommentVO comment) {
		sqlSessionTemplate.delete("comment.deleteCommentByAdmin", comment);
	}
	public List<CurCommentVO> getSortComments(CurCommentVO comment){
		List<CurCommentVO> list = new ArrayList<CurCommentVO>();
		
		if (comment.getSearchKeyword() != null && comment.getSortType() == null) {
	        list = sqlSessionTemplate.selectList("comment.getSearchComments", comment);
	    } else if(comment.getSortType() == null){
	    	list = sqlSessionTemplate.selectList("comment.getSortCommentsDefault", comment);
	    }else if(comment.getSortType() != null){
			list = sqlSessionTemplate.selectList("comment.getSortComments", comment);
		}

		return list;
	}
	public List<CommentVO> getAllCommentList(CommentVO comment) {
		return sqlSessionTemplate.selectList("comment.getAllCommentList", comment);
	}
	public List<MyCommentVO> getMyCommentList(MyCommentVO comment) {
		return sqlSessionTemplate.selectList("comment.getMyCommentList", comment);
	}
	public void modifyComment(CommentVO comment) {
		sqlSessionTemplate.update("comment.modifyComment", comment);
	}
	public void deleteComment(CommentVO comment) {
		sqlSessionTemplate.delete("comment.deleteComment", comment);
	}
	public void insertComment(CommentVO comment) {
		sqlSessionTemplate.insert("comment.insertComment", comment);
	}
	public CommentVO getComment(CommentVO comment) {
		return sqlSessionTemplate.selectOne("comment.getComment", comment);
	}
	public List<CurCommentVO> getCommentList(CurCommentVO curComment) {
		return sqlSessionTemplate.selectList("comment.getCommentList", curComment);
	}
	public CurCommentVO getCurComment(CurCommentVO curComment) {
		sqlSessionTemplate.update("comment.curCommentView", curComment);
		return sqlSessionTemplate.selectOne("comment.getCurComment", curComment);
	}
}
