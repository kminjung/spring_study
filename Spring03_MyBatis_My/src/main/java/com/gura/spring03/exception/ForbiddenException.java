package com.gura.spring03.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 *  403 FORBIDDEN 응답을 프로그래머가 하고 싶을 때
 *  
 *  throw new ForbiddenException() 하면 된다.
 *  
 *  403 - 금지된 요청
 */
@ResponseStatus(HttpStatus.FORBIDDEN) // 403
public class ForbiddenException extends RuntimeException{
	
}
/*
 *  @ResponseStatus
 *  
 *  - 어노테이션 없이 예외를 처리한다 (보통 당신이 작성하지않은 선정의된 예외들)
 *  - 사용자를 특정한 에러페이지로 리다이렉트한다
 *  - 완전히 컨스텀 에러 응답을 만든다
 */

