package kr.co.unified;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.from.user.dto.UserDTO;
import kr.co.from.user.service.IUserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
"file:src/main/webapp/WEB-INF/spring/root-context.xml"})

public class Test {
	
	private static final Logger logger = LoggerFactory.getLogger(Test.class);
	
	@Autowired private IUserService userServiceImpl = null;
	
	@org.junit.Test
	public void write() {
		
		UserDTO _userDTO = new UserDTO();
		
		_userDTO.setLgnId("behemoth");
		_userDTO.setLgnPw("kuaaaa");
		_userDTO.setName("firestrike");
		_userDTO.setPhone("010-020-1300");
		_userDTO.setStatus(1);
		_userDTO.setEmail("admin@futuremark.com");
		
		userServiceImpl.write(_userDTO);
	}
	
	
	@org.junit.Test
	public void view() {
		
		Integer userId = 10000022;
		UserDTO _userDTO = new UserDTO();
		
		_userDTO = userServiceImpl.view(userId);
		
		logger.debug("=====>view " + _userDTO.toString());
	}
	
	
	@org.junit.Test
	public void edit() {
		
		UserDTO userDTO = new UserDTO();
		
		userDTO.setUserId(99999);

		
		userDTO.setLgnPw("12345");
		userDTO.setEmail("asdf");
		userDTO.setName("form");
		userDTO.setPhone("400-4944-4984");
		userDTO.setStatus(9);
		
		userServiceImpl.edit(userDTO);
		
		view();
		
	}

	@org.junit.Test
	public void remove() {
		
		Integer userId = 1;
		
		userServiceImpl.remove(userId);
		
		
	}
}
