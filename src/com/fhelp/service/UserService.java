package com.fhelp.service;

import java.sql.SQLException;
import java.util.List;

import com.fhelp.base.Task;
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
	
	/**
	 * 查询最后一条记录
	 * @return
	 * @throws SQLException 
	 */
	User getLastUser() throws SQLException;
	
	/**
	 * 按类型查看任务列表
	 * @param taskType
	 * @return
	 */
	List<Task> getTask(String taskType);
}
