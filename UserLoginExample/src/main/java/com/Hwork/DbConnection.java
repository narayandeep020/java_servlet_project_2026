package com.Hwork;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/test_db";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "Root@123";

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }
}
