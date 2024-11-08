package movie.hub.comment.service;

import java.util.List;

import movie.hub.comment.entity.CommentVO;
import movie.hub.comment.entity.CurCommentVO;
import movie.hub.comment.entity.MyCommentVO;

public interface CommentService {
	void insertComment(CommentVO comment);
	CommentVO getComment(CommentVO comment);
	CurCommentVO getCurComment(CurCommentVO curComment);
	List<CommentVO> getAllCommentList(CommentVO comment);
	List<CurCommentVO> getCommentList(CurCommentVO curComment);
	List<CurCommentVO> sortComments(CurCommentVO curComment);
	List<MyCommentVO> getMyCommentList(MyCommentVO comment);
	void modifyComment(CommentVO comment);
	void deleteCommentByAdmin(CommentVO comment);
	void deleteComment(CommentVO comment);
}
