package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {
	static Connection con = null;
	public static Connection requestConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project1?user=root&password=Subha@2005");
			System.out.println("Connection established");
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
