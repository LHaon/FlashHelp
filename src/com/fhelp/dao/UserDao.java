package com.fhelp.dao;

import com.fhelp.base.User;

/**
 * 用户操作数据库的方法
 *
 */
public interface UserDao {
	/**
	 * 登录
	 */
	boolean login(String username, String password);

	/**
	 * 查找用户信息
	 */
	User findUser(String neme);
}
