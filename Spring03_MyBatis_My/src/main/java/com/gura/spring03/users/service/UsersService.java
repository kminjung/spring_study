package com.gura.spring03.users.service;

import org.springframework.web.servlet.ModelAndView;

import com.gura.spring03.users.dto.UsersDto;

public interface UsersService {
	public boolean canUseId(String id);//id 를 사용할 수 있는지 String type 으로 리턴해주는 메소드
	public void signup(ModelAndView mVies, UsersDto dto);
}
