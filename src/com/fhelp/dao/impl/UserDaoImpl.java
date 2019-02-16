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

/**
 * 用户操作数据库的实现类
 *
 */
public class UserDaoImpl implements UserDao {

	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	String sql = null;
	PreparedStatement ps = null;

	@Override
	public boolean login(String username, String password) {
		boolean flag = false;
		try {
			con = JDBCUtil.getConnection();
			st = con.createStatement();
			sql = "select * from user_tb";
			rs = st.executeQuery(sql);
			while (rs.next()) {
				String uName = rs.getString("username");
				String uPassword = rs.getString("password");
				if (username.equals(uName) && password.equals(uPassword)) {
					System.out.println("登录成功");
					flag = true;
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("数据库操作失败");
		}
		return flag;
	}

	@Override
	public User findUser(String name) {
		User user = null;
		sql = "select * from user_tb where username=?";
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setUserId(rs.getInt("userid"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setAutograph(rs.getString("autograph"));
				user.setRegistertime(rs.getTime("registertime"));
				user.setIsRealName(rs.getInt("isrealname"));
				user.setCredit(rs.getInt("credit"));
				user.setFollow(rs.getString("follow"));
				user.setFans(rs.getString("fans"));
				user.setBalance(rs.getDouble("balance"));
				user.setIntegral(rs.getDouble("integral"));
				user.setRelease(rs.getString("release"));
				user.setAccept(rs.getString("accept"));
				user.setColection(rs.getString("collection"));
				user.setFinish(rs.getString("finish"));
				user.setOfftenTask(rs.getString("offtentask"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean register(User user) {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "insert into user_tb set userid=?,username=?,password=?,autograph=?,registertime=?";
		int num = 0;
		try {
			num = runner.update(sql, null, user.getUsername(), user.getPassword(), user.getAutograph(),
					user.getRegistertime());// 执行插入语句
			// 在个人信息表中同步增加该用户的昵称信息
			runner.update("insert into selfinfo_tb set userid=?,nikename=?", user.getUserId(), user.getNikename());

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num >= 1 ? true : false;
	}

	@Override
	public void findAllMsg(User user, int id) {
		// TODO Auto-generated method stub

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
		String sql = "select * from task_tb where 1=1 and";
		// all,onlymoney,onlyint,onlyfree,neartask,newtask,hightask
		switch (taskType) {
		case "onlymoney":
			// 只看现金
			sql = "remunertype = 1 ORDER BY remuneration";
			break;
		case "onlyint":
			// 只看积分
			sql = "remunertype = 2 ORDER BY remuneration";
			break;
		case "onlyfree":
			// 只看免费
			sql = "remuneration = 0";
			break;
		case "neartask":
			// 距离最近
			sql = "1=1 ORDER BY loc";
			break;
		case "newtask":
			// 最新发布
			sql = "1=1 ORDER BY starttime DESC";
			break;
		case "hightask":
			// 悬赏最高
			sql = "1=1 ORDER BY remuneration DESC";
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

}
