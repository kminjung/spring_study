package com.gura.spring03.exception;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/*
 *  예외를 처리하는 컨트롤러
 *  
 *  1. @ControllerAdvice 어노테이션을 붙이고
 *  2. component scan 을 해서 bean 으로 만들고
 *  3. @ExceptionHandler(예외 type) 을 메소드에 붙여준다.
 */

@ControllerAdvice // spring 프레임워크가 내부적으로 aop로 적용할 bean 이다. 검색해보기
public class ExceptionController {
	// ForbiddenException type 오류가 발생했을 때 실행되는 메소드
	@ExceptionHandler(ForbiddenException.class)
	public ModelAndView error403(ForbiddenException fe) { //403오류가 발생했을 때 실행순서를 이쪽으로 보내달라
		ModelAndView mView=new ModelAndView();
		
		mView.setViewName("error/403"); // view/error/403.jsp 를 가리키는 것, 예쁘게 응답해 주면 된다.
		return mView;
	}
	
	/*
	 *  @Repository 어노테이션이 붙어 있는 Dao 에서 DB 관련 Exception 이 발생하면 
	 *  스프링이 DataAccessException 으로 바꿔서 발생시킨다.
	 *  
	 */
	@ExceptionHandler(DataAccessException.class)
	public ModelAndView errorDataAccess(DataAccessException dae) {
		ModelAndView mView=new ModelAndView();
		//예외 정보(문자열) 을 request 에 담기
		mView.addObject("msg", dae.getMessage());
		// dae.getMessage - 문자열을 리턴하는 메소드 / el 에서 이 메소드가 호출되게 하는 방법은 ${exception.message}.message 의 의미는 get.massage 를 리턴하라는 것
		mView.setViewName("error/data_access");
		return mView;
	}
}
