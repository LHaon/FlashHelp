package com.fhelp.base;

/**
 * 封装密码的相关信息
 * @author Fan
 *
 */
public class PswType {
	private boolean isCorrect;// 密码是否合法
	private int level;// 密码的强度

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
