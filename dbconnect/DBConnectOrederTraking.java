package com.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectOrederTraking {
	
	public static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
	public static final String JDBC_URL="jdbc:mysql://localhost:3306/order_tracking_system";
	public static final String USERNAME="root";
	public static final String PASSWORD="root";
	
	static Connection conn=null;
	
	public static Connection getconnetion()
	{
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Driver Loaded.");
			
			conn=DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			System.out.println("Connection established");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		getconnetion();
	}

}
