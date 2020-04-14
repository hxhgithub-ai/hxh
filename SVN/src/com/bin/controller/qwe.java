package com.bin.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class qwe {
	private static Map hashmap = new HashMap();
	private static SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static String t(Object time) {
		long currentTime = System.currentTimeMillis() ;
		Object a = time;
		int as = Integer.parseInt((String) a);
		currentTime += as*60*1000;
		String endtime = sim.format(new Date(currentTime));
		return endtime;
	}
	
	

}
