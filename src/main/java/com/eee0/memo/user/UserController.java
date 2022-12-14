package com.eee0.memo.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	@GetMapping("/user/signup/view")
	public String singupView() {
		return "user/signup";			
	}
	
	@GetMapping("/user/signin/view")
	public String signinView() {
		return "user/signin";
	}
	
	@GetMapping("/user/signout")
	public String signout(HttpServletRequest request) {
		// 로그아웃
		// 로그인시에 저장한 세션의 값들을 모두 제거한다.
		
		HttpSession session = request.getSession();
		
		// userId, userLoginId, userName
		session.removeAttribute("userId");
		session.removeAttribute("userLoginId");
		session.removeAttribute("userName");
	
		// 리다이렉트
		return "redirect:/user/signin/view";
		
	}
	
	
	
} 
