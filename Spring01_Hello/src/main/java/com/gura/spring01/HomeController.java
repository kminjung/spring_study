package com.gura.spring01;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {// /home.do 요청에 대해 응답할 것임
	
	@RequestMapping("/home.do")//.do 는 생략 가능
	public String home(HttpServletRequest request) {
		
		List<String> news=new ArrayList<String>();
		news.add("안녕하세요");
		news.add("오늘 Spring Framework 시작 입니다.");
		news.add("어뗘구..");
		news.add("뎌뗘구..."); // date 는 모델이다.
		
		//request 에 담기
		request.setAttribute("news", news);
		
		/*
		 * view page 의 정보를 문자열로 리턴하기
		 * 
		 * prefix : /WEB-INF/views/
		 * 
		 * suffix : .jsp
		 * 
		 * "WEB-INF/views/"+"home"+".jsp" / home 의 앞과 뒤가 자동으로 붙여진다. - servlet-context 에 있음
		 * 
		 * 따라서  "/WEB-INF/views/home.jsp" 로 사용되어진다.
		 * 
		 * 여기에 대한 설정정보는 SEB-INF/spring/appServlet/servlet-context.xml 에 있다.
		 */
		return "home";//view 페이지의 정보를 문자열로 전달
	}
}
