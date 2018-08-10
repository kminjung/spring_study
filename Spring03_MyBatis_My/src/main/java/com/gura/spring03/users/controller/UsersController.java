package com.gura.spring03.users.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	
	//아이디 중복확인 ajax 요청에 대한 응답 (JSON 응답) / ajax 요청에 대한 응답을 json라이브러리로 쉽게 응답하려고 Map 을 쓴다.
	/*
	 *  1.pom.xml 에 jackson 라이브러리 추가
	 *  2. @ResponseBody 어노테이션
	 *  3. {}: Map Or Dto 리턴
	 *     []: List 리턴
	 */
	@RequestMapping("/users/checkid")
	@ResponseBody // view 페이지를 거치치 않고 바로 method body 를 통해 직접 출력한다.
	public Map<String, Object> checkid(@RequestParam String inputId){
		//서비스 객체를 이용해서 사용가능 여부를 boolean type 으로 리턴 받는다.
		boolean canUse=service.canUseId(inputId);
		//Map 에 담는다.
		Map<String, Object> map=new HashMap<>();
		map.put("canUse", canUse);
		// {"canUse":true} or {"canUse":false} 문자열이 응답된다.컨트롤러에서 클라이언트 웹브라우져에 바로 찍어준다. / 클라이언트에 자바스크립트랑 같이 생각해야 한다. object 로 바꿔서 담아준다.
		return map;
	}
	//로그인 폼 요청 처리
	@RequestMapping("/users/loginform")
	public String loginForm(HttpServletRequest request) {
		//로그인 후 이동할 url 주소를 읽어온다.
		String url=request.getParameter("url");//파라미터 추출
		//만일 전달되지 않았으면
		if(url==null) {
			//인덱스로 이동할 수 있도록
			url=request.getContextPath()+"/";
		}
		//request 에 담기
		request.setAttribute("url", url);
		return "users/loginform";
	}
	
//	//로그인 폼 요청 처리2  이 방법이 더 스프링 답다.
//	public ModelAndView lobinForm2(HttpServletRequest String url,
//		HttpServletRequest request){
//		
//		//만일 전달되지 않았으면
//		if(url==null) {
//			//인덱스로 이동할 수 있도록
//			url=request.getContextPath()+"/";
//		}
//		ModelAndView mView=new ModelAndView();
//		mView.addObject("url", url);
//		mView.setViewName("users/loginform");
//		
//		return mView;	
//	}
	//로그인 요청 처리
	@RequestMapping("/users/login") // id,pwd 를 한번에 받을 수 ↓ 있다.
	public ModelAndView login(@ModelAttribute UsersDto dto,
			@RequestParam String url, HttpSession session) { // 로그인 하고 나서 이동할 url 이 넘어왔다.
		ModelAndView mView=new ModelAndView();
		service.login(mView, dto, session);//로그인 성공여부를 알기 위해 mView 를 넣었다./ dto 는 방금 입력한 id,비밀번호를 넣은것, session - 
		
		//로그인 후 이동할 url
		mView.addObject("url",url);
		//view 페이지 정보
		mView.setViewName("users/login");
		
		return mView;
	}//@RequestParam String url- url 도 찍히게 / 로그인으로 이동할 url
	// ModelAndView - Controller 처리 결과 후 응답할 view와 view에 전달할 값을 저장
	// @ModelAttribute - model 의 속성
	 
	//로그아웃 요청 처리
	@RequestMapping("/users/logout")
	public String logout(HttpSession session) {
		//세션 초기화
		session.invalidate();
		//view 페이지 정보 리턴
		return "users/logout";
		
	}
	//개인정보 보기 요청 처리
	@RequestMapping("/users/info")
	public ModelAndView authInfo(HttpServletRequest request, HttpSession session) {
		ModelAndView mView=new ModelAndView();
		
		service.info(mView, session);
		
		//view 페이지의 정보를 담아서
		mView.setViewName("users/info");
		//ModelAndView 객체를 리턴해준다.
		return mView;
	}
	//회원정보 수정 폼 요청 처리
	@RequestMapping("/users/updateform") // ↓ 로그인 해야지만 할 수 있다.
	public ModelAndView authUpdateForm(HttpServletRequest request,
			HttpSession session) {
		//ModelAndView 객체를 생성해서
		ModelAndView mView=new ModelAndView();
		//서비스에 인자로 전달해서 회원정보가 담기게 하고
		service.updateForm(mView, session);
		//view 페이지에서 회원 정보 수정 폼을 출력한다.
		mView.setViewName("users/updateform");
		return mView;
	}
	//회원정보 수정 요청
	@RequestMapping("/users/update")
	public ModelAndView authUpdate(HttpServletRequest request,
			@ModelAttribute UsersDto dto) {//UsersDto dto를 통해 수정반영을 만든다.
		service.update(dto);
		
		//방법1. ModelAndView mView=new ModelAndView("redirect:/users/info.do"); view 페이지 정보를 생성자의 인자로 전달 해 줄 수 있다.
		//방법2. mView.setViewName("redirect:/users/info.do");
		//개인정보 보기 페이지로 리다일렉트 이동
		return new ModelAndView("redirect:/users/info.do");
	}
	//비밀번호 수정 폼 요청
	@RequestMapping("/users/pw_changeform")
	public ModelAndView authPwUpdateForm(HttpServletRequest request) {
	
		return new ModelAndView("users/pw_changeform");
	}
	
	@RequestMapping("/users/pw_check")
	@ResponseBody
	public Map<String, Object> pwCheck(@RequestParam String inputPwd,
			HttpSession session){
		boolean isValid=service.isValidPwd(inputPwd, session);
		Map<String,Object> map=new HashMap<>();
		map.put("isValid", isValid);
 		//{"isValid":true} or {"isValid":false}
		return map;
   }
	//비밀번호 수정 반영하는 요청 처리
	@RequestMapping("/users/pw_update") // 수정폼임
	public ModelAndView authPwUpdate(HttpServletRequest request,
			@RequestParam String pwd, HttpSession session) {
		//서비스를 이용해서 비밀번호 수정
		service.updatePwd(pwd, session);
		//개인정보 보기로 리다일렉트
		return new ModelAndView("redirect:/users/info.do");
	}
	//회원탈퇴 요청 처리
	@RequestMapping("/users/delete") // returun type 이 ModelAndView /auth?? / .1
	public ModelAndView authDelete(HttpServletRequest request,
			ModelAndView mView) { // .2
		service.delete(mView, request.getSession()); //.2 세션을 mView 로 받지 않고 request 로 받을 수 있다.
		//view 페이지로 이동해서 응답하기 //.3
		mView.setViewName("users/delete");
		return mView;
	}
}
/*
* ModelAndView - Controller 처리 결과 후 응답할 view와 view에 전달할 값을 저장
* HttpServletRequest - 클라이언트의 요청과 관련된 정보와 동작을 가지고 있는 객체 !
* 						(클라이언트 ip정보,쿠키,헤더,get/post로 전송한 값 가져옴)
*
*/