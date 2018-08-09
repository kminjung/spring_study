package com.gura.spring03.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring03.member.dao.MemberDao;
import com.gura.spring03.member.dto.MemberDto;
import com.gura.spring03.member.service.MemberService;

@Controller  //Bean이 되기 위해서 @Controller 을 한 것 / ↓ 존재하는 곳에 component scan 을 해야지 Bean 됨.
public class MemberController {
	//의존 객체 
	@Autowired // @Autowired / MemberService 의 객체값이 들어온다. 
	private MemberService mService;
	
	@RequestMapping("/member/update")
	public String update(@ModelAttribute MemberDto dto) {
		mService.update(dto); //update 를 할게 dto 다
		return "redirect:/member/list.do";
	}
	
	//회원 수정 폼 요청 처리
	@RequestMapping("/member/updateform")//어떤 경로 요청이 왔을 때
	public ModelAndView updateForm(@RequestParam() int num) { //만약 request를 통해 전달된 파라미터가 있으면 추출도 한다.
		ModelAndView mView=new ModelAndView();
		mService.getData(mView, num); // 무슨 서비스를 통해
		mView.setViewName("member/updateform");//어디로 어떻게 이동 할 것인지
		return mView;
		//
	}
	
	//회원 삭제 요청 처리
	@RequestMapping("/member/delete")
	public String delete(@RequestParam int num) { //num 이라는 파라미터 명으로 추출되는
		mService.delete(num);
		return "redirect:/member/list.do";
	}
	
	//회원 추가 요청 처리
//	@RequestMapping("/member/insert")
//	public String insert(HttpServletRequest request) {
//		String name=request.getParameter("name");
//		String addr=request.getParameter("addr");
//		MemberDto dto=new MemberDto();
//		dto.setName(name);
//		dto.setAddr(addr); 이 작업을 @ModelAttribute MemberDto dto 가 해준다.
//		
//		mService.insert(dto);
//		
//		return "redirect:/member/list.do";
//	}
//	@RequestMapping("/member/insert")
//	public String insert(@RequestParam String name, 
//				@RequestParam String addr) {
//		MemberDto dto=new MemberDto();
//		dto.setName(name);
//		dto.setAddr(addr);
//		
//		mService.insert(dto);
//		
//		return "redirect:/member/list.do";
//	}
	@RequestMapping("/member/insert")
	public String insert(@ModelAttribute MemberDto dto) {
		/*
		 * 회원 정보가 담긴 MemberDto 객체를 MemberService 
		 * 객체를 이용해서 DB 에 저장하기 
		 */
		mService.insert(dto); //한번에 다 전달받고 싶을 때
		
		return "redirect:/member/list.do";
		//return "member/insert; 
	}
	
	//회원 추가 폼 요청 처리
	@RequestMapping("/member/insertform")
	public String insertForm() {
		return "member/insertform";
	}
	
	// 회원 목록 요청 처리
	// 1.어떤 요청에 대해서
	@RequestMapping("/member/list")
	public ModelAndView list() {
		// 2. 어떤 처리를 하고
		ModelAndView mView=new ModelAndView();
		//MemberService 객체를 이용해서 비즈니스 로직 처리하고 
		mService.list(mView);
		
		// 3.뷰페이지의 정보 설정 
		mView.setViewName("member/list");
		return mView;
	}
}
//컨트롤러에서는 최소한의 로직만 사용한다.