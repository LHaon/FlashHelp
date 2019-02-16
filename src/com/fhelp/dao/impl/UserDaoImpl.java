﻿package com.fhelp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbutils.QueryRunner;

import com.fhelp.base.User;
import com.fhelp.dao.UserDao;
import com.fhelp.jdbcutil.JDBCUtil;

/**
 * 用户操作数据库的实现类
 *
 */
public class UserDaoImpl implements UserDao {

	Connection con = JDBCUtil.getConnection();
	Statement st = null;
	ResultSet rs = null;
	String sql = null;
	PreparedStatement ps = null;

	@Override
	public boolean login(String username, String password) {
		boolean flag = false;
		try {
			st = con.createStatement();
		} catch (SQLException e) {
			System.out.println("获取数据库操作对象失败");
		}
		sql = "select * from user_tb";
		try {
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("获取结果集失败");
		}
		try {
			while (rs.next()) {
				String uName = rs.getString("username");
				String uPassword = rs.getString("password");
				if (username.equals(uName) && password.equals(uPassword)) {
					System.out.println("登录成功");
					flag = true;
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public User findUser(String name) {
		User user = new User();
		sql = "select * from user_tb where username=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			if (rs.next()) {
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
			num = runner.update(sql, user.getUserId(), user.getUsername(), user.getPassword(), user.getAutograph(),
					user.getRegistertime());// 执行插入语句
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num >= 1 ? true : false;
	}

	@Override
	public void findAllMsg(User user, int id) {
		// 查找用户的所有信息
	}

}
