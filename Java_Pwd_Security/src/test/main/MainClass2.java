package test.main;

import java.util.Scanner;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MainClass2 {
	public static void main(String[] args) {
		//가입할 때 입력 한 비밀번호라고 가정
		String pwd="1234";
		
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		//DB 에 저장된 암호화 된 비밀번호라고 가정
		String savedPwd=encoder.encode(pwd);
		
		Scanner scan=new Scanner(System.in);//키보드로 문자열을 입력하는 System.in 를 받아서 처리해주는 Scanner 클래스 

		System.out.println("비밀번호 입력 : ");
		//로그인 할 때 입력한 비밀번호라고 가정
		String inputPwd=scan.nextLine();
		
		//저장된 비밀번호와 암호화된 비밀번호가 일치하는지 여부
		boolean isValid=BCrypt.checkpw(inputPwd, savedPwd);// DB 에 있는 비밀번호를 dao 로 읽어와서 
		
		if(isValid) {
			System.out.println("비밀번호가 일치해요!");
		}else {
			System.out.println("비밀번호를 잘못 입력했습니다.");
		}
	}
}
