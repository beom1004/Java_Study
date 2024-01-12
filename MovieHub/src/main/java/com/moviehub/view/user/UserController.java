package com.moviehub.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moviehub.biz.user.UserDetailVO;
import com.moviehub.biz.user.UserVO;
import com.moviehub.biz.user.impl.UserDetailService;
import com.moviehub.biz.user.impl.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserDetailService detailService;
	
	@RequestMapping(value="/myProfile.do", method=RequestMethod.GET)
	public String viewProfile() {
		return "myPage.jsp";
	}
	
	@RequestMapping("/detailModify.do")
	public String detailModify(HttpSession session, UserVO user, UserDetailVO detail) {
		user = (UserVO) session.getAttribute("user");
		user.setId(user.getId());
		userService.userModify(user);
		
		detail.setUser_id(user.getId());
		detailService.detailModify(detail);
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
	public String login(UserVO vo, UserDetailVO vd, HttpSession session) {
		UserVO user = userService.getUser(vo);
		vd.setUser_id(user.getId());
		UserDetailVO detail = userService.getDetail(vd);
		
		if(user != null) {
			session.setAttribute("user", user);
			session.setAttribute("detail", detail);
		}
		return "index.do";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		System.out.println("로그아웃 처리");
		
		session.invalidate();
		return "index.do";
	}
}
