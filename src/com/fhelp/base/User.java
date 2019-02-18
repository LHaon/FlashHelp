package com.fhelp.base;

import java.util.Date;

/**
 * 用户对象
 *
 */
public class User {
	private int userId;// 用户id
	private String username;// 用户名
	private String phone;// 电话
	private String email;// 邮箱
	private String password;// 用户密码
	private String autograph;// 签名
	private Date registertime;// 注册时间
	private int isRealName;// 实名
	private int credit;// 信誉度
	private String follow;// 关注的人
	private String fans;// 粉丝
	private double balance;// 余额
	private double integral;// 积分
	private String sendList;// 发布列表
	private String accept;// 接受列表
	private String collection;// 收藏列表
	private String finish;// 完成列表
	private String offtenTask;// 常接任务列表
	private String nikename;// 昵称
	private String photo;// 头像
	private int sex;// 性别
	private String location;// 位置

	public User() {

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getSendList() {
		return sendList;
	}

	public void setSendList(String sendList) {
		this.sendList = sendList;
	}

	public String getAccept() {
		return accept;
	}

	public void setAccept(String accept) {
		this.accept = accept;
	}

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
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

	public String getNikename() {
		return nikename;
	}

	public void setNikename(String nikename) {
		this.nikename = nikename;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "userId:" + userId + ",photo:" + photo;
	}
}
