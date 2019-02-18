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
	public boolean login(String username, String password) throws SQLException {
		UserDao dao = new UserDaoImpl();
		return dao.login(username, password);
	}

	@Override
	public User findUser(String neme) throws SQLException {
		UserDao dao = new UserDaoImpl();
		return dao.findUser(neme);
	}

	@Override
	public boolean register(User user) {
		UserDao dao = new UserDaoImpl();
		return dao.register(user);
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

	@Override
	public boolean sendTask(Task task) {
		UserDao dao = new UserDaoImpl();
		return dao.sendTask(task);
	}

	@Override
	public User getUserByNikeName(String nikeName) {
		UserDao dao = new UserDaoImpl();
		return dao.getUserByNikeName(nikeName);
	}

	@Override
	public User getUserById(int userid) {
		UserDao dao = new UserDaoImpl();
		return dao.getUserById(userid);
	}

}
