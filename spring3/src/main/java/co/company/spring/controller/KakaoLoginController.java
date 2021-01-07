package co.company.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.JsonNode;

@Controller
public class KakaoLoginController {

	@RequestMapping(value = "/loginform2", method = RequestMethod.GET)
	public ModelAndView memberLoginForm(HttpSession session) {
		ModelAndView mav = new ModelAndView(); /* 네아로 인증 URL을 생성하기 위하여 getAuthorizationUrl을 호출 */
		String kakaoUrl = KakaoAPI.getAuthorizationUrl(); /* 생성한 인증 URL을 View로 전달 */
		mav.setViewName("user/login"); // 로그인 폼
		// mav.addObject("naver_url", naverAuthUrl); // 네이버 로그인
		mav.addObject("kakao_url", kakaoUrl); // 카카오 로그인
		// 이때 mav에 설정한 오브젝트 이름을 로그인.jsp 에서 a태그에 불러서 씀
		return mav;
	}

	@RequestMapping(value = "/kakaologin", produces = "application/json")
	public ModelAndView kakaoLogin(@RequestParam("code") String code, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		// code : 인가 코드 받기 요청으로 얻은 인가 코드
		ModelAndView mav = new ModelAndView(); // 결과값을 node에 담아줌
		JsonNode node = KakaoAPI.getAccessToken(code); // accessToken에 사용자의 로그인한 모든 정보가 들어있음
		JsonNode accessToken = node.get("access_token"); // 사용자의 정보에 접근할수있는 토큰?
		JsonNode userInfo = KakaoAPI.getKakaoUserInfo(accessToken); // 토큰을 갖고 회원정보를 얻어냄
		String kemail = null;
		String kname = null;
		String kgender = null;
		String kbirthday = null;
		String kage = null;
		String kimage = null; // 유저정보 카카오에서 가져오기 Get properties
		JsonNode properties = userInfo.path("properties");
		JsonNode kakao_account = userInfo.path("kakao_account");
		kemail = kakao_account.path("email").asText();
		kname = properties.path("nickname").asText();
		kimage = properties.path("profile_image").asText();
		kgender = kakao_account.path("gender").asText();
		kbirthday = kakao_account.path("birthday").asText();
		kage = kakao_account.path("age_range").asText();
		session.setAttribute("kemail", kemail);
		session.setAttribute("kname", kname);
		session.setAttribute("kimage", kimage);
		session.setAttribute("kgender", kgender);
		session.setAttribute("kbirthday", kbirthday);
		session.setAttribute("kage", kage);
		// 값 받아왔을때 null이 아닌 값을 받아올수있음.
		// 값을 세션에 넣어줘도 되고..
		// 이 정보들을 가지고 회원가입란에 insert 해도 됨
		mav.setViewName("home"); // views - home.jsp 로 이동
		return mav;
	}
}
