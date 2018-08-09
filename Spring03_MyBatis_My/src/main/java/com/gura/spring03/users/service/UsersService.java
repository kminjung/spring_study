package com.gura.spring03.users.service;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.gura.spring03.users.dto.UsersDto;

public interface UsersService {
	public boolean canUseId(String id);//id 를 사용할 수 있는지 String type 으로 리턴해주는 메소드
	public void signup(ModelAndView mView, UsersDto dto); // 0808
	public void login(ModelAndView mView, UsersDto dto, HttpSession session);//0809
	public void info(ModelAndView mView, HttpSession session);
	public void updateForm(ModelAndView mView, HttpSession session);
	public void update(UsersDto dto);
	public boolean isValidPwd(String inputPwd, HttpSession session);
	public void updatePwd(String pwd, HttpSession session);
	
}
