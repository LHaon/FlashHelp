package com.fhelp.base;

import java.util.Date;

/**
 * 用户对象
 *
 */
public class User {
	private int userId;//用户id
	private String username;//用户名
	private String password;//用户密码
	private String autograph;//签名
	private Date registertime;//注册时间
	private int isRealName;//实名
	private int credit;//信誉度
	private String follow;//关注的人
	private String fans;//粉丝
	private double balance;//余额
	private double integral;//积分
	private String release;//发布列表
	private String accept;//接受列表
	private String colection;//收藏列表
	private String finish;//完成列表
	private String offtenTask;//常接任务列表
	
	public User() {
		
	}
	
	public User(int userId, String username, String password, int credit, double balance, double integral) {
		this.setUserId(userId);
		this.username = username;
		this.setPassword(password);
		this.credit = credit;
		this.setBalance(balance);
		this.setIntegral(integral);
	}
	
	
	public User(String username, String password, String autograph, Date registertime) {
		super();
		this.username = username;
		this.password = password;
		this.autograph = autograph;
		this.registertime = registertime;
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

	public String getAutograph() {
		return autograph;
	}

	public void setAutograph(String autograph) {
		this.autograph = autograph;
	}

	public Date getRegistertime() {
		return registertime;
	}

	public void setRegistertime(Date registertime) {
		this.registertime = registertime;
	}

	public int getIsRealName() {
		return isRealName;
	}

	public void setIsRealName(int isRealName) {
		this.isRealName = isRealName;
	}

	public String getFollow() {
		return follow;
	}

	public void setFollow(String follow) {
		this.follow = follow;
	}

	public String getFans() {
		return fans;
	}

	public void setFans(String fans) {
		this.fans = fans;
	}

	public String getRelease() {
		return release;
	}

	public void setRelease(String release) {
		this.release = release;
	}

	public String getAccept() {
		return accept;
	}

	public void setAccept(String accept) {
		this.accept = accept;
	}

	public String getColection() {
		return colection;
	}

	public void setColection(String colection) {
		this.colection = colection;
	}

	public String getFinish() {
		return finish;
	}

	public void setFinish(String finish) {
		this.finish = finish;
	}

	public String getOfftenTask() {
		return offtenTask;
	}

	public void setOfftenTask(String offtenTask) {
		this.offtenTask = offtenTask;
	}
	
}
