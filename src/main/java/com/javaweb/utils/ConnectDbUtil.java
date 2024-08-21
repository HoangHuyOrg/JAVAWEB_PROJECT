package com.javaweb.utils;

import java.sql.*;

import com.javaweb.repository.entity.RentAreaEntity;

public class ConnectDbUtil {
	static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=estatebasic;encrypt=true;trustServerCertificate=true";
	static final String USER = "sa";
	static final String PASS = "123";

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
