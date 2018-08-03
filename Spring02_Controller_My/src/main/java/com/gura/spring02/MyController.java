package com.gura.spring02;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //String Bean 컨테이너에서 관리하게 된다.
public class MyController {
	
	@RequestMapping("/fortune")
	public String showFortune(HttpServletRequest request) {
		// view 페이지에 전달할 Model
		String fortuneToday="동쪽으로 가면 귀인을 만나요";
		// request 에 담기
		request.setAttribute("fortuneToday", fortuneToday);
		// view 페이지로 forward 이동
		return "fortune"; // 뭐를 만들라는 뜻
	}
	
	@RequestMapping("/person")
	public ModelAndView showPerson(HttpServletRequest request) {
		String personToday="밀크";
		// ModelAndView - request 에 담을 Model 과 view 페이지 정보를 가지는 객체
		ModelAndView mView=new ModelAndView();
		mView.addObject("personToday", personToday);
		mView.setViewName("person"); //view 페이지의 정보를 담았다.
		
		return mView;
	}
}
// 요청처리하는(리턴되는) 메소드가 String 이거나 ModelAndView(많이 쓴다) 일 수 있다.
// request 에 담을 내용이 없으면 String, 담을 객체가 있으면 ModelAndView 을 사용해도 좋을듯 


