package com.moviehub.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moviehub.biz.user.UserVO;
import com.moviehub.biz.user.impl.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/index.do")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/register.do", method=RequestMethod.POST)
	public String registerUser(UserVO vo) {
		userService.registerUser(vo);
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
	public String login(UserVO vo, HttpSession session) {
		UserVO user = userService.getUser(vo);
		
		if(user != null) {
			session.setAttribute("user", user);
			return "index.do";
		}
		return "index.do";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		System.out.println("로그아웃 처리");
		
		session.invalidate();
		return "index.jsp";
	}
}
