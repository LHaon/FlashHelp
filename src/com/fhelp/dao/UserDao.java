package com.fhelp.dao;

import java.sql.SQLException;
import java.util.List;

import com.fhelp.base.Task;
import com.fhelp.base.User;

/**
 * 用户操作数据库的方法
 *
 */
public interface UserDao {
	/**
	 * 登录
	 */
	boolean login(String username, String password) throws SQLException;

	/**
	 * 查找用户信息
	 */
	User findUser(String neme) throws SQLException;
	
	/**
	 * 通过昵称来查找用户
	 * @param nikeName
	 * @return
	 */
	User getUserByNikeName(String nikeName);
	
	/**
	 * 通过用户id来查找用户
	 * @param id
	 * @return
	 */
	User getUserById(int userid);

	/**
	 * 用户注册
	 * 
	 * @param user
	 * @return
	 */
	boolean register(User user);

	/**
	 * 查询最后一条记录
	 * 
	 * @return
	 * @throws SQLException
	 */
	User getLastUser() throws SQLException;

	/**
	 * 按类型查看任务列表
	 * 
	 * @param taskType
	 * @return
	 */
	List<Task> getTask(String taskType);

	/**
	 * 发布任务
	 * 
	 * @param task
	 */
	boolean sendTask(Task task);

}
