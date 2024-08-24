package com.javaweb.utils;

import java.sql.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import com.javaweb.repository.entity.RentAreaEntity;

@PropertySource("classpath:application-uat.properties")
public class ConnectDbUtil {
	@Value("${spring.datasource.url}")
	static String DB_URL;
	
	@Value("${spring.datasource.username}")
	static String USER;
	
	@Value("${spring.datasource.password}")
	static String PASS;

	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return conn;
	}
}
