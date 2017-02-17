package kr.co.from.user.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.from.user.dao.IUserDAO;
import kr.co.from.user.dto.UserDTO;
import kr.co.from.user.service.IUserService;
import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired IUserDAO userDAOImpl = null;
	
	@Override
	public void write(UserDTO userDTO) {
		// TODO Auto-generated method stub

		userDAOImpl.insert(userDTO);
	}

	@Override
	public void edit(UserDTO userDTO) {
		// TODO Auto-generated method stub
		
		userDAOImpl.update(userDTO);
	}

	@Override
	public UserDTO view(Integer userId) {
		// TODO Auto-generated method stub
		
		UserDTO userDTO = new UserDTO();
		
		userDTO = userDAOImpl.selectOne(userId);
		
		return userDTO;
	}

	@Override
	public void remove(Integer userId) {
		
		userDAOImpl.delete(userId);

	}

	@Override
	public String isAvailableId(String _lgnId) {
		
		UserDTO userDTO = userDAOImpl.selectOneByLgnId(_lgnId);
		
		if (userDTO == null) {
			return "Y";
		} else {
			return "N";
		}
		
	}

	@Override
	public void editpass(UserDTO userDTO) {
		
		userDAOImpl.updatepass(userDTO);
		
	}

	
	// reCaptcha 구현
	@Override
	public String captcha(Map<String, String> paramMap) {
		
		String check = "Y";
	     
	    ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
	    reCaptcha.setPrivateKey("6Lc-yRMUAAAAAGFMxthZ2qxQd4cTS1m2vtsk3yO5");//Secret key
	 
	    String host = paramMap.get("host");
	    String challenge = paramMap.get("challenge");
	    String res = paramMap.get("response");
	     
	    ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(host, challenge, res);
	 
	    if (reCaptchaResponse.isValid()) {
	        System.out.println("true");
	        check = "Y";
	    } else {
	        System.out.println("false");
	        check = "N";
	    }
	    
		return check;
	}

}
