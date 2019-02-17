package com.fhelp.util;

public class JavaBaseUtil {

	/**
	 * 检测用户名是否合法 用户名格式：只能是以字母开头(不区分大小写)、5-10位、不包含特殊符号（、_.%$#@!空格)
	 * 
	 * @param username
	 * @return
	 */
	public static boolean checkUsername(String username) {
		if (username.matches("^[a-zA-Z]\\w{4,9}$") && !username.contains(" ")) {
			return true;
		}
		return false;
	}

	/**
	 * 检测密码是否合法 密码格式：长度为6-16位 但不能是9位以下纯数字且可以包含
	 * 字母、数字、特殊符号(~!@#$%^&*()_+[]{}|\;:'",./<>?)
	 * 
	 * 强：包含字母、数字、特殊符号三种 中：只包含字母、数字、特殊符号中任意两种 弱：只包含任意一种
	 * 
	 * @param password
	 * @return
	 */
	public static boolean checkPassword(String password) {
		char arr[] = password.toCharArray();
		boolean digit, word, symbol, l;
		boolean flag = true;
		// 1.判断是否含有数字
		digit = password.matches("^.*\\d+.*$");
		// 2.判断是否有字母
		word = password.matches("^.*[a-zA-Z]+.*$");
		// 3.判断是否有特殊符号
		symbol = password.matches(".*[~!@#$%^&*()_+|<>,.?/;'\\[\\]{}\"]+.*");
		int len = arr.length;
		// 4.判断长度是否为6-16
		l = (len >= 6 && len <= 16) ? true : false;
		if (l) {
			// 符合长度
			if (digit && !word && !symbol) {
				if (len < 9) {
					// 不能9位以下纯数字
					flag = false;
				}
			}
		} else {
			// 长度不符合
			flag = false;
		}
		return flag;
	}
}
