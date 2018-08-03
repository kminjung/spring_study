package com.gura.spring02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//1. 클래스가 컨트롤러 역할을 할 수 있도록
@Controller
public class HomeController {
	
	//2. 어떤 요청을 처리할지 요청 맵핑
	@RequestMapping("/home.do")//.do 는 생략 가능
	public String home() {
		//3. 비지니스 로직 처리
		
		//4. view 페이지의 정보 리턴
		return "home";	//WEB_INF/views/(prifix 임)home.jsp(suffix 임) 이거에 대한 정보는 servlet-context.xml 에 있음
		
	}

}
