package test.service;

import org.springframework.stereotype.Component;

// component scan 을 했을 때 bean 으로 만들기 위한 어노테이션
@Component
public class WritingServiceImpl implements WritingService{//모든 객체는 objece type 이다.

	@Override
	public void write() { // 핵심 비즈니스 로직이라고 가정
		System.out.println("글 쓰기 작업중...");
		try {
			Thread.sleep(5000); // 실행하는데 5분이 걸린다.
		}catch(Exception e) {}
	}

	@Override
	public void writeToFriend() {
		System.out.println("친구에게 글 쓰기 작업중...");
		try {
			Thread.sleep(5000); 
		}catch(Exception e) {}	
	}

	@Override
	public void writeToTeacher(String name) {
		System.out.println(name+"선생님 글 쓰기 작업중..."); // 인자로 전달된 name 에 해당된 선생님에게 글쓰기 작업중
		try {
			Thread.sleep(5000);
		}catch(Exception e) {}
		
	}

	@Override
	public String writeAndGet(int num) { // 이걸 조사 해 볼수 도 있고
		System.out.println("글쓰기 작업하고 문자열을 돌려줍니다.");
		return "Acorn";//이걸 조사 해 볼수 있다.
	}


}
