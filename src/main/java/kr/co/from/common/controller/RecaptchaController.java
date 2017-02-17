package kr.co.from.common.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.from.user.service.IUserService;

@Controller
public class RecaptchaController {

	@Autowired IUserService userServiceImpl = null;
	
	@ResponseBody
	@RequestMapping(value = "/validateRecaptcha", method = RequestMethod.POST)
	public String validateRecaptcha(@RequestParam Map<String, String> paramMap) {
		
	    return userServiceImpl.captcha(paramMap);
	}
}
