package com.fhelp.jdbcutil;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * JDBC工具类
 *
 */
public class JDBCUtil {

	static String driverClass = null;
	static String url = null;
	static String name = null;
	static String password = null;

	static {
		// 创建属性配置对象
		Properties properties = new Properties();
		// 使用类加载器，去读取src底下的资源文件
		InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
		try {
			// 导入输入流
			properties.load(is);
		} catch (IOException e) {
			System.out.println("获取输入流失败");
		}

		// 读取属性
		driverClass = properties.getProperty("driverClass");
		url = properties.getProperty("url");
		name = properties.getProperty("name");
		password = properties.getProperty("password");

	}

	/**
	 * 获取连接对象
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		Connection con = null;
		try {
			try {
				Class.forName(driverClass);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con = DriverManager.getConnection(url, name, password);
		} catch (SQLException e) {
			System.out.println("连接失败");
		}
		return con;
	}

	/**
	 * 释放资源
	 * 
	 * @param con
	 * @param st
	 * @param rs
	 */
	public static void release(Connection con, Statement st, ResultSet rs) {
		closeRs(rs);
		closeSt(st);
		closeCon(con);
	}

	private static void closeRs(ResultSet rs) {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("关闭结果集失败");
			} finally {
				rs = null;
			}
		System.out.println("关闭结果集成功");
	}

	private static void closeSt(Statement st) {
		if (st != null)
			try {
				st.close();
			} catch (SQLException e) {
				System.out.println("关闭Statement失败");
			} finally {
				st = null;
			}
		System.out.println("关闭Statement对象成功");
	}

	private static void closeCon(Connection con) {
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("关闭连接失败");
			} finally {
				con = null;
			}
		System.out.println("数据库驱动关闭成功!");
	}

}
