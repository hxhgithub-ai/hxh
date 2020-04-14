package com.bin.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class asd {
	private static Map hashmap = new HashMap();
	private static SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
public static void main(String[] args) {
	
	String start = sim.format(new Date());
	hashmap.put("start",start);
	System.out.println(hashmap.toString());
}
}
