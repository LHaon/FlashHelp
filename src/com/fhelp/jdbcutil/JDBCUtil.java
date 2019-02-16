package com.fhelp.jdbcutil;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * JDBC工具类
 *
 */
public class JDBCUtil {

	// 数据库连接池
	static ComboPooledDataSource dataSource = null;
	static {
		dataSource = new ComboPooledDataSource();
	}

	/**
	 * 获取数据库连接池对象
	 * 
	 * @return
	 */
	public static DataSource getDataSource() {
		return dataSource;
	}

	/**
	 * 获取连接对象
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
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
