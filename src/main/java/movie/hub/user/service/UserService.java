package movie.hub.user.service;

import java.util.List;

import movie.hub.user.entity.LoginUserVO;
import movie.hub.user.entity.UserCommentVO;
import movie.hub.user.entity.UserDetailVO;
import movie.hub.user.entity.UserVO;

public interface UserService {
	void deleteUser(LoginUserVO user);
	int idCheck(String id);
	LoginUserVO loginCheck(LoginUserVO vo);
	int emailCheck(String email);
	List<LoginUserVO> getAllUserList(LoginUserVO user);
	void registerUser(UserVO vo, UserDetailVO detail);
	UserVO getUser(String id);
	LoginUserVO getUser(LoginUserVO user);
	UserDetailVO getDetail(UserDetailVO detail);
	void widthdrawlUser(String id);
	void modifyUser(LoginUserVO user, LoginUserVO loginUser);
	LoginUserVO getUserData(LoginUserVO user);
	Double getAvgRating(LoginUserVO user);
	List<UserCommentVO> getUserCommentList(UserCommentVO userComment);
}
