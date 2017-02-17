package kr.co.from.main.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.from.user.dto.UserDTO;
import kr.co.from.user.service.IUserService;


/**
 * 
 * 회원가입
 * @author Owner
 *
 */

@Controller
public class JoinController {

	@Autowired IUserService userServiceImpl = null;
	
	private static final Logger logger = LoggerFactory.getLogger(JoinController.class);
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String goJoin() {
		
		logger.debug("=======> 회원가입");
		
		return "main/join";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String doJoin(Model model, UserDTO _userDTO) {
		
		logger.debug("======> 작업");
		
		_userDTO.setStatus(9);		//회원 가입시 바로 승인 처리
		
		userServiceImpl.write(_userDTO);
		model.addAttribute("username", _userDTO.getName());
		
		return "/main/login";
		
	}
	
	
	/**
	 * 아이디 체크
	 * @param lgnId
	 * @return Y: 사용가능 N 불가능
	 */
	
	@ResponseBody				// 페이지를 이동시키지 않고 브라우저로 곧바로 넘긴다.
	@RequestMapping(value="/join/id/available", method=RequestMethod.POST)
	public String checkId(@RequestParam("lgnId") String lgnId) {
		
		return userServiceImpl.isAvailableId(lgnId);
		
	}
}
