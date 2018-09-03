package test.service;

public class CafeServiceImple implements CafeService{

	@Override
	public void insert() {
		System.out.println("카페 글을 추가합니다.");
		
	}

	@Override
	public void select() {
		System.out.println("카페 글 목록을 불러옵니다.");
		
	}
//bean 으로 만들기 위해서 init.xml 에서 설정한다.
}
