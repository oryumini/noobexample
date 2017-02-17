package kr.co.from.user.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import kr.co.from.user.dao.IUserDAO;
import kr.co.from.user.dto.UserDTO;

@Repository
public class UserDAOImpl extends SqlSessionDaoSupport implements IUserDAO {

	@Override
	public void insert(UserDTO userDTO) {
		// TODO Auto-generated method stub

		getSqlSession().insert("User.insertData", userDTO);
	}

	@Override
	public void update(UserDTO userDTO) {
		// TODO Auto-generated method stub

		getSqlSession().update("User.update", userDTO);
		
	}

	@Override
	public UserDTO selectOne(Integer userId) {
		// TODO Auto-generated method stub
		UserDTO userDTO = new UserDTO();
		
		userDTO = getSqlSession().selectOne("User.selectOne", userId);
		
		return userDTO;
	}
	@Override
	public UserDTO selectOneByLgnId(String lgnId) {
		// TODO Auto-generated method stub
		UserDTO userDTO = new UserDTO();
		
		userDTO = getSqlSession().selectOne("User.selectOneById", lgnId);
		
		return userDTO;
	}

	@Override
	public void delete(Integer userId) {
		// TODO Auto-generated method stub

		getSqlSession().delete("User.delete", userId);

	}

	@Override
	public void updatepass(UserDTO userDTO) {

		getSqlSession().update("User.updatePass", userDTO);
		
	}

}
