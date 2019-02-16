package com.fhelp.base;

/**
 * 用户对象
 *
 */
public class User {
	private int userId;
	private String username = null;
	private String password = null;
	private int credit;
	private double balance;
	private double integral;

	public User(int userId, String username, String password, int credit, double balance, double integral) {
		this.setUserId(userId);
		this.username = username;
		this.setPassword(password);
		this.credit = credit;
		this.setBalance(balance);
		this.setIntegral(integral);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getIntegral() {
		return integral;
	}

	public void setIntegral(double integral) {
		this.integral = integral;
	}

}
