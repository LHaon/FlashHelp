package com.fhelp.service;

import com.fhelp.base.User;

/**
 * 逻辑层操作
 * 
 * @author Fan
 *
 */
public interface UserService {
	/**
	 * 登录
	 */
	boolean login(String username, String password);

	/**
	 * 查找用户信息
	 */
	User findUser(String neme);

	/**
	 * 用户注册
	 * 
	 * @param user
	 * @return
	 */
	boolean register(User user);

	/**
	 * 查找用户所有信息
	 * 
	 * @param user
	 * @param id
	 */
	void findAllMsg(User user, int id);
}
