package com.project.service.impl;
import java.util.List;

import com.projec.dao.UserDao;
import com.project.dao.impl.UserDaoImplUsingJdbc;
import com.project.dto.UserDTO;
import com.project.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDao userDao = new UserDaoImplUsingJdbc();
	
	//private com.projec.dao.UserDao userDao = new UserDaoImplUsingJdbc();
	
	//private UserDao userDao = new UserDaoImplUsingHibernate();
	
	@Override
	public boolean saveUser(UserDTO user) {
		return userDao.saveUser(user);
		
	}
	@Override
	public boolean updateUser(UserDTO user) {
		return false;
	}
	@Override
	public boolean deleteUser(String email) {
		return userDao.deleteUser(email);
		
	}
	@Override
	public UserDTO searchUser() {
		return null;
		
	}
	@Override
	public List<UserDTO> showAllUser(){
		return userDao.showAllUser();
		
	}
	
	}
	


