package com.gura.spring03.shop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring03.shop.service.ShopService;

@Controller
public class ShopController {
	@Autowired
	private ShopService shopService;
	
	//1. 상품 목록보기 요청 처리
	@RequestMapping("/shop/list")
	public ModelAndView list(ModelAndView mView) {
		//service를 통해 mView 에 상품목록을 담는다.
		shopService.getList(mView);
		
		mView.setViewName("shop/list"); // 상품 출력
		return mView;
	}
	//상품 구매하고 요청 처리
	@RequestMapping("/shop/buy")
	public ModelAndView authBuy(HttpServletRequest request) {
		
		return null;
	}
}
