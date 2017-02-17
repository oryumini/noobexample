package kr.co.from.common.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import kr.co.from.user.dto.UserDTO;

@Component
public class AuthenticationSuccess extends AbstractAuthenticationTargetUrlRequestHandler implements AuthenticationSuccessHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthenticationSuccess.class);
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		UserDetail userDetail = (UserDetail)authentication.getPrincipal();
		UserDTO userDTO = userDetail.getUser();
		HttpSession session = request.getSession(true);
		session.setAttribute("user", userDTO);
		
		getRedirectStrategy().sendRedirect(request, response,  "/main/index" );
		
		logger.debug("======>" + "성공?");
	}
	
}
