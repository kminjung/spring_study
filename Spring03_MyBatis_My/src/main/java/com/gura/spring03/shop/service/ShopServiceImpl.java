package com.gura.spring03.shop.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring03.shop.dao.OrderDao;
import com.gura.spring03.shop.dao.ShopDao;
import com.gura.spring03.shop.dto.OrderDto;
import com.gura.spring03.shop.dto.ShopDto;

@Service
public class ShopServiceImpl implements ShopService{
	
	@Autowired
	private ShopDao shopDao;
	@Autowired
	private OrderDao orderDao;
	
	@Override
	public void getList(ModelAndView mView) {
		//ShopDao 객체를 이용해서 상품 목록을 얻어와서
		List<ShopDto> list=shopDao.getList();
		//인자로 전달된 ModelAndView 객체에 담는다.
		//(request 영역에 담기 위해)
		mView.addObject("list", list);
		
	}

	@Override // (여기서 하는 관리는 하나의 묶음으로 관리되어야 한다. 수정)
	public void buy(HttpServletRequest request, ModelAndView mView) {
		//로그인 된 아이디
		String id=(String)request.getSession().getAttribute("id");
		//구입할 상품 번호
		int num=Integer.parseInt(request.getParameter("num"));
		
		//1. 상품의 가격정보 얻어오기
		int price=shopDao.getPrice(num);
		//2. 가격만큼 계좌 잔액을 줄인다.
		ShopDto dto=new ShopDto();
		dto.setPrice(price);
		dto.setNum(num);
		dto.setId(id);
		shopDao.minusMoney(dto);
		//3.가격의 10% 를 포인트로 적립
		shopDao.plusPoint(dto);
		//4. 재고의 갯수를 -1 줄인다.
		shopDao.minusCount(num);
		//5.배송요청 정보를 입력한다.
		OrderDto orderDto=new OrderDto();
		orderDto.setId(id);
		orderDto.setCode(num);
		orderDto.setAddr("노량진");
		orderDao.addOrder(orderDto);
		
		/*
		 *  하나의 로직을 수행하기 위해서 dao를 여러번 쓰고있다.
		 *  이 4개중에서 하나라도 실패되면 Exception 이 발생한다.(다 원래대로 되돌린다.)
		 *  이렇게 묶음으로 관리하는 것이 트렌젝션 관리라고 한다.
		 *  
		 *  각각의 Dao 에서 관리한 session 은 spring 이 관리하고 있는 세션이다.
		 *  트렌젝션을 관리하기 위해서는 세션을 관리해야 하는데
		 *  트렌젝션도 스프링한테 맡겨야 한다. (이것을 배우면 되는것)
		 */
	}
}
