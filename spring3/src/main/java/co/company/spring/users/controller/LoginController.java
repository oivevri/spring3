package co.company.spring.users.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	
	//로그인 페이지로 이동
	@GetMapping("login")
	public String loginForm() {
		return "user/login";
	}
	
	//로그인
	@PostMapping("login")
	public String login(HttpSession session) {
		session.setAttribute("loginId", "user");
		return "redirect:/empSelect";
	}
	
	//로그아웃
		@GetMapping("logout")
		public String logout(HttpSession session) {
			session.invalidate();
			return "user/login";
		}
}
