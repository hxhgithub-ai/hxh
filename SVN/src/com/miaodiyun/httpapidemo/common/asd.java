package com.miaodiyun.httpapidemo.common;

public class asd {
//生成随机六位数作为验证码
	public static  String as() {
		double i = ((Math.random()*9+1)*100000);
		int k  = (int)i;
		String j = String.valueOf(k);
		System.out.println("验证码"+j);
		return j;
	}
}
