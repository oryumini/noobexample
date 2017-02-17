package kr.co.from.common.security;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.WebUtils;

import kr.co.from.user.dto.UserDTO;

@Service
public class SecuritySession {
	private static final Logger logger = LoggerFactory.getLogger(SecuritySession.class);

	public static Authentication getAuthenCation() {
		if( SecurityContextHolder.getContext().getAuthentication() == null )
			return null;

		return SecurityContextHolder.getContext().getAuthentication();
	}

	public static UserDTO getCurrentUser() {

		if( SecurityContextHolder.getContext().getAuthentication() == null ) {
			return new UserDTO();

		}

		Object pricial = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if( pricial instanceof UserDetail ) {
			return ((UserDetail)pricial).getUser();
		}

		return (UserDTO)WebUtils.getSessionAttribute( SecuritySession.getCurrentRequest(), "MEMBER");
	}


	@SuppressWarnings("deprecation")
	public static String getRealPath() {
		//StringBuffer sb = new StringBuffer();
		ServletRequestAttributes sra = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
		return sra.getRequest().getRealPath("");
	}

	public static List<MultipartFile> getRequestToFile(HttpServletRequest request, String name) {

		MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
		List<MultipartFile> files = multiRequest.getFiles(name);

		List<MultipartFile> list = new ArrayList<MultipartFile>();
		for( MultipartFile file : files) {
			if( file.getSize() > 0 )
				list.add(file);
		}
		return list;
	}

	public static HttpServletRequest getCurrentRequest() {
		ServletRequestAttributes sra = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
		return sra.getRequest();
	}
}
