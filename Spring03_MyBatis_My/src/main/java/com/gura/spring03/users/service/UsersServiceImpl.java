package com.gura.spring03.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring03.users.dao.UsersDao;
import com.gura.spring03.users.dto.UsersDto;

@Service
public class UsersServiceImpl implements UsersService{
	//의존객체 DI
	@Autowired
	private UsersDao dao;
	
	@Override
	public boolean canUseId(String id) {
		//인자로 전달된 아이디의 사용가능 여부를 리턴 해 준다.
		return dao.canUseId(id);
	}
	
	   //회원 가입 처리하는 서비스 메소드
	   @Override
	   public void signup(ModelAndView mView, UsersDto dto) {
	      //비밀번호 암호화를 도와주는 객체 생성
	      BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
	      //UserdDto 에 있는 비밀번호를 암호화 한다
	      String encodedPwd=encoder.encode(dto.getPwd());
	      //암호화된 비밀번호를 UsersDto에 다시 담는다.
	      dto.setPwd(encodedPwd);
	      //Dao를 이용해서 회원정보를 저장한다
	      dao.insert(dto);
	      //request에 담을 내용을 ModelAndView 객체에 담는다.
	      mView.addObject("msg",dto.getId()+"회원님이 가입되었습니다."); // 필요한 모델이 있으면 여기에다
 
	   }
	

}
