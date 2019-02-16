package com.fhelp.service.impl;

import com.fhelp.base.User;
import com.fhelp.dao.UserDao;
import com.fhelp.dao.impl.UserDaoImpl;
import com.fhelp.service.UserService;

public class UserServiceImpl implements UserService{

	@Override
	public boolean login(String username, String password) {
		UserDao dao = new UserDaoImpl();
		return dao.login(username, password);
	}

	@Override
	public User findUser(String neme) {
		UserDao dao = new UserDaoImpl();
		return dao.findUser(neme);
	}

	@Override
	public boolean register(User user) {
		UserDao dao = new UserDaoImpl();
		return dao.register(user);
	}
	
}
