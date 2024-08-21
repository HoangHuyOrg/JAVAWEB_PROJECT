package com.javaweb.utils;

public class NumberUtil {
	public static boolean isNumber(String s) {
		try {
			Long n = Long.parseLong(s);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
