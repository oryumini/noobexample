package kr.co.from.common.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import kr.co.from.user.dao.IUserDAO;
import kr.co.from.user.dto.UserDTO;




public class UserDetailService implements UserDetailsService {
	private static final Logger logger = LoggerFactory.getLogger( UserDetailService.class );

	@Autowired private IUserDAO userDAOImpl = null;

	public UserDetails loadUserByUsername(String lgnId) throws UsernameNotFoundException {
		UserDTO userDTO = null;
		try{
			logger.debug("id=================>"+lgnId);
			userDTO = userDAOImpl.selectOneByLgnId(lgnId);
			
			if( userDTO == null ) {
				logger.debug("member is null =================>");
				throw new BadCredentialsException("ID나 비밀번호가 잘못되었습니다.");
			}
		}catch(DataAccessException dae){
			dae.printStackTrace();
			logger.error("[ERROR]==>", dae);
			throw new DataAccessException("[ERROR] 알 수 없는 오류가 발생했습니다.") {
				private static final long serialVersionUID = 1L;
			};
		}
		
		return new UserDetail(userDTO);
	}
	
}
