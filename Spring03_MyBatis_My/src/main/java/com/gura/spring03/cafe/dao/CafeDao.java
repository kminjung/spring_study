package com.gura.spring03.cafe.dao;

import java.util.List;

import com.gura.spring03.cafe.dto.CafeDto;

public interface CafeDao { // 구현 할 클래스가 강제로 메소드를 정의한 것
	//새글 저장하는 메소드 
	public void insert(CafeDto dto);
	//인자로 전달되는 정보에 맞는 글의 갯수를 리턴하는 메소드 
	public int getCount(CafeDto dto); //Dto 키워드 검색이 있는 경우 그 키워드에 맞게 리턴
	//인자로 전달되는 정보에 맞는 글 목록을 리턴하는 메소드 
	public List<CafeDto> getList(CafeDto dto);
	//인자로 전달되는 정보에 맞는 글 하나의 정보를 리턴하는 메소드
	public CafeDto getData(CafeDto dto);
	//인자로 전달되는 글번호에 해당되는 글을 삭제하는 메소드 
	public void delete(int num);
	//인자로 전달되는 정보에 맞게 글을 수정하는 메소드
	public void update(CafeDto dto);
	//인자로 전달되는 글번호에 해당되는 글의 조회수를 증가 시키는 메소드
	public void addViewCount(int num);
	//글을 수정하는 메소드
}
/*
 *  public CafeDto getData(CafeDto dto);
 *  - 인자로 int가 아니라 왜 Dto 를 인자로 받는가?
 *   : Mapper에서 getData 를 보면 키워드검색을 위한 where 절이 있는데 prevNum,nextNum 이 없었으면
 *     int 로 받아도 된다. 여러개의 정보전달을 위해 Dto 를 인자로 받은 것
 *  
 *  왜 굳이 interface 를 통해 구현해서 메소드를 구현할까
 *  객체들간에 의존관계를 느슨하게 하기 위해서, 스프링 방법중에 하나다. (면접질문 나올 때 많음)
 *   
 *    
 */
