package kr.co.from.main.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.from.common.security.SecuritySession;
import kr.co.from.common.security.UserDetail;
import kr.co.from.user.dto.UserDTO;
import kr.co.from.user.service.IUserService;


/**
 * 
 * 회원가입
 * @author Owner
 *
 */

@Controller
public class EditController {

	@Autowired IUserService userServiceImpl = null;
	
	private static final Logger logger = LoggerFactory.getLogger(EditController.class);
	
	//회원정보 보기
	@RequestMapping(value="/sessionview", method=RequestMethod.GET)
	public String sessionView() {
		logger.debug("=========> 정보 보기");
		
		return "main/sessionview";
	}
	
	
	//회원정보수정
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String goEdit() {
		
		logger.debug("=======> 정보변경");
		
		return "main/edit";
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String doEdit(Model model, UserDTO _userDTO) {

		
		logger.debug("======> 작업");
		
		_userDTO.setUserId(SecuritySession.getCurrentUser().getUserId());
		_userDTO.setStatus(9);		//회원 가입시 바로 승인 처리
		
		userServiceImpl.edit(_userDTO);
		
		
		return "main/main";
		
	}
	
	//회원 비밀번호 수정
	@RequestMapping(value="/editpass", method=RequestMethod.GET)
	public String goEditPass() {
		
		logger.debug("=======> 정보변경");
		
		return "main/editpass";
	}
	
	
	@RequestMapping(value="/editpass", method=RequestMethod.POST)
	public String doEditPass(Model model, UserDTO _userDTO) {

		
		_userDTO.setUserId(SecuritySession.getCurrentUser().getUserId());
		
		
		logger.debug("======> 작업");
		
		userServiceImpl.editpass(_userDTO);
		
		
		return "main/main";
	}

}
