package com.fhelp.base;

import java.util.Scanner;

public class ABC {
//测试	
	
	public static void main(String[] args) {
//		String reg = "^[a-zA-Z]\\w{3,15}$";
//		System.out.println("aaaaaaaaaaaa".matches(reg));
		String reg = ".*[~!@#$%^&*()_+|<>,.?/:;'\\[\\]{}\"]+.*";
		String str = new Scanner(System.in).nextLine();
		System.out.println(str.matches(reg));
	}
}
