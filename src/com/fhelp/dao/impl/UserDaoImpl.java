package com.fhelp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.fhelp.base.Task;
import com.fhelp.base.User;
import com.fhelp.dao.UserDao;
import com.fhelp.jdbcutil.JDBCUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * 用户操作数据库的实现类
 *
 */
public class UserDaoImpl implements UserDao {

	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	String sql = "";
	PreparedStatement ps = null;

	@Override
	public boolean login(String username, String password) throws SQLException {
		sql = "select password from user_tb where username=?";
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		User user = runner.query(sql, new BeanHandler<User>(User.class), username);
		if (user == null)
			return false;
		return user.getPassword().equals(password);
	}

	@Override
	public User findUser(String name) throws SQLException {
		sql = "select * from user_tb A JOIN selfinfo_tb B ON A.userid=B.userid where A.username=?";
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		return runner.query(sql, new BeanHandler<User>(User.class), name);
	}

	@Override
	public boolean register(User user) {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "insert into user_tb set userid=?,username=?,password=?,autograph=?,registertime=?";
		int num = 0;
		try {
			num = runner.update(sql, user.getUserId(), user.getUsername(), user.getPassword(), user.getAutograph(),
					user.getRegistertime());// 执行插入语句
			// 在个人信息表中同步增加该用户的昵称信息
			runner.update("insert into selfinfo_tb set userid=?,nikename=?", user.getUserId(), user.getNikename());

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num >= 1 ? true : false;
	}

	@Override
	public User getLastUser() throws SQLException {
		String sql = "select * from user_tb order by userid DESC limit 1";
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		return runner.query(sql, new BeanHandler<User>(User.class));
	}

	@Override
	public List<Task> getTask(String taskType) {
		List<Task> list = null;
		String sql = "select * from task_tb where ";
		// all,onlymoney,onlyint,onlyfree,neartask,newtask,hightask
		switch (taskType) {
		case "all":
			sql += " 1=1";
			break;
		case "onlymoney":
			// 只看现金
			sql += " remunertype = 1 ORDER BY remuneration";
			break;
		case "onlyint":
			// 只看积分
			sql += " remunertype = 2 ORDER BY remuneration";
			break;
		case "onlyfree":
			// 只看免费
			sql += " remuneration = 0";
			break;
		case "neartask":
			// 距离最近
			sql += " 1=1 ORDER BY loc";
			break;
		case "newtask":
			// 最新发布
			sql += " 1=1 ORDER BY starttime DESC";
			break;
		case "hightask":
			// 悬赏最高
			sql += " 1=1 ORDER BY remuneration DESC";
			break;
		}
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		try {
			list = runner.query(sql, new BeanListHandler<Task>(Task.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 发布任务未写完
	@Override
	public boolean sendTask(Task task) {
		sql = "insert into task_tb values(?,?,?,?,?)";
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		int num = 0;
		try {
			num = runner.update(sql, null, task.getUserId());
		} catch (SQLException e) {
			System.out.println("发布任务失败");
		}
		return num >= 1 ? true : false;
	}

	@Override
	public User getUserByNikeName(String nikeName) {
		sql = "select * from user_tb A JOIN selfinfo_tb B ON A.userid=B.userid where B.nikename=?";
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		User user = null;
		try {
			user = runner.query(sql, new BeanHandler<User>(User.class), nikeName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User getUserById(int userid) {
		sql = "select * from user_tb A JOIN selfinfo_tb B ON A.userid=B.userid where A.userid=?";
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		User user = null;
		try {
			user = runner.query(sql, new BeanHandler<User>(User.class), userid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}
