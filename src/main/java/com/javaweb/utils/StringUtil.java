package com.javaweb.utils;

public class StringUtil {
	public static boolean checkEmptyString(String s) {
		if (s != null && !s.equals(""))
			return false;
		return true;
	}
}
