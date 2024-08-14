package com.javaweb.customexception;

//Tạo exception
public class FieldRequiredException extends RuntimeException{
	public FieldRequiredException(String s) {
		super(s);
	}
}
