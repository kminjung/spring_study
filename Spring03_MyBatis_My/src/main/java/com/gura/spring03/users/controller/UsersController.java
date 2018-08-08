package com.gura.spring03.users.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring03.users.dto.UsersDto;
import com.gura.spring03.users.service.UsersService;

@Controller // bean 된다.
public class UsersController {
	//서비스 DI
	@Autowired
	private UsersService service;
	
	//회원가입 요청 처리
	@RequestMapping("/users/signup")
	public ModelAndView signup(@ModelAttribute UsersDto dto) {
		//서비스에 전달할 ModelAndView 객체 생성
		ModelAndView mView=new ModelAndView();
		//서비스에 ModelAndView 객체와 폼 전송된 회원 가입 정보가 담겨있는 UsersDto 객체를 전달한다.
		service.signup(mView, dto);//mView 에다가 담은 것,UsersServiceImple 에서 받아서  addObject 한다.
		//ModelAndView 객체에 view 페이지 정보를 담고 / //ModelView 에 담으면 결국 request 에 담는다.
		mView.setViewName("users/signup");
		//리턴해준다
		return mView;
	}
	
	//회원가입 폼 요청 처리
	@RequestMapping("/users/signup_form")
	public String signupForm() {
		return "users/signup_form"; // view 페이지 정보를 String 으로 리턴한 것
	}
	
	//아이디 중복확인 ajax 요청에 대한 응답 / ajax 요청에 대한 응답을 json라이브러리로 쉽게 응답하려고 Map 을 쓴다.
	@RequestMapping("/users/checkid")
	@ResponseBody // view 페이지를 거치치 않고 바로 method body 를 통해 직접 출력한다.
	public Map<String, Object> checkid(@RequestParam String inputId){
		//서비스 객체를 이용해서 사용가능 여부를 boolean type 으로 리턴 받는다.
		boolean canUse=service.canUseId(inputId);
		//Map 에 담는다.
		Map<String, Object> map=new HashMap<>();
		map.put("canUse", canUse);
		
		return map;
	}
}