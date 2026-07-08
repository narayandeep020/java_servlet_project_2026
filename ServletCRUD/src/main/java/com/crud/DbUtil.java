package com.crud;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DbUtil {
	
//	private static final String DB_URL = "jdbc:mysql://localhost:3306/test_db";
//    private static final String DB_USER = "*****";
//    private static final String DB_PASS = "******";
//
//    public static Connection getConnection() throws Exception {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
//    }
	
	private static Properties properties = new Properties();
	private static final String PROPERTIES_FILE = "E:\\application_secret\\system.properties";
	
	static {
		loadProperties();
	}

	private static void loadProperties() {
		// TODO Auto-generated method stub
		try (FileInputStream fis = new FileInputStream(PROPERTIES_FILE)){
			properties.load(fis);
			 System.out.println("Properties file loaded successfully from: " + PROPERTIES_FILE);
			 
		}catch(Exception e) {
			System.err.println("Error loading properties file: " + e.getMessage());
		}
		
	}
	public static Connection getConnection() throws Exception {
		Class.forName(properties.getProperty("db.driver"));
		
		String url = properties.getProperty("db.url");
		String username = properties.getProperty("db.user");
		String password = properties.getProperty("db.pass");
		
		Connection connection = DriverManager.getConnection(url, username,password);
		System.out.println("Connection Established successfully to: "+url);
		return connection;
		
	}
	public static void closeConnection(Connection con) {
		if(con != null) {
			try {
				con.close();
				System.out.println("Connection Closed...");
			}catch(Exception e) {
				System.out.println("Error closing connection..."+e.getMessage());
			}
		}
	}

}
