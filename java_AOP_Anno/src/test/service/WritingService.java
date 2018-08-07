package test.service;

public interface WritingService {
	public void write();
	public void writeToFriend();
	public void writeToTeacher(String name);//전달되는 인자는 string 이다.
	public String writeAndGet(int num); //전달 해 주는 인자도 있고 리턴 타입(String)도 있다.
	
}
