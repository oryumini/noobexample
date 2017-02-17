package kr.co.from.user.dao;

import kr.co.from.user.dto.UserDTO;

public interface IUserDAO {
	public void insert(UserDTO userDTO);
	public void update(UserDTO userDTO);
	public void updatepass(UserDTO userDTO);
	public UserDTO selectOne(Integer userId);
	public UserDTO selectOneByLgnId(String lgnId);
	public void delete(Integer userId);
}
