package test.service;

import org.springframework.stereotype.Component;

@Component // init.mxl 에 패키지명 명시하고 @Component 를 붙이면 bean 이 된다.
public class MemberServiceImpl implements MemberService{

	@Override
	public void insert() {
		System.out.println("회원 정보를 저장합니다.");
		
	}

	@Override
	public void select() {
		System.out.println("회원 정보를 불러옵니다.");
		
	}
	
}
