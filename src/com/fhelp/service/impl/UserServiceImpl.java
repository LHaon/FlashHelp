package com.fhelp.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.fhelp.base.Task;
import com.fhelp.base.User;
import com.fhelp.dao.UserDao;
import com.fhelp.dao.impl.UserDaoImpl;
import com.fhelp.service.UserService;

public class UserServiceImpl implements UserService {

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

	@Override
	public void findAllMsg(User user, int id) {
		UserDao dao = new UserDaoImpl();
		dao.findAllMsg(user, id);
	}

	@Override
	public User getLastUser() throws SQLException {
		UserDao dao = new UserDaoImpl();
		return dao.getLastUser();
	}

	@Override
	public List<Task> getTask(String taskType) {
		UserDao dao = new UserDaoImpl();
		return dao.getTask(taskType);
	}

}
