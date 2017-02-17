package kr.co.from.main.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	
	/*
	 * 로그인 페이지로 이동
	 */
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String goLogin() {
		
		logger.debug("=======> 로그인페이지");
		
		return "main/login";
	}
	
	
	/**
	 * 로그인 실행
	 * @return
	 */
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String doLogin() {
		
		logger.debug("=====> 로그인 작업");
		
		return "main/loginok";
	}
	

}
