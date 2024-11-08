package movie.hub.comment.service;

import java.util.List;

import movie.hub.comment.mapper.CommentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import movie.hub.comment.entity.CommentVO;
import movie.hub.comment.entity.CurCommentVO;
import movie.hub.comment.entity.MyCommentVO;


@Service("commentService")
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentDAO commentDAO;
	
	@Override
	public void deleteCommentByAdmin(CommentVO comment) {
		commentDAO.deleteCommentByAdmin(comment);
	}

	@Override
	public List<CommentVO> getAllCommentList(CommentVO comment) {
		return commentDAO.getAllCommentList(comment);
	}

	@Override
	public List<MyCommentVO> getMyCommentList(MyCommentVO comment) {
		return commentDAO.getMyCommentList(comment);
	}

	@Override
	public void modifyComment(CommentVO comment) {
		commentDAO.modifyComment(comment);
	}
	
	@Override
	public void deleteComment(CommentVO comment) {
		commentDAO.deleteComment(comment);
	}

	@Override
	public CommentVO getComment(CommentVO comment) {
		return commentDAO.getComment(comment);
	}

	@Override
	public void insertComment(CommentVO comment) {
		commentDAO.insertComment(comment);
	}

	@Override
	public List<CurCommentVO> getCommentList(CurCommentVO curComment) {
		return commentDAO.getCommentList(curComment);
	}

	@Override
	public CurCommentVO getCurComment(CurCommentVO curComment) {
		return commentDAO.getCurComment(curComment);
	}

	@Override
	public List<CurCommentVO> sortComments(CurCommentVO comment) {
		return commentDAO.getSortComments(comment);
	}
	
}
