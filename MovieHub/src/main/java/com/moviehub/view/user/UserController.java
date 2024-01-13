package com.moviehub.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moviehub.biz.user.LoginUserVO;
import com.moviehub.biz.user.UserDetailVO;
import com.moviehub.biz.user.UserVO;
import com.moviehub.biz.user.impl.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/myProfile.do", method=RequestMethod.GET)
	public String viewProfile() {
		return "myPage.jsp";
	}
	
	@RequestMapping("/modifyUser.do")
	public String modifyUser(HttpSession session, LoginUserVO user, LoginUserVO loginUser) {
		loginUser = (LoginUserVO) session.getAttribute("user");
		// 업데이트 할 file, nickname, email, profile_msg를 담은 user, 세션 정보가 담긴 loginUser
		userService.modifyUser(user, loginUser);
		return "index.do";
	}
	
	@RequestMapping("/widthrawl.do")
	public String withdrawlUser(HttpSession session, UserVO user) {
		user = (UserVO) session.getAttribute("user");
	    userService.widthdrawlUser(user.getId());
	    session.invalidate();
		return "index.do";
	}

	@RequestMapping(value="/register.do", method=RequestMethod.POST)
	public String registerUser(UserVO user, UserDetailVO detail) {
		detail.setUser_id(user.getId());
		userService.registerUser(user, detail);
		return "index.do";
	}
	
	@RequestMapping("/emailCheck.do")
	@ResponseBody // ajax 요청에 담긴 값을 java 객체로 변환시켜 인스턴스(boolean)에 저장
	public boolean emailCheck(String email) {	
		String check = null;
		check = userService.emailCheck(email);
		
		if(check != null) return true;
		return false;
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(HttpSession session, LoginUserVO user) {
		user = userService.getUser(user);
		
		if(user != null) {
			session.setAttribute("user", user);
		}
		return "index.do";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index.do";
	}
}
