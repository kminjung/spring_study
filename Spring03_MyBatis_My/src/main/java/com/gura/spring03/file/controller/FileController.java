package com.gura.spring03.file.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring03.file.dto.FileDto;
import com.gura.spring03.file.service.FileService;

@Controller
public class FileController {
	//의존객체
	@Autowired
	private FileService fileService;
	
	@RequestMapping("/file/list")
	public ModelAndView list(ModelAndView mView,
			@RequestParam(defaultValue="1") int pageNum) {
		//pageNum 이라는 파라미터가 넘어오지 않으면 1 페이지가 된다.
		fileService.getList(mView, pageNum);
		
		mView.setViewName("file/list");	
		return mView;
	}
	@RequestMapping("/file/upload_form")
	public ModelAndView authUploadForm(HttpServletRequest request) {
		
		return new ModelAndView("file/upload_form");
	}
	
	@RequestMapping("/file/upload") // upload_form 과 매핑
	public ModelAndView authUpload(HttpServletRequest request,
			@ModelAttribute FileDto dto) {
		//FileDto 에는 업로드된 파일의 정보도 같이 들어있다.
		fileService.insert(request, dto);
		
		// 파일 목록보기로 리다일렉트 치동
		return new ModelAndView("redirect:/file/list.do");
	}
}
/*
 * 	HttpServletRequest - 서블릿에서 보내온 요청을 받아오는 것
 */
