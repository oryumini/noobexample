package kr.co.from.user.service;

import java.util.Map;

import kr.co.from.user.dto.UserDTO;

public interface IUserService {

	public void write(UserDTO userDTO);
	public void edit(UserDTO userDTO);
	public void editpass(UserDTO userDTO);
	public UserDTO view(Integer userId);
	public void remove(Integer userId);
	
	public String isAvailableId(String lgnId);
	
	public String captcha(Map<String, String> paramMap);
	
}
